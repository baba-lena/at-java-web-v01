package work.part07;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

    public class LoginPage {
        SelenideElement
                username = $("#username"),
                password = $("#password"),
                loginButton = $("#loginButton"),
                greeting = $("#greeting");

        @Step("Вход в систему")
        public void login(String username, String password) {
            this.username.setValue(username);
            this.password.setValue(password);
            this.loginButton.click();
        }

        @Step("Успешный логин")
        public void isLoginSuccessful(String fio) {
            this.greeting.shouldHave(text("Добро пожаловать, " + fio + "!"));
        }


    }



