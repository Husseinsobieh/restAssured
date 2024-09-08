import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class chapter4 {
    private static RequestSpecification request;
    private static ResponseSpecification response;
    @BeforeClass
    public void requestSpec(){
        request = new RequestSpecBuilder().
                setBaseUri("https://api.zippopotam.us").
                build();
    }
    @BeforeClass
    public void responseSpec(){
        response = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectStatusCode(200).
                build();
    }
    @Test
    public void bothSpecCheck(){
        given().
            spec(request).
        when().
            get("us/90210").
        then().
            spec(response).
        and().
            assertThat().
            body("places.'place name'", hasItem("Beverly Hills"));
    }
    @Test
    public void extractCheck(){
        String placeName =
        given().
            spec(request).
        when().
            get("us/90210").
        then().
            extract().
            path("places[0].'place name'");
        Assert.assertEquals(placeName, "Beverly Hills");
    }
}
