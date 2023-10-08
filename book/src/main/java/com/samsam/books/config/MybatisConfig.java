//package com.samsam.books.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//@Configuration
//public class MybatisConfig {
//	private final ApplicationContext context = null;
//	
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		
//		sessionFactory.setDataSource(dataSource);
//		
//		sessionFactory.setMapperLocations(context.getResources("classpath:/mapper//*.xml"));
//		
//		sessionFactory.setTypeAliasesPackage("com.samsam.books");
//		
//		return sessionFactory.getObject();
//	}
//	
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//		
//		sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);
//		
//		return sqlSessionTemplate;
//	}
//	
//	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//	
//}