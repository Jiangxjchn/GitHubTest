package Comparetor;

import Data.po.goods.Dish;

import java.util.Comparator;

public class DishComparetor2 implements Comparator<Dish>{
	public int compare(Dish d1, Dish d2) {
		
		
    	return (d2.getSalesNum()-d1.getSalesNum());
      
    }
}
