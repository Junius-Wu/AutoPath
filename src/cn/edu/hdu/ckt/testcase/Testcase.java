package cn.edu.hdu.ckt.testcase;
//�������������
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.hdu.ckt.handle.*;


import org.junit.Test;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

public class Testcase {
	public static void main(String[] args) {
		//String xml="loop6ForXStream.xml";
		//String xml="loop6ForXStream.xml";
		String xml="loop10ForXStream.xml";
		//String xml="loop9ForXStream.xml";
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������		
		System.out.println("����������и�����"+testCase.size());
		int i = 1;
		for(Automatic a:testCase){	///////////////////////////////////
			System.out.println();
			System.out.println("������������:"+a.getName());
			List<String> list=new ArrayList<String>();//�����������ʽ
			List<String> list1=new ArrayList<String>();//���С������ʽ
			int j=1;
			System.out.println("==================��"+i+"������������ʼ==================");
			for(Transition tran:a.getTransitionSet()){/////////////////////
				//System.out.println("             ======��"+j+"��Ǩ�ƿ�ʼ======");
				System.out.println("--------->��������--------> "+tran.getName());
				//System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());
				//δ�����Լ������	
				System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				/////////////////////////////////////////////////////////////////
				Map<String,String> map = new HashMap<String,String>();
				Map<String,String> map1 = new HashMap<String,String>();
				Map<String,String> map3 = new HashMap<String,String>();
				Map<String,String> map4 = new HashMap<String,String>();//////
				//////////////////////////in����ʼ///////////////////////////////////////
				
						//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
			//System.out.println("========================in========================");	
			System.out.println("in---->"+tran.getIn());	//in���������			
			if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
//				System.out.println("keySet���ϣ�"+tran.getIn());
			}
			else{//map����ֵ�����в����Ͳ�����Ӧ����
				map3 = GetMap.get_inMap(tran.getIn());
//				Set<String> keySet = map3.keySet();
//				System.out.println("keySet���ϣ�"+keySet);
				String cs1 = AddBdsType.getcs(map3);
				String cs2 = AddBdsType.getDoubleCs(map3);
				String cs3 = AddBdsType.getBoolCs(map3);
//				System.out.println("����in���͵õ�����������ʽ�еĲ���������"+cs1);
//				System.out.println("����in���͵õ���С������ʽ�еĲ���������"+cs2);
//				System.out.println("����in���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);

				System.out.println("-----------");

				String s1 = AddBdsType.add_bds(map3);			
				String s2 = AddBdsType.add_doublebds(map3);
//				System.out.println("����in���������������ʽΪ��"+s1);
//				System.out.println("����in�������С������ʽΪ��"+s2);
				
			 //==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
				String bds0=GetBds.get_bds_0(tran.getIn().toString());

			//�����Ͳ���ʽ�Ͳ���
				String bds1=GetBds.get_bds(tran.getIn().toString());
//				System.out.println("����in���͵õ�����������ʽ�еĲ���ʽ������"+bds1);  //in�����ֲ���ʽ
//				System.out.println("����in���͵õ�����������ʽ�еĲ���������"+cs1);
//				System.out.println("����in���͵õ���С������ʽ�еĲ���ʽ������"+bds1);
//				System.out.println("����in���͵õ���С������ʽ�еĲ���������"+cs2);
//				System.out.println("����in���������������ʽΪ��"+s1);
//				System.out.println("����in�������С������ʽΪ��"+s2);

				System.out.println("����------>����ʽ������"+bds1);  //in�����ֲ���ʽ
				System.out.println("==0------>����ʽ������"+bds0);
				System.out.println("����------>����������"+cs1);
				System.out.println("С��------>����ʽ������");
				System.out.println("С��------>����������"+cs2);
				System.out.println("add------>��������ʽΪ��"+s1);
				System.out.println("add------>С������ʽΪ��"+s2);

            //�����Ͳ���ʽ�Ͳ���
				String boolbds=GetBds.get_boolbds(tran.getIn().toString());
				System.out.println("������------>����ʽ������"+boolbds);//in�ϲ�������ʽ
				System.out.println("������------>����������"+cs3);

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
														if(m==0&&!(x1.contains("==0"))){
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
														if(m==0&&!(x1.contains("==0"))){
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
														if(m==0&&!(bds1.contains("==0"))){
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
														if(m==0&&!(bds1.contains("==0"))){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}
											}
										}
									}//if(bds1!=null)
									else{
										if(bds1==null){
											System.out.println("��������ʽΪ----->"+null);
											System.out.println("С������ʽΪ----->"+null);
										}										
									}
								}//if(cs2!=null)
								else{
									//û��С������
									System.out.println("��������ʽΪ----->"+bds1);
									System.out.println("С������ʽΪ----->"+null);

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
								System.out.println("��������ʽΪ----->"+cs);
								
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
								System.out.println("С������ʽΪ----->"+css);
								/////////
//////////////////
								//�����Ͳ���ʽ�Ͳ���
								//�����Ͳ���ʽ�Ͳ���
								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//����mma�����ⷽ����
								if(((bds1==null)&&(cs1==null))&&(s2==null)){
									System.out.println("inû��Լ����Ϊ��null");
								}
								if((bds1!=null)&&(cs1!=null)){
									String bbb = bds1+","+s1;
									System.out.println("bbb++++++:"+bbb);
									String solution1 = Mathematica.getSolution2(bbb, cs1);
									System.out.println("in������Լ����Ϊ��"+solution1);
									//System.out.println("��ֵ��Լ����Ϊ��");
									//System.out.println(solution1);
								}
								else{
									if(s1!=null){
										String solution1 = Mathematica.getSolution2(s1, cs1);
										System.out.println("in������Լ����Ϊ��"+solution1);
									}
								}
								if((boolbds!=null)&&(s2!=null)){
									String solution2 = Mathematica.getSolution4(s2, cs2);
									System.out.println("inС����Լ����Ϊ��"+solution2);
									//System.out.println("������ֵ��Ϊ��");
									//System.out.println(solution2);
								}
								System.out.println("in������ֵ��Ϊ��"+boolbds);//in�ϲ�������ʽ
								/*if((boolbds!=null)&&(boolcs!=null)){
									String solution2 = Mathematica.getSolution3(boolbds, boolcs);
									System.out.println("in������ֵ��Ϊ��"+solution2);
									//System.out.println("������ֵ��Ϊ��");
									//System.out.println(solution2);
								}*/
							//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=	
								if(bds0!=null){
									System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
								}

								 

								//����mma�����ⷽ����
								//String solution1 = Mathematica2.getSolution2(bds1, cs1);
								//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
								
								
								
								
								
//////////////////

		  

/*
				for (String key : keySet) {
					//System.out.println("key���������ͣ�"+map.get(key));
					System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_inMap(tran.getIn()).get(key));

				}*/

			}
//			System.out.println("===========================in�������===========================");
				 
				///////////////////////////in�������//////////////////////////////////////
				//////////////////////////out����ʼ///////////////////////////////////////

				//			System.out.println("out---->"+tran.getOut());



				//////////////////////////out�������///////////////////////////////////////
				//////////////////////////condition����ʼ///////////////////////////////////////
				System.out.println("--------------------------condition------------------------");
				//Map<String,String> map = new HashMap<String,String>();
				//Map<String,String> map1 = new HashMap<String,String>();
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����

						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
						System.out.println("//condition//---->"+conditonValue);
						//System.out.println("==================================");
						if(GetMap.get_condMap(conditonValue)==null){          //û��Լ������ʽ
							System.out.println("keySet����1��"+GetMap.get_condMap(conditonValue));
						}
						else{                                                 //��Լ������ʽ
							if(!(GetMap.get_condMap(conditonValue)==null)){
								map = GetMap.get_condMap(conditonValue);//�����У�Ҫ���������
								//Set<String> set = map.keySet();
								//Collection<String> coll = map.values();
								//System.out.println("==================================");
								//System.out.println("keyset����2��"+set);
								//System.out.println("------------------values����4��"+coll);

								String cs1 = AddBdsType.getcs(map);
								String cs2 = AddBdsType.getDoubleCs(map);
								String cs3 = AddBdsType.getBoolCs(map);
								//							System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
								//							System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
								//							System.out.println("����condition���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);								
								//							System.out.println("-----------");								
								String s1 = AddBdsType.add_bds(map);
								String s2 = AddBdsType.add_doublebds(map);
								//							System.out.println("����condition���������������ʽΪ��"+s1);
								//							System.out.println("����condition�������С������ʽΪ��"+s2);




								//							for (String key : set) {
								//								//System.out.println("key���������ͣ�"+map.get(key));
								//								System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(conditonValue).get(key));
								//								
								//							}

								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//(==0�Ľ�)
								String bds0=GetBds.get_bds_0(conditonValue.toString());


								//�����Ͳ���ʽ�Ͳ���
								String bds1=GetBds.get_bds(conditonValue.toString());
							//	System.out.println("����condition���͵õ�����������ʽ�еĲ���ʽ������"+bds1);  //condition�����ֲ���ʽ
						//	System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
						//	System.out.println("����condition���͵õ���С������ʽ�еĲ���ʽ������");
						//	System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
						//	System.out.println("����condition���������������ʽΪ��"+s1);
						//	System.out.println("����condition�������С������ʽΪ��"+s2);

								System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
								//System.out.println("==0------>����ʽ������"+bds0);
								System.out.println("����------>����������"+cs1);
								System.out.println("С��------>����ʽ������");
								System.out.println("С��------>����������"+cs2);
								System.out.println("add------>��������ʽΪ��"+s1);
								System.out.println("add------>С������ʽΪ��"+s2);

								//�����Ͳ���ʽ�Ͳ���
								String boolbds=GetBds.get_boolbds(conditonValue.toString());
								System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
								System.out.println("������------>����������"+cs3);

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
														if(m==0&&!(x1.contains("==0"))){
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
														if(m==0&&!(x1.contains("==0"))){
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
														if(m==0&&!(bds1.contains("==0"))){
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
														if(m==0&&!(bds1.contains("==0"))){
															list.add(bds1);//list�����ų���==0����������ʽ
														}
													}
												}
											}
										}
									}//if(bds1!=null)
									else{
										if(bds1==null){
											System.out.println("��������ʽΪ----->"+null);
											System.out.println("С������ʽΪ----->"+null);
										}										
									}
								}//if(cs2!=null)
								else{
									//û��С������
									System.out.println("��������ʽΪ----->"+bds1);
									System.out.println("С������ʽΪ----->"+null);

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
								System.out.println("��������ʽΪ----->"+cs);
								
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
								System.out.println("С������ʽΪ----->"+css);
								/////////

//////////////////
								//�����Ͳ���ʽ�Ͳ���
								//�����Ͳ���ʽ�Ͳ���
								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//����mma�����ⷽ����
								if(((bds1==null)&&(cs1==null))&&(s2==null)){
									System.out.println("conditionû��Լ����Ϊ��null");
								}
								if((bds1!=null)&&(cs1!=null)){
									String bbb = bds1+","+s1;
									System.out.println("bbb++++++:"+bbb);
									String solution1 = Mathematica.getSolution2(bbb, cs1);
									System.out.println("condition������Լ����Ϊ��"+solution1);
									//System.out.println("��ֵ��Լ����Ϊ��");
									//System.out.println(solution1);
								}
								else{
									if(s1!=null){
										String solution1 = Mathematica.getSolution2(s1, cs1);
										System.out.println("condition������Լ����Ϊ��"+solution1);
									}
								}
								if(/*(boolbds!=null)&&*/(s2!=null)){
									String solution2 = Mathematica.getSolution4(s2, cs2);
									System.out.println("conditionС����Լ����Ϊ��"+solution2);
									//System.out.println("������ֵ��Ϊ��");
									//System.out.println(solution2);
								}
								System.out.println("condition������ֵ��Ϊ��"+boolbds);//in�ϲ�������ʽ
								/*if((boolbds!=null)&&(boolcs!=null)){
									String solution2 = Mathematica.getSolution3(boolbds, boolcs);
									System.out.println("in������ֵ��Ϊ��"+solution2);
									//System.out.println("������ֵ��Ϊ��");
									//System.out.println(solution2);
								}*/
							/*//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=	
								if(bds0!=null){
									System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
								}*/

								 

								//����mma�����ⷽ����
								//String solution1 = Mathematica2.getSolution2(bds1, cs1);
								//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
								
								
								
								
								
//////////////////


							}
						}

					}
					else{
						if(!tran.getCondition().contains("/")){
							System.out.println("condition---->"+tran.getCondition());
							if(GetMap.get_condMap(tran.getCondition())==null){
								System.out.println("keySet����3��"+GetMap.get_condMap(tran.getCondition()));
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									map1 = GetMap.get_condMap(tran.getCondition());//�����У�Ҫ���������
									//System.out.println("==================================");
									Set<String> set =map1.keySet();
									//								Collection<String> coll = map1.values();
									//System.out.println("==================================");
									//								System.out.println("keyset����4��"+set);
									//								System.out.println("------------------values���ϣ�"+coll);

									String cs1 = AddBdsType.getcs(map1);
									String cs2 = AddBdsType.getDoubleCs(map1);
									String cs3 = AddBdsType.getBoolCs(map1);
									//								System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
									//								System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
									//								System.out.println("����condition���͵õ��Ĳ����Ͳ���ʽ�еĲ���������"+cs3);									
									//								System.out.println("-----------");									
									String s1 = AddBdsType.add_bds(map1);
									String s2 = AddBdsType.add_doublebds(map1);
									//								System.out.println("����condition���������������ʽΪ��"+s1);
									//								System.out.println("����condition�������С������ʽΪ��"+s2);

									//								for (String key : set) {
									//									//System.out.println("key���������ͣ�"+map.get(key));
									//									System.out.println("|��������|��"+key.trim()+"----->"+"|��������|��"+GetMap.get_condMap(tran.getCondition()).get(key));
									//									
									//								}

									//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
									String bds0=GetBds.get_bds_0(tran.getCondition().toString());
									//�����Ͳ���ʽ�Ͳ���
									String bds1=GetBds.get_bds(tran.getCondition().toString());
						//			System.out.println("����condition���͵õ�����������ʽ�еĲ���ʽ������"+bds1);  //condition�����ֲ���ʽ
						//		System.out.println("����condition���͵õ�����������ʽ�еĲ���������"+cs1);
						//		System.out.println("����condition���͵õ���С������ʽ�еĲ���ʽ������"+bds1);
						//		System.out.println("����condition���͵õ���С������ʽ�еĲ���������"+cs2);
						//		System.out.println("����condition���������������ʽΪ��"+s1);
						//		System.out.println("����condition�������С������ʽΪ��"+s2);

									System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
									//System.out.println("==0------>����ʽ������"+bds0);
									System.out.println("����------>����������"+cs1);
									System.out.println("С��------>����ʽ������");
									System.out.println("С��------>����������"+cs2);
									System.out.println("add------>��������ʽΪ��"+s1);
									System.out.println("add------>С������ʽΪ��"+s2);

									//�����Ͳ���ʽ�Ͳ���
									String boolbds=GetBds.get_boolbds(tran.getCondition().toString());
									System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
									System.out.println("������------>����������"+cs3);


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
															if(m==0&&!(x1.contains("==0"))){
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
															if(m==0&&!(x1.contains("==0"))){
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
															if(m==0&&!(bds1.contains("==0"))){
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
															if(m==0&&!(bds1.contains("==0"))){
																list.add(bds1);//list�����ų���==0����������ʽ
															}
														}
													}
												}
											}
										}//if(bds1!=null)
										else{
											if(bds1==null){
												System.out.println("��������ʽΪ----->"+null);
												System.out.println("С������ʽΪ----->"+null);
											}										
										}
									}//if(cs2!=null)
									else{
										//û��С������
										System.out.println("��������ʽΪ----->"+bds1);
										System.out.println("С������ʽΪ----->"+null);

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
									System.out.println("��������ʽΪ----->"+cs);
									
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
									System.out.println("С������ʽΪ----->"+css);
									/////////
//////////////////
									//�����Ͳ���ʽ�Ͳ���
									//�����Ͳ���ʽ�Ͳ���
									//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
									//����mma�����ⷽ����
									if(((bds1==null)&&(cs1==null))&&(s2==null)){
										System.out.println("conditionû��Լ����Ϊ��null");
									}
									if((bds1!=null)&&(cs1!=null)){
										String bbb = bds1+","+s1;
										System.out.println("bbb++++++:"+bbb);
										String solution1 = Mathematica.getSolution2(bbb, cs1);
										System.out.println("condition������Լ����Ϊ��"+solution1);
										//System.out.println("��ֵ��Լ����Ϊ��");
										//System.out.println(solution1);
									}
									else{
										if(s1!=null){
											String solution1 = Mathematica.getSolution2(s1, cs1);
											System.out.println("condition������Լ����Ϊ��"+solution1);
										}
									}
									if(/*(boolbds!=null)&&*/(s2!=null)){
										String solution2 = Mathematica.getSolution4(s2, cs2);
										System.out.println("conditionС����Լ����Ϊ��"+solution2);
										//System.out.println("������ֵ��Ϊ��");
										//System.out.println(solution2);
									}
									System.out.println("condition������ֵ��Ϊ��"+boolbds);//in�ϲ�������ʽ
									/*if((boolbds!=null)&&(boolcs!=null)){
										String solution2 = Mathematica.getSolution3(boolbds, boolcs);
										System.out.println("in������ֵ��Ϊ��"+solution2);
										//System.out.println("������ֵ��Ϊ��");
										//System.out.println(solution2);
									}*/
								/*//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=	
									if(bds0!=null){
										System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
									}*/

									 

									//����mma�����ⷽ����
									//String solution1 = Mathematica2.getSolution2(bds1, cs1);
									//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);
									
									
									
									
									
	//////////////////
									
									
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

				System.out.println("===========================condition�������===========================");

				//////////////////////////condition�������///////////////////////////////////////









				/*		

			//�����Ͳ���ʽ�Ͳ���
				String bds1=Get_str.get_bds(tran.getEventSet().toString());
				//System.out.println(bds1);  //һ��Ǩ�������ֲ���ʽ
				String cs1=Get_str.get_cs(bds1);
				//System.out.println(cs1);//һ��Ǩ�������ֲ���ʽ�еĲ���
				//System.out.println("bds---------->"+bds);
            //�����Ͳ���ʽ�Ͳ���
				String boolbds=Get_str.get_bool_bds(tran.getEventSet().toString());
				//System.out.println(boolbds);//һ��Ǩ���ϲ�������ʽ
				String boolcs=Get_str.get_bool_cs(boolbds);
				//System.out.println(boolcs);//һ��Ǩ���ϲ�������ʽ�еĲ���
		   //==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
				String bds0=Get_str.get_bds_0(tran.getEventSet().toString());
				//
				if(bds0!=null){
					System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
				}

			//����mma�����ⷽ����
				if(((bds1==null)&&(cs1==null))&&((boolbds==null)&&(boolcs==null))){
					System.out.println("û��Լ����Ϊ��null");
				}
				if((bds1!=null)&&(cs1!=null)){
					String solution1 = Mathematica.getSolution2(bds1, cs1);
					System.out.println("��ֵ��Լ����Ϊ��"+solution1);
					//System.out.println("��ֵ��Լ����Ϊ��");
					//System.out.println(solution1);
				}
				if((boolbds!=null)&&(boolcs!=null)){
					String solution2 = Mathematica.getSolution3(boolbds, boolcs);
					System.out.println("������ֵ��Ϊ��"+solution2);
					//System.out.println("������ֵ��Ϊ��");
					//System.out.println(solution2);
				}
			//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=	
				if(bds0!=null){
					System.out.println("==0�Ĳ���ʽ��Ϊ��"+bds0);
				}

				 */

				//����mma�����ⷽ����
				//String solution1 = Mathematica2.getSolution2(bds1, cs1);
				//String solution2 = Mathematica2.getSolution3(boolbds, boolcs);

				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
			}
			//System.out.println("==================��"+i+"��������������==================");
			i++;
		}



	}

}


