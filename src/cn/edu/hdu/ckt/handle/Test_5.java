package cn.edu.hdu.ckt.handle;
//���������ӣ��ĸ���������
import java.util.ArrayList;

public class Test_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml="read_radioForXStream.xml";
		Automatic automatic=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto = AddType.addType(automatic);
		
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������

			int i=1;	
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){
			
			System.out.println("������������:"+a.getName());
			
		/*	for(Transition tran:a.getTransitionSet()){
				System.out.println(tran.getName()+"----********----Ǩ�Ʊ�����");
				System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());
				
				//System.out.println("�ڶ��������i����"+i+"----"+Get_yueshu.get_yueshu(tran.getEventSet().toString()));
				//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				//i++;
			}*/
			for(Transition tran:a.getTransitionSet()){
				System.out.println(/*tran.getSource()+"---->"+tran.getTarget()+*/"��һ�������Լ���� "+tran.getEventSet());
				System.out.println(tran.getName()+"----********----Ǩ�Ʊ�����");
				//System.out.println(/*"�ڶ��������i����"+i+"----"+*/Get_yueshu.get_yueshu(tran.getEventSet().toString()));
				//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				//i++;
			}
			System.out.println("*********************************");
		}
	}

}

