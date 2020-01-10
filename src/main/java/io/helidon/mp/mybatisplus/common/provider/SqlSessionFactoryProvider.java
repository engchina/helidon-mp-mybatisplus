package io.helidon.mp.mybatisplus.common.provider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.cdi.SessionFactoryProvider;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;

import io.helidon.mp.mybatisplus.common.config.GlobalConfig;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;

@ApplicationScoped
public class SqlSessionFactoryProvider {

	@Produces
	@ApplicationScoped
	@SessionFactoryProvider
	public SqlSessionFactory produceFactory() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
//		TransactionFactory transactionFactory = new ManagedTransactionFactory();
		Environment environment = new Environment("product", transactionFactory,
				new Log4jdbcProxyDataSource(GlobalConfig.ds));
//		Configuration configuration = new Configuration(environment);
		Configuration configuration = new MybatisConfiguration(environment);
		configuration.getTypeAliasRegistry().registerAliases("io.helidon.mp.mybatisplus.entity");
		configuration.getTypeAliasRegistry().registerAliases("io.helidon.mp.mybatisplus.vo");
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.addMappers("io.helidon.mp.mybatisplus.mapper");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSessionFactory factory = new MybatisSqlSessionFactoryBuilder().build(configuration);
		return factory;
	}

//	/**
//	 * 分页插件
//	 */
//	@Produces
//	@Dependent
//	public PaginationInterceptor paginationInterceptor() {
//		return new PaginationInterceptor();
//	}
//
//	/**
//	 * 打印 sql
//	 */
//	@Produces
//	@Dependent
//	public SqlExplainInterceptor sqlExplainInterceptor() {
//		SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
//		// 格式化sql语句
//		Properties properties = new Properties();
//		properties.setProperty("format", "true");
//		sqlExplainInterceptor.setProperties(properties);
//		return sqlExplainInterceptor;
//	}
}
