/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitah;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static twitah.Metodos.cb;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Brian
 */
public class Metodos {

    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status status;
    static DirectMessage message;
    static ArrayList<Status> twits = new ArrayList<Status>();
    static Iterator<Status> it = twits.iterator();

    public Metodos() {

    }

    /**
     * Setting up twitter permissions to send and receive
     */
    public static void conecta() {
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("yFIIR0UR9q2HNaFEkQMUTVjVu");
        cb.setOAuthConsumerSecret("LVTz8Hpp9Ub6gNxaz4fwIqXhj92b44KZ8cnwoTwuVILpNuB6z1");
        cb.setOAuthAccessToken("285664852-eeZj0GBgkMsFwnLKLj4xfowdVXujqdvu174lrx8i");
        cb.setOAuthAccessTokenSecret("svAHdGjn3W7BXas3stbDoDJm4oy0iCndTCFvlr1A9c7HZ");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

    }

    /**
     * Used to collect the user's twitter timeline in a collection.
     */
    public static void lineaTiempo() {

     List<Status> statuses = null;

        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);
            }

    }

    /**
     * Used to tweet new states, typing them on the keyboard.
     * @param latestStatus the status update message.
     */
    public static void twitear(String latestStatus) {

      
        try {
            status = twitter.updateStatus(latestStatus);
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
       

    }

    /**
     * Used to search for twits
     *
     * @param busca String where we enter the content to search
     */
    public static void buscarTwit(String busca) {

        Query query = new Query(busca);
        QueryResult result;
        try {
            result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());

            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Used to send private messages, only to people who Follow or follow us.
     * @param destinatario address of twitter where we want to send the message
     * @param mensaje Contains the string of characters to send
     */
    public static void enviarMensaje(String destinatario, String mensaje) {

        try {

            message = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());

    }

   
}
