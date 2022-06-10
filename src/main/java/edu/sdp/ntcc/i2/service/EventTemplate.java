package edu.sdp.ntcc.i2.service;

import edu.sdp.ntcc.i2.model.Events;
import edu.sdp.ntcc.i2.payload.EventProposalPayload;

import java.util.List;


public abstract class EventTemplate {

    abstract public void saveEventProposal(EventProposalPayload eventProposal);

    abstract public List<Events> getAllEvents();

    abstract public Events getEvent(Integer eventId);

}