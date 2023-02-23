package indi.revolutionaryhistory.controller;

import indi.revolutionaryhistory.entity.People;
import indi.revolutionaryhistory.service.PeopleService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Resource
    private PeopleService peopleService;
    private int pageSize = 5;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> peopleNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "人物不存在！");

    /**
     * 分页获取人物
     * @param pageNum
     * @param people
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, People people) {
        List<People> dataPeopleList = peopleService.getPeopleListPageByPeople(pageSize, pageNum, people);
        if (dataPeopleList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataPeopleList);
        }
    }

    /**
     * 获取人物
     * @param pId
     * @return
     */
    @GetMapping("/{pId}")
    public ResultVO<?> getPeople(@PathVariable Integer pId) {
        People dataPeople = peopleService.getPeopleByPId(pId);
        if (dataPeople == null) {
            return peopleNotExist;
        } else {
            return new ResultVO<>(dataPeople);
        }
    }
}
