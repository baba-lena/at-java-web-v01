package work.part07.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMAgileTravelTest {

    private final String url = "https://travel.agileway.net/login";

    @BeforeEach
    void openWeb()
    {
       Configuration.browser = "firefox";
       open(url);
       getWebDriver().manage().window().maximize();
    }

    SignInPage sp = new SignInPage();

    @Test @Order(1)
    void test02LoginFailed()
    {
        sp.login("", "");
        sp.isLoginFailed();
    }

    @Test @Order(2)
    void test01LoginSuccessfull()
    {
        sp.login("agileway", "test$W1se");
        sp.isLoginSuccessful();
    }


    SelectFlightPage sf = new SelectFlightPage ();
    @Test @Order(3)
    void test03SelectFlightRoundTrip()
    {
        sp.login("agileway", "test$W1se");
        sp.isLoginSuccessful();
        sf.SelectFlightPage("New York", "Sydney", "30", "July 2025", "10", "October 2025","8:30");
        sf.selectFlightRoundTrip();
        sleep(20000);
    }



}
