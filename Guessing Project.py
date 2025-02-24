import random

guess = random.randint(0,100)
answer = input(f'is the ansewer {guess} correct? smaller? bigger ?')
bottom_limit = 0
top_limit = 100
while answer != 'correct' :
    if answer == 'b' :
        guess= random.randint(bottom_limit,guess)
        answer = input(f'is the ansewer {guess} correct? smaller? bigger ?')

    elif answer == 's' :
        guess = random.randint(guess,top_limit)
        answer = input(f'is the ansewer {guess} correct? smaller? bigger ?')


