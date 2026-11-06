package com.hzchum.scim.mes.building.core.mapper.abnormal;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalChangeReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormalReport;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAbnormalReportMapper extends BaseMapper<MesBuildingAbnormalReport> {
   List<AbnormalChangeReportDO> abonrmalChangeReport(@Param("abnormalId") Long abnormalId, @Param("type") Integer type);
}
