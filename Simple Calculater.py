import sys
operators = ["+","-","*","/"]
def calculater (operator,num1,num2) :
    if operator == "+" :
        result = num1 + num2
    elif operator == "-" :
        result = num1 - num1
    elif operator == "*" :
        result = num1 * num2
    elif operator == "/" :
        if num2 == 0 :
            return "Error"
        else :
            result = num1 / num2
    return result

operator = input("Enter Operator (+,-,*,/) : ")
if operator not in operators :
       print("Error")
       sys.exit(0)
num1 = float(input("Enter Number One : "))
num2 = float(input("Enter Number Two : "))
calculater(operator,num1,num2)
result = calculater(operator,num1,num2)
print("Result : ", result)


