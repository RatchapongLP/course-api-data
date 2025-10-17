package com.satsumaimo.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(String id) {
		return courseRepository.findByTopicId(id);
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		// From the CourseController,
		// The 'course' has the 'topic' foreign key as empty-fielded except for the topic's id.
		// But the JPA repository auto-search the particular topic from the Topic table 
		// using the topicId, then it injects the found topic record to create the new course record.
		
		// If no existing topic with id = topicId is found, a jakarta.persistence.EntityNotFoundException is thrown
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
		// If the row exists, it does an update.
		// If the row does not, it does an insertion.
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
