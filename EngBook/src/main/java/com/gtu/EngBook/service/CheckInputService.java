package com.gtu.EngBook.service;

import com.gtu.EngBook.model.ArticlesModel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckInputService {

    public Map<String,Object> inputText(String text)
    {
        HashMap<String,Object> mresponse=new HashMap<>();
        if(text.length()>1000)
        {
            mresponse.put("response",false);
            mresponse.put("message","Text size should not exceed 1000 characters");
        }
        else {
            mresponse.put("response",true);
        }
        return mresponse;
    }

    public Map<String,Object> inputDOB(long dob)
    {
        HashMap<String,Object> mresponse=new HashMap<>();


        if(dob>System.currentTimeMillis()) {
            mresponse.put("response",false);
            mresponse.put("message","Invalid date");
        }
        else mresponse.put("response",true);
        return mresponse;
    }

}
