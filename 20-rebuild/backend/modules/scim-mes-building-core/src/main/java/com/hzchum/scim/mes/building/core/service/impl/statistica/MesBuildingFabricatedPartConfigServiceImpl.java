package com.hzchum.scim.mes.building.core.service.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingFabricatedPartConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingFabricatedPartConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.statistica.MesBuildingFabricatedPartConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingFabricatedPartConfigService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingFabricatedPartConfigMapper;
import com.hzchum.scim.system.core.api.common.enums.AuxiliaryTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysAuxiliaryClassification;
import com.hzchum.scim.system.core.api.service.SysAuxiliaryClassificationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingFabricatedPartConfigServiceImpl
   extends ServiceImpl<MesBuildingFabricatedPartConfigMapper, MesBuildingFabricatedPartConfig>
   implements MesBuildingFabricatedPartConfigService {
   @Resource
   private MesBuildingProductProcessLinkService mesBuildingProductProcessLinkService;
   @Resource
   private SysAuxiliaryClassificationService sysAuxiliaryClassificationService;

   @Override
   public List<MesBuildingFabricatedPartConfigDTO> fabricatedParList() {
      List<MesBuildingFabricatedPartConfigDTO> fabricatedPartList = new ArrayList<>();
      Map<Long, MesBuildingFabricatedPartConfig> partConfigMap = new HashMap<>();
      List<MesBuildingFabricatedPartConfig> fabricatedPartConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtils.isNotEmpty(fabricatedPartConfigs)) {
         partConfigMap = fabricatedPartConfigs.stream().collect(Collectors.toMap(MesBuildingFabricatedPartConfig::getAuxiliaryId, Function.identity()));
      }

      List<SysAuxiliaryClassification> auxiliaryClassifications = this.sysAuxiliaryClassificationService
         .list((Wrapper<SysAuxiliaryClassification>)new LambdaQueryWrapper<SysAuxiliaryClassification>().ne(SysAuxiliaryClassification::getType, AuxiliaryTypeEnum.OTHER.getType()));
      if (CollectionUtils.isNotEmpty(auxiliaryClassifications)) {
         for (SysAuxiliaryClassification auxiliary : auxiliaryClassifications) {
            MesBuildingFabricatedPartConfigDTO build = MesBuildingFabricatedPartConfigDTO.builder()
               .auxiliaryId(auxiliary.getId())
               .auxiliaryName(auxiliary.getName())
               .basicClass(auxiliary.getBasicClass())
               .build();
            if (partConfigMap.get(auxiliary.getId()) != null) {
               build.setUnitPrice(partConfigMap.get(auxiliary.getId()).getUnitPrice());
            }

            fabricatedPartList.add(build);
         }
      }

      return fabricatedPartList;
   }

   @Override
   public Boolean setFabricatedParts(MesBuildingFabricatedPartConfigDTOParam dto) {
      List<MesBuildingProductProcessLinkDO> processLinkDOS = this.mesBuildingProductProcessLinkService
         .getProcessListByTypeIdAndProductType(dto.getAuxiliaryId(), ProductTypeEnum.MACHINE_PART.getType());
      Preconditions.checkArgument(CollectionUtils.isEmpty(processLinkDOS), "该零件工序已存在,请刷新页面");
      MesBuildingFabricatedPartConfig fabricatedPartConfig = this.baseMapper
         .selectOne(
            (Wrapper<MesBuildingFabricatedPartConfig>)new LambdaQueryWrapper<MesBuildingFabricatedPartConfig>().eq(MesBuildingFabricatedPartConfig::getAuxiliaryId, dto.getAuxiliaryId())
         );
      if (fabricatedPartConfig != null && fabricatedPartConfig.getUnitPrice().compareTo(dto.getUnitPrice()) != 0) {
         fabricatedPartConfig.setUnitPrice(dto.getUnitPrice());
         this.baseMapper.updateById(fabricatedPartConfig);
      } else {
         MesBuildingFabricatedPartConfig build = MesBuildingFabricatedPartConfig.builder()
            .auxiliaryId(dto.getAuxiliaryId())
            .auxiliaryName(dto.getAuxiliaryName())
            .basicClass(dto.getBasicClass())
            .unitPrice(dto.getUnitPrice())
            .build();
         this.baseMapper.insert(build);
      }

      return true;
   }

   @Override
   public Boolean removeFabricatedParts(MesBuildingFabricatedPartConfigDTOParam dto) {
      MesBuildingFabricatedPartConfig fabricatedPartConfig = this.baseMapper
         .selectOne(
            (Wrapper<MesBuildingFabricatedPartConfig>)new LambdaQueryWrapper<MesBuildingFabricatedPartConfig>().eq(MesBuildingFabricatedPartConfig::getAuxiliaryId, dto.getAuxiliaryId())
         );
      Preconditions.checkArgument(fabricatedPartConfig != null, "删除失败,成品零件配置不存在");
      this.baseMapper.deleteById(fabricatedPartConfig.getId());
      return true;
   }
}
