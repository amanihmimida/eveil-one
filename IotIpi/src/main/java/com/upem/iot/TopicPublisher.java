package com.upem.iot;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * A Mqtt topic publisher 
 *
 */
public class TopicPublisher {
    
    public void run(String... args) {
        System.out.println("TopicPublisher initializing...");

        String host = args[0];
        String username = args[1];
        String password = args[2];

        try {
            // Create an Mqtt client
            MqttClient mqttClient = new MqttClient(host, "HelloWorldPub");
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
            
            // Connect the client
            System.out.println("Connecting to Solace messaging at " + host);
            mqttClient.connect(connOpts);
            System.out.println("Connected");

            // Create a Mqtt message
            String content = "Hello world from MQTT!";
            MqttMessage message = new MqttMessage(content.getBytes());
            // Set the QoS on the Messages - 
            // Here we are using QoS of 0 (equivalent to Direct Messaging in Solace)
            message.setQos(0);
            
            System.out.println("Publishing message: " + content);
            
            // Publish the message
            mqttClient.publish("T/GettingStarted/pubsub", message);
            
            // Disconnect the client
            mqttClient.disconnect();
            
            System.out.println("Message published. Exiting");

            System.exit(0);
        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        new TopicPublisher().run("tcp://mr2aqty0xnech1.messaging.solace.cloud:20966" , "solace-cloud-client","cljvbkb0l1ineecvafr9863d2o");
    }
}