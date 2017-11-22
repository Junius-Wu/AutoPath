package cn.edu.hdu.wj.paperTest;

import java.util.ArrayList;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.wj.util.DataHelper;

public class GP {

	
	
	// 贪心
	public static void dfsPath() {
		// 找出开始节点到终止节点的路径'
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
				
			}// 只接受没覆盖的边
			Transition targetTran = Datas.transitions.get(index);
			ArrayList<Transition> partPath = dfsPathFromTranToTran(tran, targetTran);
		}
	}
	
	private static ArrayList<Transition> dfsPathFromTranToTran(Transition tran, Transition targetTran) {
		return null;
	}


}
