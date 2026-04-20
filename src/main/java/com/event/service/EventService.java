package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.event.entity.Event;
import com.event.repository.EventRepository;

@Service
public class EventService{
	@Autowired
	EventRepository eventRepository;

	public Event saveEvent(Event event) {
		
		return eventRepository.save(event);
	}

	public List<Event> getAllEvents() {
		
		return eventRepository.findAll();
	}
	
	public Optional<Event> getEventById(Long id)
	{
		return eventRepository.findById(id);
		
	}
	
	
}
