import com.infosys.domain.Employee;
public interface EmployeeDAO {
    // Method to insert employee record into Employee table
     public void insert(Employee employee);
    // Method to delete a record 
    public int delete(int empId);
}
