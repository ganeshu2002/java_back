package com.example.employeecrud.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate doj;

    private Integer age;
    private String address;

    @JsonProperty("mobileNo") // Accepts "mobileNo" from JSON
    private String mobile;

    private String city;
    private String state;
    private String country;

    @ElementCollection
    @CollectionTable(name = "employee_education", joinColumns = @JoinColumn(name = "employee_id"))
    private List<Education> education;

    // ✅ Inner class for Education
    @Embeddable
    public static class Education {
        private String level;
        private String schoolOrCollegeName;
        private String obtainedScore;
        private String totalScore;
        private String percentage;

        // Getters and Setters
        public String getLevel() {
            return level;
        }
        public void setLevel(String level) {
            this.level = level;
        }

        public String getSchoolOrCollegeName() {
            return schoolOrCollegeName;
        }
        public void setSchoolOrCollegeName(String schoolOrCollegeName) {
            this.schoolOrCollegeName = schoolOrCollegeName;
        }

        public String getObtainedScore() {
            return obtainedScore;
        }
        public void setObtainedScore(String obtainedScore) {
            this.obtainedScore = obtainedScore;
        }

        public String getTotalScore() {
            return totalScore;
        }
        public void setTotalScore(String totalScore) {
            this.totalScore = totalScore;
        }

        public String getPercentage() {
            return percentage;
        }
        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }
    }

    // ✅ Getters and Setters for Employee
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }
    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<Education> getEducation() {
        return education;
    }
    public void setEducation(List<Education> education) {
        this.education = education;
    }
}
