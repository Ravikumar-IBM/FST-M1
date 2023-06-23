numbers = list(input("Enter a sequence of comma separated values: ").split(","))
Num = 0

for number in numbers:
    Num += int(number)

print(Num)
