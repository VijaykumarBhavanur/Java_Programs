package com.bridgelabz.designPatterns.VisitorPattern;

public class TPLinkRouter implements Router{
	 
    @Override
    public void sendData(char[] data) {
    }
 
    @Override
    public void acceptData(char[] data) {
    }
     
    @Override
    public void accept(RouterVisitor v) {
        v.visit(this);
    }
}