# Define function to calculate sum
def sum(n):
    if n <= 0:
        return n
    else:
        return n + sum(n-1)

num = int(input("Enter any number from 0 to 10: "))
print("The sum of", num, "to 0: ", sum(num))

