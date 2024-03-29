package com.bridgelabz.designPatterns.VisitorPattern;

public class TestVisitorPattern
{
    private MacConfigurator macConfigurator;
    private LinuxConfigurator linuxConfigurator;
    private DLinkRouter dlink;
    private TPLinkRouter tplink;
    private LinkSysRouter linksys;
     
    public void setUp()
    {
        macConfigurator = new MacConfigurator();
        linuxConfigurator = new LinuxConfigurator();
         
        dlink = new DLinkRouter();
        tplink = new TPLinkRouter();
        linksys = new LinkSysRouter();
    }
     
    public void testDlink()
    {
        dlink.accept(macConfigurator);
        dlink.accept(linuxConfigurator);
    }
     
    public void testTPLink()
    {
        tplink.accept(macConfigurator);
        tplink.accept(linuxConfigurator);
    }
     
    public void testLinkSys()
    {
        linksys.accept(macConfigurator);
        linksys.accept(linuxConfigurator);
    }
    
    public static void main(String[] args) {
		TestVisitorPattern test=new TestVisitorPattern();
		test.setUp();
		test.testDlink();
		test.testLinkSys();
		test.testTPLink();
	}
}
 