package work.part07.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
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
    void test01LoginFailed()
    {
        sp.login("", "");
        sp.isLoginFailed();
    }

    @Test @Order(2)
    void test02LoginSuccessfull()
    {
        sp.login("agileway", "test$W1se");
        sp.isLoginSuccessful();
    }

    SelectFlightPage sf = new SelectFlightPage ();
    @Test @Order(3)
    void test03SelectFlightRoundTrip()
    {
        test02LoginSuccessfull();
        sf.selectFlightRoundTrip("New York", "Sydney", "30", "July 2025", "10", "October 2025","08:00");
    }

    @Test @Order(4)
    void test04SelectFlightOneWay()
    {
        test02LoginSuccessfull();
        sf.selectFlightOneWay("New York", "Sydney", "30", "July 2025", "08:30");
    }

    PassDetailsPage pd = new PassDetailsPage();
    @Test @Order(5)
    void test05PassDetails()
    {
        test04SelectFlightOneWay();
        pd.passDetails("Josef", "Stalin");
    }

    PaymentPage pp = new PaymentPage();
    @Test @Order(6)
    void test06PassDetails()
    {
        test05PassDetails();;
        pp.payByCreditCard("Niki Khruschev", "1953", "07", "2027");
    }

}
