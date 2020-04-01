package com.example.stock.controller;

import java.util.Date;

public class DateUtil {

	public static long calculerLeNombreDeJours(Date date,Date date2) {
		long milliSeconde = date2.getTime()-date.getTime();
		return milliSeconde/(1000*24*3600);
	}
}
