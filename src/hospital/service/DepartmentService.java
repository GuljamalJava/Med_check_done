package hospital.service;

import hospital.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);

    void FindDepartmentById (Long id);


}
