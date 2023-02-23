package indi.revolutionaryhistory.controller;

import indi.revolutionaryhistory.entity.Discuss;
import indi.revolutionaryhistory.service.DiscussService;
import indi.revolutionaryhistory.vo.ResultCode;
import indi.revolutionaryhistory.vo.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/discuss")
public class DiscussController {
    @Resource
    private DiscussService discussService;
    private final ResultVO<?> noData = new ResultVO<>(ResultCode.VALIDATE_FAILED, "无数据！");

    @GetMapping("/{eId}")
    public ResultVO<?> getDiscussList(@PathVariable Integer eId) {
        List<Discuss> dataDiscussList = discussService.getDiscussListByEId(eId);
        if (dataDiscussList == null) {
            return noData;
        } else {
            return new ResultVO<>(dataDiscussList);
        }
    }
}
