package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureLicencePlate;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureLicencePlateService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureLicencePlateMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureLicencePlateServiceImpl
   extends ServiceImpl<MesEnclosureLicencePlateMapper, MesEnclosureLicencePlate>
   implements MesEnclosureLicencePlateService {
}
