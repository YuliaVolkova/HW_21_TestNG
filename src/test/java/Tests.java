import configuration.BaseClass;
import data.CertificateData;

import objects.CertificatePage;
import objects.HillelMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests extends BaseClass {

    HillelMainPage hillelMainPage;
    CertificatePage certificatePage=new CertificatePage(driver);


    private final String mainURL="https://ithillel.ua/";
    @BeforeClass
    public void bb() {
        driver.get(mainURL);
        hillelMainPage= new HillelMainPage(driver);
        certificatePage=new CertificatePage(driver);
    }

    @Test
    public void checkCourseElem(){
        Assert.assertTrue(hillelMainPage.checkCourseElement());
    }



    @Test    (description = "check certificate page",dependsOnMethods = {"checkCourseElem"},
    dataProviderClass = CertificateData.class, dataProvider = "getStrings")
    public void openCertificatePage(String searchNumber) throws Exception {

            driver.navigate().to("https://certificate.ithillel.ua/");

        certificatePage.sendNumber(searchNumber);
            certificatePage.checkCertificateForm();



    }
}
