package hospital.dao;

import hospital.models.Doctor;

import java.util.List;

public interface DoctorDao {

    Doctor findDoctorById(Long id);

    // todo Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз

    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);

    List<Doctor> getAllDoctorsByHospitalId(Long id);

    List<Doctor> getAllDoctorsByDepartmentId(Long id);

}
