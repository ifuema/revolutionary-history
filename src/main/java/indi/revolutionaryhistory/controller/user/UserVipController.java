package indi.revolutionaryhistory.controller.user;

import indi.revolutionaryhistory.entity.Collect;
import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.entity.groups.Register;
import indi.revolutionaryhistory.service.CollectService;
import indi.revolutionaryhistory.service.EssayService;
import indi.revolutionaryhistory.service.UserService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/vip")
public class UserVipController {
    @Resource
    private UserService userService;
    @Resource
    private CollectService collectService;
    @Resource
    private EssayService essayService;
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");
    private final ResultVO<?> notExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, null);
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> exist = new ResultVO<>(ResultCode.SUCCESS, null);
    private final ResultVO<?> saveFailed = new ResultVO<>(ResultCode.FAILED, "保存失败！");
    private final ResultVO<?> accountExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "账号已存在！");
    private final ResultVO<?> collectExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "不能重复收藏！");
    private final ResultVO<?> collectNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "没有被收藏！");
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "不存在数据！");


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

    /**
     * 修改已登录用户信息
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/session")
    public ResultVO<?> changeUser(@RequestBody @Validated({Register.class}) User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        if (!sessionUser.getuAccount().equals(user.getuAccount())){
            if (userService.checkUserByUAccount(user.getuAccount())) {
                return accountExist;
            }
        }
        user.setuId(sessionUser.getuId());
        user.setuPassword(BCrypt.hashpw(user.getuPassword(), BCrypt.gensalt()));
        if (userService.modifyUserByUId(user)) {
            session.setAttribute("user", user);
            return success;
        } else {
            return saveFailed;
        }
    }

    @PostMapping("/collect/{eId}")
    public ResultVO<?> addCollect(@PathVariable Integer eId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        Collect collect = new Collect();
        collect.seteId(eId);
        collect.setuId(sessionUser.getuId());
        if (!essayService.checkEssayByEId(eId)) {
            return essayNotExist;
        } else if (collectService.checkCollectByCollect(collect)) {
            return collectExist;
        } else {
            if (collectService.saveCollect(collect)) {
                return success;
            } else {
                return saveFailed;
            }
        }
    }

    @DeleteMapping("/collect/{eId}")
    public ResultVO<?> deleteCollect(@PathVariable Integer eId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        Collect collect = new Collect();
        collect.seteId(eId);
        collect.setuId(sessionUser.getuId());
        if (collectService.checkCollectByCollect(collect)) {
            if (collectService.removeCollectByCollect(collect)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return collectNotExist;
        }
    }

    @GetMapping("/collect/{eId}")
    public ResultVO<?> checkCollect(@PathVariable Integer eId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        Collect collect = new Collect();
        collect.seteId(eId);
        collect.setuId(sessionUser.getuId());
        if (collectService.checkCollectByCollect(collect)) {
            return exist;
        } else {
            return notExist;
        }
    }

    @GetMapping("/collect")
    public ResultVO<?> collect(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        List<Collect> dataCollectList = collectService.getCollectListByUID(sessionUser.getuId());
        if (dataCollectList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataCollectList);
        }
    }

}
