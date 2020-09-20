package io.tutospringjava.springbootquickstart.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/Topics")
	public List<Topic> getTopic(){
		return topicService.getAllTopic();				
				
	}
	@RequestMapping("/Topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/Topics")
	public void addTopics(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Topics/{id}")
	public void removeTopics(@RequestBody Topic topic,@PathVariable String id) {
		
		
		//	topicService.deleteTopic(topic,id);
		topicService.deleteTopic( topic,  id);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Topics/{id}")
	public void updateTopics(@RequestBody Topic topic,@PathVariable String id) {
		
		
			topicService.updateTopic(topic, id);
		
		
	}
}
