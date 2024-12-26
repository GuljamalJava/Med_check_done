package hospital.service.impl;

import hospital.dao.impl.DepartmentDaoImpl;
import hospital.models.Department;
import hospital.service.DepartmentService;
import hospital.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements GenericService<Department,Long>,DepartmentService {
private final DepartmentDaoImpl departmentDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public String add(Long hospitalId, Department department) {
        return departmentDao.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
      departmentDao.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return departmentDao.updateById(id,department);
    }


    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }

    @Override
    public void FindDepartmentById(Long id) {
         departmentDao.FindDepartmentById(id);
    }
}
