package com.fivedots.hello;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demonstrates anonymous inner classes.
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 *
 */
public class AnonymousInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		
		// Keep program running until user selects "OK"
		JOptionPane.showMessageDialog(null, "Quit Program");
		System.exit(0);
	}
}

/**
 * A clock that prints the time in regular intervals.
 *
 */
class TalkingClock
{
	/**
	 * Starts the clock
	 * @param interval the interval between messages (in milliseconds)
	 * @param beep true if the clock should beep
	 */
	public void start(int interval, final boolean beep)
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Date now = new Date();
				System.out.println("At the tone, the time is "+now);
				if(beep) Toolkit.getDefaultToolkit().beep();
			}
		};
		
		Timer t = new Timer(interval, listener);
		t.start();
	}
}