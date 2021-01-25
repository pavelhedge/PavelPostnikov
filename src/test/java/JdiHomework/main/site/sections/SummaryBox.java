package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class SummaryBox extends Section{
    @UI("#odds-selector input") RadioButtons odds;
    @UI("#even-selector input") RadioButtons even;

    public void select(int... numbers){
        odds.select("" + numbers[0]);
        even.select("" + numbers[1]);
    }
}
