package raneShubham;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDAO {

    Configuration con = new Configuration();
    SessionFactory sf = con.buildSessionFactory();
    Session s = sf.openSession();
    s.save();

}
