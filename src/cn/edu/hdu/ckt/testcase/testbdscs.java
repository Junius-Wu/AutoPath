package cn.edu.hdu.ckt.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testbdscs {

	public static void main(String[] args) {
//		List<String> list=new ArrayList<String>();//�����������ʽ
//		List<String> list1=new ArrayList<String>();//���С������ʽ
//		List<String> list2=new ArrayList<String>();//���=0С������ʽ
//		List<String> list3=new ArrayList<String>();//���=0С������ʽ�Ĳ���
//		Map<String,String> map = new HashMap<String,String>();
//		Map<String,String> map1 = new HashMap<String,String>();
//		Map<String,String> map3 = new HashMap<String,String>();
//		String ttt=null;
//		String ttt1=null;
//		String ttt2=null;
//		//String ttt3[]=null;
//		List<String> result=new ArrayList<String>();//�������ʵ�������
//		List<String> tt3=new ArrayList<String>();//��ų���=0��С������ʽ���ʵ�������


		List<String> con = new ArrayList<String>();
		/*String con1 = "cycle=2.5ms--ap.motor_test==0#ap.motor_test:uint8_t--_flags.armed>2#_flags.armed:uint8_t";
		String con2 = "cycle=2.5ms--ap.motor_test==0#ap.motor_test:uint8_t--_flags.armed>2#_flags.armed:uint8_t--sssss_1=0#sssss_1:float--!(sssss_2<sssss_3,sssss_4<88)#sssss_2:uint8_t,sssss_3:uint8_t,sssss_4:uint8_t";
		String con3 ="cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--dt>=interval_ticks_product_two && _debug>1#dt:uint16_t,interval_ticks_product_two:uint16_t,_debug:int8_t--!(time_taken>_task_time_allowed && _debug>2)#time_taken:uint32_t,_task_time_allowed:uint32_t,_debug:int8_t";
		String con4 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--i==0#i:uint8_t";
		String con5 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--channel_throttle$control_in<=0#channel_throttle$control_in:int16_t--tmp>4000#tmp:int16_t--arming_counter==20&&is_armed==false#arming_counter:int16_t,is_armed:bool";
		String con6 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--_hil_mode==false#_hil_mode:bool--i<_num_drivers#i:uint8_t,_num_drivers:uint8_t";
		String con7 = "i$t#i$t:uint8_t";*/
		/*con.add(con1);
		con.add(con2);
		con.add(con3);
		con.add(con4);
		con.add(con5);
		con.add(con6);
		con.add(con7);*/
		//String condition = "has_new_input==True#has_new_input:bool";
		//String condition = "cycle=2.5ms--contr--ol_mode==0#control_mode:int8_t#0<=control_mode<=14--motor_state==False || ap.throttle_zero==True#motor_state:bool,ap.throttle_zero:bool";
		//String condition = "cycle=2.5ms--control_mode==0#control_mode:int8_t#0<=control_mode<=14--motor_state==False || ap.throttle_zero==True#motor_state:bool,ap.throttle_zero:bool";
		//String condition = "cycle=2.5ms--control_mode==4#control_mode:int8_t#0<=control_mode<=14--guided_mode==2#guided_mode:uint8_t#guided_mode=0,guided_mode=1,guided_mode=2,guided_mode=3,guided_mode=4--ap.auto_armed != 0 && get_interlock==true && ap.land_complete!=1#ap.auto_armed:uint8_t,get_interlock:bool,ap.land_complete:uint8_t--tnow - vel_update_time_ms > 3000 && is_zero==false#tnow:uint32_t,vel_update_time_ms:uint32_t,is_zero:bool";
		String condition = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--i==18#i:uint8_t--0<=i<=16#i:uint8_t--gcs[i].initialised==true#gcs[i].initialised:bool";
		int ee=0;
		//for(String condition : con){
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

			
			System.out.println("condition"+ ee +"----->"+condition);
			System.out.println("keySet����3��"+GetMap.get_condMap(condition));
			if(GetMap.get_condMap(condition)==null){
				result.add(null);
				//System.out.println("keySet����3��"+GetMap.get_condMap(condition));
			}else{

				if(!(GetMap.get_condMap(condition)==null)){
					map1 = GetMap.get_condMap(condition);//�����У�Ҫ���������
					//System.out.println("==================================");
					Set<String> set =map1.keySet();

					String cs1 = AddBdsType.getcs(map1);
					String cs2 = AddBdsType.getDoubleCs(map1);
					String cs3 = AddBdsType.getBoolCs(map1);			
					String s1 = AddBdsType.add_bds(map1);
					String s20 = AddBdsType.add_doublebds(map1);
					String bds2=null;
					String bds00=null;

					//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
					//String bds0=GetBds.get_bds_0(condition.toString());
					//�����Ͳ���ʽ�Ͳ���
					String bds1=GetBds.get_bds(condition.toString());	
					System.out.println("bds1:"+bds1);


					/////////////////���
					System.out.println("=================================");
					System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ				
					System.out.println("����------>����������"+cs1);
					System.out.println("С��=0---->����ʽ������"+bds00);
					System.out.println("С��------>����ʽ������"+bds2);
					System.out.println("С��------>����ǰ������"+cs2);
					System.out.println("add------>��������ʽΪ��"+s1);
					System.out.println("add------>С������ʽǰΪ��"+s20);
					System.out.println("=================================");

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
					System.out.println("=================================");
					System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ			
					System.out.println("����------>����������"+cs1);
					System.out.println("С��=0---->����ʽ������"+bds00);
					System.out.println("С��------>����ʽ������"+bds2);
					System.out.println("С��------>�����󣬼���"+cs2);
					System.out.println("add------>��������ʽΪ��"+s1);
					System.out.println("add------>С������ʽ��Ϊ��"+s2);
					System.out.println("=================================");



					//�����Ͳ���ʽ�Ͳ���
					String boolbds=GetBds.get_boolbds(condition.toString());
					if(cs3!=null&&boolbds==null){
						boolbds = AddBdsType.add_boolbds(cs3);
					}
					System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
					System.out.println("С��=0---->����ʽ������"+bds00);
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
						System.out.println("��������ʽ:"+bbb);
						System.out.println("������������"+cs1);


						String solution1 = Mathematica.getSolution2(bbb, cs1);
						ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt=bbb.toString();
						//
						System.out.println("�����⣺"+solution1);
						results = solution1.substring(2, solution1.length() - 2).split("\\}, \\{");
						for(int i=0;i<results.length;i++){
							System.out.println("results11----"+results[i]);
						}
						System.out.println("condition������Լ����11Ϊ��"+solution1);
					}
					else{
						if(s1!=null){
							//											System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
							//											System.out.println("        ===>  condition����������ֵ������"+cs1);
							System.out.println("��������ʽ:"+s1);
							System.out.println("������������"+cs1);
							String solution1 = Mathematica.getSolution2(s1, cs1);
							ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//ttt=s1.toString();
							//							
							results = solution1.trim().substring(2, solution1.length() - 2).split("\\}, \\{");
							for(int i=0;i<results.length;i++){
								System.out.println("results22----"+results[i]);
							}
							System.out.println("condition��������Լ����22Ϊ��"+solution1);
						}
					}
					if((bds2!=null)&&(s2!=null)){
						//System.out.println("condition��С������ֵ����ʽ��"+s2);
						//System.out.println("condition��С������ֵ������"+cs2);
						String bb = bds2+","+s2;
						System.out.println("С������ʽ:"+bb);
						System.out.println("С��������"+cs2);
						String solution2 = Mathematica.getSolution4(bb, cs2);
						ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt1=s2.toString();
						//						
						results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
						for(int i=0;i<results1.length;i++){
							System.out.println("results1 33----"+results[i]);
						}
						System.out.println("condition��С����Լ����33Ϊ��"+solution2);
					}else{
						if((s2!=null)){
							System.out.println("С������ʽ:"+s2);
							System.out.println("С��������"+cs2);
							String solution2 = Mathematica.getSolution4(s2, cs2);
							ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//							
							results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
							System.out.println(results1.length);
							for(int i=0;i<results1.length;i++){
								System.out.println("results1 44----"+results1[i]);
							}
							System.out.println("condition��С����Լ����44Ϊ��"+solution2);
						}
					}

					//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
					if(boolbds!=null){
						System.out.println("===>condition�ϲ����͵Ĳ���ʽ��"+boolbds);
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
						//if(results.length>=0)
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
						System.out.println("list�н�:"+tt3.get(i));
					}
					if(bds00!=null){
						System.out.println("bds00:"+bds00);
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

					for(int i=0;i<result.size();i++){
						System.out.println("testcase"+i+"Ϊ:"+result.get(i));
					}

					//////////////////////////////////////

					System.out.println("---------------");
					System.out.println("result--->"+result);
					System.out.println("---------------");
				}

			}
			ee++;
		}
	//}



	public static List<String> getResult(String condition){

//		List<String> list=new ArrayList<String>();//�����������ʽ
//		List<String> list1=new ArrayList<String>();//���С������ʽ
//		List<String> list2=new ArrayList<String>();//���=0С������ʽ
//		List<String> list3=new ArrayList<String>();//���=0С������ʽ�Ĳ���
//		Map<String,String> map = new HashMap<String,String>();
//		Map<String,String> map1 = new HashMap<String,String>();
//		Map<String,String> map3 = new HashMap<String,String>();
//		String ttt=null;
//		String ttt1=null;
//		String ttt2=null;
//		//String ttt3[]=null;
//		List<String> result=new ArrayList<String>();//�������ʵ�������
//		List<String> tt3=new ArrayList<String>();//��ų���=0��С������ʽ���ʵ�������


		List<String> con = new ArrayList<String>();
		/*String con1 = "cycle=2.5ms--ap.motor_test==0#ap.motor_test:uint8_t--_flags.armed>2#_flags.armed:uint8_t";
		String con2 = "cycle=2.5ms--ap.motor_test==0#ap.motor_test:uint8_t--_flags.armed>2#_flags.armed:uint8_t--sssss_1=0#sssss_1:float--!(sssss_2<sssss_3,sssss_4<88)#sssss_2:uint8_t,sssss_3:uint8_t,sssss_4:uint8_t";
		String con3 ="cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--dt>=interval_ticks_product_two && _debug>1#dt:uint16_t,interval_ticks_product_two:uint16_t,_debug:int8_t--!(time_taken>_task_time_allowed && _debug>2)#time_taken:uint32_t,_task_time_allowed:uint32_t,_debug:int8_t";
		String con4 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--i==0#i:uint8_t";
		String con5 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--channel_throttle$control_in<=0#channel_throttle$control_in:int16_t--tmp>4000#tmp:int16_t--arming_counter==20&&is_armed==false#arming_counter:int16_t,is_armed:bool";
		String con6 = "cycle=2.5ms--i<_num_tasks#i:uint8_t,_num_tasks:uint8_t--dt>=interval_ticks#dt:uint16_t,interval_ticks:uint16_t--_task_time_allowed<=time_available#_task_time_allowed:uint32_t,time_available:uint32_t--_hil_mode==false#_hil_mode:bool--i<_num_drivers#i:uint8_t,_num_drivers:uint8_t";
		String con7 = "i$t#i$t:uint8_t";*/
		/*con.add(con1);
		con.add(con2);
		con.add(con3);
		con.add(con4);
		con.add(con5);
		con.add(con6);
		con.add(con7);*/
		//String condition = "has_new_input==True#has_new_input:bool";
		//String condition = "cycle=2.5ms--control_mode==4#control_mode:int8_t#0<=control_mode<=14--guided_mode==1#guided_mode:uint8_t#guided_mode=0,guided_mode=1,guided_mode=2,guided_mode=3,guided_mode=4--ap.auto_armed==0 || get_interlock==false || ap.land_complete==1#ap.auto_armed:uint8_t, get_interlock:bool,ap.land_complete:uint8_t";
		//String condition = "cycle=2.5ms--control_mode==0#control_mode:int8_t#0<=control_mode<=14--motor_state==False || ap.throttle_zero==True#motor_state:bool,ap.throttle_zero:bool";
		int ee=0;
		//for(String condition : con){
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

			
			System.out.println("condition"+ ee +"----->"+condition);
			//System.out.println("keySet����3��"+GetMap.get_condMap(condition));
			if(GetMap.get_condMap(condition)==null){
				result.add(null);
				//System.out.println("keySet����3��"+GetMap.get_condMap(condition));
			}else{

				if(!(GetMap.get_condMap(condition)==null)){
					map1 = GetMap.get_condMap(condition);//�����У�Ҫ���������
					//System.out.println("==================================");
					Set<String> set =map1.keySet();

					String cs1 = AddBdsType.getcs(map1);
					String cs2 = AddBdsType.getDoubleCs(map1);
					String cs3 = AddBdsType.getBoolCs(map1);			
					String s1 = AddBdsType.add_bds(map1);
					String s20 = AddBdsType.add_doublebds(map1);
					String bds2=null;
					String bds00=null;

					//==0�Ĳ���ʽ��Ϊ�� ==��Ϊ=
					//String bds0=GetBds.get_bds_0(condition.toString());
					//�����Ͳ���ʽ�Ͳ���
					String bds1=GetBds.get_bds(condition.toString());	
					System.out.println("bds1:"+bds1);


					/////////////////���
					System.out.println("=================================");
					System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ				
					System.out.println("����------>����������"+cs1);
					System.out.println("С��=0---->����ʽ������"+bds00);
					System.out.println("С��------>����ʽ������"+bds2);
					System.out.println("С��------>����ǰ������"+cs2);
					System.out.println("add------>��������ʽΪ��"+s1);
					System.out.println("add------>С������ʽǰΪ��"+s20);
					System.out.println("=================================");

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
					System.out.println("=================================");
					System.out.println("����------>����ʽ������"+bds1);  //condition�����ֲ���ʽ			
					System.out.println("����------>����������"+cs1);
					System.out.println("С��=0---->����ʽ������"+bds00);
					System.out.println("С��------>����ʽ������"+bds2);
					System.out.println("С��------>�����󣬼���"+cs2);
					System.out.println("add------>��������ʽΪ��"+s1);
					System.out.println("add------>С������ʽ��Ϊ��"+s2);
					System.out.println("=================================");



					//�����Ͳ���ʽ�Ͳ���
					String boolbds=GetBds.get_boolbds(condition.toString());
					if(cs3!=null&&boolbds==null){
						boolbds = AddBdsType.add_boolbds(cs3);
					}
					System.out.println("������------>����ʽ������"+boolbds);//condition�ϲ�������ʽ
					System.out.println("С��=0---->����ʽ������"+bds00);
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
						System.out.println("��������ʽ:"+bbb);
						System.out.println("������������"+cs1);


						String solution1 = Mathematica.getSolution2(bbb, cs1);
						//ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt=bbb.toString();
						System.out.println(solution1);					
						results = solution1.substring(2, solution1.length() - 2).split("\\}, \\{");
						for(int i=0;i<results.length;i++){
							System.out.println("results11----"+results[i]);
						}
						System.out.println("condition������Լ����11Ϊ��"+solution1);
					}
					else{
						if(s1!=null){
							//											System.out.println("        ===>  condition����������ֵ����ʽ��"+s1);
							//											System.out.println("        ===>  condition����������ֵ������"+cs1);
							System.out.println("��������ʽ:"+s1);
							System.out.println("������������"+cs1);
							String solution1 = Mathematica.getSolution2(s1, cs1);
							ttt=solution1.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//ttt=s1.toString();
							//							
							results = solution1.trim().substring(2, solution1.length() - 2).split("\\}, \\{");
							for(int i=0;i<results.length;i++){
								System.out.println("results22----"+results[i]);
							}
							System.out.println("condition��������Լ����22Ϊ��"+solution1);
						}
					}
					if((bds2!=null)&&(s2!=null)){
						//System.out.println("condition��С������ֵ����ʽ��"+s2);
						//System.out.println("condition��С������ֵ������"+cs2);
						String bb = bds2+","+s2;
						System.out.println("С������ʽ:"+bb);
						System.out.println("С��������"+cs2);
						String solution2 = Mathematica.getSolution4(bb, cs2);
						ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
						//ttt1=s2.toString();
						//						
						results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
						for(int i=0;i<results1.length;i++){
							System.out.println("results1 33----"+results[i]);
						}
						System.out.println("condition��С����Լ����33Ϊ��"+solution2);
					}else{
						if((s2!=null)){
							System.out.println("С������ʽ:"+s2);
							System.out.println("С��������"+cs2);
							String solution2 = Mathematica.getSolution4(s2, cs2);
							ttt1=solution2.toString().replace("{", "").replace("}", "").replace(" ", "").replace("->", "=").replace("(", "").replace(")", "");
							//							
							results1 = solution2.substring(2, solution2.length() - 2).split("\\}, \\{");
							System.out.println(results1.length);
							for(int i=0;i<results1.length;i++){
								System.out.println("results1 44----"+results1[i]);
							}
							System.out.println("condition��С����Լ����44Ϊ��"+solution2);
						}
					}

					//System.out.println("condition������ֵ��Ϊ��"+boolbds);//condition�ϲ�������ʽ	
					if(boolbds!=null){
						System.out.println("===>condition�ϲ����͵Ĳ���ʽ��"+boolbds);
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
						//if(results.length>=0)
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
						System.out.println("list�н�:"+tt3.get(i));
					}
					if(bds00!=null){
						System.out.println("bds00:"+bds00);
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

					for(int i=0;i<result.size();i++){
						System.out.println("testcase"+i+"Ϊ:"+result.get(i));
					}

					//////////////////////////////////////

					System.out.println("---------------");
					System.out.println("result--->"+result);
					System.out.println("---------------");
				}

			}
			ee++;
			return result;
		
	}


}
