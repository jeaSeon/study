package info.thecodinglive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity//스프링 시큐리티 사용을 위한 어노테이션
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityBoardConfig extends WebSecurityConfigurerAdapter{
	//WebSecurityConfigurerAdapter 상속
	
	//비밀번호 암호화
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	//스프링 시큐리티
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf() //csrf 보안설정을 비활성화
			.disable();	//해당 기능을 사용하기 위해서 프론트단에서 csrf토큰값 보내줘야함.
		http.authorizeRequests() //보호된 리소스 URI에 접근가능하게.
			.antMatchers("/user/**").authenticated()
			.antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")	//로그인폼
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/list");	//로그인 성공하면 이동하는 페이지.
	}
}
