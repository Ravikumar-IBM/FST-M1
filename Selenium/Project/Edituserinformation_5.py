from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.ui import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm");

    #Add a new employee
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]")
    password = driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]")
    username.send_keys("orange")
    password.send_keys("orangepassword123")

    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()

    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click()
    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[6]/a/b")).click()
    #Click on Edit button

    driver.find_element(By.ID,("btnSave")).click()
    #Fill in the required fields and click Save.
    FirstName = driver.find_element(By.XPATH,("//*[@id=\"personal_txtEmpFirstName\"]"))
    FirstName.clear()
    FirstName.send_keys("Ravi")
    LastName = driver.find_element(By.XPATH,("//*[@id=\"personal_txtEmpLastName\"]"))
    LastName.clear()
    LastName.send_keys("Kumar")
    Gender=driver.find_element(By.XPATH,("//*[@id=\"personal_optGender_2\"]"));
    Gender.click()
   #Select Nationality,
    Nationality = Select(driver.find_element(By.XPATH,("//*[@id='oldSelectMenu']")))
    Nationality.selectByValue("Greek")
    #Set DOB
    DOB = driver.find_element(By.XPATH,("//*[@id=\"personal_DOB\"]"))
    DOB.send_keys("1990-10-10")
    #Clcik on save button
    driver.find_element(By.XPATH,("//*[@id=\"btnSave\"]")).click()
