package es.damarur.rock.paper.scissors.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order()
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

	private final CustomProperties customProperties;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			filterChain.doFilter(request, response);
		}
		String apiKey = request.getHeader("x-api-key");
		if (customProperties.getApiKey().equals(apiKey)) {
			filterChain.doFilter(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Missing X-Api-Key");
		}
	}

}
