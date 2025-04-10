package com.sree.WeatherReport.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sree.WeatherReport.DAO.WeatherDao;
import com.sree.WeatherReport.DTO.Weather;

@RestController
public class WeatherController {

	
	@Autowired
	WeatherDao dao;
	
	//rest api to insert weather object into db
	@PostMapping("/weather")
	public Weather addWeather(@RequestBody Weather weather)
	{
		return  dao.insertweather(weather);
	}
	
	
	// Rest API to get all weather report
	@GetMapping("/weather")
	public List<Weather> getAllReports(){
		return dao.getAllWatherReports();
	}
	
	//Rest API to get weather report byid
	
	@GetMapping("/byid")
	public Weather getWeatherById(@RequestParam long weatherId)
	{
		return dao.getWeatherById(weatherId);
	}
	
	
	// Rest API to delete weatherReport
	@DeleteMapping("/weather")
	public String deleteWeatherById(@RequestParam long id)
	{
		return dao.deleteweatherReportById(id);
	}
	
	
	// Rest API to update Weather report
	@PutMapping("/weather")
	public String updateWeatherBasedId(@RequestParam long id,@RequestParam String conditions,@RequestParam String temperature)
	{
		return dao.updateWeather(id, conditions, temperature);
	}
	
	//Rest API to get details by city
	@GetMapping("/city")
	public List<Weather> getWeatherBycity(@RequestParam String city)
	{
		return dao.getWeatherBasedCity(city);
	}
	
	//rest API to get weather Report Based on sunny
	
	@GetMapping("/sunny")
	public List<Weather> getWeatherbasedSunny()
	{
		return dao.getBasedSunnyWeatherReport();
	}
}
