package cn.edu.hdu.ckt.testcase;
//��֤����

import java.util.ArrayList;
import cn.edu.hdu.ckt.handle.*;


public class yzcw {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String xml="loopForXStream3.13.xml";
		String xml="Package2ForXStream.xml";//��ͼ  ��֤�Ƿ��ܳ�����
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic automatic=AddType.addType(auto);
		/*//ArrayList<State> new_stateSet=Minimization__1.minimization(automatic);
		Automatic new_automatic=IPR__1.iPR(automatic);//��ò�ֺ��ʱ���Զ���
		Automatic aTDRTAutomatic=ATDTR__1.aTDRT(new_automatic,automatic);//���ȥ������ʱ��Ǩ�ƺ��ʱ���Զ���
		//Automatic DFStree=StateCoverage__1.DFSTree(aTDRTAutomatic);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(aTDRTAutomatic);//�������״̬���ǵĳ����������
		ArrayList<ArrayList<String>> all_inequalitys=Get_inequality__1.get_AllInequalitys(testCase);//ÿ���������������һ������ʽ��
		*/
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(automatic);//�������״̬���ǵĳ����������
		System.out.println("ʱ���Զ�������:"+automatic.getName());						
		System.out.println("��Ǩ�Ƹ���"+automatic.getTransitionSet().size());
	/*	int p=0;
		for(Transition tran:automatic.getTransitionSet()){
			System.out.println("��"+p+"��Ǩ��");
			p++;			
			System.out.println("Դ:"+tran.getSource());
			System.out.println("Ŀ�ģ�"+tran.getTarget());						
			if(tran.getEventSet()==null){
//				System.out.println("�¼�Ϊ��");
			}
			else if(tran.getEventSet().size()==0){
//				System.out.println("�¼�Ϊ���գ�����û������");
			}
			else{
				ArrayList<String> events=tran.getEventSet();
				for(String e:events){
					System.out.println("�¼���"+e);
				}
				String con=tran.getCondition();///���/////////////
				System.out.println("�¼���con��"+con);////���/////////////
			}
			System.out.println("********************");
		}*/
		
		
		
		
		
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){			
			System.out.println("������������:"+a.getName());						
			System.out.println("Ǩ�Ƹ���"+a.getTransitionSet().size());
			int pp=0;
			for(Transition tran:a.getTransitionSet()){
				System.out.println("��"+pp+"��Ǩ��");
				pp++;				
				System.out.println("Դ:"+tran.getSource());
				System.out.println("Ŀ�ģ�"+tran.getTarget());								
				if(tran.getEventSet()==null){
					System.out.println("�¼�Ϊ��");
				}
				else if(tran.getEventSet().size()==0){
					System.out.println("�¼�Ϊ���գ�����û������");
				}
				else{
					ArrayList<String> events=tran.getEventSet();
					for(String e:events){
						System.out.println("�¼���"+e);
					}
					String con=tran.getCondition();///���/////////////
					System.out.println("�¼���con��"+con);////���/////////////
				}								
				System.out.println("********************");
			}
//			System.out.println("_________________");
			//Դ:loc_id_5d0a332f-7daf-43c1-9f08-1d0ba3c5466d
			//Ŀ�ģ�loc_id_b85aeaf4-c9dd-4eb8-b49f-ea6f28e89e24_5
			/////////////////////////////////////////////////////////////////////////////
			
//			for(Transition tran:a.getTransitionSet()){
//				System.out.println(/*tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+*/tran.getEventSet());
//			}
			System.out.println("*********************************");
		}
		
		///////////////////////////////////////////////////////////////////////////////
		
		
		/*System.out.println("�ܹ�"+all_inequalitys.size()+"������ʽ��");
		int e=1;
		for(ArrayList<String> inequalitys:all_inequalitys){
			System.out.println("��"+e+"������ʽ��");
			for(String s:inequalitys){
				System.out.println(s);
			}
			System.out.println("***************");
			e++;
		}*/
		
	}

}
