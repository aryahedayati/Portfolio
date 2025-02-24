n = int(input("Enter the Size of Your List : "))
list_0 = []
for i in range(n) :
     list_1 = input()
     list_0.append(list_1)
def highest_list_0 (list_0,max) :
    max = list_0[0]
    for a in list_0 :
        if a > max :
            max = a
    return max
def lowest_list_0 (list_0,min) :
    min = list_0[0]
    for a in list_0 :
        if a < min :
            min = a
    return min

highest_list_0(list_0,max)
lowest_list_0(list_0,min)
print("The Highest Number Is :",highest_list_0(list_0,max))
print("The Lowest Number Is :", lowest_list_0(list_0,min))
