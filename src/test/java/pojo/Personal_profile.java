package pojo;

public class Personal_profile
{
    private String first_name;

    private String last_name;

    private String date_of_birth;

    private String mobile_phone;

    private String national_id;

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public void setDate_of_birth(String date_of_birth){
        this.date_of_birth = date_of_birth;
    }
    public String getDate_of_birth(){
        return this.date_of_birth;
    }
    public void setMobile_phone(String mobile_phone){
        this.mobile_phone = mobile_phone;
    }
    public String getMobile_phone(){
        return this.mobile_phone;
    }
    public void setNational_id(String national_id){
        this.national_id = national_id;
    }
    public String getNational_id(){
        return this.national_id;
    }
}
