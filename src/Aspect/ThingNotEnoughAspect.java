package Aspect;

import Data.po.User.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Aspect
public class ThingNotEnoughAspect {
    static Map<String,Integer> dishMap=new HashMap<>();
    @Pointcut("execution( * Service.CustomerService.PlaceAnOrder(..))")
    private void modify(){}
    @AfterThrowing(value = "modify()",throwing = "e")
    private  void handleThrowing(JoinPoint joinPoint, Exception e)  {
        //System.out.println(Arrays.toString(joinPoint.getArgs()));
        try{
            Object[] para=joinPoint.getArgs();
            //System.out.println(para[0]);
            System.out.println("----"+e.getMessage()+ "----");
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            File file=new File("log.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            if(!file.exists()){
                file.createNewFile();
            }
            Date date=new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");
            String time = dateformat.format(date);
            if(e.getMessage().contains("余额")){

                out.write(time+":"+"["+joinPoint.getSignature().getName()+"]"+"账户"+((Customer)para[0]).getAccount()+" "+((Customer)para[0]).getNickname()+" "+e.getMessage());
                out.newLine();
            }
            else{
                out.write(time+":"+"["+joinPoint.getSignature().getName()+"]"+"账户"+((Customer)para[0]).getAccount()+" "+((Customer)para[0]).getNickname()+" "+e.getMessage());
                out.newLine();
            }
            out.close();
            in.close();
        }catch (IOException e1){
            e1.printStackTrace();
        }

    }
}
