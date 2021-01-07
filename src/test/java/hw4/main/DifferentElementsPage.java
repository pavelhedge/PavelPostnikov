package hw4.main;

import hw4.java.menu.*;
import hw4.main.menu.*;
import org.openqa.selenium.WebDriver;

public class DifferentElementsPage extends AbstractPage {

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
