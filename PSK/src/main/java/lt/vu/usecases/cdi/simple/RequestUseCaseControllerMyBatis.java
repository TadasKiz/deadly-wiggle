package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.DeedMapper;
import lt.vu.usecases.mybatis.dao.EmployeeDeedMapper;
import lt.vu.usecases.mybatis.dao.EmployeeMapper;
import lt.vu.usecases.mybatis.model.Deed;
import lt.vu.usecases.mybatis.model.Employee;
import lt.vu.usecases.mybatis.model.EmployeeDeed;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

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
    private EmployeeMapper employeeMapper;
    @Inject
    private DeedMapper deedMapper;
    @Inject
    private EmployeeDeedMapper employeeDeedMapper;

    @Transactional
    public void createDeedEmployee() {
        deedMapper.insert(deed);
        employeeMapper.insert(employee);
        EmployeeDeed employeeDeed = new EmployeeDeed();
        employeeDeed.setDeedId(deed.getId());
        employeeDeed.setEmployeeId(employee.getId());
        employeeDeedMapper.insert(employeeDeed);
        log.info("Maybe OK...");
    }

    private void loadAllEmployees() {
        allEmployees = employeeMapper.selectAll();
    }
}
