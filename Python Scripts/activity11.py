
fruits = {
    "apple": "$3.99",
    "orange": "$2.99",
    "kiwi": "$5.99"
}
#fruits = dict(apple = "$3.99", orange = "$2.99", kiwi = "$5.99")
print(fruits)
fruit = input("Which fruit do you need? ").lower()
if fruit not in fruits:
    print(fruit, "is not available")
else:
    print(fruit, "is available for", fruits[fruit])    