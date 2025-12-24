package work.part07.homework;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignInPage {

    SelenideElement
            username = $("#username"),
            password = $("#password"),
            commit = $x("//input[@name='commit' and @value='Sign in']"),
            notice = $("#flash_notice"),
            alert = $("#flash_alert");

    @Step("Sign in")
    public void login(String username, String password)
        {
            this.username.setValue(username);
            this.password.setValue(password);
            this.commit.click();
        }

    @Step("Login Successfully")
    public void isLoginSuccessful()
        {
            this.notice.shouldHave(text("Signed in!"));
        }

    @Step("Login Failed")
    public void isLoginFailed()
        {
            this.alert.shouldHave(text("Invalid email or password"));
        }

}
