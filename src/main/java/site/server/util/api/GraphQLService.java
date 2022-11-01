package site.server.util.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.inject.Qualifier;
import jakarta.inject.Singleton;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Singleton
public @interface GraphQLService {

}
