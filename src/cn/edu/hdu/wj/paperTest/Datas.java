package cn.edu.hdu.wj.paperTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.wj.util.DataHelper;

public class Datas {
 
	public final static int MAX_PATH_SIZE = 1000;
	public static Automatic automatic;
	public static ArrayList<Transition> transitions;
	public static ArrayList<Transition> circleTrans;

	public static ArrayList<Transition> initTransitions;
	public static ArrayList<State> states;
	public static State initState;
	public static int[][] table;
	public static boolean[] tranCovered;
	public static int coveredCount;
	public static HashMap<String, State> findStateById;
	public static ArrayList<State> finalStates;
	
	private static HashSet<String> fromToIsCircle;

	static {
		automatic = GetAutomatic.getAutomatic("UAVForXStreamGaoDuV9.xml");
		transitions = automatic.getTransitionSet();
		states = automatic.getStateSet();
		table = new int[MAX_PATH_SIZE][transitions.size()];//姑且认为生成数量少于1000条
		tranCovered = new boolean[transitions.size()];
		coveredCount = 0;
		findStateById = DataHelper.getStateIdHashMap(states);
		fromToIsCircle = new HashSet<>();
		circleTrans = new ArrayList<>();
		initState = automatic.getInitState();
		
		
		
	}
	static { // 去回路
		int originTranSize = transitions.size();
		int removeCount = 0;
		for(int i = 0; i < transitions.size(); i++) {
			Transition tran = transitions.get(i);
			State sourceState = findStateById.get(tran.getSource());
			State targetState = findStateById.get(tran.getTarget());
			if (sourceState.getId() >= targetState.getId()) {
				fromToIsCircle.add(sourceState.getId() + "->" + targetState.getId());
				circleTrans.add(transitions.remove(i));
				removeCount++;
				i--;
			}
		}
		System.out.println("去掉了" + removeCount + "/" + originTranSize + "条循环迁移");

	
	}
	static {
		for(Transition tran : Datas.transitions) {
			if (tran.getSource().equals(Datas.initState.getPosition())) { // 从初始点出发的迁移
				initTransitions.add(tran);
			}
		}
	}
	static{// 终止状态
		finalStates = new ArrayList<>();
		for(State state : states) {
			if (state.isFinalState()) {
				finalStates.add(state);
			}
		}
	}
	

//	public static BlockingQueue<Path> generationPaths; 
//	static {
//		generationPaths = new LinkedBlockingDeque<>(10);
//		new Thread(new GPQuest()).start();
//	}
	
	
	static boolean allCovered() {// 所有的迁移是否都被覆盖
		return coveredCount == transitions.size();
	}
	
	static void setCovered(int k) {// 设置第k条边为已覆盖
		tranCovered[k] = true;
		coveredCount++;
	}
	static void setCovered(int k, boolean value) {
		tranCovered[k] = value;
		if(value == true) coveredCount++; else coveredCount--;
	}

}
