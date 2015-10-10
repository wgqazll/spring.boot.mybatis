package chanjet.spring.boot.mybatis.util.config;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig implements EnvironmentAware{
	
	private static Log logger = LogFactory.getLog(DataSourceConfig.class); 
	
	private RelaxedPropertyResolver propertyResolver;
	
	@Override
	public void setEnvironment(Environment environment) {
		 this.propertyResolver = new RelaxedPropertyResolver(environment, "jdbc."); 
	}
	
	@Bean(name="dataSource", destroyMethod = "close", initMethod="init")  
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
		dataSource.setUrl(propertyResolver.getProperty("url"));
		dataSource.setUsername(propertyResolver.getProperty("username"));
		dataSource.setPassword(propertyResolver.getProperty("password"));
		dataSource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("max-active")));
		dataSource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("min-idle")));
		dataSource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initial-size")));
		dataSource.setValidationQuery(propertyResolver.getProperty("validation-query"));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(propertyResolver.getProperty("test-on-borrow")));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(propertyResolver.getProperty("test-on-borrow")));
		dataSource.setTestOnReturn(Boolean.parseBoolean(propertyResolver.getProperty("test-on-return")));
		dataSource.setMaxWait(Integer.parseInt(propertyResolver.getProperty("max-wait")));
		logger.info("init dataSource success");
		return dataSource;
	}
}
