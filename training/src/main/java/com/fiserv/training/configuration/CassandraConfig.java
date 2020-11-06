package com.fiserv.training.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.oss.driver.api.core.CqlSession;

//@Configuration
//@EnableCassandraRepositories(basePackages = { "com.fiserv.training.repository" })
public class CassandraConfig extends AbstractCassandraConfiguration {

  /*@Bean
  public CqlSessionFactoryBean session() {

    CqlSessionFactoryBean session = new CqlSessionFactoryBean();
    session.setContactPoints("localhost");
    return session;
  }

  @Bean
  public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {

    SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
    sessionFactory.setSession(session);
    sessionFactory.setConverter(converter);
    sessionFactory.setSchemaAction(SchemaAction.NONE);

    return sessionFactory;
  }

  @Bean
  public CassandraMappingContext mappingContext(CqlSession cqlSession) {

    CassandraMappingContext mappingContext = new CassandraMappingContext();
    mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));

    return mappingContext;
  }

  @Bean
  public CassandraConverter converter(CassandraMappingContext mappingContext) {
    return new MappingCassandraConverter(mappingContext);
  }

  @Bean
  public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
    return new CassandraTemplate(sessionFactory, converter);
  }
  
  @Override
  protected String getLocalDataCenter() {
      return "DC1";
  }*/
	
	public static final String KEYSPACE = "FiservKeySpace";


    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE);

        return Arrays.asList(specification);
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.test.cassandra.entity"};
    }

    @Override
    protected String getLocalDataCenter() {
        return "DC1";
    }
	
}
