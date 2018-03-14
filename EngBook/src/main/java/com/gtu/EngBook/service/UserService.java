package com.gtu.EngBook.service;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.repository.ArticleRepository;
import com.gtu.EngBook.repository.DepartmentRepository;
import com.gtu.EngBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public UserService(UserRepository userRepository, ArticleRepository articleRepository /*DepartmentRepository departmentRepository*/) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        //this.departmentRepository = departmentRepository;
    }

    public Map<String,Object> studentRegister(UserModel userModel, StudentModel studentModel)
    {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setStudentModel(studentModel);
        studentModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("Message","Registration Successfull");

        return res;
    }


    public Map<String,Object> facultyRegister(UserModel userModel, FacultyModel facultyModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setFacultyModel(facultyModel);
        facultyModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("Message","Registration Successfull");


        return res;
    }

    public Map<String,Object> hodRegister(UserModel userModel, HodModel hodModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setHodModel(hodModel);
        hodModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("Message","Registration Successfull");

        return res;
    }

    public Map<String,Object> login(String email, String password)
    {
        UserModel userModel=userRepository.findOneByEmail(email);
        Map<String,Object> res = new HashMap<>();
        if(userModel!=null)
        {
            if(userModel.getPassword().equals(password)){
                res.put("response","true");
                res.put("Message","Login Successfull");
                userModel.setLoginStatus(true);
                return res;
            }

            else {
                res.put("response","false");
                res.put("Message","Invalid Password");
                return res;
            }
        }

        else
        {
            res.put("response","false");
            res.put("Message","Email Id is not Registered");
            return res;
        }
    }


    public Map<String,Object> forgotpassword(String email)
    {
        UserModel userModel=userRepository.findOneByEmail(email);
        Map<String,Object> res = new HashMap<>();
        if(userModel!=null)
        {}
        else res.put("Message","Email Id not yet Registered");

            return res;
    }

    //** Illegal state exception **//
    public Map<String,Object> getArticle(Long userId, Long deptId, Pageable pageable) {
        Map<String,Object> res = new HashMap<>();
        //Pageable Twenty=new PageRequest(0,20);
        /*if(userType.equals("student")) {
            int deptId=departmentRepository.findByUserType(userType).getDept_id();
        }*/

       // int deptId=departmentRepository.findByDeptName(deptName);
       //ArticlesModel articlesModel=articleRepository.findByDeptIdAndUserIdNot(deptId,userId);
        List<ArticlesModel> articlesModelList=new ArrayList<>();
        UserModel userModel1=userRepository.findByUserId(userId);
        articlesModelList=articleRepository.findAllByUserModelNotAndDeptId(userModel1,deptId,pageable);
       res.put("ArticleList",articlesModelList);
        return res;
    }

    public Map<String,Object> updateLikes(int articleId){
        Map<String,Object> res = new HashMap<>();

        ArticlesModel articlesModel=articleRepository.findByArticleId(articleId);
        if(articlesModel!=null) {
            articlesModel.setLikes(articlesModel.getLikes() + 1);
            res.put("Message", "Success");
            return res;
        }

        res.put("Message","failure");
        return res;

    }

    public Map<String,Object> getComment(int article_id) {
        Map<String,Object> res = new HashMap<>();



        return res;
    }

    public Map<String,Object> principalRegister(UserModel userModel, CollegeModel collegeModel) {

        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setCollegeModel(collegeModel);
        collegeModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("Message","Registration Successfull");


        return res;
    }

    public Map<String,Object> chancellorRegister(UserModel userModel, UniversityModel universityModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setUniversityModel(universityModel);
        universityModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("Message","Registration Successfull");


        return res;

    }
}
