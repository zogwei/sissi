package com.sissi.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author kim 2013年11月28日
 */
public class Interval {

	private final Long interval;

	private final TimeUnit unit;

	public Interval(Long interval, TimeUnit unit) {
		super();
		this.interval = interval;
		this.unit = unit;
	}

	public Long convert(TimeUnit unit) {
		return unit.convert(this.interval, this.unit);
	}

	public Long getInterval() {
		return this.interval;
	}

	public TimeUnit getUnit() {
		return this.unit;
	}
}