package fi.solita.dev.goosdemo.domain;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class InMemoryMeetingHistory implements MeetingHistory, MeetingListener {

    private HashMap<String, Integer> meetingCount = new HashMap<String, Integer>();

    @Override
    public synchronized int timesMet(String name) {
        Integer count = meetingCount.get(name);
        return (count == null) ? 0 : count;
    }

    @Override
    public synchronized void personMet(String name) {
        Integer oldCount = meetingCount.get(name);
        Integer newCount = (oldCount == null) ? 1 : oldCount + 1;
        meetingCount.put(name, newCount);
    }

}
