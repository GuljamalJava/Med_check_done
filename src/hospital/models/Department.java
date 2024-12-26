package hospital.models;

import java.util.List;

public class Department {
  private  Long id;
  private String departmentName;
  private List<Doctor> doctors;


    public Department() {
    }

    public Department(List<Doctor> doctors, String departmentName, Long id) {
        this.departmentName = departmentName;
        this.doctors = doctors;
        this.id = id;

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", id=" + id +
                ", doctors=" + doctors+
                '}' +'\n';
    }
}

