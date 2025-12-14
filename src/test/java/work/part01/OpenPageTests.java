package work.part01;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
public class OpenPageTests {
    @Test
    void openWebSite() {
        open("https://ya.ru"); //06.12.2025
    }

}