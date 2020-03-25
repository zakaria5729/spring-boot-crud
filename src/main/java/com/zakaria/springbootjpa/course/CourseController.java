package com.zakaria.springbootjpa.course;

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

import com.zakaria.springbootjpa.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAlCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void create(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void delete(@PathVariable String id) {
		courseService.delete(id);
	}
}

