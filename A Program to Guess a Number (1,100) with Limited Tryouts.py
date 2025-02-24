import random

finished = False
random_number = random.randint(1, 100)
user_input = int(input("Enter Your Guess : "))
index = 1
limit = 10

while not finished and index != limit :

    if user_input - random_number > 0 and abs(user_input-random_number) >= 20 :
           user_input = int(input("Your Guess is Too High ! : "))
           print("Try outs left : " , limit-index-1)
           index += 1
    elif user_input - random_number > 0 and abs(user_input-random_number) < 20 :
           user_input = int(input("Sorry Wrong Guess ! : "))
           print("Try outs left : ", limit-index-1)
           index += 1
    elif user_input - random_number < 0 and abs(user_input - random_number ) >= 20 :
           user_input = int(input("Your Guess is Too Low ! : "))
           print("Try outs left : ", limit-index-1)
           index += 1
    elif user_input - random_number < 0 and abs(user_input-random_number) < 20 :
           user_input = int(input("Sorry Wrong Guess ! : "))
           print("Try outs left : ", limit-index-1)
           index += 1
    elif user_input == random_number :
           print("Right Guess ! ")
           print(random_number)
           break

