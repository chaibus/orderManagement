package softuni.restaurant.web.employees.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import softuni.restaurant.service.StatsService;

@Component
public class StatsInterceptor implements HandlerInterceptor {

  private final StatsService statsService;

  public StatsInterceptor(StatsService statsService) {
    this.statsService = statsService;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    statsService.onRequest();
    return true;
  }
}
