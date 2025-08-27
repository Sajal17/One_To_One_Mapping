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

       /* Student student=em.find(Student.class,1);
        if(student !=null){
            System.out.println("Student :"+student);
            System.out.println("StudentDetail :"+student.getStudentDetail());
        } else {
            System.out.println("Student not found");
        } */

        //Update

      /*  Student student=em.find(Student.class,1);
        if(student!=null){
            StudentDetail sd=student.getStudentDetail();
            sd.setCollege("IIT");
            sd.setCgpa(8.5);
            student.setLastName("Dey");
            em.merge(student);
            System.out.println("Updated StudentDetail: "+sd);
        }else {
            System.out.println("Student not found !");
        } */


        //Delete

       /* Student student=em.find(Student.class,1);
        if(student !=null){
            em.remove(student);
            System.out.println("Deleted Student and linked StudentDetail");
        }else {
            System.out.println("Student not found..");
        } */


        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}
