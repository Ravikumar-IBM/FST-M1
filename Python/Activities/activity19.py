import pandas as pd

df_marks = pd.DataFrame({
    'FirstName':["Satvik", "Avinash", "Lahri"],
    'LastName':["Shah", "Kati", "Rath"],
    'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber':["4537829158", "4892184058", "4528727830"]
})
writer = pd.ExcelWriter('data.xlsx')

df_marks.to_excel(writer)

writer._save()
print('DataFrame is written successfully to Excel File.')