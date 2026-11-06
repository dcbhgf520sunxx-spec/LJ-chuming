package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionMeteDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.InspectionUserRecordDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionDetailDOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.task.InspectionReportDOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureInspectionTeamMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureInspectionTeamServiceImpl
   extends ServiceImpl<MesEnclosureInspectionTeamMapper, MesEnclosureInspectionTeam>
   implements MesEnclosureInspectionTeamService {
   @Override
   public MesEnclosureInspectionTeam getInspectionTeamBygroupsIdAndProcessIdAndUserId(Long groupsId, Long processId, Long userId) {
      return this.baseMapper.getInspectionTeamBygroupsIdAndProcessIdAndUserId(groupsId, processId, userId);
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
   public List<MesEnclosureInspectionTeam> selectByLine(List<Long> ids) {
      return this.baseMapper.inspectionTeamBy(ids);
   }
}
