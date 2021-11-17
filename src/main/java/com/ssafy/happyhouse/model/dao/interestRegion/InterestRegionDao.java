package com.ssafy.happyhouse.model.dao.interestRegion;

import java.util.List;

import com.ssafy.happyhouse.model.dto.DongInfo;

public interface InterestRegionDao {
	
	/* 관심 지역 입력 */
	public void addInterestedRegion(String user_id, int dong_code);
	
	/* 관심 지역 삭제 */
	public void deleteInterestedRegion(String user_id, int dong_code);
	
	/* 관심 지역 검색 */
	public List<DongInfo> searchInterestedRegion(String user_id);
}
