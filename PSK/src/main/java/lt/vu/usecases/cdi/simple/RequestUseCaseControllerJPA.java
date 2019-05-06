package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Deed;
import lt.vu.entities.Employee;
import lt.vu.usecases.cdi.dao.DeedDAO;
import lt.vu.usecases.cdi.dao.EmployeeDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Deed deed = new Deed();
    @Getter
    private Employee employee = new Employee();
    @Getter
    private List<Employee> allEmployees;

    @PostConstruct
    public void init() {
        loadAllEmployees();
    }

    @Inject
    private DeedDAO deedDAO;
    @Inject
    private EmployeeDAO employeeDAO;

    @Transactional
    public void createDeedEmployee() {
        employee.getDeedList().add(deed);
        deed.getEmployeeList().add(employee);
        deedDAO.create(deed);
        employeeDAO.create(employee);
        log.info("Maybe OK...");
    }

    private void loadAllEmployees() {
        allEmployees = employeeDAO.getAllEmployees();
    }
}
