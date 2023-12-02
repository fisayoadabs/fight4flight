package io.group02.fight4flight.service;

import java.util.List;

import io.group02.fight4flight.model.CrewMember;

public interface CrewMemberService {
    public CrewMember saveCrew(CrewMember customer);

    public List<CrewMember> getAllCrewMembers();

    public void assignCrewToFlight(Long crewMemberId, Long flightId);

    public void removeCrewToFlight(Long crewMemberId, Long flightId);
}