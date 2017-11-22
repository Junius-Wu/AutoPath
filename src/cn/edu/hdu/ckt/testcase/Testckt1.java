package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.StateCoverage__1;
import cn.edu.hdu.ckt.handle.Transition;

public class Testckt1 {

	public static void main(String[] args) {
		//��ȡ��xml�ļ�
		String xml="UAVForXStream3.2.1.xml";//��ʱ��Լ��
		
		//��һ�� �����Ƿ���ʱ��
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		/*if((auto.getClockSet().toString().equals("[]"))){
			System.out.println("1-->��ʱ���Զ�����ʱ��Լ��");
		}else{
			System.out.println();
			System.out.println("1-->��ʱ���Զ�����ʱ��Լ��");
			System.out.print("    ʱ���Զ���ʱ�Ӽ��ϣ�");
			for(String c:auto.getClockSet()){
				System.out.print(" "+c+"  ");
			}
			System.out.println();
		}*/
		//System.out.println("----------------------------------");
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������
		System.out.println("����������и�����"+testCase.size());
		//�ڶ��� �鿴in������	
		for(Automatic a:testCase){
			System.out.println("----------------------------------");
			System.out.println("������������:"+a.getName());			
			for(Transition tran:a.getTransitionSet()){	
				System.out.println("Լ����"+tran.getEventSet());
				System.out.println("2-->in:"+tran.getIn());	//in���������	
				System.out.println("3-->condition:"+tran.getCondition());//condition���������
				//System.out.println("----------------------------------");
			}
		}
		//������ �鿴condition������			
		/*for(Automatic a:testCase){
			System.out.println("������������:"+a.getName());
			System.out.println("----------------------------------");
			for(Transition tran:a.getTransitionSet()){
				//System.out.println("----------------------------------");			
				System.out.println("3-->condition:"+tran.getCondition());//condition���������
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){
						//System.out.println("condition/---->"+conditonValue);
					}else{
						if(!tran.getCondition().contains("/")){
							//System.out.println("condition---->"+tran.getCondition());							
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						//System.out.println("condition--null-->"+tran.getCondition());	
					}
				}
			}
		}*/
	}
}
