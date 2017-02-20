package hibernate.connection;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.model.Department;
import hibernate.model.Employee;
 
public class HibernateTest {
 
public static void main(String[] args) {
          
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
 
        Department department = new Department("sql");
        session.save(department);
 
        session.save(new Employee("bharath",department));
        session.save(new Employee("sushma",department));
      
        session.getTransaction().commit();
 
        List<Employee> resultList = session.createQuery("From Employee ").list();
                 
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
 
    }
    
}
