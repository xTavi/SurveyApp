package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.DoneSurvey;
import com.example.demo.repositories.DoneSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class DoneSurveyServiceImpl implements DoneSurveyService {

    @Autowired
    private DoneSurveyRepository doneSurveyRepository;

    @Override
    public DoneSurvey createDoneSurvey(DoneSurvey doneSurvey) {
        doneSurvey.setRespondentName(getCurrentUserName());
        return doneSurveyRepository.save(doneSurvey);
    }

    @Override
    public DoneSurvey getDoneSurveyById(UUID id) {
        Optional<DoneSurvey> doneSurveyDB = doneSurveyRepository.findById(id);

        if (doneSurveyDB.isPresent()) {
            return doneSurveyDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id:" + id);
        }
    }

    @Override
    public List<DoneSurvey> getAllDoneSurvey() {
        // Here I need a little clarification
        // If the user is a RESPONDENT see all surveys done by him
        // If the user is a COORDINATOR see all his respondent surveys
        if (isCoordinator())
            return surveyRepository.findByCreatorName(getCurrentUserName());
        else
            return surveyRepository.findAllByOpenIsTrue();
    }


    private String getCurrentUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

    private boolean isCoordinator() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_COORDINATOR"));
    }

    private boolean isRespondent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_RESPONDENT"));
    }
}
