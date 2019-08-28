package br.edu.ifpb.api.filter;

import br.edu.ifpb.JWT.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Classe responsável por verificar se o token do usuário é válido
 * caso o mesmo tente acessar uma página restrita
 */

@WebFilter(urlPatterns = "/api/*")
public class SessionUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if(req.getRequestURI().startsWith("/api/clients/login")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = req.getHeader(TokenManager.TOKEN_HEADER);

        if(token == null || token.trim().isEmpty()){
            res.setStatus(401);
            return;
        }

        try {
            Jws<Claims> parser = TokenManager.decode(token);
            System.out.println("User request: "+ parser.getBody().getSubject());
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (SignatureException e) {
            res.setStatus(401);
        }

    }

    @Override
    public void destroy() {}
}
