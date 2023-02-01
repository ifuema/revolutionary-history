package indi.revolutionaryhistory.controller;

import indi.revolutionaryhistory.entity.Essay;
import indi.revolutionaryhistory.service.EssayService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/essay")
public class EssayController {
    @Resource
    private EssayService essayService;
    private int pageSize = 5;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "当前页不存在数据！");
    private final ResultVO<?> essayNotExist = new ResultVO<>(ResultCode.VALIDATE_FAILED, "文章不存在！");

    /**
     * 分页获取文章
     * @param pageNum
     * @param essay
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public ResultVO<?> page(@PathVariable Integer pageNum, Essay essay) {
        List<Essay> dataEssayList = essayService.getEssayListPageByEssay(pageSize, pageNum, essay);
        if (dataEssayList.isEmpty()) {
            return noData;
        } else {
            return new ResultVO<>(dataEssayList);
        }
    }

    /**
     * 获取文章
     * @param eId
     * @return
     */
    @GetMapping("/{eId}")
    public ResultVO<?> getEssay(@PathVariable Integer eId) {
        Essay dataEssay = essayService.getEssayByEId(eId);
        if (dataEssay == null) {
            return essayNotExist;
        } else {
            essayService.modifyENumAddByEId(eId);
            return new ResultVO<>(dataEssay);
        }
    }
}
