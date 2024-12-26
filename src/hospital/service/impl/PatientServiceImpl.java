package hospital.service.impl;

import hospital.dao.impl.PatientDaoImpl;
import hospital.models.Patient;
import hospital.service.GenericService;
import hospital.service.PatientService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PatientServiceImpl implements GenericService<Patient,Long>, PatientService {
 private final PatientDaoImpl patientDao;

    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDao.addPatientsToHospital(id,patients);
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        return patientDao.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
      patientDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientDao.updateById(id,patient);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    public Map<Integer, Patient> getPatientByAge() {
        return patientDao.getPatientByAge();
    }


    public List<Patient> sortPatientsByAge(String ascOrDesc) {
     return patientDao.sortPatientsByAge(ascOrDesc);
    }
}


