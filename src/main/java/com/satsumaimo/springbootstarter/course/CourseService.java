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
		// The 'course' has the 'topic' foreign key as empty-data except for the topicId.
		// But the JPA repository auto-search the particular topic from the Topic table 
		// using the topicId, then it maps the existing topic row to the new course record.
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
