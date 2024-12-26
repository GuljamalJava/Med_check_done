package hospital.dao.impl;

import hospital.dao.GenericDao;
import hospital.dao.PatientDao;
import hospital.db.DataBase;
import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.*;

public class PatientDaoImpl  implements GenericDao<Patient, Long>, PatientDao {
   private final HospitalDaoImpl hospitalDao = new HospitalDaoImpl();

    public PatientDaoImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getPatients().add(patient);
            }
        }
        return "Successfully added patient to hospital";
    }

    @Override
    public void removeById(Long id) {
        DataBase.hospitalList.forEach(h -> h.getPatients().removeIf(p -> p.getId().equals(id)));


    }

    @Override
    public String updateById(Long patientId, Patient newPatient) {
//    DataBase.hospitalList.forEach(h->h.getPatients().stream()
//            .filter(p->p.getId().equals(patientId)).peek(p->{
//                p.setId(newPatient.getId());
//                p.setAge(newPatient.getAge());
//                p.setFirstName(newPatient.getFirstName());
//                p.setLastName(newPatient.getLastName());
//                p.setGender(newPatient.getGender());}).
        for (Hospital hospital : DataBase.hospitalList) {
            for (Patient hospitalPatient : hospital.getPatients()) {
                if (hospitalPatient.getId().equals(patientId)) {
                    hospitalPatient.setFirstName(newPatient.getFirstName());
                    hospitalPatient.setLastName(newPatient.getLastName());
                    hospitalPatient.setAge(newPatient.getAge());
                    hospitalPatient.setGender(newPatient.getGender());
                    return "Successfully updated Patient" + patientId;
                }
            }
        }
        return "Patient with " + patientId + "not found!";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        List<Patient> patientList = new ArrayList<>();
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(id))
                hospital.getPatients().addAll(patientList);
            return "Successfully added Patients to Library with " + id;
        }
        return "Not found " + id;
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        if (DataBase.hospitalList != null) {
            for (Hospital hospital : DataBase.hospitalList) {
                if (hospital.getPatients() != null) {
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getId().equals(id)) {
                            return Optional.of(patient);
                        }
                    }
                }
            }

        }
        return Optional.empty();
    }
    @Override
    public Map<Integer, Patient> getPatientByAge() {
        for (Hospital hospital : DataBase.hospitalList) {
            for (Patient patient : hospital.getPatients()) {
                Map<Integer, Patient> patientMap = new HashMap<>();
                patientMap.put(patient.getAge(), patient);
                return patientMap;
            }
        }
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new LinkedList<>();
        if (DataBase.hospitalList == null) {
            for (Hospital hospital : DataBase.hospitalList) {
                if (hospital != null && hospital.getPatients() != null) {
                    patients.addAll(hospital.getPatients());

                    if (ascOrDesc.equalsIgnoreCase("asc")) {
                        patients.sort(new Comparator<Patient>() {
                            @Override
                            public int compare(Patient o1, Patient o2) {
                                return Integer.compare(o1.getAge(), o2.getAge());
                            }
                        });
                    }
                    if (ascOrDesc.equalsIgnoreCase("desc")) {
                        patients.sort(new Comparator<Patient>() {
                            @Override
                            public int compare(Patient o1, Patient o2) {
                                return Integer.compare(o2.getAge(), o1.getAge());
                            }
                        });
                    }
                }
            }
        }
        return patients;
    }
}
