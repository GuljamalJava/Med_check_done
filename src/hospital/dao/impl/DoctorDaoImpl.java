package hospital.dao.impl;

import hospital.dao.DoctorDao;
import hospital.dao.GenericDao;
import hospital.db.DataBase;
import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements GenericDao<Doctor, Long>, DoctorDao {
    @Override
    public String add(Long hospitalId, Doctor newDoctor) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getDoctors().add(newDoctor);
            }
        }

        return "Successfully added new Doctor to hospital " + newDoctor;
    }

    @Override
    public void removeById(Long doctorId) {
        boolean is = false;
        for (Hospital hospital : DataBase.hospitalList) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(doctorId)) {
                    is = true;
                    hospital.getDoctors().remove(doctor);
                    System.out.println("Successfully removed!");
                    break;
                }
            }
        }
        if (!is) {
            System.out.println("The doctor wasn't remove");
        }
    }


    @Override
    public String updateById(Long id, Doctor newDoctor) {
        if (DataBase.hospitalList != null) {
            for (Hospital hospital : DataBase.hospitalList) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(id)) {
                        doctor.setFirstName(newDoctor.getFirstName());
                        doctor.setLastName(newDoctor.getLastName());
                        doctor.setGender(newDoctor.getGender());
                        doctor.setExperienceYear(newDoctor.getExperienceYear());
                        return "Successfully Doctor updated with id" + id;
                    }
                }
            }
        }
        return "not found id" + id;
    }


    @Override
    public Doctor findDoctorById(Long doctorId) {
        if (DataBase.hospitalList != null) {
            for (Hospital hospital : DataBase.hospitalList) {
                for (Doctor doctor : hospital.getDoctors()) {
                    if (doctor.getId().equals(doctorId)) {
                        return doctor;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Long aLong : doctorsId) {
            doctors.add(findDoctorById(aLong));
        }
        for (Hospital hospital : DataBase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    department.setDoctors(doctors);
                    return "Successfully assinged Doctor to Department";
                }
            }
        }
        return "not found departament id"+ departmentId;
    }



    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long hospitalId) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                return hospital.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long departmentId) {
        for (Hospital hospital : DataBase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    return department.getDoctors();
                }
            }
        }
        return null;
    }
}
