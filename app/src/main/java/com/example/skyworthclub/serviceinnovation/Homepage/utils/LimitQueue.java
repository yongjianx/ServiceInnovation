package com.example.skyworthclub.serviceinnovation.Homepage.utils;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by skyworthclub on 2018/4/10.
 */

/*
固定长度队列实现
@params limit 队列长度
 */
public class LimitQueue<E> implements Serializable{
    private int limit;
    private LinkedList<E> queue;

    public LimitQueue(int limit){
        queue = new LinkedList<>();
        this.limit = limit;
    }

    //入队
    public void offer(E e){
        //插入时，如果队列长度大于固定长度，先poll再插入
        if (queue.contains(e))
            return;
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
        if(position >= queue.size())
            return null;
        return queue.get(position);
    }

    //获取队列
    public LinkedList<E> getQueue() {
        return queue;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    //获取队列长度
    public int getLimit() {
        return limit;
    }

    public int getSize(){
        return queue.size();
    }

    public void clear(){
        queue.clear();
    }
}
