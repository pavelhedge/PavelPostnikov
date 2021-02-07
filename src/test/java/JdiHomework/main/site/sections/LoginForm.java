package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import JdiHomework.main.entities.User;

public class LoginForm extends Form<User> {
    @Css("#name")
    TextField userName;
    @Css("#password")
    TextField password;
    @Css("[type=submit]")
    Button enter;
}
