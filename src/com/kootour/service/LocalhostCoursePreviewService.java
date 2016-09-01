package com.kootour.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.kootour.mapper.entity.CourseDetailEntity;
public interface LocalhostCoursePreviewService {
CourseDetailEntity load(CourseDetailEntity courseDetailEntity,Map<String,Object> paraMap);
}
