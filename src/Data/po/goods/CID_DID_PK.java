package Data.po.goods;

import java.io.Serializable;
import java.util.Objects;

public class CID_DID_PK implements Serializable {
    String account;
    Integer dishID;

    public CID_DID_PK() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getDishID() {
        return dishID;
    }

    public void setDishID(Integer dishID) {
        this.dishID = dishID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CID_DID_PK that = (CID_DID_PK) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(dishID, that.dishID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, dishID);
    }

    @Override
    public String toString() {
        return "CID_DID_PK{" +
                "account='" + account + '\'' +
                ", dishID=" + dishID +
                '}';
    }
}
