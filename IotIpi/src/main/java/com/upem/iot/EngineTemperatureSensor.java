package com.upem.iot;

import java.util.concurrent.Callable;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class EngineTemperatureSensor implements Callable<Void> {

	private MqttClient client;
	private MqttClient subClient;
	
	public EngineTemperatureSensor() {
		 try {
			 
			client = new MqttClient("tcp://192.168.118.11:1883", "Sending");
			 subClient = new MqttClient("tcp://192.168.118.11:1883", "Subscribing");
			 
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Void call() throws Exception {
		if ( !client.isConnected()) {
			return null;
		}           
		MqttMessage msg = readEngineTemp();
		msg.setQos(0);
		msg.setRetained(true);
		client.publish("lola",msg);        
		return null;        
	}

	
	
	private MqttMessage readEngineTemp() {             
		double temp =  80 + 10 * 20.0;        
		byte[] payload = String.format("T:%04.2f",temp)
				.getBytes();        
		return new MqttMessage(payload);           
	}
	
	
	
	
	





}
