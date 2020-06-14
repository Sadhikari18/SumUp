package pojo;

public class User {

        private String country;

        private Personal_profile personal_profile;

        private Address address;

        public void setCountry(String country){
            this.country = country;
        }
        public String getCountry(){
            return this.country;
        }
        public void setPersonal_profile(Personal_profile personal_profile){
            this.personal_profile = personal_profile;
        }
        public Personal_profile getPersonal_profile(){
            return this.personal_profile;
        }
        public void setAddress(Address address){
            this.address = address;
        }
        public Address getAddress(){
            return this.address;
        }
    }
