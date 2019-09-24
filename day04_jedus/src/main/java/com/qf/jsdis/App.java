package com.qf.jsdis;

import com.qf.utils.JedisUtils;
import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis =new Jedis("10.211.55.3",6379,1000);
        //设置redis服务的密码
        jedis.auth("12345678");
        //根据key值获取字符串数据
//        String name = jedis.get("name");
//        System.out.println(name);

        //设置字符串类型
//        jedis.set("height" ,"310");
//        String height = jedis.get("height");
//        System.out.println(height);
//        Long hset=null;
//        hset = jedis.hset("preson", "name", "zhangsan");
//        hset = jedis.hset("preson","age","20");
//        System.out.println(hset);
//        //关闭
//        jedis.close();

        //对连接池操作
        Jedis jedis1 = JedisUtils.getJedis();
        System.out.println(jedis1.get("name"));
        JedisUtils.closeJedis(jedis1);

    }
}
