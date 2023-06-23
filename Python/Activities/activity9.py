
set1 = [10, 20, 23, 11, 17]
set2 = [13, 43, 24, 36, 12]
print("First List ", set1)
print("Second List ", set2)

set3 = []
for num in set1:
    if (num % 2 != 0):
        set3.append(num)

for num in set2:
    if (num % 2 == 0):
        set3.append(num)


print("result of se3 is:")
print(set3)