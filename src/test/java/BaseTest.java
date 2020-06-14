import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import pojo.Root;
import pojo.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties prop;
    Root rootObj;
    User user;
    String country;
    Response response;
    String uri;


    @BeforeSuite
    public void loadProperty() throws IOException {
        prop = new Properties();
        FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Testing.properites");
        prop.load(fp);

    }

    public void generateUser(String countryCode) {
        country = countryCode;
        uri = prop.getProperty("URL");
        System.out.println(uri);
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured
                .given()
                .header("Content-type", "application/json")
                .header("HTTP", "1.1")
                .body(payload.place(country)).log().all();
        response = httpRequest.post();
        rootObj = response.as(Root.class);
        user = rootObj.getUser();

    }

    @DataProvider(name = "data-for-countrycode")
    public Object[][] dpMethod() {
        return new Object[][]{
                {Locale.US},
                {Locale.AL},
                {Locale.FR}
        };
    }

}