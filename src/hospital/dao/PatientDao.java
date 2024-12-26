package hospital.dao;

import hospital.models.Patient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PatientDao {
    String addPatientsToHospital(Long id,List<Patient> patients);

    Optional<Patient> getPatientById(Long id);

    Map<Integer, Patient> getPatientByAge();

    List<Patient> sortPatientsByAge(String ascOrDesc);
}
