import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class chapter2 {
    @Test
    public void contentCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                        assertThat().
                contentType("application/json");
//                        contentType(ContentType.JSON);
    }
    @Test
    public void logCheck(){
        given().
                log().all().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                log().body();
    }
    @Test
    public void bodyCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                body("places[0].'place name'", equalTo("Beverly Hills"));
    }
    @Test
    public void stateCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].state", equalTo("California"));
    }
    @Test
    public void hasItemCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }
    @Test
    public void notHasItemCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", not(hasItem("Beverly Hills")));
    }
    @Test
    public void hasSizeCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }
}
