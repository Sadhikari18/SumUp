package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalProfileValidator {



    public static boolean isValiDOB(String dob) {
        Pattern pt;
        System.out.printf(dob);
        pt = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}.[0-9]{3}Z$");
        Matcher m = pt.matcher(dob);
        return m.matches();
    }

    public static boolean isValiname(String name) {
        Pattern pt;
        pt = Pattern.compile("[a-zA-Z]+");
        Matcher m = pt.matcher(name);
        return m.matches();
    }

    public static boolean isValiPhoneNum(String zip) {
        Pattern pt;
        pt = Pattern.compile(("\\+[0-9]+"));
        Matcher m = pt.matcher(zip);
        return m.matches();
    }


}
