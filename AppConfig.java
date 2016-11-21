package org.springframework.security.oauth.examples.sparklr.config;

import javax.sql.DataSource;

import org.apache.http.util.ExceptionUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("org.springframework.security.oauth.examples.sparklr.dao")
@PropertySource("/WEB-INF/conf/jdbc.properties")
public class AppConfig {

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.driver}")
	private String driver;

	@Bean
	public DataSource dataSource() {
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setPassword(password);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setDriverClassName(Class.forName(driver).getName());
			return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
    		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    		sqlSessionFactoryBean.setDataSource(dataSource);
    		return sqlSessionFactoryBean;
    }
}
