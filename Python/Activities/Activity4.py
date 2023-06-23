
user1 = input("What is 1st Player name? ")
user2 = input("What is 2nd Player name? ")

while True:

    user1answer = input(user1 + ", do you want to choose rock, paper or scissors? ").lower()

    user2answer = input(user2 + ", do you want to choose rock, paper or scissors? ").lower()


    if user1answer == user2answer:
        print("It's a tie!")
    elif user1answer == 'rock':
        if user2answer == 'scissors':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif user1answer == 'scissors':
        if user2answer == 'paper':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif user1answer == 'paper':
        if user2answer == 'rock':
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")


    repeat = input("Do you want to play another round? Yes/No: ").lower()


    if(repeat == "yes"):
        pass

    elif(repeat == "no"):
        raise SystemExit
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit