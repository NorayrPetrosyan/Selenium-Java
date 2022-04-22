package Selectors;

import java.util.HashMap;

public class Selectors {

    public HashMap<String,String> selectors = new HashMap<>();

    public Selectors(){
        selectors.put("Task one button", "[href='/task_1']");
        selectors.put("Task two button","[href='/task_2']");
        selectors.put("Task three button","[href='/task_3']");
        selectors.put("Task four button","[href='/task_4']");
        selectors.put("Task five button","[href='/task_5']");
        selectors.put("Task six button", "[href='/task_6/logged']");
        selectors.put("Task seven button","[href='/task_7']");
        selectors.put("Task eight button","[href='/task_8']");
        selectors.put("Task nine button","[href='/task_9']");
        selectors.put("Task one page", "task_1");
        selectors.put("Task two page", "task_2");
        selectors.put("Task three page", "task_3");
        selectors.put("Task four page", "task_4");
        selectors.put("Task five page", "task_5");
        selectors.put("Task six page", "task_6");
        selectors.put("Task seven page", "task_7");
        selectors.put("Task eight page", "task_8");
        selectors.put("Task nine page", "task_9");
        selectors.put("filter container","[class='select2-selection__rendered']");
        selectors.put("filter search field","[type='search']");
        selectors.put("upload button in Task three page","[id='in-file']");
        selectors.put("save button","[id='save-btn']");
        selectors.put("apply button","button");
        selectors.put("name field","[name='name']");
        selectors.put("email field","[name='email']");
        selectors.put("tel. number field","[name='phone']");
        selectors.put("upload button in Task five page","[type='file']");
        selectors.put("login field","[id='LoginForm__username']");
        selectors.put("password field","[id='LoginForm__password']");
        selectors.put("login button","[id='LoginForm_save']");
        selectors.put("logout button","[id='logout']");
        selectors.put("download button","[href='/task_6/download']");
        selectors.put("card type container","[id='task8_form_cardType']");
        selectors.put("month container","[id='task8_form_cardInfo_month']");
        selectors.put("year container","[id='task8_form_cardInfo_year']");
        selectors.put("full name field","[id='task8_form_name']");
        selectors.put("card No field","[id='task8_form_cardNumber']");
        selectors.put("cvv code field","[id='task8_form_cardCvv']");
        selectors.put("pay button","[type='submit']");
        selectors.put("successful registration message","[class='notifyjs-bootstrap-base']");
        selectors.put("invalid login message","[class='alert alert-danger']");
        selectors.put("successful payment message","[class='alert alert-success']");
        selectors.put("card expiration message","[class='alert alert-danger']");
        selectors.put("CVV information","[class='tooltip fade top in']");
        selectors.put("invalid CVV code message","[class='glyphicon glyphicon-exclamation-sign']");
        selectors.put("first name field", "[id='in-name']");
        selectors.put("surname field", "[id='in-surname']");
        selectors.put("phone number field", "[id='in-phone']");
        selectors.put("notes field", "[id='in-notes']");
    }

}
