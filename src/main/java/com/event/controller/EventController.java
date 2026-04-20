package com.event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.entity.Event;
import com.event.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
	@Autowired
	EventService eventService;
	
	//used to send the data to database
	@PostMapping
	public ResponseEntity<?> creteEvent(@RequestBody Event event)
	{
		Event savedEvent=eventService.saveEvent(event);
		
		HashMap<String,Object> response=new HashMap<>();
		response.put("event",savedEvent);
		
		return ResponseEntity.ok(response);
		
	}
	
	//Used to fetch all records
	@GetMapping("/all")
	public List<Event> getAllEvent()
	{
		return eventService.getAllEvents();
		
	}
	
	//Used to fetch the record by id
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventId(@PathVariable long id)
	{
		return eventService.getEventById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
				
		
	}
	
	
	
}

