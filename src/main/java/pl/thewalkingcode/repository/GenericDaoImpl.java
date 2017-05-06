package pl.thewalkingcode.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDaoImpl<T extends Serializable, PK> implements GenericDao<T, PK> {

    private Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public final void setEntityClass(final Class<T> classToSet) {
        this.entityClass = classToSet;
    }

    @Override
    public T create(T t) {
        this.entityManager.persist(t);
        this.entityManager.flush();
        return t;
    }

    @Override
    public T update(T t) {
        return this.entityManager.merge(t);
    }

    @Override
    public T read(PK pk) {
        return this.entityManager.find(entityClass, pk);
    }

    @Override
    public List<T> readAll() {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(entityClass);
        criteria.select(criteria.from(entityClass));
        return this.entityManager.createQuery(criteria).getResultList();
    }

}
