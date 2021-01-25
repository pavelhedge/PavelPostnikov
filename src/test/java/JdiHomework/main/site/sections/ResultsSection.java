package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import JdiHomework.main.entities.MetalsAndColorsDataset;

public class ResultsSection extends Section {
    @UI(".summ-res") public Text summary;
    @UI(".col-res") Text color;
    @UI(".met-res") Text metal;
    @UI(".sal-res") Text vegetables;
    @UI(".elem-res") Text elements;

    @Override
    public String toString(){
        return String.format("Sum: %s\n color: %s\nmetal: %s\nvegetables: %s\n elements: %s\n",
                summary.getValue(),
                color.getValue(),
                metal.getValue(),
                vegetables.getValue(),
                elements.getValue());
    }

    private String getString(Text text){
        return text.getText().split(": ")[1];
    }

    public MetalsAndColorsDataset getDataset(){
        return new MetalsAndColorsDataset().set(
                d -> {
                    d.sum = Integer.parseInt(getString(summary));
                    d.elements = getString(elements).split(", ");
                    d.color = getString(color);
                    d.metals = getString(metal);
                    d.vegetables = getString(vegetables).split(", ");
                });
    }
}
