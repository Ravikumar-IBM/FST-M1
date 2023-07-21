from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm");
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]")
    password = driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]")
    username.send_keys("orange")
    password.send_keys("orangepassword123")

    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()

    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click()
    #Click the Add button to add a new Employee.

    driver.find_element(By.NAME,("btnAdd")).click()
    #Fill in the required fields and click Save.
    FirstName = driver.find_element(By.XPATH,("//*[@id=\"firstName\"]"))
    FirstName.send_keys("Ravi")
    LastName = driver.find_element(By.XPATH,("//*[@id=\"lastName\"]"))
    LastName.send_keys("Kumar")
    driver.find_element(By.XPATH,("//*[@id=\"btnSave\"]")).click()

    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click()
    EmployeeName = driver.find_element(By.XPATH,("//*[@id=\"empsearch_employee_name_empName\"]"))
    EmployeeName.send_keys("Ravi Kumar ")
    driver.find_element(By.XPATH,("//*[@id=\"searchBtn\"]")).click()
    btnSearch = driver.find_element(By.XPATH,("//input[@id='searchBtn']"))
    btnSearch.click()
    print("Employee name added successfully")