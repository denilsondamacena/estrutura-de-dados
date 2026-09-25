package controller;

import model.estrutura.Stack;

public class StackController {
	public StackController(){
		super();
	}
	
	public String teste() {
		Stack<Integer> stack = new Stack<>();
		
		stack.push( 1 );
		stack.push( 2 );
		//stack.pop();
		stack.push( 3 );
		
		return stack.toString();
	}
}
