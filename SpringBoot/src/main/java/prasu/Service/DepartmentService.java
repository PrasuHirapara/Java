package prasu.Service;

import prasu.Entity.Department;
import prasu.Error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long id) throws DepartmentNotFound;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);
}
