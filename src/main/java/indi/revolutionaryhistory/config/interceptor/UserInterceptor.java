package indi.revolutionaryhistory.config.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.service.UserService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String stateInvalidJson = "";
    private String notLoginJson = "";

    {
        try {
            stateInvalidJson = objectMapper.writeValueAsString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "登录已过期！"));
            notLoginJson = objectMapper.writeValueAsString(new ResultVO<>(ResultCode.PERMISSION_REGECT, "未登录！"));
        } catch (JsonProcessingException e) {
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            try {
                response.getWriter().write(notLoginJson);
            } catch (IOException e) {
            }
            return false;
        } else {
            Integer dataUId = userService.getUIdByUAccountAndUPassword(sessionUser);
            if (dataUId == null) {
                try {
                    response.getWriter().write(stateInvalidJson);
                } catch (IOException e) {
                }
                return false;
            } else {
                sessionUser.setuId(dataUId);
                return true;
            }
        }
    }
}
