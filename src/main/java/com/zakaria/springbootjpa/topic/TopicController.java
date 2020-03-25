package com.zakaria.springbootjpa.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zakaria.springbootjpa.services.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void delete(@PathVariable String id) {
		topicService.delete(id);
	}
}

