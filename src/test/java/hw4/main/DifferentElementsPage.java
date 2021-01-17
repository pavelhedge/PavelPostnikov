package hw4.main;

import hw4.main.subElements.*;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    private Selectable checkboxes;
    private Selectable radio;
    private ElemDropdown dropdown;
    private LogItem log;

    public DifferentElementsPage(){
        super("Different Elements", "https://jdi-testing.github.io/jdi-light/different-elements.html");
        checkboxes = new ElemCheckboxes();
        radio = new ElemRadio();
        dropdown = new ElemDropdown();
        log = new LogItem();
    }

    public void selectCheckbox(String itemName) {
        checkboxes.select(itemName);
    }

    public void selectRadio(String itemName) {
        radio.select("Selen");
    }

    public void selectDropdown(String itemName) {
        dropdown.select("Yellow");
    }

    public List<String> getLog(){
        return log.getItemsText();
    }
}
