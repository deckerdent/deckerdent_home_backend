package site.server.layout.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@Entity
@Table(name = "LAYOUT_LINKS")
public class Link {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @NotNull
    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @NotNull
    @Column(name = "type", nullable = false)
    private LinkType type;

    @NotNull
    @Column(name = "url", nullable = false)
    private String url;

    public Link(String title, LinkType type, String url) {
        this.title = title;
        this.type = type;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkType getType() {
        return type;
    }

    public void setType(LinkType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
