package cn.edu.hdu.ckt.testcase;
//ȡ��in��condition���map
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Get_bds_cs {


	/**
	 * ȡin����Ĳ��������Ͷ�Ӧ��map
	 * @param tran
	 * @return
	 */
	public static Map<String,String> get_inMap(String ins){
		Map<String,String> map = new HashMap<String,String>();//ӳ�����������֮���ϵ
		if(ins==null){  //in����Ϊ��
			return null;
		}
		else{
			if(ins!=null){ //in���治Ϊ��
				if(ins.contains("#")){//  #���ֲ���ʽ�Ͳ�������
					String[] s = ins.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
					//String sbds = s[0].replace("&&", ",").replace("||", ",").replace(" ", "")/*.replace("(", "").replace(")", "")*/;//���in�еĲ���ʽ
					String stype = s[1];  //���in�в���������

					if(stype!=null&&stype.contains(",")){///////////////////////////////��ֹһ������
						String[] intype = stype.split(",");
						for(String tt1:intype){//tt1Ϊһ��������Ӧһ������
							String[] ss1 = tt1.split(":");
							map.put(ss1[0], ss1[1]);
						}
						
					}//if(stype!=null&&stype.contains(","))
					else{
						if(stype!=null&&!stype.contains(",")){//  ֻ��һ���������Ӧ������
							String[] ss1 = stype.split(":");
							map.put(ss1[0], ss1[1]);

						}//if(stype!=null&&!stype.contains(","))												
					}
				}//if(ins.contains("#"))
				else{//����# ��û�в���
					return null; 
				}
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
		
		Map<String,String> map = new HashMap<String,String>();//ӳ�����������֮���ϵ
		if(condition==null){  //condition����Ϊ��
			return null;
		}
		else{
			if(condition.contains("--")&&condition!=null){
				//condition.replace("false", "False").replace("true", "True").replace("&&", ",")/*.replace("(", "").replace(")", "")*/;
				String[] condition1=condition.split("--");
				for(String condition2:condition1){
					if(condition2!=null){ //condition���治Ϊ��
						if(condition2.contains("#")){
							System.out.println("condition2:"+condition2);
							String[] s = condition2.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
							String stype = s[1];  //���in�в���������
							if(stype!=null&&stype.contains(",")){//��ֹһ������
								String[] contype = stype.split(",");
								for(String tt1:contype){//tt1Ϊһ��������Ӧһ������
									String[] ss1 = tt1.split(":");
									map.put(ss1[0], ss1[1]);
								}
								
							}//if(stype!=null&&stype.contains(","))
							else{
								if(stype!=null&&!stype.contains(",")){//  ֻ��һ���������Ӧ������
									String[] ss1 = stype.split(":");
									map.put(ss1[0], ss1[1]);

								}//if(stype!=null&&!stype.contains(","))												
							}
						}//if(condition2.contains("#"))
					}//if(condition2!=null)
				}//for(String condition2:condition1)
			}//if(condition.contains("--")&&condition!=null)
			else{
				if(!condition.contains("--")&&condition!=null){//condition����û��--����ֻҪһ������ʽ,�Ҳ�Ϊ��
					if(condition.contains("#")){////////////////////////////////////////////////#���ֲ���ʽ�Ͳ�������
						String[] s = condition.split("#");//#���Ϊ����ʽ��#�ұ�Ϊ����ʽ�в���������
						//String sbds = s[0].replace("&&", ",").replace("||", ",").replace(" ", "").replace("(", "").replace(")", "");//���in�еĲ���ʽ
						String stype = s[1];   //���condition�в����Ͷ�Ӧ������
						if(stype!=null&&stype.contains(",")){//��ֹһ������
							String[] contype = stype.split(",");
							for(String tt1:contype){//tt1Ϊһ��������Ӧһ������
								String[] ss1 = tt1.split(":");
								map.put(ss1[0], ss1[1]);
							}																				
						}//if(stype!=null&&stype.contains(","))
						else{
							if(stype!=null&&!stype.contains(",")){//  ֻ��һ������
								String[] ss1 = stype.split(":");
								map.put(ss1[0], ss1[1]);																
							}//if(stype!=null&&!stype.contains(","))												
						}
					}//if(condition2.contains("#"))
					
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

