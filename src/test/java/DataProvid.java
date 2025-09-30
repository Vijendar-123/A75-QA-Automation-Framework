import org.testng.annotations.DataProvider;

public class DataProvid {
    @DataProvider(name = "IncorrectLoginData")
    public static Object[][] getDataFromDataProviders() {

        return new Object[][]{
                {"incorrect@testpro.io", "cnb243YB"},
                {"vijendar@testpro.io", "incorrectPas"},
                {"", "cnb243YB"},
                {"incorrect@testpro.io", ""}
        };
    }
    @DataProvider(name = "incorrectURLs")
    public static Object[][] getDataFromDataProvidersurl() {

        return new Object[][]{
                {"incorrect@testpro.io", "cnb243YB"},
                {"vijendar@testpro.io", "incorrectPas"},
                {"", "cnb243YB"},
                {"incorrect@testpro.io", ""}
        };
    }
}
