package Service;

import Data.po.User.IUser;

public interface IUserService<T> {
    public T login(T user);
}
