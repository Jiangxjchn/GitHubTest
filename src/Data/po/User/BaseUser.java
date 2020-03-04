package Data.po.User;

import java.util.Objects;

public class BaseUser implements IUser {
    protected String id;
    protected String account;
    protected String password;
    protected String type;

    public BaseUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseUser(String account, String password, String type, String id) {
        this.account = account;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUser baseUser = (BaseUser) o;
        return Objects.equals(id, baseUser.id) &&
                Objects.equals(account, baseUser.account) &&
                Objects.equals(password, baseUser.password) &&
                Objects.equals(type, baseUser.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, type);
    }
}
