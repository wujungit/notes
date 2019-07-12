package com.kanghe.notes.pattern.adapter;

/**
 * 对于非常稳定的方法不去动，直接继承下来
 */
public class LoginForThirdService extends LoginService {

    public BaseResult<?> loginForPhone(String phoneNo, String code) {
        return null;
    }

    public BaseResult<?> loginForWeiXin(String appId) {
        // 1、appId是全局唯一，我们可以把它当作是一个用户名
        // 2、密码默认为null
        // 3、注册（在原有的系统里面创建一个用户）
        BaseResult<Member> registerBR = super.register(appId, null);
        // 4、调用原来的登陆方法
        Member member = registerBR.getContent();
        return super.login(member.getUserName(), member.getPassword());
    }

    public BaseResult<?> loginForQQ(String openId) {
        return null;
    }

    public BaseResult<?> loginForToken(String token) {
        // 通过token拿到用户信息，再重新登陆
        return null;
    }

}
