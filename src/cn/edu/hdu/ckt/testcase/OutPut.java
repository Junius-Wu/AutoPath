package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.hdu.ckt.handle.ATDTR__1;
import cn.edu.hdu.ckt.handle.AddType;
import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.DBM_element;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.Get_inequality__1;
import cn.edu.hdu.ckt.handle.IPR__1;
import cn.edu.hdu.ckt.handle.State;
import cn.edu.hdu.ckt.handle.StateCoverage__1;
import cn.edu.hdu.ckt.handle.Transition;
import cn.edu.hdu.ckt.handle.*;

public class OutPut {
	public static void main(String[] args) {
		//String xml="loop10ForXStream.xml";//��ʱ��Լ��
		//String xml="loopForXStream3.1.5.xml";//��ʱ��Լ��
		//String xml="loopForXStream3.1.5.2.x.xml";//��ʱ��Լ��
		//String xml="loopForXStream.3.1.5.2.y.xml";//��ʱ��Լ��
		//String xml="loopForXStream3.13.xml";//��ʱ��Լ��
		//String xml="loopForXStream3.1.5.2.z.xml";//��ʱ��Լ��
		//String xml="UAVForXStream3.1.5.3.xml";//��ʱ��Լ��
		String xml="UAVForXStream3.1.6.xml";//��ʱ��Լ��
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		if((auto.getClockSet().toString().equals("[]"))){
			System.out.println();
			System.out.println("��ʱ���Զ�����ʱ��Լ��");
			//System.out.println("ʱ���Զ���ʱ�Ӽ��ϣ�null");
			//output1(xml);//��һ�� ��ȡxml�������Ӧ���ݽṹ��
			//output11(xml);//�ڶ���   ����״̬���ǵĲ������У������Ӧ���ݽṹ��
			//output111(xml);//������   �������ɳ����������
			output1111(xml);//���Ĳ� �����������ʵ����
		}else{
			System.out.println();
			System.out.println("��ʱ���Զ�����ʱ��Լ��");
			System.out.print("ʱ���Զ���ʱ�Ӽ��ϣ�");
			for(String c:auto.getClockSet()){
				System.out.print(" "+c+"  ");
			}
			System.out.println();
			//output2(xml);
			//output22(xml);
			//output111(xml);
			
			
			//output1(xml);//��һ�� ��ȡxml�������Ӧ���ݽṹ��
			//output11(xml);//�ڶ���   ����״̬���ǵĲ������У������Ӧ���ݽṹ��
			//output111(xml);//������   �������ɳ����������
			output1111(xml);//���Ĳ� �����������ʵ����
		}
		//output1(xml);
	}


	/**
	 * ��ʱ��Լ���������ʽ                     ��һ��                ��ȡxml�������Ӧ���ݽṹ��
	 * @param xml
	 */
	public static  void output1(String xml){
		Automatic automatic1=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto=AddType.addType(automatic1);
		//	ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������		



		//########################################        ��һ��             ###############################################
		//#########################################################################################################
		//======================================================================��ȡxml�������Ӧ���ݽṹ��		
		//======================================================================���ڽ���xml�ĵ�
		
		System.out.println("=============================��ȡxml�ĵ���Ϣ=============================");
		//System.out.println();
		System.out.println("----------------------���ڶ�ȡ��õ�xml�ĵ���Ϣ----------------------");
	
		System.out.println("===>  ʱ���Զ���������Ϣ");
		System.out.println("ʱ���Զ������֣�"+auto.getName());	
		System.out.print("ʱ���Զ���ʱ�Ӽ��ϣ�");
		if((auto.getClockSet().toString().equals("[]"))){
			System.out.println("null");
		}
		else{
			for(String c:auto.getClockSet()){
				System.out.print(" "+c+"  ");
			}
		}
		System.out.println("ģ������״̬������"+auto.getStateSet().size());
		System.out.println("ģ������Ǩ�Ƹ�����"+auto.getTransitionSet().size());
		System.out.println();
		//=========================================================================xml������Ϣ����


		//=========================================================================��ȡģ�ͳ�ʼ״̬��Ϣ
		System.out.println("-------------------------��ȡ��ʼ״̬��Ϣ-------------------------");
		
		State iniState=auto.getInitState();
		System.out.println("===>  ��ʼ״̬��Ϣ");
		System.out.println("��ʼ״̬���֣�"+iniState.getName());
		System.out.println("״̬λ�ã�"+iniState.getPosition());
		System.out.println("�Ƿ�Ϊ��ֹ״̬ ��"+iniState.isFinalState());
		System.out.println("Type����(�Ƿ�Ϊ��ʼ)��"+iniState.getType());
		DBM_element[][] DBM=iniState.getInvariantDBM();
		if(auto.getClockSet().size()>0){
			for(int i=0;i<auto.getClockSet().size()+1;i++){
				for(int j=0;j<auto.getClockSet().size()+1;j++){
					DBM_element cons=DBM[i][j];
					//System.out.println("DBM_i��"+cons.getDBM_i());
					//System.out.println("DBM_j��"+cons.getDBM_j());
					//System.out.println("value��"+cons.getValue());
					//System.out.println("Strictness��"+cons.isStrictness());					
				}
			}
		}		
		System.out.println();
		//============================================================================ģ�ͳ�ʼ״̬��Ϣ��ȡ����


		//============================================================================��ȡģ��״̬�ľ�����Ϣ
		System.out.println("-------------------------��ȡ����״̬��Ϣ-------------------------");
		System.out.println("===>  ״̬�ܸ�����"+auto.getStateSet().size());
		System.out.println();
		int k=0;
		for(State state:auto.getStateSet()){
			System.out.println("��"+k+"��״̬");
			k++;
			DBM_element[][] dbm=state.getInvariantDBM();
			if(auto.getClockSet().size()>0){
				for(int i=0;i<auto.getClockSet().size()+1;i++){
					for(int j=0;j<auto.getClockSet().size()+1;j++){
						DBM_element cons=dbm[i][j];
						//System.out.println("DBM_i��"+cons.getDBM_i());
						//System.out.println("DBM_j��"+cons.getDBM_j());
						//System.out.println("value��"+cons.getValue());
						//System.out.println("Strictness��"+cons.isStrictness());					
					}
				}
			}			
			System.out.println("״̬���ƣ�"+state.getName());
			System.out.println("״̬λ�ã�"+state.getPosition());
			System.out.println("�Ƿ�Ϊ��ֹ״̬��"+state.isFinalState());
			System.out.println("Type����(�Ƿ�Ϊ��ʼ)��"+state.getType());
			DBM_element[][] adddbm=state.getAddClockRelationDBM();
			if(auto.getClockSet().size()>0){
				for(int i=0;i<auto.getClockSet().size()+1;i++){
					for(int j=0;j<auto.getClockSet().size()+1;j++){
						DBM_element cons=adddbm[i][j];
						//System.out.println("DBM_i��"+cons.getDBM_i());
						//System.out.println("DBM_j��"+cons.getDBM_j());
						//System.out.println("value��"+cons.getValue());
						//System.out.println("Strictness��"+cons.isStrictness());					
					}
				}
			}			
			//System.out.println("--------------------------");
			System.out.println();
		}
		System.out.println();		
		//=========================================================================ģ�;���״̬��Ϣ��ȡ����




		//=========================================================================��ȡģ��Ǩ��(����)��Ϣ
		System.out.println("-------------------------��ȡ����Ǩ��(����)��Ϣ-------------------------");
		
		System.out.println("===>  Ǩ���ܸ�����"+auto.getTransitionSet().size());
		int p=0;
		for(Transition tran:auto.getTransitionSet()){
			System.out.println("��"+p+"��Ǩ��(����)");
			System.out.println("Ǩ��(����)���ƣ�"+tran.getName().replace("(", "").replace(")", "").replace("!", "").replace("?", ""));
			System.out.println("Ǩ��Id��"+tran.getId());
			p++;
			if(tran.getConstraintDBM()!=null){
				DBM_element[][] dbm=tran.getConstraintDBM();
				if(auto.getClockSet().size()>0){
					for(int i=0;i<auto.getClockSet().size()+1;i++){
						for(int j=0;j<auto.getClockSet().size()+1;j++){
							DBM_element cons=dbm[i][j];
							//System.out.println("DBM_i��"+cons.getDBM_i());
							//System.out.println("DBM_j��"+cons.getDBM_j());
							//System.out.println("value��"+cons.getValue());
							//System.out.println("Strictness��"+cons.isStrictness());					
						}
					}
				}				
			}
			else System.out.println("ʱ��Լ��Ϊ��");			
//			System.out.println("      ===>  Դ״̬���ƣ�"+tran.getSource());
//			System.out.println("      ===>  Ŀ��״̬���ƣ�"+tran.getTarget());						
			if(tran.getEventSet()==null){
				System.out.println("�¼�Ϊ��");
			}
			else if(tran.getEventSet().size()==0){
				System.out.println("�¼�Ϊ���գ�����û������");
			}
			else{				
				String in=tran.getIn();		
				String con=tran.getCondition();
				String out=tran.getOut();
				System.out.print("in(Լ������)��");
				if("".equals(in.toString())){
					System.out.println("null");
				}
				else{
					System.out.println(in.toString());
				}
				System.out.println("condition(Լ������)��"+con);
				System.out.println("out(�����Ϣ)��"+out.toString());	
				////////////////out.toString()Ϊ��ʱ�����
				/*if("".equals(out.toString())){
					System.out.println("null");
				}
				else{
					System.out.println(out.toString());
				}*/
				//ArrayList<String> events=tran.getEventSet();
				//				for(String e��events){
				//					System.out.println("      ===>  �¼���"+e);
				//				}								
			}			
			if(tran.getResetClockSet()==null){
				System.out.println("����ʱ�ӣ�null");
			}
			else if(tran.getResetClockSet().size()==0){
				System.out.println("����ʱ�ӣ����գ�����û������");
			}
			else{
				ArrayList<String> reset=tran.getResetClockSet();
				for(String r:reset){
					System.out.println("���õ�ʱ�ӣ�"+r);
				}
			}

			if(tran.getTypeIds()==null){
				//System.out.println("      ===>  typeID��null");
			}
			else if(tran.getTypeIds().size()==0){
				//System.out.println("      ===>  typeID�����գ�����û������");
			}
			else{
				ArrayList<String> typeid=tran.getTypeIds();
				for(String i:typeid){
					//System.out.println("      ===>  typeId��"+i);
				}
			}

			if(tran.getTypes()==null){
				//System.out.println("      ===>  types��null");
			}
			else if(tran.getTypes().size()==0){
				//System.out.println("      ===>  types�����գ�����û������");
			}
			else{
				ArrayList<String> type=tran.getTypes();
				for(String t:type){
					//System.out.println("      ===>  types��"+t);
				}
			}

			//System.out.println("--------------------------");
			System.out.println();
		}
		System.out.println();
		//=====================================================================ģ��Ǩ��(����)��Ϣ��ȡ����	
		//=====================================================================��ȡxml����	




	}


	/**
	 * ��ʱ��Լ���������ʽ                       �ڶ���            ����״̬���ǵĲ������У������Ӧ���ݽṹ��
	 * @param xml
	 */
	public static  void output11(String xml){
		Automatic automatic1=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto=AddType.addType(automatic1);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������		

		//########################################        �ڶ���             ###############################################
		//#########################################################################################################
		//=====================================================================��ȡ�����������
		//======================================================================����״̬���ǵĲ������У������Ӧ���ݽṹ��
		System.out.println("===========================��ȡ����״̬���ǵĲ���������Ϣ===========================");
		System.out.println("-------------------------���ڱ���ʱ���Զ���-------------------------");
		System.out.println();
		System.out.println("-------------------------���������������������-------------------------");
		System.out.println();
		System.out.println("-------------------------���ڱ����������������-------------------------");
		System.out.println();
		System.out.println("-------------------------������������״̬���ǵĳ����������-------------------------");
		System.out.println();
		System.out.println("-------------------------��ȡ�������������ϸ��Ϣ-------------------------");		
		System.out.println();
		System.out.println("===>  ����������и�����"+testCase.size());
		System.out.println();
		for(Automatic a:testCase){	
			System.out.println("---------------");
			System.out.println("--->  �����������֣�"+a.getName());
			for(Transition tran:a.getTransitionSet()){	
				System.out.println("Ǩ��(����)���ƣ�"+tran.getName().replace("(", "").replace(")", "").replace("!", "").replace("?", ""));
				System.out.println("Ǩ��Id��"+tran.getId());								
				System.out.println("Դ״̬���ƣ�"+tran.getSource());
				System.out.println("Ŀ��״̬���ƣ�"+tran.getTarget());	
				//δ�����Լ������	
				//				System.out.println("        ===>  Լ����"+tran.getEventSet());
				//���in�����Լ��
				System.out.println("in(Լ������)��"+tran.getIn());
				/*if(tran.getIn().equals("")){
					System.out.println("null");
				}else{
					System.out.println(tran.getIn());
				}	*/				
				//���out�����Լ��
				System.out.print("out(�����Ϣ)��");
				if(tran.getOut().equals("")){
					System.out.println("null");
				}else{
					System.out.println(tran.getOut());
				}
				//���condition�����Լ��
				//System.out.println("        ===>  get-condition��"+tran.getCondition());
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����
						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
						System.out.println("condition(Լ������)��"+conditonValue);
					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("condition(Լ������)��"+tran.getCondition());
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						System.out.println("condition(Լ������)��null"+tran.getCondition());	
					}
				}
				System.out.println();
			}
			//System.out.println();
			//System.out.println("---------------------------------------------------------");

		}
		//=====================================================================��ȡ����������н���
	}

	/**
	 * ��ʱ��Լ���������ʽ                       ������           �������ɳ����������
	 * @param xml
	 */
	public static  void output111(String xml){
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������



		//########################################        ������             ###############################################
		//#########################################################################################################
		//=====================================================================��ȡ����״̬���ǵĳ����������
		//======================================================================����Ǩ�ƣ��������ϵ�Լ�������ɳ����������
		System.out.println("===========================��������״̬���ǵĲ�������===========================");
		System.out.println("----------------------------��ȡ����������Ϣ----------------------------");
		System.out.println();
		System.out.println("===>  ����������и�����"+testCase.size());

		int i = 1;
		String ttt=null;
		String ttt1=null;
		String ttt2=null;
		String ttt3=null;

		for(Automatic a:testCase){	///////////////////////////////////
			//List<String> list=new ArrayList<String>();//�����������ʽ
			//List<String> list1=new ArrayList<String>();//���С������ʽ
			//List<String> list2=new ArrayList<String>();//���С��=0�Ĳ���ʽ
			int j=1;
			//System.out.println();
			System.out.println("------------��"+i+"����������------------");
			System.out.println("--->  ������������:"+a.getName());
			for(Transition tran:a.getTransitionSet()){/////////////////////
				//System.out.println();
				//System.out.println("Ǩ��(����)����--->"+tran.getName());
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					String sss=tran.getName().substring(0,index11);
					System.out.println("Ǩ��(����)���ƣ�"+sss);
				}
				else{
					System.out.println("Ǩ��(����)���ƣ�"+tran.getName().replace("!", "").replace("?", ""));
				}

				System.out.println("Ǩ��Id��"+tran.getId());								
				System.out.println("Դ״̬���ƣ�"+tran.getSource());
				System.out.println("Ŀ��״̬���ƣ�"+tran.getTarget());
				//System.out.println("             ======��"+j+"��Ǩ�ƿ�ʼ======");
				//				System.out.println("--------->��������--------> "+tran.getName());
				//System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());
				//δ�����Լ������	
				//				System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				/////////////////////////////////////////////////////////////////
				Map<String,String> map = new HashMap<String,String>();
				Map<String,String> map1 = new HashMap<String,String>();
				Map<String,String> map3 = new HashMap<String,String>();
				Map<String,String> map4 = new HashMap<String,String>();//////
				///////////////////////////////////////////////in����ʼ///////////////////////////////////////

				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
				//System.out.println("========================in========================");	
				//System.out.println("          in---->"+tran.getIn());	//in���������			
				if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
					//System.out.println("keySet���ϣ�"+tran.getIn());
				}
				else{//map����ֵ�����в����Ͳ�����Ӧ����
					map3 = GetMap.get_inMap(tran.getIn());
					String cs1 = AddBdsType.getcs(map3);
					String cs2 = AddBdsType.getDoubleCs(map3);
					String cs3 = AddBdsType.getBoolCs(map3);
					//					System.out.println("-----------");
					String s1 = AddBdsType.add_bds(map3);			
					String s2 = AddBdsType.add_doublebds(map3);		
					String bds2=null;
					String bds00=null;
					
					List<String> list=new ArrayList<String>();//�����������ʽ
					List<String> list1=new ArrayList<String>();//���С������ʽ
					List<String> list2=new ArrayList<String>();//���С��=0�Ĳ���ʽ
					
					//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
					//String bds0=GetBds.get_bds_0(tran.getIn().toString());

					//�����Ͳ���ʽ�Ͳ���
					String bds1=GetBds.get_bds(tran.getIn().toString());



					/////////////////////////////////////
					if(cs2!=null){  //cs2��С��------>����
						if(bds1!=null){
							if(bds1.contains(",")){
								String[] xbds = bds1.split(",");
								if(cs2.contains(",")){//�������ʽ�������
									String[] xcs = cs2.split(",");
									for(String x1:xbds){
										int m=0;
										for(String x2:xcs){													
											if(x1.contains(x2)){
												//list1.add(x1);
												m=1;
											}
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(x1.contains("==0"))){
											list1.add(x1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(x1.contains("==0"))){
												list2.add(x1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(x1);//list��������������ʽ
											}
										}

									}//for(String x1:xbds) 
								}//if(cs2.contains(","))
								else{
									//!cs2.contains(",")
									////�������ʽһ������
									for(String x1:xbds){
										int m=0;
										if(x1.contains(cs2)){
											m=1;
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(x1.contains("==0"))){
											list1.add(x1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(x1.contains("==0"))){
												list2.add(x1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(x1);//list�����ų���==0����������ʽ
											}
										}
									}												
								}

							}//if(bds1.contains(","))
							else{
								if(!bds1.contains(",")){
									if(cs2.contains(",")){//һ������ʽ�������
										String[] xcs = cs2.split(",");
										int m=0;
										for(String x2:xcs){													
											if(bds1.contains(x2)){
												//list1.add(x1);
												m=1;
											}
										}
										////�ж��ǲ���С��������������ʽ
										if(m==1&&!(bds1.contains("==0"))){
											list1.add(bds1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(bds1.contains("==0"))){
												list2.add(bds1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(bds1);//list�����ų���==0����������ʽ
											}
										}
									}//if(cs2.contains(","))
									else{
										//!cs2.contains(",")
										//һ������ʽһ������
										int m=0;
										if(bds1.contains(cs2)){
											m=1;
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(bds1.contains("==0"))){
											list1.add(bds1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(bds1.contains("==0"))){
												list2.add(bds1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(bds1);//list�����ų���==0����������ʽ
											}
										}
									}
								}
							}
							
							//��������ʽ
							String cs = null;
							if(list.size()>1){
								cs=list.get(0);
								for(int mm=1;mm<list.size();mm++){
									String c1=list.get(mm);
									cs=cs+","+c1;
								}
							}
							if(list.size()==1){
								cs=list.get(0);
							}	
							bds1=cs;
							//	System.out.println("��������ʽΪ----->"+cs);
							
							//=0��С������ʽ
							String css = null;
							if(list1.size()>1){
								css=list1.get(0);
								for(int mm=1;mm<list1.size();mm++){
									String c1=list1.get(mm);
									css=css+","+c1;
								}
							}
							if(list1.size()==1){
								css=list1.get(0);
							}
							bds2=css;							
							//	System.out.println("С������ʽΪ----->"+css);
							
							//=0��С������ʽ
							String csss = null;
							if(list2.size()>1){
								csss=list2.get(0);
								for(int mm=1;mm<list2.size();mm++){
									String c1=list2.get(mm);
									csss=csss+","+c1;
								}
							}
							if(list2.size()==1){
								csss=list2.get(0);
							}	
							bds00=csss.replace("==", "=");
						}//if(bds1!=null)
						else{
							if(bds1==null){
								//System.out.println("��������ʽΪ----->"+null);
								//System.out.println("С������ʽΪ----->"+null);
							}										
						}												
					}//if(cs2!=null)
					else{
						//û��С������
						//System.out.println("��������ʽΪ----->"+bds1);
						//System.out.println("С������ʽΪ----->"+null);

					}


					//////////////////////



					//////////////////////
					//System.out.println("����------>����ʽ������"+bds1);  //in�����ֲ���ʽ
					//System.out.println("==0------>����ʽ������"+bds0);
					//					System.out.println("����------>����������"+cs1);
					//System.out.println("С��------>����ʽ������"+bds2);
					//					System.out.println("С��------>����������"+cs2);
					//System.out.println("add------>��������ʽΪ��"+s1);
					//System.out.println("add------>С������ʽΪ��"+s2);

					//�����Ͳ���ʽ�Ͳ���
					String boolbds=GetBds.get_boolbds(tran.getIn().toString());
					if(cs3!=null&&boolbds==null){
						boolbds = AddBdsType.add_boolbds(cs3);
					}
					//System.out.println("������------>����ʽ������"+boolbds);//in�ϲ�������ʽ
					//System.out.println("������------>����������"+cs3);


					//System.out.println("in�ϲ���ʽ��");

					////////////////////////////////////
					//����mma�����ⷽ����
					if(((bds1==null)&&(cs1==null))&&(s2==null)){
						//						System.out.println("        ===>  in��û��Լ����Ϊ��null");
					}
					if((bds1!=null)&&(cs1!=null)){
						String bbb = bds1+","+s1;
						//						System.out.println("        ===>  in����������ֵ����ʽ��"+bbb);
						//System.out.println("        ===>  in����������ֵ������"+cs1);
						//String solution1 = Mathematica.getSolution2(bbb, cs1);
						ttt=bbb.toString();
						//	System.out.println("in������Լ����Ϊ��"+solution1);
					}
					else{
						if(s1!=null){
							//							System.out.println("        ===>  in����������ֵ����ʽ��"+s1);
							//System.out.println("in����������ֵ������"+cs1);
							//String solution1 = Mathematica.getSolution2(s1, cs1);
							ttt=s1.toString();
							//System.out.println("in��������Լ����Ϊ��"+solution1);
						}
					}
					if((s2!=null)){
						//						System.out.println("        ===>  in��С������ֵ����ʽ��"+s2);
						//System.out.println("in��С������ֵ������"+cs2);
						//						String solution2 = Mathematica.getSolution4(s2, cs2);
						ttt1=s2.toString();
						//						System.out.println("in��С����Լ����Ϊ��"+solution2);
					}	
					if(boolbds!=null){
						//System.out.println("        ===>  in�ϲ����͵Ĳ���ʽ��"+boolbds);
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1+","+boolbds;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt+","+boolbds;;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1+","+boolbds;
						}
					}
					else{
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1;
						}
					}
					if(ttt2!=null&&bds00!=null){
						ttt2 = ttt2+","+bds00;
					}else{
						if(ttt2==null&&bds00!=null){
							ttt2 = bds00;
						}
					}




					//////////////////


				}
				//			System.out.println("===========================in�������===========================");

				//////////////////////////////////////////////in�������//////////////////////////////////////
				//////////////////////////////////////////////out����ʼ///////////////////////////////////////

				//			System.out.println("out---->"+tran.getOut());



				//////////////////////////////////////////////out�������///////////////////////////////////////
				/////////////////////////////////////////////condition����ʼ///////////////////////////////////////
				//				System.out.println("--------------------------condition------------------------");
				//Map<String,String> map = new HashMap<String,String>();
				//Map<String,String> map1 = new HashMap<String,String>();
				if(!tran.getCondition().equals("null")){
					List<String> list=new ArrayList<String>();//�����������ʽ
					List<String> list1=new ArrayList<String>();//���С������ʽ
					List<String> list2=new ArrayList<String>();//���С��=0�Ĳ���ʽ
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����

						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
						//						System.out.println("          condition/---->"+conditonValue);
						//System.out.println("==================================");
						if(GetMap.get_condMap(conditonValue)==null){          //û��Լ������ʽ
							//							System.out.println("keySet����1��"+GetMap.get_condMap(conditonValue));
						}
						else{                                                 //��Լ������ʽ
							if(!(GetMap.get_condMap(conditonValue)==null)){
								map = GetMap.get_condMap(conditonValue);//�����У�Ҫ���������

								String cs1 = AddBdsType.getcs(map);
								String cs2 = AddBdsType.getDoubleCs(map);
								String cs3 = AddBdsType.getBoolCs(map);
								//								System.out.println("-----------");								
								String s1 = AddBdsType.add_bds(map);
								String s2 = AddBdsType.add_doublebds(map);	
								String bds2=null;
								String bds00=null;

								
								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//(==0�Ľ�)
								//								String bds0=GetBds.get_bds_0(conditonValue.toString());

								//�����Ͳ���ʽ�Ͳ���
								String bds1=GetBds.get_bds(conditonValue.toString());	



								///////////////////////////////////
								if(cs2!=null){  //cs2��С��------>����
									if(bds1!=null){
										if(bds1.contains(",")){
											String[] xbds = bds1.split(",");
											if(cs2.contains(",")){//�������ʽ�������
												String[] xcs = cs2.split(",");
												for(String x1:xbds){
													int m=0;
													for(String x2:xcs){													
														if(x1.contains(x2)){
															//list1.add(x1);
															m=1;
														}
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(x1.contains("==0"))){
														list1.add(x1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(x1.contains("==0"))){
															list2.add(x1);//list2������==0��С������ʽ
														}
														if(m==0){
															list.add(x1);//list��������������ʽ
														}
													}

												}//for(String x1:xbds) 
											}//if(cs2.contains(","))
											else{
												//!cs2.contains(",")
												////�������ʽһ������
												for(String x1:xbds){
													int m=0;
													if(x1.contains(cs2)){
														m=1;
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(x1.contains("==0"))){
														list1.add(x1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(x1.contains("==0"))){
															list2.add(x1);//list2������==0��С������ʽ
														}
														if(m==0){
															list.add(x1);//list�����ų���������ʽ
														}
													}
												}												
											}

										}//if(bds1.contains(","))
										else{
											if(!bds1.contains(",")){
												if(cs2.contains(",")){//һ������ʽ�������
													String[] xcs = cs2.split(",");
													int m=0;
													for(String x2:xcs){													
														if(bds1.contains(x2)){
															//list1.add(x1);
															m=1;
														}
													}
													////�ж��ǲ���С��������������ʽ
													if(m==1&&!(bds1.contains("==0"))){
														list1.add(bds1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(bds1.contains("==0"))){
															list2.add(bds1);//list2������==0��С������ʽ													
														}
														if(m==0){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}//if(cs2.contains(","))
												else{
													//!cs2.contains(",")
													//һ������ʽһ������
													int m=0;
													if(bds1.contains(cs2)){
														m=1;
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(bds1.contains("==0"))){
														list1.add(bds1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(bds1.contains("==0"))){
															list2.add(bds1);//list2������==0��С������ʽ													
														}
														if(m==0){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}
											}
										}
										
										//��������ʽ
										String cs = null;
										if(list.size()>1){
											cs=list.get(0);
											for(int mm=1;mm<list.size();mm++){
												String c1=list.get(mm);
												cs=cs+","+c1;
											}
										}
										if(list.size()==1){
											cs=list.get(0);
										}
										bds1=cs;
										//								System.out.println("��������ʽΪ----->"+cs);

										//��=0��С������ʽ
										String css = null;
										if(list1.size()>1){
											css=list1.get(0);
											for(int mm=1;mm<list1.size();mm++){
												String c1=list1.get(mm);
												css=css+","+c1;
											}
										}
										if(list1.size()==1){
											css=list1.get(0);
										}
										bds2=css;
										//								System.out.println("С������ʽΪ----->"+css);
									
										//=0��С������ʽ
										String csss = null;
										if(list2.size()>1){
											csss=list2.get(0);
											for(int mm=1;mm<list2.size();mm++){
												String c1=list2.get(mm);
												csss=csss+","+c1;
											}
										}
										if(list2.size()==1){
											csss=list2.get(0);
										}	
										bds00=csss.replace("==", "=");
									
									}//if(bds1!=null)
									else{
										if(bds1==null){
											//System.out.println("��������ʽΪ----->"+null);
											//System.out.println("С������ʽΪ----->"+null);
										}										
									}


								}//if(cs2!=null)
								else{
									//û��С������
									//									System.out.println("��������ʽΪ----->"+bds1);
									//									System.out.println("С������ʽΪ----->"+null);

								}


								//////////////////////






								//////////////////////////////////
								//								System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
								//System.out.println("==0------>����ʽ������"+bds0);
								//								System.out.println("����------>����������"+cs1);
								//								System.out.println("С��------>����ʽ������"+bds2);
								//								System.out.println("С��------>����������"+cs2);
								//								System.out.println("add------>��������ʽΪ��"+s1);
								//								System.out.println("add------>С������ʽΪ��"+s2);

								//�����Ͳ���ʽ�Ͳ���
								String boolbds=GetBds.get_boolbds(conditonValue.toString());
								if(cs3!=null&&boolbds==null){
									boolbds = AddBdsType.add_boolbds(cs3);
								}
								//								System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ  ==
								//								System.out.println("������------>����������"+cs3);



								///////////////////////////////////
								//����mma�����ⷽ����
								if(((bds1==null)&&(cs1==null))&&(s2==null)){
									//									System.out.println("        ===>  condition��û��Լ����Ϊ��null");
									//input.setText("null");
								}
								if((bds1!=null)&&(cs1!=null)){
									String bbb = bds1+","+s1;
									//									System.out.println("        ===>  condition����������ֵ����ʽ��"+bbb);
									//System.out.println("        ===>  condition����������ֵ������"+cs1);
									//									String solution1 = Mathematica.getSolution2(bbb, cs1);
									ttt=bbb.toString();
									//									System.out.println("condition������Լ����Ϊ��"+solution1);
								}
								else{
									if(s1!=null){
										//System.out.println("condition����������ֵ����ʽ��"+s1);
										//System.out.println("        ===>  condition����������ֵ������"+cs1);
										//String solution1 = Mathematica.getSolution2(s1, cs1);
										ttt=s1.toString();
										//System.out.println("condition��������Լ����Ϊ��"+solution1);
									}
								}
								if((s2!=null)){
									//System.out.println("condition��С������ֵ����ʽ��"+s2);
									//System.out.println("        ===>  condition��С������ֵ������"+cs2);
									//									String solution2 = Mathematica.getSolution4(s2, cs2);
									ttt1=s2.toString();
									//									System.out.println("condition��С����Լ����Ϊ��"+solution2);
								}
								//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
								if(boolbds!=null){
									//									System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1+","+boolbds;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt+","+boolbds;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1+","+boolbds;
									}
								}
								else{
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1;
									}
								}
								if(ttt3!=null&&bds00!=null){
									ttt3 = ttt3+","+bds00;
								}else{
									if(ttt3==null&&bds00!=null){
										ttt3 = bds00;
									}
								}


								//////////////////


							}
						}

					}
					else{
						if(!tran.getCondition().contains("/")){
							//							System.out.println("          condition---->"+tran.getCondition());
							if(GetMap.get_condMap(tran.getCondition())==null){
								//								System.out.println("keySet����3��"+GetMap.get_condMap(tran.getCondition()));
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									map1 = GetMap.get_condMap(tran.getCondition());//�����У�Ҫ���������
									//System.out.println("==================================");
									Set<String> set =map1.keySet();

									String cs1 = AddBdsType.getcs(map1);
									String cs2 = AddBdsType.getDoubleCs(map1);
									String cs3 = AddBdsType.getBoolCs(map1);			
									String s1 = AddBdsType.add_bds(map1);
									String s2 = AddBdsType.add_doublebds(map1);
									String bds2=null;
									String bds00=null;

									//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
									String bds0=GetBds.get_bds_0(tran.getCondition().toString());
									//�����Ͳ���ʽ�Ͳ���
									String bds1=GetBds.get_bds(tran.getCondition().toString());					

									//////////////////
									if(cs2!=null){  //cs2��С��------>����
										if(bds1!=null){
											if(bds1.contains(",")){
												String[] xbds = bds1.split(",");
												if(cs2.contains(",")){//�������ʽ�������
													String[] xcs = cs2.split(",");
													for(String x1:xbds){
														int m=0;
														for(String x2:xcs){													
															if(x1.contains(x2)){
																//list1.add(x1);
																m=1;
															}
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(x1.contains("==0"))){
															list1.add(x1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(x1.contains("==0"))){
																list2.add(x1);//list2������==0��С������ʽ
															}
															if(m==0){
																list.add(x1);//list�����ų���==0����������ʽ
															}
														}

													}//for(String x1:xbds) 
												}//if(cs2.contains(","))
												else{
													//!cs2.contains(",")
													////�������ʽһ������
													for(String x1:xbds){
														int m=0;
														if(x1.contains(cs2)){
															m=1;
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(x1.contains("==0"))){
															list1.add(x1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&!(x1.contains("==0"))){
																list2.add(x1);//list1������==0��С������ʽ
															}
															if(m==0){
																list.add(x1);//list�����ų���==0����������ʽ
															}
														}
													}												
												}

											}//if(bds1.contains(","))
											else{
												if(!bds1.contains(",")){
													if(cs2.contains(",")){//һ������ʽ�������
														String[] xcs = cs2.split(",");
														int m=0;
														for(String x2:xcs){													
															if(bds1.contains(x2)){
																//list1.add(x1);
																m=1;
															}
														}
														////�ж��ǲ���С��������������ʽ
														if(m==1&&!(bds1.contains("==0"))){
															list1.add(bds1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&!(bds1.contains("==0"))){
																list2.add(bds1);//list2������==0��С������ʽ
															}
															if(m==0){
																list.add(bds1);//list�����ų���==0����������ʽ
															}
														}
													}//if(cs2.contains(","))
													else{
														//!cs2.contains(",")
														//һ������ʽһ������
														int m=0;
														if(bds1.contains(cs2)){
															m=1;
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(bds1.contains("==0"))){
															list1.add(bds1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(bds1.contains("==0"))){
																list2.add(bds1);//list2������==0��С������ʽ
															}
															if(m==0){
																list.add(bds1);//list�����ų���==0����������ʽ
															}
														}
													}
												}
											}
											//��������ʽ
											String cs = null;
											if(list.size()>1){
												cs=list.get(0);
												for(int mm=1;mm<list.size();mm++){
													String c1=list.get(mm);
													cs=cs+","+c1;
												}
											}
											if(list.size()==1){
												cs=list.get(0);
											}	
											bds1=cs;
											//									System.out.println("��������ʽΪ----->"+cs);

											//��=0��С������ʽ
											String css = null;
											if(list1.size()>1){
												css=list1.get(0);
												for(int mm=1;mm<list1.size();mm++){
													String c1=list1.get(mm);
													css=css+","+c1;
												}
											}
											if(list1.size()==1){
												css=list1.get(0);
											}
											bds2=css;
											//									System.out.println("С������ʽΪ----->"+css);
											//=0��С������ʽ
											String csss = null;
											if(list2.size()>1){
												csss=list2.get(0);
												for(int mm=1;mm<list2.size();mm++){
													String c1=list2.get(mm);
													csss=csss+","+c1;
												}
											}
											if(list2.size()==1){
												csss=list2.get(0);
											}	
											bds00=csss.replace("==", "=");
										}//if(bds1!=null)
										else{
											if(bds1==null){
												//												System.out.println("��������ʽΪ----->"+null);
												//												System.out.println("С������ʽΪ----->"+null);
											}										
										}


									}//if(cs2!=null)
									else{
										//û��С������
										//	System.out.println("��������ʽΪ----->"+bds1);
										//	System.out.println("С������ʽΪ----->"+null);

									}


									/////////



									/////////////////���
									//         System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
									//System.out.println("==0------>����ʽ������"+bds0);
									//System.out.println("����------>����������"+cs1);
									//		System.out.println("С��------>����ʽ������"+bds2);
									//System.out.println("С��------>����������"+cs2);
									//			System.out.println("add------>��������ʽΪ��"+s1);
									//				System.out.println("add------>С������ʽΪ��"+s2);

									//�����Ͳ���ʽ�Ͳ���
									String boolbds=GetBds.get_boolbds(tran.getCondition().toString());
									if(cs3!=null&&boolbds==null){
										boolbds = AddBdsType.add_boolbds(cs3);
									}
									//			System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
									//			System.out.println("������------>����������"+cs3);



									/////////////////////////////////////////
									//����mma�����ⷽ����
									if(((bds1==null)&&(cs1==null))&&(s2==null)){
										//										System.out.println("        ===>  condition��û��Լ����Ϊ��null");
										//input.setText("null");
									}
									if((bds1!=null)&&(cs1!=null)){
										String bbb = bds1+","+s1;
										//										System.out.println("        ===>  condition����������ֵ����ʽ��"+bbb);
										//										System.out.println("        ===>  condition����������ֵ������"+cs1);
										//										String solution1 = Mathematica.getSolution2(bbb, cs1);
										ttt=bbb.toString();
										//										System.out.println("condition������Լ����Ϊ��"+solution1);
									}
									else{
										if(s1!=null){
											//											System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
											//											System.out.println("        ===>  condition����������ֵ������"+cs1);
											//											String solution1 = Mathematica.getSolution2(s1, cs1);
											ttt=s1.toString();
											//											System.out.println("condition��������Լ����Ϊ��"+solution1);
										}
									}
									if((s2!=null)){
										//										System.out.println("        ===>  condition��С������ֵ����ʽ��"+s2);
										//										System.out.println("        ===>  condition��С������ֵ������"+cs2);
										//										String solution2 = Mathematica.getSolution4(s2, cs2);
										ttt1=s2.toString();
										//										System.out.println("condition��С����Լ����Ϊ��"+solution2);
									}
									//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
									if(boolbds!=null){
										//										System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1+","+boolbds;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt+","+boolbds;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1+","+boolbds;
										}
									}
									else{
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1;
										}
									}
									if(ttt3!=null&&bds00!=null){
										ttt3 = ttt3+","+bds00;
									}else{
										if(ttt3==null&&bds00!=null){
											ttt3 = bds00;
										}
									}


									//////////////////////////////////////


								}
							}
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						//					System.out.println("condition--null-->"+tran.getCondition());	
					}

				}

				//				System.out.println("===========================condition�������===========================");

				////////////////////////////////////////////////condition�������///////////////////////////////////////





				//				System.out.println("******************************************");
				/////////////////////////////////////////////////////////////////////////////////////
				//��ӽڵ�

				//
				////////////////////Ϊinput���������Ľ�
				if(ttt2==null&&ttt3==null){		
					System.out.println("ʵ����Լ��������null");
				}
				else{
					if(ttt2!=null&&ttt3!=null){
						String x=ttt2+","+ttt3;
						x.replaceAll("false", "False").replaceAll("true", "True");
						System.out.println("ʵ����Լ��������"+x);
					}
					else{
						if(ttt2==null&&ttt3!=null){
							String x=ttt3;
							x.replaceAll("false", "False").replaceAll("true", "True");
							System.out.println("ʵ����Լ��������"+x);
						}
						else{
							if(ttt2!=null&&ttt3==null){
								String x=ttt2;
								x.replaceAll("false", "False").replaceAll("true", "True");
								System.out.println("ʵ����Լ��������"+x);
							}
						}
					}
				}

				//				System.out.println("******************************************");

				////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
				System.out.println();
			}
			System.out.println();
			//System.out.println("===========================��"+i+"������������ȡ���");
			i++;
		}
	}


	/**
	 * ��ʱ��Լ���������ʽ                       ���Ĳ�           �����������ʵ����
	 * @param xml
	 */
	public static  void output1111(String xml){

		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������



		//########################################        ���Ĳ�             ###############################################
		//#########################################################################################################
		//=====================================================================��ȡ����״̬���ǵĳ����������
		//======================================================================���ݳ���������������Լ������ʽ
		System.out.println("===========================���ڽ���ʵ��������===========================");
		System.out.println();
		System.out.println("---------------------����״̬���ǵ�ʵ�������---------------------");
		System.out.println("===>  ʵ������������������"+testCase.size());

		int i = 1;
		String ttt=null;
		String ttt1=null;
		String ttt2=null;//in
		String ttt3=null;//condition

		for(Automatic a:testCase){	///////////////////////////////////
			
			int j=1;
			System.out.println();
			System.out.println("-------------���ڶ�ȡ��"+i+"����������------------");
			System.out.println("--->  ������������:"+a.getName());
			for(Transition tran:a.getTransitionSet()){/////////////////////
				//System.out.println("       -----------------------------");
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					String sss=tran.getName().substring(0,index11);
					System.out.println("Ǩ��(����)���ƣ�"+sss);
				}
				else{
					System.out.println("Ǩ��(����)���ƣ�"+tran.getName().replace("!", "").replace("?", ""));
				}

				System.out.println("Ǩ��Id��"+tran.getId());								
				System.out.println("Դ״̬���ƣ�"+tran.getSource());
				//				System.out.println("        ===>  Ŀ��״̬���ƣ�"+tran.getTarget());
				//System.out.println("             ======��"+j+"��Ǩ�ƿ�ʼ======");
				//δ�����Լ������	
				//				System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				/////////////////////////////////////////////////////////////////
				Map<String,String> map = new HashMap<String,String>();
				Map<String,String> map1 = new HashMap<String,String>();
				Map<String,String> map3 = new HashMap<String,String>();
				Map<String,String> map4 = new HashMap<String,String>();//////
				///////////////////////////////////////////////in����ʼ///////////////////////////////////////

				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
				//System.out.println("========================in========================");	
//				
				System.out.println("in:"+tran.getIn());	//in���������			
				if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
					//System.out.println("keySet���ϣ�"+tran.getIn());
					ttt2=null;
				}
				else{//map����ֵ�����в����Ͳ�����Ӧ����
					map3 = GetMap.get_inMap(tran.getIn());
					String cs1 = AddBdsType.getcs(map3);
					String cs2 = AddBdsType.getDoubleCs(map3);
					String cs3 = AddBdsType.getBoolCs(map3);
					
					List<String> list=new ArrayList<String>();//�����������ʽ
					List<String> list1=new ArrayList<String>();//��ų�=0��С������ʽ
					List<String> list2=new ArrayList<String>();//���=0С������ʽ
					
/////					
					//System.out.println("zscs:"+cs1+"    xscs:"+cs2+"    boolcs:"+cs3);
					String s1 = AddBdsType.add_bds(map3);			
					String s2 = AddBdsType.add_doublebds(map3);		
					String bds2=null;
					String bds00=null;
					//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
					//String bds0=GetBds.get_bds_0(tran.getIn().toString());

					//�����Ͳ���ʽ�Ͳ���
					String bds1=GetBds.get_bds(tran.getIn().toString());



					/////////////////////////////////////
					if(cs2!=null){  //cs2��С��------>����
						if(bds1!=null){
							if(bds1.contains(",")){
								String[] xbds = bds1.split(",");
								if(cs2.contains(",")){//�������ʽ�������
									String[] xcs = cs2.split(",");
									for(String x1:xbds){
										int m=0;
										for(String x2:xcs){													
											if(x1.contains(x2)){
												//list1.add(x1);
												m=1;
											}
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(x1.contains("==0"))){
											list1.add(x1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(x1.contains("==0"))){
												list2.add(x1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(x1);//list�����ų���==0����������ʽ
											}
										}

									}//for(String x1:xbds) 
								}//if(cs2.contains(","))
								else{
									//!cs2.contains(",")
									////�������ʽһ������
									for(String x1:xbds){
										int m=0;
										if(x1.contains(cs2)){
											m=1;
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(x1.contains("==0"))){
											list1.add(x1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(x1.contains("==0"))){
											list2.add(x1);//list2������==0��С������ʽ
										    }
											
											if(m==0){
												list.add(x1);//list�����ų���==0����������ʽ
											}
										}
									}												
								}

							}//if(bds1.contains(","))
							else{
								if(!bds1.contains(",")){
									if(cs2.contains(",")){//һ������ʽ�������
										String[] xcs = cs2.split(",");
										int m=0;
										for(String x2:xcs){													
											if(bds1.contains(x2)){
												//list1.add(x1);
												m=1;
											}
										}
										////�ж��ǲ���С��������������ʽ
										if(m==1&&!(bds1.contains("==0"))){
											list1.add(bds1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(bds1.contains("==0"))){
												list2.add(bds1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(bds1);//list�����ų���==0����������ʽ
											}
										}
									}//if(cs2.contains(","))
									else{
										//!cs2.contains(",")
										//һ������ʽһ������
										int m=0;
										if(bds1.contains(cs2)){
											m=1;
										}
										////�ж��ǲ���С��������������ʽ����==0�����
										if(m==1&&!(bds1.contains("==0"))){
											list1.add(bds1);//list1�����ų���==0��С������ʽ
										}
										else{
											if(m==1&&(bds1.contains("==0"))){
												list2.add(bds1);//list2������==0��С������ʽ
											}
											if(m==0){
												list.add(bds1);//list�����ų���==0����������ʽ
											}
										}
									}
								}
							}
							//��������ʽ
							String cs = null;
							if(list.size()>1){
								cs=list.get(0);
								for(int mm=1;mm<list.size();mm++){
									String c1=list.get(mm);
									cs=cs+","+c1;
								}
							}
							if(list.size()==1){
								cs=list.get(0);
							}	
							bds1=cs;
							//	System.out.println("��������ʽΪ----->"+cs);

							//��=0��С������ʽ
							String css = null;
							if(list1.size()>1){
								css=list1.get(0);
								for(int mm=1;mm<list1.size();mm++){
									String c1=list1.get(mm);
									css=css+","+c1;
								}
							}
							if(list1.size()==1){
								css=list1.get(0);
							}
							bds2=css;
							//	System.out.println("С������ʽΪ----->"+css);
							
							//=0��С������ʽ
							String csss = null;
							if(list2.size()>1){
								csss=list2.get(0);
								for(int mm=1;mm<list2.size();mm++){
									String c1=list2.get(mm);
									csss=csss+","+c1;
								}
							}
							if(list2.size()==1){
								csss=list2.get(0);
							}	
							bds00=csss.replace("==", "=");
						}//if(bds1!=null)
						else{
							if(bds1==null){
								//				System.out.println("��������ʽΪ----->"+null);
								//				System.out.println("С������ʽΪ----->"+null);
							}										
						}												
					}//if(cs2!=null)
					else{
						//û��С������
						//		System.out.println("��������ʽΪ----->"+bds1);
						//		System.out.println("С������ʽΪ----->"+null);

					}


					//////////////////////



					//////////////////////
//					System.out.println("����------>����ʽ������"+bds1);  //in�����ֲ���ʽ
//					System.out.println("==0------>����ʽ������"+bds00);
//					System.out.println("����------>����������"+cs1);
//					System.out.println("С��------>����ʽ������"+bds2);
//					System.out.println("С��------>����������"+cs2);
//					System.out.println("add------>��������ʽΪ��"+s1);
//					System.out.println("add------>С������ʽΪ��"+s2);

					//�����Ͳ���ʽ�Ͳ���
					String boolbds=GetBds.get_boolbds(tran.getIn().toString());
					if(cs3!=null&&boolbds==null){
						boolbds = AddBdsType.add_boolbds(cs3);
					}
					//System.out.println("������------>����ʽ������"+boolbds);//in�ϲ�������ʽ
					//System.out.println("������------>����������"+cs3);


					//System.out.println("in�ϲ���ʽ��");

					////////////////////////////////////
					//����mma�����ⷽ����
					if(((bds1==null)&&(cs1==null))&&(bds2==null)&&(s2==null)){
						//System.out.println("        ===>  in��û��Լ����Ϊ��null");
					}
					if((bds1!=null)&&(cs1!=null)){
						String bbb = bds1+","+s1;
						//System.out.println("        ===>  in����������ֵ����ʽ��"+bbb);
						//System.out.println("        ===>  in����������ֵ������"+cs1);
						String solution1 = Mathematica.getSolution2(bbb, cs1);
						ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt=bbb.toString();
						//System.out.println("in������Լ����Ϊ��"+solution1);
					}
					else{
						if(s1!=null){
							//System.out.println("        ===>  in����������ֵ����ʽ��"+s1);
							//System.out.println("in����������ֵ������"+cs1);
							String solution1 = Mathematica.getSolution2(s1, cs1);
							ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//System.out.println("in��������Լ����Ϊ��"+solution1);
						}
					}
					if((bds2!=null)&&(s2!=null)){
						//						System.out.println("        ===>  in��С������ֵ����ʽ��"+s2);
						//System.out.println("in��С������ֵ������"+cs2);
						String bb = bds2+","+s2;
						String solution2 = Mathematica.getSolution4(bb, cs2);
						ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt1=s2.toString();
						//System.out.println("in��С����Լ����Ϊ��"+solution2);
					}else{
						if((s2!=null)){
							String solution2 = Mathematica.getSolution4(s2, cs2);
							ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						}
					}
					if(boolbds!=null){
						//System.out.println("        ===>  in�ϲ����͵Ĳ���ʽ��"+boolbds);
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1+","+boolbds;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt+","+boolbds;;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1+","+boolbds;
						}
					}
					else{
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1;
						}
					}
					if(ttt2!=null&&bds00!=null){
						ttt2 = ttt2+","+bds00;
					}else{
						if(ttt2==null&&bds00!=null){
							ttt2 = bds00;
						}
					}




					//////////////////


				}
				//			System.out.println("===========================in�������===========================");

				//////////////////////////////////////////////in�������//////////////////////////////////////
				//////////////////////////////////////////////out����ʼ///////////////////////////////////////

				//			System.out.println("out---->"+tran.getOut());



				//////////////////////////////////////////////out�������///////////////////////////////////////
				/////////////////////////////////////////////condition����ʼ///////////////////////////////////////
				//				System.out.println("--------------------------condition------------------------");
				//Map<String,String> map = new HashMap<String,String>();
				//Map<String,String> map1 = new HashMap<String,String>();
				if(!tran.getCondition().equals("null")){
					List<String> list=new ArrayList<String>();//�����������ʽ
					List<String> list1=new ArrayList<String>();//��ų�=0��С������ʽ
					List<String> list2=new ArrayList<String>();//���=0С������ʽ
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����

						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
//						
						System.out.println("condition������:"+conditonValue);
						//System.out.println("==================================");
						if(GetMap.get_condMap(conditonValue)==null){          //û��Լ������ʽ
							//System.out.println("keySet����1��"+GetMap.get_condMap(conditonValue));
							ttt3=null;
						}
						else{                                                 //��Լ������ʽ
							if(!(GetMap.get_condMap(conditonValue)==null)){
								map = GetMap.get_condMap(conditonValue);//�����У�Ҫ���������

								String cs1 = AddBdsType.getcs(map);
								String cs2 = AddBdsType.getDoubleCs(map);
								String cs3 = AddBdsType.getBoolCs(map);
								//								System.out.println("-----------");								
								String s1 = AddBdsType.add_bds(map);
								String s2 = AddBdsType.add_doublebds(map);	
								String bds2=null;
								String bds00=null;

								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//(==0�Ľ�)
								//								String bds0=GetBds.get_bds_0(conditonValue.toString());

								//�����Ͳ���ʽ�Ͳ���
								String bds1=GetBds.get_bds(conditonValue.toString());	



								///////////////////////////////////
								if(cs2!=null){  //cs2��С��------>����
									if(bds1!=null){
										if(bds1.contains(",")){
											String[] xbds = bds1.split(",");
											if(cs2.contains(",")){//�������ʽ�������
												String[] xcs = cs2.split(",");
												for(String x1:xbds){
													int m=0;
													for(String x2:xcs){													
														if(x1.contains(x2)){
															//list1.add(x1);
															m=1;
														}
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(x1.contains("==0"))){
														list1.add(x1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(x1.contains("==0"))){
															list2.add(x1);//list2������==0��С������ʽ
														}
														if(m==0){
															list.add(x1);//list�����ų���==0����������ʽ
														}
													}

												}//for(String x1:xbds) 
											}//if(cs2.contains(","))
											else{
												//!cs2.contains(",")
												////�������ʽһ������
												for(String x1:xbds){
													int m=0;
													if(x1.contains(cs2)){
														m=1;
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(x1.contains("==0"))){
														list1.add(x1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(x1.contains("==0"))){
															list2.add(x1);//list2������==0��С������ʽ
														}
														if(m==0){
															list.add(x1);//list�����ų���==0����������ʽ
														}
													}
												}												
											}

										}//if(bds1.contains(","))
										else{
											if(!bds1.contains(",")){
												if(cs2.contains(",")){//һ������ʽ�������
													String[] xcs = cs2.split(",");
													int m=0;
													for(String x2:xcs){													
														if(bds1.contains(x2)){
															//list1.add(x1);
															m=1;
														}
													}
													////�ж��ǲ���С��������������ʽ
													if(m==1&&!(bds1.contains("==0"))){
														list1.add(bds1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(bds1.contains("==0"))){
															list2.add(bds1);//list2������==0��С������ʽ													
														}
														if(m==0){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}//if(cs2.contains(","))
												else{
													//!cs2.contains(",")
													//һ������ʽһ������
													int m=0;
													if(bds1.contains(cs2)){
														m=1;
													}
													////�ж��ǲ���С��������������ʽ����==0�����
													if(m==1&&!(bds1.contains("==0"))){
														list1.add(bds1);//list1�����ų���==0��С������ʽ
													}
													else{
														if(m==1&&(bds1.contains("==0"))){
															list2.add(bds1);//list2������==0��С������ʽ													
														}
														if(m==0){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}
											}
										}
										//��������ʽ
										String cs = null;
										if(list.size()>1){
											cs=list.get(0);
											for(int mm=1;mm<list.size();mm++){
												String c1=list.get(mm);
												cs=cs+","+c1;
											}
										}
										if(list.size()==1){
											cs=list.get(0);
										}
										bds1=cs;
										//								System.out.println("��������ʽΪ----->"+cs);

										//��=0��С������ʽ
										String css = null;
										if(list1.size()>1){
											css=list1.get(0);
											for(int mm=1;mm<list1.size();mm++){
												String c1=list1.get(mm);
												css=css+","+c1;
											}
										}
										if(list1.size()==1){
											css=list1.get(0);
										}
										bds2=css;
										//								System.out.println("С������ʽΪ----->"+css);
										//=0��С������ʽ
										String csss = null;
										if(list2.size()>1){
											csss=list2.get(0);
											for(int mm=1;mm<list2.size();mm++){
												String c1=list2.get(mm);
												csss=csss+","+c1;
											}
										}
										if(list2.size()==1){
											csss=list2.get(0);
										}	
										bds00=csss.replace("==", "=");
									}//if(bds1!=null)
									else{
										if(bds1==null){
											//											System.out.println("��������ʽΪ----->"+null);
											//											System.out.println("С������ʽΪ----->"+null);
										}										
									}


								}//if(cs2!=null)
								else{
									//û��С������
									//									System.out.println("��������ʽΪ----->"+bds1);
									//									System.out.println("С������ʽΪ----->"+null);

								}


								//////////////////////






								//////////////////////////////////
//								System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
//								//System.out.println("==0------>����ʽ������"+bds0);
//								System.out.println("����------>����������"+cs1);
//								System.out.println("С��------>����ʽ������"+bds2);
//								System.out.println("С��------>����������"+cs2);
//								System.out.println("add------>��������ʽΪ��"+s1);
//								System.out.println("add------>С������ʽΪ��"+s2);

								//�����Ͳ���ʽ�Ͳ���
								String boolbds=GetBds.get_boolbds(conditonValue.toString());
								if(cs3!=null&&boolbds==null){
									boolbds = AddBdsType.add_boolbds(cs3);
								}							
								//System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ  ==
								//								System.out.println("������------>����������"+cs3);



								///////////////////////////////////
								//����mma�����ⷽ����
								if(((bds1==null)&&(cs1==null))&&(s2==null)){
									//									System.out.println("        ===>  condition��û��Լ����Ϊ��null");
									//input.setText("null");
								}
								if((bds1!=null)&&(cs1!=null)){
									String bbb = bds1+","+s1;
//////////////									
									//System.out.println("condition����������ֵ����ʽ��"+bbb);
									//System.out.println("        ===>  condition����������ֵ������"+cs1);
									String solution1 = Mathematica.getSolution2(bbb, cs1);
									ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									//ttt=bbb.toString();
									//									System.out.println("condition������Լ����Ϊ��"+solution1);
								}
								else{
									if(s1!=null){
///////////										
										//System.out.println("condition����������ֵ����ʽ��"+s1);
										//System.out.println("        ===>  condition����������ֵ������"+cs1);
										String solution1 = Mathematica.getSolution2(s1, cs1);
										ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt=s1.toString();
										//System.out.println("condition��������Լ����Ϊ��"+solution1);
									}
								}
								if((bds2!=null)&&(s2!=null)){
//////////////									
									//System.out.println("condition��С������ֵ����ʽ��"+s2);
									//System.out.println("        ===>  condition��С������ֵ������"+cs2);
									String bb = bds2+","+s2;
									String solution2 = Mathematica.getSolution4(bb, cs2);
									ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									//ttt1=s2.toString();
									//									System.out.println("condition��С����Լ����Ϊ��"+solution2);
								}else{
									if((s2!=null)){
										String solution2 = Mathematica.getSolution4(s2, cs2);
										ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									}
								}
/////////////								
								//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
								if(boolbds!=null){
									//									System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1+","+boolbds;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt+","+boolbds;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1+","+boolbds;
									}
								}
								else{
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1;
									}
								}
								if(ttt3!=null&&bds00!=null){
									ttt3 = ttt3+","+bds00;
									System.out.println("condition�Ͻ�Ϊ��"+ttt3);
								}else{
									if(ttt3==null&&bds00!=null){
										ttt3 = bds00;
										System.out.println("condition�Ͻ�Ϊ��"+ttt3);
									}
								}


								//////////////////


							}
						}

					}
					else{
						if(!tran.getCondition().contains("/")){
//							
							System.out.println("condition������"+tran.getCondition());
							if(GetMap.get_condMap(tran.getCondition())==null){
								//								System.out.println("keySet����3��"+GetMap.get_condMap(tran.getCondition()));
								ttt3=null;
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									map1 = GetMap.get_condMap(tran.getCondition());//�����У�Ҫ���������
									//System.out.println("==================================");
									Set<String> set =map1.keySet();

									String cs1 = AddBdsType.getcs(map1);
									String cs2 = AddBdsType.getDoubleCs(map1);
									String cs3 = AddBdsType.getBoolCs(map1);			
									String s1 = AddBdsType.add_bds(map1);
									String s2 = AddBdsType.add_doublebds(map1);
									String bds2=null;
									String bds00=null;

									//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
									//String bds0=GetBds.get_bds_0(tran.getCondition().toString());
									//�����Ͳ���ʽ�Ͳ���
									String bds1=GetBds.get_bds(tran.getCondition().toString());					

									//////////////////
									if(cs2!=null){  //cs2��С��------>����
										if(bds1!=null){
											if(bds1.contains(",")){
												String[] xbds = bds1.split(",");
												if(cs2.contains(",")){//�������ʽ�������
													String[] xcs = cs2.split(",");
													for(String x1:xbds){
														int m=0;
														for(String x2:xcs){													
															if(x1.contains(x2)){
																//list1.add(x1);
																m=1;
															}
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(x1.contains("==0"))){
															list1.add(x1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(x1.contains("==0"))){
																list2.add(x1);//list2������==0��С������ʽ
															}
															if(m==0){
																list.add(x1);//list�����ų���==0����������ʽ
															}
														}

													}//for(String x1:xbds) 
												}//if(cs2.contains(","))
												else{
													//!cs2.contains(",")
													////�������ʽһ������
													for(String x1:xbds){
														int m=0;
														if(x1.contains(cs2)){
															m=1;
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(x1.contains("==0"))){
															list1.add(x1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(x1.contains("==0"))){
																list2.add(x1);//list2������==0��С������ʽ
															}
															if(m==0){
																list.add(x1);//list�����ų���==0����������ʽ
															}
														}
													}												
												}

											}//if(bds1.contains(","))
											else{
												if(!bds1.contains(",")){
													if(cs2.contains(",")){//һ������ʽ�������
														String[] xcs = cs2.split(",");
														int m=0;
														for(String x2:xcs){													
															if(bds1.contains(x2)){
																//list1.add(x1);
																m=1;
															}
														}
														////�ж��ǲ���С��������������ʽ
														if(m==1&&!(bds1.contains("==0"))){
															list1.add(bds1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(bds1.contains("==0"))){
																list2.add(bds1);//list2������==0��С������ʽ													
															}
															if(m==0){
																list.add(bds1);//list�����ų���==0����������ʽ
															}
														}
													}//if(cs2.contains(","))
													else{
														//!cs2.contains(",")
														//һ������ʽһ������
														int m=0;
														if(bds1.contains(cs2)){
															m=1;
														}
														////�ж��ǲ���С��������������ʽ����==0�����
														if(m==1&&!(bds1.contains("==0"))){
															list1.add(bds1);//list1�����ų���==0��С������ʽ
														}
														else{
															if(m==1&&(bds1.contains("==0"))){
																list2.add(bds1);//list2������==0��С������ʽ													
															}
															if(m==0){
																list.add(bds1);//list�����ų���==0����������ʽ
															}
														}
													}
												}
											}
											String cs = null;
											if(list.size()>1){
												cs=list.get(0);
												for(int mm=1;mm<list.size();mm++){
													String c1=list.get(mm);
													cs=cs+","+c1;
												}
											}
											if(list.size()==1){
												cs=list.get(0);
											}	
											bds1=cs;
											//									System.out.println("��������ʽΪ----->"+cs);

											String css = null;
											if(list1.size()>1){
												css=list1.get(0);
												for(int mm=1;mm<list1.size();mm++){
													String c1=list1.get(mm);
													css=css+","+c1;
												}
											}
											if(list1.size()==1){
												css=list1.get(0);
											}
											bds2=css;
											//									System.out.println("С������ʽΪ----->"+css);
										
											//=0��С������ʽ
											String csss = null;
											if(list2.size()>1){
												csss=list2.get(0);
												for(int mm=1;mm<list2.size();mm++){
													String c1=list2.get(mm);
													csss=csss+","+c1;
												}
											}
											if(list2.size()==1){
												csss=list2.get(0);
											}	
											bds00=csss.replace("==", "=");
										}//if(bds1!=null)
										else{
											if(bds1==null){
												//												System.out.println("��������ʽΪ----->"+null);
												//												System.out.println("С������ʽΪ----->"+null);
											}										
										}


									}//if(cs2!=null)
									else{
										//û��С������
										//	System.out.println("��������ʽΪ----->"+bds1);
										//	System.out.println("С������ʽΪ----->"+null);

									}


									/////////



									/////////////////���
//									System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
//									//System.out.println("==0------>����ʽ������"+bds0);
//									System.out.println("����------>����������"+cs1);
//									System.out.println("С��------>����ʽ������"+bds2);
//									System.out.println("С��------>����������"+cs2);
//									System.out.println("add------>��������ʽΪ��"+s1);
//									System.out.println("add------>С������ʽΪ��"+s2);

									//�����Ͳ���ʽ�Ͳ���
									String boolbds=GetBds.get_boolbds(tran.getCondition().toString());
									if(cs3!=null&&boolbds==null){
										boolbds = AddBdsType.add_boolbds(cs3);
									}
									//			System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
									//			System.out.println("������------>����������"+cs3);



									/////////////////////////////////////////
									//����mma�����ⷽ����
									if(((bds1==null)&&(cs1==null))&&(s2==null)){
										//										System.out.println("        ===>  condition��û��Լ����Ϊ��null");
										//input.setText("null");
									}
									if((bds1!=null)&&(cs1!=null)){
										String bbb = bds1+","+s1;
/////////										
										//System.out.println("condition����������ֵ����ʽ��"+bbb);
										//										System.out.println("        ===>  condition����������ֵ������"+cs1);

										String solution1 = Mathematica.getSolution2(bbb, cs1);
										ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt=bbb.toString();
										//										System.out.println("condition������Լ����Ϊ��"+solution1);
									}
									else{
										if(s1!=null){
/////////	
											//System.out.println("condition����������ֵ����ʽ��"+s1);
											//											System.out.println("        ===>  condition����������ֵ������"+cs1);
											String solution1 = Mathematica.getSolution2(s1, cs1);
											ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
											//ttt=s1.toString();
											//											System.out.println("condition��������Լ����Ϊ��"+solution1);
										}
									}
									if((bds2!=null)&&(s2!=null)){
/////////									
										//System.out.println("condition��С������ֵ����ʽ��"+s2);
										//										System.out.println("        ===>  condition��С������ֵ������"+cs2);
										String bb = bds2+","+s2;
										String solution2 = Mathematica.getSolution4(bb, cs2);
										ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt1=s2.toString();
										//										System.out.println("condition��С����Լ����Ϊ��"+solution2);
									}else{
										if((s2!=null)){
											String solution2 = Mathematica.getSolution4(s2, cs2);
											ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										}
									}
/////////
									//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
									if(boolbds!=null){
										//										System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1+","+boolbds;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt+","+boolbds;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1+","+boolbds;
										}
									}
									else{
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1;
										}
									}

									if(ttt3!=null&&bds00!=null){
										ttt3 = ttt3+","+bds00;
										System.out.println("condition�Ͻ�Ϊ��"+ttt3);
									}else{
										if(ttt3==null&&bds00!=null){
											ttt3 = bds00;
											System.out.println("condition�Ͻ�Ϊ��"+ttt3);
										}
									}

									//////////////////////////////////////


								}
							}
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						System.out.println("condition��������"+tran.getCondition());							
						ttt3=null;
					}
				}

				//				System.out.println("===========================condition�������===========================");

				////////////////////////////////////////////////condition�������///////////////////////////////////////





				//				System.out.println("******************************************");
				/////////////////////////////////////////////////////////////////////////////////////
				//��ӽڵ�

				//
				////////////////////Ϊinput���������Ľ�
				if(ttt2==null&&ttt3==null){		
					System.out.println("ʵ���������null");
				}
				else{
					if(ttt2!=null&&ttt3!=null){
						ttt3.toString().replaceAll("false", "False").replaceAll("true", "True");
						String x=ttt2+","+ttt3;
						x.toString().replace("false", "False").replace("true", "True");
						System.out.println("ʵ���������"+x);
					}
					else{
						if(ttt2==null&&ttt3!=null){
							ttt3.toString().replaceAll("false", "False").replaceAll("true", "True");
							String x=ttt3;
							x.toString().replace("false", "False").replace("true", "True");
							System.out.println("ʵ���������"+x);
						}
						else{
							if(ttt2!=null&&ttt3==null){
								String x=ttt2;
								x.toString().replaceAll("false", "False").replaceAll("true", "True");
								System.out.println("ʵ���������"+x);
							}
						}
					}
				}

				System.out.println();
				//				System.out.println("******************************************");

				////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
			}
			//System.out.println("===========================��"+i+"������������ȡ���");
			i++;
		}

	}




	/**
	 * ��ʱ���Զ����������ʽ
	 * @param xml
	 */
	public static  void output2(String xml){

		Automatic automatic1=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto=AddType.addType(automatic1);
		//ArrayList<State> new_stateSet=Minimization__1.minimization(automatic);
		Automatic new_automatic=IPR__1.iPR(auto);//��ò�ֺ��ʱ���Զ���
		Automatic aTDRTAutomatic=ATDTR__1.aTDRT(new_automatic,auto);//���ȥ������ʱ��Ǩ�ƺ��ʱ���Զ���
		//Automatic DFStree=StateCoverage__1.DFSTree(aTDRTAutomatic);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(aTDRTAutomatic);//�������״̬���ǵĳ����������
		ArrayList<ArrayList<String>> all_inequalitys=Get_inequality__1.get_AllInequalitys(testCase);//ÿ���������������һ������ʽ��

		//########################################        ��һ��             ###############################################
		//#########################################################################################################
		//======================================================================��ȡxml�������Ӧ���ݽṹ��		
		//======================================================================���ڽ���xml�ĵ�
		System.out.println("----------------------------��ȡxml�ĵ���Ϣ----------------------------");
		System.out.println("===========================���ڽ���xml�ĵ�");
		System.out.println("===========================");
		System.out.println();
		System.out.println("===========================���ڻ�ȡxml�ĵ���Ϣ");		
		System.out.println("  ===>  ʱ���Զ������֣�"+auto.getName());	
		System.out.print("  ===>  ʱ���Զ���ʱ�Ӽ��ϣ�");
		if((auto.getClockSet().toString().equals("[]"))){
			System.out.println("null");
		}
		else{
			for(String c:auto.getClockSet()){
				System.out.print(" "+c+"  ");
			}
		}
		System.out.println("  ===>  ģ������״̬������"+auto.getStateSet().size());
		System.out.println("  ===>  ģ������Ǩ�Ƹ�����"+auto.getTransitionSet().size());
		System.out.println();
		//=========================================================================xml������Ϣ����


		//=========================================================================��ȡģ�ͳ�ʼ״̬��Ϣ
		System.out.println("===========================���ڻ�ȡ��ʼ״̬��Ϣ");
		System.out.println("===========================");
		State iniState=auto.getInitState();
		System.out.println("  ===>  ��ʼ״̬���֣�"+iniState.getName());
		System.out.println("  ===>  ״̬λ�ã�"+iniState.getPosition());
		System.out.println("  ===>  �Ƿ�Ϊ��ֹ״̬ ��"+iniState.isFinalState());
		System.out.println("  ===>  Type����(�Ƿ�Ϊ��ʼ)��"+iniState.getType());
		DBM_element[][] DBM=iniState.getInvariantDBM();
		if(auto.getClockSet().size()>0){
			for(int i=0;i<auto.getClockSet().size()+1;i++){
				for(int j=0;j<auto.getClockSet().size()+1;j++){
					DBM_element cons=DBM[i][j];
					//System.out.println("DBM_i��"+cons.getDBM_i());
					//System.out.println("DBM_j��"+cons.getDBM_j());
					System.out.println("  ===>  value��"+cons.getValue());
					System.out.println("  ===>  Strictness��"+cons.isStrictness());					
				}
			}
		}		
		System.out.println();
		//============================================================================ģ�ͳ�ʼ״̬��Ϣ��ȡ����


		//============================================================================��ȡģ��״̬�ľ�����Ϣ
		System.out.println("===========================���ڻ�ȡ����״̬������Ϣ");
		System.out.println("===========================");
		System.out.println("  ===>  ״̬�ܸ�����"+auto.getStateSet().size());
		int k=0;
		for(State state:auto.getStateSet()){
			System.out.println("    ===>  ��"+k+"��״̬");
			k++;
			DBM_element[][] dbm=state.getInvariantDBM();
			if(auto.getClockSet().size()>0){
				for(int i=0;i<auto.getClockSet().size()+1;i++){
					for(int j=0;j<auto.getClockSet().size()+1;j++){
						DBM_element cons=dbm[i][j];
						//System.out.println("DBM_i��"+cons.getDBM_i());
						//System.out.println("DBM_j��"+cons.getDBM_j());
						System.out.println("      ===>  value��"+cons.getValue());
						System.out.println("      ===>  Strictness��"+cons.isStrictness());					
					}
				}
			}			
			System.out.println("      ===>  ״̬���ƣ�"+state.getName());
			System.out.println("      ===>  ״̬λ�ã�"+state.getPosition());
			System.out.println("      ===>  �Ƿ�Ϊ��ֹ״̬��"+state.isFinalState());
			System.out.println("      ===>  Type����(�Ƿ�Ϊ��ʼ)��"+state.getType());
			DBM_element[][] adddbm=state.getAddClockRelationDBM();
			if(auto.getClockSet().size()>0){
				for(int i=0;i<auto.getClockSet().size()+1;i++){
					for(int j=0;j<auto.getClockSet().size()+1;j++){
						DBM_element cons=adddbm[i][j];
						//System.out.println("DBM_i��"+cons.getDBM_i());
						//System.out.println("DBM_j��"+cons.getDBM_j());
						System.out.println("      ===>  value��"+cons.getValue());
						System.out.println("      ===>  Strictness��"+cons.isStrictness());					
					}
				}
			}			
			System.out.println("--------------------------");
		}
		System.out.println();		
		//=========================================================================ģ�;���״̬��Ϣ��ȡ����




		//=========================================================================��ȡģ��Ǩ��(����)��Ϣ
		System.out.println("===========================���ڻ�ȡ����Ǩ��(����)������Ϣ");
		System.out.println("===========================");
		System.out.println("  ===>  Ǩ���ܸ�����"+auto.getTransitionSet().size());
		int p=0;
		for(Transition tran:auto.getTransitionSet()){
			System.out.println("    ===>  ��"+p+"��Ǩ��(����)");
			System.out.println("      ===>  Ǩ��(����)���ƣ�"+tran.getName()/*.replace("(", "").replace(")", "").replace("!", "").replace("?", "")*/);
			System.out.println("      ===>  Ǩ��Id��"+tran.getId());
			p++;
			if(tran.getConstraintDBM()!=null){
				DBM_element[][] dbm=tran.getConstraintDBM();
				if(auto.getClockSet().size()>0){
					for(int i=0;i<auto.getClockSet().size()+1;i++){
						for(int j=0;j<auto.getClockSet().size()+1;j++){
							DBM_element cons=dbm[i][j];
							//System.out.println("DBM_i��"+cons.getDBM_i());
							//System.out.println("DBM_j��"+cons.getDBM_j());
							System.out.println("      ===>  value��"+cons.getValue());
							System.out.println("      ===>  Strictness��"+cons.isStrictness());					
						}
					}
				}				
			}
			else System.out.println("ʱ��Լ��Ϊ��");			
			System.out.println("      ===>  Դ״̬���ƣ�"+tran.getSource());
			System.out.println("      ===>  Ŀ��״̬���ƣ�"+tran.getTarget());						
			if(tran.getEventSet()==null){
				System.out.println("�¼�Ϊ��");
			}
			else if(tran.getEventSet().size()==0){
				System.out.println("�¼�Ϊ���գ�����û������");
			}
			else{				
				String in=tran.getIn();		
				String con=tran.getCondition();
				String out=tran.getOut();
				System.out.print("      ===>  in(Լ������)��");
				if("".equals(in.toString())){
					System.out.println("null");
				}
				else{
					System.out.println(in.toString());
				}
				System.out.println("      ===>  condition(Լ������)��"+con);
				System.out.print("      ===>  out(�����Ϣ)��"+out.toString());												
				if("".equals(out.toString())){
					System.out.println("null");
				}
				else{
					System.out.println(out.toString());
				}

				ArrayList<String> events=tran.getEventSet();
				//				for(String e��events){
				//					System.out.println("      ===>  �¼���"+e);
				//				}								
			}			
			if(tran.getResetClockSet()==null){
				System.out.println("      ===>  ����ʱ�ӣ�null");
			}
			else if(tran.getResetClockSet().size()==0){
				System.out.println("      ===>  ����ʱ�ӣ����գ�����û������");
			}
			else{
				ArrayList<String> reset=tran.getResetClockSet();
				for(String r:reset){
					System.out.println("      ===>  ���õ�ʱ�ӣ�"+r);
				}
			}

			if(tran.getTypeIds()==null){
				//				System.out.println("      ===>  typeID��null");
			}
			else if(tran.getTypeIds().size()==0){
				//				System.out.println("      ===>  typeID�����գ�����û������");
			}
			else{
				ArrayList<String> typeid=tran.getTypeIds();
				for(String i:typeid){
					//					System.out.println("      ===>  typeId��"+i);
				}
			}

			if(tran.getTypes()==null){
				//				System.out.println("      ===>  types��null");
			}
			else if(tran.getTypes().size()==0){
				//				System.out.println("      ===>  types�����գ�����û������");
			}
			else{
				ArrayList<String> type=tran.getTypes();
				for(String t:type){
					//					System.out.println("      ===>  types��"+t);
				}
			}

			System.out.println("--------------------------");
		}
		System.out.println();
		//=====================================================================ģ��Ǩ��(����)��Ϣ��ȡ����	
		//=====================================================================��ȡxml����	

	}


	/**
	 * ��ʱ���Զ����������ʽ
	 * @param xml
	 */
	public static  void output22(String xml){

		Automatic automatic1=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto=AddType.addType(automatic1);
		//ArrayList<State> new_stateSet=Minimization__1.minimization(automatic);
		Automatic new_automatic=IPR__1.iPR(auto);//��ò�ֺ��ʱ���Զ���
		Automatic aTDRTAutomatic=ATDTR__1.aTDRT(new_automatic,auto);//���ȥ������ʱ��Ǩ�ƺ��ʱ���Զ���
		//Automatic DFStree=StateCoverage__1.DFSTree(aTDRTAutomatic);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(aTDRTAutomatic);//�������״̬���ǵĳ����������
		ArrayList<ArrayList<String>> all_inequalitys=Get_inequality__1.get_AllInequalitys(testCase);//ÿ���������������һ������ʽ��



		//########################################        �ڶ���             ###############################################
		//#########################################################################################################
		//======================================================================���з��Ų���㷨�������Ӧ���ݽṹ��		
		//======================================================================���ڽ��з���״̬���
		System.out.println("----------------------------��ȡ����״̬��ֺ��ʱ���Զ�����Ϣ----------------------------");		
		System.out.println("===========================���ڽ��з���״̬���");
		System.out.println("===========================");

		//======================================================================���з��Ų���㷨����
		//########################################        ������             ###############################################		
		//#########################################################################################################		


		//########################################        ���Ĳ�             ###############################################	
		//#########################################################################################################
		//=====================================================================��ȡ�����������
		//======================================================================����״̬���ǵĲ������У������Ӧ���ݽṹ�н���
		System.out.println("----------------------------��ȡ����״̬���ǵĲ���������Ϣ----------------------------");
		System.out.println("===========================���ڱ���ʱ���Զ���");
		System.out.println("===========================");
		System.out.println("===========================���������������������");
		System.out.println("===========================");
		System.out.println("===========================���ڱ����������������");
		System.out.println("===========================");
		System.out.println("===========================������������״̬���ǵĳ����������");
		System.out.println("===========================");
		System.out.println();
		System.out.println("===========================���ڻ�ȡ�������������ϸ��Ϣ");		
		System.out.println();
		System.out.println("  ===>  ����������и�����"+testCase.size());
		System.out.println("-------------------------------------------------");
		for(Automatic a:testCase){			
			System.out.println("    ===>  �����������֣�"+a.getName());
			for(Transition tran:a.getTransitionSet()){	
				System.out.println("       -----------------------------");
				System.out.println("      ===>  Ǩ��(����)����--->"+tran.getName());
				System.out.println("        ===>  Ǩ��Id��"+tran.getId());								
				System.out.println("        ===>  Դ״̬���ƣ�"+tran.getSource());
				System.out.println("        ===>  Ŀ��״̬���ƣ�"+tran.getTarget());	
				//δ�����Լ������	
				//				System.out.println("        ===>  Լ����"+tran.getEventSet());
				//���in�����Լ��
				System.out.print("        ===>  in(Լ������)��"+tran.getIn());
				if(tran.getIn().equals("")){
					System.out.println("null");
				}else{
					System.out.println(tran.getIn());
				}					
				//���out�����Լ��
				System.out.print("        ===>  out(�����Ϣ)��");
				if(tran.getOut().equals("")){
					System.out.println("null");
				}else{
					System.out.println(tran.getOut());
				}
				//���condition�����Լ��
				//System.out.println("        ===>  get-condition��"+tran.getCondition());
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����
						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
						System.out.println("        ===>  condition(Լ������)//��"+conditonValue);
					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("        ===>  condition(Լ������)��"+tran.getCondition());
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						System.out.println("        ===>  condition(Լ������)��null-->"+tran.getCondition());	
					}
				}																																									
			}
			System.out.println("---------------------------------------------------------");
			//System.out.println("---------------------------------------------------------");

		}
		System.out.println();
		//=====================================================================��ȡ����������н���
		//########################################        ���岽             ###############################################
		//#########################################################################################################






	}


















}
