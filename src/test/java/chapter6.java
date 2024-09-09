import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class chapter6 {
    @Test
    public void checkResponse(){
        Location location =

            given().
            when().
                get("https://api.zippopotam.us/us/90210").
            as(Location.class);

        Assert.assertEquals("Beverly Hills", location.getPlaces().get(0).getPlaceName());
    }
    @Test
    public void sendRequest(){
        Location location = new Location();
        given().
            contentType(ContentType.JSON).
            body(location).
            log().body().
        when().
            post("localhost").
        then().
            assertThat().
            statusCode(200);
    }
}
