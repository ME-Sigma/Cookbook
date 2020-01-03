import random

# Game set up
print("Welcome to the guessing game!")
number_of_guesses = 3                   # User has three guesses before loosing the game
user_won = False

# Computer guesses a random number between 1 and 10
correct_answer = random.randint(1, 10)

while number_of_guesses > 0:
    # User guesses the number
    user_guess = input("Guess the number: ")
    user_guess = int(user_guess)

    # Computer tells user whether guess was too high or too low
    if user_guess == correct_answer:
        print("You are correct")
        user_won = True
        break
    elif user_guess > correct_answer:
        print("Sorry, you guessed too high!")
    elif user_guess < correct_answer:
        print("Sorry, you guessed too low!")

    number_of_guesses -= 1

print()
if user_won == True:
    print("You win!")
else:
    print("You loose!")
    print("The number was: " + str(correct_answer))

input()