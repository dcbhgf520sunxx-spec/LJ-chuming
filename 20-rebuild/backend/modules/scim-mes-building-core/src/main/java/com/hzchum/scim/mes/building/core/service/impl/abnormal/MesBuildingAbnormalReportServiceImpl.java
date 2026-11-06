package com.hzchum.scim.mes.building.core.service.impl.abnormal;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalChangeReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormalReport;
import com.hzchum.scim.mes.building.core.api.service.abnormal.MesBuildingAbnormalReportService;
import com.hzchum.scim.mes.building.core.mapper.abnormal.MesBuildingAbnormalReportMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAbnormalReportServiceImpl
   extends ServiceImpl<MesBuildingAbnormalReportMapper, MesBuildingAbnormalReport>
   implements MesBuildingAbnormalReportService {
   @Override
   public List<AbnormalChangeReportDO> abonrmalChangeReport(Long abnormalId, Integer type) {
      return this.baseMapper.abonrmalChangeReport(abnormalId, type);
   }
}
