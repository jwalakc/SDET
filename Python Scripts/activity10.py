list = input("Enter numbers separated by coma: ").split(",")
print("tuple of given numbers: ", tuple(list))
list1 = []
for number in list:
    if int(number) % 5 == 0:
        list1.append(number)
tuple = tuple(list1)
print("tuple of numbers that are divisible by 5: ", tuple)

