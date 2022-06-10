package edu.sdp.ntcc.i2.service;

import edu.sdp.ntcc.i2.model.Events;
import edu.sdp.ntcc.i2.payload.EventProposalPayload;
import edu.sdp.ntcc.i2.repository.EventDetailsProxyRepository;

import java.util.List;

public class GetEventImpl extends EventTemplate {

    private EventDetailsProxyRepository eventDetailsProxyRepository;

    public GetEventImpl(EventDetailsProxyRepository eventDetailsProxyRepository) {
        this.eventDetailsProxyRepository = eventDetailsProxyRepository;
    }

    @Override
    public void saveEventProposal(EventProposalPayload eventProposal) {

    }

    @Override
    public List<Events> getAllEvents() {

        List<Events> events = eventDetailsProxyRepository.findAll();
        events.stream().forEach(System.out::println);
        return events;
    }

    @Override
    public Events getEvent(Integer eventId) {
        return eventDetailsProxyRepository.getByEventId(eventId);
    }
}
