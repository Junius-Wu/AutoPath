package cn.edu.hdu.wj.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;

public class GeneratePath {
	private static Automatic mAutomatic;
	private static HashMap<String, State> findStateByID;
	private static double[] statePoints;
	// ·�����Զ�������ʽ�� + ·������Ҫ��
	static class PathAndImpPoint implements Comparable<PathAndImpPoint>{
		Automatic automatic;
		double impPoint;
		public PathAndImpPoint(ArrayList<Transition> transitions) {
			Automatic auto = new Automatic();
			ArrayList<State> states = new ArrayList<>();
			HashSet<State> stateSet = new HashSet<>();
			for(Transition tran : transitions) {
				// ȥ����Ƿ�
				tran.setName(tran.getName().replaceAll("@@", ""));
				tran.setName(tran.getName().replaceAll("##", ""));
				stateSet.add(findStateByID.get(tran.getSource()));
				stateSet.add(findStateByID.get(tran.getTarget()));
			}
			states.addAll(stateSet);
			auto.setStateSet(states);
			auto.setTransitionSet(transitions);
			automatic = auto;
			// �ۼ�·����״̬����Ҫ�� ��Ϊ·������Ҫ��
			double count = 0;
			for(State s : states) {
				count += statePoints[s.getId()];
			}
			impPoint = count;
			
		}
		@Override
		public int compareTo(PathAndImpPoint object) {
			if (this.impPoint < object.impPoint) return -1;
			if (this.impPoint > object.impPoint) return 1;
			return 0;
		}
	}
	// ��ȡ·��
	public static ArrayList<Automatic> getFormatPathFromAutomatic(Automatic automatic, int wantedSize) {
		mAutomatic = automatic;
		if (findStateByID == null) {
			findStateByID = DataHelper.getStateIdHashMap(automatic.getStateSet());
		}
		if (statePoints == null) {
			statePoints = DataHelper.getStatesImportantPoint(automatic);
		}
		
		/*
		 *  �������ÿ�ʼ����ֹ·���� ÿһ����ֹ��xxxxxxxxxxx��
		 *  1��ʱ���Ϊ204  15000��ʱ���Ϊ60018��ȫǨ�Ƹ��ǳ��˻�·��
		 */
		ArrayList<ArrayList<Transition>> paths = 
				TranCoverUtil.getTranCoverTestCaseFromAutomatic(automatic, wantedSize, statePoints);
		
		System.out.println("����" + paths.size() + "��·��");
		
		
		ArrayList<Automatic> res = new ArrayList<>();
		for(ArrayList<Transition> tranList : paths) {
			res.add(GeneratePath.fromTranListToAuto(tranList));
		}
		
		return res;
	}
	// ���ܲ��Ե�һ��·��
	public static Automatic getPerformPathFromAutomatic(Automatic automatic) throws Exception {
		mAutomatic = automatic;
		findStateByID = DataHelper.getStateIdHashMap(automatic.getStateSet());
		statePoints = DataHelper.getStatesImportantPoint(automatic);
		
		ArrayList<Transition> tranList = PerformTestPath.getPerformTestPathFromAutomatic(automatic);
		for(Transition tran : tranList) {
			System.out.println();
			System.out.println(tran.getName());
			System.out.println("condition:" + tran.getCondition());
		}
		return GeneratePath.fromTranListToAuto(tranList);
	}
	
	public static Automatic fromTranListToAuto(ArrayList<Transition> tranList) {
		PathAndImpPoint pp = new PathAndImpPoint(tranList);
		return pp.automatic;
	}
}
