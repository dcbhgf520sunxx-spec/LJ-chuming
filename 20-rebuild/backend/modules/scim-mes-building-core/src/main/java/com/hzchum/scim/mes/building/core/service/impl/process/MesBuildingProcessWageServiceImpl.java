package com.hzchum.scim.mes.building.core.service.impl.process;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcessWage;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessWageService;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingProcessWageMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProcessWageServiceImpl
   extends ServiceImpl<MesBuildingProcessWageMapper, MesBuildingProcessWage>
   implements MesBuildingProcessWageService {
}
