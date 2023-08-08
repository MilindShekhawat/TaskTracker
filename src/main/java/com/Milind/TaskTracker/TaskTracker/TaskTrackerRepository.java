package com.Milind.TaskTracker.TaskTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Extends JpaRepository to make use of inbuilt functions, TaskTracker is extensively used in TaskTrackerService
@Repository
public interface TaskTrackerRepository extends JpaRepository<TaskTracker, String> {
}
