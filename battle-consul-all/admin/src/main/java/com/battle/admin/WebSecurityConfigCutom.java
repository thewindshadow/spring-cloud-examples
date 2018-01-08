package com.battle.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 配置HttpBasic权限验证
 * Created by Bing.Z on 2018/1/8.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class WebSecurityConfigCutom extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html","/**.css", "/img/**", "/**.js","/third-party/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers( "/login",
                    "/api/**",
                    "/**/heapdump",
                    "/**/loggers",
                    "/**/liquibase",
                    "/**/logfile",
                    "/**/flyway",
                    "/**/auditevents",
                    "/**/jolokia").permitAll() //放开"/api/**"：为了给被监控端免登录注册并解决Log与Logger冲突
            .and()
            .authorizeRequests()
            .antMatchers("/**").hasRole("USER")
            .antMatchers("/**").authenticated()
            .and()
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login").permitAll()
            .defaultSuccessUrl("/")
            .and() //Logout Form configuration
            .logout()
            .deleteCookies("remove")
            .logoutSuccessUrl("/login.html").permitAll()
            .and()
            .httpBasic();
    }
}
