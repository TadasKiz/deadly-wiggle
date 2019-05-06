package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class EmployeeDAO {
    @Inject
    private EntityManager em;

    public void create(Employee employee) {
        em.persist(employee);
    }
    public void updateAndFlush(Employee employee) {
        em.merge(employee);
        em.flush();
    }

    public List<Employee> getAllEmployees() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public Employee findById(Integer id) {
        return em.find(Employee.class, id);
    }
}
