package com.dawdler.gateway.boostrap;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.anywide.dawdler.clientplug.web.session.DawdlerSessionFilter;
import com.dawdler.session.user.SessionUser;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@Component
public class AuthorizationGatewayFilter implements GlobalFilter, Ordered {
	private static final String SESSION_USER = "session_user";
	DawdlerSessionFilter filter = new DawdlerSessionFilter();

	public AuthorizationGatewayFilter() throws ServletException {
		FilterConfig fc = new FilterConfig() {

			@Override
			public ServletContext getServletContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Enumeration<String> getInitParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getInitParameter(String name) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFilterName() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		filter.init(fc);
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		ServerHttpResponse response = exchange.getResponse();
		HttpServletRequestImpl requestImpl = new HttpServletRequestImpl(request);
		HttpServletResponseImpl responseImpl = new HttpServletResponseImpl(response);
		Map<String, Mono<Void>> result = new HashMap<>();
		FilterChain myChain = new FilterChain() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response)
					throws IOException, ServletException {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				SessionUser user = (SessionUser) httpRequest.getSession().getAttribute(SESSION_USER);
				String url = httpRequest.getRequestURI();
				if ((url.contains("/my/") || url.contains("/admin/")) && user == null) {
					httpResponse.setStatus(401);
					Mono<Void> mono = new Mono<Void>() {
						@Override
						public void subscribe(CoreSubscriber actual) {
							actual.onComplete();
						}
					};
					result.put("mono", mono);
				}

				else {
					result.put("mono", chain.filter(exchange));
				}
			}
		};
		try {
			filter.doFilter(requestImpl, responseImpl, myChain);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
//		ServerHttpResponse response = exchange.getResponse();
//		String uri = request.getURI().toString();
//		System.out.println("uri->" + uri);
//		response.setStatusCode(HttpStatus.UNAUTHORIZED);
//		return response.setComplete();
		return result.get("mono");
	}

}
