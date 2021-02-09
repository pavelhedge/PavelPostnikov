package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class SummaryBox extends Section {

    @UI("#odds-selector input")
    RadioButtons odds;
    @UI("#even-selector input")
    RadioButtons even;

    public void select(int... numbers) {

        if (isOdd(numbers[0])) odds.select("" + numbers[0]);
        else throw new IllegalStateException("ERROR: Cannot select, this radio is only for odd numbers");

        if (!isOdd(numbers[1])) even.select("" + numbers[1]);
        else throw new IllegalStateException("ERROR: Cannot select, this radio is only for even numbers");
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
