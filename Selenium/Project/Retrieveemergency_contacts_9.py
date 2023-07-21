from _ast import Assert

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
    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[2]/a/b")).click();
    #Find the “My Info” menu item and click it.
    driver.find_element(By.XPATH,("//*[@id=\"menu_pim_viewMyDetails\"]")).click();
    #Click on Emergency Contacts  .
    driver.find_element(By.XPATH,("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
    #Table
    table=driver.find_element(By.XPATH,("//*[@id=\"emgcontact_list\"]"));
    cellValue = driver.find_element(By.XPATH,("/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr/th[1]"));

    columns = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
    print("Number of columns: ", len(columns))
    rows = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/thead/tr")
    print("Number of rows: ", len(rows))
    third_row = driver.find_elements(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[5]")
    print("Cell values of third row:")
    for row in third_row:
        print("Cell value: ", row.text)
    second_row_second_cell = driver.find_element(By.XPATH, "/html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[5]")
    print("Cell value at second row and second column: ", second_row_second_cell.text)



