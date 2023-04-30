package com.tenco.hobby.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.hobby.repository.model.Message;

@Mapper
public interface MessageRepository {
	
	public int insert(Message message);
	public List<Message> findByReceiver(Long receiver);
	public List<Message> findBySender(Long sender);

}
