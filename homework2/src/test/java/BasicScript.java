import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript {
    private static WebDriver driver;
    private String baseUrl;


    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
}

    @Before
    public void setURL() {
        baseUrl = "https://www.google.com.ua/";
        System.out.println(baseUrl);
    }

    @Test
    public void testChrome() {
        driver.get(baseUrl);
        WebElement chrInput = driver.findElement(By.id("lst-ib"));
        chrInput.sendKeys("Selenium");
        chrInput.sendKeys(Keys.ENTER);
        assert driver.getCurrentUrl().toLowerCase().contains("selenium");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
