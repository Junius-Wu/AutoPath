package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����:�����������õ�����mathematica�⣬���ص��Ƕ����
 * @author ckt
 *
 */
public class Result {
	/**
	 * �����������õ������
	 * @param condition
	 * @return
	 */
	public static List<String> getResult(String condition){ 
		List<String> list=new ArrayList<String>();//�����������ʽ
		List<String> list1=new ArrayList<String>();//���С������ʽ
		List<String> list2=new ArrayList<String>();//���=0С������ʽ
		List<String> list3=new ArrayList<String>();//���=0С������ʽ�Ĳ���
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> map1 = new HashMap<String,String>();
		Map<String,String> map3 = new HashMap<String,String>();
		String ttt=null;
		String ttt1=null;
		String ttt2=null;
		//String ttt3[]=null;
		List<String> result=new ArrayList<String>();//�������ʵ�������
		List<String> tt3=new ArrayList<String>();//��ų���=0��С������ʽ���ʵ�������
		//System.out.println("condition----->"+condition);
		//System.out.println("keySet����3��"+GetMap.get_condMap(condition));
		if(GetMap.get_condMap(condition)==null){
			//System.out.println("keySet����3��"+GetMap.get_condMap(condition));
			return null;
		}else{
			if(!(GetMap.get_condMap(condition)==null)){
				map1 = GetMap.get_condMap(condition);//�����У�Ҫ���������
				//System.out.println("==================================");
				//Set<String> set =map1.keySet();
				
				String cs1 = AddBdsType.getcs(map1);
				String cs2 = AddBdsType.getDoubleCs(map1);
				String cs3 = AddBdsType.getBoolCs(map1);			
				String s1 = AddBdsType.add_bds(map1);
				String s20 = AddBdsType.add_doublebds(map1);
				String bds2=null;
				String bds00=null;

				//�����Ͳ���ʽ�Ͳ���
				String bds1=GetBds.get_bds(condition.toString());	
				//System.out.println("bds1:"+bds1);
								
                /////////////////���
				/*System.out.println("=================================");
				System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ				
				System.out.println("����------>����������"+cs1);
				System.out.println("С��=0---->����ʽ������"+bds00);
				System.out.println("С��------>����ʽ������"+bds2);
				System.out.println("С��------>����ǰ������"+cs2);
				System.out.println("add------>��������ʽΪ��"+s1);
				System.out.println("add------>С������ʽǰΪ��"+s20);
				System.out.println("=================================");*/

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
										if(m==1&&(x1.contains("==0"))){
											list2.add(x1);//list2������==0��С������ʽ
										}
										if(m==0){
											list.add(x1);//list��������������ʽ
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
										if(m==1&&(x1.contains("==0"))){
											list2.add(x1);//list2������==0��С������ʽ
										}
										if(m==0){
											list.add(x1);//list�����ų���������ʽ
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
										if(m==1&&(bds1.contains("==0"))){
											list2.add(bds1);//list2������==0��С������ʽ													
										}
										if(m==0){
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
										if(m==1&&(bds1.contains("==0"))){
											list2.add(bds1);//list2������==0��С������ʽ													
										}
										if(m==0){
											list.add(bds1);//list�����ų���==0����������ʽ
										}
									}
								}
							}
						}
						
						//��������ʽ
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
						//System.out.println("��������ʽΪ----->"+cs);

						//��=0��С������ʽ
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
					
						//=0��С������ʽ
						String csss = null;
						if(list2.size()>1){
							csss=list2.get(0);
							list3.add(list2.get(0).replace("==0", ""));
							for(int mm=1;mm<list2.size();mm++){
								list3.add(list2.get(mm).replace("==0", ""));
								String c1=list2.get(mm);
								csss=csss+","+c1;
							}
						}
						if(list2.size()==1){
							csss=list2.get(0);
							list3.add(list2.get(0).replace("==0", ""));
						}	
						bds00=csss.replace("==", "=");
					
					}//if(bds1!=null)
					else{
						if(bds1==null){
							//System.out.println("��������ʽΪ----->"+null);
							//System.out.println("С������ʽΪ----->"+null);
						}										
					}


				}//if(cs2!=null)
				else{
					//û��С������
					//System.out.println("��������ʽΪ----->"+bds1);
					//System.out.println("С������ʽΪ----->"+null);

				}
             	//////////////////////
	
				
				for(int i=0;i<list3.size();i++){
					//����С������
					if(cs2.contains(list3.get(i)+",")){
						cs2 = cs2.replace(list3.get(i)+",", "");
					}else{
						if(cs2.contains(list3.get(i))){
							cs2 = cs2.replace(list3.get(i), "");
						}						
					}
					//�������ӵ�С������ʽ
					map1.remove(list3.get(i));					
				}
				String s2 = AddBdsType.add_doublebds(map1);

				
                /////////////////���
				/*System.out.println("=================================");
				System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ			
				System.out.println("����------>����������"+cs1);
				System.out.println("С��=0---->����ʽ������"+bds00);
				System.out.println("С��------>����ʽ������"+bds2);
				System.out.println("С��------>�����󣬼���"+cs2);
				System.out.println("add------>��������ʽΪ��"+s1);
				System.out.println("add------>С������ʽ��Ϊ��"+s2);
				System.out.println("=================================");*/
				
	
				//�����Ͳ���ʽ�Ͳ���
				String boolbds=GetBds.get_boolbds(condition.toString());
				if(cs3!=null&&boolbds==null){
					boolbds = AddBdsType.add_boolbds(cs3);
				}
				//System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
				//System.out.println("С��=0---->����ʽ������"+bds00);
				//			System.out.println("������------>����������"+cs3);


				/////////////////////////////////////////
				//����mma�����ⷽ����
				String[] results = null;
				String[] results1 = null;
				String[] ttt3 = null;
				if(((bds1==null)&&(cs1==null))&&(s2==null)){
					//System.out.println("        ===>  condition��û��Լ����Ϊ��null");
					//input.setText("null");
				}
				if((bds1!=null)&&(cs1!=null)){
					String bbb = bds1+","+s1;
					//System.out.println("        ===>  condition����������ֵ����ʽ��"+bbb);
					//										System.out.println("        ===>  condition����������ֵ������"+cs1);
					//System.out.println("��������ʽ:"+bbb);
					//System.out.println("������������"+cs1);
					String solution1 = Mathematica.getSolution2(bbb, cs1);
					ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
					//ttt=bbb.toString();
//					
					results = solution1.substring(2, solution1.length() - 2).split("\\}, \\{");

					//System.out.println("condition������Լ����Ϊ��"+solution1);
				}
				else{
					if(s1!=null){
						//System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
						//System.out.println("        ===>  condition����������ֵ������"+cs1);
						//System.out.println("��������ʽ:"+s1);
						//System.out.println("������������"+cs1);
						String solution1 = Mathematica.getSolution2(s1, cs1);
						ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt=s1.toString();
//						
						results = solution1.substring(2, solution1.length() - 2).split("\\}, \\{");
						
						//System.out.println("condition��������Լ����Ϊ��"+solution1);
					}
				}
				if((bds2!=null)&&(s2!=null)){
					//System.out.println("condition��С������ֵ����ʽ��"+s2);
					//System.out.println("condition��С������ֵ������"+cs2);
					String bb = bds2+","+s2;
					//System.out.println("С������ʽ:"+bb);
					//System.out.println("С��������"+cs2);
					String solution2 = Mathematica.getSolution4(bb, cs2);
					ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
					//ttt1=s2.toString();
//					
					results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
					
					//System.out.println("condition��С����Լ����Ϊ��"+solution2);
				}else{
					if((s2!=null)){
						//System.out.println("С������ʽ:"+s2);
						//System.out.println("С��������"+cs2);
						String solution2 = Mathematica.getSolution4(s2, cs2);
						ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
//						
						results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
						
						//System.out.println("condition��С����Լ����Ϊ��"+solution2);
					}
				}
				
				//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
				if(boolbds!=null){
					//System.out.println("        ===>  condition�ϲ����͵Ĳ���ʽ��"+boolbds);
					if((results!=null)&&(results1!=null)){
                        //Object results;
						//for(int i=0;;i++){
							for(String tttt:results){
								for(String tttt1:results1){
									//ttt3[i]
									String t3=tttt+","+tttt1+","+boolbds;
									tt3.add(t3);
								}								
							}
						//}
						
						//ttt3=ttt+","+ttt1+","+boolbds;
					}
					if((results!=null)&&(results1==null)){
						//for(int i=0;;i++){
							for(String tttt:results){
								
								String t3=tttt+","+boolbds;
								tt3.add(t3);
							}
						//}
						//ttt3=ttt+","+boolbds;
					}
					if((results==null)&&(results1!=null)){
						//for(int i=0;;i++){							
							for(String tttt1:results1){
								
								String t3=tttt1+","+boolbds;
								tt3.add(t3);
							}															
						//}
						//ttt3=ttt1+","+boolbds;
					}
					//System.out.println("condition�Ͻ�Ϊ��"+ttt3);
					if((results==null)&&(results1==null)){
						//for(int i=0;;i++){						
							String t3=boolbds;
							tt3.add(t3);																						
						//}
						//ttt3=ttt1+","+boolbds;
					}
				}
				else{
					if((results!=null)&&(results1!=null)){
						//for(int i=0;;i++){
							for(String tttt:results){
								for(String tttt1:results1){									
									String t3=tttt+","+tttt1;
									tt3.add(t3);
								}								
							}
						//}
						//ttt3=ttt+","+ttt1;
					}
					if((results!=null)&&(results1==null)){
						//for(int i=0;;i++){
							for(String tttt:results){															
								String t3=tttt;
								tt3.add(t3);
							}
						//}
						//ttt3=ttt;
					}
					if((results==null)&&(results1!=null)){
						//for(int i=0;;i++){							
							for(String tttt1:results1){								
								String t3=tttt1;
								tt3.add(t3);
							}															
						//}
						//ttt3=ttt1;
					}
					
					
				}
				for(int i=0;i<tt3.size();i++){
					//System.out.println("list�н�:"+tt3.get(i));
				}
				if(bds00!=null){
					//System.out.println("bds00:"+bds00);
					for(int i=0;i<tt3.size();i++){	
						String t = tt3.get(i)+","+bds00;
						t = t.replace(" ", "").replaceAll("->", "=").replace("(", "").replace(")", "").replace("$", "->");
						result.add(t);
						//tt3.remove(tt3.get(i));
					}
			    }else{
			    	for(int i=0;i<tt3.size();i++){
			    		String t = tt3.get(i).replace(" ", "").replaceAll("->", "=").replace("(", "").replace(")", "").replace("$", "->");
						result.add(t);						
					}
			    }
				/*for(int i=0;i<tt3.size();i++){
					System.out.println("��"+i+"Ϊ:"+tt3.get(i));
				}*/

				/*for(int i=0;i<result.size();i++){					
					System.out.println("��"+i+"Ϊ:"+result.get(i));
				}*/

				//////////////////////////////////////


			}	
			
		return result;
		}
	
	}
}
