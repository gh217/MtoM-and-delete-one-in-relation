package controller;


import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Set;

import model.UserDetails;
import model.Vechicle;


public class Main {

	public static void main(String[] args) {
		
//		UserDetails user = new UserDetails();
//		user.setUserName("mohamed");
//		
//		Vechicle vec = new Vechicle();
//		vec.setVechicleName("car");
//		
//		Vechicle vec2 = new Vechicle();
//		vec2.setVechicleName("moto");
//		
//		user.getVechicle().add(vec);
//		user.getVechicle().add(vec2);
//		
//		
//		vec.getUserList().add(user);
//		vec2.getUserList().add(user);
		
//		
        try {
        	
        	SessionFactory factory = new Configuration()
    				.configure("config.xml")			
    				.addAnnotatedClass(UserDetails.class)
    				.addAnnotatedClass(Vechicle.class)
    				.buildSessionFactory();
            
            Session session = factory.openSession();
        	session.beginTransaction();
       
//        	session.save(user);
//        	session.save(vec);
//        	session.save(vec2);
        	
//        	
        	Vechicle v = session.get(Vechicle.class,2);
        	
        	for( UserDetails user1 : v.getUserList()) {
        		 System.out.println(user1.getUserId());
        	}
//        	
//        	for( UserDetails user1 : v.getUserList()) {
//        		if(user1.getUserId()==1) {
//        			v.remov(user1);
//        		}
//        	}
//        	
        	
//        	UserDetails user = session.get(UserDetails.class, 28);
//        	        	
//    		for(Vechicle v : user.getVechicle()) {
//    			if(v.getVehicleId()==29)
//    				user.remov(v);
//    		}
//    		
            session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.getStackTrace();
			return;
		}
		System.out.println("Done");
		
		
	}

}
