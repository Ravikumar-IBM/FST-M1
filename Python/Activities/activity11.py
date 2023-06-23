fruit_shop = {
    "bannana": 80,
    "orange": 75,
    "apple": 90,
    "grapes": 95
}
key_to_check = input("What are you looking for? ").lower()

if(key_to_check in fruit_shop):
    print("Yes, this is available")
else:
    print("No, this is not available")