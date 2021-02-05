package JdiHomework.main.site;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import JdiHomework.main.site.pages.HomePage;
import JdiHomework.main.site.pages.MetalsAndColorsPage;
import JdiHomework.main.site.sections.LoginForm;
import org.openqa.selenium.WebElement;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css("form") 
    public static LoginForm loginForm;
    @Css("img#user-icon") 
    public static Icon userIcon;
    @UI("#user-name") 
    public static Text userName;
    @Css(".fa-sign-out") 
    public static WebElement logout;
    @UI(".nav>li") 
    public static Menu headerMenu;
}
