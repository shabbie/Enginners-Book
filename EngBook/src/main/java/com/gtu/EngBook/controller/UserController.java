package com.gtu.EngBook.controller;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="/user")
public class UserController
{
	@Autowired
	UserService userService;

	@RequestMapping(value="/register/student")
	public Map<String, Object> studentregister(HttpServletRequest req)
	{
		StudentModel studentModel=new StudentModel();
		UserModel userModel=new UserModel();

		studentModel.setEnroll_no(Long.parseLong( req.getParameter("enroll")));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
    	userModel.setAddress(req.getParameter("addr"));
		userModel.setContact(Long.parseLong( req.getParameter("contact")));
		userModel.setEmail(req.getParameter("email"));

		studentModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
		studentModel.setColg_id(Integer.parseInt(req.getParameter("colg_id")));
		studentModel.setUnivId(Integer.parseInt(req.getParameter("univ_id")));

		studentModel.setYear_of_passing(Integer.parseInt( req.getParameter("yop")));
		userModel.setPassword(req.getParameter("pass"));


		return userService.studentRegister(userModel,studentModel);
	}
	
	@RequestMapping(value="/register/faculty")
	public Map<String, Object> facultyregister(HttpServletRequest req)
	{
		FacultyModel facultyModel=new FacultyModel();
		UserModel userModel=new UserModel();

		facultyModel.setEnroll_no(Long.parseLong( req.getParameter("enroll")));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact(Long.parseLong( req.getParameter("contact")));
		userModel.setEmail(req.getParameter("email"));
		facultyModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
        facultyModel.setColg_id(Integer.parseInt(req.getParameter("colg_id")));
        facultyModel.setUnivId(Integer.parseInt(req.getParameter("univ_id")));
        userModel.setPassword(req.getParameter("pass"));

		return userService.facultyRegister(userModel,facultyModel);
	}
	
	@RequestMapping(value="/register/hod")
	public Map<String, Object> hodregister(HttpServletRequest req)
	{
		HodModel hodModel=new HodModel();
		UserModel userModel=new UserModel();

		hodModel.setEnroll_no(Long.parseLong( req.getParameter("enroll")));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact(Long.parseLong( req.getParameter("contact")));
		userModel.setEmail(req.getParameter("email"));

        hodModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
        hodModel.setColg_id(Integer.parseInt(req.getParameter("colg_id")));
        hodModel.setUnivId(Integer.parseInt(req.getParameter("univ_id")));
        userModel.setPassword(req.getParameter("pass"));

        return userService.hodRegister(userModel,hodModel);


	}
	
	@RequestMapping(value="/register/principal")
	public Map<String, Object> principalregister(HttpServletRequest req)
	{
		CollegeModel collegeModel=new CollegeModel();
		UserModel userModel=new UserModel();

		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));

		collegeModel.setWebsite(req.getParameter("website"));
		collegeModel.setTpo_name(req.getParameter("tponame"));
		collegeModel.setColg_name(req.getParameter("colg_name"));

		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact((Long.parseLong( req.getParameter("contact"))));
		userModel.setEmail(req.getParameter("email"));

        collegeModel.setColgId(Integer.parseInt(req.getParameter("colg_id")));
        collegeModel.setUniv_id(Integer.parseInt(req.getParameter("univ_id")));

        userModel.setPassword(req.getParameter("pass"));

		return userService.principalRegister(userModel,collegeModel);
	}
	
	@RequestMapping(value="/register/chancellor")
	public Map<String, Object> chancellorregister(HttpServletRequest req)
	{

		UserModel userModel=new UserModel();
		UniversityModel universityModel=new UniversityModel();

		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));

		universityModel.setUniv_name(req.getParameter("univname"));
		universityModel.setWebsite(req.getParameter("univwebsite"));
		universityModel.setUniv_id(Integer.parseInt(req.getParameter("uniid")));

		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact((Long.parseLong( req.getParameter("contact"))));
		userModel.setEmail(req.getParameter("email"));
        userModel.setPassword(req.getParameter("pass"));

		return userService.chancellorRegister(userModel,universityModel);
	}

	@RequestMapping(value="/login")
	public Map<String, Object> login(HttpServletRequest req)
	{
		Map map=new HashMap<String, Object>();
		map.put("response",userService.login(req.getParameter("email"),req.getParameter("password")));
		map.put("temp","abcd");

		Map map2=new HashMap<String, Object>();
		map2.put("param1", "val1");
		map2.put("param2", "val2");
		map2.put("param3", "val3");
		map2.put("param4", "val4");

		Map[] arrayMap = new Map[3];
		for (int i = 0; i < 3; i++) {
			arrayMap[i] = map2;
		}

		map.put("myArray",arrayMap);

		return map;
	}

    @RequestMapping(value="/forgotpassword")
    public Map<String, Object> forgotPassword(HttpServletRequest req)
    {
		Map map=new HashMap<>();
        return map;
    }

    @GetMapping(value="/getarticle/{userId}/{departmentId}")
    public Map<String, Object> getArticle(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID,@ApiParam Pageable pageable)
    {
		Map map=new HashMap<>();

    	map=userService.getArticle(userId,departmentID,pageable);
        return map;
    }

    @RequestMapping(value = "/updatelikes")
	public Map<String, Object> updateLikes(HttpServletRequest req) {

		return userService.updateLikes(Integer.parseInt(req.getParameter("article_id")));

	}

	@RequestMapping(value = "/getcomment")
	public Map<String, Object> getComment(HttpServletRequest req) {

		return userService.getComment(Integer.parseInt(req.getParameter("article_id")));
	}
}