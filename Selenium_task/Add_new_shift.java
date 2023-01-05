package org.example;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Add_new_shift {
    private final Duration timeoutLoadPageInSeconds = Duration.ofSeconds(5);

    private final String loginUsername = "Admin";
    private final String loginPassword = "admin123";
    private final String addedEmployeeName = "Odis Adalwin";
    private final String addedShiftName = "Random Name";
    private static final String fromTime = "06:00 AM";
    private static final String toTime = "06:00 PM";

    private final WebDriver driver = new ChromeDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, timeoutLoadPageInSeconds);

    public Add_new_shift(){
        driver.manage().window().maximize();
    }

    public void CloseWindow(){
        driver.close();
    }

    public void LoginToPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys(loginUsername);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginPassword);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }

    public void GoToShiftPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Job')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Work Shifts')]"))).click();

        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

    }
    public void AddShift(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Add')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"oxd-input oxd-input--active\" and not(@placeholder)]"))).sendKeys(addedShiftName);

        List<WebElement> salariesInputs = driver.findElements(By.xpath("//input[@class=\"oxd-input oxd-input--active\"]"));
        salariesInputs.get(1).clear();
        salariesInputs.get(1).sendKeys(fromTime);
        salariesInputs.get(2).clear();
        salariesInputs.get(2).sendKeys(toTime);

        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(addedEmployeeName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Odis')]"))).click();

        driver.findElement(By.xpath("//button[contains(.,\"Save\")]")).click();
    }

    public Boolean SearchShift() {
        try {
            String[] arrayOfStringXpath = new String[4];
            arrayOfStringXpath[0] = "//div[contains(.,\"Random Name\")]";
            arrayOfStringXpath[1] = "//div[contains(.,\"06:00\")]";
            arrayOfStringXpath[2] = "//div[contains(.,\"18:00\")]";
            arrayOfStringXpath[3] = "//div[contains(.,\"12\")]";

            for (String s : arrayOfStringXpath) {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s))).isDisplayed();
            }
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void DeleteShift(){
        driver.findElement(By.xpath("//div[@class=\"oxd-table-row oxd-table-row--with-border\" and " +
                String.format("./div/div[contains(text(), \"%s\")]]//i[@class=\"oxd-icon bi-trash\"]", addedShiftName))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., \"Yes, Delete\")]"))).click();
        driver.close();
    }
}
