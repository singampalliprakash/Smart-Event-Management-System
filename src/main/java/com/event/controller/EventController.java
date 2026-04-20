package com.event.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@PostMapping
	public ResponseEntity<?> creteEvent(@RequestBody Event event)
	{
		Event savedEvent=EventService.saveEvent();
		
		HashMap<String,Object> response=new HashMap<>();
		response.put("event",savedEvent);
		
		return ResponseEntity.ok(response);
		
	}
	
	
}
