package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.task.InspectionReportDOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingInspectionTeamMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingInspectionTeamServiceImpl
   extends ServiceImpl<MesBuildingInspectionTeamMapper, MesBuildingInspectionTeam>
   implements MesBuildingInspectionTeamService {
   @Override
   public MesBuildingInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId) {
      return this.baseMapper.getInspectionTeamBygroupsIdAndProcessIdAndUserId(groupsId, processId, userId);
   }

   @Override
   public MesBuildingInspectionTeam getInspectionTeamByLineIdAndProcessIdAndUserId(Long lineId, Long processId, Long userId, Boolean teamType) {
      return this.baseMapper.getInspectionTeamByLineIdAndProcessIdAndUserId(lineId, processId, userId, teamType);
   }

   @Override
   public ListVO<InspectionMeteDO> listUserSummary(InspectionReportDOParam param) {
      return new ListVO<>(this.baseMapper.listUserSummary(param));
   }

   @Override
   public ListVO<InspectionUserRecordDO> listUserDetail(InspectionDetailDOParam param) {
      return new ListVO<>(this.baseMapper.listUserDetail(param));
   }

   @Override
   public List<MesBuildingInspectionTeam> selectByLine(List<Long> ids) {
      return this.baseMapper.inspectionTeamBy(ids);
   }
}
