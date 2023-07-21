from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.ui import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]")
    password = driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]")
    username.send_keys("orange")
    password.send_keys("orangepassword123")

    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()

    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click()

    #Find the “My Info” menu item and click it.

    driver.find_element(By.XPATH,("//*[@id=\"menu_pim_viewMyDetails\"]")).click()
    #find the Qualification option on the left side menu and click it.
    driver.find_element(By.XPATH,("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]/a")).click()
    #Click on ADD button
    driver.find_element(By.XPATH,("//*[@id=\"addWorkExperience\"]")).click()
    #Add Work Experience and click Save.
    Company  = driver.find_element(By.XPATH,("//*[@id=\"experience_employer\"]"))
    JobTitle = driver.find_element(By.XPATH,("//*[@id=\"experience_jobtitle\"]"))
    Company.send_keys("XYZ")
    JobTitle.send_keys("SSE")
    driver.find_element(By.XPATH,("//*[@id=\"btnWorkExpSave\"]")).click()
