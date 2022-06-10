package edu.sdp.ntcc.i2.controller;

import edu.sdp.ntcc.i2.model.Events;
import edu.sdp.ntcc.i2.model.Payments;
import edu.sdp.ntcc.i2.payload.EventProposalPayload;
import edu.sdp.ntcc.i2.payload.EventsPayload;
import edu.sdp.ntcc.i2.payload.PaymentPayload;
import edu.sdp.ntcc.i2.service.EventService;
import edu.sdp.ntcc.i2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/eventProposal")
    public String eventProposal(Model model){
        model.addAttribute("eventProposal", new EventProposalPayload());
        return "eventProposal";
    }

    @PostMapping("/eventProposalSuccess")
    public String eventProposal(@ModelAttribute("eventProposal") EventProposalPayload eventProposal) {
        eventService.saveEventProposal(eventProposal);
        return "eventProposalSubmit";
    }

    @GetMapping("/events")
    public String events(Model model){

        List<EventsPayload> eventsPayloadList = new ArrayList<>();

        for (Events event : eventService.getAllEvents()){

            EventsPayload eventsPayload = new EventsPayload(
                    event.getEventId(), event.getName(),
                    event.getDescription(), event.getDomain(),
                    event.getProposalId(), event.getDate().toLocalDate().toString());

            eventsPayloadList.add(eventsPayload);
        }

        model.addAttribute("events", eventsPayloadList);
        model.addAttribute("eventId", new EventsPayload());
        return "events";
    }

    @PostMapping("/payment")
    public String register(@ModelAttribute("eventId") EventsPayload eventsPayload, Model model) {

        Events eventDetail = eventService.getEvent(eventsPayload.getEventId());

        EventsPayload eventsPayload1 = new EventsPayload(eventDetail.getEventId(),
                eventDetail.getName(),
                eventDetail.getDescription(),
                eventDetail.getDomain(),
                eventDetail.getProposalId(),
                eventDetail.getDate().toLocalDate().toString());

        model.addAttribute("event", eventsPayload1);
        model.addAttribute("paymentDetails", new PaymentPayload());
        return "payment";
    }

    @PostMapping("/paymentSuccess")
    public String payment(@ModelAttribute("paymentDetails") PaymentPayload paymentPayload, Model model) {

        Events eventDetail = eventService.getEvent(paymentPayload.getEventId());

        paymentPayload.setAmount(10);

        paymentService.processPayment(paymentPayload);

        EventsPayload eventsPayload1 = new EventsPayload(eventDetail.getEventId(),
                eventDetail.getName(),
                eventDetail.getDescription(),
                eventDetail.getDomain(),
                eventDetail.getProposalId(),
                eventDetail.getDate().toLocalDate().toString());

        model.addAttribute("event", eventsPayload1);

        return "paymentSuccess";
    }

}
