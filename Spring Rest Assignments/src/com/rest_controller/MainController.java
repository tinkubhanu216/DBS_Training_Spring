package com.rest_controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest_model.Book;
import com.rest_model.Electricity;
import com.rest_model.Library;
import com.rest_model.LoginForm;
import com.rest_model.User;

@RestController
//@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/assign")
public class MainController {
	User user1=new User("admin","admin");
	User user2=new User("admin1","admin");
	User user3=new User("admin2","admin");
	
	static ArrayList<User> users=new ArrayList<User>();
	
	@RequestMapping(value="/validateuser",method=RequestMethod.POST)
	public String validateController(@RequestBody String data) throws ParseException{
		
		// parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(data); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
        String username = (String) jo.get("username"); 
        String password = (String) jo.get("password"); 
        if (username.equals("tinku") && password.equals("pass")) {
			return "Valid User";
		}else {
			return "Invalid User"; 
		}     
	}	
	@RequestMapping(value="/fullname",method=RequestMethod.GET)
	public String nameController(@RequestParam String fname,@RequestParam int lname){
		return fname+lname;
	}
	static ArrayList<Electricity> elearr=new ArrayList<Electricity>();
	@RequestMapping(value="/electricity/add",method=RequestMethod.GET)
	public ResponseEntity<String> elecController(@RequestParam int meter_no,@RequestParam int consumed_units,@RequestParam int costperunit,@RequestParam int amount,@RequestParam Date lastdate){
		Electricity ele=new Electricity(meter_no,consumed_units,costperunit,amount,lastdate);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@RequestMapping(value="/electricity/display",method=RequestMethod.GET)
	public String displayController(@RequestParam int meter_no){
		for( Electricity a : elearr) { 
			if (a.getMeter_no()==meter_no) {
				return a.toString();
			}
		}
		return "No records Found";
	}
	Library lib=new Library();
	@RequestMapping(value="/library/add_book",method=RequestMethod.GET)
	public String libaddController(@RequestParam int book_id,@RequestParam String book_name,@RequestParam String author_name){
		lib.addBook(book_id,book_name,author_name);
		return "Book Created";
	}
	@RequestMapping(value="/library/update_book",method=RequestMethod.GET)
	public String libupdateController(@RequestParam int book_id,@RequestParam String book_name,@RequestParam String author_name){
		lib.updateBook(book_id, book_name, author_name);
		return "Updated";
	}
	@RequestMapping(value="/library/delete_book",method=RequestMethod.GET)
	public String libdeleteController(@RequestParam int book_id){
		lib.deleteBook(book_id);
		return "Deleted";
	}
	@RequestMapping(value="/library/display",method=RequestMethod.GET)
	public String libdisplayController(@RequestParam int book_id){
		return lib.display(book_id).toString();
	}
	@RequestMapping(value="/library/displayall",method=RequestMethod.GET)
	public ArrayList<Book> libdisplayallController(){
		return lib.displayAll();
	}
	
	DAOController dao=new DAOController();
	@RequestMapping(value="/5",method=RequestMethod.POST)
	public String assignaController(@RequestBody String data) throws ParseException{
		
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
		// parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(data); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
        String username = (String) jo.get("username"); 
        String password = (String) jo.get("password");
		return dao.validateUser(username, password); 
	}
}
