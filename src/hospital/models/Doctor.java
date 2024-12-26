package hospital.models;

import hospital.enums.Gender;

import java.time.LocalDate;

public class Doctor {
 private Long id;
 private String firstName;
 private String lastName;
 private Gender gender;
 private LocalDate experienceYear;

    public Doctor() {
    }

    public Doctor(String firstName, Gender gender, Long id) {
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
    }

    public Doctor(LocalDate experienceYear, String firstName, Gender gender, Long id, String lastName) {
        this.experienceYear = experienceYear;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.lastName = lastName;
    }

    public LocalDate getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(LocalDate experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "experienceYear=" + experienceYear +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}'+'\n';
    }
}
