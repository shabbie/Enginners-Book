package com.gtu.EngBook.controller;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(value="/user")
public class UserController
{

	@Autowired
	UserService userService;

	@RequestMapping(value="/register/student")
	public Map<String, Object> studentregister(@RequestBody Map<String, Object> req)
	{
		StudentModel studentModel=new StudentModel();
		UserModel userModel=new UserModel();
		DepartmentModel departmentModel=new DepartmentModel();


		studentModel.setEnroll_no(Long.parseLong( req.get("enroll").toString()));
		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());
		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
		userModel.setDob((Date)(req.get("dob")));
		userModel.setAddress(req.get("addr").toString());
		userModel.setContact((long) req.get("contact"));
		userModel.setEmail(req.get("email").toString());
		departmentModel.setDept_name(req.get("dept").toString());
		req.get("col").toString();
		String univ = req.get("univ").toString();
		int yop= (int) req.get("yop");
		String pass = req.get("pass").toString();

		boolean result=userService.studentRegister(studentModel);




		return req;
	}
	
	@RequestMapping(value="/register/faculty")
	public Map<String, Object> facultyregister(@RequestBody Map<String, Object> req)
	{
		FacultyModel facultyModel=new FacultyModel();
		UserModel userModel=new UserModel();

		facultyModel.setEnroll_no(Long.parseLong( req.get("enroll").toString()));
		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());
		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
		userModel.setDob((Date)(req.get("dob")));
		userModel.setAddress(req.get("addr").toString());
		userModel.setContact((long) req.get("contact"));
		userModel.setEmail(req.get("email").toString());


		String dept = req.get("dept").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/hod")
	public Map<String, Object> hodregister(@RequestBody Map<String, Object> req)
	{
		HodModel hodModel=new HodModel();
		UserModel userModel=new UserModel();

		hodModel.setEnroll_no(Long.parseLong( req.get("enroll").toString()));
		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());
		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
		userModel.setDob((Date)(req.get("dob")));
		userModel.setAddress(req.get("addr").toString());
		userModel.setContact((long) req.get("contact"));
		userModel.setEmail(req.get("email").toString());


		String dept = req.get("dept").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/principal")
	public Map<String, Object> principalregister(@RequestBody Map<String, Object> req)
	{
		CollegeModel collegeModel=new CollegeModel();
		UserModel userModel=new UserModel();

		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());
		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
		collegeModel.setWebsite(req.get("website").toString());
		collegeModel.setTpo_name(req.get("tponame").toString());

		userModel.setDob((Date)(req.get("dob")));
		userModel.setAddress(req.get("addr").toString());
		userModel.setContact((long) req.get("contact"));
		userModel.setEmail(req.get("email").toString());

		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/chancellor")
	public Map<String, Object> chancellorregister(@RequestBody Map<String, Object> req)
	{

		UserModel userModel=new UserModel();

		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());

		String univname = req.get("univname").toString();
		String univwebsite = req.get("univwebsite").toString();

		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
		userModel.setDob((Date)(req.get("dob")));
		userModel.setAddress(req.get("addr").toString());
		userModel.setContact((long) req.get("contact"));
		userModel.setEmail(req.get("email").toString());

		String pass = req.get("pass").toString();

		return req;
	}

	@RequestMapping(value="/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> req)
	{
		UserModel um=new UserModel();
		um.setPassword(req.get("password").toString());
		um.setEmail(req.get("email").toString());

		req.put("response",userService.login(um));


		return req;
	}
}
