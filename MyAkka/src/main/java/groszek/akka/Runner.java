package groszek.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Runner {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MySystem");
        ActorRef myActor = system.actorOf(new Props(MyActor1.class), "myactor");
        ActorRef myActor2 = system.actorOf(new Props(MyActor2.class), "myactor2");
        myActor.tell("TELL");
    }

}
