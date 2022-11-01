package site.server.layout.dao;

import site.server.layout.model.Link;
import site.server.layout.model.LinkType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Optional;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
public interface LinkRepository {

    Optional<Link> findById(long id);

    Link save(@NotBlank String title, @NotBlank LinkType type, @NotBlank String url);

    void deleteById(long id);

    Link update(@NotNull Link link);
}
