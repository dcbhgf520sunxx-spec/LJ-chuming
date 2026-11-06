package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.system.core.api.pojo._do.MesOddJobConfig;
import com.hzchum.scim.system.core.api.pojo.request.MesOddJobConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesOddJobConfigService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesOddJobConfigMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesOddJobConfigServiceImpl extends ServiceImpl<MesOddJobConfigMapper, MesOddJobConfig> implements MesOddJobConfigService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public PageVO<MesOddJobConfig> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<MesOddJobConfig> pageInfo = PageHelper.<MesOddJobConfig>startPage(pageNumber, pageSize, s).doSelectPageInfo(this::list);
      List<MesOddJobConfig> list = pageInfo.getList();
      return new PageVO<>(list);
   }

   @Override
   public List<MesOddJobConfig> listInfo() {
      return this.list();
   }

   @Override
   public MesOddJobConfig detailById(Long id) {
      MesOddJobConfig oddJobConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oddJobConfig != null, "当前零工配置不存在，请核对后操作");
      return oddJobConfig;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOddJobConfig(MesOddJobConfigSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      int count = this.baseMapper.selectCount(Wrappers.lambdaQuery(MesOddJobConfig.class).eq(MesOddJobConfig::getOddJobType, param.getOddJobType()));
      Preconditions.checkArgument(count == 0, "零工类型重复");
      MesOddJobConfig oddJobConfig = BeanUtil.copy(param, MesOddJobConfig.class);
      this.baseMapper.insert(oddJobConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editOddJobConfig(MesOddJobConfigSaveDTOParam param) {
      MesOddJobConfig mesOddJobConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(mesOddJobConfig != null, "当前零工配置不存在，请核对后操作");
      int repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesOddJobConfig.class).ne(MesOddJobConfig::getId, param.getId()).eq(MesOddJobConfig::getOddJobType, param.getOddJobType())
         );
      Preconditions.checkArgument(repeat == 0, "零工类型重复");
      MesOddJobConfig oddJobConfig = BeanUtil.copy(param, MesOddJobConfig.class);
      this.baseMapper.updateById(oddJobConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesOddJobConfig mesOddJobConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(mesOddJobConfig != null, "当前零工配置不存在，请核对后操作");
      mesOddJobConfig.setStatus(status);
      this.baseMapper.updateById(mesOddJobConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteOddJobConfigById(Long id) {
      MesOddJobConfig mesOddJobConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(mesOddJobConfig != null, "当前零工配置不存在，删除失败");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
