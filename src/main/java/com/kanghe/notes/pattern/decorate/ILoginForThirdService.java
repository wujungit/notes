package com.kanghe.notes.pattern.decorate;

/**
 * @Author: W_jun1
 * @Date: 2019/7/12 21:54
 * @Description:
 **/
public interface ILoginForThirdService extends ILoginService {

    public BaseResult<?> loginForPhone(String phoneNo, String code);

    public BaseResult<?> loginForWeiXin(String appId);

    public BaseResult<?> loginForQQ(String openId);

    public BaseResult<?> loginForToken(String token);

}
