package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestingApprove;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestingApproveDTO;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestingApproveService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestingApproveMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestingApproveServiceImpl
   extends ServiceImpl<MesBuildingNestingApproveMapper, MesBuildingNestingApprove>
   implements MesBuildingNestingApproveService {
   @Resource
   private MesBuildingNestingApproveMapper mesBuildingNestingApproveMapper;

   @Override
   public List<MesBuildingNestingApproveDTO> getNestingApprove(Long jobId, Integer reviewStatus) {
      return this.mesBuildingNestingApproveMapper.getNestingApprove(jobId, reviewStatus);
   }
}
