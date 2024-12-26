package hospital;

import hospital.dao.impl.DepartmentDaoImpl;
import hospital.dao.impl.DoctorDaoImpl;
import hospital.dao.impl.HospitalDaoImpl;
import hospital.dao.impl.PatientDaoImpl;
import hospital.enums.Gender;
import hospital.models.Department;
import hospital.models.Doctor;
import hospital.models.Hospital;
import hospital.models.Patient;
import hospital.service.impl.DepartmentServiceImpl;
import hospital.service.impl.DoctorServiceImpl;
import hospital.service.impl.HospitalServiceImpl;
import hospital.service.impl.PatientServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//           1)  Оорукана тууралу бир программа жазыныз.
//    todo             Dao жана Service менен иштешкиле (ар бир класстын dao жана service interface'тери жана ошол interface'ти implements класстары болуш керек).
//        Database деген класс ачып, ичинде бардык маалыматтарды сактаган маалымат структурасы болсун(List<Hospital> hospitals).
//
//           2) Класстар:
//    todo   * Hospital (Long id, String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients),
//       * Department (Long id, String departmentName, List<Doctor> doctors),
//       * Doctor (Long id, String firstName, String lastName, Gender gender, int experienceYear),
//       * Patient (Long id, String firstName, String lastName, int age, Gender gender);
//       3) Gender enum.
//
//          3) HospitalService :
//todo    String addHospital(Hospital hospital);
//        Hospital findHospitalById(Long id);
//        List<Hospital> getAllHospital();
//        List<Patient> getAllPatientFromHospital(Long id);
//        String deleteHospitalById(Long id);
//        Map <String, Hospital> getAllHospitalByAddress(String address);
//
//          4) GenericService : (Department, Doctor , Patient)
//     todo  String add(Long  hospitalId, T t);
//        void removeById(Long id);
//        String updateById(Long id, T t);
//
//           5) DepartmentService:
//todo    List<Department> getAllDepartmentByHospital(Long id);
//        Department findDepartmentByName(String name);
//        FindDepartmentById (Long id);
//
//          6) DoctorService:
//todo   Doctor findDoctorById(Long id);
////todo  Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан
//        ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
//
//  todo    String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);

// todo   List<Doctor> getAllDoctorsByHospitalId(Long id);
//        List<Doctor> getAllDoctorsByDepartmentId(Long id);
//
//         7) PatientService:
// todo   String addPatientsToHospital(Long id,List<Patient> patients);
//        Patient getPatientById(Long id);
//        Map<Integer, Patient> getPatientByAge();
//        List<Patient> sortPatientsByAge(String ascOrDesc);

        HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(hospitalDao);
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentDao);
        DoctorDaoImpl doctorDao = new DoctorDaoImpl();
        DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorDao);
        PatientDaoImpl patientDao = new PatientDaoImpl(hospitalDao);
        PatientServiceImpl patientService = new PatientServiceImpl(patientDao);

        Scanner scanner = new Scanner(System.in);
        boolean is = true;
        while (is){
            System.out.println("""
                   1.Add Hospital :
                   2.Find Hospital By Id :
                   3.Get All Hospital :
                   4.Get All Patient From Hospital :
                   5.Delete Hospital By Id :
                   6.Get All Hospital By Address :
                   7.Add department by Id :
                   8.Remove By Id :
                   9.Update By Id :
                   10.Get All Department By Hospital :
                   11.Find Department By Name :
                   12.Find Department By Id :
                   13.Add Doctor By Id :
                   14.Remove Doctor By Id:
                   15.Update Doctor by Id:
                   16.Find Doctor By Id:
                   17.Assign Doctor To Department:
                   18.Get All Doctors By Hospital Id:
                   19.Get All Doctors By Department Id:
                   20.Add Patient by Id:
                   21.Remove Patient by Id:
                   22.Update Patient by Id:
                   23.Add Patients to Hospital:
                   24.Get Patient By Id :
                   25.Get Patient By Age :
                   26.Sort Patients By Age :
                   """);
            switch (scanner.nextInt()){
                case 1->{
                    System.out.println("Add Hospital: ");
                    System.out.println(hospitalService.addHospital(new Hospital("fuchika / den seyapin",new ArrayList<>(),new ArrayList<>(),"",1L,new ArrayList<>())));
                    System.out.println(hospitalService.addHospital(new Hospital("Kievskaya/umetalieva",new ArrayList<>(),new ArrayList<>(),"Government Hospital nom:1",2L,new ArrayList<>())));
                    System.out.println(hospitalService.addHospital(new Hospital("Kievskaya/Tynystanova",new ArrayList<>(),new ArrayList<>()," nom:2",3L,new ArrayList<>())));
                    System.out.println(hospitalService.addHospital(new Hospital("Sovetskaya 233",new ArrayList<>(),new ArrayList<>(),"Stomologicheskaya poliklinika nom:6",4L,new ArrayList<>())));
                    System.out.println(hospitalService.addHospital(new Hospital("Nekrasova 34",new ArrayList<>(),new ArrayList<>(),"Gorodskaya Policlinika nom: 3",5L,new ArrayList<>())));
                }
                case 2->{
                    System.out.println("Find Hospital By Id: ");
                    System.out.println(hospitalService.findHospitalById(1L));
                }
                case 3->{
                    System.out.println("Get all Hospital: ");
                    System.out.println(hospitalService.getAllHospital());
                }
                case 4->{
                    System.out.println("Get all Patients From Hospital: ");
                    System.out.println(hospitalService.getAllPatientFromHospital(1L));
                }
                case 5->{
                    System.out.println("Delete Hospital By Id: ");
                    System.out.println(hospitalService.deleteHospitalById(1L));
                }
                case 6->{
                    System.out.println("Get All Hospital By Address: ");
                    System.out.println(hospitalService.getAllHospitalByAddress("Kievskaya/umetalieva"));
                }
                case 7->{
                    System.out.println("Add Department: ");
                    System.out.println(departmentService.add(2L, new Department( new ArrayList<>(),"Neurology", 1L)));
                    System.out.println(departmentService.add(2L, new Department(new ArrayList<>(), "Pediatrics", 2L)));
                    System.out.println(departmentService.add(2L, new Department(new ArrayList<>(), "Obstetrics", 3L)));
                    System.out.println(departmentService.add(2L, new Department(new ArrayList<>(), "Orthopedics", 4L)));
                    System.out.println(departmentService.add(2L, new Department(new ArrayList<>(), "Radiology", 5L)));
                }
                case 8 ->{
                    System.out.println("Remove Department By Id:");
                    departmentDao.removeById(4L);
                }
                case 9 ->{
                    System.out.println(" Update Department by Id:");
                    System.out.println(departmentDao.updateById(5L, new Department(new ArrayList<>(), "Cardiologia", 3L)));
                }
                case 10->{
                    System.out.println("Get All Departments By Hospital :");
                    System.out.println(departmentDao.getAllDepartmentByHospital(2L));
                }
                case 11->{
                    System.out.println("Find Department By Name:");
                    System.out.println(departmentDao.findDepartmentByName("Neurology"));
                }
                case 12->{
                    System.out.println("Find Department By Id: ");
                    System.out.println(departmentDao.FindDepartmentById(3L));
                }
                case 13 ->{
                    System.out.println("Add Doctor by id: ");
                    System.out.println(doctorService. add(1L,new Doctor(getExperience(LocalDate.of(2018,1,3),LocalDate.of(2024,12,2)),"Kunduz", Gender.FEMALE,1L,"Sadykova")));
                    System.out.println(doctorService.add(2L,new Doctor(getExperience(LocalDate.of(2017,11,10),LocalDate.of(2024,12,12)),"Guljamal", Gender.FEMALE,2L,"Shermatova")));
                    System.out.println(doctorService.add(3L,new Doctor(getExperience(LocalDate.of(2016,1,19),LocalDate.of(2024,1,10)),"Kubanych", Gender.MALE,3L,"Ibragimov")));
                    System.out.println(doctorService.add(4L,new Doctor(getExperience(LocalDate.of(2020,5,14),LocalDate.of(2024,4,16)),"Nuradil", Gender.MALE,4L,"Kubanuchbekova")));
                }
                case 14 ->{
                    System.out.println("Remove Doctor By Id: ");
                    doctorService.removeById(3L);
               }
               case 15 ->{
                   System.out.println("Update Doctor By Id: ");
                   System.out.println(doctorService.updateById(4L, new Doctor("Firdaus", Gender.FEMALE, 7L)));
               }
               case 16-> {
                    System.out.println("Find Doctor By Id:");
                    System.out.println(doctorService.findDoctorById(1L));
                }
                case 17 ->{
                    System.out.println("Assign Doctor To Department: ");
                    doctorService.assignDoctorToDepartment(1L,List.of(1L,2L,3L));
                }
                case 18->{
                    System.out.println("Get All Doctors By Hospital Id:");
                    System.out.println(doctorService.getAllDoctorsByHospitalId(3L));
                }
                case 19->{
                    System.out.println("Get All Doctors By Department Id:");
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(1L));
                }
                case 20->{
                    System.out.println("Add Patient:");
                    System.out.println(patientService.add(2L,new Patient(30,"Bermet",Gender.FEMALE,1L,"Aidadrova")));
                    System.out.println(patientService.add(2L,new Patient(50, "Jamilia", Gender.FEMALE, 2L, "Damirova")));
                    System.out.println(patientService.add(2L,new Patient(70, "Nurbek", Gender.MALE, 3L, "Jamalidinov")));
                    System.out.println(patientService.add(2L,new Patient(80, "Damir", Gender.MALE, 4L, "Maripov")));
                }
                case 21 ->{
                    System.out.println("Remove Patient By Id: ");
                    patientService.removeById(3L);
                }
                case 22 ->{
                    System.out.println("Update Patient By Id:");
                    System.out.println(patientService.updateById(2L, new Patient(40, "Aibek", Gender.MALE, 5L, "Nuruev")));
                }
                case 23 ->{
                    System.out.println("Add Patients to Hospital: ");
                    System.out.println(patientService.addPatientsToHospital(
                            3L, List.of(
                            new Patient(43,"Jurgal",Gender.MALE,6L,"Aidarova"),
                            new Patient(27,"Hadidja",Gender.FEMALE,7L,"Ulanova"),
                            new Patient( 19,"Aigul",Gender.FEMALE,8L,"Aidadrova"),
                            new Patient( 30,"Batyr",Gender.FEMALE,9L,"Aidadrova"))));
                }
                case 24->{
                    System.out.println("Get Patient By Id:");
                    System.out.println(patientService.getPatientById(7L));
                }
                case 25->{
                    System.out.println("Get Patient By Age:");
                    System.out.println(patientService.getPatientByAge());
                }
                case 26->{
                    System.out.println("Sort Patients By Age:");
                    System.out.println(patientService.sortPatientsByAge("asc"));
                    System.out.println(patientService.sortPatientsByAge("desc"));
                }

                default -> throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
            }
//





















        }


























    }
    public static LocalDate getExperience(LocalDate startDate,LocalDate currentDate){
        Period  period = Period.between(startDate,currentDate);
        return LocalDate.ofEpochDay(period.getYears());
    }
}