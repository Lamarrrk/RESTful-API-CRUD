package com.example.restulapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository <com.example.restulapi.model.tasks, Integer> {

}
