package hospital.dao.impl;

import hospital.dao.GenericDao;
import hospital.dao.HospitalDao;
import hospital.db.DataBase;
import hospital.models.Hospital;
import hospital.models.Patient;

import java.util.*;

public class HospitalDaoImpl implements GenericDao<Hospital,Long>, HospitalDao {
    @Override
    public String add(Long hospitalId, Hospital hospital) {
        for (Hospital hospital1 : DataBase.hospitalList) {
            if (hospital1.getId().equals(hospitalId)) {
                DataBase.hospitalList.add(hospital);
                return  "Successfully hospital added!"+hospital;
            }
        }
        return "not found hospital with id "+ hospitalId;
    }

    @Override
    public void removeById(Long hospitalId) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
            DataBase.hospitalList.remove(hospital);

            }
        }
    }

        //      Iterator<Hospital> iterator = DataBase.hospitalList.iterator();
        //        while(iterator.hasNext()){
//            Hospital hospital = iterator.next();
//            if(hospital.getId().equals(hospitalId)){
//                iterator.remove();
//            }else {
//                System.out.println("not found with this id!");
//            }

    @Override
    public String updateById(Long id, Hospital newHospital) {
//        if (DataBase.hospitalList != null) {
            for (Hospital hospital1 : DataBase.hospitalList) {
                if (hospital1.getId().equals(id)) {
                    hospital1.setHospitalName(newHospital.getHospitalName());
                    hospital1.setAddress(newHospital.getAddress());
                    hospital1.setDoctors(newHospital.getDoctors());
                    hospital1.setPatients(newHospital.getPatients());
                    hospital1.setDepartments(newHospital.getDepartments());
                    return "Successfully Updated hospital with!" + id;
                }
            }
            return "Not Found" + id;
    }

    @Override
    public String addHospital(Hospital hospital) {
        DataBase.hospitalList.add(hospital);
        return "Successfully  hospital added"+ hospital;
    }

    @Override
    public Hospital findHospitalById(Long hospitalId) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                 return hospital;
            }else {
                System.out.println("");
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
       List<Hospital> hospitals = DataBase.hospitalList;
        return hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long hospitalId) {
         for (Hospital hospital : DataBase.hospitalList) {
               if (hospital.getId().equals(hospitalId)) {
                   List<Patient> getAllPatients = hospital.getPatients();
                   return getAllPatients;
         //          return  getAllPatients==null ? getAllPatients : new ArrayList<>()  ;
               }
           }
           return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        Hospital hospital = findHospitalById(id);
        if (hospital != null) {
            DataBase.hospitalList.remove(hospital);
            return "Successfully deleted hospital by id " + id;
        }
        return "not found hospital with" + id;
    }



// ondop chygysh kerek
    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address){
        var allHospital = getAllHospital();
        for (Hospital hospital : allHospital) {
            Map<String,Hospital> hospitalMap= new LinkedHashMap<>();
            hospitalMap.put(address,hospital);
            return hospitalMap;
        }
        return null;
    }
}

