package data;

import org.testng.annotations.DataProvider;

public class CertificateData {
    @DataProvider
    public static Object[][] getStrings(){
        return new Object[][]{
                {"45924126"},
                {"8523699"},
                {"78008248"},
                {"254551"},
        };
    }
}
