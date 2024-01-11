@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    Long id;
    String firstname;
    String lastname;
@Service
public class EmpServ {
    @Autowired
    EmployeeRepository employeeRepository;
    @Transactional
    public void save(Employee employee){
        employeeRepository.save(employee);
    }
}
   import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.stereotype.Service;


public class Run implements CommandLineRunner {
    @Autowired
    EmpServ empServ;
    @Override
    public void run(String... args) throws Exception {
        Employee employee=new Employee();
        employee.setId(4L);
        employee.setFirstname("Ali");
        employee.setLastname("Ataeifar ");
        empServ.save(employee);

    }
}
