package com.centralibrary.librarymanager.filter;

import com.centralibrary.librarymanager.exception.BusinessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        try {
            if (authorization == null || authorization.isEmpty()) {
                throw new BusinessException("Authorization header is missing. request prohibited", 401);
            } else {

                Claims claims = tokenUtil.validateToken(authorization);
                String emailAddress = claims.get("sub", String.class);

                request.setAttribute("emailAddress", emailAddress);
                request.setAttribute("roles", claims.get("roles", String.class));

                filterChain.doFilter(request, response);
            }
        } catch (ExpiredJwtException exception) {
            throw new BusinessException("Token Expired. Get a new token", 401);
        } catch (BusinessException businessException) {
            response.setContentType("application/json");
            response.setStatus(businessException.getStatusCode());
            response.getWriter().write(new ObjectMapper().writeValueAsString(businessException));
        }
    }
}
