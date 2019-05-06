package lt.vu.usecases.cdi.optimisticlock;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Deed;
import lt.vu.entities.Employee;
import lt.vu.entities.Company;
import lt.vu.usecases.cdi.dao.DeedDAO;
import lt.vu.usecases.cdi.dao.EmployeeDAO;
import lt.vu.usecases.cdi.dao.CompanyDAO;
import org.hibernate.Hibernate;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
@Slf4j
public class EditEmployeeUseCaseController implements Serializable {

    /*
     * Būsena, kurią saugome ViewScoped kontekste:
     */
    @Getter private Employee selectedEmployee;
    @Getter private Employee conflictingEmployee;
    @Getter private List<Employee> allEmployees;
    @Getter private List<Company> allCompanies;
    @Getter private List<Deed> allDeeds;

    /*
     * DAO:
     */
    @Inject private EmployeeDAO employeeDAO;
    @Inject private DeedDAO deedDAO;
    @Inject private CompanyDAO companyDAO;

    @PostConstruct
    public void init() {
        reloadAll();
    }

    public void prepareForEditing(Employee employee) {
        selectedEmployee = employee;
        conflictingEmployee = null;
    }

    @Transactional
    public void updateSelectedEmployee() {
        try {
            employeeDAO.updateAndFlush(selectedEmployee);
            reloadAll();
        } catch (OptimisticLockException ole) {
            conflictingEmployee = employeeDAO.findById(selectedEmployee.getId());
            // Pavyzdys, kaip inicializuoti LAZY ryšį, jei jo reikia HTML puslapyje:
            Hibernate.initialize(conflictingEmployee.getDeedList());
            // Pranešam PrimeFaces dialogui, kad užsidaryti dar negalima:
            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }

    @Transactional
    public void overwriteEmployee() {
        selectedEmployee.setOptLockVersion(conflictingEmployee.getOptLockVersion());
        updateSelectedEmployee();
    }

    public void reloadAll() {
        allEmployees = employeeDAO.getAllEmployees();
        allCompanies = companyDAO.getAllCompanies();
        allDeeds = deedDAO.getAllDeeds();
    }
}
