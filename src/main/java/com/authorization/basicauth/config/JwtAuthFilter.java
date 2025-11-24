package com.authorization.basicauth.config;

import com.authorization.basicauth.entity.ApplicationUsers;
import com.authorization.basicauth.repository.UserAuthRepo;
import com.authorization.basicauth.util.AuthUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private final UserAuthRepo userAuthRepo;

    @Autowired
    private AuthUtil authUtil;
    @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming url: {}",request.getRequestURI());
        try {
            String authHeader = request.getHeader("Authorization");
            if (null == authHeader || !authHeader.startsWith("Bearer")) {
                filterChain.doFilter(request, response);
                return;
            }
            String token = authHeader.split("Bearer ")[1];
            String userName = authUtil.getUserName(token);
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                ApplicationUsers user = userAuthRepo.findByUserName(userName).orElseThrow();
                UsernamePasswordAuthenticationToken upAuthToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(upAuthToken);
            }
            filterChain.doFilter(request, response);
        }catch(Exception ex){
            handlerExceptionResolver.resolveException(request,response,null,ex);
        }
    }
}
