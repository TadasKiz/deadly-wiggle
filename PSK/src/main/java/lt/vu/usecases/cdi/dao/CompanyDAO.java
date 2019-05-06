package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Company;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CompanyDAO {
    @Inject
    private EntityManager em;

    public void create(Company company) {
        em.persist(company);
    }

    public List<Company> getAllCompanies() {
        return em.createNamedQuery("Company.findAll", Company.class).getResultList();
    }
}
