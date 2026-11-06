package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactProcessFile;
import com.hzchum.scim.plan.core.api.pojo.dto.TechArtifactProcessFileDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileQueryDTOParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactProcessFileService;
import com.hzchum.scim.plan.core.mapper.TechArtifactProcessFileMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactProcessFileServiceImpl
   extends ServiceImpl<TechArtifactProcessFileMapper, TechArtifactProcessFile>
   implements TechArtifactProcessFileService {
   @Override
   public List<TechArtifactProcessFileDTO> listByCondition(TechArtifactProcessFileQueryDTOParam param) {
      return this.baseMapper.selectByCondition(param);
   }
}
