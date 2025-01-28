package com.app.todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.Model.Task;

@Repository
public interface TodoRepository extends JpaRepository<Task,Integer>{

	
}
