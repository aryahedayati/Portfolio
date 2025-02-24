text = input("Enter the Word : ")
n = int(input("Enter the Amount of Sequence : "))

def stringcopy (text,n) :
    tlen = 2
    if tlen > n :
        tlen = len(text)
    result = ""
    for i in range(n) :
        substring = text[:tlen]
        result = substring + result
    return result
result = stringcopy(text,n)
print(result)
