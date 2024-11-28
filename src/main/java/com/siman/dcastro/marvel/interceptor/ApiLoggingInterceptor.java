package com.siman.dcastro.marvel.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import com.siman.dcastro.marvel.auth.TokenJwtConfig;
import com.siman.dcastro.marvel.models.entities.ApiLogs;
import com.siman.dcastro.marvel.repositories.ApiLogRepository;

@Component
public class ApiLoggingInterceptor implements AsyncHandlerInterceptor {

    private final ApiLogRepository apiLogRepository;

    public ApiLoggingInterceptor(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
       
            String method = request.getMethod();
            String endpoint = request.getRequestURI();
            String headers = request.getHeaderNames().hasMoreElements() 
                             ? request.getHeaderNames().nextElement()
                             : ""; 
            
            String requestBody=request.getQueryString();
                             int responseStatus = response.getStatus();

        


            
            String token = request.getHeader(TokenJwtConfig.HEADER_AUTHORIZATION);
            String userId = null;

            if (token != null && token.startsWith(TokenJwtConfig.PREFIX_TOKEN)) {
                token = token.substring(TokenJwtConfig.PREFIX_TOKEN.length());
                userId = extractUserIdFromToken(token);
            }

            // Save to database
            ApiLogs apiLog = new ApiLogs();
            apiLog.setHttpMethod(method);
            apiLog.setEndpoint(endpoint);
            apiLog.setRequestHeaders(headers);
            apiLog.setRequestBody(requestBody);
            apiLog.setResponseStatus(responseStatus);
            apiLog.setUserId(userId);
            apiLogRepository.save(apiLog);
        } catch (Exception e) {
            e.printStackTrace(); // Handle logging errors separately
        }
    }

    private String extractUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(TokenJwtConfig.SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.get("username", String.class); 
        } catch (Exception e) {
            e.printStackTrace(); 
            return null;
        }
    }
}


