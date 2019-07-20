import random
import os

# words with 15 letters for the guessing game
five_letter_words = [
    "peace",
    "house",
    "anime",
    "water",
    "world",
    "forty",
    "watch",
    "heart",
    "beard",
    "board",
    "women",
    "amber",
    "dream",
    "laugh",
    "music",
    "death",
    "stone",
    "admin",
    "lemon",
    "river",
    "piano",
]
ten_letter_words = [
    "strawberry",
    "everything",
    "basketball",
    "characters",
    "technology",
    "government",
    "contraband",
    "friendship",
    "punishment",
    "blackboard",
    "understand",
    "perfection",
    "depression",
    "homecoming",
    "watermelon",
    "university",
    "restaurant",
    "discipline",
    "helicopter",
    "skateboard",
    "leadership",
]
fifteen_letter_words = [
    "congratulations",
    "alphabetisation",
    "trustworthiness",
    "procrastinating",
    "miniaturization",
    "excommunication",
    "hospitalisation",
    "rationalization",
    "inaccessibility",
    "disorganization",
    "intensification",
    "instrumentalist",
    "inconsequential",
    "resourcefulness",
    "professionalism",
    "synchronisation",
    "restrengthening",
    "remorselessness",
    "differentiation",
    "remorselessness",
    "criminalisation",
    "destructiveness"
]
witty_quotes = [
    "A true friend is someone who is there for you when he’d rather be anywhere else. — Len Wein",
    "A conservative is a man with two perfectly good legs who, however, has never learned how to walk forward. – Franklin D. Roosevelt",
    "A painting is worth a thousand confused art-gallery visitors. – Ljupka Cvetanova",
    "A person is wise if he listens to millions of advice and doesn’t implement any of it. – Michael Bassey Johnson",
    "A person with a sharp tongue will eventually cut themselves. – J. Robson Koenig",
    "A skunk is better company than a person who prides himself on being 'frank'. – Robert Heinlein",
    "A true friend overlooks your failures and tolerates your success! – Doug Larson",
    "A witty saying proves nothing. – Voltaire",
    "A word of kindness is seldom spoken in vain, while witty sayings are as easily lost as the pearls slipping from a broken string. – George Dennison Prentice",
    "Act as if what you do makes a difference. It does. – William James",
    "Action will destroy your procrastination. – Og Mandino",
    "All progress has resulted from people who took unpopular positions. – Adlai E. Stevenson",
    "An ounce of action is worth a ton of theory. – Ralph Waldo Emerson",
    "And in the end, it’s not the years in your life that count. It’s the life in your years. – Abraham Lincoln",
    "Arguing with a fool proves there are two. – Doris M. Smith",
    "Ask me no questions, and I’ll tell you no fibs. – Oliver Goldsmith",
    "Better a witty fool than a foolish wit. – William Shakespeare",
    "By working faithfully eight hours a day, you may eventually get to be boss and work twelve hours a day. – Robert Frost",
    "Choose a job you love, and you will never have to work a day in your life. – Confucius",
    "Do your own thinking independently. Be the chess player, not the chess piece. – Ralph Charell",
    "Don’t be too timid and squeamish about your actions. All life is an experiment. – Ralph Waldo Emerson"
]

clear = lambda: os.system('cls')

while True:

    # Introduction to the game
    print("Hello. Welcome to the word-guessing-game.")
    print("Your goal is to guess the word chosen by the program.")
    print("You can type a letter you think is in the word.")
    print("You loose, if you guess a letter, that is not in the word.")
    print("Once you have guessed all characters or think you know the word, type your guess instead of a letter.")
    print("Ok. With this introduction done you can now start the game. Good luck!")
    print("You may enter a Game Mode to adjust the games difficulty:")
    #TODO: restrict vocals to 2
    print("0 --> TRAINING. All letters are concealed. 100 guesses. No consequences if guessed wrong.")
    print("1 --> EASY/DEFAULT. 5-letter words. All letters are concealed. 100 guesses. Loose if guessed wrong nine times.")
    print("2 --> NORMAL. 10-letter words. All letters are concealed. 15 guesses. Loose if guessed wrong six times.")
    print("3 --> HARD. 15-letter words. All letters are concealed. 15 guesses. Loose if guessed wrong three times.")
    print("4 --> CUSTOM. Needs to be unlocked by winning a HARD game.")
    game_mode = input("Enter Game Mode: ")
    clear()

    ### Options
    # Init variables
    user_guess = ""
    number_of_guesses = 0
    number_wrong_guesses = 0

    # DEFAULT. 5-letter words. All letters are concealed. 100 guesses. Loose if guessed wrong nine times.
    words_to_guess = five_letter_words
    guess_limit = 100
    wrong_guesses_limit = 9

    # TRAINING. All letters are concealed. 100 guesses. No consequences if guessed wrong.
    if str(game_mode) == "0":
        print("")
        print("1 --> five letters")
        print("2 --> ten letters")
        print("3 --> fifteen letters")
        users_choice_word_length = input("Choose word length: ")

        words_to_guess = five_letter_words              # Default choice
        if str(users_choice_word_length) == "2":
            words_to_guess = ten_letter_words
        if str(users_choice_word_length) == "3":
            words_to_guess = fifteen_letter_words

        guess_limit = 100
        wrong_guesses_limit = 100
        print("Game Mode set to TRAINING. Guess limit set to " + str(guess_limit) + ".")
        print(str(wrong_guesses_limit) + " wrong guesses are possible.")
        input("Practice makes perfect!")

    # EASY. 5-letter words. All letters are concealed. 100 guesses. Loose if guessed wrong nine times.
    if str(game_mode) == "1":
        print("Game Mode set to EASY. Guess limit set to " + str(guess_limit) + ".")
        print(str(wrong_guesses_limit) + " wrong guesses are possible.")
        input("It'll be a walk in the park!")

    # NORMAL. 10-letter words. All letters are concealed. 15 guesses. Loose if guessed wrong six times.
    if str(game_mode) == "2":
        words_to_guess = ten_letter_words
        guess_limit = 15
        wrong_guesses_limit = 6
        print("Game Mode set to NORMAL. Guess limit set to " + str(guess_limit) + ".")
        print(str(wrong_guesses_limit) + " wrong guesses are possible.")
        input("Ready for a challenge?")

    # HARD. 15-letter words. All letters are concealed. 15 guesses. Loose if guessed wrong three times.
    if str(game_mode) == "3":
        words_to_guess = fifteen_letter_words
        guess_limit = 15
        wrong_guesses_limit = 3
        print("Game Mode set to HARD. Guess limit set to " + str(guess_limit) + ".")
        print(str(wrong_guesses_limit) + " wrong guesses are possible.")
        input("That's HARD mode! You won't make it! Better give up now!")

    # CUSTOM. Needs to be unlocked by winning a HARD game.
    if str(game_mode) == "4":
        print("Not implemented yet.")
        #TODO

    # choose a random word from the list and create a concealed word of the same length
    target_word = words_to_guess[random.randint(0, len(words_to_guess)-1)]
    concealed_word = ""
    for i in range(0, len(target_word)):
        concealed_word += "-"

    clear()

    ### Start guessing
    while True:
        if (guess_limit-number_of_guesses) < 1:
            print("Sorry. You have no guesses left. You loose!")
            input()
            break
        print("You have " + str(guess_limit-number_of_guesses) + " guesses left and guessed wrong " + str(number_wrong_guesses) + " times.")
        print(concealed_word)
        user_guess = input("Enter your guess: ")
        if len(user_guess) == 1:            # A letter was guessed
            if user_guess in target_word:
                print("True")
                temp = ""
                for i in range(0, len(target_word)):
                    if target_word[i] == user_guess:
                        temp += user_guess
                    else:
                        temp += concealed_word[i]
                concealed_word = temp
            else:
                number_wrong_guesses += 1
                if number_wrong_guesses >= wrong_guesses_limit:
                    print("You have guessed wrong too often. You Loose!")
                    input()
                    break
            number_of_guesses += 1
        else:                               # The final word was guessed
            if user_guess == target_word:
                print("Congratulations! You have guessed the word correctly!")
                if str(game_mode) == "1":
                    print("But there is still so much to learn!")
                    print("Maybe try a harder difficulty next.")
                if str(game_mode) == "2" or str(game_mode) == "3":
                    print("And what have we learned from that?")
                    print(witty_quotes[random.randint(0, len(witty_quotes)-1)])
                #TODO: implement code to enable custom mode
                print()
                print("Thanks for playing!")
            else:
                print("Sorry. That was not correct. Please try another game!")
            input()
            break
        clear()

    temp = input("Do you want to play another game? [y/n] ")
    if str(temp) != "y":
        break
    clear()
