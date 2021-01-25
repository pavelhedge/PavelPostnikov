package JdiHomework.main.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import JdiHomework.main.site.sections.MetalsAndColorsForm;
import JdiHomework.main.site.sections.ResultsSection;

@Url("/metals-colors.html") @Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

   @UI(".form") public MetalsAndColorsForm form;

   @UI(".results") public ResultsSection results;

}
