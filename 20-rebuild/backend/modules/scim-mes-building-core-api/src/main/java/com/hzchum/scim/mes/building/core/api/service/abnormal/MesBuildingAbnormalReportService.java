package com.hzchum.scim.mes.building.core.api.service.abnormal;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalChangeReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormalReport;
import java.util.List;

public interface MesBuildingAbnormalReportService extends IService<MesBuildingAbnormalReport> {
   List<AbnormalChangeReportDO> abonrmalChangeReport(Long abnormalId, Integer type);
}
