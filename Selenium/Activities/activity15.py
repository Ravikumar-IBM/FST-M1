
from selenium.webdriver.common.by import By
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
service = FirefoxService(GeckoDriverManager().install())
from selenium.webdriver.support import expected_conditions as EC


with webdriver.Firefox(service=service) as driver:
    wait = WebDriverWait(driver, 10)
    driver.get("https://www.training-support.net/selenium/dynamic-attributes")
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//input[starts-with(@class, 'username-')]")
    password = driver.find_element(By.XPATH, "//input[starts-with(@class, 'password-')]")
    username.send_keys("admin")
    password.send_keys("password")
    driver.find_element(By.XPATH, "//button[@type='submit']").click()
    wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation")))
    message = driver.find_element(By.ID, "action-confirmation").text
    print("Login message: ", message)