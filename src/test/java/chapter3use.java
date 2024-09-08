import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class chapter3use {
    @Test(dataProviderClass = chapter3.class, dataProvider = "zipCode")
    public void useDataProvider(String country, String zipCode, String placeName){
        given().
                when().
                get("https://api.zippopotam.us/" + country + "/" + zipCode).
                then().
                assertThat().body("places.'place name'", hasItem(placeName));
    }
    @Test(dataProviderClass = chapter3.class, dataProvider = "zipCode")
    public void useDataProvider2(String country, String zipCode, String placeName){
        given().pathParams("country", country).pathParams("zipCode", zipCode).
                when().
                get("https://api.zippopotam.us/{country}/{zipCode}").
                then().
                assertThat().body("places.'place name'", hasItem(placeName));
    }
}
