package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.bid.core.api.pojo._do.SubjectConfig;
import com.hzchum.scim.bid.core.api.pojo.dto.SubjectDTO;

public interface SubjectConfigService extends IService<SubjectConfig> {
   Boolean updateConfig(SubjectDTO subjectDTO);
}
