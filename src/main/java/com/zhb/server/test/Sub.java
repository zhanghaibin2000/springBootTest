package com.zhb.server.test;

@DBTable2
public class Sub extends Super{

	private Sub(){}
	public Sub(int i){}
	private int subPrivateField;
	public int subPublicField;
	private int subPrivateMothed() {return 0;}
	public int subPublicMothed() {return 0;}
}
