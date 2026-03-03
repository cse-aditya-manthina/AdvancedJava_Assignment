package com.capgemini.hibernate.hybernate2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

      //   Create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("myPersistenceUnit");

        // Create EntityManager
        EntityManager em = emf.createEntityManager();

        // Begin Transaction
        em.getTransaction().begin();

        //  Create objects
        Account account = new Account();
        account.setAccountNumber("ACC12345");
        account.setAccountType("Savings");

        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setAccount(account);

        // Set bidirectional relationship
        account.setCustomer(customer);

        //  Persist customer (Account will persist due to CascadeType.ALL)
        em.persist(customer);

        //   Commit transaction
        em.getTransaction().commit();

        System.out.println("Customer and Account saved successfully");

        em.close();
        emf.close();
    }
}