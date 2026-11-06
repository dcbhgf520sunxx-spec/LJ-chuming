package com.hzchum.scim.mes.building.core.service.impl.temp_work;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWorkApproval;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkApprovalDTO;
import com.hzchum.scim.mes.building.core.api.service.temp_work.MesTempWorkApprovalService;
import com.hzchum.scim.mes.building.core.mapper.temp_work.MesTempWorkApprovalMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesTempWorkApprovalServiceImpl extends ServiceImpl<MesTempWorkApprovalMapper, MesTempWorkApproval> implements MesTempWorkApprovalService {
   @Override
   public List<MesTempWorkApprovalDTO> listByTempWorkIds(List<Long> tempWorkIds) {
      return this.baseMapper.listByTempWorkIds(tempWorkIds);
   }

   @Override
   public Integer getMaxSort(Long tempWorkId) {
      return this.baseMapper.getMaxSort(tempWorkId);
   }
}
