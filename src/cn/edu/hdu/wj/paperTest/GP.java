package cn.edu.hdu.wj.paperTest;

import java.util.ArrayList;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.wj.util.DataHelper;

public class GP {

	
	
	// ̰��
	public static void dfsPath() {
		// �ҳ���ʼ�ڵ㵽��ֹ�ڵ��·��'
		int index = 0;
		
		for(Transition tran : Datas.initTransitions) {
			while(true) {
				if (Datas.tranCovered[index]) {
					index++;
					continue;
				}
				Transition thisTran = Datas.transitions.get(index);
				State source = Datas.findStateById.get(tran.getTarget());
				State target = Datas.findStateById.get(thisTran.getSource());
				if (target.getId() >= source.getId()) {
					index++;
					continue;
				}
				break;
				
			}// ֻ����û���ǵı�
			Transition targetTran = Datas.transitions.get(index);
			ArrayList<Transition> partPath = dfsPathFromTranToTran(tran, targetTran);
		}
	}
	
	private static ArrayList<Transition> dfsPathFromTranToTran(Transition tran, Transition targetTran) {
		return null;
	}


}
