package Comparetor;

import Data.po.goods.Dish;

import java.util.Comparator;

public class DishComparetor implements Comparator<Dish>{
	public int compare(Dish d1, Dish d2) {
		
		if (d2.getSalesNum()==0) return -1;
    	if (d1.getSalesNum()==0) return 1;
    	return (d2.getGoodRate()*d1.getSalesNum())-(d1.getGoodRate()*d2.getSalesNum());
      
    }
}
