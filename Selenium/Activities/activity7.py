from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/drag-drop")
    print("Page title is: ", driver.title)
    actions = ActionChains(driver)
    ball = driver.find_element(By.ID, "draggable")
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")
    actions.drag_and_drop(ball, dropzone1).perform()
    if(dropzone1.text.find("Dropped!")):
        actions.drag_and_drop(ball, dropzone2).perform()
    if(dropzone2.text.find("Dropped!")):
        print("Dropzone 2 was activated!")