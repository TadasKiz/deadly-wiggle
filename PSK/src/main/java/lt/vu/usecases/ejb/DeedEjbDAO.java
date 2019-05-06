package lt.vu.usecases.ejb;

import lt.vu.entities.Deed;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;

@Stateless
public class DeedEjbDAO {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Deed deed) {
        em.persist(deed);
    }
}
