package cn.edu.hdu.wj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;

public class PathCoverUtil {
	private static Automatic mAutomatic;
	private static ArrayList<State> states;
	private static ArrayList<Transition> transitions;
	private static State initState;
	private static ArrayList<State> finalStates;	
	private static HashMap<String, State> findStateByID;
	private static HashSet<String> fromToIsCircle;
	private static int count;
	static class pathBack{
		State start;
		State end;
		public pathBack(State start, State end) {
			this.start = start;
			this.end = end;
		}
	}
	private static ArrayList<pathBack> pathBacks;
	// �����Զ�������   ·�����ǵĲ�������
	public static HashSet<ArrayList<Transition>> getPathCoverTestCaseFromAutomatic(Automatic automatic) {
		mAutomatic = automatic;
		states = automatic.getStateSet();//���е�״̬
		transitions = automatic.getTransitionSet();//���е�Ǩ��
		initState = automatic.getInitState();// ��ȡ��ʼ״̬
		finalStates = getFinalStates();//��ȡ��ֹ״̬
		pathBacks = new ArrayList<>();// ��ʼ�� ��·��¼
		fromToIsCircle = new HashSet<>();// ��¼���л�·   "a��b"    String
		count = 0;// ��¼·��������
		if (isEmpty()) {// ������ϵĳ�Ա������һ��Ϊ�� ��ֱ�ӷ���null
			System.err.println("��ָ��");
			return null;
		}
		// ����keyΪid ��state��hashmap
		findStateByID = DataHelper.getStateIdHashMap(states);
		
		
		
		HashSet<ArrayList<Transition>> noCirclePathsFromInitState = new HashSet<>();
		for(State finalState : finalStates) {
			HashSet<ArrayList<Transition>> directPaths = new HashSet<>();
//			if (finalState.getId() ==  initState.getId()) {
//				continue;
//			}
			for(Transition tran : transitions) {
				if (tran.getSource().equals(initState.getPosition())) { // �ӳ�ʼ�������Ǩ��
					ArrayList<Transition> path = new ArrayList<Transition>();
					
					int[] visited = new int[transitions.size() + 1]; 	
					
					dfsPathFromStartToEndExceptCircle(tran, finalState, 
							visited, path, directPaths);
				}
			}
			noCirclePathsFromInitState.addAll(directPaths);
		}
		
		
		return noCirclePathsFromInitState;// ��������·��
	}

	// ·�����ǵ� ȥ������ ��tran��ʼ��finalState������·������ΪdirectPaths
	private static void dfsPathFromStartToEndExceptCircle(Transition tran, State finalState, int[] visited,
			ArrayList<Transition> onePath, HashSet<ArrayList<Transition>> directPaths) {
		State sourceState = findStateByID.get(tran.getSource());
		State targetState = findStateByID.get(tran.getTarget());
		
		visited[tran.getId()] = 1;
		onePath.add(tran);
//		if (targetState.getId() == 1) {
//			System.out.println(1);
//		}
		if (targetState == finalState) { // ����Ŀ��ڵ�
			directPaths.add(new ArrayList<>(onePath));
			count++;
			System.out.println("�õ�һ��·����״̬" +finalState.getId() + "----count :" +count);
			
				
			
			for(Transition tran1 : onePath) {
				System.out.println(tran1.getName());
			}
			onePath.remove(tran);
			visited[tran.getId()] = 0;
			return ;
		}
		
		if (sourceState.getId() >= targetState.getId()) { // �ǻ�· 
			if (fromToIsCircle.add(sourceState.getId() + "��" + targetState.getId())) {// û����ؼ�¼
				pathBacks.add(new pathBack(sourceState, targetState));// ��¼
			}
			
			onePath.remove(tran);
			visited[tran.getId()] = 0;
			return ;
		}
		

		
		
		boolean in = false;
		for(Transition nextTran : transitions) {
			State sourceStateNow = findStateByID.get(nextTran.getSource());
			State targetStateNow = findStateByID.get(nextTran.getTarget());
			if (targetState.getId() > sourceStateNow.getId() || targetStateNow.getId() > finalState.getId() ) {
				continue;
			} else {
//				System.out.println(nextTran.getName());
			}
			if (nextTran.getName().equals("loopSSSSSSSSSSSSSSSS()")) {
//				System.out.println(123);
			}
			if (sourceStateNow == targetState && visited[nextTran.getId()] == 0) { // Ϊ���ӵ�����Ǩ��
				dfsPathFromStartToEndExceptCircle(nextTran, finalState, visited, onePath, directPaths);
				
			}
		}
		if (!in) {
//			System.out.println("��·����");
		}
		onePath.remove(tran);
		visited[tran.getId()] = 0;
		return ;
	}
	// �ж������Ƿ�Ϊ��
	private static boolean isEmpty() {
		if (mAutomatic != null && states.size() > 0 && transitions.size() > 0
				&& initState != null && finalStates.size() > 0) {
			return false;
		}
		return true;
	}

	private static ArrayList<State> getFinalStates() {
		ArrayList<State> finalStates = new ArrayList<>();
		for(State state : states) {
			if (state.isFinalState()) {
				finalStates.add(state);
			}
		}
		return finalStates;
	}

	
}
