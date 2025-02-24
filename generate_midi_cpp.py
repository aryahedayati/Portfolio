from mido import MidiFile

# Replace 'mario.mid' with your MIDI file path
midi = MidiFile('mario.mid')

events = []

# Convert MIDI messages to a simplified format
current_time = 0
for track in midi.tracks:
    for msg in track:
        current_time += msg.time
        if msg.type in ['note_on', 'note_off']:
            events.append({
                'time_ms': int((current_time / midi.ticks_per_beat) * 1000),  # Convert to milliseconds
                'type': msg.type,
                'note': msg.note,
                'velocity': msg.velocity
            })

# Prepare the C++ code using these events
cpp_code_lines = []
cpp_code_lines.append('#include <iostream>')
cpp_code_lines.append('#include <thread>')
cpp_code_lines.append('#include <chrono>')
cpp_code_lines.append('')
cpp_code_lines.append('struct MidiEvent {')
cpp_code_lines.append('    int time_ms;')
cpp_code_lines.append('    std::string type;')
cpp_code_lines.append('    int note;')
cpp_code_lines.append('    int velocity;')
cpp_code_lines.append('};')
cpp_code_lines.append('')
cpp_code_lines.append('void send_midi_command(const std::string& type, int note, int velocity) {')
cpp_code_lines.append('    std::cout << type << ": Note " << note << ", Velocity " << velocity << "\\n";')
cpp_code_lines.append('}')
cpp_code_lines.append('')
cpp_code_lines.append('int main() {')
cpp_code_lines.append('    std::vector<MidiEvent> events = {')

# Add events to the C++ code
for event in events:
    cpp_code_lines.append(f'        {{ {event["time_ms"]}, "{event["type"]}", {event["note"]}, {event["velocity"]} }},')

cpp_code_lines.append('    };')
cpp_code_lines.append('')
cpp_code_lines.append('    while (true) {')
cpp_code_lines.append('        for (const auto& event : events) {')
cpp_code_lines.append('            std::this_thread::sleep_for(std::chrono::milliseconds(event.time_ms));')
cpp_code_lines.append('            send_midi_command(event.type, event.note, event.velocity);')
cpp_code_lines.append('        }')
cpp_code_lines.append('        std::cout << "Repeating the song...\\n";')
cpp_code_lines.append('    }')
cpp_code_lines.append('')
cpp_code_lines.append('    return 0;')
cpp_code_lines.append('}')

# Save the generated C++ code to a file
with open('mario_midi_player.cpp', 'w') as cpp_file:
    cpp_file.write('\n'.join(cpp_code_lines))

print("C++ code has been generated in 'mario_midi_player.cpp'.")
