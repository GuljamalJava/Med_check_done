package hospital.dao.impl;

import hospital.dao.DepartmentDao;
import hospital.dao.GenericDao;
import hospital.db.DataBase;
import hospital.models.Department;
import hospital.models.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDaoImpl implements GenericDao<Department, Long>, DepartmentDao {
    @Override
    public String add(Long hospitalId, Department newDep) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                hospital.getDepartments().add(newDep);
                return "Successfully added Department to Hospital" + newDep;
            }
        }
        return "Not found the hospital with id:" + hospitalId;
    }

    @Override
    public void removeById(Long departmentId) {
        for (Hospital hospital : DataBase.hospitalList) {
            List<Department> depToRemove = new ArrayList<>(hospital.getDepartments());
            for (Department department : depToRemove) {
                if (department.getId().equals(departmentId)) {
                    hospital.getDepartments().remove(department);
                    System.out.println("deleted");
                    break;
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Department newDep) {
        for (Hospital hospital : DataBase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    department.setDepartmentName(newDep.getDepartmentName());
                    department.setDoctors(newDep.getDoctors());
                    return "Successfully updated department with" + id + " " + newDep;
                }
            }
        }
        return "not found department with" + id;
    }

    public List<Department> getAllDepartmentByHospital(Long hospitalId) {
        for (Hospital hospital : DataBase.hospitalList) {
            if (hospital.getId().equals(hospitalId)) {
                return hospital.getDepartments();
            }
        }
        return null;
    }

    public Department findDepartmentByName(String name) {
        if (DataBase.hospitalList != null) {
            for (Hospital hospital : DataBase.hospitalList) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getDepartmentName().equals(name)) {
                        return department;
                    }
                }
            }
        }
        return null;
    }

    public Department FindDepartmentById(Long id) {
        if (DataBase.hospitalList != null) {
            for (Hospital hospital : DataBase.hospitalList) {
                for (Department department : hospital.getDepartments()) {
                    if (department.getId().equals(id)) {
                        return department;
                    }
                }
            }
        }
        return null;
    }
}
