# Import pandas
import pandas

# Create a Dictionary that will hold our data
data = {
    "Usernames": ["admin", "ravi", "kumar"],
    "Passwords": ["password", "admin123", "test123"]
}


dataframe = pandas.DataFrame(data)


print(dataframe)


dataframe.to_csv("ravi.csv", index=False)