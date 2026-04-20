package com.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.repository.EventRepository;

@Service
public class EventService{
	@Autowired
	EventRepository eventRepository;
	
	
}
