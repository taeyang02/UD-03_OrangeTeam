package com.orange.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Queue<T> {
	protected static final Logger LOG = LoggerFactory.getLogger(Queue.class);
	protected final String queueName;
	protected final Class<T> classOfT;

	public Queue(String queueName, Class<T> classOfT) {
		this.queueName = queueName;
		this.classOfT = classOfT;
	}

	public String getQueueName() {
		return queueName;
	}

	public Class<T> getClassOfT() {
		return classOfT;
	}

	public abstract void add(T t);

	public abstract T remove();
}