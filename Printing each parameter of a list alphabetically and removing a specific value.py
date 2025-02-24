n = int(input("Enter the Size of Your List : "))
fruits = []
for i in range(n) :
    fruits_0 = input("Enter a Fruit :  ")
    fruits.append(fruits_0)
fruits = sorted(fruits , key=str.upper)
for x in fruits:
  if x == "banana":
      fruits.remove("banana")
      for n in range(len(fruits)):
         print(fruits[n])

