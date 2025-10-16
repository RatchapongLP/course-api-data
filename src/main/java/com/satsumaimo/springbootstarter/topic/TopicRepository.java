package com.satsumaimo.springbootstarter.topic;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

// No @Repository needed
public interface TopicRepository extends JpaRepository<Topic, String> {
//public interface TopicRepository extends CrudRepository<Topic, String> {
	
	// No need to manually create these CRUD methods
	
//	public List<Topic> getAllTopics() {
//		return null;
//	}
//	
//	public Topic getTopic(String id) {
//		return null;
//	}
//	
//	public void updateTopic(Topic topic) {
//		
//	}
	// Other basic operations
}
