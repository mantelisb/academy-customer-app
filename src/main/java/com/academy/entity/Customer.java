package com.academy.entity;


public class Customer {

    public static class Builder {
        private String id;

        //Mandatory
        private String firstName;
        private String lastName;
        private String personalNumber;

        //Optional
        private String middleName;
        private int age;
        private String countryCode;
        private String city;
        private int monthlyIncome;
        private String employer;
        private String gender;
        private String maritalStatus;

        public Builder(String firstName, String lastName, String personalNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.personalNumber = personalNumber;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.firstName = firstName;
            customer.lastName = lastName;
            customer.personalNumber = personalNumber;
            customer.middleName = middleName;
            customer.age = age;
            customer.countryCode = countryCode;
            customer.city = city;

            return customer;
        }


    }

    private String id;

    //Mandatory
    private String firstName;
    private String lastName;
    private String personalNumber;

    //Optional
    private String middleName;
    private int age;
    private String countryCode;
    private String city;
    private int monthlyIncome;
    private String employer;
    private String gender;
    private String maritalStatus;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getGender() {
        return gender;
    }

    public String getEmployer() {
        return employer;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setId(String id) {
        this.id = id;
    }
}
