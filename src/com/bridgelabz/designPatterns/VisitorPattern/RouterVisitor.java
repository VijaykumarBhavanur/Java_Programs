package com.bridgelabz.designPatterns.VisitorPattern;

public interface RouterVisitor 
{
    public void visit(DLinkRouter router);
    public void visit(TPLinkRouter router);
    public void visit(LinkSysRouter router);
}