package work.part07;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class SearchPage {
    SelenideElement cityFrom = $("#departureCity");
    SelenideElement cityTo = $("#arrivalCity");
    SelenideElement departureDate = $("#departureDate");
    SelenideElement findButton = $x("//button[.='Найти']");
    SelenideElement searchMessage = $("#searchMessage");

    @Step("Поиск рейсов (задаём только дату)")
    public void search(String departureDate) {
        this.departureDate.setValue(departureDate);
        this.findButton.click();
    }

    @Step("Прошлая дата не прокатит")
    public void incorrectDate()
    {
        this.searchMessage.shouldHave(text("Невозможно осуществить поиск: выбранная дата уже прошла."));
    }

}