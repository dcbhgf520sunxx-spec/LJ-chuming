package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanMonomerDTO;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.mapper.PlanMonomerMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlanMonomerServiceImpl extends ServiceImpl<PlanMonomerMapper, PlanMonomer> implements PlanMonomerService {
   @Override
   public List<PlanMonomerDTO> listByCondition(Long projectId, String name) {
      return this.baseMapper.listByProjectIdAndName(projectId, name);
   }

   @Override
   public PlanMonomerDTO getMonomerById(Long id) {
      PlanMonomer planMonomer = this.baseMapper.selectById(id);
      Preconditions.checkArgument(planMonomer != null, "单体不存在");
      return BeanUtil.copy(planMonomer, PlanMonomerDTO.class);
   }

   @Cacheable(cacheNames = "monomer", key = "#id", unless = "#result == null")
   @Override
   public PlanMonomer getByIdFromCache(Long id) {
      return this.baseMapper.selectById(id);
   }

   @CachePut(cacheNames = "monomer", key = "#monomer.id")
   @Override
   public PlanMonomer updateWithCache(PlanMonomer monomer) {
      this.baseMapper.updateById(monomer);
      return monomer;
   }

   @CachePut(cacheNames = "monomer", key = "#monomer.id")
   @Override
   public PlanMonomer saveWithCache(PlanMonomer monomer) {
      this.baseMapper.insert(monomer);
      return monomer;
   }

   @CacheEvict(cacheNames = "monomer", key = "#id")
   @Override
   public int deleteWithCache(Long id) {
      return this.baseMapper.deleteById(id);
   }

   @Override
   public NameInfo getSimpleById(Long monomerId) {
      PlanMonomer monomer = this.baseMapper.selectById(monomerId);
      return BeanUtil.copy(monomer, NameInfo.class);
   }

   @Override
   public List<NameInfo> listNameInfo(Collection<Long> monomerIds) {
      return this.baseMapper.selectBatchIds(monomerIds).stream().map(m -> BeanUtil.copy(m, NameInfo.class)).collect(Collectors.toList());
   }

   @Override
   public PlanMaxMinDateDTO getMonomerDate(Long projectId) {
      return this.baseMapper.selectMinMaxDate(projectId);
   }

   @Override
   public List<PlanMonomerDTO> getNoDeepenedPersonId(Long projectId) {
      return this.baseMapper.selectNoDeepenedPersonId(projectId);
   }

   @Override
   public Integer yearOrderTon() {
      return this.baseMapper.yearOrderTon();
   }

   @Override
   public List<ProjectPlanMonomerDTO> getListByProjectId(Long projectId) {
      return this.baseMapper.getListByProjectId(projectId);
   }
}
