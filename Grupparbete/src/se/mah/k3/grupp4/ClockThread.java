package se.mah.k3.grupp4;

import java.text.DecimalFormat;
import java.util.Calendar;

//kör klockan 
	public class ClockThread extends Thread{
	private Gui2 gui2;
	private TestGUI testGUI;			
		        public ClockThread(Gui2 gui22) {
		// TODO Auto-generated constructor stub
		        	this.gui2 = gui22;

		        }
				public ClockThread(TestGUI testGUI) {
					// TODO Auto-generated constructor stub
					this.testGUI=testGUI;

				}
				@Override
				public void run(){
		        	
		        	DecimalFormat decimalFormat = new DecimalFormat("00");
		
						while(true) {
							
						Calendar cal = Calendar.getInstance();
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);

						gui2.setTimeOnLabel("" + decimalFormat.format(hour) + ":" +decimalFormat.format(minute) + ":" + decimalFormat.format(second));
		
						//testGUI.setTimeOnLabel("" + decimalFormat.format(hour) + ":" +decimalFormat.format(minute) + ":" + decimalFormat.format(second));
				
						
						try {
							Thread.sleep(900);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
						
						
		
					}
				}
				
			}
				
	

