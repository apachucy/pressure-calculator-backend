package unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.util.WebUtils
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters.CsrfGrantingFilter.Companion.CSRF_COOKIE_NAME
import unii.health.pressure.calculator.backend.pressurecalculatorbackend.app.filters.CsrfGrantingFilter.Companion.CSRF_HEADER_NAME
import java.util.*
import java.util.regex.Pattern
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class CsrfValidationFilter constructor(var cookiePath: String) : Filter {

    companion object {
        val WRITE_METHODS: Pattern = Pattern.compile("^(POST|PUT|DELETE)$")
        const val INVALID_CSRF_TOKEN_MSG: String = "Invalid CSRF Token"
        val LOGGER: Logger = LoggerFactory.getLogger(CsrfValidationFilter::class.java)
    }


    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req: HttpServletRequest = request as HttpServletRequest
        val res: HttpServletResponse = response as HttpServletResponse

        if (WRITE_METHODS.matcher(req.method).matches()) {
            if (isCsrfTokenValid(req)) {
                chain?.doFilter(req, res)
            } else {
                removeCsrfCookie(res)
                res.status = HttpServletResponse.SC_FORBIDDEN
                res.writer.println(INVALID_CSRF_TOKEN_MSG)
            }
        } else {
            chain?.doFilter(req, res)
        }
    }

    private fun isCsrfTokenValid(request: HttpServletRequest): Boolean {
        val header: String = request.getHeader(CSRF_HEADER_NAME)
        val cookie = Optional.ofNullable(WebUtils.getCookie(request, CSRF_COOKIE_NAME))
                .map { obj: Cookie -> obj.value }
                .orElse(null)


        if (header == null) {
            LOGGER.warn("Invalid CSRF Token: header missing")
            return false
        }

        if (cookie == null) {
            LOGGER.warn("Invalid CSRF Token: cookie missing")
            return false
        }

        if (!header.equals(cookie)) {
            LOGGER.warn("Invalid CSRF Token: header '{}' and cookie '{}' did not match", header, cookie)
            return false
        }
        return true
    }

    private fun removeCsrfCookie(response: HttpServletResponse) {
        val cookie: Cookie = createCsrfCookie(null)
        cookie.maxAge = 0
        cookie.value = null
        response.addCookie(cookie)
    }

    private fun createCsrfCookie(value: String?): Cookie {
        val cookie: Cookie = Cookie(CSRF_COOKIE_NAME, value)
        cookie.path = cookiePath
        return cookie
    }
}