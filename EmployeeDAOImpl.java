package com.infosys.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.infosys.domain.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    public void setEntityManagerFactory (EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public void insert(Employee employee){
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }
    public int delete(int empId) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int result=0; 
        try{
             Employee emp = (Employee) entityManager.find(Employee.class, empId);
             entityManager.remove(emp);
             result=1;
             entityManager.getTransaction().commit();
        }
        catch(Exception e){
             entityManager.getTransaction().rollback();
        }
        entityManager.close();
        return result;
    }
}
