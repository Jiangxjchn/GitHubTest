package Data.po.goods;

public class Comment {
	private Integer id;
	private String detail;
	private String customer;
	private Dish dish;
    private Integer type;
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
	
}
