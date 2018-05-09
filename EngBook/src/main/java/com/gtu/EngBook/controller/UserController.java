package com.gtu.EngBook.controller;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.service.UserService;
import io.swagger.annotations.ApiParam;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;



@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;




    @RequestMapping(value = "/profile/update")
    public Map<String, Object> updateProfile(HttpServletRequest req) throws IOException, SQLException {
        UserModel userModel = new UserModel();
        StudentModel studentModel = new StudentModel();
        HashMap<String, Object> mresponse = new HashMap<>();

        userModel.setUserId(Long.parseLong(req.getParameter("user_id")));
        studentModel.setEnroll_no(Long.parseLong(req.getParameter("enroll")));
        userModel.setAddress(req.getParameter("addr"));
        //userModel.setProfilePic();
        MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
        mresponse.put("images response", userService.setImage(req, mrequest, "studentprofile"));
        studentModel.setYear_of_passing(Integer.parseInt(req.getParameter("yop")));
        studentModel.setInterest(req.getParameter("interest)"));
        userModel.setContact(Long.parseLong(req.getParameter("contact")));
        userModel.setPassword(req.getParameter("pass"));

        return userService.updateProfile(userModel, studentModel);
    }

    //								======PROFILE====== END


    // 							=======RETIEVAL============

    //							=========  COMPANY  ==========
    @RequestMapping(value = "/getcompanylist")
    public Map<String, Object> ComapanyList(HttpServletRequest request) {
        HashMap<String, Object> response = new HashMap<>();
        userService.getComapnyList();

        return response;
    }

    @RequestMapping(value = "/getyearplacement")
    public Map<String, Object> yearWisePlacement(HttpServletRequest request) {
        return userService.getYearWisePlacement(Long.parseLong(request.getParameter("comp_id")));
    }

    @RequestMapping(value = "/getdeptplacement")
    public Map<String, Object> DeptWisePlacement(HttpServletRequest request) {
        return userService.getDeptWisePlacement(Long.parseLong(request.getParameter("comp_id")));
    }

    @RequestMapping(value = "/getstudentplacementlist")
    public Map<String, Object> studentPlacementList(HttpServletRequest request) {
        return userService.getstudentPlacementList(
                Long.parseLong(request.getParameter("comp_id")),
                Integer.parseInt(request.getParameter("year_of_passing")),
                Long.parseLong(request.getParameter("colg_id")));

    }

    @RequestMapping(value = "/getstudentplacementlistdept")
    public Map<String, Object> studentPlacementListDept(HttpServletRequest request) {
        return userService.getstudentPlacementListDept(
                Long.parseLong(request.getParameter("comp_id")),
                Integer.parseInt(request.getParameter("year_of_passing")),
                Long.parseLong(request.getParameter("colg_id")),
                Long.parseLong(request.getParameter(("dept_id"))));
    }


    //							=========END Company==========


    @RequestMapping(value = "/register/student")
    public Map<String, Object> studentregister(MultipartHttpServletRequest req) throws IOException, SQLException {
        StudentModel studentModel = new StudentModel();
        UserModel userModel = new UserModel();
        HashMap<String, Object> mresponse = new HashMap<>();
        try {
            studentModel.setEnroll_no(Long.parseLong(req.getParameter("enroll")));
            userModel.setFname(req.getParameter("fname"));
            userModel.setLname(req.getParameter("lname"));
            userModel.setGender(Integer.parseInt(req.getParameter("gender")));
            userModel.setDob((req.getParameter("dob")));
            userModel.setAddress(req.getParameter("addr"));
            userModel.setContact(Long.parseLong(req.getParameter("contact")));
            userModel.setEmail(req.getParameter("email"));
            userModel.setUserType(req.getParameter("user_type"));

            //userModel.setProfilePic();
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("imagesResponse", userService.setImageRegister(req, mrequest, "studentprofile", userModel));


            String dept_name = req.getParameter("dept_name");
            studentModel.setDept_id((int) userService.getDeptId(dept_name));

            String colg_name = req.getParameter("colg_name");
            studentModel.setColg_id(userService.getColgId(colg_name));

            String univ_name = req.getParameter("univ_name");
            studentModel.setUnivId(userService.getUnivId(univ_name));

            studentModel.setInterest(req.getParameter("interest"));

            studentModel.setYear_of_passing(Integer.parseInt(req.getParameter("yop")));
            userModel.setPassword(req.getParameter("pass"));

            mresponse.put("studentResgistration", userService.studentRegister(userModel, studentModel));
        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }
        return mresponse;
    }

    @RequestMapping(value = "/register/faculty")
    public Map<String, Object> facultyregister(MultipartHttpServletRequest req) throws IOException, SQLException {
        FacultyModel facultyModel = new FacultyModel();
        UserModel userModel = new UserModel();
        HashMap<String, Object> mresponse = new HashMap<>();
        try {

            //userModel.setProfilePic();
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("images response", userService.setImageRegister(req, mrequest, "facultyprofile", userModel));

            facultyModel.setEnroll_no(Long.parseLong(req.getParameter("enroll")));
            userModel.setFname(req.getParameter("fname"));
            userModel.setLname(req.getParameter("lname"));
            userModel.setGender(Integer.parseInt(req.getParameter("gender")));
            userModel.setDob((req.getParameter("dob")));
            userModel.setAddress(req.getParameter("addr"));
            userModel.setContact(Long.parseLong(req.getParameter("contact")));
            userModel.setEmail(req.getParameter("email"));
            userModel.setUserType(req.getParameter("user_type"));

            String dept_name = req.getParameter("dept_name");
            facultyModel.setDept_id((int) userService.getDeptId(dept_name));

            String colg_name = req.getParameter("colg_name");
            facultyModel.setColg_id(userService.getColgId(colg_name));

            String univ_name = req.getParameter("univ_name");
            facultyModel.setUnivId(userService.getUnivId(univ_name));

            userModel.setPassword(req.getParameter("pass"));

            mresponse.put("facultyResgistration", userService.facultyRegister(userModel, facultyModel));

        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }
        return mresponse;
    }

    @RequestMapping(value = "/register/hod")
    public Map<String, Object> hodregister(MultipartHttpServletRequest req) throws IOException, SQLException {
        HodModel hodModel = new HodModel();
        UserModel userModel = new UserModel();
        DepartmentModel departmentModel=new DepartmentModel();
        HashMap<String, Object> mresponse = new HashMap<>();
        try {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("images response", userService.setImageRegister(req, mrequest, "hodprofile", userModel));
            hodModel.setEnroll_no(Long.parseLong(req.getParameter("enroll")));
            userModel.setFname(req.getParameter("fname"));
            userModel.setLname(req.getParameter("lname"));
            userModel.setGender(Integer.parseInt(req.getParameter("gender")));
            userModel.setDob((req.getParameter("dob")));
            userModel.setAddress(req.getParameter("addr"));
            userModel.setContact(Long.parseLong(req.getParameter("contact")));
            userModel.setEmail(req.getParameter("email"));
            userModel.setUserType(req.getParameter("user_type"));

            departmentModel.setDeptName(req.getParameter("dept_name"));
            hodModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));
            departmentModel.setDept_id(Integer.parseInt(req.getParameter("dept_id")));

            String colg_name = req.getParameter("colg_name");
            hodModel.setColg_id(userService.getColgId(colg_name));
            departmentModel.setColg_id(userService.getColgId(colg_name));

            String univ_name = req.getParameter("univ_name");
            hodModel.setUnivId(userService.getUnivId(univ_name));
            departmentModel.setHod_name(req.getParameter("fname")+req.getParameter("lname"));

            userModel.setPassword(req.getParameter("pass"));

            mresponse.put("hodRegistration", userService.hodRegister(userModel, hodModel,departmentModel));
        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }

        return mresponse;
    }

    @RequestMapping(value = "/register/principal")
    public Map<String, Object> principalregister(MultipartHttpServletRequest req) throws IOException, SQLException {
        CollegeModel collegeModel = new CollegeModel();
        UserModel userModel = new UserModel();
        HashMap<String, Object> mresponse = new HashMap<>();
        try {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("images response", userService.setImageRegister(req, mrequest, "principalprofile", userModel));
            userModel.setFname(req.getParameter("fname"));
            userModel.setLname(req.getParameter("lname"));
            userModel.setGender(Integer.parseInt(req.getParameter("gender")));
            userModel.setDob((req.getParameter("dob")));
            userModel.setAddress(req.getParameter("addr"));
            userModel.setContact((Long.parseLong(req.getParameter("contact"))));
            userModel.setEmail(req.getParameter("email"));
            userModel.setPassword(req.getParameter("pass"));
            userModel.setUserType(req.getParameter("user_type"));

            collegeModel.setWebsite(req.getParameter("website"));
            collegeModel.setTpo_name(req.getParameter("tponame"));
            collegeModel.setTpo_no(Long.parseLong(req.getParameter("tpono")));
            collegeModel.setColg_name(req.getParameter("colg_name"));
            collegeModel.setColgId(Integer.parseInt(req.getParameter("colg_id")));

            String univ_name = req.getParameter("univ_name");
            collegeModel.setUniv_id(userService.getUnivId(univ_name));

            mresponse.put("principalRegistration", userService.principalRegister(userModel, collegeModel));
        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }

        return mresponse;
    }

    @RequestMapping(value = "/register/chancellor")
    public Map<String, Object> chancellorregister(MultipartHttpServletRequest req) throws IOException, SQLException {

        UserModel userModel = new UserModel();
        UniversityModel universityModel = new UniversityModel();

        HashMap<String, Object> mresponse = new HashMap<>();
        try {

            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("images response", userService.setImageRegister(req, mrequest, "chancellorprofile", userModel));
            userModel.setFname(req.getParameter("fname"));
            userModel.setLname(req.getParameter("lname"));
            userModel.setGender(Integer.parseInt(req.getParameter("gender")));
            userModel.setDob((req.getParameter("dob")));
            userModel.setAddress(req.getParameter("addr"));
            userModel.setContact((Long.parseLong(req.getParameter("contact"))));
            userModel.setEmail(req.getParameter("email"));
            userModel.setPassword(req.getParameter("pass"));
            userModel.setUserType(req.getParameter("user_type"));

            universityModel.setUniv_name(req.getParameter("univname"));
            universityModel.setWebsite(req.getParameter("univwebsite"));
            universityModel.setUniv_id(Integer.parseInt(req.getParameter("univid")));

            mresponse.put("chancellorRegistration", userService.chancellorRegister(userModel, universityModel));
        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }

        return mresponse;
    }


    @RequestMapping(value = "/register/company")
    public Map<String, Object> companyRegister(MultipartHttpServletRequest req) throws IOException, SQLException {
        CompanyModel companyModel = new CompanyModel();
        HashMap<String, Object> mresponse = new HashMap<>();
        try {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
            mresponse.put("images response", userService.setImageCompany(req, mrequest, "companyprofile", companyModel));
            companyModel.setCompId(Long.parseLong(req.getParameter("comp_id")));
            companyModel.setCompName(req.getParameter("comp_name"));
            companyModel.setAddress(req.getParameter("address"));
            companyModel.setDomain(req.getParameter("domain"));
            companyModel.setHr_name(req.getParameter("hr_name"));
            companyModel.setContact(Long.parseLong(req.getParameter("contact")));
            companyModel.setHrContact(Long.parseLong(req.getParameter("hr_contact")));
        } catch (Exception e) {
            mresponse.put("response", false);
            mresponse.put("message", e.getMessage() + e.getStackTrace());
        }

        return userService.companyRegister(companyModel);
    }

    //** Registration completes **//


    //LOGIN
    @RequestMapping(value = "/login")
    public Map<String, Object> login(HttpServletRequest req) {
        Map map = new HashMap<String, Object>();
        map.put("response", userService.login(req.getParameter("email"), req.getParameter("password"),req.getParameter("fcamtoken")));
        return map;
    }

    @RequestMapping(value = "/company/login")
    public Map<String, Object> companyLogin(HttpServletRequest req) {
        Map map = new HashMap<String, Object>();
        map.put("response", userService.companyLogin(Long.parseLong(req.getParameter("comp_id"))));

        return map;
    }


    //END LOGIN

/*
FORGOT PASSSwORD
 */

    @RequestMapping(value = "/forgotpassword")
    public Map<String, Object> forgotPassword(HttpServletRequest req) throws IOException {
        Map map = new HashMap<>();

        String email = req.getParameter("email");
        map = userService.forgotpassword(email);

        return map;
    }

    @RequestMapping(value = "/checktoken")
    public Map<String, Object> checkToken(HttpServletRequest request) {

        return userService.checkToken(request.getParameter("token"), request.getParameter("email"));
    }

    // UPDATING

    //UPDATE LIKES
    @RequestMapping(value = "/updatelikes")
    public Map<String, Object> updateLikes(HttpServletRequest req) throws IOException, JSONException {

        return userService.updateLikes(Long.parseLong(req.getParameter("article_id")),
                req.getParameter("type"), Long.parseLong(req.getParameter("user_id")));
    }

    @RequestMapping(value = "/doubt/downvote")
    public Map<String, Object> doubtDownvote(HttpServletRequest req) {

        return userService.doubtDownvote(Long.parseLong(req.getParameter("doubt_id")));
    }

    @RequestMapping(value = "/doubt/upvote")
    public Map<String, Object> doubtUpvote(HttpServletRequest req) {

        return userService.doubtUpvote(Long.parseLong(req.getParameter("doubt_id")),Long.parseLong(req.getParameter("user_id")));
    }

    @RequestMapping(value = "/answer/downvote")
    public Map<String, Object> answerDownvote(HttpServletRequest req) {

        return userService.answerDownvote(Long.parseLong(req.getParameter("answer_id")));
    }

    @RequestMapping(value = "/answer/upvote")
    public Map<String, Object> answerUpvote(HttpServletRequest req) {

        return userService.answerUpvote(Long.parseLong(req.getParameter("answer_id")),Long.parseLong("user_id"));
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

    @GetMapping(value = "/getprofiledata/{userId}")
    public Map<String, Object> getProfileData(@PathVariable("userId") Long userId, @ApiParam Pageable pageable) {
        Map map = new HashMap<>();
        map = userService.getProfileData(userId, pageable);
        return map;
    }

    @GetMapping(value = "/getarticle/{userId}/{departmentId}")
    public Map<String, Object> getArticle(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID, @ApiParam Pageable pageable) {
        Map map = new HashMap<>();
        map = userService.getArticle(userId, departmentID, pageable);
        return map;
    }

    @GetMapping(value = "/getcomment/{articleId}")
    public Map<String, Object> getComment(@PathVariable("articleId") Long articleId, @ApiParam Pageable pageable) {

        Map map = new HashMap<>();
        map = userService.getComment(articleId, pageable);
        return map;
    }


    @GetMapping(value = "/getdoubtlist/{userId}/{departmentId}")
    public Map<String, Object> getDoubtList(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID, @ApiParam Pageable pageable) {

        Map map = new HashMap<>();

        map = userService.getDoubtList(userId, departmentID, pageable);
        return map;
    }

    @GetMapping(value = "/getdoubtlist/{userId}/{departmentId}/{keyword}")
    public Map<String, Object> getFilteredDoubtList(@PathVariable("userId") Long userId, @PathVariable("departmentId") Long departmentID,@PathVariable("keyword") String keyword, @ApiParam Pageable pageable) {

        Map map = new HashMap<>();

        map = userService.getFilteredDoubtList(userId, departmentID,keyword, pageable);
        return map;
    }

    @GetMapping(value = "/getanswer/{doubtId}")
    public Map<String, Object> getAnswer(@PathVariable("doubtId") Long doubtId, @ApiParam Pageable pageable) {

        Map map = new HashMap<>();
        map = userService.getAnswer(doubtId, pageable);
        return map;
    }
    //=================================ENND============================

    //Inserting into db

    //General Image getter

    //================Adding Doubt================
    @RequestMapping(value = "/adddoubt")
    public Map<String, Object> addDoubt(MultipartHttpServletRequest request) throws IOException, SQLException {
        Map<String, Object> mresponse = new HashMap<>();
        DoubtModel doubtModel = new DoubtModel();
        //images
        MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
        mresponse.put("images response", userService.setImage(request, mrequest, "doubt"));

        doubtModel.setText(request.getParameter("text"));
        doubtModel.setDeptId(Long.parseLong(request.getParameter("dept_id")));
        doubtModel.setTag(request.getParameter("tag"));
        doubtModel.setUserModel(userService.knowUserModel(Long.parseLong(request.getParameter("user_id"))));
        doubtModel.setCreateTime(System.currentTimeMillis());
        doubtModel.setHeading(request.getParameter("heading"));

        mresponse.put("doubt response", userService.addDoubt(doubtModel));
        return mresponse;
    }


    // =================  ADDING ANN ARTICLE=========
    @RequestMapping(value = "/addarticle")
    public Map<String, Object> addArticle(MultipartHttpServletRequest request) throws SQLException, IOException {
        Map<String, Object> mresponse = new HashMap<>();
        ArticlesModel articlesModel = new ArticlesModel();


        articlesModel.setArticleText(request.getParameter("text"));
        if (articlesModel.getArticleImage() == null) {
            articlesModel.setArticleType(0);
        } else {
            MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
            mresponse.put("images response", userService.setImage(request, mrequest, "article"));
            articlesModel.setArticleType(1);
        }

        articlesModel.setUserModel(userService.knowUserModel(Long.parseLong(request.getParameter("user_id"))));
        articlesModel.setDeptId(Long.parseLong(request.getParameter("dept_id")));
        articlesModel.setCreateTime(System.currentTimeMillis());

        mresponse.put("article_response", userService.addArticle(articlesModel));

        return mresponse;
    }

    //========Inserting Comment=======
    @RequestMapping(value = "/addcomment")
    public Map<String, Object> addComment(HttpServletRequest req) throws SQLException {

        CommentModel commentModel = new CommentModel();

        commentModel.setArticleId(Long.parseLong(req.getParameter("article_id")));
        commentModel.setText(req.getParameter("text"));
        commentModel.setUserModel(userService.knowUserModel(Long.parseLong(req.getParameter("user_id"))));
        commentModel.setCreateTime(System.currentTimeMillis());

        return userService.addComment(commentModel);
    }


    @RequestMapping(value = "/addanswer")
    public Map<String, Object> addAnswer(MultipartHttpServletRequest req) throws SQLException, IOException {
        Map<String, Object> mresponse = new HashMap<>();
        AnswerModel answerModel = new AnswerModel();

        MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) req;
        mresponse.put("images response", userService.setImage(req, mrequest, "answer"));
        answerModel.setText(req.getParameter("text"));
        answerModel.setDoubtId(Long.parseLong(req.getParameter("doubt_id")));
        answerModel.setUserModel(userService.knowUserModel(Long.parseLong(req.getParameter("user_id"))));
        answerModel.setCreateTime(System.currentTimeMillis());

        return userService.addAnswer(answerModel);
    }

    @RequestMapping(value = "/approve")
    public Map<String, Object> approve(HttpServletRequest request) {
        Map<String, Object> mresponse = new HashMap<>();


        return userService.approve(Long.parseLong(request.getParameter("user_id")));
    }

    @RequestMapping(value = "/disapprove")
    public Map<String, Object> disApprove(HttpServletRequest request) {
        Map<String, Object> mresponse = new HashMap<>();


        return userService.disApprove(Long.parseLong(request.getParameter("user_id")));
    }

    @RequestMapping(value = "/getnetworklist")
    public Map<String, Object> getNetworkList(HttpServletRequest request) {
        return userService.getNetworkList(Long.parseLong(request.getParameter("user_id")),
                Long.parseLong(request.getParameter("dept_id")));
    }

}