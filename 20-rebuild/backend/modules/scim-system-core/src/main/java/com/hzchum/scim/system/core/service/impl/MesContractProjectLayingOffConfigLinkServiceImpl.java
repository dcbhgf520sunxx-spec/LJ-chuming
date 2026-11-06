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
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProductProcessLinkDO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.system.core.api.common.enums.WageConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectLayingOffConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectLayingOffConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesLayingOffConfigDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectLayingOffConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectLayingOffConfigParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkDetailService;
import com.hzchum.scim.system.core.api.service.MesContractProjectLayingOffConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesLayingOffConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectLayingOffConfigLinkMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectLayingOffConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectLayingOffConfigLinkMapper, MesContractProjectLayingOffConfigLink>
   implements MesContractProjectLayingOffConfigLinkService {
   @Autowired
   private MesContractProjectLayingOffConfigLinkDetailService detailService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesLayingOffConfigService layingOffConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProductProcessLinkService productProcessLinkService;

   @Override
   public PageVO<MesContractProjectLayingOffConfigLinkDTO> pageInfo(
      Long projectId, Integer statisticsConfigStatisticsMode, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<MesContractProjectLayingOffConfigLink> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesContractProjectLayingOffConfigLink> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class)
               .eq(MesContractProjectLayingOffConfigLink::getContractProjectId, projectId)
               .eq(MesContractProjectLayingOffConfigLink::getStatisticsConfigStatisticsMode, statisticsConfigStatisticsMode)
         );
      if (CollUtil.isEmpty(list)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<Long> idList = list.stream().map(MesContractProjectLayingOffConfigLink::getId).collect(Collectors.toList());
      List<MesContractProjectLayingOffConfigLinkDTO> dtoList = this.baseMapper.listInfoByIds(idList);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<MesContractProjectLayingOffConfigLinkDTO> listInfo(Long projectId, Integer statisticsConfigStatisticsMode) {
      return this.baseMapper.listInfo(projectId, statisticsConfigStatisticsMode);
   }

   @Override
   public MesContractProjectLayingOffConfigLinkDTO detailById(Long id) {
      MesContractProjectLayingOffConfigLinkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前下料配置不存在");
      return dto;
   }

   @Override
   public List<MesContractProjectLayingOffConfigLinkDTO> listInfoByProjectIds(List<Long> projectIds) {
      List<MesContractProjectLayingOffConfigLinkDTO> dtoList = this.baseMapper.listInfoByProjectIds(projectIds);
      return CollUtil.isEmpty(dtoList) ? new ArrayList<>() : dtoList;
   }

   @Override
   public MesContractProjectLayingOffConfigLinkDTO getOneByCondition(
      Long projectId, Integer machinePartType, Long steelClassificationId, Boolean boolFixedPrice
   ) {
      MesContractProjectLayingOffConfigParam param = new MesContractProjectLayingOffConfigParam();
      param.setProjectId(projectId);
      param.setMachinePartType(machinePartType);
      param.setSteelClassificationId(steelClassificationId);
      param.setBoolFixedPrice(boolFixedPrice);
      return this.baseMapper.getOneByCondition(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectLayingOffConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesContractProjectLayingOffConfigLink layingOffConfigLink = BeanUtil.toBean(param, MesContractProjectLayingOffConfigLink.class);
      layingOffConfigLink.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.insert(layingOffConfigLink);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesContractProjectLayingOffConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(
         CollUtil.newArrayList(ProductClassificationEnum.SECTION_PRODUCT.getType(), ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
            .contains(param.getMachinePartType()),
         "零件类型不存在"
      );
      Preconditions.checkArgument(WageConfigStatisticsModeEnum.existEliminateAssemble(param.getStatisticsMode()), "统计模式不存在");
      List<MesContractProjectLayingOffConfigLink> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class)
               .eq(MesContractProjectLayingOffConfigLink::getContractProjectId, param.getContractProjectId())
               .ne(param.getId() != null, MesContractProjectLayingOffConfigLink::getId, param.getId())
               .eq(MesContractProjectLayingOffConfigLink::getMachinePartType, param.getMachinePartType())
               .eq(param.getSteelClassificationId() != null, MesContractProjectLayingOffConfigLink::getSteelClassificationId, param.getSteelClassificationId())
         );
      Preconditions.checkArgument(CollUtil.isEmpty(list), "零件类型,零件分类重复");
      if (!param.getBoolFixedPrice()) {
         Preconditions.checkArgument(WageQuotaTypeEnum.existEliminateArea(param.getMeasurementManner()), "计量方式不存在");
         List<Long> processIdList = this.productProcessLinkService
            .getProcessListByTypeIdAndProductType(param.getSteelClassificationId(), ProductTypeEnum.MACHINE_PART.getType())
            .stream()
            .map(MesBuildingProductProcessLinkDO::getProcessId)
            .distinct()
            .collect(Collectors.toList());
         Preconditions.checkArgument(param.getProcessIdList().stream().allMatch(processIdList::contains), "包含不存在的工序");
         List<Long> existingProcessIdList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class)
                  .ne(param.getId() != null, MesContractProjectLayingOffConfigLink::getId, param.getId())
                  .eq(MesContractProjectLayingOffConfigLink::getContractProjectId, param.getContractProjectId())
                  .eq(MesContractProjectLayingOffConfigLink::getMachinePartType, param.getMachinePartType())
                  .eq(MesContractProjectLayingOffConfigLink::getSteelClassificationId, param.getSteelClassificationId())
            )
            .stream()
            .map(config -> StrUtil.split(config.getProcess(), ",").stream().map(Long::valueOf).collect(Collectors.toList()))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         Preconditions.checkArgument(param.getProcessIdList().stream().noneMatch(existingProcessIdList::contains), "存在重复工序");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchSaveConfig(List<MesContractProjectLayingOffConfigLinkSaveDTOParam> paramList) {
      paramList.forEach(this::saveConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateContractProjectLayingOffConfigLink(MesContractProjectLayingOffConfigLinkSaveDTOParam param) {
      MesContractProjectLayingOffConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前下料配置不存在");
      this.verifyParameters(param);
      MesContractProjectLayingOffConfigLink newConfig = BeanUtil.toBean(param, MesContractProjectLayingOffConfigLink.class);
      newConfig.setProcess(CollUtil.join(param.getProcessIdList(), ","));
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectLayingOffConfigLink(Long contractProjectId, Integer contractProjectStatisticsMode) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesLayingOffConfigDTO> layingOffConfigDTOList = this.layingOffConfigService.listInfo(contractProjectStatisticsMode);
      if (CollUtil.isEmpty(layingOffConfigDTOList)) {
         return Boolean.TRUE;
      }

      layingOffConfigDTOList.forEach(loc -> {
         MesContractProjectLayingOffConfigLink layingOffConfigLink = BeanUtil.toBean(loc, MesContractProjectLayingOffConfigLink.class);
         layingOffConfigLink.setContractProjectId(contractProjectId);
         this.baseMapper.insert(layingOffConfigLink);
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchDelete(List<Long> idList) {
      Integer count = this.baseMapper
         .selectCount(Wrappers.lambdaQuery(MesContractProjectLayingOffConfigLink.class).in(MesContractProjectLayingOffConfigLink::getId, idList));
      Preconditions.checkArgument(count.equals(idList.size()), "包含不存在的下料配置");
      this.baseMapper.deleteBatchIds(idList);
      return Boolean.TRUE;
   }
}
