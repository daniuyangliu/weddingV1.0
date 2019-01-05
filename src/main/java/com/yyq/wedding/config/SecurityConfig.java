package com.yyq.wedding.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author YangLiu
 * @Title: SecurityConfig
 * @ProjectName wedding
 * @Description: TODO
 * @date 2019/1/411:11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("========================================SecurityConfig验证========================================");
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/form")
                .failureUrl("/error")
                .defaultSuccessUrl("/wedding.jsp")
                //成功后跳转。。。
                .permitAll()
                .and()
                //关闭csrf
                .csrf().disable()
        ;

    }
    @Override
    public void configure(WebSecurity web) {
        logger.info("========================================解开oracle受限资源========================================");
        web.ignoring().antMatchers("/oracle/**");
    }



}
