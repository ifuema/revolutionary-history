package indi.revolutionaryhistory.service.impl;

import indi.revolutionaryhistory.entity.User;
import indi.revolutionaryhistory.mapper.UserMapper;
import indi.revolutionaryhistory.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据账号密码获取用户id
     * @param user
     * @return
     */
    @Override
    public Integer getUIdByUAccountAndUPassword(User user) {
        return userMapper.selectUIdByUAccountAndUPassword(user);
    }

    /**
     * 根据id文本获取用户信息
     * @param uId
     * @return
     */
    @Override
    public User getUserByUId(Integer uId) {
        return userMapper.selectUserByUId(uId);
    }

    /**
     * 根据id修改用户
     * @param user
     * @return
     */
    @Override
    public boolean modifyUserByUId(User user) {
        if (userMapper.updateUserByUId(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean modifyUserUImgByUId(User user) {
        if (userMapper.updateUserUImgByUId(user) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserPublicByUId(Integer uId) {
        return userMapper.selectUserPublicByUId(uId);
    }

    /**
     * 根据过滤用户信息分页获取用户列表
     * @param pageSize
     * @param pageNum
     * @param user
     * @return
     */
    @Override
    public List<User> getUserListPageByUser(int pageSize, Integer pageNum, User user) {
        Integer startIndex = (pageNum - 1) * pageSize;
        return userMapper.selectUserListPageByUser(pageSize, startIndex, user);
    }

    /**
     * 根据id文本判断是否已存在用户
     * @param uId
     * @return
     */
    @Override
    public boolean checkUserByUId(Integer uId) {
        Integer dataTId = userMapper.selectUIdByUId(uId);
        if (dataTId == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据id删除用户
     * @param uId
     * @return
     */
    @Override
    public boolean removeUserByUId(Integer uId) {
        if (userMapper.deleteUserByUId(uId) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer getUserCount() {
        return userMapper.selectUserCount();
    }
}
