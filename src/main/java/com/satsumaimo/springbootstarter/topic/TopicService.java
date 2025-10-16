package com.satsumaimo.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopic() {
		return topicRepository.findAll();
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		// If the row exists, it does an update.
		// If the row does not, it does an insertion.
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
