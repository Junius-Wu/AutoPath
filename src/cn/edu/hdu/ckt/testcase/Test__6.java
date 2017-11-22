package cn.edu.hdu.ckt.testcase;
//第7个例子，5个测试用例
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
		Automatic auto=GetAutomatic.getAutomatic(xml);//获得原始的时间自动机

		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//获得满足状态覆盖的抽象测试序列
		
		System.out.println("抽象测试序列个数："+testCase.size());
		for(Automatic a:testCase){
			
			System.out.println("测试用例名字:"+a.getName());


			for(Transition tran:a.getTransitionSet()){
				//System.out.println("激励名称"+tran.getName());
				//System.out.println(tran.getSource()+"---->"+tran.getTarget()+"约束： "+tran.getEventSet());
			//未处理的约束条件	
				System.out.println("约束："+tran.getEventSet());
			//数字型不等式和参数
				String bds1=Get_str.get_bds(tran.getEventSet().toString());
				System.out.println(bds1);
				String cs1=Get_str.get_cs(bds1);
				System.out.println(cs1);
				//System.out.println("bds---------->"+bds);
              //布尔型不等式和参数
				String boolbds=Get_str.get_bool_bds(tran.getEventSet().toString());
				System.out.println(boolbds);
				String boolcs=Get_str.get_bool_cs(boolbds);
				System.out.println(boolcs);
			 //==0的不等式即为解 ==换为=
				String bds0=Get_str.get_bds_0(tran.getEventSet().toString());
			
			//调用mma软件求解方程组
				if((bds1!=null)&&(cs1!=null)){
					String solution1 = Mathematica.getSolution2(bds1, cs1);
					System.out.println("$$$$$$$$$$$$$$$$$$"+solution1);
				}
				if((boolbds!=null)&&(boolcs!=null)){
					String solution2 = Mathematica.getSolution3(boolbds, boolcs);
					System.out.println("##################"+solution2);
				}
			//调用mma软件求解方程组
				//String solution1 = Mathematica2.getSolution2(bds1, cs1);
				//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
				
				
			}
			System.out.println("*********************************");
		}
		
		
	
	}

}

