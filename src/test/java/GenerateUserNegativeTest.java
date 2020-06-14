import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GenerateUserNegativeTest extends BaseTest {

    //To run functional test for invalid endpoint
    @Test(dataProvider = "data-for-countrycode")
    public void assertNonExistEndPoint(String countryCode) {
        generateUser(countryCode);
        uri = uri + "/sas";
        given()
                .log()
                .all()
                .header(Headers.CONTENTTYPE, "application/json")
                .header("HTTP", "1.1")
                .body(payload.place(country))
                .when()
                .post(uri).then().statusCode(404);

    }

    //To run functional test for invalid contentType
    @Test(dataProvider = "data-for-countrycode")
    public void assertNonExistContentType(String countryCode) {
        generateUser(countryCode);
        uri = uri;
        given()
                .log()
                .all()
                .header(Headers.CONTENTTYPE, "text/html")
                .header("HTTP", "1.1")
                .body(payload.place(country))
                .when()
                .post(uri).then().statusCode(500);

    }

    //To run functional test for invalid countryCode
    @Test
    public void assertNonExistCountryCodeTest() {
        generateUser("sdsada*");
        Assert.assertNull(rootObj.getUser().getAddress());
        Assert.assertNull(rootObj.getUser().getPersonal_profile());

    }

    //To run functional test for empty countryCode
    @Test
    public void assertEmptyCountryCodeTest() {
        generateUser(" ");
        Assert.assertNull(rootObj.getUser().getAddress());
        Assert.assertNull(rootObj.getUser().getPersonal_profile());

    }

    //To run functional test for null countryCode
    @Test
    public void assertNullCountryCodeTest() {
        generateUser(null);
        Assert.assertEquals(response.statusCode(), 500);

    }

}
