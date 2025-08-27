package com.sa.controller;

import com.sa.entity.Student;
import com.sa.entity.StudentDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class OneToOne {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("myPU");
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();

        // Create/ Insertion
        StudentDetail sd=new StudentDetail();
        sd.setCollege("SIT");
        sd.setCgpa( 8.2);
        em.persist(sd); //Persist the student details

        Student student=new Student();
        student.setFirstName("Ram");
        student.setLastName("Roy");
        student.setEmail("ram123@gmail.com");

        student.setStudentDetail(sd); // Link only one way

        em.persist(student);

        //Fetch by primary key

        Student student1=em.find(Student.class,1);
        if(student1 !=null){
            System.out.println("Student :"+student1);
            System.out.println("StudentDetail :"+student.getStudentDetail());
        } else {
            System.out.println("Student not found");
        } 

        //Update

       Student student3=em.find(Student.class,1);
        if(student3!=null){
            StudentDetail sd1=student3.getStudentDetail();
            sd2.setCollege("IIT");
            sd2.setCgpa(8.5);
            student3.setLastName("Dey");
            em.merge(student3);
            System.out.println("Updated StudentDetail: "+sd2);
        }else {
            System.out.println("Student not found !");
        } 


        //Delete

      Student student4=em.find(Student.class,1);
        if(student4 !=null){
            em.remove(student4);
            System.out.println("Deleted Student and linked StudentDetail");
        }else {
            System.out.println("Student not found..");
        } 


        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}

