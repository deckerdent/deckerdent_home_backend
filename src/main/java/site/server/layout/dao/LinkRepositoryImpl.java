package site.server.layout.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import site.server.configuration.DatabaseConfiguration;
import site.server.layout.model.Link;
import site.server.layout.model.LinkType;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@Singleton
public class LinkRepositoryImpl implements LinkRepository {

    private final EntityManager entityManager;
    private final DatabaseConfiguration databaseConfiguration;

    public LinkRepositoryImpl(EntityManager entityManager, DatabaseConfiguration databaseConfiguration) {
        this.entityManager = entityManager;
        this.databaseConfiguration = databaseConfiguration;
    }

    @Override
    @ReadOnly
    public Optional<Link> findById(long id) {
        return Optional.ofNullable(entityManager.find(Link.class, id));
    }

    public List<Link> findAll() {
        return entityManager.createQuery("from LAYOUT_LINKS").getResultList();
    }

    @Override
    @Transactional
    public Link save(String title, LinkType type, String url) {
        Link link = new Link(title, type, url);
        this.entityManager.persist(link);
        return link;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        this.findById(id).ifPresent(this.entityManager::remove);
    }

    @Override
    @Transactional
    public Link update(Link link) {
        return this.entityManager.merge(link);

    }

}
