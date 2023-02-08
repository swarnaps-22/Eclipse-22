package com.sba.SMS;

import com.sms.controller.courseController;
import com.sms.controller.studentController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       courseController courses= new courseController();
       studentController students= new studentController();
       students.createStudent();
       courses.createCourse();
    }
}
