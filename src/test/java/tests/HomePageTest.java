package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest  {
    HomePage homepage;
    @BeforeClass
    public void initialObject(){
        homepage = new HomePage(this.driver);
    }

    @Test
    public void firstTest() throws InterruptedException {
        Assert.assertTrue(homepage.homePageLogoIsDisplayed());
    }
}
