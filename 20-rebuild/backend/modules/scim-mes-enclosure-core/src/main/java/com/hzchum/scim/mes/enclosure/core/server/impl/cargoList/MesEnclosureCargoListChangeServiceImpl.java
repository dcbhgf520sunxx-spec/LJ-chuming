package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoListChange;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListChangeService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureCargoListChangeMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureCargoListChangeServiceImpl
   extends ServiceImpl<MesEnclosureCargoListChangeMapper, MesEnclosureCargoListChange>
   implements MesEnclosureCargoListChangeService {
}
