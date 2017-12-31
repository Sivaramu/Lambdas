package com.curiousinc.java.lambda.core;

import java.text.NumberFormat;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutionTimeTracker {

	private static Logger logger = LoggerFactory.getLogger(ExecutionTimeTracker.class);

	public static <T,R> R measure(T param, Function<T, R> func) {
		long startTime = System.nanoTime();
		R r = func.apply(param);
		logger.debug("Took {} ns", NumberFormat.getInstance().format(System.nanoTime() - startTime));
		return r;
	}

}
