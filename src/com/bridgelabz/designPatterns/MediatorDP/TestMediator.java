package com.bridgelabz.designPatterns.MediatorDP;

public class TestMediator {

	    public static void main(String[] args)
	    {
	        IChatRoom chatroom = new ChatRoom();
	         
	        User user1 = new ChatUser(chatroom,"1", "Ram");
	        User user2 = new ChatUser(chatroom,"2", "Raj");
	        User user3 = new ChatUser(chatroom,"3", "Charu");
	        User user4 = new ChatUser(chatroom,"4", "Danush");
	         
	        chatroom.addUser(user1);
	        chatroom.addUser(user2);
	        chatroom.addUser(user3);
	        chatroom.addUser(user4);
	 
	        user1.send("Hello Raj", "2");
	        user2.send("Hey buddy", "1");
	    }
}
