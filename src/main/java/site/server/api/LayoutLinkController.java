package site.server.api;

import java.util.List;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import site.server.layout.dao.LinkRepository;
import site.server.layout.model.Link;
import site.server.layout.model.LinkType;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@ExecuteOn(TaskExecutors.IO)
@Controller("/Links")
public class LayoutLinkController {

    private final LinkRepository linkRepository;

    LayoutLinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Get("/{id}")
    @Secured(SecurityRule.IS_ANONYMOUS)
    Link getById(long id) {
        return linkRepository.findById(id).orElse(new Link("no link available", LinkType.EXTERNAL, "www.noLink.com/noLink"));
    }

    //TODO: impl
    @Get("/list")
    @Secured(SecurityRule.IS_ANONYMOUS)
    List<Link> list() {
        return null;
    }

    //TODO: impl
    @Post
    @Secured(SecurityRule.IS_ANONYMOUS)
    Link create() {
        return null;
    }

    //TODO: impl
    @Put
    @Secured(SecurityRule.IS_ANONYMOUS)
    Link update() {
        return null;
    }

    //TODO: impl
    @Delete
    @Secured(SecurityRule.IS_ANONYMOUS)
    Link delete() {
        return null;
    }

}
