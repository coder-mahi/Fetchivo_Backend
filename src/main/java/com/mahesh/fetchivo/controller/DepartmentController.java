//package com.mahesh.fetchivo.controller;
//
//import com.mahesh.fetchivo.entity.Department;
//import com.mahesh.fetchivo.service.impl.DepartmentServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/department")
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentServiceImpl dept;
//
//    @GetMapping("/all")
//    public List<Department> getAllDepartments() {
//        return dept.fetchDepartmentList();
//    }
//
//    @PostMapping("/add")
//    public Department addDept(@RequestBody Department newDept) {
//        return dept.saveDepartment(newDept);
//    }
//
//    @PutMapping("/update/{deptid}")
//    public Department updateDept(@RequestBody Department updatedDept, @PathVariable("deptid") Long deptid) {
//        return dept.updateDepartment(updatedDept, deptid);
//    }
//
//    @DeleteMapping("/delete/{deptid}")
//    public void deleteDept(@PathVariable Long deptid) {
//        dept.deleteDepartmentById(deptid);
//    }
//}

// java Program to Illustrate DepartmentController File

// Importing required packages modules
package com.mahesh.fetchivo.controller;

import com.mahesh.fetchivo.entity.Department;
import com.mahesh.fetchivo.service.DepartmentService;
import java.util.List;
// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController

// Class
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
           @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}