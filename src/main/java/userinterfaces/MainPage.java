package userinterfaces;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://google.com")
public class MainPage extends PageObject {
    public static final Target MAIN_LOGO = Target
            .the(" logo principal de la pagina")
            .located(MobileBy
                    .xpath("//body/div[1]/div[2]/div[1]/img[1]"));

    public static final Target INPUT_SEARCH = Target
            .the(" ingresa texto en la barra de busqueda")
            .located(MobileBy
                    .xpath("//*[@name='q']"));

    public static final Target BTN_BUSCAR = Target
            .the(" boton [Buscar con Google]")
            .located(MobileBy
                    .xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
}
