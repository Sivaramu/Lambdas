package com.curiousinc.java.lambda.core;

import java.util.function.IntUnaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaOperator {

	public static Logger logger = LoggerFactory.getLogger(LambdaOperator.class);
	
	public static IntUnaryOperator factorial;
			
	public static void main(String[] args) {
		
		factorial = i -> i == 0 ? 1 : i * factorial.applyAsInt(i - 1);
		
		logger.info("Operator {}", factorial.applyAsInt(10));
	}

}
