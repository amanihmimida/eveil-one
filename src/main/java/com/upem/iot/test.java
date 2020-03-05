package com.upem.iot;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class test {

	
	public static void main(String[] args) throws MqttException {
		 CountDownLatch latch = new CountDownLatch(30);
		PahoDemo demo = new  PahoDemo();
		demo.doDemo();
		
		MqttClient mqttClient = new MqttClient("tcp://mr2aqty0xnech1.messaging.solace.cloud:20966", "HelloWorldSub");
		MqttConnectOptions connectionOptions = new MqttConnectOptions();
		connectionOptions.setUserName("solace-cloud-client");
		connectionOptions.setPassword("cljvbkb0l1ineecvafr9863d2o".toCharArray());
		mqttClient.connect(connectionOptions);
		
		mqttClient.setCallback(new MqttCallback() {

		    public void messageArrived(String topic, MqttMessage message) throws Exception {
		        String time = new Timestamp(System.currentTimeMillis()).toString();
		        System.out.println("\nReceived a Message!" +
		            "\n\tTime:    " + time +
		            "\n\tTopic:   " + topic +
		            "\n\tMessage: " + new String(message.getPayload()) +
		            "\n\tQoS:     " + message.getQos() + "\n");
		         latch.countDown(); // unblock main thread
		         
		    }

		    public void connectionLost(Throwable cause) {
		        System.out.println("Connection to Solace broker lost!" + cause.getMessage());
		        latch.countDown();
		    }

		    public void deliveryComplete(IMqttDeliveryToken token) {
		    }

		});
		
		mqttClient.subscribe("T/GettingStarted/pubsub", 0);
		
		try {
		    latch.await(); // block here until message received, and latch will flip
		} catch (InterruptedException e) {
		    System.out.println("I was awoken while waiting");
		}
		
		MqttMessage message = new MqttMessage("Hello world from MQTT!".getBytes());
		message.setQos(0);
		mqttClient.publish("T/GettingStarted/pubsub", message);
			
	}
	
	

	
	
	void firsttry() {
		/*
		MqttClient subscriber;

		String publisherId = UUID.randomUUID().toString();
		IMqttClient publisher = new MqttClient("tcp://iot.eclipse.org:1883",publisherId);
		
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		publisher.connect(options);
		
		
		subscriber = new MqttClient("tcp://192.168.118.11:1883", "Subscribing");
		
		CountDownLatch receivedSignal = new CountDownLatch(10);
		subscriber.subscribe("TOPIC", (topic, msg) -> {
		    byte[] payload = msg.getPayload();
		   
		    receivedSignal.countDown();
		});    
		try {
			receivedSignal.await(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	*/
	}
}
