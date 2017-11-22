package cn.edu.hdu.ckt.testcase;
//��������xml�ĵ�

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.StateCoverage__1;
import cn.edu.hdu.ckt.handle.Transition;

public class GetXML5 {
	public static void main(String[] args) {

		//String xml="loop6ForXStream.xml";
		//String xml="loopForXStream3.13.xml";
		//String xml="loopForXStream3.1.5.2.z.xml";//��ʱ��Լ��
		String xml="UAVForXStream3.2.1.xml";//��ʱ��Լ��

		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������



		//########################################����xml�ĵ�###############################################
		//#########################################################################################################


		System.out.println("  ===>  ����������и�����"+testCase.size());
		// 1������document���󣬴�������xml�ĵ�
		Document dom = DocumentHelper.createDocument();
		// 2���������ڵ�TCS
		org.dom4j.Element tcs = dom.addElement("TCS");
		// 3����TCS�ڵ������version����

		int i = 1;		
		List<String> result1=new ArrayList<String>();//���in��������ʵ�������
		List<String> result2=new ArrayList<String>();//���condition��������ʵ�������
		List<List<String>> cases = new ArrayList<List<String>>(); // ������������


		for(Automatic a:testCase){	///////////////////////////////////
			System.out.println("===========================���ڶ�ȡ��"+i+"����������");
			System.out.println("  ===>  ������������:"+a.getName());
			int j = 1;
			for(Transition tran:a.getTransitionSet()){			
				System.out.println("======��"+j+"��Ǩ�ƿ�ʼ======");
				System.out.println("Լ����"+tran.getEventSet());
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					String sss=tran.getName().substring(0,index11);
					System.out.println("Ǩ��(����)���ƣ�"+sss);
				}
				else{
					System.out.println("Ǩ��(����)���ƣ�"+tran.getName().replace("!", "").replace("?", ""));
				}
				// 4�������ӽڵ㼰�ڵ�����
				Element testcase = tcs.addElement("testcase");


				System.out.println("Ǩ��Id��"+tran.getId());								
				System.out.println("Դ״̬���ƣ�"+tran.getSource());
				System.out.println("Ŀ��״̬���ƣ�"+tran.getTarget());

				//δ�����Լ������	
				//System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				////////////////////////////////////////////////////////////////
				///////////////////////////////       in����ʼ            /////////////////////////

				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
				//System.out.println("========================in========================");	
				//System.out.println("in---->"+tran.getIn());	//in���������			
				if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
					//System.out.println("keySet���ϣ�"+tran.getIn());
					result1 = null;
				}
				else{//map����ֵ�����в����Ͳ�����Ӧ����
					String inn = tran.getIn().replace("false", "False").replace("true", "True");
					result1 = Result.getResult(inn);
				}
				if(result1==null){
					System.out.println("in���Ϊ:"+null);
				}else{
					for(int ii=0;ii<result1.size();ii++){
						System.out.println("in���"+ii+"Ϊ:"+result1.get(ii));
					}
				}
				
				//System.out.println("===========================in�������===========================");
				/////////////////////////////////////////////condition����ʼ///////////////////////////////////////
				if(tran.getCondition().equals("null")){	
					result2 = null;
				}else{
					if(!tran.getCondition().equals("null")){
						if(GetMap.get_condMap(tran.getCondition())==null){
							result2 = null;
						}else{
							if(!(GetMap.get_condMap(tran.getCondition())==null)){
								String tra = tran.getCondition().replace("false", "False").replace("true", "True");
								result2 = Result.getResult(tra);
								
							}
						}

					}					
				}
				if(result2==null){
					System.out.println("condition���Ϊ:"+null);
				}else{
					for(int ii=0;ii<result2.size();ii++){
						System.out.println("condition���"+ii+"Ϊ:"+result2.get(ii));
					}
				}
				

				////////////////////////////////////////////////condition�������///////////////////////////////////////

				//System.out.println("===========================condition�������===========================");

				////////////////////////////////////////////////condition�������///////////////////////////////////////



/*

				//System.out.println("******************************************");
				/////////////////////////////////////////////////////////////////////////////////////
				//��ӽڵ�
				Element process = testcase.addElement("process");
				Element operation = process.addElement("operation");
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					String sss=tran.getName().substring(0,index11);
					operation.setText(sss);
				}
				else{
					operation.setText(tran.getName().replace("!", "").replace("?", ""));
				}
				Element input = process.addElement("input");
				//
				////////////////////Ϊinput���������Ľ�
				List<String> result=new ArrayList<String>();//���һ��Ǩ���ϵĽ��
				String res = new String();
				if((result1==null)&&(result2==null)){
					result = null;
				}else{
					for(String ttt2:result1){
						for(String ttt3:result2){
							if(ttt2==null&&ttt3==null){
								//input.setText("null");
								System.out.println("ʵ���������null");
							}
							else{
								if(ttt2!=null&&ttt3!=null){
									res = ttt2+","+ttt3;
									result.add(res);
									//input.setText(ttt2+","+ttt3);
									System.out.println("ʵ���������"+ttt2+","+ttt3);
								}
								else{
									if(ttt2==null&&ttt3!=null){
										res = ttt3;
										result.add(res);
										//input.setText(ttt3);
										System.out.println("ʵ���������"+ttt3);
									}
									else{
										if(ttt2!=null&&ttt3==null){
											res = ttt2;
											result.add(res);
											//input.setText(ttt2);
											System.out.println("ʵ���������"+ttt2);
										}
									}
								}
							}
						}
					}
				}
				cases.add(result);
				/*for(int n=0;n<result.size();n++){

				}*/



				////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
			}//for(Transition tran:a.getTransitionSet())
			//System.out.println("===========================��"+i+"������������ȡ���");
			i++;
		}//for(Automatic a:testCase)


		OutputFormat format = OutputFormat.createPrettyPrint();
		//6������xml�ļ�
		//File file = new File("C:\\Users\\Administrator\\Desktop\\tcss.xml");
		File file = new File("E:\\��Ŀ\\xml\\UAVForXStream3.2.1.xml");
		//String xml="loopForXStream3.1.5.2.z.xml";//��ʱ��Լ��
		//File file = new File("E:\\xml\\tcs2.xml");

		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			writer.write(dom);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
