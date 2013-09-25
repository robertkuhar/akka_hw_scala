package com.example.java;

import akka.actor.*;

public class Greeter extends UntypedActor {
    public enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive( Object msg ) throws Exception {
        if ( msg == Msg.GREET ) {
            System.out.println( String.format( "Hello World from %s", getClass().getName() ) );
            getSender().tell( Msg.DONE, getSelf() );
        } else {
            unhandled( msg );
        }
    }
}
