package com.curiousinc.java.lambda.core;

import java.time.Month;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foundation {

	private static Logger logger = LoggerFactory.getLogger(Foundation.class);

	public static void main(String[] args) {

		ExecutionTimeTracker.measure(Arrays.stream(Month.values()).map(Month::toString).collect(Collectors.toList()),
				(preJava5Months) -> {
					logger.debug("Pre Java5 : ");
					for (int i = 0; i < preJava5Months.size(); i++) {
						if (preJava5Months.get(i).length() > 4) {
							logger.debug("{} is a long month", preJava5Months.get(i));
						}
					}
					return null;
				});

		ExecutionTimeTracker.measure(Arrays.stream(Month.values()).map(Month::toString).collect(Collectors.toList()),
				(java5Months) -> {
					logger.debug("Java5 : ");
					for (String month : java5Months) {
						if (month.length() > 4) {
							logger.debug("{} is a long month", month);
						}
					}
					return null;
				});

		ExecutionTimeTracker.measure(Arrays.stream(Month.values()).map(Month::toString).collect(Collectors.toList()),
				(java8Months) -> {
					logger.debug("Java8 : ");
					java8Months.stream().filter((string) -> string.length() > 4).forEach(logger::debug);
					return null;
				});

		ExecutionTimeTracker.measure(Arrays.stream(Month.values()).map(Month::toString).collect(Collectors.toList()),
				(java8Months) -> {
					logger.debug("Java8 Parallel: ");
					java8Months.parallelStream().filter((string) -> string.length() > 4).forEach(logger::debug);
					return null;
				});
	}

}
