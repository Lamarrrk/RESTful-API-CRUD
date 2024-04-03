package com.example.restfulapi.repo;

import com.example.restfulapi.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tasks", path = "tasks")
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
}

