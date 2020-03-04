package Data.po.User;
import java.util.Objects;

public class TopupDetail {
    private int id;
    private double number;
    private String time;
    private String account;

    public TopupDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopupDetail that = (TopupDetail) o;
        return id == that.id &&
                Double.compare(that.number, number) == 0 &&
                Objects.equals(time, that.time) &&
                Objects.equals(account, that.account);
    }

    @Override
    public String toString() {
        return "TopupDetail{" +
                "id=" + id +
                ", number=" + number +
                ", time=" + time +
                ", account='" + account + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, time, account);
    }

}