package hw3.main.java;

import hw3.main.java.menu.*;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractPage{

    public Selectable checkboxes;
    public Selectable radio;
    public Selectable dropdown;
    public Selectable log;

    public DifferentElementsPage(WebDriver driver){
        super(driver);
        checkboxes = new ElemCheckboxes(driver);
        radio = new ElemRadio(driver);
        dropdown = new ElemDropdown(driver);
        log = new LogItem(driver);
    }
}
