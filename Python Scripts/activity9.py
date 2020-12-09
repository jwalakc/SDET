list1 = [1,2,3,5]
list2 = [4,5,6]
print("First list: ", list1)
print("Second list: ", list2)
combinedList = list1 + list2
print("Combined List: ", combinedList)
sortedList = []
for i in list1:
    if int(i) % 2 != 0:
        sortedList.append(i)
for  i in list2:
    if int(i) % 2 == 0:
        sortedList.append(i)
print("Sorted list: ", sortedList)