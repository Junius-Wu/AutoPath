package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class get_bdscs {


	/**
	 * ȡin����Ĳ��������Ͷ�Ӧ��map
	 * @param tran
	 * @return
	 */
	public static Map<String,String> get_inMap(String ins){
		List<String> list1=new ArrayList<String>(); //�����ֵ�Ͳ���ʽ
		List<String> list2=new ArrayList<String>(); //��Ų����Ͳ���ʽ
		List<String> list3=new ArrayList<String>(); //���==0�Ĳ���ʽ
		List<String> cs1=new ArrayList<String>();//�����ֵ�Ͳ���
		List<String> cs2=new ArrayList<String>();//��Ų����Ͳ���
		List<String> cs3=new ArrayList<String>();//���==0�Ĳ���

		Map<String,String> map = new HashMap<String,String>();//ӳ�����������֮���ϵ
		int i=0;
		if(ins==null){  //in����Ϊ��
			return null;
		}
		else{
			if(ins!=null){ //in���治Ϊ��
				if(ins.contains("#")){////////////////////////////////////////////////#���ֲ���ʽ�Ͳ�������
					String[] s = ins.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
					String sbds = s[0].replace("&&", ",").replace("||", ",").replace(" ", "")/*.replace("(", "").replace(")", "")*/;//���in�еĲ���ʽ
					String stype = s[1];               //���in�в���������

					if(stype!=null&&stype.contains(",")){///////////////////////////////��ֹһ������
						String[] intype = stype.split(",");
						if(sbds.contains(",")){  ////////////////////////////��ֹһ������ʽ�Ҳ�ֹһ������
							String[] inbds = sbds.split(",");
							for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
								//����Լ����Χ�Ĳ���ʽ ��  x<3��y>z    #int,double,int
								if(str.contains("<")||str.contains(">")||str.contains("=")){
									String cs= getcs(str);
									if(cs!=null){
										if(cs.contains(",")){//һ������ʽ�в�ֹһ������
											if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
												list1.add(str);  // ��ֵ��
												String[] ccs=cs.split(",");
												for(String ss:ccs){
													if(ss!=null){
														cs1.add(ss);
														map.put(ss, intype[i]);
														i++;
													}
												}
											}
											else{
												if(str.contains("True")||str.contains("False")){
													list2.add(str);  // ������
													//cs2.add(cs);
													String[] ccs=cs.split(",");
													for(String ss:ccs){
														if(ss!=null){
															cs2.add(ss);
															map.put(ss, intype[i]);
															i++;
														}
													}
												}
												else{
													if(str.contains("==0")){
														list3.add(str); // ==0��
														//cs3.add(cs);
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs1.add(ss);
																map.put(ss, intype[i]);
																i++;
															}
														}
													}
												}
											}

										}
										else{//һ������ʽ��ֻ��һ������
											if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
												if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
													list1.add(str);  // ��ֵ��
													cs1.add(cs);
													map.put(cs, intype[i]);
													i++;
												}
												else{
													if(str.contains("True")||str.contains("False")){
														list2.add(str);  // ������
														cs2.add(cs);
														map.put(cs, intype[i]);
														i++;
													}
													else{
														if(str.contains("==0")){
															list3.add(str); // ==0��
															cs3.add(cs);
															map.put(cs, intype[i]);
															i++;
														}
													}
												}
											}
										}
									}
									/*else{//����Ϊ�գ���û�в���ʽ
								                       }	*/						
								}						
								else{//һ������ʽ��   û����ȷԼ��  ��  x#int   
									String cs= str;
									cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
									map.put(cs, intype[i]);
									i++;
								}
							}//for(String str:inbds)
						}//if(sbds.contains(","))
						else{//////////////////////////////ֻ��һ������ʽ,��ֹһ������
							//����Լ����Χ�Ĳ���ʽ ��  x<y#int,double
							if(!sbds.contains(",")){
								if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
									String cs= getcs(sbds);
									if(cs!=null){
										if(cs.contains(",")){//һ������ʽ�в�ֹһ������
											if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
												list1.add(sbds);  // ��ֵ��
												String[] ccs=cs.split(",");
												for(String ss:ccs){
													if(ss!=null){
														cs1.add(ss);
														map.put(ss, intype[i]);
														i++;
													}
												}
											}
											else{
												if(sbds.contains("True")||sbds.contains("False")){
													list2.add(sbds);  // ������
													//cs2.add(cs);
													String[] ccs=cs.split(",");
													for(String ss:ccs){
														if(ss!=null){
															cs2.add(ss);
															map.put(ss, intype[i]);
															i++;
														}
													}
												}
												else{
													if(sbds.contains("==0")){
														list3.add(sbds); // ==0��
														//cs3.add(cs);
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs1.add(ss);
																map.put(ss, intype[i]);
																i++;
															}
														}
													}
												}
											}

										}
										else{
											if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
												if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
													list1.add(sbds);  // ��ֵ��
													cs1.add(cs);
													map.put(cs, intype[i]);
													i++;
												}
												else{
													if(sbds.contains("True")||sbds.contains("False")){
														list2.add(sbds);  // ������
														cs2.add(cs);
														map.put(cs, intype[i]);
														i++;
													}
													else{
														if(sbds.contains("==0")){
															list3.add(sbds); // ==0��
															cs3.add(cs);
															map.put(cs, intype[i]);
															i++;
														}
													}
												}
											}
										}
									}
									/*else{//����Ϊ�գ���û�в���ʽ

								}	*/						
								}						
								else{//û����ȷԼ��  ��  x#int
									String cs= sbds;
									cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
									map.put(cs, intype[i]);
									i++;
								}
							}

							////////////////////////////
						}
					}//if(stype!=null&&stype.contains(","))
					else{
						if(stype!=null&&!stype.contains(",")){//  ֻ��һ������
							if(sbds.contains(",")){   ////////////////////////////�������ʽ��һ������
								String[] inbds = sbds.split(",");
								for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
									//����Լ����Χ�Ĳ���ʽ ��  x<5,cycle==10ms#int    x,cycle==10ms#int
									if(str.contains("<")||str.contains(">")||str.contains("=")){
										String cs= getcs(str);
										if(cs!=null&&!cs.contains(",")){
											if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
												list1.add(str);  // ��ֵ��
												cs1.add(cs);
												map.put(cs, stype);
											}
											else{
												if(str.contains("True")||str.contains("False")){
													list2.add(str);  // ������
													cs2.add(cs);
													map.put(cs, stype);
												}
												else{
													if(str.contains("==0")){
														list3.add(str); // ==0��
														cs3.add(cs);
														map.put(cs, stype);
													}
												}
											}
										}
									}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
									else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
										if(!(str.contains("<")||str.contains(">")||str.contains("="))){
											list1.add(str);
											cs1.add(str);
											map.put(str, stype);
										}
									}
								}
							}
							else{
								if(!sbds.contains(",")){////////////һ������ʽ��һ������
									//����Լ����Χ�Ĳ���ʽ ��  x<5#int    x#int
									if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
										String cs= getcs(sbds);
										if(cs!=null&&!cs.contains(",")){
											if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
												list1.add(sbds);  // ��ֵ��
												cs1.add(cs);
												map.put(cs, stype);
											}
											else{
												if(sbds.contains("True")||sbds.contains("False")){
													list2.add(sbds);  // ������
													cs2.add(cs);
													map.put(cs, stype);
												}
												else{
													if(sbds.contains("==0")){
														list3.add(sbds); // ==0��
														cs3.add(cs);
														map.put(cs, stype);
													}
												}
											}
										}
									}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
									else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
										if(!(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))){
											list1.add(sbds);
											cs1.add(sbds);
											map.put(sbds, stype);
										}
									}
								}
							}

						}//if(stype!=null&&!stype.contains(","))												
					}
				}//if(ins.contains("#"))
				/*else{//����# ��û�в���

				}*/
			}//if(ins!=null)
			return map;


		}
	}

	/**
	 * ȡcondition����Ĳ��������Ͷ�Ӧ��map
	 * @param tran
	 * @return
	 */

	public static Map<String,String> get_condMap(String condition){
		List<String> list1=new ArrayList<String>(); //�����ֵ�Ͳ���ʽ
		List<String> list2=new ArrayList<String>(); //��Ų����Ͳ���ʽ
		List<String> list3=new ArrayList<String>(); //���==0�Ĳ���ʽ
		List<String> cs1=new ArrayList<String>();//�����ֵ�Ͳ���
		List<String> cs2=new ArrayList<String>();//��Ų����Ͳ���
		List<String> cs3=new ArrayList<String>();//���==0�Ĳ���

		Map<String,String> map = new HashMap<String,String>();//ӳ�����������֮���ϵ
		int i=0;
		if(condition==null){  //condition����Ϊ��
			return null;
		}
		else{
			if(condition.contains("--")&&condition!=null){
				condition.replace("false", "False").replace("true", "True").replace("&&", ",")/*.replace("(", "").replace(")", "")*/;
				String[] condition1=condition.split("--");
				for(String condition2:condition1){
//					
					System.out.println("condition2��--�ֿ���Ĳ���ʽ��"+condition2);
					i=0;
					if(condition2!=null){ //condition���治Ϊ��
						if(condition2.contains("#")){////////////////////////////////////////////////#���ֲ���ʽ�Ͳ�������
							System.out.println("--�ֿ����condition�ﺬ��#");
							String[] s = condition2.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
							String sbds = s[0].replace("&&", ",")/*.replace("||", ",")*/.replace(" ", "")/*.replace("(", "").replace(")", "")*/;//���in�еĲ���ʽ
							String stype = s[1];               //���condition�в���������
//
							System.out.println("#ǰ����ʽ��"+sbds);
//
							System.out.println("#��������ͣ�"+stype);

							if(stype!=null&&stype.contains(",")){///////////////////////////////��ֹһ������
								
								String[] intype = stype.split(",");
								if(sbds.contains(",")){  //////////////////////////////��ֹһ������ʽ�Ҳ�ֹһ������
//
									System.out.println("�������ʽ������������ܲ���ʽΪ��"+sbds);
									String[] inbds = sbds.split(",");
									for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
										//����Լ����Χ�Ĳ���ʽ ��  x<3��y>z    #int,double,int
										if(str.contains("<")||str.contains(">")||str.contains("=")){
											String cs= getcs(str);
//  //
											System.out.println("���ֿ�����ֵ����ʽΪ��"+str);
											System.out.println("���ֿ�����ֵ����Ϊ��"+cs);
											System.out.println("�Բ������з��������޶��ţ�����map��-------------");
											if(cs!=null){
												if(cs.contains(",")){//һ������ʽ�в�ֹһ������
													if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
														list1.add(str);  // ��ֵ��
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs1.add(ss);
																map.put(ss, intype[i]);
																//System.out.println("i1:"+i);
																i++;
															}
														}
													}
													else{
														if(str.contains("True")||str.contains("False")){
															list2.add(str);  // ������
															//cs2.add(cs);
															String[] ccs=cs.split(",");
															for(String ss:ccs){
																if(ss!=null){
																	cs2.add(ss);
																	map.put(ss, intype[i]);
																	//System.out.println("i2:"+i);
																	i++;
																}
															}
														}
														else{
															if(str.contains("==0")){
																list3.add(str); // ==0��
																//cs3.add(cs);
																String[] ccs=cs.split(",");
																for(String ss:ccs){
																	if(ss!=null){
																		cs1.add(ss);
																		map.put(ss, intype[i]);

																		//System.out.println("i3:"+i);
																		i++;
																	}
																}
															}
														}
													}

												}
												else{//һ������ʽ��ֻ��һ������
//
													System.out.println("һ������ʽһ������������ʽΪ��"+str);
													System.out.println("һһ������Ϊ��"+cs);
													System.out.println("�Բ������з��������޶��ţ�����map��-------------");
													if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
														if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
															list1.add(str);  // ��ֵ��
															cs1.add(cs);
															map.put(cs, intype[i]);
															//System.out.println("i4:"+i);
															i++;
														}
														else{
															if(str.contains("True")||str.contains("False")){
																list2.add(str);  // ������
																cs2.add(cs);
																map.put(cs, intype[i]);
																//System.out.println("i5:"+i);
																i++;
															}
															else{
																if(str.contains("==0")){
																	list3.add(str); // ==0��
																	cs3.add(cs);
																	map.put(cs, intype[i]);
																	//System.out.println("i6:"+i);
																	i++;
																}
															}
														}
													}
												}
											}
											/*else{//����Ϊ�գ���û�в���ʽ
										                       }	*/						
										}						
										else{//һ������ʽ��   û����ȷԼ��  ��  x#int
//											
											System.out.println("һ������ʽ��û����ȷԼ����x#int---------------");
											
											System.out.println("����Ϊ����ʽ������map��-------------");
											String cs= str;
											cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
											map.put(cs, intype[i]);
											//System.out.println("i7:"+i);
											i++;
										}
									}//for(String str:inbds)
								}//if(sbds.contains(","))
								else{//////////////////////////////ֻ��һ������ʽ,��ֹһ������
//
									System.out.println("һ������ʽ������������ܲ���ʽΪ��"+sbds);
									//����Լ����Χ�Ĳ���ʽ ��  x<y#int,double
									if(!sbds.contains(",")){
										if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
											String cs= getcs(sbds);
//
											System.out.println("һ������ʽ�в���Ϊ��"+cs+"----------�Բ��������Ƿ���");
											System.out.println("�Բ������з��������޶��ţ�����map��-------------");
											if(cs!=null){
												if(cs.contains(",")){//һ������ʽ�в�ֹһ������
//
													System.out.println("һ������ʽ���������������ʽΪ��"+sbds+"----����Ϊ��"+cs);
													if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
														list1.add(sbds);  // ��ֵ��
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs1.add(ss);
																//System.out.println("ss:"+ss);
																//System.out.println("i8:"+i);
																//System.out.println("intype[i]:"+intype[i]);
																map.put(ss, intype[i]);/////
																i++;
															}
														}
													}
													else{
														if(sbds.contains("True")||sbds.contains("False")){
															list2.add(sbds);  // ������
															//cs2.add(cs);
															String[] ccs=cs.split(",");
															for(String ss:ccs){
																if(ss!=null){
																	cs2.add(ss);
																	map.put(ss, intype[i]);
																	//System.out.println("i9:"+i);
																	i++;
																}
															}
														}
														else{
															if(sbds.contains("==0")){
																list3.add(sbds); // ==0��
																//cs3.add(cs);
																String[] ccs=cs.split(",");
																for(String ss:ccs){
																	if(ss!=null){
																		cs1.add(ss);
																		map.put(ss, intype[i]);
																		//System.out.println("i10:"+i);
																		i++;
																	}
																}
															}
														}
													}

												}
												else{
													if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
//
														System.out.println("һ������ʽ��һ���������ܲ���ʽΪ��"+sbds);
														if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
															list1.add(sbds);  // ��ֵ��
															cs1.add(cs);
															map.put(cs, intype[i]);
															//System.out.println("i11:"+i);
															i++;
														}
														else{
															if(sbds.contains("True")||sbds.contains("False")){
																list2.add(sbds);  // ������
																cs2.add(cs);
																map.put(cs, intype[i]);
																//System.out.println("i12:"+i);
																i++;
															}
															else{
																if(sbds.contains("==0")){
																	list3.add(sbds); // ==0��
																	cs3.add(cs);
																	map.put(cs, intype[i]);
																	//System.out.println("i13:"+i);
																	i++;
																}
															}
														}
													}
												}
											}
											/*else{//����Ϊ�գ���û�в���ʽ

										}	*/						
										}						
										else{//û����ȷԼ��  ��  x#int
//
											System.out.println("һ������ʽ��û����ȷԼ����x#int---------------");											
											System.out.println("����Ϊ����ʽ������map��-------------");
											String cs= sbds;
											cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
											map.put(cs, intype[i]);
											//System.out.println("i14:"+i);
											i++;
										}
									}

									////////////////////////////
								}
							}//if(stype!=null&&stype.contains(","))
							else{
								if(stype!=null&&!stype.contains(",")){//  ֻ��һ������
									if(sbds.contains(",")){   ////////////////////////////�������ʽ��һ������
//
										System.out.println("�������ʽ��һ������������ʽΪ��"+sbds);
										String[] inbds = sbds.split(",");
										for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
											//����Լ����Χ�Ĳ���ʽ ��  x<5,cycle==10ms#int    x,cycle==10ms#int
											if(str.contains("<")||str.contains(">")||str.contains("=")){
												String cs= getcs(str);
//
												System.out.println("�������ʽ��һ������������Ϊ��"+cs);
												if(cs!=null&&!cs.contains(",")){
													if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
														list1.add(str);  // ��ֵ��
														cs1.add(cs);
														map.put(cs, stype);
													}
													else{
														if(str.contains("True")||str.contains("False")){
															list2.add(str);  // ������
															cs2.add(cs);
															map.put(cs, stype);
														}
														else{
															if(str.contains("==0")){
																list3.add(str); // ==0��
																cs3.add(cs);
																map.put(cs, stype);
															}
														}
													}
												}
											}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
											else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
												if(!(str.contains("<")||str.contains(">")||str.contains("="))){
//
													System.out.println("һ������ʽ��û����ȷԼ����x#int---------------");											
													System.out.println("����Ϊ����ʽ������map��-------------");
													list1.add(str);
													cs1.add(str);
													map.put(str, stype);
												}
											}
										}
									}
									else{
										if(!sbds.contains(",")){////////////һ������ʽ��һ������
											System.out.println("һ������ʽ��һ������,����ʽΪ��"+sbds);
											//����Լ����Χ�Ĳ���ʽ ��  x<5#int    x#int
											if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
												String cs= getcs(sbds);
//
												System.out.println("�о���Լ���Ĳ���Ϊ��"+cs);
												if(cs!=null&&!cs.contains(",")){
													if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
														list1.add(sbds);  // ��ֵ��
														cs1.add(cs);
														map.put(cs, stype);
													}
													else{
														if(sbds.contains("True")||sbds.contains("False")){
															list2.add(sbds);  // ������
															cs2.add(cs);
															map.put(cs, stype);
														}
														else{
															if(sbds.contains("==0")){
																list3.add(sbds); // ==0��
																cs3.add(cs);
																map.put(cs, stype);
															}
														}
													}
												}
											}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
											else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
												System.out.println("û�о���Լ��������ʽΪ����"+sbds);
												if(!(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))){
													list1.add(sbds);
													cs1.add(sbds);
													map.put(sbds, stype);
												}
											}
										}
									}

								}//if(stype!=null&&!stype.contains(","))												
							}
						}//if(condition2.contains("#"))
						/*else{//����# ��û�в���

						}*/
					}//if(condition2!=null)
				}//for(String condition2:condition1)
			}//if(condition.contains("--")&&condition!=null)
			else{
				if(!condition.contains("--")&&condition!=null){//condition���治Ϊ��
					i=0;
					System.out.println("condition��û��--����ֻҪһ������ʽ������ʽΪ"+condition);
					if(condition.contains("#")){////////////////////////////////////////////////#���ֲ���ʽ�Ͳ�������
						String[] s = condition.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
						String sbds = s[0].replace("&&", ",").replace("||", ",").replace(" ", "").replace("(", "").replace(")", "");//���in�еĲ���ʽ
						String stype = s[1];               //���condition�в���������
						//System.out.println("����ʽ��"+sbds);
						//System.out.println("�������ͣ�"+stype);

						if(stype!=null&&stype.contains(",")){///////////////////////////////��ֹһ������
							String[] intype = stype.split(",");
							if(sbds.contains(",")){  ////////////////////////////��ֹһ������ʽ�Ҳ�ֹһ������
								String[] inbds = sbds.split(",");
								for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
									//����Լ����Χ�Ĳ���ʽ ��  x<3��y>z    #int,double,int
									if(str.contains("<")||str.contains(">")||str.contains("=")){
										String cs= getcs(str);
										System.out.println("��ֵ����Ϊ��"+cs);
										if(cs!=null){
											if(cs.contains(",")){//һ������ʽ�в�ֹһ������
												if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
													list1.add(str);  // ��ֵ��
													String[] ccs=cs.split(",");
													for(String ss:ccs){
														if(ss!=null){
															cs1.add(ss);
															map.put(ss, intype[i]);
															//System.out.println("i1:"+i);
															i++;
														}
													}
												}
												else{
													if(str.contains("True")||str.contains("False")){
														list2.add(str);  // ������
														//cs2.add(cs);
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs2.add(ss);
																map.put(ss, intype[i]);
																//System.out.println("i2:"+i);
																i++;
															}
														}
													}
													else{
														if(str.contains("==0")){
															list3.add(str); // ==0��
															//cs3.add(cs);
															String[] ccs=cs.split(",");
															for(String ss:ccs){
																if(ss!=null){
																	cs1.add(ss);
																	map.put(ss, intype[i]);

																	//System.out.println("i3:"+i);
																	i++;
																}
															}
														}
													}
												}

											}
											else{//һ������ʽ��ֻ��һ������
												if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
													if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
														list1.add(str);  // ��ֵ��
														cs1.add(cs);
														map.put(cs, intype[i]);
														//System.out.println("i4:"+i);
														i++;
													}
													else{
														if(str.contains("True")||str.contains("False")){
															list2.add(str);  // ������
															cs2.add(cs);
															map.put(cs, intype[i]);
															//System.out.println("i5:"+i);
															i++;
														}
														else{
															if(str.contains("==0")){
																list3.add(str); // ==0��
																cs3.add(cs);
																map.put(cs, intype[i]);
																//System.out.println("i6:"+i);
																i++;
															}
														}
													}
												}
											}
										}
										else{//����Ϊ�գ���û�в���ʽ
										                       }							
									}						
									else{//һ������ʽ��   û����ȷԼ��  ��  x#int   
										String cs= str;
										cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
										map.put(cs, intype[i]);
										//System.out.println("i7:"+i);
										i++;
									}
								}//for(String str:inbds)
							}//if(sbds.contains(","))
							else{//////////////////////////////ֻ��һ������ʽ,��ֹһ������
								//����Լ����Χ�Ĳ���ʽ ��  x<y#int,double
								if(!sbds.contains(",")){
									if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
										String cs= getcs(sbds);
										if(cs!=null){
											if(cs.contains(",")){//һ������ʽ�в�ֹһ������
												if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
													list1.add(sbds);  // ��ֵ��
													String[] ccs=cs.split(",");
													for(String ss:ccs){
														if(ss!=null){
															cs1.add(ss);
															//System.out.println("ss:"+ss);
															//System.out.println("i8:"+i);
															//System.out.println("intype[i]:"+intype[i]);
															map.put(ss, intype[i]);/////
															i++;
														}
													}
												}
												else{
													if(sbds.contains("True")||sbds.contains("False")){
														list2.add(sbds);  // ������
														//cs2.add(cs);
														String[] ccs=cs.split(",");
														for(String ss:ccs){
															if(ss!=null){
																cs2.add(ss);
																map.put(ss, intype[i]);
																//System.out.println("i9:"+i);
																i++;
															}
														}
													}
													else{
														if(sbds.contains("==0")){
															list3.add(sbds); // ==0��
															//cs3.add(cs);
															String[] ccs=cs.split(",");
															for(String ss:ccs){
																if(ss!=null){
																	cs1.add(ss);
																	map.put(ss, intype[i]);
																	//System.out.println("i10:"+i);
																	i++;
																}
															}
														}
													}
												}

											}
											else{
												if(!cs.contains(",")){//һ������ʽ��ֻ��һ������
													if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
														list1.add(sbds);  // ��ֵ��
														cs1.add(cs);
														map.put(cs, intype[i]);
														//System.out.println("i11:"+i);
														i++;
													}
													else{
														if(sbds.contains("True")||sbds.contains("False")){
															list2.add(sbds);  // ������
															cs2.add(cs);
															map.put(cs, intype[i]);
															//System.out.println("i12:"+i);
															i++;
														}
														else{
															if(sbds.contains("==0")){
																list3.add(sbds); // ==0��
																cs3.add(cs);
																map.put(cs, intype[i]);
																//System.out.println("i13:"+i);
																i++;
															}
														}
													}
												}
											}
										}
										else{//����Ϊ�գ���û�в���ʽ

										}							
									}						
									else{//û����ȷԼ��  ��  x#int
										String cs= sbds;
										cs1.add(cs);//Ĭ�ϲ�����ڲ����Ͳ���û����Լ��
										map.put(cs, intype[i]);
										//System.out.println("i14:"+i);
										i++;
									}
								}

								////////////////////////////
							}
						}//if(stype!=null&&stype.contains(","))
						else{
							if(stype!=null&&!stype.contains(",")){//  ֻ��һ������
								if(sbds.contains(",")){   ////////////////////////////�������ʽ��һ������
									String[] inbds = sbds.split(",");
									for(String str:inbds){     ///���һ��һ���Ĳ���ʽ
										//����Լ����Χ�Ĳ���ʽ ��  x<5,cycle==10ms#int    x,cycle==10ms#int
										if(str.contains("<")||str.contains(">")||str.contains("=")){
											String cs= getcs(str);
											if(cs!=null&&!cs.contains(",")){
												if(!(str.contains("==0")||str.contains("True")||str.contains("False"))){
													list1.add(str);  // ��ֵ��
													cs1.add(cs);
													map.put(cs, stype);
												}
												else{
													if(str.contains("True")||str.contains("False")){
														list2.add(str);  // ������
														cs2.add(cs);
														map.put(cs, stype);
													}
													else{
														if(str.contains("==0")){
															list3.add(str); // ==0��
															cs3.add(cs);
															map.put(cs, stype);
														}
													}
												}
											}
										}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
										else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
											if(!(str.contains("<")||str.contains(">")||str.contains("="))){
												list1.add(str);
												cs1.add(str);
												map.put(str, stype);
											}
										}
									}
								}
								else{
									if(!sbds.contains(",")){////////////һ������ʽ��һ������
										//����Լ����Χ�Ĳ���ʽ ��  x<5#int    x#int
										if(sbds.contains("<")||sbds.contains(">")||sbds.contains("=")){
											String cs= getcs(sbds);
											if(cs!=null&&!cs.contains(",")){
												if(!(sbds.contains("==0")||sbds.contains("True")||sbds.contains("False"))){
													list1.add(sbds);  // ��ֵ��
													cs1.add(cs);
													map.put(cs, stype);
												}
												else{
													if(sbds.contains("True")||sbds.contains("False")){
														list2.add(sbds);  // ������
														cs2.add(cs);
														map.put(cs, stype);
													}
													else{
														if(sbds.contains("==0")){
															list3.add(sbds); // ==0��
															cs3.add(cs);
															map.put(cs, stype);
														}
													}
												}
											}
										}//if(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))
										else{//û�о���Լ���Ĵ�һ�������Ĳ���ʽ
											if(!(sbds.contains("<")||sbds.contains(">")||sbds.contains("="))){
												list1.add(sbds);
												cs1.add(sbds);
												map.put(sbds, stype);
											}
										}
									}
								}

							}//if(stype!=null&&!stype.contains(","))												
						}
					}//if(condition2.contains("#"))
					else{//����# ��û�в���

						}






				}
			}

			return map;


		}
	}








	/**
	 * ȡһ������ʽ�еĲ���	
	 * @param s
	 * @return
	 */
	public static String getcs(String s){
		String c1=new String();
		String cs=new String(); //���ڷ��ز�����
		String s1=new String();//��ȡ��һ������ʽ���ַ�
		String s2=new String();
		String s3=new String();
		String s4=new String();
		List<String> list=new ArrayList<String>();   //��Ų���
		if((s!=null)&&!(s.contains("cycle"))){
			String a = s.replace("(", "").replace(")", "").replace("true", "True").replace("false", "False");
			//���ж��Ƿ񺬲�����
			if(a.contains("True")||a.contains("False")){
				if(a.contains("==")){
					int index1=a.indexOf("=");
					s1=a.substring(0,index1);//==ǰ���
					if(!(s1.contains("True")||s1.contains("False"))){
						list.add(s1);
					}
					s2=a.substring(index1+2,a.length());//==�����
					if(!(s2.contains("True")||s2.contains("False"))){
						list.add(s2);
					}
				}			 
			}
			//���ǲ����Ͳ���ʽ��������ֵ�Ͳ���ʽ
			else{
				int ss1=a.substring(0, 1).toCharArray()[0];
				if(!((ss1>=48&&ss1<=57)||ss1==45)){//��һ��Ϊ����
					if(a.contains("<=")){  ///////��������<=
						int index1=a.indexOf("<");
						s1=a.substring(0,index1);//��һ��<=ǰ���
						list.add(s1);
						s2=a.substring(index1+2,a.length());//��һ��<=�����
						if(s2.contains("<=")){
							int index2=s2.indexOf("<");
							s3=s2.substring(0,index2);//����<=֮���
							s4=s2.substring(index2+2,s2.length());//�ڶ���<=�����
							int ss2=s3.substring(0, 1).toCharArray()[0];
							int ss3=s4.substring(0, 1).toCharArray()[0];
							if(!((ss2>=48&&ss2<=57)||ss2==45)){
								list.add(s3);
							}
							if(!((ss3>=48&&ss3<=57)||ss3==45)){
								list.add(s4);
							}
						}	
						else{
							int ss2=s2.substring(0, 1).toCharArray()[0];
							if(!((ss2>=48&&ss2<=57)||ss2==45)){
								list.add(s2);
							}
						}
					}             //////////<=.<=
					else{
						if(a.contains("<")){
							int index1=a.indexOf("<");
							s1=a.substring(0,index1);//<=ǰ���
							list.add(s1);
							s2=a.substring(index1+1,a.length());//<=�����
							//int ss2=Integer.valueOf(s2.substring(0, 1));
							int ss2=s2.substring(0, 1).toCharArray()[0];
							if(!((ss2>=48&&ss2<=57)||ss2==45)){
								list.add(s2);
							}
						}
						else{
							if(a.contains(">=")){  ///////��������>=
								int index1=a.indexOf(">");
								s1=a.substring(0,index1);//��һ��>=ǰ���
								list.add(s1);
								s2=a.substring(index1+2,a.length());//��һ��>=�����
								if(s2.contains(">=")){
									int index2=s2.indexOf(">");
									s3=s2.substring(0,index2);//����>=֮���
									s4=s2.substring(index2+2,s2.length());//�ڶ���>=�����
									int ss2=s3.substring(0, 1).toCharArray()[0];
									int ss3=s4.substring(0, 1).toCharArray()[0];
									if(!((ss2>=48&&ss2<=58)||ss2==45)){
										list.add(s3);
									}
									if(!((ss3>=48&&ss3<=57)||ss3==45)){
										list.add(s4);
									}
								}
								else{
									int ss2=s2.substring(0, 1).toCharArray()[0];
									if(!((ss2>=48&&ss2<=57)||ss2==45)){
										list.add(s2);
									}
								}
							}             //////////>=.>=
							else{
								if(a.contains(">")){
									int index1=a.indexOf(">");
									s1=a.substring(0,index1);//>=ǰ���
									list.add(s1);
									s2=a.substring(index1+1,a.length());//>=�����
									//int ss2=Integer.valueOf(s2.substring(0, 1));
									int ss2=s2.substring(0, 1).toCharArray()[0];
									if(!((ss2>=48&&ss2<=57)||ss2==45)){
										list.add(s2);
									}
								}
								else{
									if(a.contains("==")){
										int index1=a.indexOf("=");
										s1=a.substring(0,index1);//==ǰ���
										list.add(s1);
										s2=a.substring(index1+2,a.length());//==�����
										//int ss2=Integer.valueOf(s2.substring(0, 1));
										int ss2=s2.substring(0, 1).toCharArray()[0];
										if(!((ss2>=48&&ss2<=57)||ss2==45)){
											list.add(s2);
										}
									}
									else{
										if(a.contains("!=")){
											int index1=a.indexOf("!");
											s1=a.substring(0,index1);//!=ǰ���
											list.add(s1);
											s2=a.substring(index1+2,a.length());//!=�����
											//int ss2=Integer.valueOf(s2.substring(0, 1));
											int ss2=s2.substring(0, 1).toCharArray()[0];
											if(!((ss2>=48&&ss2<=57)||ss2==45)){
												list.add(s2);
											} 
										}
									}
								}
								//	 }
								// }
							}
						}	 
					}//��Ϊ>=.>=				 
				}
				if((ss1>=48&&ss1<=57)||ss1==45){//��һ��Ϊ��Ȼ��
					if(a.contains("<=")){  ///////��������<=
						int index1=a.indexOf("<");
						s2=a.substring(index1+2,a.length());//��һ��<=�����
						if(s2.contains("<=")){
							int index2=s2.indexOf("<");
							s3=s2.substring(0,index2);//����<=֮���
							s4=s2.substring(index2+2,s2.length());//�ڶ���<=�����
							//int ss2=Integer.valueOf(s3.substring(0, 1));
							// int ss3=Integer.valueOf(s4.substring(0, 1));
							int ss2=s3.substring(0, 1).toCharArray()[0];
							int ss3=s4.substring(0, 1).toCharArray()[0];
							if(!((ss2>=48&&ss2<=57)||ss2==45)){
								list.add(s3);
							}
							if(!((ss3>=48&&ss3<=57)||ss3==45)){
								list.add(s4);
							}
						} 
						else{
							int ss2=s2.substring(0, 1).toCharArray()[0];
							if(!((ss2>=48&&ss2<=57)||ss2==45)){
								list.add(s2);
							}
						}
					}             //////////<=.<=
					/*else{
						 if(a.contains("<=")){
							 int index1=a.indexOf("<");
							 s2=a.substring(index1+2,a.length());//<=�����
							 //int ss2=Integer.valueOf(s2.substring(0, 1));
							 int ss2=s2.substring(0, 1).toCharArray()[0];
							 if(!((ss2>=48&&ss2<=57)||ss2==45)){
								 list.add(s2);
							 }
						 }           ///////////    <=
					 */						 else{
						 if(a.contains("<")){
							 int index1=a.indexOf("<");
							 s2=a.substring(index1+1,a.length());//<=�����
							 //int ss2=Integer.valueOf(s2.substring(0, 1));
							 int ss2=s2.substring(0, 1).toCharArray()[0];
							 if(!((ss2>=48&&ss2<=57)||ss2==45)){
								 list.add(s2);
							 }
						 }
						 else{
							 if(a.contains(">=")){  ///////��������>=
								 int index1=a.indexOf(">");
								 s2=a.substring(index1+2,a.length());//��һ��>=�����
								 if(s2.contains(">=")){
									 int index2=s2.indexOf(">");
									 s3=s2.substring(0,index2);//����>=֮���
									 s4=s2.substring(index2+2,s2.length());//�ڶ���>=�����
									 //int ss2=Integer.valueOf(s3.substring(0, 1));
									 //int ss3=Integer.valueOf(s4.substring(0, 1));
									 int ss2=s3.substring(0, 1).toCharArray()[0];
									 int ss3=s4.substring(0, 1).toCharArray()[0];
									 if(!((ss2>=48&&ss2<=57)||ss2==45)){
										 list.add(s3);
									 }
									 if(!((ss3>=48&&ss3<=57)||ss3==45)){
										 list.add(s4);
									 }
								 }
								 else{
									 int ss2=s2.substring(0, 1).toCharArray()[0];
									 if(!((ss2>=48&&ss2<=57)||ss2==45)){
										 list.add(s2);
									 }
								 }

							 }             //////////>=.>=
							 /*else{
									 if(a.contains(">=")){
										 int index1=a.indexOf(">");
										 s2=a.substring(index1+2,a.length());//<=�����
										 //int ss2=Integer.valueOf(s2.substring(0, 1));
										 int ss2=s2.substring(0, 1).toCharArray()[0];
										 if(!((ss2>=48&&ss2<=57)||ss2==45)){
											 list.add(s2);
										 }
									 }     */      ///////////    >=
							 else{
								 if(a.contains(">")){
									 int index1=a.indexOf(">");
									 s2=a.substring(index1+1,a.length());//>=�����
									 //int ss2=Integer.valueOf(s2.substring(0, 1));
									 int ss2=s2.substring(0, 1).toCharArray()[0];
									 if(!((ss2>=48&&ss2<=57)||ss2==45)){
										 list.add(s2);
									 }
								 }
								 else{
									 if(a.contains("==")){
										 int index1=a.indexOf("=");
										 s2=a.substring(index1+2,a.length());//==�����
										 //int ss2=Integer.valueOf(s2.substring(0, 1));
										 int ss2=s2.substring(0, 1).toCharArray()[0];
										 if(!((ss2>=48&&ss2<=57)||ss2==45)){
											 list.add(s2);
										 }
									 }
									 else{
										 if(a.contains("!=")){
											 int index1=a.indexOf("!");
											 s2=a.substring(index1+2,a.length());//!=�����
											 //int ss2=Integer.valueOf(s2.substring(0, 1));
											 int ss2=s2.substring(0, 1).toCharArray()[0];
											 if(!((ss2>=48&&ss2<=57)||ss2==45)){
												 list.add(s2);
											 } 
										 }
									 }
								 }
							 }
						 }	 
					 }				 
				}
			}
		}
		else{
			return null;
		}
		if(list.size()>1){
			cs=list.get(0);
			for(int j=1;j<list.size();j++){
				c1=list.get(j);
				cs=cs+","+c1;
			}
		}
		if(list.size()==1){
			cs=list.get(0);
		}					
		return cs;
	}

}

