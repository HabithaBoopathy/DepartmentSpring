package com.crud.operations.repository;

import com.crud.operations.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {
   @Query(value = "{'departmentId':?0}")
   Department findByDepartmentId(int id);
}
