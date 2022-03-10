package com.academy.entity;


import lombok.*;

@Builder(builderMethodName = "hiddenBuilder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class Customer {

    @Setter
    private String id;

    //Mandatory

    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String personalNumber;

    //Optional
    private String middleName;
    private int age;
    private String countryCode;
    private String city;
    private int monthlyIncome;
    private String employer;
    private String gender;
    private String maritalStatus;

    public static CustomerBuilder builder(String firstName, String lastName, String personalNumber) {
        return hiddenBuilder().firstName(firstName).lastName(lastName).personalNumber(personalNumber);
    }

}
