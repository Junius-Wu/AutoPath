package cn.edu.hdu.wj.util;

import java.util.ArrayList;
import java.util.HashMap;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.State;

public class DataHelper {

	// ���ø���id��״̬��hashmap
	public static HashMap<String, State> getStateIdHashMap(ArrayList<State> states) {
		HashMap<String, State> findStateByID = new HashMap<>();
		for (State state : states) {
			findStateByID.put(state.getPosition(), state);
		}
		return findStateByID;
	}

	// ��ȡ״̬����Ҫ��
	public static double[] getStatesImportantPoint(Automatic automatic) {
		ImpJudger ij = new ImpJudger(automatic);
		return ij.getStatesImportantPoints();
	}

	/**
	 * ���ݸ��� ��ȡ�������
	 * 
	 * @param rdm
	 * @return
	 */
	// ����Ĳ�����һ���洢���ʼ��ϵ�Ȼ��Ҳ����������
	public static Integer randomPoints(ArrayList<Double> rdm) {
		ArrayList<Double> cdm = rdm;
		// �����ǽ����ʼ������� ���� 0.2 0.3 0.1 0.4 �ĸ����ݵļ���
		for (int i = 1; i < cdm.size() - 1; i++) {
			cdm.set(i, cdm.get(i) + cdm.get(i - 1));
		}
		cdm.set(cdm.size() - 1, 1.0);
		// ����� ���0.2 0.5 0.6 1.0 �ĸ����ݵļ���
		double randomNumber;
		randomNumber = Math.random();
		// �������һ��0��1�������
		// ���¾ͺܼ�����ֻҪѭ�����鼯�� ��������С���Ǹ�ֵ ���Ƿ��� I �ͺ���
		for (int i = 0; i < cdm.size(); i++) {
			if (randomNumber < cdm.get(i)) {
				return i;
			}
		}
		return -1; // �������֮�²�Ӧ�õ���һ���ġ���Ϊcdf�����һ������Ӧ����1

	}
}
