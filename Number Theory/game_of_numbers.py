'''
Alice and Bob are playing a game with the following rules:

Alice always plays first and they take alternating turns.
During each turn, a player can choose any number (regardless of whether or not it was chosen during a previous turn)
in the inclusive range between  l and r.
The game ends when the running sum of chosen numbers (i.e., sum of all numbers chosen by both players) is ,
and the last player to take their turn wins.
Each player always chooses their number optimally.

This means they will not choose a number that would cause them to lose the game if some better, winning choice exists.
Given the values of , , and  for  games, print the name of the winner of each game on a new line.
'''
query = input()
for _ in xrange(query):
    low, high, total = map(int,raw_input().split())
    sum = low + high
    rem = total%sum
    b = "Bob"
    a = "Alice"
    if(rem==0):
        print b
    elif(rem<=high):
        print a
    else:
        print b