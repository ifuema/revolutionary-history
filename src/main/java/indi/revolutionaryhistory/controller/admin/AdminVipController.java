package indi.revolutionaryhistory.controller.admin;

import indi.revolutionaryhistory.entity.Admin;
import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.entity.People;
import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.entity.groups.Register;
import indi.revolutionaryhistory.service.*;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/vip")
public class AdminVipController {
    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;
    @Resource
    private DiscussService discussService;
    @Resource
    private EssayService essayService;
    @Resource
    private PeopleService peopleService;
    private int pageSize = 5;
    private final ResultVO<?> success = new ResultVO<>();
    private final ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");
    private final ResultVO<?> saveFailed = new ResultVO<>(ResultCode.FAILED, "保存失败！");
    private final ResultVO<?> deleteFailed = new ResultVO<>(ResultCode.FAILED, "删除失败！");
    private final ResultVO<?> userNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "用户不存在！");
    private final ResultVO<?> peopleNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "人物不存在！");
    private final ResultVO<?> discussNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "评论不存在！");
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

    @GetMapping("/user")
    public ResultVO<Integer> userCount() {
        Integer dataUserCount = userService.getUserCount();
        return new ResultVO<>(dataUserCount);
    }

    @GetMapping("/essay")
    public ResultVO<Integer> essayCount() {
        Integer dataEssayCount = essayService.getEssayCount();
        return new ResultVO<>(dataEssayCount);
    }

    @GetMapping("/people")
    public ResultVO<Integer> peopleCount() {
        Integer dataPeopleCount = peopleService.getPeopleCount();
        return new ResultVO<>(dataPeopleCount);
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

    @DeleteMapping("/discuss/{dId}")
    public ResultVO<?> deleteDiscuss(@PathVariable Integer dId) {
        if (discussService.checkDiscussByDId(dId)) {
            if (discussService.removeDiscussByDId(dId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return discussNotExist;
        }
    }

    @PostMapping("/essay")
    public ResultVO<?> addEssay(@RequestBody @Validated({Register.class}) Essay essay) {
        if (essayService.saveEssay(essay)) {
            return new ResultVO<>(essay.geteId());
        } else {
            return saveFailed;
        }
    }

    @PutMapping("/essay/{eId}")
    public ResultVO<?> changeEssay(@RequestBody @Validated({Register.class}) Essay essay, @PathVariable Integer eId) {
        if (essayService.checkEssayByEId(eId)) {
            essay.seteId(eId);
            if (essayService.modifyEssayByEId(essay)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return essayNotExist;
        }
    }

    @DeleteMapping("/essay/{eId}")
    public ResultVO<?> deleteEssay(@PathVariable Integer eId) {
        if (essayService.checkEssayByEId(eId)) {
            if (essayService.removeEssayByEId(eId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return essayNotExist;
        }
    }

    @PostMapping("/people")
    public ResultVO<?> addPeople(@RequestBody @Validated({Register.class}) People people) {
        if (peopleService.savePeople(people)) {
            return new ResultVO<>(people.getpId());
        } else {
            return saveFailed;
        }
    }

    @PutMapping("/people/{pId}")
    public ResultVO<?> changePeople(@RequestBody @Validated({Register.class}) People people, @PathVariable Integer pId) {
        if (peopleService.checkPeopleByPId(pId)) {
            people.setpId(pId);
            if (peopleService.modifyPeopleByPId(people)) {
                return success;
            } else {
                return saveFailed;
            }
        } else {
            return peopleNotExist;
        }
    }

    @DeleteMapping("/people/{pId}")
    public ResultVO<?> deletePeople(@PathVariable Integer pId) {
        if (peopleService.checkPeopleByPId(pId)) {
            if (peopleService.removePeopleByPId(pId)) {
                return success;
            } else {
                return deleteFailed;
            }
        } else {
            return peopleNotExist;
        }
    }
}
