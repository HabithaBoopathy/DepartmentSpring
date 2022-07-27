package com.crud.operations.controller;

import com.crud.operations.model.Department;
import com.crud.operations.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@CrossOrigin(origins = "*")

public class DepartmentResource {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getDepartments() {
        System.out.println("get works");
        return departmentService.getDepartments();
    }

    @PostMapping
    public Boolean addDepartment(@RequestBody Department department) {

        try {
            System.out.println("add works");
            departmentService.addDepartment(department);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @PutMapping
    public Boolean updateDepartment(@RequestBody Department department) {
        try {
            departmentService.updateDepartment(department);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteHotel(@PathVariable("id") String id) {
        try {
            departmentService.deleteDepartment(id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}

