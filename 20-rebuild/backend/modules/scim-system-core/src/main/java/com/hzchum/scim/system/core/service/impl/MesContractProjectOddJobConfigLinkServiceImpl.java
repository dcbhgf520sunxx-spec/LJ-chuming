package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectOddJobConfigLink;
import com.hzchum.scim.system.core.api.pojo._do.MesOddJobConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOddJobConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectOddJobConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesOddJobConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectOddJobConfigLinkMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectOddJobConfigLinkServiceImpl
   extends ServiceImpl<MesContractProjectOddJobConfigLinkMapper, MesContractProjectOddJobConfigLink>
   implements MesContractProjectOddJobConfigLinkService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesOddJobConfigService oddJobConfigService;

   @Override
   public PageVO<MesContractProjectOddJobConfigLink> pageInfo(Long projectId, Integer pageNumber, Integer pageSize, List<String> sort) {
      String sortStr = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, sortStr);
      List<MesContractProjectOddJobConfigLink> list = this.listInfo(projectId);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesContractProjectOddJobConfigLink> listInfo(Long projectId) {
      return this.list(Wrappers.lambdaQuery(MesContractProjectOddJobConfigLink.class).eq(MesContractProjectOddJobConfigLink::getContractProjectId, projectId));
   }

   @Override
   public MesContractProjectOddJobConfigLink detailById(Long id) {
      MesContractProjectOddJobConfigLink config = this.baseMapper.selectById(id);
      Preconditions.checkArgument(config != null, "当前零工配置不存在，请核对后操作");
      return config;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectOddJobConfigLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      int count = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesContractProjectOddJobConfigLink.class)
               .eq(MesContractProjectOddJobConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectOddJobConfigLink::getOddJobType, param.getOddJobType())
         );
      Preconditions.checkArgument(count == 0, "零工类型重复");
      MesContractProjectOddJobConfigLink config = BeanUtil.copy(param, MesContractProjectOddJobConfigLink.class);
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editConfig(MesContractProjectOddJobConfigLinkSaveDTOParam param) {
      MesContractProjectOddJobConfigLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前零工配置不存在，请核对后操作");
      int repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesContractProjectOddJobConfigLink.class)
               .ne(MesContractProjectOddJobConfigLink::getId, param.getId())
               .eq(MesContractProjectOddJobConfigLink::getContractProjectId, param.getContractProjectId())
               .eq(MesContractProjectOddJobConfigLink::getOddJobType, param.getOddJobType())
         );
      Preconditions.checkArgument(repeat == 0, "零工类型重复");
      MesContractProjectOddJobConfigLink newConfig = BeanUtil.copy(param, MesContractProjectOddJobConfigLink.class);
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesContractProjectOddJobConfigLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前零工配置不存在，请核对后操作");
      oldConfig.setStatus(status);
      this.baseMapper.updateById(oldConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesContractProjectOddJobConfigLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前零工配置不存在，删除失败");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectOddJobConfigLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesOddJobConfig> oddJobConfigList = this.oddJobConfigService.listInfo();
      if (CollUtil.isEmpty(oddJobConfigList)) {
         return Boolean.TRUE;
      }

      List<MesContractProjectOddJobConfigLink> configList = oddJobConfigList.stream().map(ojc -> {
         MesContractProjectOddJobConfigLink config = cn.hutool.core.bean.BeanUtil.toBean(ojc, MesContractProjectOddJobConfigLink.class);
         config.setContractProjectId(contractProjectId);
         return config;
      }).collect(Collectors.toList());
      this.saveBatch(configList);
      return Boolean.TRUE;
   }
}
