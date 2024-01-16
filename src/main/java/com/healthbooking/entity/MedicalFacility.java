package com.healthbooking.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "medicalfacilities")
public class MedicalFacility {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_facility_id")
    private int medicalFacilityId;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_info")
    private String contactInfo;
    
    @OneToMany(mappedBy = "medicalFacility")
    private List<FacilitySchedule> FacilitySchedule;
}
