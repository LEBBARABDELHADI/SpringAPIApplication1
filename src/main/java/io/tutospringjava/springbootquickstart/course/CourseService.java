package io.tutospringjava.springbootquickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	 private CourseRepository topicrepository;
	
	
	
	
	public List<Course> getAllCourses(String topicId)
	{
		
		List<Course> courses =new ArrayList<>();
		topicrepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
		
		//return topics;
	}
	
	public Course getCourse(String id) {
		
		return topicrepository.findById(id).get();
	}

	public void addCourse(Course course) {
		 topicrepository.save(course);
	}
	
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		topicrepository.save(course);
	}

	public void deleteCourse(String id) {
		// TODO Auto-generated method stub
		topicrepository.deleteById(id);
		
		
		
	} 


	

}
