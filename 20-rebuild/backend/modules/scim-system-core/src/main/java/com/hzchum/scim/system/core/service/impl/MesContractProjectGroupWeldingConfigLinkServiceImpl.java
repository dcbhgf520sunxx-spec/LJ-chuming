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
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectGroupWeldingConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectGroupWeldingConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesGroupWeldingConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectGroupWeldingConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectGroupWeldingConfigParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectGroupWeldingConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesGroupWeldingConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectGroupWeldingConfigLinkMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectGroupWeldingConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectGroupWeldingConfigLinkMapper, MesContractProjectGroupWeldingConfigLink>
   implements MesContractProjectGroupWeldingConfigLinkService {
   @Autowired
   private MesContractProjectGroupWeldingConfigLinkDetailService detailService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesGroupWeldingConfigService groupWeldingConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public PageVO<MesContractProjectGroupWeldingConfigLinkDTO> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page<MesContractProjectGroupWeldingConfigLink> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesContractProjectGroupWeldingConfigLink> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLink.class).eq(MesContractProjectGroupWeldingConfigLink::getContractProjectId, projectId)
         );
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesContractProjectGroupWeldingConfigLink::getId).collect(Collectors.toList());
      List<MesContractProjectGroupWeldingConfigLinkDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesContractProjectGroupWeldingConfigLinkDTO> listInfo(Long projectId) {
      return this.baseMapper.listInfo(projectId);
   }

   @Override
   public List<MesContractProjectGroupWeldingConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds) {
      List<MesContractProjectGroupWeldingConfigLinkDTO> dtoList = this.baseMapper.listInfoByProjectIds(projectIds);
      return CollUtil.isEmpty(dtoList) ? new ArrayList<>() : dtoList;
   }

   @Override
   public MesContractProjectGroupWeldingConfigLinkDTO detailById(Long id) {
      MesContractProjectGroupWeldingConfigLinkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前组焊配置不存在");
      return dto;
   }

   @Override
   public MesContractProjectGroupWeldingConfigLinkDTO getOneByCondition(Long projectId, Long assembleConfigId, Long processId) {
      MesContractProjectGroupWeldingConfigParam param = new MesContractProjectGroupWeldingConfigParam();
      param.setProjectId(projectId);
      param.setAssembleConfigId(assembleConfigId);
      param.setProcessId(processId);
      return this.baseMapper.getOneByCondition(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectGroupWeldingConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesContractProjectGroupWeldingConfigLink config = BeanUtil.toBean(param, MesContractProjectGroupWeldingConfigLink.class);
      config.setProcess(StrUtil.join(",", param.getProcessIdList()));
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesContractProjectGroupWeldingConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(WageConfigStatisticsModeEnum.existEliminateMachinePart(param.getStatisticsMode()), "统计模式不存在");
      List<Long> processIdList = this.productProcessLinkService
         .getProcessListByTypeIdAndProductType(param.getAssembleConfigId(), ProductTypeEnum.ASSEMBLE.getType())
         .stream()
         .map(MesBuildingProductProcessLinkDO::getProcessId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
      Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
      List<Long> existingProcessIdList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLink.class)
               .ne(param.getId() != null, MesContractProjectGroupWeldingConfigLink::getId, param.getId())
               .eq(MesContractProjectGroupWeldingConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectGroupWeldingConfigLink::getAssembleConfigId, param.getAssembleConfigId())
         )
         .stream()
         .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "存在重复工序");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveConfig(List<MesContractProjectGroupWeldingConfigLinkSaveDTOParam> paramList) {
      paramList.forEach(this::saveConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConfig(MesContractProjectGroupWeldingConfigLinkSaveDTOParam param) {
      MesContractProjectGroupWeldingConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前组焊配置不存在");
      this.verifyParameters(param);
      MesContractProjectGroupWeldingConfigLink newConfig = BeanUtil.toBean(param, MesContractProjectGroupWeldingConfigLink.class);
      newConfig.setProcess(StrUtil.join(",", param.getProcessIdList()));
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper
         .selectCount(Wrappers.lambdaQuery(MesContractProjectGroupWeldingConfigLink.class).in(MesContractProjectGroupWeldingConfigLink::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的组焊配置");
      this.baseMapper.deleteBatchIds(idList);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectGroupWeldingConfigLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesGroupWeldingConfigDTO> groupWeldingConfigDTOList = this.groupWeldingConfigService.listInfo();
      if (CollUtil.isEmpty(groupWeldingConfigDTOList)) {
         return Boolean.TRUE;
      }

      groupWeldingConfigDTOList.forEach(gwc -> {
         MesContractProjectGroupWeldingConfigLink groupWeldingConfigLink = BeanUtil.toBean(gwc, MesContractProjectGroupWeldingConfigLink.class);
         groupWeldingConfigLink.setContractProjectId(contractProjectId);
         this.baseMapper.insert(groupWeldingConfigLink);
      });
      return Boolean.TRUE;
   }
}
