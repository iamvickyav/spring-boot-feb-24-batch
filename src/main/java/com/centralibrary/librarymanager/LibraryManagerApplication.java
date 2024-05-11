package com.centralibrary.librarymanager;

import com.centralibrary.librarymanager.filter.AuthorizationFilter;
import com.centralibrary.librarymanager.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class LibraryManagerApplication {

	@Autowired
	SecurityFilter securityFilter;

	@Autowired
	AuthorizationFilter authorizationFilter;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagerApplication.class, args);
	}

	@Bean
	FilterRegistrationBean securityFilterBeanRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(securityFilter);
		filterRegistrationBean.setUrlPatterns(List.of("/staffs", "/students"));
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}

	@Bean
	FilterRegistrationBean authFilterBeanRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(authorizationFilter);
		filterRegistrationBean.setUrlPatterns(List.of("/staffs", "/students"));
		filterRegistrationBean.setOrder(2);
		return filterRegistrationBean;
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
