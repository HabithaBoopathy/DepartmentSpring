package com.crud.operations.service;

import com.crud.operations.model.Department;
import com.crud.operations.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;

    private List<Department> departmentList = new CopyOnWriteArrayList<>();
    public Department addDepartment(Department department)
    {
        return departmentRepository.insert(department);
    }
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public  Department getDepartment(String id){
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }

    public String deleteDepartment(String id){
        departmentRepository.deleteById(id);
        return "Success";}

    public Department updateDepartment(Department department){

        return departmentRepository.save(department);}


}
