package Data.po.User;

import java.util.Objects;

public class Staff {
    private String name ;
    private String id ;
    private Double pay ;
    private String position ;
    private String account;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Double.compare(staff.pay, pay) == 0 &&
                Objects.equals(name, staff.name) &&
                Objects.equals(id, staff.id) &&
                Objects.equals(position, staff.position) &&
                Objects.equals(account, staff.account) &&
                Objects.equals(password, staff.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), account, name, id, position, pay, password);
    }
}
