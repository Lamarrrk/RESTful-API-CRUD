package com.example.restfulapi.repo;

import com.example.restfulapi.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository <Tasks, Integer> {

}
