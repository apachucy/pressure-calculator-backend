/*package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    companion object {
        const val FILTER_ALL: String = "/"
        const val ENDPOINT_PATH: String = "/user"
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()
                ?.withUser("admin")
                ?.password("{noop}admin")
                ?.roles("Admin")
                ?.and()
                ?.withUser("user")
                ?.password("{noop}user")
                ?.roles("User")

    }


    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
                ?.antMatchers(FILTER_ALL)
                ?.permitAll()
        /* ?.and()
         ?.formLogin()*/
    }


}*/