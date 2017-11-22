package cn.edu.hdu.ckt.testcase;
/////����xml�ĵ���������ݽṹ   ������
/////û��ʱ��Լ��
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import cn.edu.hdu.ckt.handle.*;
import org.junit.Test;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;



public class yzsc {
	public static void main(String[] args) {
		String xml="loop10ForXStream.xml";
		//String xml="read_radioForXStream.xml";
		Automatic automatic1=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		Automatic auto=AddType.addType(automatic1);
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������		
		
//======================================================================����״̬���ǵĲ������У������Ӧ���ݽṹ�н���
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
				System.out.println("        ===>  Լ����"+tran.getEventSet());
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
			System.out.println("---------------------------------------------------------");
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//===========================================================================���ڽ���xml�ĵ�
		/*System.out.println("===========================���ڽ���xml�ĵ�");
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
		System.out.println();*/
//========================================================================================xml������Ϣ����
		
		
//=========================================================================================��ȡģ�ͳ�ʼ״̬��Ϣ
		/*System.out.println("===========================���ڻ�ȡ��ʼ״̬��Ϣ");
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
		System.out.println();*/
//========================================================================================ģ�ͳ�ʼ״̬��Ϣ��ȡ����
		
		
//===========================================================================================��ȡģ��״̬�ľ�����Ϣ
		/*System.out.println("===========================���ڻ�ȡ����״̬������Ϣ");
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
		System.out.println();		*/
//=====================================================================================ģ�;���״̬��Ϣ��ȡ����
		
		
		
		
//====================================================================================��ȡģ��Ǩ��(����)��Ϣ
		/*System.out.println("===========================���ڻ�ȡ����Ǩ��(����)������Ϣ");
		System.out.println("===========================");
		System.out.println("  ===>  Ǩ���ܸ�����"+auto.getTransitionSet().size());
		int p=0;
		for(Transition tran:auto.getTransitionSet()){
			System.out.println("    ===>  ��"+p+"��Ǩ��(����)");
			System.out.println("      ===>  Ǩ��(����)���ƣ�"+tran.getName().replace("(", "").replace(")", "").replace("!", "").replace("?", ""));
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
				System.out.println("      ===>  typeID��null");
			}
			else if(tran.getTypeIds().size()==0){
				System.out.println("      ===>  typeID�����գ�����û������");
			}
			else{
				ArrayList<String> typeid=tran.getTypeIds();
				for(String i:typeid){
//					System.out.println("      ===>  typeId��"+i);
				}
			}
			
			if(tran.getTypes()==null){
				System.out.println("      ===>  types��null");
			}
			else if(tran.getTypes().size()==0){
				System.out.println("      ===>  types�����գ�����û������");
			}
			else{
				ArrayList<String> type=tran.getTypes();
				for(String t:type){
//					System.out.println("      ===>  types��"+t);
				}
			}
			
			System.out.println("--------------------------");
		}
		System.out.println();*/
//=======================================================================ģ��Ǩ��(����)��Ϣ��ȡ����	
//=======================================================================��ȡxml����
		
//==========================================����״̬���ǵĲ������У������Ӧ���ݽṹ��====
		/*System.out.println();
		System.out.println("����������и�����"+testCase.size());
		for(Automatic a:testCase){			
			System.out.println("�����������֣�"+a.getName());
			for(Transition tran:a.getTransitionSet()){
				System.out.println("-------------------------------------------------");
				System.out.println("��������--->"+tran.getName());				
			//δ�����Լ������	
				System.out.println("Լ����"+tran.getEventSet());
			//���in�����Լ��
				System.out.println("in---->"+tran.getIn());	
			//���out�����Լ��
				System.out.println("out---->"+tran.getOut());
			//���condition�����Լ��
				System.out.println("get-condition---->"+tran.getCondition());
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����
						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
						System.out.println("//condition//---->"+conditonValue);
					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("condition---->"+tran.getCondition());
						}
					}
				}
				else{
					if(tran.getCondition().equals("null")){
						System.out.println("condition--null-->"+tran.getCondition());	
					}
				}																																									
			}
		}
		try {
			System.setOut(new PrintStream("E��\\xml\\a.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
//=====================����״̬���ǵĲ������У������Ӧ���ݽṹ�н���=======================================	
/*
		//======================================================================��ȡxml�������Ӧ���ݽṹ��
		
		//===========================================================================���ڽ���xml�ĵ�
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
		//========================================================================================xml������Ϣ����
				
				
		//=========================================================================================��ȡģ�ͳ�ʼ״̬��Ϣ
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
		//========================================================================================ģ�ͳ�ʼ״̬��Ϣ��ȡ����
				
				
		//===========================================================================================��ȡģ��״̬�ľ�����Ϣ
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
		//=====================================================================================ģ�;���״̬��Ϣ��ȡ����
				
				
				
				
		//====================================================================================��ȡģ��Ǩ��(����)��Ϣ
				System.out.println("===========================���ڻ�ȡ����Ǩ��(����)������Ϣ");
				System.out.println("===========================");
				System.out.println("  ===>  Ǩ���ܸ�����"+auto.getTransitionSet().size());
				int p=0;
				for(Transition tran:auto.getTransitionSet()){
					System.out.println("    ===>  ��"+p+"��Ǩ��(����)");
					System.out.println("      ===>  Ǩ��(����)���ƣ�"+tran.getName().replace("(", "").replace(")", "").replace("!", "").replace("?", ""));
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
//						for(String e��events){
//							System.out.println("      ===>  �¼���"+e);
//						}								
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
						System.out.println("      ===>  typeID��null");
					}
					else if(tran.getTypeIds().size()==0){
						System.out.println("      ===>  typeID�����գ�����û������");
					}
					else{
						ArrayList<String> typeid=tran.getTypeIds();
						for(String i:typeid){
//							System.out.println("      ===>  typeId��"+i);
						}
					}
					
					if(tran.getTypes()==null){
						System.out.println("      ===>  types��null");
					}
					else if(tran.getTypes().size()==0){
						System.out.println("      ===>  types�����գ�����û������");
					}
					else{
						ArrayList<String> type=tran.getTypes();
						for(String t:type){
//							System.out.println("      ===>  types��"+t);
						}
					}
					
					System.out.println("--------------------------");
				}
				System.out.println();
		//=======================================================================ģ��Ǩ��(����)��Ϣ��ȡ����	
		//=======================================================================��ȡxml����
		
		*/
		
		
		////////////////////////////////////////////////////////////////////////
		
		
	}
}

