package site.server.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@ConfigurationProperties("database")
public class DatabaseConfigurationProperties implements DatabaseConfiguration {

    private final int DEFAULT_MAX = 10;
    private int max = DEFAULT_MAX;

    @Override
    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
