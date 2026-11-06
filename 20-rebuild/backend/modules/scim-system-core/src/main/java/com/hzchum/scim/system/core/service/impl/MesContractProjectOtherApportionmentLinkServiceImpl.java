package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOtherApportionmentLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectOtherApportionmentLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesOtherApportionmentDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOtherApportionmentLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectOtherApportionmentLinkService;
import com.hzchum.scim.system.core.api.service.MesOtherApportionmentService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectOtherApportionmentLinkMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectOtherApportionmentLinkServiceImpl
   extends ServiceImpl<MesContractProjectOtherApportionmentLinkMapper, MesContractProjectOtherApportionmentLink>
   implements MesContractProjectOtherApportionmentLinkService {
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesOtherApportionmentService otherApportionmentService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingFactoryService factoryService;

   @Override
   public List<MesContractProjectOtherApportionmentLinkDTO> listInfo(Long projectId) {
      return this.baseMapper.listInfo(projectId);
   }

   @Override
   public MesContractProjectOtherApportionmentLinkDTO detailById(Long id) {
      MesContractProjectOtherApportionmentLink otherApportionment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(otherApportionment != null, "当前其他分摊不存在，请核对后操作");
      MesBuildingProcess buildingProcess = this.buildingProcessService.getById(otherApportionment.getId());
      MesBuildingFactory factory = this.factoryService.getById(otherApportionment.getFactoryId());
      MesContractProjectOtherApportionmentLinkDTO dto = BeanUtil.toBean(otherApportionment, MesContractProjectOtherApportionmentLinkDTO.class);
      dto.setProcessName(buildingProcess.getName());
      dto.setFactoryName(factory.getName());
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectOtherApportionmentLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesContractProjectOtherApportionmentLink config = com.hzchum.pangu.common.util.BeanUtil.copy(param, MesContractProjectOtherApportionmentLink.class);
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesContractProjectOtherApportionmentLinkSaveDTOParam param) {
      int repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesContractProjectOtherApportionmentLink.class)
               .ne(param.getId() != null, MesContractProjectOtherApportionmentLink::getId, param.getId())
               .eq(MesContractProjectOtherApportionmentLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectOtherApportionmentLink::getType, param.getType())
         );
      Preconditions.checkArgument(repeat == 0, "类型重复");
      MesBuildingProcess buildingProcess = this.buildingProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getId, param.getProcessId())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      Preconditions.checkArgument(buildingProcess != null, "工序不存在");
      int factoryCount = this.factoryService
         .count(
            Wrappers.lambdaQuery(MesBuildingFactory.class)
               .eq(MesBuildingFactory::getBoolEnabledEnum, Boolean.TRUE)
               .eq(MesBuildingFactory::getId, param.getFactoryId())
         );
      Preconditions.checkArgument(factoryCount > 0, "工厂不存在");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editConfig(MesContractProjectOtherApportionmentLinkSaveDTOParam param) {
      MesContractProjectOtherApportionmentLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前其他分摊不存在，请核对后操作");
      this.verifyParameters(param);
      MesContractProjectOtherApportionmentLink newConfig = com.hzchum.pangu.common.util.BeanUtil.copy(param, MesContractProjectOtherApportionmentLink.class);
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesContractProjectOtherApportionmentLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前其他分摊不存在，请核对后操作");
      oldConfig.setStatus(status);
      this.baseMapper.updateById(oldConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesContractProjectOtherApportionmentLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前其他分摊不存在，请核对后操作");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectOtherApportionmentLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesOtherApportionmentDTO> otherApportionmentDTOList = this.otherApportionmentService.listInfo();
      if (CollUtil.isEmpty(otherApportionmentDTOList)) {
         return Boolean.TRUE;
      }

      List<MesContractProjectOtherApportionmentLink> otherApportionmentLinkList = otherApportionmentDTOList.stream().map(oa -> {
         MesContractProjectOtherApportionmentLink otherApportionmentLink = BeanUtil.toBean(oa, MesContractProjectOtherApportionmentLink.class);
         otherApportionmentLink.setContractProjectId(contractProjectId);
         return otherApportionmentLink;
      }).collect(Collectors.toList());
      this.saveBatch(otherApportionmentLinkList, otherApportionmentLinkList.size());
      return Boolean.TRUE;
   }
}
