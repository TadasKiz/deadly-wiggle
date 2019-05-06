package lt.vu.usecases.ejb;

import lt.vu.entities.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.util.List;

@Stateless
public class EmployeeEjbDAO {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> getAllEmployees() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
