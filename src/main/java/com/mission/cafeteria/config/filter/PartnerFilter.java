package com.mission.cafeteria.config.filter;

import com.mission.cafeteria.service.PartnerService;
import com.mission.common.UserVo;
import com.mission.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/customer/*")
@RequiredArgsConstructor
public class PartnerFilter implements Filter {
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final PartnerService partnerService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("X-AUTH_TOKEN");
        if(!jwtAuthenticationProvider.validateToken(token)){
            throw new ServletException("Invalid Access");
        }
        UserVo vo = jwtAuthenticationProvider.getUserVo(token);
        partnerService.findByIdAndEmail(vo.getId(),vo.getEmail()).orElseThrow(
                ()->new ServletException("Invalid Error")
        );

        chain.doFilter(request,response);
    }
}
