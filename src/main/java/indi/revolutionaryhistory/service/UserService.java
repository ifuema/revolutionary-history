package indi.revolutionaryhistory.service;

import indi.revolutionaryhistory.entity.User;

public interface UserService {
    /**
     * 根据账号文本获取用户隐私信息
     * @param uAccount
     * @return
     */
    User getUserPrivateByUAccount(Long uAccount);
}
