package indi.revolutionaryhistory.controller.user;

import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.service.UserService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    private UserService userService;
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");

    /**
     * 获取已登录用户信息
     * @param request
     * @return
     */
    @GetMapping
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        User dataUser = userService.getUserByUId(sessionUser.getuId());
        if (dataUser == null) {
            return userNotExist;
        }
        return new ResultVO<>(dataUser);
    }
}
