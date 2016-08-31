package se.mah.k3.klara;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

public class BT {
	private static Object lock=new Object();
	private LocalDevice localDevice;
	private DiscoveryAgent agent;
	private boolean scanning = true;
	public BT() {
		try{
            // 1
            localDevice = LocalDevice.getLocalDevice();

            // 2
            agent = localDevice.getDiscoveryAgent();
            final StringBuffer sb = new StringBuffer(); 
            
            // Get the device's Bluetooth address 
            sb.append("Bluetooth Address: "); 
            sb.append(localDevice.getBluetoothAddress()); 
            sb.append('\n'); 
     
            // Get the device's Bluetooth friendly name 
            sb.append("Bluetooth friendly name: "); 
            sb.append(localDevice.getFriendlyName()); 
            sb.append('\n'); 
     
            System.out.println(sb.toString());       
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void startInquiry(int interval){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (scanning){
				System.out.println("-------Scan started---------");
					try {
						agent.startInquiry(DiscoveryAgent.GIAC, new MyDiscoveryListener());
					} catch (BluetoothStateException e1) {
						System.out.println(e1.getMessage());
					}
					try {
						synchronized(lock){
			                lock.wait();
			            }
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					System.out.println("-------Scan Finished---------");
					try {
						Thread.sleep(interval);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void stopInquiry(){
		scanning = false;
	}
	
private class MyDiscoveryListener implements DiscoveryListener{
	    
	    @Override
	    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass arg1) {
	        String name;
	        String id ="";
	        try {
	            name = btDevice.getFriendlyName(false);
	            id = btDevice.getBluetoothAddress();
	            //btDevice.
	        } catch (Exception e) {
	            name = btDevice.getBluetoothAddress();
	           
	        }
	        System.out.println("-------------");
	        System.out.println("device found: " + name);
	        System.out.println("With BluetoothAddress: " + id);
	        
	    }

	    @Override
	    public void inquiryCompleted(int arg0) {
	        synchronized(lock){
	            lock.notify();
	        }
	    }

	    @Override
	    public void serviceSearchCompleted(int transID, int respCode) {
	    	if (DiscoveryListener.SERVICE_SEARCH_COMPLETED == respCode){
	    		System.out.println("Service search completed"+transID);
	    	}
	    }

	    @Override
	    public void servicesDiscovered(int arg0, ServiceRecord[] arg1) {
	    	for (ServiceRecord serviceRecord : arg1) {
				if (serviceRecord.getAttributeValue(0x0100)!=null){
					System.out.println("Service"+serviceRecord.getAttributeValue(0x0100));
				}
			}
	    }

	}

}
