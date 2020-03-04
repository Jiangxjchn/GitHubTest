package Service;

import Data.DAO.TopupDao;
import Data.po.User.Customer;
import Data.po.User.TopupDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopupService {
    private TopupDao topupDAO=null;
    private List list=new ArrayList();
    public List findByHql(){
        String hql="from TopupDetail as topupdetail order by topupdetail.id";
         list=topupDAO.findByHQL(hql);
        return list;
    }
    public List findById(Customer cus){
         list=topupDAO.findByID(cus);
         System.out.println("Service:"+list);
        return list;
    }
    public void setTopupDAO(TopupDao topupDAO) {
        this.topupDAO = topupDAO;
    }
   public void insert(Customer cus, double money){
        TopupDetail t=new TopupDetail();
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        t.setNumber(money);
        t.setAccount(cus.getAccount());
        t.setTime(df.format(day));
        topupDAO.save(t);
   }
}
