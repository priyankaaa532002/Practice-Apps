package com.example.studyhubpriyanka2;

public class branches {
    private String subject;
    private String code;
    private String credits;
    private String modules;

    public branches(String subject, String code, String credits, String modules){
        this.code = code;
        this.credits = credits;
        this.modules = modules;
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
    public String getCode(){
        return code;
    }
    public String getCredits(){
        return credits;
    }
    public String getModules(){
        return modules;
    }

}



