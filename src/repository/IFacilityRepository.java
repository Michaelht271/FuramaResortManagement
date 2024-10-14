package repository;

import java.util.ArrayList;

import model.Facility;

public interface IFacilityRepository extends Respository<Facility>{
	ArrayList<Facility> getFacilitiesNeedingMaintenance();

}
