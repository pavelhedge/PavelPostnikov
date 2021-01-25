package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import JdiHomework.main.entities.MetalsAndColorsDataset;

public class MetalsAndColorsForm extends Form<MetalsAndColorsDataset> {

    @UI("#summary-block") public SummaryBox summary;
    @UI("#elements-block input") public Checklist elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown color;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public Dropdown metals;
    @UI("#vegetables")
    public DropList vegetables;

    @UI("#submit-button") public Button submit;

    /*@Override
    public void fillAction(Field field, Object element, Object parent, String setValue){
        System.out.printf("############## \n\nfield: %s\nelement: %s\nparent: %s\nsetValue: %s\n\n", field.getName(),  element.getClass(),  parent.getClass(),  setValue);

        super.fillAction(field, element, parent, setValue);
    }*/
}
