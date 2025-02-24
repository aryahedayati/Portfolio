n = input("Enter the length of the List : ")
n = int(n)
list_0 = []

for i in range(0,n) :
    list_1 = int(input("enter a Value : "))
    list_0.append(list_1)

def count_4s_in_list_1 (list_0) :
    count = 0
    for num in list_0 :
        if num == 4 :
          count = count + 1
    return count
print(count_4s_in_list_1(list_0))