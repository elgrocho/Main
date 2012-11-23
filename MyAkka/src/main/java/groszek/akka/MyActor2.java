package groszek.akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyActor2 extends UntypedActor {
  LoggingAdapter log = Logging.getLogger(getContext().system(), this);

  public void onReceive(Object message) {
    if (message instanceof String)  {
        log.info("Received String message: {}", message);
        getContext().actorFor("akka://MySystem/user/myactor").tell("Talking to actor 1");
    } else {
      unhandled(message);
    }
  }
}