package io.helidon.mp.mybatisplus.common.provider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import io.helidon.mp.mybatisplus.common.config.GlobalConfig;

@ApplicationScoped
public class SqlSessionFactoryProvider {

	@Produces
	@ApplicationScoped
	@SessionFactoryProvider
	public SqlSessionFactory produceFactory() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		TransactionFactory transactionFactory = new ManagedTransactionFactory();
		Environment environment = new Environment("product", transactionFactory, GlobalConfig.ds);
		Configuration configuration = new Configuration(environment);
		configuration.getTypeAliasRegistry().registerAliases("io.helidon.mp.mybatisplus.entity");
		configuration.addMappers("io.helidon.mp.mybatisplus.mapper");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
		return factory;
	}
}
