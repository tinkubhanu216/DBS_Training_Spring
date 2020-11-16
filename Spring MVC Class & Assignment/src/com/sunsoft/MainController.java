package com.sunsoft;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class MainController {
	//assign 1
	@RequestMapping("/display")
	public ModelAndView displayUsernameController(HttpServletRequest request,HttpServletResponse response) {
		String name=request.getParameter("username");
		
		String message="Welcome,"+name;
		return new ModelAndView("hellopage","message",message);
		
	}
	//assign 2
	@RequestMapping("/displayEmployee")
	public String displayEmployeeController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		if(id.equals("1234") && password.equals("bhanu")) {
			m.addAttribute("name","bhanu");
			m.addAttribute("id", 12345);
			m.addAttribute("dept","FR");
			m.addAttribute("designation", "Senior Officer");
			return "displayEmployee";
		}else {
			return "errorPage";
		}
	}
	
	//assign 3
	@RequestMapping("/empsalary/{id}/{name}/{basic}/{hra}/{da}/{it}/{deduction}")
	public String helloWorld( @PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("basic") int basic,@PathVariable("hra") int hra,@PathVariable("da") int da,@PathVariable("it") int it,@PathVariable("deduction") int deduction, Model m)
	{
		if(id==1234) {
			int gross_salary=basic+hra+da+it;
			int net_salary=gross_salary-deduction;
		    m.addAttribute("gross_salary",gross_salary);
		    m.addAttribute("net_salary",net_salary);
		    m.addAttribute("id", id);
		    m.addAttribute("name",name);
		    return "displaysalary";
		}else {
			return "errorPage";
		}
	}
	
	//Assign 4
	ArrayList<Insurance> arr=new ArrayList();
	@RequestMapping("/addpolicy")
	public String addUserController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String policyNumber=request.getParameter("policyNumber");
		String name=request.getParameter("name");
		String tensure=request.getParameter("tensure");
		String amount=request.getParameter("amount");
		Insurance u1=new Insurance();
		u1.setName(name);
		u1.setAmount(Integer.parseInt(amount));
		u1.setPolicyNumber(Integer.parseInt(policyNumber));
		u1.setTensure(Integer.parseInt(tensure));
		arr.add(u1);
		return "add";
	}
	@RequestMapping("/displaypolicies")
	public String newController(Model m) {
		m.addAttribute("policies",arr);
		return "view";
	}
	@RequestMapping("/add")
	public String addController(Model m) {
		return "add";
	}
	
	//Assign 5
	private ArrayList<Student> students=new ArrayList();	
	@RequestMapping("/read")
	public String readController(Model m) {
		m.addAttribute("students",students);
		return "read";
	}
	@RequestMapping("/create")
	public String createController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String address=request.getParameter("address");
		Student stu=new Student();
		stu.setId(Integer.parseInt(id));
		stu.setBranch(branch);
		stu.setAddress(address);
		stu.setName(name);
		students.add(stu);
		return "redirect:read";
	}
	@RequestMapping("/update")
	public String updateController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String address=request.getParameter("address");
		for( Student a : students) { 
			if (a.getId()==Integer.parseInt(id)) {
				a.setName(name);
				a.setBranch(branch);
				a.setAddress(address);
			}
		}
		return "redirect:read";
	}
	@RequestMapping("/delete")
	public String deleteController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String id=request.getParameter("id");
		Iterator<Student> itr = students.iterator();
		while (itr.hasNext()) {
		    Student stu = itr.next();
		    if (stu.getId()==Integer.parseInt(id)) {
		       itr.remove();
		    }
		}
		return "redirect:read";
	}
	//classwork
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest req, HttpServletResponse res,Model m)
	{
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(password.equals("admin")) {
			String msg = "Welcome" + name + "!!";
			m.addAttribute("message",msg);
			return "hellopage";
		}
		else
		{
			m.addAttribute("msg","Incorrect Credentials Entered please try again");
			return "errorPage";
		}
	}
}
