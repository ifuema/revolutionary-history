package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.mapper.UserMapper;
import indi.revolutionaryhistory.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    @Override
    public User getUserPrivateByUAccount(Long uAccount) {
        return userMapper.selectUserPrivateByUAccount(uAccount);
    }
}
