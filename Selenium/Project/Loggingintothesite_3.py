from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm");

    ###Logging into the site
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]")
    password = driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()
    actualUrl="http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/dashboard";
    expectedUrl= driver.current_url
#Verify that the homepage has opened.
    print ("expectedUrl is:"+ expectedUrl )
    if actualUrl==expectedUrl:
        print("Home page displayed")
    else:
        print("Home page not displayed")

