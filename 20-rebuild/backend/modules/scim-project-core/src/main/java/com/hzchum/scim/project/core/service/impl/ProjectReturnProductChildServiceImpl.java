package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectReturnProductChildDO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectReturnProductQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.mapper.ProjectReturnProductChildMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProjectReturnProductChildServiceImpl
   extends ServiceImpl<ProjectReturnProductChildMapper, ProjectReturnProductChild>
   implements ProjectReturnProductChildService {
   private static final Logger log = LoggerFactory.getLogger(ProjectReturnProductChildServiceImpl.class);

   @Override
   public List<ProjectReturnProductChildDO> projectReturnChildsByTypeArtifact(ProjectReturnProductQueryDTOParam param) {
      return this.baseMapper.projectReturnChildsByTypeArtifact(param);
   }

   @Override
   public List<ProjectReturnProductChildDO> projectReturnChildsByTypeEenclosure(ProjectReturnProductQueryDTOParam param) {
      return this.baseMapper.projectReturnChildsByTypeEenclosure(param);
   }

   @Override
   public List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartArtifact(ProjectReturnProductQueryDTOParam param) {
      return this.baseMapper.projectReturnChildsByTypeStandardPartArtifact(param);
   }

   @Override
   public List<ProjectReturnProductChildDO> projectReturnChildsByTypeStandardPartEenclosure(ProjectReturnProductQueryDTOParam param) {
      return this.baseMapper.projectReturnChildsByTypeStandardPartEenclosure(param);
   }

   public String getStorageDuration(Date startDate, Date endDate) {
      long differ = endDate.getTime() - startDate.getTime();
      BigDecimal workTime = new BigDecimal(differ * 1.0 / 3600000.0);
      return String.valueOf(workTime.setScale(1, RoundingMode.HALF_UP).doubleValue());
   }
}
