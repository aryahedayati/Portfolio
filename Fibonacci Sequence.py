num = int(input("Enter a Number : "))
def fibonacci_sequence (n) :
    if n == 1 or n == 0 :
        return n
    return fibonacci_sequence(n-1) + fibonacci_sequence(n-2)
for i in range(num) :
    print(fibonacci_sequence(i),end=" ")
