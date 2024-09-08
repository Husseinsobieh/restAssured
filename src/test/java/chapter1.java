import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class chapter1 {
    @Test
    public void statusCheck(){
        given().
                when().
                get("https://api.zippopotam.us/us/90210")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
