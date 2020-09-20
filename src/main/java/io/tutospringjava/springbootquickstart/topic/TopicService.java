package io.tutospringjava.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	 private TopicRepository topicrepository;
	
	
	
	
	public List<Topic> getAllTopic()
	{
		
		List<Topic> lis =new ArrayList<>();
		topicrepository.findAll()
		.forEach(lis::add);
		return lis;
		
		//return topics;
	}
	
	public Topic getTopic(String id) {
		
		return topicrepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		 topicrepository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		topicrepository.save(topic);
	}

	public void deleteTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		topicrepository.deleteById(id);
		
		
		
	} 


	

}
