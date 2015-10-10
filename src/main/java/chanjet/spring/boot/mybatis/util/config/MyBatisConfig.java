package chanjet.spring.boot.mybatis.util.config;


import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages={"chanjet.spring.boot.mybatis.mapper"})
public class MyBatisConfig implements EnvironmentAware{
	
	private static Log logger = LogFactory.getLog(MyBatisConfig.class); 
	
	private RelaxedPropertyResolver propertyResolver;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void setEnvironment(Environment environment) {
		 this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis."); 
	}
	
	@Bean(name="sqlSessionFactory")  
	public SqlSessionFactory sqlSessionFactory(){
		 SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		 sessionFactory.setDataSource(dataSource);
		 try {
			sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()  
			         .getResources(propertyResolver.getProperty("mapperLocations")));
			sessionFactory.setConfigLocation(new DefaultResourceLoader()  
                     .getResource(propertyResolver.getProperty("configLocation"))); 
			logger.info("init sqlSessionFactory success!");
			return sessionFactory.getObject();
		} catch (Exception e) {
			logger.error("init sqlSessionFactory error!");
		} 
		return null;
	}
	
	@Bean  
	public DataSourceTransactionManager transactionManager() {  
	    return new DataSourceTransactionManager(dataSource);  
	}
}
