package com.example.skyworthclub.serviceinnovation.Homepage.utils;

import java.util.LinkedList;

/**
 * Created by skyworthclub on 2018/4/10.
 */

/*
固定长度队列实现
@params limit 队列长度
 */
public class LimitQueue<E> {
    private int limit;
    private LinkedList<E> queue = new LinkedList<>();

    public LimitQueue(int limit){
        this.limit = limit;
    }

    //入队
    public void offer(E e){
        //插入时，如果队列长度大于固定长度，先poll再插入
        if (queue.size() >= limit){
            queue.poll();
        }
        queue.offer(e);
    }

    //出队
    public E poll(){
        return queue.poll();
    }

    public E get(int position){
        return queue.get(position);
    }

    //获取队列
    public LinkedList<E> getQueue() {
        return queue;
    }

    //获取队列长度
    public int getLimit() {
        return limit;
    }

    public void clear(){
        queue.clear();
    }
}
