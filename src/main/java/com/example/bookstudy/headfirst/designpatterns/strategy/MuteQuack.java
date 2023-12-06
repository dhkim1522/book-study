package com.example.bookstudy.headfirst.designpatterns.strategy;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
