package cn.edu.hdu.ckt.testcase;
//���ɲ������� xml�ļ�
import java.util.ArrayList;
import cn.edu.hdu.ckt.handle.*;


import cn.edu.hdu.ckt.testcase.Mathematica;
import org.junit.Test;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class GetXML2 {
	public static void main(String[] args) {
		String xml="loop2ForXStream.xml";//tcs2.xml		
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������		
		System.out.println("����������и�����"+testCase.size());
		int i = 1;
		String ttt=null;
		String ttt1=null;
		// 1������document���󣬴�������xml�ĵ�
		Document dom = DocumentHelper.createDocument();
		// 2���������ڵ�TCS
		org.dom4j.Element tcs = dom.addElement("TCS");
		// 3����TCS�ڵ������version����
		for(Automatic a:testCase){		
			System.out.println();
			System.out.println("������������:"+a.getName());
			System.out.println("============��"+i+"������������ʼ============");
			
			// 4�������ӽڵ㼰�ڵ�����
			Element testcase = tcs.addElement("testcase");
	
			for(Transition tran:a.getTransitionSet()){
				//System.out.println("--------->��������--------> "+tran.getName());
			//δ�����Լ������	
			//System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
			//�����Ͳ���ʽ�Ͳ���
				String bds1=Get_str.get_bds(tran.getEventSet().toString());
				//System.out.println("���ֲ���ʽ:"+bds1);  //һ��Ǩ�������ֲ���ʽ
				String cs1=Get_str.get_cs(bds1);
				//System.out.println("���ֲ���:"+cs1);//һ��Ǩ�������ֲ���ʽ�еĲ���
				//System.out.println("bds---------->"+bds);
            //�����Ͳ���ʽ�Ͳ���
				String boolbds=Get_str.get_bool_bds(tran.getEventSet().toString());
				//System.out.println("��������ʽ:"+boolbds);//һ��Ǩ���ϲ�������ʽ
				String boolcs=Get_str.get_bool_cs(boolbds);
				//System.out.println("��������"+boolcs);//һ��Ǩ���ϲ�������ʽ�еĲ���
		  //==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
				String bds0=Get_str.get_bds_0(tran.getEventSet().toString());
				//System.out.println("==0�Ĳ���ʽ��"+bds0);
				//
				/*if(bds0!=null){
					System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
				}*/
				
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
			/*//����mma�����ⷽ����
				if(((bds1==null)&&(cs1==null))&&(s2==null)){
					System.out.println("û��Լ����Ϊ��null");
					input.setText("null");
				}
				if((bds1!=null)&&(cs1!=null)){
					String bbb = bds1+","+s1;
					System.out.println("*******��ֵ����ʽ*******"+bbb);
					System.out.println("*******��ֵ����*******"+cs1);
					String solution1 = Mathematica.getSolution2(bbb, cs1);
					ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
					System.out.println("condition������Լ����Ϊ��"+solution1);
				}
				else{
					if(s1!=null){
						String solution1 = Mathematica.getSolution2(s1, cs1);
						ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						System.out.println("condition��������Լ����Ϊ��"+solution1);
					}
				}
				if((s2!=null)){
					String solution2 = Mathematica.getSolution4(s2, cs2);
					ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
					System.out.println("condition��С����Լ����Ϊ��"+solution2);
				}
				System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
				if(boolbds!=null){
					System.out.println("condition�ϲ����͵Ĳ���ʽ��Ϊ��"+boolbds);
					if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
						input.setText(ttt+","+ttt1+","+boolbds);
					}
					if((bds1!=null)&&(cs1!=null)(s2==null)){
						input.setText(ttt+","+boolbds);
					}
					if((bds1==null)&&(cs1==null)&&(s2!=null)){
						input.setText(ttt1+","+boolbds);
					}
				}
				else{
					if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
						input.setText(ttt+","+ttt1);
					}
					if((bds1!=null)&&(cs1!=null)&&(s2==null)){
						input.setText(ttt);
					}
					if((bds1==null)&&(cs1==null)&&(s2!=null)){
						input.setText(ttt1);
					}
				}
				*/
			//����mma�����ⷽ����
				//String solution1 = Mathematica2.getSolution2(bds1, cs1);
				//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
				
				
				
				//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				
			}
			System.out.println("============��"+i+"��������������============");
			i++;
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 6������xml�ļ�
	    //File file = new File("C:\\Users\\Administrator\\Desktop\\tcss.xml");
		File file = new File("E:\\��Ŀ\\xml\\tcs_loop.xml");
		//File file = new File("E:\\xml\\tcs2.xml");
		
	    XMLWriter writer;
		try {
			writer = new XMLWriter(new FileOutputStream(file), format);
			writer.write(dom);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}


