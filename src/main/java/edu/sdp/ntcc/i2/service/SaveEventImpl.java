package edu.sdp.ntcc.i2.service;

import edu.sdp.ntcc.i2.model.EventProposal;
import edu.sdp.ntcc.i2.model.Events;
import edu.sdp.ntcc.i2.model.User;
import edu.sdp.ntcc.i2.payload.EventProposalPayload;
import edu.sdp.ntcc.i2.repository.EventProposalProxyRepository;
import edu.sdp.ntcc.i2.repository.UserDetailsProxyRepository;

import java.util.List;
import java.util.Optional;


public class SaveEventImpl extends EventTemplate {

    private EventProposalProxyRepository eventProposalProxyRepository;

    private UserDetailsProxyRepository userDetailsProxyRepository;

    public SaveEventImpl(EventProposalProxyRepository eventProposalProxyRepository, UserDetailsProxyRepository userDetailsProxyRepository) {
        this.eventProposalProxyRepository = eventProposalProxyRepository;
        this.userDetailsProxyRepository = userDetailsProxyRepository;
    }

    @Override
    public void saveEventProposal(EventProposalPayload eventProposal) {
        Optional<User> user = userDetailsProxyRepository.getUserByEmail(eventProposal.getEmail());
        System.out.println(user);
        EventProposal events = new EventProposal(eventProposal.getName(),
                eventProposal.getDomain(), eventProposal.getDescription(), user.get().getId());

        eventProposalProxyRepository.save(events);
    }

    @Override
    public List<Events> getAllEvents() {
        return null;
    }

    @Override
    public Events getEvent(Integer eventId) {
        return null;
    }
}
