package com.beauto.iiotconnx.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.beauto.iiotconnx.dto.Message;
import com.beauto.iiotconnx.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    	Message message = new Message();
		message.setMessage(Constants.UNAUTHORIZED);

		ObjectMapper objectMapper = new ObjectMapper();
		String customResponseJson = objectMapper.writeValueAsString(message);

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		response.getWriter().write(customResponseJson);
	}
    
    
    

}
