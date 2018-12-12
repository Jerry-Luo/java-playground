package com.jerry.snowflake;

import java.util.HashSet;
import java.util.Set;

/**
 * Filename      IdWorker
 * Description   twitter snowflake 的 java 实现
 * Copyright     Copyright (c) 2016-2022 All Rights Reserved.
 * Company       fintechzh.com Inc.
 * @author       罗建伟
 * @date         2018-12-12 00:04 
 * @version      1.0
 */
public class IdWorker {

    private long workerId;
    private long datacenterId;
    private long sequence;

    public IdWorker(long workerId, long datacenterId, long sequence) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d", timestampLeftShift, datacenterIdBits,
            workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

//    private long twepoch            = 1544544809524L;
    private long twepoch            = 0L;

    private long workerIdBits       = 5L;
    private long datacenterIdBits   = 5L;
    private long maxWorkerId        = ~(-1L << workerIdBits);
    private long maxDatacenterId    = ~(-1L << datacenterIdBits);
    private long sequenceBits       = 12L;

    private long workerIdShift      = sequenceBits;
    private long datacenterIdShift  = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask       = ~(-1L << sequenceBits);

    private long lastTimestamp      = -1L;

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    //---------------测试---------------
    public static void main(String[] args) {

        IdWorker worker = new IdWorker(1, 1, 1);
        Set<String> set = new HashSet<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println(worker.nextId());
//            set.add(String.valueOf(worker.nextId()));
        }
        System.out.println();
        System.out.println((System.currentTimeMillis()-start) + "ms");
        System.out.println(set.size());
    }

}