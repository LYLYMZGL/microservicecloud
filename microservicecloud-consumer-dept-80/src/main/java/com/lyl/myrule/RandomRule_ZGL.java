package com.lyl.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZGL extends AbstractLoadBalancerRule{
	//当total=5，currentIndex+1,total重新置为0
	private int total=0;	//总共被调用的次数，目前要求每台被调用5次
	private int currentIndex=0; 	//当前提供服务的机器号
	
	public Server choose(ILoadBalancer lb,Object key) {
		if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            if(total<5) {
            	server=upList.get(currentIndex);
            	total++;
            }else {
            	total=0;
            	currentIndex++;
            	if(currentIndex>=upList.size()) {
            		currentIndex=0;
            	}
            }
            
            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;
	}
	
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}
	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}
}
