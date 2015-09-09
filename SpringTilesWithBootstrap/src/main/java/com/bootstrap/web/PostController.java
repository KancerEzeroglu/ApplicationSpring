package com.bootstrap.web;

import model.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PostController {
	
	@RequestMapping(value="/studentPost", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<Student> get(){
		Student st =new Student();
		
		st.setName("kancer2");
		st.setSurname("gokirmak2");
		st.setAge(77);
		
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/studentPost", method = RequestMethod.POST)
	public ResponseEntity<Student> update(@RequestBody Student stu){
		
		if(stu != null){
			stu.setAge(stu.getAge()+34);
		}
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}*/
	
}
