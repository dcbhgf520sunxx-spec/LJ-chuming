package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubject;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectService;
import com.hzchum.scim.bid.core.mapper.ProjectSubjectMapper;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class ProjectSubjectServiceImpl extends ServiceImpl<ProjectSubjectMapper, ProjectSubject> implements ProjectSubjectService {
}
