package hw3.main.java;

import hw3.main.java.menu.ElemCheckboxes;
import hw3.main.java.menu.ElemDropdown;
import hw3.main.java.menu.ElemRadio;
import hw3.main.java.menu.LogItem;
import org.openqa.selenium.WebDriver;


public class DifferentElementsPage extends AbstractPage{

    public ElemCheckboxes checkboxes;
    public ElemRadio radio;
    public ElemDropdown dropdown;
    public LogItem log;

    public DifferentElementsPage(WebDriver driver){
        super(driver);
        checkboxes = new ElemCheckboxes(driver);
        radio = new ElemRadio(driver);
        dropdown = new ElemDropdown(driver);
        log = new LogItem(driver);
    }
}
