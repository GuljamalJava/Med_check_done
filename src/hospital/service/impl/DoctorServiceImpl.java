package hospital.service.impl;

import hospital.dao.impl.DoctorDaoImpl;
import hospital.models.Doctor;
import hospital.service.DoctorService;
import hospital.service.GenericService;

import java.util.List;

public class DoctorServiceImpl implements GenericService <Doctor,Long>,DoctorService{

    private  final DoctorDaoImpl doctorDao;

    public DoctorServiceImpl(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        return doctorDao.add(hospitalId,doctor);
    }

    @Override
    public void removeById(Long id) {
       doctorDao.removeById(id);
    }


    @Override
    public String updateById(Long id, Doctor doctor) {
        return doctorDao.updateById(id,doctor);
    }


    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }
}
