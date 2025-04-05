package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data  // Lombok annotation for getters, setters, and toString
@Entity // Marks this as a JPA entity
@Table(name="students")  // Maps this class to the "students" table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments ID
    private Integer id;

    @Column(name="first_name")
    private String firstName;  // Changed to camelCase for standard naming

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="branch")
    private String branch;

    @Column(name="section")
    private String section;

    @Column(name="joining_year")
    private String joiningYear;

    @Column(name="passout_year")
    private String passoutYear;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setJoiningYear(String joiningYear) {
        this.joiningYear = joiningYear;
    }

    public void setPassoutYear(String passoutYear) {
        this.passoutYear = passoutYear;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public void setBacklogs(Integer backlogs) {
        this.backlogs = backlogs;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }

    @Column(name="cgpa")
    private Double cgpa;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBranch() {
        return branch;
    }

    public String getSection() {
        return section;
    }

    public String getJoiningYear() {
        return joiningYear;
    }

    public String getPassoutYear() {
        return passoutYear;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public Integer getBacklogs() {
        return backlogs;
    }

    public Integer getFailures() {
        return failures;
    }

    @Column(name="backlogs")
    private Integer backlogs;

    @Column(name="failures")
    private Integer failures;
}
