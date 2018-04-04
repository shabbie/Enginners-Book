package com.gtu.EngBook.controller;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.repository.CommentRepository;
import com.gtu.EngBook.service.UserService;
import com.sendgrid.*;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@RestController
@RequestMapping(value="/user")
public class UserController
{
	@Autowired
	UserService userService;


	//									======PROFILE======
	@RequestMapping(value = "/profile")
	public Map<String,Object> showProfile(HttpServletRequest req)
	{
		long userId= Long.parseLong(req.getParameter("user_id"));
		return userService.getProfile(userId);
	}

	@RequestMapping(value = "/profile/update")
	public Map<String,Object> updateProfile(HttpServletRequest req) throws IOException, SQLException {
		UserModel userModel=new UserModel();
		StudentModel studentModel=new StudentModel();
		HashMap<String,Object> mresponse=new HashMap<>();

		userModel.setUserId(Long.parseLong(req.getParameter("user_id")));
		studentModel.setEnroll_no(Long.parseLong( req.getParameter("enroll")));
		userModel.setAddress(req.getParameter("addr"));
		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"studentprofile"));
		studentModel.setYear_of_passing(Integer.parseInt( req.getParameter("yop")));
		studentModel.setInterest(req.getParameter("interest)"));
		userModel.setContact(Long.parseLong( req.getParameter("contact")));
		userModel.setPassword(req.getParameter("pass"));

		return userService.updateProfile(userModel,studentModel);
	}

	//								======PROFILE====== END



	// 							=======RETIEVAL============

	//							=========Company==========
	@RequestMapping(value = "/getcompanylist")
	public Map<String,Object> ComapanyList(HttpServletRequest request)
	{
		HashMap<String,Object> response=new HashMap<>();
		userService.getComapnyList();

		return response;
	}

	@RequestMapping(value = "/getyearplacement")
	public Map<String,Object> yearWisePlacement(HttpServletRequest request)
	{
		HashMap<String,Object> response=new HashMap<>();

		userService.getYearWisePlacement(Long.parseLong(request.getParameter("comp_id")));

		return response;
	}




	//							=========END Company==========


	@RequestMapping(value="/register/student")
	public Map<String, Object> studentregister(HttpServletRequest req) throws IOException, SQLException {
		StudentModel studentModel=new StudentModel();
		UserModel userModel=new UserModel();
		HashMap<String,Object> mresponse=new HashMap<>();

		studentModel.setEnroll_no(Long.parseLong( req.getParameter("enroll")));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
    	userModel.setAddress(req.getParameter("addr"));
		userModel.setContact(Long.parseLong( req.getParameter("contact")));
		userModel.setEmail(req.getParameter("email"));

		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"studentprofile"));

		studentModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
		studentModel.setColg_id(Integer.parseInt(req.getParameter("colg_id")));
		studentModel.setUnivId(Integer.parseInt(req.getParameter("univ_id")));
		studentModel.setInterest(req.getParameter("interest)"));
		studentModel.setCompanyId(req.getParameter("comp_id"));

		studentModel.setYear_of_passing(Integer.parseInt( req.getParameter("yop")));
		userModel.setPassword(req.getParameter("pass"));

		mresponse.put("Student Resgistration",userService.studentRegister(userModel,studentModel));

		return mresponse;
	}
	
	@RequestMapping(value="/register/faculty")
	public Map<String, Object> facultyregister(HttpServletRequest req) throws IOException, SQLException {
		FacultyModel facultyModel=new FacultyModel();
		UserModel userModel=new UserModel();
		HashMap<String,Object> mresponse=new HashMap<>();

		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"facultyprofile"));
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

        mresponse.put("Faculty Resgistration",userService.facultyRegister(userModel,facultyModel));

		return mresponse;
	}
	
	@RequestMapping(value="/register/hod")
	public Map<String, Object> hodregister(HttpServletRequest req) throws IOException, SQLException {
		HodModel hodModel=new HodModel();
		UserModel userModel=new UserModel();
		HashMap<String,Object> mresponse=new HashMap<>();

		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"hodprofile"));
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

        mresponse.put("Hod Registration",userService.hodRegister(userModel,hodModel));

        return mresponse;
	}
	
	@RequestMapping(value="/register/principal")
	public Map<String, Object> principalregister(HttpServletRequest req) throws IOException, SQLException {
		CollegeModel collegeModel=new CollegeModel();
		UserModel userModel=new UserModel();
		HashMap<String,Object> mresponse=new HashMap<>();

		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"principalprofile"));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact((Long.parseLong( req.getParameter("contact"))));
		userModel.setEmail(req.getParameter("email"));
		userModel.setPassword(req.getParameter("pass"));

		collegeModel.setWebsite(req.getParameter("website"));
		collegeModel.setTpo_name(req.getParameter("tponame"));
		collegeModel.setColg_name(req.getParameter("colg_name"));
		collegeModel.setColgId(Integer.parseInt(req.getParameter("colg_id")));
        collegeModel.setUniv_id(Integer.parseInt(req.getParameter("univ_id")));

		mresponse.put("Principal Registration",userService.principalRegister(userModel,collegeModel));

		return mresponse;
	}
	
	@RequestMapping(value="/register/chancellor")
	public Map<String, Object> chancellorregister(HttpServletRequest req) throws IOException, SQLException {

		UserModel userModel=new UserModel();
		UniversityModel universityModel=new UniversityModel();

		HashMap<String,Object> mresponse=new HashMap<>();

		//userModel.setProfilePic();
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
		mresponse.put("images response",userService.setImage(req,mrequest,"chancellorprofile"));
		userModel.setFname(req.getParameter("fname"));
		userModel.setLname(req.getParameter("lname"));
		userModel.setGender(Integer.parseInt(req.getParameter("gender")));
		userModel.setDob((req.getParameter("dob")));
		userModel.setAddress(req.getParameter("addr"));
		userModel.setContact((Long.parseLong( req.getParameter("contact"))));
		userModel.setEmail(req.getParameter("email"));
		userModel.setPassword(req.getParameter("pass"));

		universityModel.setUniv_name(req.getParameter("univname"));
		universityModel.setWebsite(req.getParameter("univwebsite"));
		universityModel.setUniv_id(Integer.parseInt(req.getParameter("uniid")));

		mresponse.put("Chancellor Registration",userService.chancellorRegister(userModel,universityModel));

		return mresponse;
	}


	@RequestMapping(value="/register/company")
	public Map<String, Object> companyRegister(HttpServletRequest req)
	{
		CompanyModel companyModel=new CompanyModel();

		companyModel.setCompId(Long.parseLong(req.getParameter("comp_id")));
		companyModel.setCompName(req.getParameter("comp_name"));
		companyModel.setAddress(req.getParameter("address"));
		companyModel.setDomain(req.getParameter("domain"));
		companyModel.setHr_name(req.getParameter("hr_name"));
		companyModel.setContact(Long.parseLong(req.getParameter("contact")));
		companyModel.setHrContact(Long.parseLong(req.getParameter("hr_contact")));

		return userService.companyRegister(companyModel);
	}



	//** Registration completes **//


//LOGIN
	@RequestMapping(value="/login")
	public Map<String, Object> login(HttpServletRequest req)
	{
		Map map=new HashMap<String, Object>();
		map.put("response",userService.login(req.getParameter("email"),req.getParameter("password")));
		return map;
	}

	@RequestMapping(value="/company/login")
	public Map<String, Object> companyLogin(HttpServletRequest req)
	{
		Map map=new HashMap<String, Object>();
		map.put("response",userService.companyLogin(Long.parseLong(req.getParameter("comp_id"))));

		return map;
	}


	//END LOGIN

/*
FORGOT PASSSwORD
 */

    @RequestMapping(value="/forgotpassword")
    public Map<String, Object> forgotPassword(HttpServletRequest req) throws IOException {
		Map map=new HashMap<>();

			String email=req.getParameter("email");
			map=userService.forgotpassword(email);


        return map;
    }

    // UPDATING

	//UPDATE LIKES
    @RequestMapping(value = "/updatelikes")
	public Map<String, Object> updateLikes(HttpServletRequest req) {

		return userService.updateLikes( Long.parseLong(req.getParameter("article_id")));
	}

	@RequestMapping(value = "/doubt/downvote")
	public Map<String, Object> doubtDownvote(HttpServletRequest req) {

		return userService.doubtDownvote(Long.parseLong(req.getParameter("doubt_id")));
	}

	@RequestMapping(value = "/doubt/upvote")
	public Map<String, Object> doubtUpvote(HttpServletRequest req) {

		return userService.doubtUpvote(Long.parseLong(req.getParameter("doubt_id")));
	}

	@RequestMapping(value = "/answer/downvote")
	public Map<String, Object> answerDownvote(HttpServletRequest req) {

		return userService.answerDownvote(Long.parseLong(req.getParameter("answer_id")));
	}

	@RequestMapping(value = "/answer/upvote")
	public Map<String, Object> answerUpvote(HttpServletRequest req) {

		return userService.answerUpvote(Long.parseLong(req.getParameter("answer_id")));
	}
	//ENDS

	//RETRIEVING

	//GETTING ARTICLE
	/*@RequestMapping(value="/getarticle")
	public Map<String, Object> getArticle(HttpServletRequest req,@ApiParam Pageable pageable)
	{
		Map map=new HashMap<>();
		long userId= Long.parseLong(req.getParameter("user_id"));
		long departmentID= Long.parseLong(req.getParameter("dept_id"));

		map=userService.getArticle(userId,departmentID,pageable);
		return map;
	}*/

	@GetMapping(value="/getarticle/{userId}/{departmentId}")
	public Map<String, Object> getArticle(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID,@ApiParam Pageable pageable)
	{
		Map map=new HashMap<>();
		map=userService.getArticle(userId,departmentID,pageable);
		return map;
	}

	@GetMapping(value = "/getcomment/{articleId}")
	public Map<String, Object> getComment(@PathVariable("articleId") Long articleId,@ApiParam Pageable pageable) {

		Map map=new HashMap<>();
		map=userService.getComment(articleId,pageable);
		return map;
	}


	@GetMapping(value = "/getdoubtlist/{userId}/{departmentId}")
	public Map<String, Object> getDoubtList(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID,@ApiParam Pageable pageable) {

		Map map=new HashMap<>();

		map=userService.getDoubtList(userId,departmentID,pageable);
		return map;
	}

	@GetMapping(value = "/getanswer/{doubtId}")
	public Map<String, Object> getAnswer(@PathVariable("doubtId") Long doubtId,@ApiParam Pageable pageable) {

		Map map=new HashMap<>();
		map=userService.getAnswer(doubtId,pageable);
		return map;
	}
	//=================================ENND============================

	//Inserting into db

	//General Image getter

	//================Adding Doubt================
			@RequestMapping(value = "/adddoubt")
			public Map<String, Object> addDoubt(HttpServletRequest request) throws IOException, SQLException {
				Map<String, Object> mresponse = new HashMap<>();
				DoubtModel doubtModel=new DoubtModel();
				//images
				MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)request;
				mresponse.put("images response",userService.setImage(request,mrequest,"doubt"));

				doubtModel.setText(request.getParameter("text"));
				doubtModel.setDeptId(Long.parseLong(request.getParameter("dept_id")));
				doubtModel.setTag(request.getParameter("tag"));
				doubtModel.setUserModel(userService.knowUserModel(Long.parseLong(request.getParameter("user_id"))));
                doubtModel.setCreateTime(System.currentTimeMillis());
                doubtModel.setHeading(request.getParameter("heading"));

				mresponse.put("doubt response",userService.addDoubt(doubtModel));
				return mresponse;
			}


			// =================  ADDING ANN ARTICLE=========
	@RequestMapping(value = "/addarticle")
	public Map<String, Object> addArticle(HttpServletRequest request) throws SQLException, IOException {
        Map<String, Object> mresponse = new HashMap<>();
		ArticlesModel articlesModel=new ArticlesModel();


		articlesModel.setArticleText(request.getParameter("text"));
		if(articlesModel.getArticleImage()==null)
		{
			articlesModel.setArticleType(0);
		}
		else
        {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)request;
            mresponse.put("images response",userService.setImage(request,mrequest,"article"));
            articlesModel.setArticleType(1);
        }

		articlesModel.setUserModel(userService.knowUserModel(Long.parseLong(request.getParameter("user_id"))));
		articlesModel.setDeptId(Long.parseLong(request.getParameter("dept_id")));
		articlesModel.setCreateTime(System.currentTimeMillis());

		mresponse.put("article_response",userService.addArticle(articlesModel));

		return mresponse;
	}

	//========Inserting Comment=======
	@RequestMapping(value = "/addcomment")
	public Map<String, Object> addComment(HttpServletRequest req) throws SQLException {

		CommentModel commentModel=new CommentModel();

		commentModel.setArticleId(Long.parseLong(req.getParameter("article_id")));
		commentModel.setText(req.getParameter("text"));
		commentModel.setUserModel(userService.knowUserModel(Long.parseLong(req.getParameter("user_id"))));
        commentModel.setCreateTime(System.currentTimeMillis());

		return userService.addComment(commentModel);
	}


	@RequestMapping(value = "/addanswer")
	public Map<String, Object> addAnswer(HttpServletRequest req) throws SQLException, IOException {
        Map<String, Object> mresponse = new HashMap<>();
		AnswerModel answerModel=new AnswerModel();

        MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest)req;
        mresponse.put("images response",userService.setImage(req,mrequest,"answer"));
		answerModel.setText(req.getParameter("text"));
		answerModel.setDoubtId(Long.parseLong(req.getParameter("doubt_id")));
		answerModel.setUserModel(userService.knowUserModel(Long.parseLong(req.getParameter("user_id"))));
        answerModel.setCreateTime(System.currentTimeMillis());

		return userService.addAnswer(answerModel);
	}

}