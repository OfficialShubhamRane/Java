package com.shubham.rane;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;

import com.sun.xml.bind.v2.model.core.ID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Entered in main" );
        
        Student objStudent = new Student();
//        objStudent.setName("Shubham");
//        objStudent.setRollNo(4);
        
        //Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        
        //create object of session factory
        SessionFactory sf = cfg.buildSessionFactory();
        
        //create object of session
        Session session = sf.openSession();
        
        //transaction created to follow ACID properties
        Transaction tx = session.beginTransaction();
        
        //use session object to save data
//        session.save(objStudent);
        objStudent = (Student) session.get(Student.class, 4);
        
        //commit the transaction
        tx.commit();
        
        System.out.println(objStudent);
        System.out.println( "Exiting from main" );
    }
}
