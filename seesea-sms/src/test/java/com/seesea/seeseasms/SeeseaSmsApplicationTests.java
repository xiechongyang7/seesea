package com.seesea.seeseasms;

import com.seesea.seeseacommon.redis.RedisUtils;
import com.seesea.seeseacommon.spring.SpringContextUtil;
import com.seesea.seeseasms.service.ISmsChannel;
import com.seesea.seeseasms.service.Impl.NetEaseImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeeseaSmsApplicationTests {

    @Test
    public void contextLoads() {
        for(int i = 10000; i< 15000;i++){
            String name = "test"+i;
            RedisUtils.del(name);
        }
    }

    @Test
    public void getBean() {
//        ISmsChannel smsChannel = SpringContextUtil.getBean("NetEase", ISmsChannel.class);
//        ISmsChannel smsChannel2 = SpringContextUtil.getBean("netEase", ISmsChannel.class);
//        Map<String,ISmsChannel> smsChannennnnnnnnnnnnnnnnnnnnnnnnnn
// .l3 = (Map<String, ISmsChannel>) SpringContextUtil.getBean(ISmsChannel.class);

        try{
            SpringContextUtil.getBean("NetEase",NetEaseImpl.class);
            System.out.println(11);

        }catch (Exception e){
           System.out.println(""+e);

        }

        try{
            SpringContextUtil.getBean(NetEaseImpl.class);
            System.out.println(22);


        }catch (Exception e){
            System.out.println(2+"+e"+e);

        }

        try{
            SpringContextUtil.getBean(ISmsChannel.class);
            System.out.println(33);

        }catch (Exception e){
            System.out.println(3+"+e"+e);

        }

//        System.out.println(smsChannel3);
    }



}
