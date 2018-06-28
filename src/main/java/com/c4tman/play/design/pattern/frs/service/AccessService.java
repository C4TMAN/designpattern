package com.c4tman.play.design.pattern.frs.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

/**
 * 应该是用redis实现
 * 但是我需要好好斟酌 🙂
 * Created by zhangxiaoman on 2018/6/28.
 */
@Service
public class AccessService {


    private ShardedJedis jedis;

    public boolean access(String key, int timeUnit, int max) {
        String unit = jedis.get(key);
        if (null == unit) {
            unit = new StoreUnit().toString();
        }


        return true;
    }

    @Getter
    class StoreUnit {
        //第一次访问时间
        long startTime;
        //最近一次访问时间
        long lastTime;
        //时间内访问总次数
        long count;

        public StoreUnit() {
            startTime = System.currentTimeMillis();
            lastTime = System.currentTimeMillis();
            count = 1;
        }

        public StoreUnit(long startTime, long lastTime, long count) {
            this.startTime = startTime;
            this.lastTime = lastTime;
            this.count = count;
        }

        @Override
        public String toString() {
            return startTime + "-" + lastTime + "-" + count;
        }
    }

    class StoreUnitBuilder {

        public StoreUnit build(String str) {
            String[] strs = str.split("-");

            long startTime = Long.parseLong(strs[0]);
            long lastTime = Long.parseLong(strs[1]);
            long count = Long.parseLong(strs[2]);
            return new StoreUnit(startTime, lastTime, count);
        }
    }

}
