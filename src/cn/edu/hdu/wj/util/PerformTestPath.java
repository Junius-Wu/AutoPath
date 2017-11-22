package cn.edu.hdu.wj.util;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;

public class PerformTestPath {
	
	private static Automatic mAutomatic;
	private static ArrayList<State> states;
	private static ArrayList<Transition> transitions;
	private static State initState;
	private static HashMap<String, State> findStateByID;
	private static int originTranSize;
	private static int countAt;
	private static int roundCount;
	public static ArrayList<Transition> getPerformTestPathFromAutomatic(Automatic automatic) throws Exception {
		mAutomatic = automatic;
		states = automatic.getStateSet();//���е�״̬
		transitions = automatic.getTransitionSet();//���е�Ǩ��
		originTranSize = transitions.size();
		initState = automatic.getInitState();// ��ȡ��ʼ״̬
		countAt = 0;
		roundCount = 1;
		if (isEmpty()) {// ������ϵĳ�Ա������һ��Ϊ�� ��ֱ�ӷ���null
			System.err.println("��ָ��");
			return null;
		}
		
		// ����keyΪid ��state��hashmap
		findStateByID = DataHelper.getStateIdHashMap(states);
		
		// ȥ����·�ı�
		removeCircleTran();
		
		System.out.println("ȥ����·�ı�ʣ��" + transitions.size());
		
		// * �ҳ���ǵ�һ��·��
		Transition endTran = findMarkedEndTran();
		ArrayList<Transition> performTestPath = new ArrayList<Transition>();
		for(Transition tran : transitions) {
			if (tran.getSource().equals(initState.getPosition()) && tranIsMarked(tran)) {// ��ʼ����ǵı�
				
				dfsMarkedPath(tran, new int[originTranSize * 2], performTestPath, endTran);
				break;
			}
		}
		return performTestPath;
	}
	
	// �ҳ��б�ǵ�·��
	private static boolean dfsMarkedPath(Transition tran, int[] visitedTran, ArrayList<Transition> path, Transition endTran) throws Exception {
		path.add(tran);
		visitedTran[tran.getId()] ++;// ���ʴ���
		if (tran == endTran) {
			System.out.println("�������ܲ���·�� ����Ŀ��Ǩ��");
			return true;
		}
		State targetState = findStateByID.get(tran.getTarget());
		boolean hasNext = false;
		ArrayList<Transition> nextTrans = new ArrayList<>();
		int markedIndex = -1;
		for(int i = 0; i < transitions.size(); i++) {
			Transition nextTran = transitions.get(i);
			if (visitedTran[nextTran.getId()]  == 1) {// ��һ��ѭ�� ���ʴ���������1���ڶ���ѭ�� ���ʴ���������2
				continue;
			}
			State sourceStateNow = findStateByID.get(nextTran.getSource());
			if (targetState == sourceStateNow) {// �ҵ��ڽӵı�
				hasNext = true;
				nextTrans.add(nextTran);
				if (tranIsMarked(nextTran)) {// �жϱ��
					markedIndex = i;
					break;
				}
			}
			
		}
		if (!hasNext) {
			for (Transition transition : path) {
				System.out.println(transition.getName());
			}
			System.out.println("�������ܲ���·�� δ����Ŀ��Ǩ��");
			throw new Exception();
		}
		
		if (nextTrans.size() == 1) {// �޷�֧�����
			if (dfsMarkedPath(nextTrans.get(0), visitedTran, path, endTran)) {
				return true;
			}
		} else {// ��֧���  ����Ҫ�б�ǵ�tran
			if (markedIndex == -1) {
				System.out.println("�������ܲ���·�� ������֧ʱδ�ҵ����");
				throw new Exception();
			}
			if (dfsMarkedPath(transitions.get(markedIndex), visitedTran, path, endTran)) {
				return true;
			}
		}
		
		// ֻ��һ��·�� ����Ҫ����
//		pathPart.remove(tran);
//		visitedTran[tran.getId()] = 0;
		return true;
	}
	// �ҳ������Ϊ##��tran(������־)
	private static Transition findMarkedEndTran() {
		for(Transition tran : transitions) {
			if (tran.getName().contains("##")) {
				return tran;
			}
		}
		return null;
	}
	// tran������򷵻�true
	private static boolean tranIsMarked(Transition nextTran) {
//		if (nextTran.getName().contains(roundCount + "#")) {// ����һ��ѭ���ĵײ�
//			roundCount++;
//		}
//		
//		if (nextTran.getName().contains("\\d+@")) {// ���ֶ��֧ѭ���ߵ����
//			if (nextTran.getName().contains(countAt + "@")) {// �͵�ǰ@һ�µ����
//				countAt++;
//				return true;
//			} else {
//				return false;
//			}
//		} else{
			return nextTran.getName().contains("@@") ;
//		}
		
	}
	
	// �ж������Ƿ�Ϊ��
	private static boolean isEmpty() {
		if (mAutomatic != null && states.size() > 0 && transitions.size() > 0
				&& initState != null) {
			return false;
		}
		return true;
	}
	
	// ȥ����·��transition
	private static void removeCircleTran() {
		int removeCount = 0;
		for(int i = 0; i < transitions.size(); i++) {
			Transition tran = transitions.get(i);
			State sourceState = findStateByID.get(tran.getSource());
			State targetState = findStateByID.get(tran.getTarget());
			if (sourceState.getId() >= targetState.getId()) {
				transitions.remove(i);
				removeCount++;
				i--;
			}
		}
	}
	
}
