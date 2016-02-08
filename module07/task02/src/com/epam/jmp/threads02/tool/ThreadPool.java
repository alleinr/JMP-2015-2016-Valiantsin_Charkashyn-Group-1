package com.epam.jmp.threads02.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	private final ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	private static ThreadPool pool;
	private ThreadPool() {		
	}
	
	public static ThreadPool getInstance(){
		if (pool == null){
			synchronized (ThreadPool.class){
				if (pool == null){
					pool = new ThreadPool();
				}
			}
		}
		return pool;
	}
	
	
	public void addThread(Runnable thread){
		executorService.submit(thread);
	}
}
