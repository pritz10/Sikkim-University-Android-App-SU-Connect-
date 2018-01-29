package com.pritz.sikkimuniversity;

/**
 * Created by rob on 12/3/17.
 */

public class TeacherDetailsProvider {
    private int image;//teachers images
    private String teacher_name;
    private String teacher_details;
    private String Phno;
    private String emailid;
    private String ass;//department names
    private int images;//department image
    public TeacherDetailsProvider(int image, String teacher_name, String teacher_details, String Phno, String emailid){
        this.setImage(image);
        this.setTeacher_name(teacher_name);
        this.setTeacher_details(teacher_details);
        this.setPhno(Phno);
        this.setEmailid(emailid);
    }
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getPhno() {
        return Phno;
    }

    public void setPhno(String phno) {
        Phno = phno;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_details() {
        return teacher_details;
    }

    public void setTeacher_details(String teacher_details) {
        this.teacher_details = teacher_details;
    }
    public TeacherDetailsProvider(String dept_names){

        this.setAss(dept_names);
    }
    public String getAss() {return ass;}

    public void setAss(String ass) {
        this.ass = ass;
    }


}
