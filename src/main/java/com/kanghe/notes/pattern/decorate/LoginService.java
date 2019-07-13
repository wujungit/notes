package com.kanghe.notes.pattern.decorate;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 21:53
 * @Description:
 **/
public class LoginService implements ILoginService {
    @Override
    public BaseResult<Member> register(String userName, String password) {
        return null;
    }

    @Override
    public BaseResult<?> login(String userName, String password) {
        return null;
    }
}
