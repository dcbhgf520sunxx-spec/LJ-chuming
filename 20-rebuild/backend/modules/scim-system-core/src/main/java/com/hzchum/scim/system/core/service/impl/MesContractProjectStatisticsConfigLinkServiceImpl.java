package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.common.enums.PriceModifySceneEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectStatisticsConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesPriceModifyConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesStatisticsModeConfig;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectStatisticsConfigLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectStatisticsConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectStatisticsConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.api.service.MesStatisticsModeConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectStatisticsConfigLinkMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectStatisticsConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectStatisticsConfigLinkMapper, MesContractProjectStatisticsConfigLink>
   implements MesContractProjectStatisticsConfigLinkService {
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesStatisticsModeConfigService statisticsModeConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public List<MesContractProjectStatisticsConfigLinkDTO> listInfo(Integer statisticsMode, String projectNumberOrName) {
      return this.baseMapper.listInfo(statisticsMode, projectNumberOrName);
   }

   @Override
   public PageVO<MesContractProjectStatisticsConfigLinkDTO> pageInfo(Integer statisticsMode, String projectNumberOrName, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<MesContractProjectStatisticsConfigLinkDTO> dtoList = this.baseMapper.listInfo(statisticsMode, projectNumberOrName);
      return new PageVO<>(page, dtoList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectStatisticsConfig(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      MesStatisticsModeConfig statisticsModeConfig = this.statisticsModeConfigService.getInfo();
      Preconditions.checkArgument(statisticsModeConfig != null, "统计模式未设置");
      MesPriceModifyConfig priceModifyConfig = this.priceModifyConfigService.getInfo();
      if (priceModifyConfig == null) {
         priceModifyConfig = new MesPriceModifyConfig();
      }

      MesContractProjectStatisticsConfigLink contractProjectStatisticsConfigLink = MesContractProjectStatisticsConfigLink.builder()
         .contractProjectId(contractProjectId)
         .statisticsMode(statisticsModeConfig.getMode())
         .statisticsDeadline(statisticsModeConfig.getDeadline())
         .configPrice(priceModifyConfig.getConfigPrice())
         .configPriceSyncStartDate(priceModifyConfig.getConfigPriceSyncStartDate())
         .configPriceSyncEndDate(priceModifyConfig.getConfigPriceSyncEndDate())
         .individualPrice(priceModifyConfig.getIndividualPrice())
         .individualPriceSyncStartDate(priceModifyConfig.getIndividualPriceSyncStartDate())
         .individualPriceSyncEndDate(priceModifyConfig.getIndividualPriceSyncEndDate())
         .build();
      this.baseMapper.insert(contractProjectStatisticsConfigLink);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateContractProjectStatisticsConfig(MesContractProjectStatisticsConfigLinkSaveDTOParam param) {
      MesContractProjectStatisticsConfigLink contractProjectStatisticsConfigLinkOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(contractProjectStatisticsConfigLinkOld != null, "当前项目统计配置不存在");
      if (PriceModifySceneEnum.SYNC_PRICE_BEFORE_MODIFICATION.getType().equals(param.getConfigPrice())) {
         Preconditions.checkArgument(param.getConfigPriceSyncStartDate() != null, "配置价格同步开始日期不能为空");
         Preconditions.checkArgument(param.getConfigPriceSyncEndDate() != null, "配置价格同步结束日期不能为空");
      }

      if (PriceModifySceneEnum.SYNC_PRICE_BEFORE_MODIFICATION.getType().equals(param.getIndividualPrice())) {
         Preconditions.checkArgument(param.getIndividualPriceSyncStartDate() != null, "单个价格同步开始日期不能为空");
         Preconditions.checkArgument(param.getIndividualPriceSyncEndDate() != null, "单个价格同步结束日期不能为空");
      }

      MesContractProjectStatisticsConfigLink contractProjectStatisticsConfigLink = BeanUtil.toBean(param, MesContractProjectStatisticsConfigLink.class);
      this.baseMapper.updateById(contractProjectStatisticsConfigLink);
      return Boolean.TRUE;
   }
}
