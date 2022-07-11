package com.nuna.pages;

import com.nuna.utility.BrowserUtil;
import com.nuna.utility.ConfigReader;
import com.nuna.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleTranslate_Page {

    @FindBy(xpath = "(//button[starts-with(@class, VfPpkd-Bz112c-LgbsSe)]/span[@class='zQ0atf'])[1]")
    private WebElement dropDownMenuOnLeft;

    @FindBy(xpath = "(//button[starts-with(@class, VfPpkd-Bz112c-LgbsSe)]/span[@class='zQ0atf'])[2]")
    private WebElement dropDownMenuOnRight;

    @FindBy(xpath = "(//div[@class='vSUSRc']/div[@class='F29iQc'])[2]/div[@class='qSb8Pe']/div[@class='Llmcnf']")
    private List<WebElement> languagesLeftSide;

    @FindBy(xpath = "(//div[@class='vSUSRc']/div[@class='F29iQc'])[3]/div[@class='qSb8Pe']/div[@class='Llmcnf']")
    private List<WebElement> languagesRightSide;

    @FindBy(xpath = "(//div[@class='akczyd'])[1]//button[contains(@class, 'VfPpkd-AznF2e-OWXEXe-auswjd')]")
    private WebElement selectedLanguageFromLeft;

    @FindBy(xpath = "(//div[@class='akczyd'])[2]//button[contains(@class, 'VfPpkd-AznF2e-OWXEXe-auswjd')]")
    private WebElement selectedLanguageFromRight;

    @FindBy(xpath = "//div[@class='QFw9Te']/textarea[@class='er8xn']")
    private WebElement textArea;

    @FindBy(xpath = "//span[@class='VIiyi']/span/span[@class='Q4iAWc']")
    private WebElement responseBox;

    @FindBy(xpath = "(//button[starts-with(@class, 'VfPpkd-Bz112c-LgbsSe')])[2]/div[@class='VfPpkd-Bz112c-RLmnJb']")
    private WebElement swapLanguageBtn;


    @FindBy(xpath = "(//div[@class='DVHrxd']/div/div/span)[1]/button/i[starts-with(@class, 'material-icons-extended')]")
    private WebElement clearBtn;

    @FindBy(xpath = "//span[@class='ita-kd-inputtools-div']/div/a[contains(@class, 'ita-kd-dropdown')]/span")
    private WebElement selectInputToolBtn;

    @FindBy(xpath = "//ul[@class='ita-kd-dropdown-menu']/li[2]/span[3]")
    private WebElement keyboardBtn;

    @FindBy(xpath = "(//button[@id='K16'])[1]/span[starts-with(@class, 'vk-cap')]")
    private WebElement shiftBtn;

    @FindBy(xpath = "//button[@id='K72']/span[starts-with(@class, 'vk-cap')]")
    private WebElement hBtn;

    @FindBy(xpath = "//button[@id='K73']/span[starts-with(@class, 'vk-cap')]")
    private WebElement iBtn;


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public GoogleTranslate_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String url) {
        Driver.getDriver().get(url);
    }

    public void selectLanguageFromLeft(String language) {

        js.executeScript("arguments[0].click();", dropDownMenuOnLeft);

        for (WebElement each : languagesLeftSide) {
            if (each.getText().contains(language)) {
                js.executeScript("arguments[0].click();", each);
            }
        }

    }


    public void selectLanguageFromRight(String language) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", dropDownMenuOnRight);

        for (WebElement each : languagesRightSide) {
            if (each.getText().contains(ConfigReader.read("translation language"))) {
                js.executeScript("arguments[0].click();", each);
            }
        }

    }

    public void leftLanguageSelectedCorrectly(String language) {
        Assert.assertEquals(ConfigReader.read(language).toLowerCase(), selectedLanguageFromLeft.getText().toLowerCase());
    }

    public void rightLanguageSelectedCorrectly(String language) {
        Assert.assertEquals(ConfigReader.read(language).toLowerCase(), selectedLanguageFromRight.getText().toLowerCase());
    }

    public void interText(String text) {
        BrowserUtil.waitFor(3);
        textArea.sendKeys(ConfigReader.read(text));
    }

    public String responseText() {
        BrowserUtil.waitFor(2);
        return responseBox.getText();
    }

    public void clickSwapLanguageBtn(){
        js.executeScript("arguments[0].click();", swapLanguageBtn);
    }

    public void clearInputField(){
        BrowserUtil.waitFor(1);
        js.executeScript("arguments[0].click();", clearBtn);
    }

    public boolean inputFieldIsEmpty(){
        BrowserUtil.waitFor(1);
        return textArea.getText().isEmpty();
    }

    public void selectInputBtn(){
        BrowserUtil.waitFor(1);
        js.executeScript("arguments[0].click();", selectInputToolBtn);
        BrowserUtil.waitFor(1);
        js.executeScript("arguments[0].click();", keyboardBtn);
    }

    public void typeHi(){
        BrowserUtil.waitFor(1);
        js.executeScript("arguments[0].click();", shiftBtn);
        js.executeScript("arguments[0].click();", hBtn);
        js.executeScript("arguments[0].click();", iBtn);
    }

    public String inputText() {
        BrowserUtil.waitFor(2);
        return textArea.getAttribute("value");
    }

}
