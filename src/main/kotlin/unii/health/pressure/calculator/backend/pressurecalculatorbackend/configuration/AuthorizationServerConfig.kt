package unii.health.pressure.calculator.backend.pressurecalculatorbackend.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig @Autowired constructor(var authenticationManager: AuthenticationManager) : AuthorizationServerConfigurerAdapter() {

    companion object {
        const val ACCESS_TOKEN_VALIDITY_SECONDS: Int = 5 * 60
        const val CLIENT_CREDENTIALS: String = "client_credentials"
        const val NO_ENCRYPT: String = "{noop}"

        //username
        const val READ_CLIENT_ID: String = "client_read"
        const val WRITE_CLIENT_ID: String = "client_write"

        //password
        const val CLIENT_SECRET: String = "secret"

        const val SCOPE_READ = "read"
        const val SCOPE_WRITE = "write"
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authenticationManager(authenticationManager)
    }

    override fun configure(clients: ClientDetailsServiceConfigurer?) {
        if (clients == null) {
            return
        }
        clients.inMemory()
                .withClient(READ_CLIENT_ID)
                .secret(NO_ENCRYPT + CLIENT_SECRET)
                .authorizedGrantTypes(CLIENT_CREDENTIALS)
                .scopes(SCOPE_READ)
                .and()
                .withClient(WRITE_CLIENT_ID)
                .secret(NO_ENCRYPT + CLIENT_SECRET)
                .authorizedGrantTypes(CLIENT_CREDENTIALS)
                .scopes(SCOPE_WRITE)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
    }

}