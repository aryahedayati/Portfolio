#include <iostream>
#include <fstream>
#include <string>
#include <unistd.h> // For usleep()

// Function to play a tone on the EV3 speaker
void playTone(int frequency, int durationMs) {
    std::ofstream sound("/sys/devices/platform/snd-legoev3/dev");
    if (sound.is_open()) {
        sound << "tone " << frequency << " " << durationMs << std::endl;
        sound.close();
    } else {
        std::cerr << "Error: Unable to play tone." << std::endl;
    }
}

// Main function to read notes and play them
int main() {
    const std::string notesFilePath = "/home/robot/notes.txt"; // Path to the notes file
    std::ifstream inputFile(notesFilePath);

    if (!inputFile.is_open()) {
        std::cerr << "Error: Could not open notes file: " << notesFilePath << std::endl;
        return 1;
    }

    int frequency, duration;
    while (inputFile >> frequency >> duration) {
        if (frequency > 0 && duration > 0) {
            std::cout << "Playing: Frequency = " << frequency
                      << " Hz, Duration = " << duration << " ms" << std::endl;
            playTone(frequency, duration);
            usleep(duration * 1000); // Wait for the duration of the note
        }
    }

    inputFile.close();
    std::cout << "Finished playing the song!" << std::endl;
    return 0;
}