package io.tutospringjava.springbootquickstart.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	 private LessonRepository lessonepository;
	
	
	
	
	public List<Lesson> getAllLesons(String courseId)
	{
		
		List<Lesson> courses =new ArrayList<>();
		lessonepository.findByCourseId(courseId)
		.forEach(courses::add);
		return courses;
		
		//return topics;
	}
	
	public Lesson getLesson(String lessonId) {
		
		return lessonepository.findById(lessonId).get();
	}

	public void addLesson(Lesson course) {
		lessonepository.save(course);
	}
	
	public void updateLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		lessonepository.save(lesson);
	}

	public void deleteLesson(String id) {
		// TODO Auto-generated method stub
		lessonepository.deleteById(id);
		
		
		
	} 


	

}
