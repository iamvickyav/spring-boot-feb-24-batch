package com.centralibrary.librarymanager.filter;

import com.centralibrary.librarymanager.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(2)
public class AuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getRequestURI();
        String requestMethod = request.getMethod();
        String role = request.getAttribute("roles").toString();
        try {
            if (requestPath.startsWith("/students") && requestMethod.equals("POST")) {
                if (role.equalsIgnoreCase("staff")) {
                    filterChain.doFilter(request, response);
                } else {
                    throw new BusinessException("Only staff are allowed to perform this action", 403);
                }
            }
        } catch(BusinessException businessException) {
            response.setContentType("application/json");
            response.setStatus(businessException.getStatusCode());
            response.getWriter().write(new ObjectMapper().writeValueAsString(businessException));
        }
    }
}
