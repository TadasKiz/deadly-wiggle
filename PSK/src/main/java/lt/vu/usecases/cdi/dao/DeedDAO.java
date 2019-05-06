package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Deed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DeedDAO {
    @Inject
    private EntityManager em;

    public void create(Deed deed) {
        em.persist(deed);
    }

    public List<Deed> getAllDeeds() {
        return em.createNamedQuery("Deed.findAll", Deed.class).getResultList();
    }
}
