package com.sree.WeatherReport.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sree.WeatherReport.DTO.Weather;


public interface WeatherRepository extends JpaRepository<Weather, Long>
{
//all the methods present in resporitory interface

	@Query("select w from Weather w where w.city=?1")
	public List<Weather> getWeatherByCity(String city);
	
	@Query(value="select * from Weather  where conditions='sunny' ", nativeQuery=true)
	public List<Weather> getSunnyWeatherReport();
}
