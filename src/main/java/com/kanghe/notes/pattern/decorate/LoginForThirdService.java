package com.kanghe.notes.pattern.decorate;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 21:55
 * @Description:
 **/
public class LoginForThirdService implements ILoginForThirdService {

    private ILoginService service;

    public LoginForThirdService(ILoginService service) {
        this.service = service;
    }

    @Override
    public BaseResult<Member> register(String userName, String password) {
        return this.service.register(userName, password);
    }

    @Override
    public BaseResult<?> login(String userName, String password) {
        return this.service.login(userName, password);
    }

    @Override
    public BaseResult<?> loginForPhone(String phoneNo, String code) {
        return null;
    }

    @Override
    public BaseResult<?> loginForWeiXin(String appId) {
        return null;
    }

    @Override
    public BaseResult<?> loginForQQ(String openId) {
        return null;
    }

    @Override
    public BaseResult<?> loginForToken(String token) {
        return null;
    }
}
