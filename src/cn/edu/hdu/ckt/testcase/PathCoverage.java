package cn.edu.hdu.ckt.testcase;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cn.edu.hdu.ckt.handle.*;


public class PathCoverage {
	
	private static ArrayList<Transition> Transitions;//����������һ��·�ϵ�Ǩ�Ƽ���		
	private static ArrayList<State> States;//����������һ��·�ϵ�״̬���ϣ������ѷ��ʹ���״̬���ϣ�
	private static List<ArrayList<Transition>> TransitionSet;//�������м��ϣ��ߣ�
	private static List<ArrayList<State>> StateSet;//�������м��ϣ�״̬��

	public static void main(String[] args) {
		String xml="rc_loopForXStream1.01.xml";
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testcaseSet=testCase(auto);
		System.out.println();       
	}
	
	/**
	 * �������������������·������׼��Ĳ������м���
	 * @param a
	 * @return
	 */
	public static ArrayList<Automatic> testCase(Automatic auto){
		ArrayList<Transition> auto_Transition=auto.getTransitionSet();//���ʱ���Զ���Ǩ�Ƽ���
		ArrayList<State> auto_StateSet=auto.getStateSet();//���ʱ���Զ���״̬����
		ArrayList<State> StateList=new ArrayList<State>();//��ֹ״̬����
		Transitions=new ArrayList<Transition>();//����������һ��·�ϵ�Ǩ�Ƽ���
		States=new ArrayList<State>();//����������һ��·�ϵ�״̬���ϣ������ѷ��ʹ���״̬���ϣ�
		TransitionSet=new ArrayList<ArrayList<Transition>>();//�������м��ϣ��ߣ�
		StateSet=new ArrayList<ArrayList<State>>();//�������м��ϣ�״̬��
		
		//������ֹ״̬����
		for(State state1:auto_StateSet){
			int k1= 0;
			for(Transition tran:auto_Transition){//�ж�Ŀ��״̬�Ƿ��ѱ�����
				if(state1.getName().equals(tran.getSource())){//�ҳ��Դ�״̬Ϊ����Ǩ��
					k1=1;
				}
			}
			if(k1==0){
				StateList.add(state1);
			}				
		}
		for(int ii=0;ii<StateList.size();ii++){
			System.out.println("��ֹ�ڵ�id��"+StateList.get(ii).getId());
		}
		//��ȡʱ���Զ�����ʼ״̬
		State intstate = auto.getInitState();
		//����dfs���Ѽ����Զ���·����״̬��Ǩ�Ƶ���Ϣ
		dfs(auto,intstate,StateList,auto_Transition,auto_StateSet);
		//��ȡ����·���ĸ���
		int n=StateSet.size();//����·��������������
		ArrayList<Automatic> testcaseSet=new ArrayList<Automatic>();//������������
		for(int i=0;i<n;i++){
			Automatic test_case=new Automatic();
			test_case.setClockSet(auto.getClockSet());
			test_case.setName("����·��"+(i+1));
			test_case.setStateSet(StateSet.get(i));
			test_case.setTransitionSet(TransitionSet.get(i));
			test_case.setInitState(auto.getInitState());
			testcaseSet.add(test_case);
		}
		System.out.println("����·��������"+testcaseSet.size());
		for(Automatic a:testcaseSet){
			System.out.println(a.getName());
			for(State s:a.getStateSet()){
				System.out.println(s.getName());
				//System.out.println(s.getPosition());
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						DBM_element cons=s.getInvariantDBM()[i][j];
						
						//System.out.println("DBM_i:"+cons.getDBM_i());
						//System.out.println("DBM_j:"+cons.getDBM_j());
						System.out.println("value:"+cons.getValue());
						System.out.println("Strictness:"+cons.isStrictness());									
					}
				}
				System.out.println("-------------");
			}
			for(Transition t:a.getTransitionSet()){
				System.out.println(t.getSource()+"-->"+t.getTarget());			
				System.out.println(t.getEventSet().get(0));
				System.out.println(t.getEventSet().get(1));
				if(t.getResetClockSet().size()!=0){
					System.out.println(t.getResetClockSet().get(0));
				}
				System.out.println("-------------");
			}
		}
		
		return testcaseSet;
	}

	
	
	/**
	 * ��������õ�·��
	 * 
	 */	
	public static int i = 1;
	public static void dfs(Automatic auto,State intstate,ArrayList<State> StateList,ArrayList<Transition> auto_Transition,ArrayList<State> auto_StateSet){				
		States.add(intstate);
		State aa = intstate;
		//System.out.println("���ʽڵ㣺"+i+"--"+intstate.getId()+"--"+intstate.getName());
		i++;
		for(Transition tran:auto_Transition){//�ж�Ŀ��״̬�Ƿ��ѱ�����
			if(intstate.getName().equals(tran.getSource())){//�ҳ��Դ�״̬Ϊ����Ǩ��
				Transitions.add(tran);	
				System.out.println("����Ǩ�ƣ�"+tran.getId()+"--"+tran.getName());
				for(State s:auto_StateSet){//�ҵ����Ǩ�Ƶ�Ŀ��״̬����intstate�������״̬
					if(s.getName().equals(tran.getTarget())){
						aa = s; 
						//System.out.println(s.getId());
					}					
				}				
			}
			//States.add(intstate);
			for(int ii=0;ii<StateList.size();ii++){
				if(StateList.get(ii).getId()==aa.getId()){
					States.add(aa);
					TransitionSet.add(Transitions);
					StateSet.add(States);
					/*for(int i=0;i<Transitions.size();i++){
						System.out.println(Transitions.get(i).getId()+"--"+Transitions.get(i).getName());
					}
					for(int i=0;i<States.size();i++){
						System.out.println(States.get(i).getId()+"--"+States.get(i).getName());
					}*/
				}else{
					dfs(auto,aa,StateList,auto_Transition,auto_StateSet);
					System.out.println("��һ��--"+aa.getId()+aa.getName());
				}
			}
			
			Transitions.remove(Transitions.size() - 1);
			States.remove(States.size() - 1);
			if(Transitions.size()<=0){
				return;
			}
		}
				
	}

	
}


