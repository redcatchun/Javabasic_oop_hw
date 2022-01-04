package service;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> employeeList;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
    }

    /**
     * @description: Them nhan vien vao danh sach nhan vien
     * @param: nhan vien
     * @return:
     */
    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
        Employee.count = employeeList.size();
    }

    /**
     * @description: Tim nhan vien theo
     * @param:
     * @return:
     */
    public Employee findById(String id) {
        return this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * @description: Xoa nhan vien theo id
     * @param: id
     * @return: true/false
     */
    public boolean deleteById(String id) {
        Employee employee = this.findById(id);
        if (employee == null) {
            return false;
        }
        employeeList.remove(employee);
        return true;
    }

    /**
     * @description: Tim kieu danh sach nhan vien theo kieu
     * @param: type
     * @return: list
     */
    public List<Employee> findByType(int type) {
        return this.employeeList.stream()
                .filter(e -> {
                    if (type == 1) {
                        return e instanceof Experience;
                    }
                    if (type == 2) {
                        return e instanceof Fresher;
                    }
                    if (type == 3) {
                        return e instanceof Intern;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<Employee> findAll() {
        return this.employeeList;
    }
}
