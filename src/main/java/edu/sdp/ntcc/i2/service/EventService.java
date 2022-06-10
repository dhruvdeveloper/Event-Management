package edu.sdp.ntcc.i2.service;

import edu.sdp.ntcc.i2.model.Events;
import edu.sdp.ntcc.i2.payload.EventProposalPayload;
import edu.sdp.ntcc.i2.repository.EventDetailsProxyRepository;
import edu.sdp.ntcc.i2.repository.EventProposalProxyRepository;
import edu.sdp.ntcc.i2.repository.UserDetailsProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventTemplate eventTemplate;

    @Autowired
    private EventDetailsProxyRepository eventDetailsProxyRepository;

    @Autowired
    private UserDetailsProxyRepository userDetailsProxyRepository;

    @Autowired
    private EventProposalProxyRepository eventProposalProxyRepository;

    public Events fetchEventDetails(Events event) {

        Optional<Events> eventDB = eventDetailsProxyRepository.findById(event.getEventId());
        if (eventDB.isPresent()) {
            return eventDB.get();
        }
        return null;

    }


    public List<Events> getAllEvents() {
        eventTemplate = new GetEventImpl(eventDetailsProxyRepository);
        return eventTemplate.getAllEvents();
    }

    public Events getEvent(Integer eventId) {
        eventTemplate = new GetEventImpl(eventDetailsProxyRepository);
        return eventTemplate.getEvent(eventId);
    }

    public void saveEventProposal(EventProposalPayload eventProposal) {
        eventTemplate = new SaveEventImpl(eventProposalProxyRepository, userDetailsProxyRepository);
        eventTemplate.saveEventProposal(eventProposal);
    }

}
