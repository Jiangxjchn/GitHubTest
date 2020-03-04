package SpringContext;

import Data.po.goods.OrderDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringMain {
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
    }
    public  Object getBean(String name){
        return applicationContext.getBean(name);
    }
    public static OrderDetail newOrderDetail(){
        return new OrderDetail();
    }

}
