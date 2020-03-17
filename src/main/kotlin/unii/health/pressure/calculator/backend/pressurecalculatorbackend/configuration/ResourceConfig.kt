package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableResourceServer
class ResourceConfig : ResourceServerConfigurerAdapter() {

    companion object {
        const val PATTERN_MATCHER_ALL: String = "/**/*"
    }

    override fun configure(http: HttpSecurity?) {
        //super.configure(http)
        if (http == null) {
            return
        }
        http.antMatcher(PATTERN_MATCHER_ALL)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, PATTERN_MATCHER_ALL).access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST, PATTERN_MATCHER_ALL).access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, PATTERN_MATCHER_ALL).access("#oauth2.hasScope('write')")
                .anyRequest()
                .authenticated()
    }
}