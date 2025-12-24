package work.part07.homework;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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
        timeFlight = $x ("//tr[./td[contains(text(),':')]]//input[@type='checkbox']"),
        submit = $("input[value='Continue']");





    @Step("Round Trip")
    public void selectFlightRoundTrip(String fromPort,
                                      String toPort,
                                      String departDay,
                                      String departMonth,
                                      String returnDay,
                                      String returnMonth,
                                      String timeFlight)
    {
        this.roundTrip.click();
        this.from.selectOption(fromPort);
        this.to.selectOption(toPort);
        this.departDay.selectOption(departDay);
        this.departMonth.selectOption(departMonth);
        this.returnDay.selectOption(returnDay);
        this.returnMonth.selectOption(returnMonth);
        this.timeFlight.click();
        this.submit.click();
    }

    @Step("One Way Ticket")
    public void selectFlightOneWay(String fromPort,
                                   String toPort,
                                   String departDay,
                                   String departMonth,
                                   String timeFlight)
    {
        this.onewayTrip.click();
        this.from.selectOption(fromPort);
        this.to.selectOption(toPort);
        this.departDay.selectOption(departDay);
        this.departMonth.selectOption(departMonth);
        this.timeFlight.click();
        this.submit.click();
    }

}
