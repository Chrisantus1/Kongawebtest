import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTestProject{
 //import the selenium webDriver
   private WebDriver driver;

   @BeforeTest
   public void setup() throws InterruptedException {
      //locate where the chrome driver is
      System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
      //Open your chrome browser
       this.driver = new ChromeDriver();
      //Input your Konga URL(https://konga.com)
       this.driver.get("https://konga.com");
       Thread.sleep(5000);
      //Maximize the browser
       this.driver.manage().window().maximize();
       Thread.sleep(5000);
      //Click on the login button to open login page
       this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
       Thread.sleep(5000);
   }

   @Test (priority = 0)
   public void Login() throws InterruptedException {
       //Input your email address or phone number
       this.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("chrisanctusdagr8@gmail.com");
       Thread.sleep(5000);
       //Input your password on the password field
       this.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Santusdagr8");
       Thread.sleep(5000);
       //Click on submit button
       this.driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
       Thread.sleep(10000);
   }

   @Test (priority = 1)
   public void Category() throws InterruptedException {
       //From categories, click on computer and accessories
       this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
       Thread.sleep(5000);
   }


   @Test (priority = 2)
   public void Item() throws InterruptedException {
       //Click on Laptop
       this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a")).click();
        Thread.sleep(5000);
        //Click on AppleMac
       this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
       Thread.sleep(5000);
   }

   @Test (priority = 3)
   public void Cart() throws InterruptedException {
       //Click on Add To Cart
       this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[2]/button")).click();
       Thread.sleep(5000);
       //Click on my Cart
       this.driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
       Thread.sleep(5000);
       //click continue to checkout
       this.driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
       Thread.sleep(10000);
   }

    @Test (priority = 4)
    public void Payment() throws InterruptedException {
    //Click on Pay Now
    this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
    Thread.sleep(5000);
    //Click on continue to payment
    this.driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
    Thread.sleep(10000);
    }

    @Test (priority = 5)
    public void selectCardMethod() throws InterruptedException {
        //17 select a card payment method
        //17a. change from default to iframe
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(7000);
        System.out.println("Payment Method");
        //17b. select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("Select card method");
        Thread.sleep(15000);
    }
    @Test (priority = 6)
    public void inputCardDetails() throws InterruptedException {
        //18. input individual card details
        //18a. input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("123456789000");
        Thread.sleep(3000);
        //18b. input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1124");
        Thread.sleep(3000);
        //18c. input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("456");
        Thread.sleep(10000);
        System.out.println("input card details");
        driver.findElement(By.xpath("//*[@id=\"card-pin-new\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"keypads\"]/button[4]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);
        System.out.println("input card pin");
        Thread.sleep(5000);
    }
    @Test (priority = 7)
    public void errorMessage() throws InterruptedException {
        //19 print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(10000);
    }
    @Test (priority = 8)
    public void closeFrame() throws InterruptedException {
        //20. close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("Exit payment method iframe");
        Thread.sleep(10000);
    }
    @Test (priority = 9)
    public void exitIFrame() throws InterruptedException {
        //21. Exit iFrame web
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        System.out.println("Restore default page");
    }
    @AfterTest
    public void CloseBrowser() {
     //Quit the browser
     this.driver.quit();
   }

}