package com.biz.list.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.biz.list.model.IoListVO;

public class IoListServiceImp {
	List<IoListVO> ioList;
	public IoListServiceImp(){
		ioList=new ArrayList<IoListVO>();
	}
	public void input() {
		IoListVO ioListVO;
		ioListVO=new IoListVO("2019-08-08","10:02:00", "햇반", 1000);
		ioList.add(ioListVO);
		
		ioListVO=new IoListVO("2019-08-09","11:02:00", "햇반", 1000);
		ioList.add(ioListVO);
		
		ioListVO=new IoListVO("2019-08-09","10:02:01", "햇반", 1000);
		ioList.add(ioListVO);
		
		ioListVO=new IoListVO("2019-08-09","10:02:10", "햇반", 1000);
		ioList.add(ioListVO);
		
		total();
	}//input end
	
	public void input(int count) {
		IoListVO ioListVO;
		Random rnd=new Random();
		
		for(int i=0; i<count; i++) {
			String strTime=String.format("14:00:%02d", i);
			int intH=rnd.nextInt(5)+1;
			int intQty=rnd.nextInt(30)+10;
			String strPName=String.format("일반미 %d 호", intH);
			ioListVO=new IoListVO("2019-08-09",strTime, strPName, 1000*intH,intQty);
			ioList.add(ioListVO);
		}
		total();
	}
	public void total() {
		//int nSize=ioList.size();
		/*for(int i=0;i<nSize;i++) {
			//vo.setIntTotal(vo.getIntQty(),vo.getIntPrice());
			IoListVO vo=ioList.get(i);
			int intTotal=vo.getIntQty()*vo.getIntPrice();
			vo.setIntTotal(intTotal);
		}*/
		for(IoListVO vo:ioList) {
			int intTotal=vo.getIntQty()*vo.getIntPrice();
			vo.setIntTotal(intTotal);
		}
	}
	public void list() {
		System.out.println("-----------------------------------------");
		System.out.println("거래내역");
		System.out.println("-----------------------------------------");
		System.out.println("상품\t\t단가\t수량\t날자\t\t거래시간\t합계");
		System.out.println("--------------------------------------------");
		for(IoListVO vo:ioList) {
			System.out.print(vo.getStrP_Name()+"\t");
			System.out.print(vo.getIntPrice()+"\t");
			System.out.print(vo.getIntQty()+"\t");
			System.out.print(vo.getStrDate()+"\t");
			System.out.print(vo.getstrTradedTime()+"\t");
			System.out.println(vo.getIntTotal()+"\n");
		}
		System.out.println("-------------------------------------------");
	}
}
