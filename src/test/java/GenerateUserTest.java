
import org.testng.Assert;
import org.testng.annotations.*;
import validator.AddressValidator;
import validator.PersonalProfileValidator;


public class GenerateUserTest extends BaseTest{


    //To run functional test for each of country(for now FR, US and Al)code and assert content type as json
    @Test(dataProvider = "data-for-countrycode")
    public void assertHeaders(String countryCode) {
        generateUser(countryCode);
        String content = response.header(Headers.CONTENTTYPE).split(";")[0];
        Assert.assertEquals(content, "application/json");

    }

    //To run functional test for each of country and assert country name in address and country
    @Test(dataProvider = "data-for-countrycode")
    public void assertCountry(String countryCode) {
        generateUser(countryCode);
        String country = rootObj.getUser().getCountry();
        String addrCountry = rootObj.getUser().getAddress().getCountry();
        Assert.assertEquals(countryCode, addrCountry);
        Assert.assertEquals(countryCode, country);

    }

    //To run functional test for each of country with lower case and assert country name in address and country
    @Test(dataProvider = "data-for-countrycode")
    public void assertLowerCountryCode(String countryCode) {
        generateUser(countryCode.toLowerCase());
        String country = rootObj.getUser().getCountry();
        String addrCountry = rootObj.getUser().getAddress().getCountry();
        Assert.assertEquals(countryCode, addrCountry);
        Assert.assertEquals(countryCode, country);

    }

    //To run functional test for US and assert the Phone Number schema
    @Test
    public void assertPhoneNumSchema() {
        generateUser(Locale.US);
        String mobileNumberSchema = rootObj.getUser().getPersonal_profile().getMobile_phone();
        Assert.assertTrue(AddressValidator.isValiLandLine(mobileNumberSchema));

    }

    //To run functional test for US and assert the fname and lname schema
    @Test
    public void assertNameSchema() {
        generateUser(Locale.US);
        String fname = rootObj.getUser().getPersonal_profile().getFirst_name();
        String lname = rootObj.getUser().getPersonal_profile().getLast_name();
        Assert.assertTrue(AddressValidator.isValiname(fname));
        Assert.assertTrue(AddressValidator.isValiname(lname));

    }

    //To run functional test for US and assert the postal/zip schema
    @Test
    public void assertZip() {
        generateUser(Locale.US);
        String zip = rootObj.getUser().getAddress().getPost_code();
        Assert.assertTrue(AddressValidator.isValiZip(zip));

    }


    //To run functional test for US and assert the Date Of Birth schema
    @Test
    public void assertDOB() {
        generateUser(Locale.US);
        String dob = rootObj.getUser().getPersonal_profile().getDate_of_birth();
        Assert.assertTrue(PersonalProfileValidator.isValiDOB(dob));

    }

}
