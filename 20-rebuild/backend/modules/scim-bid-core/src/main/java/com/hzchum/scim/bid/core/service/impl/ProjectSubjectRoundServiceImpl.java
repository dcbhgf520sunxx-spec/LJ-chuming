package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectSubjectRound;
import com.hzchum.scim.bid.core.api.service.ProjectSubjectRoundService;
import com.hzchum.scim.bid.core.mapper.ProjectSubjectRoundMapper;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class ProjectSubjectRoundServiceImpl extends ServiceImpl<ProjectSubjectRoundMapper, ProjectSubjectRound> implements ProjectSubjectRoundService {
}
