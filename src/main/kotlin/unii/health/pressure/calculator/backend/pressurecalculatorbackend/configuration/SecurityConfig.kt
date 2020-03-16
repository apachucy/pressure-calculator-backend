package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters.CsrfGrantingFilter
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters.CsrfValidationFilter

import javax.servlet.Filter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.inMemoryAuthentication()
                ?.withUser("admin")
                ?.password("{noop}admin")
                ?.roles("ADMIN")
                ?.and()
                ?.withUser("user")
                ?.password("{noop}user")
                ?.roles("USER")

    }

    override fun configure(http: HttpSecurity?) {
        http?.csrf()
                ?.disable()
                ?.authorizeRequests()
                ?.anyRequest()?.authenticated()
                ?.and()
                ?.httpBasic()

    }
}