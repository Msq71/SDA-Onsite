package Homeworks.Homework_06;

import com.github.javafaker.Faker;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Challenge_day06 {
        static WebDriver driver;
        @BeforeClass
        public static void setUp(){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        }
        @AfterClass
        public static void tearDown (){
            //driver.quit();
        }

        @Test
        public void challenge() throws InterruptedException {
            //login
            WebElement email = driver.findElement(By.id("email"));
            email.click();
            email.sendKeys("Msqx71@gmail.com");
            WebElement pass = driver.findElement(By.id("password"));
            pass.click();
            pass.sendKeys("1234567");
            driver.findElement(By.id("submit")).click();

            //click on add-contact
            driver.findElement(By.id("add-contact")).click();
            //User is directed to create contact page successfully
            Assert.assertEquals("https://thinking-tester-contact-list.herokuapp.com/addContact",driver.getCurrentUrl());

            //fill the form using Faker class
            Faker faker = new Faker();
            //fake firstname
            WebElement fname = driver.findElement(By.id("firstName"));
            String firstname = faker.name().firstName();
            fname.sendKeys(firstname);
            // fake lastname
            WebElement lname = driver.findElement(By.id("lastName"));
            String lastName = faker.name().lastName();
            lname.sendKeys(lastName);
            //fake date
            WebElement birth = driver.findElement(By.id("birthdate"));
            birth.sendKeys("2000-06-10");
            //fake email
            WebElement email1 = driver.findElement(By.xpath("//input[@id='email']"));
            String em = faker.internet().emailAddress();
            email1.sendKeys(em);
            //fake phone
            WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
            phone.sendKeys("0555555555");
            //fake address
            WebElement address = driver.findElement(By.xpath("//input[@id='street1']"));
            address.sendKeys("x");
            ////fake address 2
            WebElement address2 = driver.findElement(By.xpath("//input[@id='street2']"));
            address2.sendKeys("x");
            //fake city
            WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
            city.sendKeys("x");
            //fake State or Province
            WebElement state = driver.findElement(By.xpath("//input[@id='city']"));
            state.sendKeys("x");
            //fake postal code
            WebElement postal = driver.findElement(By.xpath("//input[@id='stateProvince']"));
            postal.sendKeys("10653223");
            //fake country
            WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
            country.sendKeys("Riyadh");
            //click submit
            WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
            submit.click();

            //Contact has been created successfully
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(3000);
            System.out.println(driver.getCurrentUrl());

            //Assert1: User is directed to contact list page successfully
            Assert.assertEquals("https://thinking-tester-contact-list.herokuapp.com/contactList",driver.getCurrentUrl());

            //Assert2: The data of created contact appears in table
            WebElement data = driver.findElement(By.xpath("(//*[contains(text(),'"+firstname+"')])"));
            Assert.assertTrue(data.isDisplayed());

            //Assert3:
            //After click on the name of created contact
            data.click();
            // website direct user to Contact Details page
            WebElement ContactDetails = driver.findElement(By.xpath("(//*[contains(text(),'Contact Details')])"));
            Assert.assertTrue(ContactDetails.isDisplayed());
        }

    }

