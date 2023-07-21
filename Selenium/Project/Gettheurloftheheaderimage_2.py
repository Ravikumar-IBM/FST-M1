from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm");
    # Get the image URL
    url = driver.find_element(By.XPATH, "/html/body/div[1]/div/div[2]/div[1]/img")
    print("Src attribute is: ", url.get_attribute("src"))