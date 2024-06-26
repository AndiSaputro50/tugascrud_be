package com.sekolah.crud.Auth.Jwt;

import com.sekolah.crud.Auth.Repository.UserRepository;
import com.sekolah.crud.Auth.Service.UserDetailsServiseImpl;
import com.sekolah.crud.Auth.User.TemporaryToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtUtils;
    @Autowired
    private UserDetailsServiseImpl userDetailService;
    @Autowired
    private UserRepository sekolahRepository;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            System.out.println(jwt);
            if (jwt != null && jwtUtils.checkingTokenJwt(jwt)) {
                TemporaryToken token = jwtUtils.getSubject(jwt);
                UserDetails userDetails = userDetailService.loadUserByUsername(sekolahRepository.findById(token.getSekolahId()).get().getEmail());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {} ", e);
        }
        filterChain.doFilter(request, response);

    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }

}
