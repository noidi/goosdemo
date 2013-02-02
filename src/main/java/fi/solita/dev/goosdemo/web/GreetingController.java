package fi.solita.dev.goosdemo.web;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.solita.dev.goosdemo.domain.Greeter;
import fi.solita.dev.goosdemo.domain.MeetingListener;

@Controller
public class GreetingController {

    @Autowired
    private Greeter greeter;

    @Autowired(required = false)
    private Collection<MeetingListener> meetingListeners = Collections.emptyList();

    @RequestMapping("/greeting/{name}")
    @ResponseBody
    public String greeting(@PathVariable String name) {
        String greeting = greeter.greet(name);
        for (MeetingListener listener : meetingListeners) {
            listener.personMet(name);
        }
        return greeting;
    }

}
