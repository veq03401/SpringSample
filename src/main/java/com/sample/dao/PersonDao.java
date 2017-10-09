package com.sample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.business.model.Person;

@Repository
public class PersonDao {
  
  @Autowired
  private NamedParameterJdbcTemplate npJdbcTemplate;
  
  public List<Person> getPersonList(String id) {
    List<Person> resultlist;
    resultlist = npJdbcTemplate.query(
      "SELECT * FROM Person WHERE id = :id",
      new MapSqlParameterSource().addValue("id",id),
      new BeanPropertyRowMapper<Person>(Person.class)
    );
    
    return resultlist;
    
  }

}
