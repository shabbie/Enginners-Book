package com.gtu.EngBook.service;

import com.gtu.EngBook.model.StudentModel;
import com.gtu.EngBook.model.UserModel;
import com.gtu.EngBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean studentRegister(StudentModel st)
    {

        return false;
    }

    public String login(UserModel st)
    {

       // String enroll = st.getEmail();
       // String pass = st.getPassword();

        if(userRepository.findOneByEmail(st.getEmail(),st.getPassword()))
        {
            return "Login Successful";
        }
        else return "Login UnSuccessful";

       //userRepository.findOne("140410107002");

        /*if(enroll.equals("140410107024"))
        {
            if(pass.equals("abhishek"))
            {
                st.setLogin_status(true);
            }
            else
            {
                st.setLogin_status(false);
            }
        }
        else
        {
            st.setLogin_status(false);
        }*/

    }
}
