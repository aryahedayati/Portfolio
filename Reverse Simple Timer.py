import time
def timer (seconds) :
    t = 1
    while t <= int(seconds) :
        print(t)
        time.sleep(1)
        t += 1
    print("Time is Up !!")
    return t
seconds = int(input("Enter The Seconds : "))
timer(seconds)

