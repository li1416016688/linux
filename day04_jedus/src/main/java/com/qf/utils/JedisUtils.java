package com.qf.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPool jedisPool =null;
    static {
        //jedis连接池的配置对象
        JedisPoolConfig config=new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最少有几个空闲的
        config.setMinIdle(5);
        //最多有几个空闲的
        config.setMaxIdle(10);
        //创建jedis连接池对象
        jedisPool=new JedisPool(config,"10.211.55.3",6379,1000,"12345678");


    }

    //获取jedis对象
    public static Jedis getJedis(){
        return jedisPool.getResource();

    }

    public static void closeJedis(Jedis jedis){
//        jedisPool.returnResource(jedis);//已废弃，资料中会遇见，也是关闭
        jedis.close();
    }

}
