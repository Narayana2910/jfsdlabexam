package com.klef.jfsd.exam.jfsdendlab;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        
        Device device = new Device();
        device.setBrand("Generic");
        device.setModel("G123");
        device.setPrice(100.0);
        session.save(device);

        
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(1200.0);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12 MP");
        session.save(smartphone);

      
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S8");
        tablet.setPrice(800.0);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("14 hours");
        session.save(tablet);

        
        transaction.commit();

        
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully!");
    }
}

