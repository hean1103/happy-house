package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.mapper.notice.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void registerArticle(NoticeDto noticeDto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(NoticeMapper.class).registerArticle(noticeDto);
	}

	@Override
	public List<NoticeDto> listArticle() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).listArticle();
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(NoticeMapper.class).deleteArticle(articleNo);
	}

	@Override
	public NoticeDto getArticle(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(NoticeMapper.class).getArticle(articleNo);
	}

	@Override
	public void updateArticle(NoticeDto noticeDto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(NoticeMapper.class).updateArticle(noticeDto);
	}
	
}
