package com.sree.WeatherReport.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sree.WeatherReport.DTO.Weather;
import com.sree.WeatherReport.REPOSITORY.WeatherRepository;

@Repository
public class WeatherDao {

	@Autowired
	WeatherRepository repository;
	
	
	//to insert weather record (object) into db
	public Weather insertweather(Weather weather)
	{
		return repository.save(weather); //repository.save(weather); return weather;
		
	}
	
	//to retrive all weather reports from DB
	public List<Weather> getAllWatherReports()
	{
		return repository.findAll();
	}
	
	//to retrive single weather report based on weather id
	public Weather getWeatherById(long id)
	{
		 Optional<Weather> opt=repository.findById(id);
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		 else
		 {
			 return null;
		 }
	}
	
	
	//to delete on weather report db
	public String deleteweatherReportById(long id)
	{
		
		//search id
		Weather w=getWeatherById(id);
		if(w!=null) 
		{
			repository.delete(w);
			//repository.deleteById(id);
			
			return "Weather report deleted Succesfully............";
		}
		else
		{
			return "could not delete the requested weather report .Id is not found";
		}
	}
	
	//update weather details --conditions,and temperature based on id
	
	public String updateWeather(long id, String newConditions, String newTemperature)
	{
		Weather w=getWeatherById(id);
		if(w !=null)
				{
			       w.setConditions(newConditions);
			       w.setTemperature(newTemperature);
			       repository.save(w);
			       return "Weather details updated succesfully....";
				}
		else
		{
			return "Cannot update weather details. Id not found....";
		}
	}
	
	
	//to retrive based on city
	
	public List<Weather> getWeatherBasedCity(String city)
	{
		return repository.getWeatherByCity(city);
	}
	
	//to retrive weather report based on suuny
	
	public List<Weather> getBasedSunnyWeatherReport()
	{
		return repository.getSunnyWeatherReport();
	}
}
