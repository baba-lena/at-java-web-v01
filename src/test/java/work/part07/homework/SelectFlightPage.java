package work.part07.homework;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SelectFlightPage
{

    SelenideElement
        roundTrip = $x("//input[@name='tripType' and @value='return']"),
        onewayTrip = $x("//input[@name='tripType' and @value='oneway']"),
        from =  $x("//select[@name='fromPort']"),
        to =  $x("//select[@name='toPort']"),
        departDay = $("#departDay"),
        departMonth = $("#departMonth"),
        returnDay =$("#returnDay"),
        returnMonth =$("#returnMonth"),
        //timeFlight = ????
        submit = $("#sumbit");

    public void SelectFlightPage (String fromPort, String toPort, String departDay, String departMonth)
    {
        this.from.selectOption(fromPort);
        this.to.selectOption(toPort);
        this.departDay.selectOption(departDay);
        this.departMonth.selectOption(departMonth);
    }

    public void SelectFlightPage(String fromPort,
                                 String toPort,
                                 String departDay,
                                 String departMonth,
                                 String returnDay,
                                 String returnMonth,
                                 String timeFlight)
    {
        this.from.selectOption(fromPort);
        this.to.selectOption(toPort);
        this.departDay.selectOption(departDay);
        this.departMonth.selectOption(departMonth);
        this.returnDay.selectOption(returnDay);
        this.returnMonth.selectOption(returnMonth);
        //this.timeFlight.selectOption(timeFlight);
    }


    @Step("Round Trip")
    public void selectFlightRoundTrip()
    {
        this.roundTrip.click();
        this.submit.click();
    }

    @Step("One Way Ticket")
    public void selectFlightOneWay()
    {
        this.onewayTrip.click();
        this.submit.click();
    }

}
