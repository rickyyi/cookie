/**
 * Created by Administrator on 2018/2/1 0001.
 */
/*

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.freeswitch.esl.client.transport.message.EslMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Freeswitch {
    //private static final Logger log = LoggerFactory.getLogger(Freeswitch.class);
    private static String host = "192.168.204.129";
    private static int port = 8021;
    private static String password = "ClueCon";

    private static final Client client = new Client();

    public static void inBand() {
        try {
            client.connect(host, port, password, 10);
        } catch (InboundConnectionFailure e) {
            //log.error("Connect failed", e);
            return;
        }
        //注册事件处理程序
        client.addEventListener(new IEslEventListener() {
            public void eventReceived(EslEvent event) {

                event.getEventHeaders().forEach((k,v) -> {
                    System.out.print(k + " : " + v + " ;");
                });

                System.out.println("\n");


                //System.out.println("Event received [{}]" + event.getEventHeaders());
                //记录接听次数和时间
                if (event.getEventName().equals("CHANNEL_ANSWER")) {
                    //your code here
                    System.out.println("接听电话");
                }
                if (event.getEventName().equals("HEARTBEAT")) {
                    //System.out.println("recieved Hearbeat event !" + event.getEventBodyLines());
                }
                if (event.getEventName().equals("CHANNEL_DESTROY")) {
                }
                if (event.getEventName().equals("CHANNEL_HANGUP_COMPLETE")) {
                    //挂断
                    System.out.println("挂断电话");
                }
            }

            public void backgroundJobResultReceived(EslEvent event) {
                String uuid = event.getEventHeaders().get("Job-UUID");
               // log.info("Background job result received+:" + event.getEventName() + "/" + event.getEventHeaders());// +"/"+JoinString(event.getEventHeaders())+"/"+JoinString(event.getEventBodyLines()));
            }
        });

        //定义事件日志输出格式,但是java esl 目前只支持plain格式    ，http://wiki.freeswitch.org/wiki/Event_Socket
        //2012-12-25 19:20:30  [ main:426 ] - [ ERROR ]  java.lang.IllegalStateException: Only 'plain' event format is supported at present
        client.setEventSubscriptions("plain", "all");

        // client.close();
    }

    public static void main(String[] args) {
        inBand();

        dialPhone(client, "1001");





        //System.out.println("event_socket_test".toUpperCase());
    }

    public static void dialPhone(Client client, String mobile){
        if(client != null){
            client.sendSyncApiCommand("originate","user/1000 7777");

            //client.sendSyncApiCommand("originate","user/1000 'start_asr:LTAIRLpr2pJFjQbY oxrJhiBZB5zLX7LKYqETC8PC8ulwh0,park' inline");
            // originate user/1000 'start_asr:LTAIRLpr2pJFjQbY oxrJhiBZB5zLX7LKYqETC8PC8ulwh0,park' inline
            //String response = client.sendAsyncApiCommand( "originate", "sofia/external/" + mobile + "@192.168.188.222 &playback(ivr/8000/mydoctestv2.wav)" );  //mydoctestv2
            // System.err.println("reponse--->" + response);
        }
    }
}
*/
