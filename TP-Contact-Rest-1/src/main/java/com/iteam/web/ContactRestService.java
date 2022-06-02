package com.iteam.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iteam.DAO.ContactRepository;
import com.iteam.Entity.Contact;

@RestController
public class ContactRestService {

	@Autowired
	private ContactRepository contactRepository;
@GetMapping("/Contacts")
public List <Contact> ListContact() {
	List<Contact> ListContact=contactRepository.findAll();
	return ListContact;	
}

@PostMapping("/Contacts")

public Contact CreateContact (@RequestBody Contact c) {
	
	return contactRepository.save(c);
}
@DeleteMapping("/Contacts/{id}")
public void DeleteContact(@PathVariable Long id) {
	contactRepository.deleteById(id);
}
@GetMapping("/Contacts/{nom}")

public List <Contact> FindContact(@PathVariable String nom){
	List <Contact> ListContacts=contactRepository.findByNom(nom);
	return ListContacts;
}

@PutMapping("/Contacts")
public Contact UpdateContact(@RequestBody Contact c) {
	return contactRepository.save(c);
}

@GetMapping("/Contacts/Count")

public int CountContact() {
	List<Contact> ListContact=contactRepository.findAll();
	return ListContact.size();
}







}


	

