package work.part07.homework;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage
    {

        SelenideElement
                cardtype = $x("//input[@name='card_type' and @type='radio']"),
                holdername = $x("//input[@name='holder_name' and @type='text']"),
                cardnumber = $x("//input[@name='card_number' and @type='text']"),
                expirymonth = $x("//select[@name='expiry_month']"),
                expiryyear = $x("//select[@name='expiry_year']"),
                submit = $("input[value='Pay now']"),
                confirm = $("#confirmation");

        @Step("Pay by credit card with confirmation")
        public void payByCreditCard (String holdername, String cardnumber,String expirymonth, String expiryyear)
        {
            this.cardtype.click();
            this.holdername.setValue(holdername);
            this.cardnumber.setValue(cardnumber);
            this.expirymonth.selectOption(expirymonth);
            this.expiryyear.selectOption(expiryyear);
            this.submit.click();
            sleep(5000);
            this.confirm.shouldBe(visible);
        }

    }
