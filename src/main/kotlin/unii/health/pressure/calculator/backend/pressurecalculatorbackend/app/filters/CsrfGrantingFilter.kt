package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters

import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.util.Assert
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CsrfGrantingFilter constructor(val tokenRepository: CookieCsrfTokenRepository) : OncePerRequestFilter() {

    companion object {
        const val CSRF_COOKIE_NAME: String = "XSRF-SPRING-REACT-APP-TOKEN"
        const val CSRF_HEADER_NAME: String = "X-XSRF-SPRING-REACT-APP-TOKEN"
        const val READ_METHOD: String = "GET"
        val ENDPOINT_PATH_MATCHER: AntPathRequestMatcher = AntPathRequestMatcher("/**/*")
    }

    init {
        Assert.notNull(tokenRepository, "csrfTokenRepository cannot be null")
        tokenRepository.setCookieName(CSRF_COOKIE_NAME)
        tokenRepository.setHeaderName(CSRF_HEADER_NAME)
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        if (READ_METHOD.equals(request.method) && isNotEndpointPath(request)) {
            request.setAttribute(HttpServletResponse::class.java.name, response);

            var csrfToken: CsrfToken = tokenRepository.loadToken(request)
            val missingToken: Boolean = csrfToken == null
            if (missingToken) {
                csrfToken = tokenRepository.generateToken(request)
                tokenRepository.saveToken(csrfToken, request, response)
            }
            request.setAttribute(CsrfToken::class.java.name, csrfToken)
            request.setAttribute(csrfToken.parameterName, csrfToken)
        }
        filterChain.doFilter(request, response)
    }

    private fun isNotEndpointPath(request: HttpServletRequest): Boolean {
        return !ENDPOINT_PATH_MATCHER.matches(request)
    }
}