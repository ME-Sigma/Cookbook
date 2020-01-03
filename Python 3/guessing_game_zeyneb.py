import random

# Game set up
print("Hey Schatzi. Das hier ist ein kleines Spiel für dich!")
print("Wenn du die richtige Zahl errätst erhältst du einen Code.")
number_of_guesses = 3                   # User has three guesses before loosing the game
user_won = False

# Computer guesses a random number between 1 and 10
correct_answer = random.randint(1, 20)

while number_of_guesses > 0:
    # User guesses the number
    user_guess = input("Rate eine Zahl zwischen 1 und 20: ")
    user_guess = int(user_guess)

    # Computer tells user whether guess was too high or too low
    if user_guess == correct_answer:
        print("Yeay!!!")
        user_won = True
        break
    elif user_guess > correct_answer:
        print("Nope, zu hoch...")
    elif user_guess < correct_answer:
        print("Nö, zu niedrig!")

    number_of_guesses -= 1

print()
if user_won == True:
    print("Hey! Richtig geraten!")
    print("Dein Gewinncode lautet: Mein Herz schlägt nur für dich!")
else:
    print("You loose!!!!!!!!")
    print("Die richtige Zahl war: " + str(correct_answer))

input()
