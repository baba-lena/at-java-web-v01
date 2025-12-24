package work.part07.homework;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PassDetailsPage
    {

        SelenideElement
                firstname = $x("//input[@name='passengerFirstName' and @type='text']"),
                lastname = $x("//input[@name='passengerLastName' and @type='text']"),
                submit = $("input[value='Next']");


        @Step("Passenger Details")
        public void passDetails (String firstname, String lastname)
        {
            this.firstname.setValue(firstname);
            this.lastname.setValue(lastname);
            this.submit.click();
        }

    }
