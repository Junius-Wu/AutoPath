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
	public static boolean arv[][];
	public static int[][] table;
	public static boolean[] tranCovered;
	public static int coveredCount;
	public static HashMap<String, State> findStateById;
	public static ArrayList<State> finalStates;
	public static HashSet<Integer> coveredIds;
	private static HashSet<String> fromToIsCircle;

	static {
		automatic = GetAutomatic.getAutomatic("UAVForXStreamGaoDuV9.xml");
		transitions = automatic.getTransitionSet();
		states = automatic.getStateSet();
		table = new int[MAX_PATH_SIZE][transitions.size()];//������Ϊ������������1000��
		arv = new boolean[states.size()][states.size()];
		tranCovered = new boolean[transitions.size() + 1];
		coveredCount = 0;
		findStateById = DataHelper.getStateIdHashMap(states);
		fromToIsCircle = new HashSet<>();
		circleTrans = new ArrayList<>();
		initState = automatic.getInitState();
		coveredIds = new HashSet<>();
		
		
	}
	static { // ȥ��·
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
		System.out.println("ȥ����" + removeCount + "/" + originTranSize + "��ѭ��Ǩ��");

//		for(Transition tran : transitions) {
//			System.out.println(findStateById.get(tran.getSource()).getId());
//		}
	
	}
	static {// ��ʼ��
		initTransitions = new ArrayList<>();
		for(Transition tran : Datas.transitions) {
			tran.setId(tran.getId() - 1);
			if (tran.getSource().equals(Datas.initState.getPosition())) { // �ӳ�ʼ�������Ǩ��
				initTransitions.add(tran);
			}
		}
		System.out.println("��ʼ�����");
	}
	static{// ��ֹ״̬
		finalStates = new ArrayList<>();
		for(State state : states) {
			if (state.isFinalState()) {
				finalStates.add(state);
			}
		}
		System.out.println("��̬���");

	}
	
	static { 
		for(Transition tran:transitions) {//�ڽӾ���
			int source = findStateById.get(tran.getSource()).getId();
			int target = findStateById.get(tran.getTarget()).getId();
//			System.out.println(source);
//			System.out.println(target);
			arv[source - 1][target - 1] = true;
		}
		boolean[] finished = new boolean[arv.length];
		for(int i = 0; i < arv.length; i++) {
			full(finished,i);
		}
		System.out.println(arv);
	}
	private static void full(boolean[] finished, int i) {
		if (finished[i] == true) {
			return;
		}
		for(int j = i + 1; j < arv.length; j++) {
			if (arv[i][j] == true) {
				full(finished, j);
				for(int k = j + 1; k < arv.length; k++) {
					if (arv[j][k] == true) {
						arv[i][k] = true;
					}
				}
			}
		}
		finished[i] = true;
	}

//	public static BlockingQueue<Path> generationPaths; 
//	static {
//		generationPaths = new LinkedBlockingDeque<>(10);
//		new Thread(new GPQuest()).start();
//	}
	
	static int pcount = 0;
	static boolean allCovered() {// ���е�Ǩ���Ƿ񶼱�����
		int count = 2;
		for(int i = 0; i < tranCovered.length; i++) {
			if (tranCovered[i] == true) {
				count++;
			}
		}
		System.out.println("������"+count + "  ����"+pcount++);
		return count >= transitions.size();
	}
	
	

	static void setCovered(int k) {// ���õ�k����Ϊ�Ѹ���
 		tranCovered[k] = true;
		//coveredCount++;
	}
	static void setCovered(int k, boolean value) {
		tranCovered[k] = value;
		//if(value == true) coveredCount++; else coveredCount--;
	}

}
