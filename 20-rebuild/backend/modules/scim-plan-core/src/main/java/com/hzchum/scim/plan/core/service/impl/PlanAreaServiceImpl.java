package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.plan.core.api.enums.AreaProductTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectPlanAreaDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.mapper.PlanAreaMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlanAreaServiceImpl extends ServiceImpl<PlanAreaMapper, PlanArea> implements PlanAreaService {
   private static final Logger log = LoggerFactory.getLogger(PlanAreaServiceImpl.class);

   @Override
   public PageVO<PlanAreaDTO> listAreaByConditions(
      Long projectId, Long monomerId, Integer productType, Integer itemizedType, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<PlanArea> areaList = this.baseMapper
         .selectList(
            (Wrapper<PlanArea>)((((new LambdaQueryWrapper<PlanArea>()
                           .eq(projectId != null, PlanArea::getProjectId, projectId))
                        .eq(monomerId != null, PlanArea::getMonomerId, monomerId))
                     .eq(productType != null, PlanArea::getProductType, productType))
                  .eq(itemizedType != null, PlanArea::getItemizedType, itemizedType))
               .orderByAsc(PlanArea::getSort)
         );
      List<PlanAreaDTO> areaDTOList = areaList.stream().map(a -> BeanUtil.copy(a, PlanAreaDTO.class)).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(areaDTOList, areaList));
   }

   @Override
   public ListVO<Map<String, Object>> listProductTypeByMonomerId(Long monomerId) {
      List<Map<String, Object>> maps = new ArrayList<>();
      List<PlanArea> areaList = this.baseMapper.selectList(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomerId));
      List<Integer> productTypeList = areaList.stream().map(PlanArea::getProductType).distinct().sorted().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(productTypeList)) {
         productTypeList.forEach(productType -> {
            Map<String, Object> map = new HashMap<>();
            map.put("type", productType);
            map.put("name", AreaProductTypeEnum.getNameByType(productType));
            maps.add(map);
         });
      }

      return new ListVO<>(maps);
   }

   @Cacheable(cacheNames = "area", key = "#areaId", unless = "#result == null")
   @Override
   public PlanArea getByIdFromCache(Long areaId) {
      return this.baseMapper.selectById(areaId);
   }

   @CachePut(cacheNames = "area", key = "#area.id")
   @Override
   public PlanArea updateAreaWithCache(PlanArea area) {
      this.baseMapper.updateById(area);
      return area;
   }

   @CachePut(cacheNames = "area", key = "#area.id")
   @Override
   public PlanArea saveAreaWithCache(PlanArea area) {
      this.baseMapper.insert(area);
      return area;
   }

   @CacheEvict(cacheNames = "area", key = "#id")
   @Override
   public int deleteAreaWithCache(Long id) {
      return this.baseMapper.deleteById(id);
   }

   @Override
   public NameInfo getSimpleById(Long areaId) {
      PlanArea area = this.baseMapper.selectById(areaId);
      return BeanUtil.copy(area, NameInfo.class);
   }

   @Override
   public List<NameInfo> listSimpleByIds(Collection<Long> areaIds) {
      return CollectionUtils.isEmpty(areaIds)
         ? Collections.emptyList()
         : this.baseMapper.selectBatchIds(areaIds).stream().map(a -> BeanUtil.copy(a, NameInfo.class)).collect(Collectors.toList());
   }

   @Override
   public PlanMaxMinDateDTO getMaxMinDate(Long monomerId, Integer areaProductType) {
      return this.baseMapper.selectMaxMinDate(monomerId, areaProductType);
   }

   @Override
   public List<PlanArea> listAreaByMonomerId(Long monomerId) {
      // Same monomer boundary already used by listProductTypeByMonomerId in this source class.
      return this.baseMapper.selectList(Wrappers.lambdaQuery(PlanArea.class).eq(PlanArea::getMonomerId, monomerId));
   }

   @Override
   public List<PlanArea> getMachinePartByAreaList(Set<Long> cutIds, List<Long> projectIds) {
      return null;
   }

   @Override
   public List<PlanArea> getArtifactAndAssembleByAreaList(Set<Long> assemblesTaskOrderIds, Integer taskTypeEnum) {
      return null;
   }

   @Override
   public List<ProjectPlanAreaDTO> getListByProjectId(Long projectId) {
      return this.baseMapper.getListByProjectId(projectId);
   }
}
