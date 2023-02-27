package indi.revolutionaryhistory.controller.user;

import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.entity.groups.Login;
import indi.revolutionaryhistory.entity.groups.Register;
import indi.revolutionaryhistory.service.UserService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> accountNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号不存在！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> accountExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号已存在！");
    private final ResultVO<?> registerFailed = new ResultVO<>(ResultCode.FAILED, "注册失败！");
    private final ResultVO<?> accountOrPasswordError = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号或密码错误！");


    /**
     * 登录请求
     * @param user
     * @param request
     * @return
     */
    @PostMapping("/session")
    public ResultVO<?> login(@RequestBody @Validated({Login.class}) User user, HttpServletRequest request) {
        User dataUser = userService.getUserPrivateByUAccount(user.getuAccount());
        if (dataUser == null) {
            return accountNotExist;
        } else {
            boolean result = false;
            try {
                result = BCrypt.checkpw(user.getuPassword(), dataUser.getuPassword());
            } catch (IllegalArgumentException e) {
            }
            if (result) {
                request.getSession().setAttribute("user", dataUser);
                return success;
            } else {
                return accountOrPasswordError;
            }
        }
    }

    /**
     * 注册请求
     * @param user
     * @return
     */
    @PostMapping
    public ResultVO<?> register(@RequestBody @Validated({Register.class}) User user) {
        if (userService.checkUserByUAccount(user.getuAccount())) {
            return accountExist;
        } else {
            user.setuPassword(BCrypt.hashpw(user.getuPassword(), BCrypt.gensalt()));
            if (userService.saveUser(user)) {
                return new ResultVO<>(user.getuId());
            } else {
                return registerFailed;
            }
        }
    }

    @GetMapping("/{uId}")
    public ResultVO<?> getUser(@PathVariable Integer uId) {
        User dataUser = userService.getUserPublicByUId(uId);
        if (dataUser == null) {
            return userNotExist;
        } else {
            return new ResultVO<>(dataUser);
        }
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @DeleteMapping("/session")
    public ResultVO<?> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return success;
    }
}
