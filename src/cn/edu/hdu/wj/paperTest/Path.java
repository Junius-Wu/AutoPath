package cn.edu.hdu.wj.paperTest;

import java.util.ArrayList;

import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;

public class Path {
	public Path() {
		trans = new ArrayList<>();
		states = new ArrayList<>();
	}
	ArrayList<Transition> trans;
	ArrayList<State> states;
	
}
