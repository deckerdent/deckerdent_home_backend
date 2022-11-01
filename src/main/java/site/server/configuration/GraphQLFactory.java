package site.server.configuration;

import java.util.Collection;

import graphql.GraphQL;
import graphql.GraphQL.Builder;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.inject.qualifiers.Qualifiers;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import site.server.util.api.GraphQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DESC
 *
 * @author DeckerM7
 * @since 0.0.1
 * @version 0.0.1
 */
//Copied from 
//https://lifeinide.com/post/2019-04-15-micronaut-graphql-with-transaction-and-security-support/#:~:text=Micronaut%20is%20a%20brand-new%20framework%20from%20Grails%20creators,popular%20standard%20to%20query%20backend%20data%20with%20JSON.
@Factory
public class GraphQLFactory {

    public static final Logger logger = LoggerFactory.getLogger(GraphQLFactory.class);

    @Inject
    protected BeanContext beanContext;

    @Bean
    @Singleton
    public GraphQL getGraphQLInstance() {
        GraphQLSchemaGenerator schemaGenerator = new GraphQLSchemaGenerator();

        Collection graphQLServices = beanContext.getBeansOfType(Object.class, Qualifiers.byStereotype(GraphQLService.class));

        if (graphQLServices.isEmpty()) {
            this.logNoServiceWarning();
            return new Builder(GraphQLSchema.newSchema().build())
                    .build();
        } else {
            for (Object graphQLService : graphQLServices) {
                Class graphQLServiceClass = graphQLService.getClass();
                this.logServiceFoundInfo(graphQLServiceClass.getSimpleName());
                if (graphQLServiceClass.getSimpleName().contains("$Intercepted")) {
                    this.logServiceInterceptedWarning();
                    graphQLServiceClass = graphQLServiceClass.getSuperclass();
                }
                this.logRegisterServiceInfo(graphQLServiceClass.getSimpleName());
                schemaGenerator.withOperationsFromSingleton(graphQLService, graphQLServiceClass);
            }
        }
        GraphQLSchema schema = schemaGenerator.generate();
        this.logSchemaDEBUG(schema.toString());
        return new GraphQL.Builder(schema).build();
    }

    private void logNoServiceWarning() {
        String msg = "No class with @GraphQLService Annotation found. Return empty schema. \nMake sure at least one Service is available to avoid a NullPointerException";
        this.logger.warn(msg);
    }

    private void logServiceFoundInfo(String serviceName) {
        String msg = "GraphQL service found. class name: {}.";
        this.logger.info(msg, serviceName);
    }

    private void logServiceInterceptedWarning() {
        String msg = "GraphQL service is $Intercepted class. Try to register super class instead";
        this.logger.warn(msg);
    }

    private void logRegisterServiceInfo(String serviceName) {
        String msg = "Register GraphQL service {}";
        this.logger.info(msg, serviceName);
    }

    private void logSchemaDEBUG(String schema) {
        this.logger.debug(schema);
    }
}
