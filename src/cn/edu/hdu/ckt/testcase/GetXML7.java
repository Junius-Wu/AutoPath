package cn.edu.hdu.ckt.testcase;
//��������xml�ĵ�

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

public class GetXML7 {
	public static void main(String[] args) {
		//String xml="UAVForXStream3.2.1+.xml";//��ʱ��Լ��
		//String xml="UAVForXStream3.3.0.xml";//��ʱ��Լ��         111
		//String xml="rc_loopForXStream1.01.xml";//��ʱ��Լ��      222
		//String xml="arm_motors_checkForXStream1.01.xml";//��ʱ��Լ��   333
		//String xml="UAVForXStream3.5.0.xml";//��ʱ��Լ��   444
		String xml="UAVForXStream3.7.0.xml";//��ʱ��Լ��   555
		
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������

		// 1������document���󣬴�������xml�ĵ�
		Document dom = DocumentHelper.createDocument();
		// 2���������ڵ�TCS
		org.dom4j.Element tcs = dom.addElement("TCS");
		// 3����TCS�ڵ������version����

		int i = 1;		
		//List<String> result1=new ArrayList<String>();//���in��������ʵ�������
		//List<String> result2=new ArrayList<String>();//���condition��������ʵ�������

//		Date date=new Date();
//		DateFormat formatt=new SimpleDateFormat("HH:mm:ss");
//		String time=formatt.format(date);
		
		for(Automatic a:testCase){	///////////////////////////////////
//			Date date=new Date();
//			DateFormat format=new SimpleDateFormat("HH:mm:ss");
//			String time=format.format(date);
			
			List<List<String>> cases = new ArrayList<List<String>>(); // ������������
			System.out.println("===========================���ڶ�ȡ��"+i+"����������");
			System.out.println("  ===>  ������������:"+a.getName());
			int j = 1;
			// 4�������ӽڵ㼰�ڵ�����
			//Element testcase = tcs.addElement("testcase");

			for(Transition tran:a.getTransitionSet()){
				System.out.println("======��"+j+"��Ǩ�ƿ�ʼ======");
				System.out.println("Ǩ��������"+tran.getCondition());
				//System.out.println("------------------------------------");
				//��ӽڵ�
				//Element process = testcase.addElement("process");
				//Element operation = process.addElement("operation");
				String sss = new String();
				List<String> result1=new ArrayList<String>();//���in��������ʵ�������
				List<String> result2=new ArrayList<String>();//���condition��������ʵ�������
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					sss=tran.getName().substring(0,index11);
					System.out.println("Ǩ��(����)���ƣ�"+sss);
					//operation.setText(sss);
				}
				else{
					sss = tran.getName().replace("!", "").replace("?", "");
					System.out.println("Ǩ��(����)���ƣ�"+sss);
					//operation.setText(sss);
				}


				System.out.println("Ǩ��Id��"+tran.getId());								
				//System.out.println("Դ״̬���ƣ�"+tran.getSource());
				//System.out.println("Ŀ��״̬���ƣ�"+tran.getTarget());

				//δ�����Լ������	
				//System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				////////////////////////////////////////////////////////////////
				///////////////////////////////       in����ʼ            /////////////////////////

				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
				//System.out.println("========================in========================");	
				//System.out.println("in---->"+tran.getIn());	//in���������	
				if(tran.getIn().equals("null")){	
					result1.add(null);
				}else{
					if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
						//System.out.println("keySet���ϣ�"+tran.getIn());
						result1.add(null);
					}
					else{//map����ֵ�����в����Ͳ�����Ӧ����
						String inn = tran.getIn().replace("false", "False").replace("true", "True").replace("->", "$");
						result1 = Result.getResult(inn);
						for(int ii=0;ii<result1.size();ii++){
							//System.out.println("in���"+ii+"Ϊ:"+result1.get(ii));
						}
					}
				}
				
				//System.out.println("===========================in�������===========================");
				/////////////////////////////////////////////condition����ʼ///////////////////////////////////////
				//System.out.println("condition---->"+tran.getCondition());
				if(tran.getCondition().equals("null")){	
					result2.add(null);
				}else{
					if(!tran.getCondition().equals("null")){
						if(GetMap.get_condMap(tran.getCondition())==null){
							result2.add(null);
						}else{
							if(!(GetMap.get_condMap(tran.getCondition())==null)){
								String tra = tran.getCondition().replace("false", "False").replace("true", "True").replace("->", "$");
								result2 = Result.getResult(tra);
								//result2 = testbdscs.getResult(tra);						
								for(int ii=0;ii<result2.size();ii++){
									//System.out.println("condition���"+ii+"Ϊ:"+result2.get(ii));
								}
							}
						}

					}					
				}

				////////////////////////////////////////////////condition�������///////////////////////////////////////

				//System.out.println("******************************************");
				/////////////////////////////////////////////////////////////////////////////////////



				//
				//System.out.println("result1--->"+result1.size()+"---"+result1);
				//System.out.println("result2--->"+result2.size()+"---"+result2);
				/*if(result1.size()>=0){
					System.out.println("result1--->"+result1.size()+"---"+result1);
					System.out.println("result2--->"+result2.size()+"---"+result2);
				}else{
					//if(result1.size())
						System.out.println("result1===>"+result1.size()+"---"+result1);
					    System.out.println("result2===>"+result2.size()+"---"+result2);
				}*/
				//System.out.println("result1--->"+result1.size()+"---"+result1);
				//System.out.println("result2--->"+result2.size()+"---"+result2);
				////////////////////Ϊinput���������Ľ�
				List<String> result=new ArrayList<String>();//���һ��Ǩ���ϵĽ��
				String res = new String();
				if((result1.toString().equals("[null]"))&&(result2.toString().equals("[null]"))){
					res = sss+"%"+null;
					//res = null;
					result.add(res.toString());
				}else{
					if(!(result1.toString().equals("[null]"))&&(result2.toString().equals("[null]"))){
						for(String ttt2:result1){
							if(ttt2!=null){
								res = sss+"%"+ttt2;
								//res = ttt2;
								result.add(res.toString());
							}
						}
					}
					if((result1.toString().equals("[null]"))&&!(result2.toString().equals("[null]"))){
						for(String ttt3:result2){
							if(ttt3!=null){
								res = sss+"%"+ttt3;
								//res = ttt3;
								result.add(res.toString());
							}
						}
					}
					if(!(result1.toString().equals("[null]"))&&!(result2.toString().equals("[null]"))){
						for(String ttt2:result1){
							for(String ttt3:result2){
								if(ttt2!=null&&ttt3!=null){
									res = sss+"%"+ttt2+","+ttt3;
									//res = ttt2+","+ttt3;
									result.add(res.toString());
								}									
							}
						}
					}
				}	
                System.out.println("result--------------"+result);
				if(result.size()==0){
					//System.out.println("-----------------0000000---------------------");
					//Element input = process.addElement("input");
					//input.setText("��1Ϊ:"+null);
				}else{
					for(int ii=1;ii<=result.size();ii++){
						System.out.println("��"+ii+"Ϊ:"+result.get(ii-1));
						String s = "��"+ii+"Ϊ:"+result.get(ii-1);
						//Element input = process.addElement("input");
						//input.setText(s);
					}					
				}


				cases.add(result);
				////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
			}//for(Transition tran:a.getTransitionSet())

			//cases��ŵ���һ��������������ÿ��Ǩ���ϵĽ⣬result�ŵ���һ��Ǩ���ϵĶ����
			/////
			int numm=1;
			for(int nn=0;nn<cases.size();nn++){
				int n = cases.get(nn).size();
				numm = numm*n;
				//System.out.println("��"+nn+"��Ǩ���Ͻ����Ϊ��"+cases.get(nn).size());
			}
			System.out.println("��"+i+"������·���Ͻ����"+numm);
//			if(num>5000){ //����������������5000������
//				num = 5000;
//			}
			int num=100;//һ��·��100����������
			if(num>numm){   //���һ��·���Ͻ�С��100����ѡȡ��ʵ����
				num = numm;
			}
			for(int n1=0;n1<num;n1++){
				// 4�������ӽڵ㼰�ڵ�����
				Element testcase = tcs.addElement("testcase");
				//System.out.println("---------------------testcase"+n1);
				for(int nn=0;nn<cases.size();nn++){
					//��ӽڵ�
					Element process = testcase.addElement("process");
					Element operation = process.addElement("operation");

					int random = -1;
					if (random == -1) {
						random = new Random().nextInt(cases.get(nn).size());
					}
					//System.out.println("random-->"+random);
					String value = cases.get(nn).get(random);
					//System.out.println("��value-->"+value);
					String[] cs =value.toString().split("%");
					//System.out.println("operation-->"+cs[0]);
					operation.setText(cs[0]);
					Element input = process.addElement("input");
					input.setText(cs[1]);
					//System.out.println("input-->"+cs[1]);
				}
				//System.out.println("---------------------testcase");
				//System.out.println(a.getName());
			}
			////////
			

			//System.out.println("===========================��"+i+"������������ȡ���");
			i++;
		
//			Date date1=new Date();
//			DateFormat format1=new SimpleDateFormat("HH:mm:ss");
//			String time1=format1.format(date1);
//			System.out.println("time---"+time);
//		    System.out.println("time1---"+time1);
//			DateFormat df = new SimpleDateFormat("HH:mm:ss");   
//			try  
//			{   
//			    Date d1 = df.parse(time);   
//			    Date d2 = df.parse(time1);   
//			    long l = d2.getTime() - d1.getTime();   
//			    long day=l/(24*60*60*1000);   
//			    long hour=(l/(60*60*1000)-day*24);   
//			    long min=((l/(60*1000))-day*24*60-hour*60);   
//			    long s=(l/1000-day*24*60*60-hour*60*60-min*60); 
//			    System.out.println("����ʱ�䣺"+ ""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
//			    System.out.println("����ʱ�䣺"+ l);
//			}   
//			catch (Exception e)   
//			{   
//			}
		
		}//for(Automatic a:testCase)

		System.out.println("����������и�����"+testCase.size());

		/////////////////////



		/////////////////////

		OutputFormat format = OutputFormat.createPrettyPrint();
        //6������xml�ļ�
//		File file = new File("C:\\Users\\Administrator\\Desktop\\tcss.xml");
//		File file = new File("E:\\��Ŀ\\xml\\UAVForXStream3.2.1+.xml");m
//		File file = new File("E:\\��Ŀ\\xml\\rc_loopForXStream1.01.xml");
//		File file = new File("E:\\��Ŀ\\xml\\arm_motors_checkForXStream1.01.xml");
//		File file = new File("E:\\��Ŀ\\xml\\UAVForXStream3.3.0.xml");
		File file = new File("E:\\��Ŀ\\xml\\UAVForXStream3.7.0+no_border.xml");
		
		//File file = new File("E:\\��Ŀ\\xml\\UAVForXStream3.5.0.xml");
		//File file = new File("E:\\��Ŀ\\xml\\test.xml");
		//File file = new File("E:\\xml\\tcs2.xml");

		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			writer.write(dom);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		Date date1=new Date();
//		DateFormat format1=new SimpleDateFormat("HH:mm:ss");
//		String time1=format1.format(date1);
//		System.out.println("time---"+time);
//	    System.out.println("time1---"+time1);
//		DateFormat df = new SimpleDateFormat("HH:mm:ss");   
//		try  
//		{   
//		    Date d1 = df.parse(time);   
//		    Date d2 = df.parse(time1);   
//		    long l = d2.getTime() - d1.getTime();   
//		    long day=l/(24*60*60*1000);   
//		    long hour=(l/(60*60*1000)-day*24);   
//		    long min=((l/(60*1000))-day*24*60-hour*60);   
//		    long s=(l/1000-day*24*60*60-hour*60*60-min*60); 
//		    System.out.println("����ʱ�䣺"+ ""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");
//		    System.out.println("����ʱ�䣺"+ l);
//		}   
//		catch (Exception e)   
//		{   
//		}
	}
}
