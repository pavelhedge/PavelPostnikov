package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import JdiHomework.main.entities.MetalsAndColorsDataset;

public class MetalsAndColorsForm extends Form<MetalsAndColorsDataset> {

    @UI("#summary-block")
    public SummaryBox summary;
    @UI("#elements-block input")
    public Checklist elements;
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
    @UI("#submit-button") 
    public Button submit;
    
    @Override
    public void submit(MetalsAndColorsDataset dataset) {
        summary.select(dataset.summary);
        elements.select(dataset.elements);
        color.select(dataset.color);
        metals.select(dataset.metals);
        vegetables.select(dataset.vegetables);
        submit.click();
    }
}
