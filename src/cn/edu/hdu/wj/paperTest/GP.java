package cn.edu.hdu.wj.paperTest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.wj.util.DataHelper;

public class GP {

	public static int countOFpath=0;
	
	// 贪心
	public static void dfsPath() {
		Path p = new Path();
		// 找出开始节点到终止节点的路径'
		int index = 0;
		
		for(Transition tran : Datas.initTransitions) {
			p.trans.add(tran);
			while(true) {
				if(noNeedDFS(tran,index)) {
					if (index == Datas.transitions.size()) {
						break;
					}
					index++;
					continue;
				}
							
				Transition targetTran = Datas.transitions.get(index);
				ArrayList<Transition> res = new ArrayList<>();
				ArrayList<Transition> partPath = dfsPathFromTranToTran(res, new int[Datas.transitions.size()] ,tran, targetTran);
				p.trans.addAll(partPath);
				for(Transition tranX : partPath) {//覆盖边
					Datas.coveredIds.add(tranX.getId());
					
				}
				updateCovered();
				tran = p.trans.get(p.trans.size() - 1);
				//System.out.println(index);
				if(index == Datas.tranCovered.length) break;
				
				
			}// 只接受没覆盖的边
			break; // 暂且只认为有一条初始边
		}
		
		System.out.println("wancheng" + countOFpath++);
	}
	private static void updateCovered() {
		for(int i = 0; i < Datas.transitions.size(); i++) {
			Transition tran = Datas.transitions.get(i);
			if (Datas.coveredIds.contains(tran.getId())) {
				Datas.setCovered(i);
			}
		}
	}
	private static boolean noNeedDFS(Transition tran, int index) {
		if (index == Datas.transitions.size()) {
			return true;
		}
		if (Datas.tranCovered[index]) {// 已经被覆盖
			return true;
		}
		
		Transition nextTran = Datas.transitions.get(index);
		State source = Datas.findStateById.get(tran.getTarget());
		State target = Datas.findStateById.get(nextTran.getSource());
		if (source.getId() >= target.getId()) {// a->source......target->b  如果source > target 说明不可达
			return true;
		}
		
		if (!Datas.arv[source.getId() - 1 ][target.getId() - 1]) {// 不可达
			return true;
		}
		
		return false;
	}
	// 判断partPath的最后一个状态是否是终态
	private static boolean lastIsFinal(ArrayList<Transition> partPath) {
		Transition lastTran = partPath.get(partPath.size() - 1);
		State lastState = Datas.findStateById.get( lastTran.getTarget() );
		return lastState.isFinalState();
	}

	private static ArrayList<Transition> dfsPathFromTranToTran(ArrayList<Transition> res, int[] visited, Transition sourceTran, Transition targetTran) {
		int sourceIndex = Collections.binarySearch(Datas.transitions, sourceTran);
		int targetIndex = Collections.binarySearch(Datas.transitions, targetTran);
		
		visited[sourceIndex] = 1;
		if (targetTran == sourceTran) {
			//res.add(targetTran);
			return res;
		}
		
		for(int i = sourceIndex + 1; i <= targetIndex; i++) {
			if (!isLinked(sourceTran, Datas.transitions.get(i))) {
				continue;
			}
			
			Transition nextTran = Datas.transitions.get(i);
			res.add(nextTran);
			if (dfsPathFromTranToTran(res ,visited, nextTran, targetTran) != null) {
				return res;
			}
			res.remove(nextTran);
		}

		
		return null;
	}
	private static boolean isLinked(Transition sourceTran, Transition transition) {
		
		return sourceTran.getTarget() .equals( transition.getSource()) ;
	}


}
