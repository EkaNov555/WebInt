import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;


class CardTest {
    @Test
    public void shouldSubmitSuccess() {
        open("http://localhost:9999");
        $("[data-test-id=name] [type=text]").setValue("Иван Иванов");
        $("[data-test-id=phone] [type=tel]").setValue("+79659443231");
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}