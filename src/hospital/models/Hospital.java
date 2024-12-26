package hospital.models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Long id;
    private String hospitalName;
    private String address;
    private List<Department> departments;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients;

    public Hospital() {
    }

    public Hospital(Long id, String hospitalName) {
        this.id = id;
        this.hospitalName = hospitalName;
    }

    public Hospital(String address, List<Department> departments, List<Doctor> doctors, String hospitalName, Long id, List<Patient> patients) {
        this.address = address;
        this.departments = departments;
        this.doctors = doctors;
        this.hospitalName = hospitalName;
        this.id = id;
        this.patients = patients;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "             Hospital              " +
                "address:       '" + address + '\n' +
                ", id:          " + id +'\n'+
                ", hospitalName:'" + hospitalName + '\n' +
                ", departments:" + departments +'\n'+
                ", doctors=" + doctors +'\n'+
                ", patients=" + patients+'\n'+
                '}'+'\n';
    }
}


