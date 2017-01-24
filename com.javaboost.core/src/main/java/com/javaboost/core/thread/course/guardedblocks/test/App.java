package com.javaboost.core.thread.course.guardedblocks.test;

public class App {
	public static void main(String[] args) {
		MailBox lMailBox = new MailBox();

		new Thread(new Sender(lMailBox)).start();
		new Thread(new Receiver(lMailBox)).start();
	}
}

class MailBox {
	private String message = "";
	private boolean empty;
	private volatile static boolean anyMoreMessages = false;

	public synchronized void postMessage(String pString) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Post Waiting Interrupted");
			}
		}
		this.message = pString;

		empty = false;

		notifyAll();

	}

	public synchronized String readMessage() {
		while (empty) {
			try {
				System.out.println("READ Waiting");
				wait(10000);
				if(!isThereAnyMoreMessages()){
					break;
				}
				
				System.out.println("READ Resume");
			} catch (InterruptedException e) {
				System.out.println("Post Waiting Interrupted");
			}

		}

		String lMessage = message;
		message = "_BLANK_";
		empty = true;
		notifyAll();
		return lMessage;
	}

	public void setNoMoreMessages() {
		System.out.println("No More Messages....");
		anyMoreMessages = false;
	}

	public void setMoreMessages() {
		anyMoreMessages = true;
	}

	public static boolean isThereAnyMoreMessages() {
		return anyMoreMessages;
	}

}

class Sender implements Runnable {

	public Sender(MailBox pMailBox) {
		super();
		mailBox = pMailBox;
	}

	private MailBox mailBox;

	@Override
	public void run() {

		mailBox.setMoreMessages();
		String[] lMessages = { "Hi", "Good Morning", "How are you" };
		for (int lI = 0; lI < lMessages.length; lI++) {
			mailBox.postMessage(lMessages[lI]);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mailBox.setNoMoreMessages();
		System.out.println("All msgs posted");

	}
}

class Receiver implements Runnable {
	private MailBox mailBox;

	public Receiver(MailBox pMailBox) {
		mailBox = pMailBox;
	}

	@Override
	public void run() {

		while (MailBox.isThereAnyMoreMessages()) {
			boolean lThereAnyMoreMessages = MailBox.isThereAnyMoreMessages();
			String lMessage = mailBox.readMessage();
			System.out.println(lMessage);
		}

		System.out.println("All msgs read");

	}
}
