package com.biz.list.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.biz.list.model.BookVO;
/*
 * 	private String strISBN;
	private String strTitle;
	private String strAuthor;
	private String strPublisher;
	private int intPrice;
	private int intPubYear;
 */

public class BookServiceImpV2 implements BookService{
	private Scanner scan;
	private List<BookVO> bookList;
	private int listCount;
	public BookServiceImpV2() {
		bookList=new ArrayList<BookVO>();
		scan=new Scanner(System.in);
	}
	@Override
	public void inputBookInfo() {
		System.out.printf("---------------%d 번째 도서정보 입력-----------------\n",listCount++);
		System.out.print("도서명 > ");
		String strTitle=scan.nextLine();
		System.out.print("도서번호(IBSN) > ");
		String strISBN=scan.nextLine();
		System.out.print("저자 > ");
		String strAuthor=scan.nextLine();
		System.out.print("출판사 > ");
		String strPublisher=scan.nextLine();
		System.out.print("가격 > ");
		String strPrice=scan.nextLine();
		int intPrice=0;
		try {
			intPrice=Integer.valueOf(strPrice); //NumberFormatException
		} catch (Exception e) {
			/*
			 * 현재 input() method에서 exception이 살생하면
			 * 호출한 곳에 exception이 발생했다고 알려주고 그곳에서 처리 하도록 
			 * 하면 된다.
			 * throw: 나(input() method)를 호출한 곳으로 예외를 던진다.
			 */
			System.out.println("숫자에 문자열이 포함되어 입력됬습니다!!");
			throw new NumberFormatException();// 자신을 호출한 곳으로 exception 메세지 던짐
		}
		
		System.out.println("출판년도 > ");
		String strPubYear=scan.nextLine();
		int intPubYear=0;
		try {
			intPubYear=Integer.valueOf(strPubYear);
		} catch (Exception e) {
			System.out.println("숫자에 문자열이 포함되어 입력됬습니다. \n 현재 정보는 입력되지 않습니다.");
			throw new NumberFormatException();
		}
		
		System.out.println("-------------------------------------------------");
		
		BookVO bVO=new BookVO();
		bVO.setIntPrice(intPrice);
		bVO.setIntPubYear(intPubYear);
		bVO.setStrAuthor(strAuthor);
		bVO.setStrISBN(strISBN);
		bVO.setStrPublisher(strPublisher);
		bVO.setStrTitle(strTitle);
		
		bookList.add(bVO);
		
	}

	@Override
	public void inputBookInfo(int count) {
		for(int i=0;i<count;i++) {
			try {
				inputBookInfo();
			} catch (Exception e) {
				System.out.println("데아터를 다시 입력하세요");
				i--;
				listCount--;
				continue;
			}
		}
		
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
		BookVO vo=bookList.get(index);
		System.out.println("-----------------------------------");
		System.out.printf("%d번째 리스트의 도서정보",index);
		System.out.println("-------------------------------------");
		System.out.println("도서명: "+vo.getStrAuthor());
		System.out.println("가격: "+vo.getIntPrice());
		System.out.println("저자: "+vo.getStrAuthor());
		System.out.println("도서번호(ISBN): "+vo.getStrISBN());
		System.out.println("-------------------------------------------");
		
	}

	@Override
	public void viewABook(String strTitle) {
		boolean bVar=false;
		String voStrName="";
		for(BookVO vo:bookList) {
			voStrName=vo.getStrTitle();
			/*if(vo.getStrTitle().equalsIgnoreCase(strTitle)) {
				System.out.println("도서명: "+vo.getStrTitle());
				System.out.println("가격: "+vo.getIntPrice());
				System.out.println("저자: "+vo.getStrAuthor());
				System.out.println("도서번호(ISBN): "+vo.getStrISBN());
				bVar=true;
			}*/
			//중간문자열 검색
			if(voStrName.toUpperCase().contains(strTitle.toUpperCase())) {
				System.out.println("도서명: "+vo.getStrTitle());
				System.out.println("가격: "+vo.getIntPrice());
				System.out.println("저자: "+vo.getStrAuthor());
				System.out.println("도서번호(ISBN): "+vo.getStrISBN());
				bVar=true;
			}
		}
		if(!bVar)System.out.println("그런 도서명은 없음");
		
	}
	
}
