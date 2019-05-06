package lt.vu.usecases.ejb;

import lombok.Getter;
import lt.vu.entities.Deed;
import lt.vu.entities.Employee;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Named
@ConversationScoped
@Stateful
public class ConversationUseCaseControllerEjb implements Serializable {

    private static final String PAGE_INDEX_REDIRECT = "conversation-ejb?faces-redirect=true";

    private enum CURRENT_FORM {
        CREATE_DEED, CREATE_EMPLOYEE, CONFIRMATION
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    @Inject
    @Getter
    private Conversation conversation;

    @Inject
    private DeedEjbDAO deedEjbDAO;
    @Inject
    private EmployeeEjbDAO employeeEjbDAO;

    @Getter
    private Deed deed = new Deed();
    @Getter
    private Employee employee = new Employee();

    private CURRENT_FORM currentForm = CURRENT_FORM.CREATE_DEED;
    public boolean isCurrentForm(CURRENT_FORM form) {
        return currentForm == form;
    }

    /**
     * The first conversation step.
     */
    public void createDeed() {
        conversation.begin();
        currentForm = CURRENT_FORM.CREATE_EMPLOYEE;
    }

    /**
     * The second conversation step.
     */
    public void createEmployee() {
        employee.getDeedList().add(deed);
        deed.getEmployeeList().add(employee);
        currentForm = CURRENT_FORM.CONFIRMATION;
    }

    /**
     * The last conversation step.
     */
    public String ok() {
        try {
            deedEjbDAO.create(deed);
            employeeEjbDAO.create(employee);
            em.joinTransaction();
            em.flush();
            Messages.addGlobalInfo("Success!");
        } catch (OptimisticLockException ole) {
            // Other user was faster...
            Messages.addGlobalWarn("Please try again");
        } catch (PersistenceException pe) {
            // Some problems with DB - most often this is programmer's fault.
           Messages.addGlobalError("Finita la commedia...");
        }
        Faces.getFlash().setKeepMessages(true);
        conversation.end();
        return PAGE_INDEX_REDIRECT;
    }

    /**
     * The last (alternative) conversation step.
     */
    public String cancel() {
        conversation.end();
        return PAGE_INDEX_REDIRECT;
    }

    public List<Employee> getAllEmployees() {
        return employeeEjbDAO.getAllEmployees();
    }
}
