package io.helidon.mp.mybatisplus.common.provider;

import io.helidon.mp.mybatisplus.common.config.GlobalConfig;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public class SqlSessionFactoryProvider {

    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    public SqlSessionFactory produceFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("product", transactionFactory, GlobalConfig.ds);
        Configuration configuration = new Configuration(environment);
        configuration.getTypeAliasRegistry().registerAliases("io.helidon.mp.mybatisplus.entity");
        configuration.addMappers("io.helidon.mp.mybatisplus.mapper");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        return factory;
    }
}
