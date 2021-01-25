package JdiHomework.main.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class DropList extends Section {
    @UI("#salad-dropdown button") Button openBtn;
    @UI("#salad-dropdown input") Checklist options;


    public void select(String ... values){
        openBtn.click();
        options.select("Vegetables"); // Убрать дефолтное значение
        options.select(values);
    }
}