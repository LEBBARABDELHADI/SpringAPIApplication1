package io.tutospringjava.springbootquickstart.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tutospringjava.springbootquickstart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/Topics/{topicId}/Courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);				
				
	}
	@RequestMapping("/Topics/{topicId}/Courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Topics/{topicId}/Courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Topics/{topicId}/Courses/{id}")
	public void removeCourses(@PathVariable String id) {
		
		
		//	topicService.deleteTopic(topic,id);
		courseService.deleteCourse(id);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,  value="/Topics/{topicId}/Courses/{id}")
	public void updateCourses(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"","")); 
		
		courseService.updateCourse(course);
		
		
	}
}
