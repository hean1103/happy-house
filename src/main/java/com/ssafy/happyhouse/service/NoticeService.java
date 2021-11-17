package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeService {

	void registerArticle(NoticeDto noticeDto) throws Exception;

	List<NoticeDto> listArticle() throws Exception;

	void deleteArticle(int articleNo) throws Exception;

	NoticeDto getArticle(int articleNo) throws Exception;

	void updateArticle(NoticeDto noticeDto) throws Exception;

}
