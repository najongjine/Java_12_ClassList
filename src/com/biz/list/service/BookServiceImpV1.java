package com.biz.list.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.list.model.BookVO;

public class BookServiceImpV1 implements BookService {
	Scanner scan;
	List<BookVO> bookList;
	
	public BookServiceImpV1() {
		bookList=new ArrayList<BookVO>();
		scan=new Scanner(System.in);
	}//init
	public void inputBookInfo(int count) {
		for(int i=0;i<count;i++) {
			inputBookInfo();
		}
	}
	@Override
	public void inputBookInfo() {
		System.out.print("도서번호(IBSN) > ");
		String strIBSN=scan.nextLine();
		
		System.out.print("출판사 > ");
		String strPublisher=scan.nextLine();
		
		System.out.print("저자 > ");
		String strAuthor=scan.nextLine();
		
		System.out.print("도서명 > ");
		String strTitle=scan.nextLine();
		
		/*
		 * 이 코드에서 사용자가 데이터를 입력하는 중에 가격이나 출판연도를
		 * 숫자가 아닌 문자열을 입력 하게 되면 문자열을 숫자로 바꾸는 과정에서
		 * NumberFormatException이 발생할 것이다.
		 *(예:""값을 입력하면 exception)
		 *하나의 실수라도 입력하면 그동안 입력한 모든 데이터 날라감 
		 */
		System.out.print("출판년도 > ");
		String strPubYear=scan.nextLine();
		int intPubYear=0;
		
		try {
			intPubYear=Integer.valueOf(strPubYear);
		} catch (Exception e) {
			System.out.println("출판년도에 문자열이 포함됨!!");
			System.out.println("현재 도서는 정보 저장이 안됬음");
			return;
		}
		
		System.out.print("가격 > ");
		String strPrice=scan.nextLine();
		int intPrice=0;
		try {
			intPrice=Integer.valueOf(strPrice);
		} catch (Exception e) {
			System.out.println("가격에 문자열이 포함됨!!");
			System.out.println("현재 도서는 정보 저장이 안됬음");
			return;
		}
		
		BookVO bookVO=new BookVO();
		bookVO.setIntPrice(intPrice);
		bookVO.setIntPubYear(intPubYear);
		bookVO.setStrAuthor(strAuthor);
		bookVO.setStrISBN(strIBSN);
		bookVO.setStrPublisher(strPublisher);
		bookVO.setStrTitle(strTitle);
		
		bookList.add(bookVO);
	}

	@Override
	public void viewList() {
		System.out.println("--------------------------------------");
		System.out.println("도서정보");
		System.out.println("---------------------------------------");
		System.out.println("도서명\t저자\t가격\t출판사\t출판년도\t도서번호(ISBN)");
		for(BookVO vo:bookList) {
			System.out.printf("%s\t",vo.getStrTitle());
			System.out.printf("%s\t",vo.getStrAuthor());
			System.out.printf("%s\t",vo.getIntPrice());
			System.out.printf("%s\t",vo.getStrPublisher());
			System.out.printf("%s\t\t",vo.getIntPubYear());
			System.out.printf("%s\n",vo.getStrISBN());
		}
		System.out.println("----------------------------------------------");
	}

	@Override
	public void viewABook(int index) {
		int nSize=bookList.size();
		try {
			bookList.get(index);
		} catch (Exception e) {
			System.out.println("현재 찾으시려는 리스트는 없습니다");
			System.out.println("현재 리스트는 입력한 index보다 작은 크기입니다");
			System.out.println("현재 List의 마지막 인덱스: "+(nSize-1));
			return;
		}
		
		System.out.println("-----------------------------------");
		System.out.printf("%d번째 리스트의 도서정보",index);
		System.out.println("-------------------------------------");
		System.out.println("도서명: "+bookList.get(index).getStrAuthor());
		System.out.println("가격: "+bookList.get(index).getIntPrice());
		System.out.println("저자: "+bookList.get(index).getStrAuthor());
		System.out.println("도서번호(ISBN): "+bookList.get(index).getStrISBN());
		System.out.println("-------------------------------------------");
	}

	@Override
	public void viewABook(String strTitle) {
		boolean bVar=false;
		for(BookVO vo:bookList) {
			if(vo.getStrTitle().equalsIgnoreCase(strTitle)) {
				System.out.println("도서명: "+vo.getStrTitle());
				System.out.println("가격: "+vo.getIntPrice());
				System.out.println("저자: "+vo.getStrAuthor());
				System.out.println("도서번호(ISBN): "+vo.getStrISBN());
				bVar=true;
			}
		}
		if(!bVar)System.out.println("그런 도서명은 없음");
	}//end

}
