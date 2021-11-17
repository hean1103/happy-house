package com.ssafy.happyhouse.model.dao.house;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfo;

public interface HouseDao {
	public List<HouseInfo> queryHouseData(String dong);
}
