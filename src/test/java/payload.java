public class payload {

    public static String place(String place){

        if (place!=null)
        return ("{\n" +
                "    \"locale\": \"" + place +"\" \n" +
                "}");
        else
            return ("{\n" +
                    "    \"locale\": null\n" +
                    "}");

    }
}
