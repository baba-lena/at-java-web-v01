package work.part05;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomeworkModule5Tests {
    private final String url1 = "http://92.51.36.108:7777/sl.qa/cinema/index.php"; //кино
    private final String url2 = "https://www.aviasales.ru"; // авиа

    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
    }

    @Test
    void test01_cinema_case ()
    {
        open(url1);
        $("input[name=age]").setValue("12");
        String dateValue = "25-12-2025";
        $("input[name='date']").setValue(dateValue);
        $x("//input[@name='session' and @value='2']").click();
        $x("//input[@name='film' and @value='crime']").click();
        $("input[type=submit").click();
        $("div").shouldHave(text("18 лет"));
    }

    @Test
    void test02_cinema_case ()
    {
        open(url1);
        $("input[name=age]").setValue("100");
        $x("//input[@name='age' and @value='']");
        String dateValue = "25-12-2025";
        $("input[name='date']").setValue(dateValue);
        $x("//input[@name='session' and @value='8']").click();
        $x("//input[@name='film' and @value='crime']").click();
        $("input[type=submit").click();
    }

    @ParameterizedTest
    @MethodSource("cinemaDataSource")
    void test03_cinema_case (int age, String dateValue, String start, String film, String priceList)
    {
        open(url1);
        $("input[name=age]").setValue(String.valueOf(age));
        $("input[name='date']").setValue(dateValue);
        $("input[name=session][value='" + start + "']").click();
        $("input[name=film][value='" + film  + "']").click();
        $("input[type=submit").click();
        $("div").shouldHave(text(priceList));
    }
        static Stream<Arguments> cinemaDataSource()
            {
                Stream.Builder<Arguments> argumentsBuilder = Stream.builder();
                argumentsBuilder.add(Arguments.of("12", "25-12-2025", "1", "back",  "Стоимость билета: 350 рублей."));
                argumentsBuilder.add(Arguments.of("18", "26-12-2025", "7", "crime", "Стоимость билета: 400 рублей."));
                argumentsBuilder.add(Arguments.of("0",  "27-12-2025", "2", "king",  "Стоимость билета: 200 рублей."));
                return argumentsBuilder.build();
            }

    @Test
    void test04_cinema_case ()
    {
        open(url1);
        $x("//input[@name='session' and @value='8']").click();
        $x("//input[@name='film' and @value='crime']").click();
        $("input[type=submit").click();
        $("div").shouldHave(text("надо указать возраст для расчёта стоимости билета* *надо указать дату сеанса для расчёта стоимости билета"));
    }

    @Test
    void test05_cinema_case ()
    {
        open(url1);
        int setAge = 22;
        String dateValue = "22-12-2025";
        $("input[name='age']").setValue(String.valueOf(setAge));
        $("input[name='date']").setValue(dateValue);
        $x("//input[@name='session' and @value='10']").click();
        $x("//input[@name='film' and @value='killers']").click();
        $("input[type=submit").click();
        $("div").shouldBe(visible);
    }

}
