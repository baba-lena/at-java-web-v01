package work.part07;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMFlightsTests {
    @BeforeEach
    void setUp()
    {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        //getWebDriver().manage().window().maximize();
    }

    @Test
    void test01()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");
    }

    @Test
    void test02()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.search("01.12.2025");
        searchPage.incorrectDate();
    }

}
