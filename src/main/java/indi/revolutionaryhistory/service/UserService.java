package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.User;

public interface UserService {
    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    User getUserPrivateByUAccount(Long uAccount);

    /**
     * 根据账号文本判断是否已存在用户
     * @param uAccount
     * @return
     */
    boolean checkUserByUAccount(Long uAccount);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean saveUser(User user);
}
