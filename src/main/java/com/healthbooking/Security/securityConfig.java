package com.healthbooking.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.healthbooking.entity.TaiKhoan;


@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService service;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	// cung cấp nguồn dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				TaiKhoan users = service.findByName(username);
				
				String password = pe.encode(users.getMatKhau());
				String role = users.getQuyen();
				return User.withUsername(username).password(password).roles(role).build();
				
			} catch (Exception e) {
				throw new UsernameNotFoundException(username + "not found");
			}
		});
	}
	
	// phân quyền sử dụng
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		    .antMatchers("/HealthBooking/order/list").hasRole("bacsi")
		    .antMatchers("/HealthBooking/admin/**").hasAnyRole("benhnhan")
	        .antMatchers("/HealthBooking/Dat-Lich-Kham/**").authenticated() // Thêm quy tắc yêu cầu đăng nhập cho đường dẫn cụ thể
		    .anyRequest().permitAll();

		
	
		http.formLogin()
		.loginPage("/HealthBooking/security/login")
		.loginProcessingUrl("/HealthBooking/security/login")
		.defaultSuccessUrl("/HealthBooking/security/login/success",false)
		.failureUrl("/HealthBooking/security/login/error");
		
		
		http.rememberMe()
		.tokenValiditySeconds(86400);
		
		http.logout()
		.logoutUrl("/HealthBooking/security/logoff")
		.logoutSuccessUrl("/security/logoff/success");
		
	}
	
	@Bean
	public  BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
