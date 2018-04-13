/**
 * 
 */
package com.flykingmz.zookeeper.configyard;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author flyking
 * 
 */
public class ProgrammaticallyConfigYardTest {
	private final static Logger logger = LoggerFactory
			.getLogger(ProgrammaticallyConfigYard.class);

	public static void main(String[] args) throws InterruptedException {
		ProgrammaticallyConfigYard yard = new ProgrammaticallyConfigYard("39.105.8.31:2181");
		yard.add("testKey1", "1");
		yard.add("testKey2", "2");
		yard.add("testKey3", "3");
		yard.add("testKey4", "4");
		yard.add("testKey5", "5");
		yard.add("testKey6", "6");
		logger.info("value is===>"+yard.get("testKey1"));
		logger.info("value is===>"+yard.get("testKey2"));
		logger.info("value is===>"+yard.get("testKey3"));
		logger.info("value is===>"+yard.get("testKey4"));
		logger.info("value is===>"+yard.get("testKey5"));
		logger.info("value is===>"+yard.get("testKey6"));
		yard.update("testKey6", "testKey6");// 触发上面的监听器，这个监听器只会响应一次，而且只有一个监听器
		logger.info("update testKey6 value is===>"+yard.get("testKey6"));
		yard.delete("testKey1");
		Thread.sleep(1000);//增加延迟防止节点删除后去读删除节点的数据
		yard.delete("testKey2");
		Thread.sleep(1000);
		yard.delete("testKey3");
		Thread.sleep(1000);
		yard.delete("testKey4");
		Thread.sleep(1000);
		yard.delete("testKey5");
		Thread.sleep(1000);
		yard.delete("testKey6");
		while(true){
		}
	}
}

