package com.kootour.mapper;

import java.util.Date;
import java.util.List;
public interface SequenceMapper {
	int selectNext(String seq_name);
	void updateNext(String seq_name);
}
