
player1 = input("Player1 chooses: ").lower()
player2 = input("Player2 chooses: ").lower()

if (player1 not in ("rock", "paper", "scissors") and player2 not in ("rock", "paper", "scissors")) == True:
    print ("Invalid input! Both players have not entered rock, paper or scissors, try again.")
elif (player2 not in ("rock", "paper", "scissors")) == True:
    print ("Invalid input! Player2 has not entered rock, paper or scissors, try again.")
elif player1 == player2:
    print("It is a tie!")
elif player1 == "rock":
     if player2 == "scissors":
        print("player1 won")
     else: 
        print("player2 won")
elif player1 == "scissors":
    if player2 == "paper":
        print("player1 won")
    else:
        print("player2 won")
elif player1 == "paper":
    if player2 == "rock":
        print("player1 won")
    else:
        print("player2 won")
else:
    print ("Invalid input! Player1 has not entered rock, paper or scissors, try again.")
