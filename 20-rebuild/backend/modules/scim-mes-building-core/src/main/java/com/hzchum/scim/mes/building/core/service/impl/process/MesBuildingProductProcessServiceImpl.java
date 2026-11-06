package com.hzchum.scim.mes.building.core.service.impl.process;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProductProcessDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.mes.building.core.mapper.process.MesBuildingProductProcessMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductProcessServiceImpl
   extends ServiceImpl<MesBuildingProductProcessMapper, MesBuildingProductProcess>
   implements MesBuildingProductProcessService {
   @Override
   public MesBuildingProductProcessDO selectByNameAndType(String name, Integer productType) {
      return this.baseMapper.selectByNameAndType(name, productType);
   }

   @Override
   public List<String> listProcessByProductType(Integer productType) {
      return this.baseMapper.listProcessByProductType(productType);
   }

   @Override
   public List<MesBuildingProductProcess> selectByType(Integer productType) {
      return this.baseMapper.selectByType(productType);
   }

   @Override
   public List<MesBuildingProductProcessDTO> selectProductLineAndProcessByTeamIds(List<Long> teamIds) {
      return this.baseMapper.selectProductLineAndProcessByTeamIds(teamIds);
   }
}
