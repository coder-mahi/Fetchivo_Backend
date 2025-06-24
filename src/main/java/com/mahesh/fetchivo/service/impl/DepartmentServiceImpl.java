//package com.mahesh.fetchivo.service.impl;
//
//import com.mahesh.fetchivo.entity.Department;
//import com.mahesh.fetchivo.repository.DepartmentRepository;
//import com.mahesh.fetchivo.service.DepartmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DepartmentServiceImpl implements DepartmentService {
//
//    @Autowired
//    private DepartmentRepository repo;
//
//    @Override
//    public Department saveDepartment(Department department) {
//        return repo.save(department);
//    }
//
//    @Override
//    public List<Department> fetchDepartmentList() {
//        return (List<Department>) repo.findAll();
//    }
//
//    @Override
//    public Department updateDepartment(Department newDept, Long departmentId) {
//        Department old = repo.findById(departmentId)
//                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + departmentId));
//
//        old.setDepartmentName(newDept.getDepartmentName());
//        old.setDepartmentAddress(newDept.getDepartmentAddress());
//        old.setDepartmentCode(newDept.getDepartmentCode());
//
//        return repo.save(old);
//    }
//
//    @Override
//    public void deleteDepartmentById(Long departmentId) {
//        repo.deleteById(departmentId);
//    }
//}

// Java Program to Demonstrate DepartmentServiceImpl.java
// File

// Importing required package modules
package com.mahesh.fetchivo.service.impl;

import com.mahesh.fetchivo.entity.Department;
import com.mahesh.fetchivo.repository.DepartmentRepository;
import java.util.List;
import java.util.Objects;

import com.mahesh.fetchivo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service

// Class
public class DepartmentServiceImpl
        implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Save operation
    @Override
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }

    // Read operation
    @Override public List<Department> fetchDepartmentList()
    {
        return (List<Department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
}