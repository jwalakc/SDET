def sum(numbers):  
    sum = 0
    for number in numbers:
        sum += int(number)
    return sum

List = input("Enter numbers separated by coma:").split(",")
print(List)
print("The sum of all elements in the list:", List, ": ", sum(List))