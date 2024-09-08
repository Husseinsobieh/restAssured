import org.testng.annotations.DataProvider;

public class chapter3 {
    @DataProvider
    public Object[][] zipCode(){
        Object[][] data = new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"nl", "1001", "Amsterdam"}
        };
        return data;
    }
}
