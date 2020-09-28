package com.nasdaq.virtualstockexchange.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class Appconfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSourceBuilder.url(env.getProperty("spring.datasource.url"));
		dataSourceBuilder.username(env.getProperty("spring.datasource.username"));
		dataSourceBuilder.password(env.getProperty("spring.datasource.password"));

		return dataSourceBuilder.build();
	}
}
