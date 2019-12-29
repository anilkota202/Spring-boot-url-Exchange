package com.capg.cap.controller;

import java.util.ArrayList;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.cap.ipaddress.IPAdressTrack;
import com.capg.cap.mail.GmailMsg;
import com.capg.cap.mail.Mailsend;
@RestController
public class Empcontroller {
	@Autowired
	private IPAdressTrack ipadresstrack;
	
	GmailMsg gmailmsg=new GmailMsg();

	
	@GetMapping("/Emp/{id}")
	public List<String> Employer(@PathVariable ("id") int id) {
		 getEmployees(id);
		return getEmployees(id) ;
		
	}
	public  List<String> getEmployees(int id)
	{
		List<String> li=new ArrayList<String>();
	     String uri = "http://localhost:8081/talcott/stfindid/"+id;

	    RestTemplate restTemplate = new RestTemplate();
	    String str = restTemplate.getForObject(uri, String.class);
	    JSONObject bookList = new JSONObject(str);
	   
	    System.out.println(bookList);
	   li.add(bookList.get("mailid").toString());
	   li.add(bookList.get("firstname").toString());
	    return li;
	}
	@GetMapping("/test")
	public String Employer() {
		 //getEmployees(id);
		System.out.println(ipadresstrack.getClientIp());
		gmailmsg.sendmail();
		System.out.println("sent");

		return "sucess";
		
	}
	
	
	
}
