import sys

num = int(input("Enter a Number : "))
finished = False
def get_factorial (num) :
    if num == 0 :
        result = 1
    if num < 0 :
        print("Error , the number is negative")
        sys.exit()
    result = num
    for i in range(num) :
             result = (num-1) * result
             num -= 1
             if num == 1 :
                 break
    return result
result = get_factorial(num)
print(result)



