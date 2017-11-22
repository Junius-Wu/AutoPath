package cn.edu.hdu.ckt.testcase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.Minimization__1;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.StateCoverage__1;
import cn.edu.hdu.ckt.handle.Transition;

public class TestComparater {

	public static void main(String[] args) {
		/**
		 * 
		 */
		String xml="111.xml";//���Ե�xml
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic a=DFSTree(auto);
		//ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������
		
		
		
		/**
		 * ����sort
		 */
		/*List<String> list = new ArrayList<String>();
		list.add("i");
		list.add("_num_i");
		list.add("abc");
		System.out.println(list.get(0)+"---"+list.get(1)+"---"+list.get(2));
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				
				return str2.length()-str1.length();
			}
		});
		System.out.println(list.get(0)+"---"+list.get(1)+"---"+list.get(2));*/
		
		/**
		 * ����random
		 */
		/*int random = -1;
		if (random == -1) {
			random = new Random().nextInt(2);
		}
		System.out.println("random-->"+random);*/
		/**
		 * 
		 */
		/*List<String> result1=new ArrayList<String>();
		result1.add(null);
		System.out.println(result1.toString());
		if(result1.toString().equals("[null]")){
			System.out.println("0000");
		}else{
			System.out.println("1111");
		}
		System.out.println(result1.size());*/
		/**
		 * 
		 */
		/*String con = "i#i:int";
		String[] s = con.split("--");
		System.out.println(s.length);
		System.out.println(s[0]);*/
		//System.out.println(s[1]);

		/*String[] results = null;
		String solution1="{{i-> 34}, {i-> 168}, {i-> 0}}";
		results = solution1.substring(2, solution1.length() - 2).split("\\}, \\{");
		for(int i=0;i<results.length;i++){
			System.out.println("results22----"+results[i]);
		}		
		System.out.println("condition��������Լ����22Ϊ��"+solution1);*/
		/*String tra = "cycle=2.5ms--control_mode==0#control_mode:int8_t#0<=control_mode<=14--motor_state==False || ap.throttle_zero==True#motor_state:bool,ap.throttle_zero:bool";
		List<String> result2=new ArrayList<String>();
		result2 = Result.getResult(tra);
		for(int ii=0;ii<result2.size();ii++){
			System.out.println("condition���"+ii+"Ϊ:"+result2.get(ii));
		}*/
		
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("HH:mm:ss");
//		String time=format.format(date);
//		System.out.println(time);
//		
//		Date date1=new Date();
//		DateFormat format1=new SimpleDateFormat("HH:mm:ss");
//		String time1=format1.format(date1);
//		
//		DateFormat df = new SimpleDateFormat("HH:mm:ss");   
//		try  
//		{   System.out.println("time---"+time);
//		System.out.println("time1---"+time1);
//		    Date d1 = df.parse(time);   
//		    Date d2 = df.parse(time1);   
//		    long l = d2.getTime() - d1.getTime();   
//		    long day=l/(24*60*60*1000);   
//		    long hour=(l/(60*60*1000)-day*24);   
//		    long min=((l/(60*1000))-day*24*60-hour*60);   
//		    long s=(l/1000-day*24*60*60-hour*60*60-min*60); 
//		    System.out.println("����ʱ�䣺"+ ""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
//		    //System.out.println("����ʱ�䣺"+ l);
//		}   
//		catch (Exception e)   
//		{   
//		}
		
		//Mathematica.closes();
	}
	
	/**
	 *����ȥ������Ǩ�Ƶ�ͼ�����������������
	 * @param auto
	 * @return
	 */
	public static Automatic DFSTree(Automatic auto){
		ArrayList<Transition> auto_Transition=auto.getTransitionSet();//���ʱ���Զ���Ǩ�Ƽ���
		ArrayList<Transition> TransitionSet=new ArrayList<Transition>();//����Լ��������Ǩ�Ƽ���
		ArrayList<State> auto_StateSet=auto.getStateSet();//���ʱ���Զ���״̬����
		ArrayList<State> StateSet=new ArrayList<State>();//�������������״̬���ϣ������ѷ��ʹ���״̬���ϣ�
		
		Stack<State> sstack=new Stack<State>();//״̬ջ
		State intstate=auto.getInitState();//���ʱ���Զ����ĳ�ʼ״̬
		sstack.push(intstate);//��ʼ״̬��ջ
		StateSet.add(intstate);//����ʼ״̬������������״̬���ϣ�Ҳ��ʾΪ�ѷ��ʹ�
		System.out.println("ջ��"+sstack);
		System.out.println("��״̬���ϣ�"+StateSet);
		while(!sstack.isEmpty()){
			State X=sstack.peek();//���ջ��Ԫ�أ�������ջ
			System.out.println("��ʱ��ȡ��ջ��Ԫ�أ�״̬����"+X.getName());
			int flag=0;//��־X���ڽӵ㶼�����ʹ�
			for(Transition tran:auto_Transition){//�ж�Ŀ��״̬�Ƿ��ѱ�����
				if(X.getName().equals(tran.getSource())){//�ҳ��Դ�״̬Ϊ����Ǩ��
					int k=0;
					for(State state:StateSet){//�ж�Ǩ�Ƶ�Ŀ��״̬�Ƿ񱻷��ʹ�����k���
						if(tran.getTarget().equals(state.getName())){
							k=1;
							break;//for(State state:StateSet)
						}
					}//
					if(k==0){//Ŀ��״̬û�б����ʹ���Ŀ��״̬����ջ��������StateSet����������Ǩ�Ƽ���TransitionSet
						flag=1;
						for(State s:auto_StateSet){
							if(tran.getTarget().equals(s.getName())){
								sstack.push(s);//�����Ŀ��״̬����ջ
								/*State ss=new State();
								ss.setName(s.getName());
								ss.setPosition(s.getPosition());
								ss.setInvariantDBM(s.getInvariantDBM());*/
								StateSet.add(s);//�����Ŀ��״̬��־Ϊ�ѷ��ʹ�
								/*Transition t=new Transition();
								t.setSource(tran.getSource());
								t.setTarget(tran.getTarget());
								ArrayList<String> events=new ArrayList<String>();
								events.add(tran.getEventSet().get(0));
								events.add(tran.getEventSet().get(1));
								t.setEventSet(events);
								ArrayList<String> ResetClockSet=new ArrayList<String>();
								if(tran.getResetClockSet()!=null){
									for(String set:tran.getResetClockSet()){
										ResetClockSet.add(set);
									}
								}
								t.setResetClockSet(ResetClockSet);*/
								TransitionSet.add(tran);//������Ǩ�Ƽ���Ǩ�Ƽ���
								break;//for(State s:auto_StateSet)
							}
						}//
					}
					if(flag==1){break;}//�������Ǩ�Ƶ�Ŀ��״̬û�б����ʹ�������������Ǩ�Ƶ�ѭ��
					                   //for(Transition tran:auto_Transition)
					if(k==1){//�������Ǩ�Ƶ�Ŀ��״̬�ѱ����ʹ����������һ��Ǩ��
						continue;
					}
				}
			}//
			if(flag==0){sstack.pop();}//��־X���ڽӵ㶼�����ʹ������ջ
		}
		
	/*	System.out.println("������ "+TransitionSet.size());
		for(Transition t:TransitionSet){
			System.out.println(t.getSource());
			System.out.println(t.getTarget());
			System.out.println(t.getEventSet().get(0));
			System.out.println(t.getEventSet().get(1));
			System.out.println("-------------");
		}*/
		
		/*System.out.println("״̬���� "+StateSet.size());
		for(State s:StateSet){
			System.out.println(s.getName());
			System.out.println(s.getPosition());
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
		}*/
		
		Automatic aaa=new Automatic();
		aaa.setClockSet(auto.getClockSet());
		aaa.setName("aaa");
		aaa.setStateSet(StateSet);
		aaa.setTransitionSet(TransitionSet);
		for(State s:StateSet){
			if(s.getName().equals(auto.getInitState().getName())&&Minimization__1.includeZero(s.getInvariantDBM())==1){
				aaa.setInitState(s);//����ʱ���Զ����ĳ�ʼ״̬
			}
		}
		return aaa;
		
	}
}
