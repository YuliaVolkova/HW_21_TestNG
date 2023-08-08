package objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CertificatePage {
    @FindBy (xpath = "//*[@id=\"certificateCheckForm\"]/div/input")
//            (name = "certificate")
    WebElement searchField;
    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMessage;
    WebDriver driver;

    public CertificatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void sendNumber(String number){
        searchField.sendKeys(number);
        searchField.sendKeys(Keys.ENTER);





    }

    public boolean checkLinkCertificate() {
        return driver.getCurrentUrl().contains("view");
    }

    public boolean checkCertificateForm() throws Exception{
        System.out.println(checkFormMessage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMessage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate checker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
