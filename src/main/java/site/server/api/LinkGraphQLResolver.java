package site.server.api;

import java.util.LinkedList;
import java.util.List;

import site.server.layout.dao.LinkRepository;
import site.server.layout.model.Link;
import site.server.layout.model.LinkType;
import site.server.util.api.GraphQLService;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@GraphQLService
public class LinkGraphQLResolver {

    private final LinkRepository linkRepository;

    LinkGraphQLResolver(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    /*Link getById(long id) {
        return linkRepository.findById(id).orElse(new Link("no link available", LinkType.EXTERNAL, "www.noLink.com/noLink"));
    }*/

 /*List<Link> getAll() {
        List list = new LinkedList<Link>();
        list.add(new Link("no link available", LinkType.EXTERNAL, "www.noLink.com/noLink"));
        list.add(new Link("another link not available", LinkType.EXTERNAL, "www.noLink2.com/noLink2"));
        return list;
        //return linkRepository.findAll();
    }*/
}
