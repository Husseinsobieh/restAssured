import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class chapter5 {
    @Test
    public void checkXML(){
            given().
            when().
                get("https://api.zippopotam.us/us/90210").
            then().
                assertThat().
                body("places.'place name'", not(hasItem("Beverly Hills")));
    }
}