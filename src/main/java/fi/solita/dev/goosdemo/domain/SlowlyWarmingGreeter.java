package fi.solita.dev.goosdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlowlyWarmingGreeter implements Greeter {

    @Autowired
    private MeetingHistory meetingHistory;

    @Override
    public String greet(String name) {
        if (meetingHistory.timesMet(name) == 0) {
            return "What do you want? Beat it!";
        } else if (meetingHistory.timesMet(name) < 5) {
            return String.format("Hello, %s!", name);
        } else {
            return String.format("Hey, %s! Great to see you!", name);
        }
    }

}
