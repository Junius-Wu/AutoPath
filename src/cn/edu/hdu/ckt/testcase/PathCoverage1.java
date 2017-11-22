package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.Stack;

import cn.edu.hdu.ckt.handle.*;


public class PathCoverage1 {

	public static void main(String[] args) {
		String xml="rc_loopForXStream1.01.xml";
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testcaseSet=testCase(auto);

	}
	
	/**
	 * �������������������������״̬����׼��Ĳ������м���
	 * @param a
	 * @return
	 */
	public static ArrayList<Automatic> testCase(Automatic aaa){
		ArrayList<State> StateList=new ArrayList<State>();//��ֹ״̬����
		ArrayList<State> StateList1=new ArrayList<State>();//��ֹ״̬����
		//������ֹ״̬����
		for(State state1:aaa.getStateSet()){
			int k1= 0;
			for(Transition tran:aaa.getTransitionSet()){//�ж�Ŀ��״̬�Ƿ��ѱ�����
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

		/*//������ֹ״̬����
		for(State state1:aaa.getStateSet()){
			int k1= 0;
			for(Transition tran:aaa.getTransitionSet()){//�ж�Ŀ��״̬�Ƿ��ѱ�����
				if(state1.getName().equals(tran.getSource())){//�ҳ��Դ�״̬Ϊ����Ǩ��
					k1=1;
				}
			}
			if(k1==0){
				StateList1.add(state1);
			}				
		}
		for(int ii=0;ii<StateList1.size();ii++){
			System.out.println("---��ֹ�ڵ�id��"+StateList1.get(ii).getId());
		}*/


		ArrayList<Transition> aaa_Transition=aaa.getTransitionSet();//���ʱ���Զ���Ǩ�Ƽ���
		ArrayList<State> aaa_StateSet=aaa.getStateSet();//���ʱ���Զ���״̬����

		ArrayList<State> visitedState=new ArrayList<State>();//�������ѷ��ʹ���״̬���ϣ�
		ArrayList<ArrayList<State>> S=new ArrayList<ArrayList<State>>();//�������м��ϣ�״̬��
		ArrayList<ArrayList<Transition>> T=new ArrayList<ArrayList<Transition>>();//�������м��ϣ��ߣ�

		Stack<State> sstack=new Stack<State>();//״̬ջ
		Stack<Transition> tstack=new Stack<Transition>();//Ǩ��ջ
		State intstate=aaa.getInitState();//���ʱ���Զ����ĳ�ʼ״̬
		sstack.push(intstate);//��ʼ״̬��ջ
		visitedState.add(intstate);//����ʾΪ�ѷ��ʹ�
		while(!sstack.isEmpty()){
			State X=sstack.peek();//���ջ��Ԫ�أ�������ջ

			int leaf=1;//��Ҷ�ӽڵ�
			for(Transition t:aaa_Transition){//�ж�X�Ƿ���Ҷ�ӽڵ�
				if(t.getSource().equals(X.getName())){
					leaf=0;
					break;
				}
			}
			if(leaf==0){//X����Ҷ�ӽڵ�
				int flag=0;//��־X���ڽӵ㶼�����ʹ�
				for(Transition tran:aaa_Transition){//�ж�Ŀ��״̬�Ƿ��ѱ�����
					if(X.getName().equals(tran.getSource())){//�ҵ�״̬���ӵ�����һ��Ǩ��
						int k=0;
						for(State state:visitedState){
							if(tran.getTarget().equals(state.getName())){
								k=1;
								break;
							}
						}
						if(k==0){//Ŀ��״̬û�б����ʹ���Ŀ��״̬����ջ��������StateSet����������Ǩ�Ƽ���TransitionSet
							flag=1;
							for(State s:aaa_StateSet){
								if(tran.getTarget().equals(s.getName())){//�ҵ�Ŀ��״̬
									sstack.push(s);//�����Ŀ��״̬����ջ
									/*State ss=new State();
									ss.setName(s.getName());
									ss.setPosition(s.getPosition());
									ss.setInvariantDBM(s.getInvariantDBM());*/
									visitedState.add(s);//�����Ŀ��״̬��־Ϊ�ѷ��ʹ�
									tstack.push(tran);//������Ǩ������ջ
									break;
								}
							}
						}
						if(flag==1){break;}//�������Ǩ�Ƶ�Ŀ��״̬û�б����ʹ�������������Ǩ�Ƶ�ѭ��
						if(k==1){//�������Ǩ�Ƶ�Ŀ��״̬�ѱ����ʹ����������һ��Ǩ��
							continue;
						}
					}
				}
				if(flag==0){//��־X���ڽӵ㶼�����ʹ������ջ
					sstack.pop();
					if(!tstack.isEmpty()){tstack.pop();}

				}
			}
			if(leaf==1){//X��Ҷ�ӽڵ�,���״̬ջ��״̬��Ǩ��ջ��Ǩ�ƣ�����һ���������У�����������м���
				ArrayList<State> StateSet=new ArrayList<State>();//һ�����������е�״̬
				for(State s:sstack){
					StateSet.add(s);
				}
				S.add(StateSet);
				/*for(State s:StateSet){
					System.out.println(s.getName());
				}
				System.out.println("-------");*/

				ArrayList<Transition> TransitionSet=new ArrayList<Transition>();//һ�����������еı�
				for(Transition t:tstack){
					TransitionSet.add(t);
				}
				T.add(TransitionSet);
				/*for(Transition t:TransitionSet){
					System.out.println(t.getSource()+"-->"+t.getTarget());
				}
				System.out.println("***********");*/

				sstack.pop();
				tstack.pop();
			}

		}


		//System.out.println(S.size());
		int n=S.size();//������������
		ArrayList<Automatic> testcaseSet=new ArrayList<Automatic>();//������������
		for(int i=0;i<n;i++){
			Automatic test_case=new Automatic();
			test_case.setClockSet(aaa.getClockSet());
			test_case.setName("��������"+(i+1));
			test_case.setStateSet(S.get(i));
			test_case.setTransitionSet(T.get(i));
			test_case.setInitState(aaa.getInitState());
			testcaseSet.add(test_case);
		}
		System.out.println("��������������"+testcaseSet.size());
		for(Automatic auto:testcaseSet){
			System.out.println(auto.getName());
			for(State s:auto.getStateSet()){
				System.out.println(s.getName());
				//System.out.println(s.getPosition());
			/*	for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						DBM_element cons=s.getInvariantDBM()[i][j];

						//System.out.println("DBM_i:"+cons.getDBM_i());
						//System.out.println("DBM_j:"+cons.getDBM_j());
						System.out.println("value:"+cons.getValue());
						System.out.println("Strictness:"+cons.isStrictness());									
					}
				}*/
				System.out.println("-------------");
			}
			for(Transition t:auto.getTransitionSet()){
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
	
	
	
	

}
