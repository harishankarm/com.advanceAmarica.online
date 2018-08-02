package com.advanceAmerica.unitTest;

public class Contructoreg extends one {
	
	/*static int count =0;
	//Instance block
	{
		count++;
	}
	
	//No Complier error but worst prg 
	public void Contructoreg()
	{
		System.out.println("Worst");
	}
	//No Complier error but worst prg 
	public int Contructoreg(int i)
	{
		return i;
		
	}
	
	public Contructoreg()
	{
		System.out.println("empty");
	}
	public Contructoreg(int i)
	{
		System.out.println("Int");
	}
	public Contructoreg(double d)
	{
		System.out.println("Double");
	}*/

	public static void main(String[] args) {
	
		System.out.println("Hi");
		/*
		Contructoreg c1 = new Contructoreg();
		Contructoreg c2 = new Contructoreg(20);
		Contructoreg c3 = new Contructoreg(29.34);
		System.out.println(count);
		c1.Contructoreg();
		c1.Contructoreg(10);*/
		Contructoreg c1 = new Contructoreg();
		c1.two();
		c1.three();
	}
	
	public void two() {
		System.out.println("Two");
	}
	

}

abstract class one
{
	public one()
	{
		System.out.println("One");	
	}
	abstract public void two();
	public void three(){
	System.out.println("Three");	
	}
	
}

interface name
{
void qname();

}

class a
{
	a(int i)
	{
		
	}
}
class b extends a{

	b(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	
	
}