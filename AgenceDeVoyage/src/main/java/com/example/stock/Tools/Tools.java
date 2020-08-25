package com.example.stock.Tools;

import java.util.Random;

import javafx.scene.Node;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;

public class  Tools {

	public static <T, R extends Node> R loadPage(FxWeaver fxWeaver, Class<T> controller, Class<R> root) {
		FxControllerAndView<T, R> add_team = fxWeaver.load(controller);
		return add_team.getView().get();
	}
	public static Long generateRandomIntIntRange(int min, int max) {
	    Random r = new Random();
	    	Long l=new Long(r.nextInt((max - min) + 1) + min);
	    		return  l;
	}
}
