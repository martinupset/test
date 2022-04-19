package com.example.demojpa.repository;

import com.example.demojpa.entity.Emp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends CrudRepository<Emp,Long> {
  @Query(value ="select * from emp where name like :name",nativeQuery = true)
  List<Emp> findEmpByName(@Param("name") String name);

  @Query(value ="select * from emp where salary >= :salary",nativeQuery = true)
  List<Emp> findSalaryGreater(@Param("salary") Double salary);
}
