package com.biz.list.exec;

public class TryCatch {

	public static void main(String[] args) {
		int num1=0, num2=0, num3=0;
		
		try {
			num1=Integer.valueOf("30");
		} catch (Exception e) {
			System.out.println("입력한 값에 문자열이 포함됨. 숫자로 변환을 못함!");
		}
		try {
			num2=Integer.valueOf("30 ");
		} catch (Exception e) {
			System.out.println("입력한 값에 문자열이 포함됨. 숫자로 변환을 못함!");
		}
		try {
			num2=Integer.valueOf("30");
		} catch (Exception e) {
			System.out.println("입력한 값에 문자열이 포함됨. 숫자로 변환을 못함!");
		}
		
		int sum=num1+num2+num3;
		
		System.out.println(sum);
	}

}
