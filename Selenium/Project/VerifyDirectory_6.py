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
    #Verify that the “Directory” menu item is visible and clickable.
    #check if element visible
    Directory=driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[9]/a/b"))
    if Directory.is_displayed():
        print("Directory is visbale")
    else:
        print("Directory not is visbale")
    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[9]/a/b")).click()
