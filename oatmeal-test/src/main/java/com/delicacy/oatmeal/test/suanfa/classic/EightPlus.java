/*【程序8】
作者 若水飞天
题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。 
 */

/*
* 算法： 定义一个变量b， 赋初值为0；定义一变量sum， 赋初值为0，
* 进入循环后，将a + b 的值赋给b，将sum + b 的值赋给sum；
* 同时，将a 增加十倍， ++ i； 继续循环；
* 循环结束后，输出sum 的值。
*/
package com.delicacy.oatmeal.test.suanfa.classic;

import java.util.Scanner;

public class EightPlus {
	static long a = 2, b = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 0;
		long sum = 0;
		while (i < n) {
			b = b + a;
			System.out.println(b);
			sum = sum + b;
			a = a * 10;
			++i;
		}
		System.out.println("input number: " + n);
		System.out.println(sum);
	}
}