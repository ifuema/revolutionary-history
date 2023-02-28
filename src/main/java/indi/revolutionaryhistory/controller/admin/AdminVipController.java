package indi.revolutionaryhistory.controller.admin;

import indi.revolutionaryhistory.entity.Admin;
import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.service.AdminService;
import indi.revolutionaryhistory.service.UserService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;
    private int pageSize = 5;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> adminNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "管理员不存在！");


    @GetMapping
    public ResultVO<?> my(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin sessionAdmin = (Admin) session.getAttribute("admin");
        Admin dataAdmin = adminService.getAdminByAId(sessionAdmin.getaId());
        if (dataAdmin == null) {
            return adminNotExist;
        }
        return new ResultVO<>(dataAdmin);
    }

    /**
     * 分页获取用户
     * @param pageNum
     * @param user
     * @return
     */
    @GetMapping("/user/page/{pageNum}")
    public ResultVO<?> userPage(@PathVariable Integer pageNum, User user) {
        List<User> dataUserList = userService.getUserListPageByUser(pageSize, pageNum, user);
        if (dataUserList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataUserList);
        }
    }

    @DeleteMapping("/user/{uId}")
    public ResultVO<?> deleteUser(@PathVariable Integer uId) {
        if (userService.checkUserByUId(uId)) {
            if (userService.removeUserByUId(uId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return userNotExist;
        }
    }
}
