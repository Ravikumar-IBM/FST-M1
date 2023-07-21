from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())
#Verify the website title
with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm");
    print("Page title is: ", driver.title)

