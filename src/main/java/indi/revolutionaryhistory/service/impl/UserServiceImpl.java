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

    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    @Override
    public boolean checkUserByUAccount(Long uAccount) {
        Integer dataUId = userMapper.selectUIdByUAccount(uAccount);
        if (dataUId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        if (userMapper.insertUser(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }
}
