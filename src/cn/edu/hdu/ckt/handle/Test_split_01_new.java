package cn.edu.hdu.ckt.handle;

import java.util.ArrayList;


import cn.edu.hdu.wj.bean.UppaalLocation;
import cn.edu.hdu.wj.bean.UppaalTemPlate;
import cn.edu.hdu.wj.bean.UppaalTransition;
/**
 * 验证l0有没有被正确拆分
 * @author Seryna
 *
 */
public class Test_split_01_new {
	public static void main(String[] args) {
		ArrayList<State> newStates=newState();
		ArrayList<State> getPs=getPs();
		
	}
	
	/**
	 * 获得 一个时间自动机
	 * @return
	 */
	public static Automatic getAutomatic(){
		UppaalTemPlate template=new UppaalTemPlate();
		ArrayList<UppaalTransition> transitions=new ArrayList<UppaalTransition>();
		ArrayList<UppaalLocation> locations=new ArrayList<UppaalLocation>();
		UppaalLocation InitState=new UppaalLocation();
		String name="第一个时间自动机";
		ArrayList<String> Clocks=new ArrayList<String>();
		Clocks.add("x");
		Clocks.add("y");

		ArrayList<String> ar0 =new ArrayList<String>();
		ar0.add("x<2");
		ar0.add("x<=y");
		ar0.add("y<=x");
		ArrayList<String> ar1 =new ArrayList<String>();
		ar1.add("y<=2");
		
		UppaalLocation l0=new UppaalLocation();
		l0.setName("l0");
		l0.setInvariant(ar0);
		UppaalLocation l1=new UppaalLocation();
		l1.setName("l1");
		l1.setInvariant(ar1);
		UppaalLocation l2=new UppaalLocation();
		l2.setName("l2");
		UppaalLocation l3=new UppaalLocation();
		l3.setName("l3");
			
		locations.add(l0);
		locations.add(l1);
		locations.add(l2);
		locations.add(l3);
		
		UppaalTransition e0 =new UppaalTransition();
		e0.setSource(l0.getName());
		e0.setTarget(l1.getName());
		ArrayList<String> reset0 =new ArrayList<String>();
		reset0.add("y");
		e0.setResetClocks(reset0);
		ArrayList<String>constraint0 =new ArrayList<String>();
		constraint0.add("x>1");
		e0.setConstraint(constraint0);
		ArrayList<String> events0=new ArrayList<String>();
		events0.add("?a");
		e0.setEvents(events0);
		
		UppaalTransition e1=new UppaalTransition();
		e1.setSource(l1.getName());
		e1.setTarget(l3.getName());
		ArrayList<String> constraint1 =new ArrayList<>();
		constraint1.add("y>1");
		constraint1.add("x<=3");
		e1.setConstraint(constraint1);
		ArrayList<String> events1=new ArrayList<String>();
		events1.add("!c");
		e1.setEvents(events1);
		
		UppaalTransition e2 =new UppaalTransition();
		e2.setSource(l3.getName());
		e2.setTarget(l1.getName());
		ArrayList<String> constraint2 =new ArrayList<>();
		constraint2.add("y<2");
		e2.setConstraint(constraint2);
		ArrayList<String> events2=new ArrayList<String>();
		events2.add("?a");
		e2.setEvents(events2);
		
		UppaalTransition e3 =new UppaalTransition();
		e3.setSource(l1.getName());
		e3.setTarget(l2.getName());
		ArrayList<String> constraint3 =new ArrayList<>();
		constraint3.add("y<=2");
		constraint3.add("y>=2");
		e3.setConstraint(constraint3);
		ArrayList<String> events3=new ArrayList<String>();
		events3.add("!b");
		e3.setEvents(events3);
		
		UppaalTransition e4 =new UppaalTransition();
		e4.setSource(l2.getName());
		e4.setTarget(l3.getName());
		ArrayList<String> constraint4 =new ArrayList<>();
		constraint4.add("x<=3");
		e4.setConstraint(constraint4);
		ArrayList<String> events4=new ArrayList<String>();
		events4.add("!c");
		e4.setEvents(events4);
		
		
		transitions.add(e0);
		transitions.add(e1);
		transitions.add(e2);
		transitions.add(e3);
		transitions.add(e4);
		
		template.setTransitions(transitions);
		template.setLocations(locations);
		template.setClockSet(Clocks);
		template.setInitState(l0);
		template.setName(name);
		
		InitState=l0;
		template.setInitState(InitState);
		
		Automatic automatic=TemPlateToAutomatic.temPlateToAutomatic(template);
		
		ArrayList<State> StateSet=automatic.getStateSet();
		for(State s:StateSet){//设置添加了时钟复位后的时钟约束
			s.setAddClockRelationDBM(s.getInvariantDBM());
		}
		//初始状态中时钟复位后的约束也设置下
		automatic.getInitState().setAddClockRelationDBM(StateSet.get(0).getAddClockRelationDBM());
		return automatic;
	}
	
	
	
	/**
	 * 拆分l0，返回l0被拆分后的状态集
	 * @return
	 */
	public static ArrayList<State> newState(){
		Automatic automatic=getAutomatic();
		State Init_State=automatic.getInitState();
		ArrayList<State> StateSet=automatic.getStateSet();
		ArrayList<Transition> TransitionSet=automatic.getTransitionSet();
		ArrayList<String> ClockSet=automatic.getClockSet();
		
		ArrayList<State> newStates=SplitSuseSs_new1.splitSuseSs(Init_State, StateSet, TransitionSet, ClockSet);//l0被拆分成新的状态集合
		
		//System.out.println(newStates.size());
		/*for(State s:newStates){
			System.out.println("状态name: "+s.getName());
			System.out.println("状态position: "+s.getPosition());
			DBM_element[][] DBM=s.getInvariantDBM();
			DBM_element[][] add_clock_DBM=s.getAddClockRelationDBM();
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					DBM_element cons=add_clock_DBM[i][j];
					//System.out.println("DBM_i:"+cons.getDBM_i());
					//System.out.println("DBM_j:"+cons.getDBM_j());
					System.out.println("value:"+cons.getValue());
					System.out.println("Strictness:"+cons.isStrictness());									
				}
			}
			System.out.println("*******************************");
		}*/
		
		ArrayList<State> Ps=automatic.getStateSet();//查看拆分过后，状态集合有没有改变（不变式不应该改变，但后继们的时钟复位后的约束应该改变）
		//System.out.println(Ps.size());
		/*for(State s:Ps){
			System.out.println("name: "+s.getName());
			System.out.println("position: "+s.getPosition());
			DBM_element[][] state=s.getInvariantDBM();
			DBM_element[][] add_clock_state=s.getAddClockRelationDBM();
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					DBM_element cons=add_clock_state[i][j];
					//System.out.println("DBM_i:"+cons.getDBM_i());
					//System.out.println("DBM_j:"+cons.getDBM_j());
					System.out.println("value:"+cons.getValue());
					System.out.println("Strictness:"+cons.isStrictness());									
				}
			}
			System.out.println("*******************************");
		}*/
		
		return newStates;
	}
	
	/**
	 * 获得l0被拆分后，删除l0，加入新状态的状态集合
	 * @return
	 */
	public static ArrayList<State> getPs(){
		Automatic automatic=Test_split_01_new.getAutomatic();
		State Init_State=automatic.getInitState();
		ArrayList<State> StateSet=automatic.getStateSet();
		ArrayList<Transition> TransitionSet=automatic.getTransitionSet();
		ArrayList<String> ClockSet=automatic.getClockSet();
		
		ArrayList<State> newStates=SplitSuseSs_new1.splitSuseSs(Init_State, StateSet, TransitionSet, ClockSet);//l0被拆分成新的状态集合
		ArrayList<State> update_StateSet=automatic.getStateSet();//获得l0被拆分后，时间自动机中被更新的状态集合
		ArrayList<State> Ps=new ArrayList<State>();
		
		for(State s:update_StateSet){//复制update_StateSet，以防update_StateSet被改变
			State ss=new State();
			ss.setAddClockRelationDBM(s.getAddClockRelationDBM());
			ss.setInvariantDBM(s.getInvariantDBM());
			ss.setName(s.getName());
			ss.setPosition(s.getPosition());
			Ps.add(ss);
		}
		for(State s:newStates){//加入新状态
			State ss=new State();
			ss.setAddClockRelationDBM(s.getAddClockRelationDBM());
			ss.setInvariantDBM(s.getInvariantDBM());
			ss.setName(s.getName());
			ss.setPosition(s.getPosition());
			Ps.add(ss);
		}
		Ps.remove(0);//删除l0
		
		//System.out.println(Ps.size());
		/*for(State s:Ps){
			System.out.println("name: "+s.getName());
			System.out.println("position: "+s.getPosition());
			DBM_element[][] state=s.getInvariantDBM();
			DBM_element[][] add_clock_state=s.getAddClockRelationDBM();
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					DBM_element cons=state[i][j];
					//System.out.println("DBM_i:"+cons.getDBM_i());
					//System.out.println("DBM_j:"+cons.getDBM_j());
					System.out.println("value:"+cons.getValue());
					System.out.println("Strictness:"+cons.isStrictness());									
				}
			}
			System.out.println("*******************************");
		}*/
		
		return Ps;
	}
	
	
}
