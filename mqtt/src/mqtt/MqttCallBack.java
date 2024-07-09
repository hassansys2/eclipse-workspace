package mqtt;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import java.net.*;

public class MqttCallBack {
  //public static final String BROKER_URL = "tcp://iot.eclipse.org:1883";
  public static final String BROKER_URL = "tcp://localhost:1883";
  private MqttClient client;
  String topic = "Demo Topic";

  public static void main(String[] args) {
    System.out.println("MQTT Broker: " + BROKER_URL);
    new MqttCallBack();
  }

  public MqttCallBack() {
    String clientId = getMacAddress() + "-sub";
    System.out.println("Client ID = " + clientId);
    try   {
      client = new MqttClient(BROKER_URL, clientId);
      client.connect();
      client.setCallback(new SubscribeCallback());
      client.subscribe(topic);
    } catch (MqttException e) {
      e.printStackTrace(); System.exit(1);
    }
  }

  public byte[] getMacAddress(){
    byte[] mac = new byte[6];
    try{
      InetAddress address = InetAddress.getLocalHost();
      NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
      mac = nwi.getHardwareAddress();
      System.out.println(mac);
    } catch(Exception e) {
      System.out.println(e);
    }
    return mac;
  }
}

class SubscribeCallback implements MqttCallback {
  @Override
  public void connectionLost (Throwable cause) { }
  @Override
  public void messageArrived (String topic, MqttMessage message) {
    System.out.println("Message arrived. Topic: " + topic
    + " Message: " + message.toString());
    if ("I'm gone".equals(topic)) {
      System.out.println("Sensor gone!");
    }
  }
  @Override
  public void deliveryComplete (IMqttDeliveryToken token) { }
}