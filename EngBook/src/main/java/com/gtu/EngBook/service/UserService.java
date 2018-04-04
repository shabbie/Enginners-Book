package com.gtu.EngBook.service;

import com.gtu.EngBook.model.*;
import com.gtu.EngBook.repository.*;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

@Service
@org.springframework.transaction.annotation.Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private DoubtRepository doubtRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StudentRepository studentRepository;

    public UserModel knowUserModel(Long userId){
        return userRepository.findByUserId(userId);
    }

    //SHOW PROFILE
    public Map<String,Object> getProfile(long userId) {
        Map<String,Object> res = new HashMap<>();

        UserModel userModel=knowUserModel(userId);
        List<DoubtModel> doubtModel=doubtRepository.findAllByUserModel(userModel);
        List<AnswerModel> answerModel=answerRepository.findAllByUserModel(userModel);

        int count=0;
        for (int i = 0; i <doubtModel.size() ; i++) {
            DoubtModel doubtModel1 = doubtModel.get(i);
            count+=doubtModel1.getUpvote();
        }

        for (int i = 0; i <answerModel.size() ; i++) {
            AnswerModel answerModel1=answerModel.get(i);
            count+=answerModel1.getUpvote();
        }

        res.put("user basic",userRepository.findByUserId(userId));
        res.put("point",count);
        res.put("doubts solved",doubtModel.size());
        res.put("doubts asked",answerModel.size());

        return res;
    }

    public Map<String,Object> updateProfile(UserModel userModel, StudentModel studentModel) {
        Map<String,Object> res = new HashMap<>();
        /*userModel.setStudentModel(studentModel);
        studentModel.setUserModel(userModel);*/

      //  userRepository.(userModel);


        res.put("response","true");
        res.put("Message","Updation Successfull");

        return res;
    }



    //General Methods

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    //end General method

    public UserService(UserRepository userRepository, ArticleRepository articleRepository ) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    public Map<String,Object> studentRegister(UserModel userModel, StudentModel studentModel)
    {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("response","false");
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setStudentModel(studentModel);
        studentModel.setUserModel(userModel);

        userRepository.save(userModel);
        res.put("response","true");
        res.put("Message","Registration Successfull");
        res.put("user_id",userModel.getUserId());
        res.put("profile_pic",userModel.getProfilePic());

        return res;
    }


    public Map<String,Object> facultyRegister(UserModel userModel, FacultyModel facultyModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("response","false");
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setFacultyModel(facultyModel);
        facultyModel.setUserModel(userModel);

        userRepository.save(userModel);
        res.put("response","true");
        res.put("Message","Registration Successfull");
        res.put("user_id",userModel.getUserId());
        res.put("profile_pic",userModel.getProfilePic());

        return res;
    }

    public Map<String,Object> hodRegister(UserModel userModel, HodModel hodModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("response","false");
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setHodModel(hodModel);
        hodModel.setUserModel(userModel);

        userRepository.save(userModel);
        res.put("response","true");
        res.put("Message","Registration Successfull");
        res.put("user_id",userModel.getUserId());
        res.put("profile_pic",userModel.getProfilePic());

        return res;
    }

    public Map<String,Object> chancellorRegister(UserModel userModel, UniversityModel universityModel) {
        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("response","false");
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setUniversityModel(universityModel);
        universityModel.setUserModel(userModel);

        userRepository.save(userModel);

        res.put("response","true");
        res.put("Message","Registration Successfull");
        res.put("user_id",userModel.getUserId());
        res.put("profile_pic",userModel.getProfilePic());


        return res;

    }
    public Map<String,Object> principalRegister(UserModel userModel, CollegeModel collegeModel) {

        Map<String,Object> res = new HashMap<>();

        if(userRepository.findOneByEmail(userModel.getEmail())!=null)
        {
            res.put("response","false");
            res.put("Message","UserAlready Registered");
            return res;
        }

        userModel.setCollegeModel(collegeModel);
        collegeModel.setUserModel(userModel);

        userRepository.save(userModel);
        res.put("response","true");
        res.put("Message","Registration Successfull");
        res.put("user_id",userModel.getUserId());
        res.put("profile_pic",userModel.getProfilePic());

        return res;
    }

    public Map<String,Object> companyRegister(CompanyModel companyModel) {
        Map<String,Object> res = new HashMap<>();

        if(companyRepository.findBycompId(companyModel.getCompId())!=null)
        {
            res.put("response","false");
            res.put("Message","Company Already Registered");
            return res;
        }

        companyRepository.save(companyModel);
        res.put("response","true");
        res.put("Message","Registration Successfull");

        return res;
    }

// Registration Completes

    //Login
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
                res.put("userId",userModel.getUserId());
                res.put("UserType",userModel.getUserType());
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

    //COMAPNY LOGIN
    public Object companyLogin(long comp_id) {
        CompanyModel  companyModel=companyRepository.findBycompId(comp_id);
        Map<String,Object> res = new HashMap<>();
        if(companyModel!=null)
        {
                res.put("response","true");
                res.put("Message","Login Successfull");
                res.put("compId",companyModel.getCompId());
                res.put("compName",companyModel.getCompName());
                return res;
        }

        else
        {
            res.put("response","false");
            res.put("Message","company Id is not Registered");
            return res;
        }

    }

    //==========  LOGIN COMPLETES  ===============

//forgot password
    public Map<String,Object> forgotpassword(String email) throws IOException {
        UserModel userModel=userRepository.findOneByEmail(email);
        Map<String,Object> res = new HashMap<>();
        if(userModel!=null)
        {
            Email from = new Email("theengineersbook@gmail.com");
            String subject = "This is a test email";
            Email to = new Email("abhishekkoranne@gmail.com");
            String token=getSaltString();
            Content content = new Content("text/plain", "PLease do not reply to this mail."+
            " The token is "+token);
            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid("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");
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                res.put("statuscode",response.getStatusCode());
                res.put("body",response.getBody());
                res.put("header",response.getHeaders());
                res.put("response",true);
            } catch (IOException ex) {
                throw ex;
            }
        }
        else res.put("Message","Email Id not yet Registered");

        return res;
    }

//UPDATING

    //update likes
    public Map<String,Object> updateLikes(Long articleId){
        Map<String,Object> res = new HashMap<>();

        ArticlesModel articlesModel=articleRepository.findByArticleId(articleId);
        if(articlesModel!=null) {
            articlesModel.setLikes(articlesModel.getLikes() + 1);
            res.put("response", true);
            return res;
        }
        res.put("response",false);
        return res;
    }

    public Map<String,Object> doubtDownvote(long doubt_id) {
        Map<String,Object> res = new HashMap<>();

        DoubtModel doubtModel=doubtRepository.findByDoubtId(doubt_id);
        if(doubtModel!=null) {
            doubtModel.setDownvote(doubtModel.getDownvote() + 1);
            res.put("response", true);
            return res;
        }
        res.put("response",false);
        return res;
    }

    public Map<String,Object> doubtUpvote(long doubt_id) {

        Map<String,Object> res = new HashMap<>();

        DoubtModel doubtModel=doubtRepository.findByDoubtId(doubt_id);
        if(doubtModel!=null) {
            doubtModel.setUpvote(doubtModel.getUpvote() + 1);
            res.put("response", true);
            return res;
        }
        res.put("response",false);
        return res;
    }


    public Map<String,Object> answerDownvote(long answer_id) {
        Map<String,Object> res = new HashMap<>();

        AnswerModel answerModel=answerRepository.findByAnswerId(answer_id);
        if(answerModel!=null) {
            answerModel.setDownvote(answerModel.getDownvote() + 1);
            res.put("response", true);
            return res;
        }
        res.put("response",false);
        return res;
    }

    public Map<String,Object> answerUpvote(long answer_id) {
        Map<String,Object> res = new HashMap<>();

        AnswerModel answerModel=answerRepository.findByAnswerId(answer_id);
        if(answerModel!=null) {
            answerModel.setUpvote(answerModel.getUpvote() + 1);
            res.put("response", true);
            return res;
        }
        res.put("response",false);
        return res;
    }

//ENDING UPDATE

    public Map<String, Object> setImage(HttpServletRequest request, MultipartHttpServletRequest mRequest, String type)
            throws SQLException, IOException {
        Map<String, Object> mresponse = new HashMap<>();
        mRequest.getParameterMap();
        String username=userRepository.findByUserId(Long.valueOf(request.getParameter("user_id")))
                .getFname();
        Iterator itr = mRequest.getFileNames();
        while (itr.hasNext()) {
            MultipartFile mFile = mRequest.getFile((String) itr.next());
            String fileName = mFile.getOriginalFilename();
            System.out.println(fileName);
            //String.valueOf(request.getServletContext().getRealPath("/"))+
            //String.valueOf(request.getServletContext().getRealPath("/"))+
            try {
                if (!new File( "C:\\Users\\Shabbir Hussain\\Desktop\\project\\a\\EngBook\\src\\main\\resources\\images\\"
                        +type+"\\"
                        +username .replaceAll(" ", "")).exists()) {
                    mresponse.put("is_created",
                            new File( "C:\\Users\\Shabbir Hussain\\Desktop\\project\\a\\EngBook\\src\\main\\resources\\images\\"
                                    +type+"\\"
                                    + username.replaceAll(" ", "")).mkdir());
                }
//String.valueOf(request.getServletContext().getRealPath("/"))+
                String filepath =  "C:\\Users\\Shabbir Hussain\\Desktop\\project\\a\\EngBook\\src\\main\\resources\\images\\"
                        +type+"\\"
                        + username.replaceAll(" ", "") + "//" + fileName;
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
                FileCopyUtils.copy((InputStream) mFile.getInputStream(), (OutputStream) stream);
                stream.close();


            } catch (Exception e) {
                throw e;
            }

        }
        return mresponse;
    }

    //getarticle
    public Map<String,Object> getArticle(Long userId, Long deptId, Pageable pageable) {
        Map<String,Object> res = new HashMap<>();
        List<ArticlesModel> articlesModelList=new ArrayList<>();
        UserModel userModel1=knowUserModel(userId);
        articlesModelList=articleRepository.findAllByUserModelNotAndDeptId(userModel1,deptId,pageable);
        res.put("response","true");
        List<String> userInfo=new ArrayList<>();
        List<Integer> comments=new ArrayList<>();
        for (int i = 0; i <articlesModelList.size() ; i++) {
         //articlesModelList.get(i).setUserModel(userRepository.findByUserId(articlesModelList.get(i).getUserModel().getUserId()));
            comments.add(i,  commentRepository.findByArticleId(articlesModelList.get(i).getArticleId()));
            userInfo.add(i,userRepository.findByUserId(articlesModelList.get(i).getUserModel().getUserId()));
        }
        res.put("ArticleList",articlesModelList);
        res.put("numberOfCommmentsList",comments);
        res.put("corresponding user info",userInfo);
        return res;
    }


    //GetComment
    public Map<String,Object> getComment(Long article_id,Pageable pageable) {
        Map<String,Object> res = new HashMap<>();

        List<CommentModel> commentModelList=new ArrayList<>();
        commentModelList=commentRepository.findAllByArticleId(article_id,pageable);
        res.put("response","true");
        List<String> userInfo=new ArrayList<>();
        for (int i = 0; i <commentModelList.size() ; i++) {
            userInfo.add(i,userRepository.findByUserId(commentModelList.get(i).getUserModel().getUserId()));
        }
        res.put("CommentList",commentModelList);
        res.put("corresponding user info",userInfo);
        return res;
    }


    //GETDoubtList
    public Map getDoubtList(Long userId, Long departmentID, Pageable pageable) {
        Map<String,Object> res = new HashMap<>();

        List<DoubtModel> doubtModelList=new ArrayList<>();
        List<Integer> noOfAnswer=new ArrayList<>();
        UserModel userModel1=knowUserModel(userId);
        doubtModelList=doubtRepository.findAllByUserModelNotAndDeptId(userModel1,departmentID,pageable);
        res.put("response","true");
        List<String> userInfo=new ArrayList<>();
        for (int i = 0; i <doubtModelList.size() ; i++) {
            noOfAnswer.add(i,answerRepository.findByDoubtId(doubtModelList.get(i).getDoubtId()));
            userInfo.add(i,userRepository.findByUserId(doubtModelList.get(i).getUserModel().getUserId()));
        }
        res.put("Doubtlist",doubtModelList);
        res.put("no Of Corresponding Answers",noOfAnswer);
        res.put("corresponding user info",userInfo);
        return res;
    }


//GetAnswer
    public Map getAnswer(Long doubtId, Pageable pageable) {
        Map<String,Object> res = new HashMap<>();

        List<AnswerModel> ansewerList=new ArrayList<>();
        ansewerList=answerRepository.findAllByDoubtId(doubtId,pageable);
        List<String> userInfo=new ArrayList<>();
        for (int i = 0; i <ansewerList.size() ; i++) {
            userInfo.add(i,userRepository.findByUserId(ansewerList.get(i).getUserModel().getUserId()));
        }
        res.put("response","true");
        res.put("Answer List",ansewerList);
        res.put("corresponding user info",userInfo);
        return res;
    }
    // END OF RETRIEVAL


    //ADDING THINGS

    //ADDING ARTICLE
    public Map<String,Object> addArticle(ArticlesModel articlesModel) {
        Map<String,Object> res = new HashMap<>();
        articleRepository.save(articlesModel);
        res.put("response",true);
        return res;
    }

    public Map<String,Object> addComment(CommentModel commentModel) {
        Map<String,Object> res = new HashMap<>();
        commentRepository.save(commentModel);
        res.put("response",true);
        return res;
    }

    public Map<String,Object> addDoubt(DoubtModel doubtModel) {
        Map<String,Object> res = new HashMap<>();
        doubtRepository.save(doubtModel);
        res.put("response",true);
        return res;
    }

    public Map<String,Object> addAnswer(AnswerModel answerModel) {
        Map<String,Object> res = new HashMap<>();
        answerRepository.save(answerModel);
        res.put("response",true);
        return res;
    }


    public String getComapnyList() {
        String response=companyRepository.findString();
        return response;
    }

    public Object getYearWisePlacement(long comp_id) {
        Object response=studentRepository.findByCompId(comp_id);
        return response;

    }
}
