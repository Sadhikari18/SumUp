package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {
    /***
     * I just wrote this method to show how i change the validation based on this locale. i would follow the same approach for any method.
     * @param zip
     * @return
     */
    public static boolean isValiZip(String zip) {
        Pattern pt;
        if (zip == "US")
            pt = Pattern.compile("\\d{5}(-)?(\\d{4})?");

        else if (zip == "AL")
            pt = Pattern.compile("\\d{6}");
        else
            pt = Pattern.compile("\\d{5}(-)?(\\d{4})?");
        Matcher m = pt.matcher(zip);
        return m.matches();
    }

    public static boolean isValiAdd1(String addLine1) {
        Pattern pt;
        pt = Pattern.compile("\\d+\\s(\\w*)?");
        Matcher m = pt.matcher(addLine1);
        return m.matches();
    }

    public static boolean isValiname(String name) {
        Pattern pt;
        pt = Pattern.compile("[a-zA-Z]+");
        Matcher m = pt.matcher(name);
        return m.matches();
    }

    public static boolean isValiLandLine(String landLineNum) {
        Pattern pt;
        pt = Pattern.compile(("\\+[0-9]+"));
        Matcher m = pt.matcher(landLineNum);
        return m.matches();
    }

    public static boolean isValiComapnyName(String compName) {
        Pattern pt;
        pt = Pattern.compile("\\w*");
        Matcher m = pt.matcher(compName);
        return m.matches();
    }


}