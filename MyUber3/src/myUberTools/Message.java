
package myUberTools;

import myUberCustomer.Customer;

/**
 * This class provide a message box service for the user. Each message is characterized by a unique ID obtained through a singleton pattern. 
 * @author Cuignet & Thi�baud
 *
 */
public class Message {
	
	private int messageID;

	static int messageCounter;
	
	public String text;
	
	public Message(String text) {
		this.setMessageID(messageCounter);
		messageCounter++;
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void sendMessage(Customer customer, String text) {
		Message message = new Message(text);
		customer.getMessageBox().add(message);
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	
	

	
	
}
