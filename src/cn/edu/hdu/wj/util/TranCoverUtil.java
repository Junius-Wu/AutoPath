package cn.edu.hdu.wj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;

public class TranCoverUtil {
	private static Automatic mAutomatic;
	private static ArrayList<State> states;
	private static ArrayList<Transition> transitions;
	private static State initState;
	private static ArrayList<State> finalStates;	
	private static HashMap<String, State> findStateByID;
	private static HashSet<String> fromToIsCircle;
	private static int originTranSize;
	private static int wantedSize;
	private static double[] points;
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
	public static ArrayList<ArrayList<Transition>> getTranCoverTestCaseFromAutomatic(Automatic automatic, int pathsLimitedSize, double[] statePoints){
		mAutomatic = automatic;
		states = automatic.getStateSet();//���е�״̬
		transitions = automatic.getTransitionSet();//���е�Ǩ��
		initState = automatic.getInitState();// ��ȡ��ʼ״̬
		finalStates = getFinalStates();//��ȡ��ֹ״̬
		pathBacks = new ArrayList<>();// ��ʼ�� ��·��¼
		fromToIsCircle = new HashSet<>();// ��¼���л�·   "a��b"    String
		originTranSize = transitions.size();//��ʼ��transition��Ŀ
		wantedSize = pathsLimitedSize;// ������Ҫ�Ĳ���·����Ŀ
		points = statePoints;// ״̬��Ҫ��
		count = 0;
		if (isEmpty()) {// ������ϵĳ�Ա������һ��Ϊ�� ��ֱ�ӷ���null
			System.err.println("��ָ��");
			return null;
		}
		
		// ����keyΪid ��state��hashmap
		findStateByID = DataHelper.getStateIdHashMap(states);
		
		// ȥ����·�ı�
		removeCircleTran();
		
		System.out.println("ȥ����·�ı�ʣ��" + transitions.size());
		
		
		// �ҳ���ʼ�ڵ㵽��ֹ�ڵ��·��
		ArrayList<ArrayList<Transition>> noCirclePathsFromInitState = new ArrayList<>();
		for(State finalState : finalStates) {
			HashSet<ArrayList<Transition>> directPaths = new HashSet<>();
			for(Transition tran : transitions) {
				if (tran.getSource().equals(initState.getPosition())) { // �ӳ�ʼ�������Ǩ��
					ArrayList<Transition> path = new ArrayList<Transition>();
					
					int[] visited = new int[originTranSize * 2]; 	
					
					dfsPathFromStartToEnd(tran, finalState, 
							visited, path, directPaths);
				}
			}
			noCirclePathsFromInitState.addAll(directPaths);
		}
		
		// ȥ����ʼ�ڵ㵽��ֹ�ڵ��·��������tran
		for(ArrayList<Transition> trans : noCirclePathsFromInitState) {
			transitions.removeAll(trans);
		}
		
		System.out.println("ȥ���Ѹ��ǵ�tran��ʣ��" + transitions.size());
		System.out.println("���δ���ǵ�tran�����е�·��"); 
		// �ҳ�ʣ�µ�tran��ɵĲ���·�� -------------------------
		while(true) {
			if (transitions.size() == 0) {
				break;
			}
			int[] visitedTran = new int[originTranSize * 2];
			ArrayList<Transition> pathPart = new ArrayList<>();
			
			dfsPathPart(transitions.get(0), visitedTran, pathPart);

			// ����ͷβ--------------------------------
			fixPathPartFromOriginPaths(pathPart, noCirclePathsFromInitState);
			noCirclePathsFromInitState.add(pathPart);
			
			transitions.removeAll(pathPart);
			
		}
		
		return noCirclePathsFromInitState;// ��������·��
	}
	// ���·��Ƭ����ԭ�е�·��Ϊ����·��
	private static void fixPathPartFromOriginPaths(ArrayList<Transition> pathPart,
			ArrayList<ArrayList<Transition>> noCirclePathsFromInitState) {
		Transition firstTran = pathPart.get(0);
		Transition lastTran = pathPart.get(pathPart.size() - 1);
		ArrayList<Transition> from = new ArrayList<>();
		ArrayList<Transition> to = new ArrayList<>();
		int indexFrom = -1, indexTo = -1;
		for(ArrayList<Transition> arr : noCirclePathsFromInitState) {
			for(int i = 0; i < arr.size(); i ++) {
				Transition tran = arr.get(i);
				State sourceState = findStateByID.get(tran.getSource());
				State targetState = findStateByID.get(tran.getTarget());
				State sourceStatePart = findStateByID.get(pathPart.get(0).getSource());
				State targetStatePart = findStateByID.get(pathPart.get(pathPart.size() - 1).getTarget());
				
				if (targetState == sourceStatePart) {
					from = arr;
					indexFrom = i;
				}
				if (sourceState == targetStatePart) {
					to = arr;
					indexTo = i;
				}
				if (indexFrom != -1 && indexTo != -1) {
					break;
				}
			}
			if (indexFrom != -1 && indexTo != -1) {
				break;
			}
		}
		try{
			pathPart.addAll(0, from.subList(0, indexFrom + 1));
			pathPart.addAll(to.subList(indexTo + 1, to.size()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	// �ҳ������·��Ƭ��
	private static boolean dfsPathPart(Transition tran, int[] visitedTran, ArrayList<Transition> pathPart) {
		pathPart.add(tran);
		visitedTran[tran.getId()] = 1;
		State targetState = findStateByID.get(tran.getTarget());
		boolean hasNext = false;
		for(Transition nextTran : transitions) {
			if (visitedTran[nextTran.getId()] == 1) {
				continue;
			}
			State sourceStateNow = findStateByID.get(nextTran.getSource());
			if (targetState == sourceStateNow) {
				hasNext = true;
				if (dfsPathPart(nextTran, visitedTran, pathPart)) {
					return true;
				}
			}
		}
		if (!hasNext) {
			return true;
		}
		pathPart.remove(tran);
		visitedTran[tran.getId()] = 0;
		return true;
	}
	
	// ��tran��ʼ��finalState��xxxxxxxxxxx��·��directPaths
	private static boolean dfsPathFromStartToEnd(Transition tran, State finalState, int[] visited,
			ArrayList<Transition> onePath, HashSet<ArrayList<Transition>> directPaths) {
		State targetState = findStateByID.get(tran.getTarget());
		visited[tran.getId()] = 1;
		onePath.add(tran);
		if (targetState == finalState) { // ����Ŀ��ڵ�
			directPaths.add(new ArrayList<>(onePath));
			System.out.println("�õ�һ��·����״̬" +finalState.getId() + "----count :" +count++);
			for(Transition tran1 : onePath) {
				System.out.println(tran1.getName());
			}
			onePath.remove(tran);
			visited[tran.getId()] = 0;
			if (directPaths.size() >= wantedSize / finalStates.size()) { //���Կ��ƿ�ʼ�ڵ㵽��ֹ�ڵ��·����Ŀ15000
				return true;
			} else {
				return false;
			}
		}
		ArrayList<Transition> nextTrans = new ArrayList<>();
		for(Transition nextTran : transitions) {// ���ݸ���������һ��tran
			State sourceStateNow = findStateByID.get(nextTran.getSource());
			State targetStateNow = findStateByID.get(nextTran.getTarget());
			if (targetStateNow.getId() > finalState.getId() ) { // ������ֹ�ڵ��id
				continue;
			} 
			
			if (sourceStateNow == targetState && visited[nextTran.getId()] == 0) { // Ϊ���ӵ�����Ǩ��
				nextTrans.add(nextTran);
			}
		}
		ArrayList<Transition> nextTranSet = new ArrayList<>();
		while(true) {
			Transition selectedNextTran = selectNextTran(nextTrans);
			nextTranSet.add(selectedNextTran);
			
			if (dfsPathFromStartToEnd(selectedNextTran, finalState, visited, onePath, directPaths)) {
				return true;
			}
			if (nextTranSet.size() >= nextTrans.size()) {
				break;
			}
		}
		
		onePath.remove(tran);
		visited[tran.getId()] = 0;
		return false;
	}
	
	// ���ѡ����һ��tran
	private static Transition selectNextTran(ArrayList<Transition> nextTrans) {
		double sum = 0;
		ArrayList<Double> rates = new ArrayList<>();
		int index = 0;
		for(Transition tran : nextTrans) {
			State targetState = findStateByID.get(tran.getTarget());
			sum += points[targetState.getId()];

			rates.add( points[targetState.getId()]);
		}
		
		for(int i = 0; i < rates.size(); i++) {
			rates.set(i, rates.get(i) / sum);
		}
		int resIndex = DataHelper.randomPoints(rates);
//		// ��ѡ�е��Ǹ���Ҫ�ȱ��0
//		Transition nextTran = nextTrans.get(resIndex);
//		int targetId = findStateByID.get(nextTran.getTarget()).getId();
//		points[targetId] = 0;
		
		
 		return nextTrans.get(resIndex);
	}



	// ȥ����·��transition
	private static void removeCircleTran() {
		int removeCount = 0;
		for(int i = 0; i < transitions.size(); i++) {
			Transition tran = transitions.get(i);
			State sourceState = findStateByID.get(tran.getSource());
			State targetState = findStateByID.get(tran.getTarget());
			if (sourceState.getId() >= targetState.getId()) {
				fromToIsCircle.add(sourceState.getId() + "->" + targetState.getId());
				transitions.remove(i);
				removeCount++;
				i--;
			}
		}
		System.out.println("ȥ����" + removeCount + "/" + originTranSize + "��ѭ��Ǩ��");
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
