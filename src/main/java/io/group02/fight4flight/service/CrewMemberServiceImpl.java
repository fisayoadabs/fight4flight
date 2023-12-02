package io.group02.fight4flight.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.group02.fight4flight.model.CrewMember;
import io.group02.fight4flight.repository.CrewMemberRepository;

@Service
public class CrewMemberServiceImpl implements CrewMemberService{
    @Autowired
    private CrewMemberRepository crewRepository;

    @Override
    public CrewMember saveCrew(CrewMember customer) {
        
        return crewRepository.save(customer);
    }

    @Override
    public List<CrewMember> getAllCrewMembers() {
        return crewRepository.findAll();
    }
}
