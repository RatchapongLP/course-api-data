package com.satsumaimo.springbootstarter.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

// No @Repository needed
public interface CourseRepository extends JpaRepository<Course, String> {
//public interface CourseRepository extends CrudRepository<Course, String> {
	
	// Declare a method following the method name conventions:
	// find: for SELECT
	// All: for no conditions
	// By<camel_cased_field>: for specifying in the WHERE condition
	
	// Special case: Course doesn't have a field 'topicId'
	// but we don't want to do - findByTopic(Topic topic) - either.
	// JPA provides the auto-chained searching to the Topic tables.
	// With topicId provided, the Topic is retrieved, which is subsequently
	// used for searching in the Course tables.
	public List<Course> findByTopicId(String topicId);
}
