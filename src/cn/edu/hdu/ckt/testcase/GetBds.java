package cn.edu.hdu.ckt.testcase;
//////����in out condition����Ĳ���ʽ�����з��ദ��
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GetBds {


	/**
	 * ���յ�ȡ��ֵ����ʽ������mma
	 * @param tran
	 * @return
	 */
	public static String get_bds(String condition){
		Map<String,String> map1 = new HashMap<String,String>();//���� ӳ�����������֮���ϵ��map
		List<String> list = new ArrayList<String>();//�Ѽ���ֵ�Ͳ���ʽ
		//List<String> list1 = new ArrayList<String>();//�Ѽ�==0����Ĳ���ʽ
		Queue<String> queue = new LinkedList<String>();//���һ��һ���ģ���Ų���ʽ
		String s1=new String();
		String ss=null;
		int n = 0;//������־�Ƿ����ڣ������������ָ�ʽ�Ĳ���ʽ
		if(condition==null){
			return null;
		}
		else{
			if(condition!=null && condition.length()>0){				
				if(condition.contains("--")){//����condition��������
					String[] condition1 = condition.split("--");
					for(String condition2:condition1){
						if(condition2.contains("!(")){
							n = 1;
						}
						if(condition2!=null && !condition2.contains("cycle")){//cycle������������cycle��
							if(condition2.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition2.split("#");
								String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										if(n==1&&i>0){//Ϊÿһ������ʽǰ�ӣ�
											String bb = "!"+ssbds[i];
											ssbds[i] = bb;
										}
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if((a.contains("<")||a.contains(">")||a.contains("="))&&(!a.contains("True"))&&(!a.contains("False"))&&(!a.contains("true"))&&(!a.contains("false"))){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}

								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if((bds.contains("<")||bds.contains(">")||bds.contains("="))&&(!bds.contains("True"))&&(!bds.contains("False"))&&(!bds.contains("true"))&&(!bds.contains("false"))){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)
						n = 0;
					}//for(String condition2:condition1)

				}//if(condition.contains("--"))
				else{
					if(!(condition.contains("--"))){//����condition��ֻ��һ�������������in��������
						if(condition!=null && !condition.contains("cycle")){//cycle������������cycle��
							if(condition.contains("!(")){
								n = 1;
							}
							if(condition.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition.split("#");
								String sbds = null;
								if(n==1){
									sbds = "!"+s[0]; //���δ������Ĳ���ʽ
								}else{
									sbds = s[0]; //���δ������Ĳ���ʽ
								}
								
								//String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if((a.contains("<")||a.contains(">")||a.contains("="))&&(!a.contains("True"))&&(!a.contains("False"))&&(!a.contains("true"))&&(!a.contains("false"))){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}

								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if((bds.contains("<")||bds.contains(">")||bds.contains("="))&&(!bds.contains("True"))&&(!bds.contains("False"))&&(!bds.contains("true"))&&(!bds.contains("false"))){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)


					}//if(!(tran.contains("--")))
				}//else
			}//if(tran!=null)
			if(list.size()<=0){
				return null;
			}
			else{
				if(list.size()==1){
//					if(!(list.get(0).contains("==0"))){
						ss=list.get(0);
//					}	
				}	
				if(list.size()>1){
//					if(!list.get(0).contains("==0")){
						ss=list.get(0);
//					}
					for(int j=1;j<list.size();j++){
						s1=list.get(j);
//						if(!(s1.contains("==0"))&&(ss!=null)){
						if(ss!=null){
							ss=ss+","+s1;
						}
//						if(!(s1.contains("==0"))&&(ss==null)){
						if(ss==null){
							ss=s1;
						}
					}
				}
				
				
				if(ss!=null&&ss.contains(" ")){
					ss=ss.replace(" ", "");
				}

				return ss;	
			}
				
		}//else


	}



	/**
	 * ���յ�ȡ��������ʽ������mma
	 * @param tran
	 * @return
	 */
	public static String get_boolbds(String condition){
		//Map<String,String> map = new HashMap<String,String>();//���� ӳ�����������֮���ϵ��map
		Map<String,String> map1 = new HashMap<String,String>();
		List<String> list = new ArrayList<String>();//������ֵ�Ͳ���ʽ
		List<String> list1 = new ArrayList<String>();//�Ѽ�==0����Ĳ���ʽ
		Queue<String> queue = new LinkedList<String>();//���һ��һ���ģ���Ų���ʽ
		String s1=new String();
		String ss=null;
		int n = 0;
		if(condition==null){
			return null;
		}
		else{
			if(condition!=null && condition.length()>0){
				if(condition.contains("--")){//����condition��������
					String[] condition1 = condition.split("--");
					for(String condition2:condition1){				
						if(condition2!=null && !condition2.contains("cycle")){//cycle������������cycle��
							if(condition2.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition2.split("#");
								String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								//Set<String> keyset =map1.keySet();
								//for(String key : keyset){
								//	map.put(key.trim(), map1.get(key));
								//}
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if(a.contains("<")||a.contains(">")||a.contains("=")){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}


								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if(bds.contains("<")||bds.contains(">")||bds.contains("=")){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)
					}//for(String condition2:condition1)

				}//if(condition.contains("--"))
				else{
					if(!(condition.contains("--"))){//����condition��ֻ��һ�������������in��������
						if(condition!=null && !condition.contains("cycle")){//cycle������������cycle��
							if(condition.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition.split("#");
								String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								//Set<String> keyset =map1.keySet();
								//for(String key : keyset){
									//map.put(key.trim(), map1.get(key));
								//}
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if(a.contains("<")||a.contains(">")||a.contains("=")){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}

								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if(bds.contains("<")||bds.contains(">")||bds.contains("=")){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)


					}//if(!(tran.contains("--")))
				}//else
			}//if(tran!=null)
			if(list.size()>0){
				for(int j=0;j<list.size();j++){
					if(list.get(j).contains("True")||list.get(j).contains("False")||list.get(j).contains("true")||list.get(j).contains("false")){
						list1.add(list.get(j));
					}
				}
			}
			if(list1.size()>1){
				ss=list1.get(0);
				for(int j=1;j<list1.size();j++){
					s1=list1.get(j);
					ss=ss+","+s1;
				}
			}
			if(list1.size()==1){
				ss=list1.get(0);
			}	
			if(list1.size()<=0){
				return null;
			}
			if(ss!=null&&ss.contains(" ")){
				ss=ss.replace(" ", "");
			}

			ss = ss.replace("==", "=");
			return ss;		
		}//else


	}

	
	
		
	/**
	 * ���յ�ȡ==0����ʽ������mma
	 * @param tran
	 * @return
	 */
	public static String get_bds_0(String condition){
		Map<String,String> map1 = new HashMap<String,String>();//���� ӳ�����������֮���ϵ��map
		List<String> list = new ArrayList<String>();//�Ѽ���ֵ�Ͳ���ʽ
		List<String> list1 = new ArrayList<String>();//�Ѽ�==0����Ĳ���ʽ
		Queue<String> queue = new LinkedList<String>();//���һ��һ���ģ���Ų���ʽ
		String s1=new String();
		String ss=null;
		if(condition==null){
			return null;
		}
		else{
			if(condition!=null && condition.length()>0){
				if(condition.contains("--")){//����condition��������
					String[] condition1 = condition.split("--");
					for(String condition2:condition1){
						if(condition2!=null && !condition2.contains("cycle")){//cycle������������cycle��
							if(condition2.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition2.split("#");
								String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if(a.contains("<")||a.contains(">")||a.contains("=")){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}


								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if(bds.contains("<")||bds.contains(">")||bds.contains("=")){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)
					}//for(String condition2:condition1)

				}//if(condition.contains("--"))
				else{
					if(!(condition.contains("--"))){//����condition��ֻ��һ�������������in��������
						if(condition!=null && !condition.contains("cycle")){//cycle������������cycle��
							if(condition.contains("#")){//--��--֮�� ����# ˵���в���ʽ�Ͳ���
								String[] s = condition.split("#");
								String sbds = s[0]; //���δ������Ĳ���ʽ
								String scs = s[1];  //��Ų��� ���Ӧ�Ĳ�������
								map1 = GetMap.getMap(scs);//map1������--��--֮�������������͵Ķ�Ӧ��ϵ
								String bds = sbds.replace("&&", ",").replace("||", ",").replace("(", "").replace(")", "");
								if(bds.contains(",")){//--��--֮���ֲ� �ж������ʽ
									String[] ssbds = bds.split(",");
									for(int i=0;i<ssbds.length;i++){
										queue.add(ssbds[i]);
									}
									String a=queue.poll();
									while(a!=null){
										if(a.contains("<")||a.contains(">")||a.contains("=")){
											if(a.contains("=")&&!a.contains("<")&&!a.contains(">")&&!a.contains("==")&&!a.contains("!=")){
												a = a.replace("=", "==");
											}
											list.add(a); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
										a = queue.poll();
									}

								}
								else{
									if(!(bds.contains(","))){//--֮��ֻ��һ������ʽ	
										if(bds.contains("<")||bds.contains(">")||bds.contains("=")){
											if(bds.contains("=")&&!bds.contains("<")&&!bds.contains(">")&&!bds.contains("==")&&!bds.contains("!=")){
												bds = bds.replace("=", "==");
											}
											list.add(bds); //ֻ����ֵ�͵Ĳ���ʽ����list��
										}
									}										
								}

							}//if(condition2.contains("#"))

						}//if(condition2!=null)


					}//if(!(tran.contains("--")))
				}//else
			}//if(tran!=null)
			if(list.size()>0){
				for(int j=0;j<list.size();j++){
					if(list.get(j).contains("==0")){
						list1.add(list.get(j));
					}
				}
			}
			if(list1.size()>1){
				ss=list1.get(0);
				for(int j=1;j<list1.size();j++){
					s1=list1.get(j);
					ss=ss+","+s1;
				}
			}
			if(list1.size()==1){
				ss=list1.get(0);
			}	
			if(list1.size()<=0){
				return null;
			}

			//ss=ss.replace(" ", "").replace("==", "=");
			return ss;		
		}//else


	}

	
	
	
	
}

































