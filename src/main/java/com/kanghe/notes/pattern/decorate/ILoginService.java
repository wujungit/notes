package com.kanghe.notes.pattern.decorate;

public interface ILoginService {

    public BaseResult<Member> register(String userName, String password);

    public BaseResult<?> login(String userName, String password);

}
