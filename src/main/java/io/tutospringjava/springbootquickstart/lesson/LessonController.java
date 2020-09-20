package io.tutospringjava.springbootquickstart.lesson;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.tutospringjava.springbootquickstart.course.Course;
import io.tutospringjava.springbootquickstart.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/Topics/{topicId}/Courses/{courseId}/Lessons")
	public List<Lesson> getAllLessons(@PathVariable String topicId,@PathVariable String courseId){
		return lessonService.getAllLesons(courseId);				
				
	}
	@RequestMapping("/Topics/{topicId}/Courses/{courseid}/Lessons/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId) {
		return lessonService.getLesson(lessonId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Topics/{topicId}/Courses/{courseid}/Lessons")
	public void addLesson(@RequestBody Lesson lesson,@PathVariable String topicId, @PathVariable String courseid) {
		
		lesson.setCourse(new Course(courseid,"","",new Topic(topicId,"","")));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Topics/{topicId}/Courses/{courseid}/Lessons/{lessonId}")
	public void removeLessons(@PathVariable String lessonId) {
		
		
		//	topicService.deleteTopic(topic,id);
		lessonService.deleteLesson(lessonId);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,  value="/Topics/{topicId}/Courses/{courseid}/Lessons/{lessonId}")
	public void updateCourses(@RequestBody Lesson lesson,@PathVariable String topicId,@PathVariable String courseid,@PathVariable String lessonId) {
		lesson.setCourse(new Course(courseid,"","",new Topic(topicId,"",""))); 
		
		lessonService.updateLesson(lesson);
		
		
	}
}
