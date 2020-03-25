package com.zakaria.springbootjpa.services;

import org.springframework.data.repository.CrudRepository;

import com.zakaria.springbootjpa.topic.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
