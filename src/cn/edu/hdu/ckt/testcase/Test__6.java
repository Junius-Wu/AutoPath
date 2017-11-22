package cn.edu.hdu.ckt.testcase;
//��7�����ӣ�5����������
import java.util.ArrayList;
import cn.edu.hdu.ckt.handle.*;


import org.junit.Test;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

public class Test__6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml="UAV2ForXStream.xml";
		//String xml="read_radioForXStream.xml";
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���

		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������
		
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){
			
			System.out.println("������������:"+a.getName());


			for(Transition tran:a.getTransitionSet()){
				//System.out.println("��������"+tran.getName());
				//System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());
			//δ�����Լ������	
				System.out.println("Լ����"+tran.getEventSet());
			//�����Ͳ���ʽ�Ͳ���
				String bds1=Get_str.get_bds(tran.getEventSet().toString());
				System.out.println(bds1);
				String cs1=Get_str.get_cs(bds1);
				System.out.println(cs1);
				//System.out.println("bds---------->"+bds);
              //�����Ͳ���ʽ�Ͳ���
				String boolbds=Get_str.get_bool_bds(tran.getEventSet().toString());
				System.out.println(boolbds);
				String boolcs=Get_str.get_bool_cs(boolbds);
				System.out.println(boolcs);
			 //==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
				String bds0=Get_str.get_bds_0(tran.getEventSet().toString());
			
			//����mma�����ⷽ����
				if((bds1!=null)&&(cs1!=null)){
					String solution1 = Mathematica.getSolution2(bds1, cs1);
					System.out.println("$$$$$$$$$$$$$$$$$$"+solution1);
				}
				if((boolbds!=null)&&(boolcs!=null)){
					String solution2 = Mathematica.getSolution3(boolbds, boolcs);
					System.out.println("##################"+solution2);
				}
			//����mma�����ⷽ����
				//String solution1 = Mathematica2.getSolution2(bds1, cs1);
				//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
				
				
			}
			System.out.println("*********************************");
		}
		
		
	
	}

}

