package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectAssemblingWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesAssemblingWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectAssemblingWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectAssemblingWeldingConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesArtifactClassificationDetailService;
import com.hzchum.scim.system.core.api.service.MesAssemblingWeldingConfigService;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectAssemblingWeldingConfigLinkMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectAssemblingWeldingConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectAssemblingWeldingConfigLinkMapper, MesContractProjectAssemblingWeldingConfigLink>
   implements MesContractProjectAssemblingWeldingConfigLinkService {
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkDetailService detailService;
   @Autowired
   private MesArtifactClassificationDetailService artifactClassificationDetailService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesAssemblingWeldingConfigService assemblingWeldingConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public PageVO<MesContractProjectAssemblingWeldingConfigLinkDTO> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page<MesContractProjectAssemblingWeldingConfigLink> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesContractProjectAssemblingWeldingConfigLink> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigLink.class)
               .eq(MesContractProjectAssemblingWeldingConfigLink::getContractProjectId, projectId)
         );
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesContractProjectAssemblingWeldingConfigLink::getId).collect(Collectors.toList());
      List<MesContractProjectAssemblingWeldingConfigLinkDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfo(Long projectId) {
      return this.baseMapper.listInfo(projectId);
   }

   @Override
   public List<MesContractProjectAssemblingWeldingConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds) {
      List<MesContractProjectAssemblingWeldingConfigLinkDTO> dtoList = this.baseMapper.listInfoByProjectIds(projectIds);
      return CollUtil.isEmpty(dtoList) ? new ArrayList<>() : dtoList;
   }

   @Override
   public MesContractProjectAssemblingWeldingConfigLinkDTO detailById(Long id) {
      MesContractProjectAssemblingWeldingConfigLinkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前装焊配置不存在");
      return dto;
   }

   @Override
   public MesContractProjectAssemblingWeldingConfigLinkDTO getOneByCondition(Long projectId, Long artifactTypeId, String artifactName, Long processId) {
      MesContractProjectAssemblingWeldingConfig param = new MesContractProjectAssemblingWeldingConfig();
      param.setProjectId(projectId);
      param.setArtifactTypeId(artifactTypeId);
      param.setArtifactName(artifactName);
      param.setProcessId(processId);
      return this.baseMapper.getOneByCondition(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesContractProjectAssemblingWeldingConfigLink config = BeanUtil.toBean(param, MesContractProjectAssemblingWeldingConfigLink.class);
      config.setProcess(StrUtil.join(",", param.getProcessIdList()));
      config.setArtifact(StrUtil.join(",", param.getArtifactNameList()));
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param) {
      List<Long> processIdList = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(param.getArtifactTypeId(), ProductTypeEnum.ARTIFACT.getType())
         .stream()
         .map(MesBuildingProductProcessLinkDO::getProcessId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
      Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
      List<MesContractProjectAssemblingWeldingConfigLink> configList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectAssemblingWeldingConfigLink.class)
               .ne(param.getId() != null, MesContractProjectAssemblingWeldingConfigLink::getId, param.getId())
               .eq(MesContractProjectAssemblingWeldingConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectAssemblingWeldingConfigLink::getArtifactTypeId, param.getArtifactTypeId())
         );
      List<Long> existingProcessIdList = configList.stream()
         .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<String> existingArtifactNameList = configList.stream()
         .map(config -> StrUtil.split(config.getArtifact(), ","))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      if (CollUtil.isNotEmpty(param.getArtifactNameList())) {
         Preconditions.checkArgument(
            param.getArtifactNameList().stream().noneMatch(existingArtifactNameList::contains)
               || param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains),
            "构件名称或工序配置错误"
         );
      } else {
         Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "工序配置错误");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveConfig(List<MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam> params) {
      params.forEach(this::saveConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConfig(MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param) {
      MesContractProjectAssemblingWeldingConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前装焊配置不存在");
      this.verifyParameters(param);
      MesContractProjectAssemblingWeldingConfigLink newConfig = BeanUtil.toBean(param, MesContractProjectAssemblingWeldingConfigLink.class);
      newConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      newConfig.setArtifact(StrUtil.join(",", param.getArtifactNameList()));
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesContractProjectAssemblingWeldingConfigLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前装焊配置不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectAssemblingWeldingConfigLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesAssemblingWeldingConfigDTO> assemblingWeldingConfigDTOList = this.assemblingWeldingConfigService.listInfo();
      if (CollUtil.isEmpty(assemblingWeldingConfigDTOList)) {
         return Boolean.TRUE;
      }

      assemblingWeldingConfigDTOList.forEach(awc -> {
         MesContractProjectAssemblingWeldingConfigLink assemblingWeldingConfigLink = BeanUtil.toBean(awc, MesContractProjectAssemblingWeldingConfigLink.class);
         assemblingWeldingConfigLink.setContractProjectId(contractProjectId);
         this.baseMapper.insert(assemblingWeldingConfigLink);
      });
      return Boolean.TRUE;
   }
}
