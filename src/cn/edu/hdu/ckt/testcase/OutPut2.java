package cn.edu.hdu.ckt.testcase;
//ʵ����������  ����map3��OutPut1��д
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.hdu.ckt.handle.Automatic;
import cn.edu.hdu.ckt.handle.GetAutomatic;
import cn.edu.hdu.ckt.handle.StateCoverage__1;
import cn.edu.hdu.ckt.handle.Transition;


public class OutPut2 {

	public static void main(String[] args) {
		//String xml="loop6ForXStream.xml";
		String xml="loopForXStream3.13.xml";
		Automatic auto=GetAutomatic.getAutomatic(xml);//���ԭʼ��ʱ���Զ���
		ArrayList<Automatic> testCase=StateCoverage__1.testCase(auto);//�������״̬���ǵĳ����������
		
		

		//########################################        ���Ĳ�             ###############################################
		//#########################################################################################################
		//=====================================================================��ȡ����״̬���ǵĳ����������
		//======================================================================���ݳ���������������Լ������ʽ
		System.out.println("----------------------------��ȡ����״̬���ǵĲ�������----------------------------");
		System.out.println("===========================���ڻ�ȡ��������");
		System.out.println("===========================");
		System.out.println("===========================���ڴ����������Լ������");
		System.out.println("===========================");
		System.out.println("===========================�������Լ������ʽ");
		System.out.println("===========================");
		System.out.println("===========================���ڽ���ʵ��������");
		System.out.println("===========================");
		System.out.println();
		System.out.println("  ===>  ����������и�����"+testCase.size());

		int i = 1;
		String ttt=null;
		String ttt1=null;
		String ttt2=null;
		String ttt3=null;

		for(Automatic a:testCase){	///////////////////////////////////
			List<String> list=new ArrayList<String>();//�����������ʽ
			List<String> list1=new ArrayList<String>();//���С������ʽ
			int j=1;
			System.out.println();
			System.out.println("===========================���ڶ�ȡ��"+i+"����������");
			System.out.println("  ===>  ������������:"+a.getName());
			for(Transition tran:a.getTransitionSet()){/////////////////////
				System.out.println("       -----------------------------");
				//System.out.println("      ===>  Ǩ��(����)����--->"+tran.getName());
				if(tran.getName().contains("(")){
					int index11=tran.getName().replace("!", "").replace("?", "").indexOf("(");
					String sss=tran.getName().substring(0,index11);
					System.out.println("      ===>  Ǩ��(����)���ƣ�"+sss);
				}
				else{
					System.out.println("      ===>  Ǩ��(����)���ƣ�"+tran.getName().replace("!", "").replace("?", ""));
				}
				
				System.out.println("        ===>  Ǩ��Id��"+tran.getId());								
				System.out.println("        ===>  Դ״̬���ƣ�"+tran.getSource());
//				System.out.println("        ===>  Ŀ��״̬���ƣ�"+tran.getTarget());
				//System.out.println("             ======��"+j+"��Ǩ�ƿ�ʼ======");
				//				System.out.println("--------->��������--------> "+tran.getName());
				//System.out.println(tran.getSource()+"---->"+tran.getTarget()+"Լ���� "+tran.getEventSet());
				//δ�����Լ������	
//				System.out.println("Լ����"+tran.getEventSet());//Լ������ʽ
				/////////////////////////////////////////////////////////////////
				Map<String,String> map = new HashMap<String,String>();
				Map<String,String> map1 = new HashMap<String,String>();
				Map<String,String> map3 = new HashMap<String,String>();
				Map<String,String> map4 = new HashMap<String,String>();//////
				///////////////////////////////////////////////in����ʼ///////////////////////////////////////

				//����in����Ĳ���ʽ�Ͳ������õ��������������һһ��Ӧ��map��������Ӳ���ʽ����
				//System.out.println("========================in========================");	
                //System.out.println("in---->"+tran.getIn());//in���������			
				if(GetMap.get_inMap(tran.getIn())==null){//map����Ϊ�գ���û�в���
					//System.out.println("keySet���ϣ�"+tran.getIn());
				}
				else{//map����ֵ�����в����Ͳ�����Ӧ����
					map3 = GetMap.get_inMap(tran.getIn());
					String cs1 = AddBdsType.getcs(map3);
					String cs2 = AddBdsType.getDoubleCs(map3);
					String cs3 = AddBdsType.getBoolCs(map3);
					//					System.out.println("-----------");
					String s1 = AddBdsType.add_bds(map3);			
					String s2 = AddBdsType.add_doublebds(map3);		
					String bds2=null;
					//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
					String bds0=GetBds.get_bds_0(tran.getIn().toString());

					//�����Ͳ���ʽ�Ͳ���
					String bds1=GetBds.get_bds(tran.getIn().toString());
					


					/////////////////////////////////////
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
							bds1=cs;
							//	System.out.println("��������ʽΪ----->"+cs);

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
							bds2=css;
                            //	System.out.println("С������ʽΪ----->"+css);
						}//if(bds1!=null)
						else{
							if(bds1==null){
								//				System.out.println("��������ʽΪ----->"+null);
								//				System.out.println("С������ʽΪ----->"+null);
							}										
						}												
					}//if(cs2!=null)
					else{
						//û��С������
						//		System.out.println("��������ʽΪ----->"+bds1);
						//		System.out.println("С������ʽΪ----->"+null);

					}
										
					
					//////////////////////



					//////////////////////
					//System.out.println("����------>����ʽ������"+bds1);  //in�����ֲ���ʽ
					//System.out.println("==0------>����ʽ������"+bds0);
					//					System.out.println("����------>����������"+cs1);
					//System.out.println("С��------>����ʽ������"+bds2);
					//					System.out.println("С��------>����������"+cs2);
					//System.out.println("add------>��������ʽΪ��"+s1);
					//System.out.println("add------>С������ʽΪ��"+s2);

					//�����Ͳ���ʽ�Ͳ���
					String boolbds=GetBds.get_boolbds(tran.getIn().toString());
					if(cs3!=null&&boolbds==null){
						boolbds = AddBdsType.add_boolbds(cs3);
					}
                   //System.out.println("������------>����ʽ������"+boolbds);//in�ϲ�������ʽ
					//System.out.println("������------>����������"+cs3);


                     //System.out.println("in�ϲ���ʽ��");

					////////////////////////////////////
					//����mma�����ⷽ����
					if(((bds1==null)&&(cs1==null))&&(bds2==null)&&(s2==null)){
//						System.out.println("        ===>  in��û��Լ����Ϊ��null");
					}
					if((bds1!=null)&&(cs1!=null)){
						String bbb = bds1+","+s1;
//						System.out.println("        ===>  in����������ֵ����ʽ��"+bbb);
                          //System.out.println("        ===>  in����������ֵ������"+cs1);
						String solution1 = Mathematica.getSolution2(bbb, cs1);
						ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt=bbb.toString();
						//System.out.println("in������Լ����Ϊ��"+solution1);
					}
					else{
						if(s1!=null){
//							System.out.println("        ===>  in����������ֵ����ʽ��"+s1);
                             //System.out.println("in����������ֵ������"+cs1);
							String solution1 = Mathematica.getSolution2(s1, cs1);
							ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//System.out.println("in��������Լ����Ϊ��"+solution1);
						}
					}
					if((bds2!=null)&&(s2!=null)){
//						System.out.println("        ===>  in��С������ֵ����ʽ��"+s2);
                        //System.out.println("in��С������ֵ������"+cs2);
						String bb = bds2+","+s2;
						String solution2 = Mathematica.getSolution4(bb, cs2);
						ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt1=s2.toString();
						//System.out.println("in��С����Լ����Ϊ��"+solution2);
					}else{
						if((s2!=null)){
							String solution2 = Mathematica.getSolution4(s2, cs2);
							ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						}
					}
					if(boolbds!=null){
//						System.out.println("        ===>  in�ϲ����͵Ĳ���ʽ��"+boolbds);
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1+","+boolbds;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt+","+boolbds;;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1+","+boolbds;
						}
					}
					else{
						if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
							ttt2=ttt+","+ttt1;
						}
						if((bds1!=null)&&(cs1!=null)&&(s2==null)){
							ttt2=ttt;
						}
						if((bds1==null)&&(cs1==null)&&(s2!=null)){
							ttt2=ttt1;
						}
					}




					//////////////////


				}
				//			System.out.println("===========================in�������===========================");

				//////////////////////////////////////////////in�������//////////////////////////////////////
				//////////////////////////////////////////////out����ʼ///////////////////////////////////////

				//			System.out.println("out---->"+tran.getOut());



				//////////////////////////////////////////////out�������///////////////////////////////////////
				/////////////////////////////////////////////condition����ʼ///////////////////////////////////////
//				System.out.println("--------------------------condition------------------------");
				//Map<String,String> map = new HashMap<String,String>();
				//Map<String,String> map1 = new HashMap<String,String>();
				if(!tran.getCondition().equals("null")){
					tran.getCondition().replaceAll("false", "False").replaceAll("true", "True");				
					if(tran.getCondition().contains("/")){//ȡ/�����

						String conditonValue = tran.getCondition().split("/")[1];//Ҫ����Ĳ���ʽ��
//						System.out.println("          condition/---->"+conditonValue);
						//System.out.println("==================================");
						if(GetMap.get_condMap(conditonValue)==null){          //û��Լ������ʽ
							//							System.out.println("keySet����1��"+GetMap.get_condMap(conditonValue));
						}
						else{                                                 //��Լ������ʽ
							if(!(GetMap.get_condMap(conditonValue)==null)){
								map = GetMap.get_condMap(conditonValue);//�����У�Ҫ���������

								String cs1 = AddBdsType.getcs(map);
								String cs2 = AddBdsType.getDoubleCs(map);
								String cs3 = AddBdsType.getBoolCs(map);
								//								System.out.println("-----------");								
								String s1 = AddBdsType.add_bds(map);
								String s2 = AddBdsType.add_doublebds(map);	
								String bds2=null;

								//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
								//(==0�Ľ�)
								//								String bds0=GetBds.get_bds_0(conditonValue.toString());

								//�����Ͳ���ʽ�Ͳ���
								String bds1=GetBds.get_bds(conditonValue.toString());	
								
								
								
///////////////////////////////////
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
										bds1=cs;
										//								System.out.println("��������ʽΪ----->"+cs);

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
										bds2=css;
										//								System.out.println("С������ʽΪ----->"+css);
									}//if(bds1!=null)
									else{
										if(bds1==null){
											//											System.out.println("��������ʽΪ----->"+null);
											//											System.out.println("С������ʽΪ----->"+null);
										}										
									}
									
									
								}//if(cs2!=null)
								else{
									//û��С������
									//									System.out.println("��������ʽΪ----->"+bds1);
									//									System.out.println("С������ʽΪ----->"+null);

								}
												
							
								//////////////////////
								
								
								
								
								
								
								//////////////////////////////////
//								System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
								//System.out.println("==0------>����ʽ������"+bds0);
								//								System.out.println("����------>����������"+cs1);
//								System.out.println("С��------>����ʽ������"+bds2);
								//								System.out.println("С��------>����������"+cs2);
//								System.out.println("add------>��������ʽΪ��"+s1);
//								System.out.println("add------>С������ʽΪ��"+s2);

								//�����Ͳ���ʽ�Ͳ���
								String boolbds=GetBds.get_boolbds(conditonValue.toString());
								if(cs3!=null&&boolbds==null){
									boolbds = AddBdsType.add_boolbds(cs3);
								}
//								System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ  ==
//								System.out.println("������------>����������"+cs3);

								

								///////////////////////////////////
								//����mma�����ⷽ����
								if(((bds1==null)&&(cs1==null))&&(s2==null)){
//									System.out.println("        ===>  condition��û��Լ����Ϊ��null");
									//input.setText("null");
								}
								if((bds1!=null)&&(cs1!=null)){
									String bbb = bds1+","+s1;
//									System.out.println("        ===>  condition����������ֵ����ʽ��"+bbb);
                                   //System.out.println("        ===>  condition����������ֵ������"+cs1);
									String solution1 = Mathematica.getSolution2(bbb, cs1);
									ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									//ttt=bbb.toString();
									//									System.out.println("condition������Լ����Ϊ��"+solution1);
								}
								else{
									if(s1!=null){
										System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
                                      //System.out.println("        ===>  condition����������ֵ������"+cs1);
										String solution1 = Mathematica.getSolution2(s1, cs1);
										ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt=s1.toString();
										//System.out.println("condition��������Լ����Ϊ��"+solution1);
									}
								}
								if((bds2!=null)&&(s2!=null)){
//									System.out.println("        ===>  condition��С������ֵ����ʽ��"+s2);
                                    //System.out.println("        ===>  condition��С������ֵ������"+cs2);
									String bb = bds2+","+s2;
									String solution2 = Mathematica.getSolution4(bb, cs2);
									ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									//ttt1=s2.toString();
									//									System.out.println("condition��С����Լ����Ϊ��"+solution2);
								}else{
									if((s2!=null)){
										String solution2 = Mathematica.getSolution4(s2, cs2);
										ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
									}
								}
								//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
								if(boolbds!=null){
//									System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1+","+boolbds;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt+","+boolbds;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1+","+boolbds;
									}
								}
								else{
									if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
										ttt3=ttt+","+ttt1;
									}
									if((bds1!=null)&&(cs1!=null)&&(s2==null)){
										ttt3=ttt;
									}
									if((bds1==null)&&(cs1==null)&&(s2!=null)){
										ttt3=ttt1;
									}
								}


								//////////////////


							}
						}

					}
					else{
						if(!tran.getCondition().contains("/")){
//							System.out.println("          condition---->"+tran.getCondition());
							if(GetMap.get_condMap(tran.getCondition())==null){
								//								System.out.println("keySet����3��"+GetMap.get_condMap(tran.getCondition()));
							}
							else{
								if(!(GetMap.get_condMap(tran.getCondition())==null)){
									map1 = GetMap.get_condMap(tran.getCondition());//�����У�Ҫ���������
									//System.out.println("==================================");
									Set<String> set =map1.keySet();

									String cs1 = AddBdsType.getcs(map1);
									String cs2 = AddBdsType.getDoubleCs(map1);
									String cs3 = AddBdsType.getBoolCs(map1);			
									String s1 = AddBdsType.add_bds(map1);
									String s2 = AddBdsType.add_doublebds(map1);
									String bds2=null;

									//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
									String bds0=GetBds.get_bds_0(tran.getCondition().toString());
									//�����Ͳ���ʽ�Ͳ���
									String bds1=GetBds.get_bds(tran.getCondition().toString());					

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
											bds1=cs;
											//									System.out.println("��������ʽΪ----->"+cs);

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
											bds2=css;
											//									System.out.println("С������ʽΪ----->"+css);
										}//if(bds1!=null)
										else{
											if(bds1==null){
												//												System.out.println("��������ʽΪ----->"+null);
												//												System.out.println("С������ʽΪ----->"+null);
											}										
										}
										
									
									}//if(cs2!=null)
									else{
										//û��С������
										//	System.out.println("��������ʽΪ----->"+bds1);
										//	System.out.println("С������ʽΪ----->"+null);

									}
														
								
									/////////
									
									
									
									/////////////////���
                        //         System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ
									//System.out.println("==0------>����ʽ������"+bds0);
									//System.out.println("����------>����������"+cs1);
                         //		System.out.println("С��------>����ʽ������"+bds2);
									//System.out.println("С��------>����������"+cs2);
                        //			System.out.println("add------>��������ʽΪ��"+s1);
                           //				System.out.println("add------>С������ʽΪ��"+s2);

									//�����Ͳ���ʽ�Ͳ���
									String boolbds=GetBds.get_boolbds(tran.getCondition().toString());
									if(cs3!=null&&boolbds==null){
										boolbds = AddBdsType.add_boolbds(cs3);
									}
                            //			System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
                            //			System.out.println("������------>����������"+cs3);


								
									/////////////////////////////////////////
									//����mma�����ⷽ����
									if(((bds1==null)&&(cs1==null))&&(s2==null)){
//										System.out.println("        ===>  condition��û��Լ����Ϊ��null");
										//input.setText("null");
									}
									if((bds1!=null)&&(cs1!=null)){
										String bbb = bds1+","+s1;
//										System.out.println("        ===>  condition����������ֵ����ʽ��"+bbb);
//										System.out.println("        ===>  condition����������ֵ������"+cs1);
										
										String solution1 = Mathematica.getSolution2(bbb, cs1);
										ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt=bbb.toString();
										//										System.out.println("condition������Լ����Ϊ��"+solution1);
									}
									else{
										if(s1!=null){
//											System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
//											System.out.println("        ===>  condition����������ֵ������"+cs1);
											String solution1 = Mathematica.getSolution2(s1, cs1);
											ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
											//ttt=s1.toString();
											//											System.out.println("condition��������Լ����Ϊ��"+solution1);
										}
									}
									if((bds2!=null)&&(s2!=null)){
//										System.out.println("        ===>  condition��С������ֵ����ʽ��"+s2);
//										System.out.println("        ===>  condition��С������ֵ������"+cs2);
										String bb = bds2+","+s2;
										String solution2 = Mathematica.getSolution4(bb, cs2);
										ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										//ttt1=s2.toString();
										//										System.out.println("condition��С����Լ����Ϊ��"+solution2);
									}else{
										if((s2!=null)){
											String solution2 = Mathematica.getSolution4(s2, cs2);
											ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
										}
									}
									//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
									if(boolbds!=null){
//										System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1+","+boolbds;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt+","+boolbds;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1+","+boolbds;
										}
									}
									else{
										if((bds1!=null)&&(cs1!=null)&&(s2!=null)){
											ttt3=ttt+","+ttt1;
										}
										if((bds1!=null)&&(cs1!=null)&&(s2==null)){
											ttt3=ttt;
										}
										if((bds1==null)&&(cs1==null)&&(s2!=null)){
											ttt3=ttt1;
										}
									}


									//////////////////////////////////////


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

//				System.out.println("===========================condition�������===========================");

				////////////////////////////////////////////////condition�������///////////////////////////////////////





//				System.out.println("******************************************");
				/////////////////////////////////////////////////////////////////////////////////////
				//��ӽڵ�
				
				//
				////////////////////Ϊinput���������Ľ�
				if(ttt2==null&&ttt3==null){		
					System.out.println("        ===>  ʵ���������null");
				}
				else{
					if(ttt2!=null&&ttt3!=null){
						ttt3.toString().replaceAll("false", "False").replaceAll("true", "True");
						String x=ttt2+","+ttt3;
						x.toString().replace("false", "False").replace("true", "True");
						System.out.println("        ===>  ʵ���������"+x);
					}
					else{
						if(ttt2==null&&ttt3!=null){
							ttt3.toString().replaceAll("false", "False").replaceAll("true", "True");
							String x=ttt3;
							x.toString().replace("false", "False").replace("true", "True");
							System.out.println("        ===>  ʵ���������"+x);
						}
						else{
							if(ttt2!=null&&ttt3==null){
								String x=ttt2;
								x.toString().replaceAll("false", "False").replaceAll("true", "True");
								System.out.println("        ===>  ʵ���������"+x);
							}
						}
					}
				}

//				System.out.println("******************************************");

				////////////////////////////////////////////////////////////////////////////////////
				//System.out.println("                 ======��"+j+"��Ǩ�ƽ���======");
				j++;
			}
			System.out.println("===========================��"+i+"������������ȡ���");
			i++;
		}
	}


}
