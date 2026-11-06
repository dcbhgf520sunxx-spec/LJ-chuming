package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.factory.MesEnclosureTeamDOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureTeamService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureTeamMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureTeamServiceImpl extends ServiceImpl<MesEnclosureTeamMapper, MesEnclosureTeam> implements MesEnclosureTeamService {
   @Override
   public List<MesEnclosureTeam> listByCondition(MesEnclosureTeamDOParam doParam) {
      return this.baseMapper.listByCondition(doParam);
   }
}
