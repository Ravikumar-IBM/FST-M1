from _ast import Assert

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.support.ui import Select
from webdriver_manager.firefox import GeckoDriverManager

service = FirefoxService(GeckoDriverManager().install())


def assertEquals(ExpectedTitle, TableValue, param):
    pass


with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    print("Page title is: ", driver.title)
    username = driver.find_element(By.XPATH, "//*[@id=\"txtUsername\"]")
    password = driver.find_element(By.XPATH, "//*[@id=\"txtPassword\"]")
    username.send_keys("orange")
    password.send_keys("orangepassword123")

    driver.find_element(By.XPATH, "//*[@id=\"btnLogin\"]").click()
    #click on the Apply Leave option.
    driver.find_element(By.XPATH,("/html/body/div[1]/div[2]/ul/li[3]/a/b")).click();
    driver.find_element(By.XPATH,("//*[@id=\"menu_leave_applyLeave\"]")).click();
    #find the Qualification option on the left side menu and click it.
    LeaveType =driver.find_element(By.XPATH,("//*[@id=\"applyleave_txtLeaveType\"]"));
    LeaveType.send_keys("DayOff");
    FromDate = driver.find_element(By.XPATH,("//*[@id=\"applyleave_txtFromDate\"]"));
    FromDate.clear();
    FromDate.send_keys("2023-07-16");
    ToDate = driver.find_element(By.XPATH,("//*[@id=\"applyleave_txtToDate\"]"));
    ToDate.clear();
    ToDate.send_keys("2023-07-16");
    driver.find_element(By.XPATH,("//*[@id=\"applyBtn\"]")).click();
    #MyLeaves
    driver.find_element(By.XPATH,("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();
    ExpectedTitle = "Pending Approval(1.00)";
    TableValue = driver.find_element(By.XPATH,("/html/body/div[1]/div[3]/div[2]/div/form/div[3]/table/tbody/tr[1]/td[6]/a"));
    print("Second row, second cell value: " + TableValue.get_property('name'));
    assertEquals(ExpectedTitle, TableValue,"matched");