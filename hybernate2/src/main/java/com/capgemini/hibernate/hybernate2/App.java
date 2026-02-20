package com.capgemini.hibernate.hybernate2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // step 1 : create entitymanagerFactory
    	EntityManagerFactory emf = Presistance.createEntityManagerFactory("myPresistanceUnit");
    	// step 2: create entityManager
    	EntityManager em= emf.createEntityManger();
    	// step 3: Begin Transaction
    	em.getTransaction().begin();
    	
    	//step4: create objects
    	Account account = new Account("ACC12345","Savings");
    	Customer customer = new Customer("John Doe",account);
    	// set bidirectional relationship
    	account.setCustomer(customer);
    	
    	// step 5: presist customer (account will aslo presist if cascade is used
    	em.presist(custonmer);
    	// strep 6: commit transaction
    	
    	em.getTransaction().commit();
    	System.out.println("customer and account saved successfully");
    	
    }
}
