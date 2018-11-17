
package myUberTools;

import myUberCustomer.Customer;

public class Message {
	
	private int messageID;

	static int messageCounter;
	
	public String text;
	
	public Message(String text) {
		this.messageID=messageCounter;
		messageCounter++;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	//j'hésite entre ces deux versions
	
	//public void sendMessage(Customer customer) {
		//customer.getMessageBox().add(this);		
	//}
	
//	public void sendMessage(Customer customer, String text) {
	//	Message message = new Message(text);
		//customer.getMessageBox().add(message);
	//}
	
	
}
