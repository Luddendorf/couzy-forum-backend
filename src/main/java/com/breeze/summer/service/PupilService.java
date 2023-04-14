package com.breeze.summer.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dto.Pupil;

@Service
public class PupilService {
	private List<Pupil> pupilList;
	private Pupil responsePupil;

	public PupilService() {
    	this.pupilList = Arrays.asList(new Pupil(1L, "Benjamin"), new Pupil(2L, "William"),
				                       new Pupil(3L, "Gregory"), new Pupil(4L, "Samuel"));
	}

	public Pupil getPupilById(Long pupilId) {
		return this.pupilList.stream().filter(p -> p.getPupilId() == pupilId)
				.limit(1).collect(Collectors.toList()).get(0);
	}

	public Pupil updatePupilById(Pupil updatedPupil) {
		pupilList = pupilList.stream()
				.map(p -> {
					if (p.getPupilId() == updatedPupil.getPupilId()) {
						p.setName(updatedPupil.getName());
						this.responsePupil = p;
						return p;
					}
					return p;
				}).collect(Collectors.toList());
		
		return this.responsePupil;
	}

}
