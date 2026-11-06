package com.hzchum.scim.mes.building.core.biz.impl.wage_quota_management;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesPaintingQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesPaintingQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesPaintingQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesPaintingQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesPaintingQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesPaintingQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesPaintingQuotaConfigBizImpl
   extends IBizImpl<MesPaintingQuotaConfigService, MesPaintingQuotaConfigMapper, MesPaintingQuotaConfig>
   implements MesPaintingQuotaConfigBiz {
   @Override
   public PageVO<MesPaintingQuotaConfigDTO> pageInfo(Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      return new PageVO<>(page, this.listInfo());
   }

   @Override
   public List<MesPaintingQuotaConfigDTO> listInfo() {
      return this.baseService.listInfo();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addInfo(MesPaintingQuotaConfigParam param) {
      this.verifyParam(param);
      MesPaintingQuotaConfig paintingQuotaConfig = BeanUtil.toBean(param, MesPaintingQuotaConfig.class);
      paintingQuotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      this.baseService.save(paintingQuotaConfig);
      return true;
   }

   private void verifyParam(MesPaintingQuotaConfigParam param) {
      LambdaQueryWrapper<MesPaintingQuotaConfig> qw = Wrappers.lambdaQuery(MesPaintingQuotaConfig.class)
         .ne(param.getId() != null, MesPaintingQuotaConfig::getId, param.getId());
      qw.and(q -> param.getWorkshopIdList().forEach(workshopId -> q.or(wq -> {
         LambdaQueryWrapper var10000 = wq.apply("FIND_IN_SET({0}, workshop_ids) > 0", workshopId);
      })));
      int count = this.baseService.count(qw);
      Preconditions.checkArgument(count == 0, "包含已有配置车间, 请重新操作");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInfo(MesPaintingQuotaConfigParam param) {
      MesPaintingQuotaConfig oldPaintingQuotaConfig = this.baseService.getById(param.getId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldPaintingQuotaConfig), "当前数据不存在, 请刷新后重试");
      this.verifyParam(param);
      MesPaintingQuotaConfig paintingQuotaConfig = BeanUtil.toBean(param, MesPaintingQuotaConfig.class);
      paintingQuotaConfig.setWorkshopIds(StrUtil.join(",", param.getWorkshopIdList()));
      this.baseService.updateById(paintingQuotaConfig);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesPaintingQuotaConfig oldPaintingQuotaConfig = this.baseService.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(oldPaintingQuotaConfig), "当前数据不存在, 请刷新后重试");
      this.baseService.removeById(id);
      return true;
   }
}
