package groszek.akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyActor1 extends UntypedActor {
  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  public void onReceive(Object message) {
    if (message instanceof String)  {
        log.info("Received String message: {}", message);
        getContext().actorFor("akka://MySystem/user/myactor2").tell("Talking to actor 2");
    } else {
      unhandled(message);
    }
  }
}