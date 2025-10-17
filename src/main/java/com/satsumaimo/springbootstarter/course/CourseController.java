package com.satsumaimo.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.satsumaimo.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourse(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	} 
	
	/**
	 * Create a course record in the database with id, name, description as sent in the JSON request body.
	 * The topic associated with the request body {@code course} will be overwritten with an empty one whose
	 * id is {@code topicId} from the path parameter. The {@code topicId} should point to an existing
	 * topic record in the database, or else HTTP 500 Internal Server Error will be shown.
	 * @param course the new course to add to the database
	 * @param topicId the id of an existing topic in the database to bind the {@code course} with.
	 * @throws EntityNotFoundException if the {@code topicId} is not found in the database
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/**
	 * Update a course record in the database with id, name, description as sent in the JSON request body.
	 * The topic associated with the request body {@code course} will be overwritten with an empty one whose
	 * id is {@code topicId} from the path parameter. The {@code topicId} should point to an existing
	 * topic record in the database, or else HTTP 500 Internal Server Error will be shown.
	 * @param course the course to update to the database
	 * @param topicId the id of an existing topic in the database to bind the {@code course} with.
	 * @throws EntityNotFoundException if the {@code topicId} is not found in the database
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	/**
	 * Delete a course record in the database with the path parameter {@code id}.
	 * If a course with id equal to {@code id} is not found in the database, nothing is done.
	 * If such course is found, it will be deleted.
	 * Note: {@code topicId} is not used and need not be correct or existing.
	 * @param id the id of the course to remove from the database
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
