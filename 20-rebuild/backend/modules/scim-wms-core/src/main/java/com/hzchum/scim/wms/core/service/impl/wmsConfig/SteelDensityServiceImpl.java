package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.CommonValue;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SteelDensity;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SteelDensityClassTreeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SteelDensityDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SteelDensityDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SteelDensityService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SteelDensityMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SteelDensityServiceImpl extends ServiceImpl<SteelDensityMapper, SteelDensity> implements SteelDensityService {
   @Autowired
   private ClassificationService classificationService;
   @Autowired
   private RedisTemplate redisTemplate;
   private static final Integer DENSITY_BASIC_CLASS = BasicClassEnum.STEEL_PLATE.getType() | BasicClassEnum.COLOR_ROLL.getType();

   @Override
   public List<SteelDensityDTO> getSteelDensityConf(Long classifyId, String createBy, String updateBy) {
      List<SteelDensity> steelDensities = this.baseMapper
         .selectList(
            ((new LambdaQueryWrapper<SteelDensity>().eq(ObjectUtil.isNotEmpty(classifyId), SteelDensity::getClassifyId, classifyId))
                  .like(ObjectUtil.isNotEmpty(createBy), SteelDensity::getCreateBy, createBy))
               .like(ObjectUtil.isNotEmpty(updateBy), SteelDensity::getUpdateBy, updateBy)
         );
      if (CollectionUtil.isEmpty(steelDensities)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = steelDensities.stream().map(SteelDensity::getClassifyId).collect(Collectors.toList());
      Map<Long, String> classFullPathNameMap = this.classificationService.getClassFullPathNameMap(classifyIds, "->");
      List<SteelDensityDTO> steelDensityDTOS = new ArrayList<>();

      for (SteelDensity steelDensity : steelDensities) {
         String classFullPathName = classFullPathNameMap.get(steelDensity.getClassifyId());
         SteelDensityDTO steelDensityDTO = SteelDensityDTO.builder().build();
         steelDensityDTO.setId(steelDensity.getId());
         steelDensityDTO.setBasicClass(steelDensity.getBasicClass());
         steelDensityDTO.setClassifyId(steelDensity.getClassifyId());
         steelDensityDTO.setClassifyName(classFullPathName);
         steelDensityDTO.setDensity(steelDensity.getDensity());
         steelDensityDTO.setCreateBy(steelDensity.getCreateName());
         steelDensityDTO.setCreateTime(steelDensity.getCreateTime());
         steelDensityDTO.setUpdateBy(steelDensity.getUpdateName());
         steelDensityDTO.setUpdateTime(steelDensity.getUpdateTime());
         steelDensityDTOS.add(steelDensityDTO);
      }

      return steelDensityDTOS;
   }

   @Override
   public Boolean saveSteelDensity(List<SteelDensityDTOParam> steelDensityDTOParams) {
      SecurityUser currentUser = UserUtil.getCurrentUser();

      for (SteelDensityDTOParam steelDensityDTOParam : steelDensityDTOParams) {
         Classification classification = this.classificationService.getById(steelDensityDTOParam.getClassifyId());
         Preconditions.checkArgument(classification != null, "科目不存在");
         SteelDensity steelDensityGet = this.baseMapper
            .selectOne((Wrapper<SteelDensity>)new LambdaQueryWrapper<SteelDensity>().eq(SteelDensity::getClassifyId, steelDensityDTOParam.getClassifyId()));
         Preconditions.checkArgument(steelDensityGet == null, "科目已存在密度配置信息");
         SteelDensity steelDensity = BeanUtil.copy(steelDensityDTOParam, SteelDensity.class);
         steelDensity.setBasicClass(classification.getBasicClass());
         steelDensity.setCreateBy(currentUser.getId());
         steelDensity.setCreateName(currentUser.getName());
         steelDensity.setUpdateBy(currentUser.getId());
         steelDensity.setUpdateName(currentUser.getName());
         this.baseMapper.insert(steelDensity);
      }

      this.updateSteelDensityRedis();
      return true;
   }

   @Override
   public Boolean updateSteelDensity(SteelDensityDTOParam steelDensityDTOParam) {
      SteelDensity steelDensity = this.baseMapper.selectById(steelDensityDTOParam.getId());
      Preconditions.checkArgument(steelDensity != null, "数据不存在");
      SteelDensity steelDensityNe = this.baseMapper
         .selectOne(
            (Wrapper<SteelDensity>)(new LambdaQueryWrapper<SteelDensity>().eq(SteelDensity::getClassifyId, steelDensityDTOParam.getClassifyId()))
               .ne(SteelDensity::getId, steelDensityDTOParam.getId())
         );
      Preconditions.checkArgument(steelDensityNe == null, "修改后科目已存在密度配置信息");
      steelDensity.setClassifyId(steelDensityDTOParam.getClassifyId());
      steelDensity.setDensity(steelDensityDTOParam.getDensity());
      steelDensity.setUpdateBy(UserUtil.getCurrentUser().getId());
      steelDensity.setUpdateName(UserUtil.getCurrentName());
      this.baseMapper.updateById(steelDensity);
      this.updateSteelDensityRedis();
      return true;
   }

   @Override
   public Boolean deletedSteelDensity(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      this.updateSteelDensityRedis();
      return true;
   }

   @Override
   public Map<Long, BigDecimal> getRedisSteelDensity() {
      Map entries = this.redisTemplate.opsForHash().entries("wms-hash-steel-density");
      if (CollectionUtil.isEmpty(entries)) {
         this.updateSteelDensityRedis();
         entries = this.redisTemplate.opsForHash().entries("wms-hash-steel-density");
      }

      return entries;
   }

   @Override
   public void refreshRedisSteelDensity() {
      this.updateSteelDensityRedis();
   }

   @Override
   public BigDecimal getRedisSteelDensityByClassifyId(Long classifyId) {
      Object density = this.redisTemplate.opsForHash().get("wms-hash-steel-density", classifyId.toString());
      if (ObjectUtil.isEmpty(density)) {
         this.updateSteelDensityRedis();
         density = this.redisTemplate.opsForHash().get("wms-hash-steel-density", classifyId.toString());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(density), classifyId + "-》密度信息不存在");
      }

      return new BigDecimal(String.valueOf(density));
   }

   @Override
   public List<SteelDensityClassTreeDTO> getSteelClass() {
      new ArrayList();
      List<Classification> values = this.redisTemplate.<String, Classification>opsForHash().values("wms-hash-classification-all");
      List<Classification> classifications;
      if (CollectionUtil.isNotEmpty(values)) {
         classifications = values;
      } else {
         classifications = this.classificationService.list((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
         if (CollectionUtil.isNotEmpty(classifications)) {
            Map<String, Classification> collect = classifications.stream()
               .collect(Collectors.toMap(classificationx -> String.valueOf(classificationx.getId()), Function.identity()));
            this.redisTemplate.<String, Classification>opsForHash().putAll("wms-hash-classification-all", collect);
         }
      }

      if (CollectionUtils.isEmpty(classifications)) {
         return null;
      }

      classifications = classifications.stream()
         .filter(c -> (c.getBasicClass() & DENSITY_BASIC_CLASS) > 0)
         .sorted(Comparator.comparing(Classification::getParentId).thenComparing(Classification::getId))
         .collect(Collectors.toList());
      List<SteelDensity> steelDensities = this.baseMapper.selectList(null);
      List<SteelDensityClassTreeDTO> labelTree = CollUtil.newArrayList();

      for (Classification classification : classifications) {
         SteelDensity steelDensity = steelDensities.stream().filter(s -> s.getClassifyId().equals(classification.getId())).findAny().orElse(null);
         SteelDensityClassTreeDTO build = SteelDensityClassTreeDTO.builder()
            .id(classification.getId())
            .parentId(classification.getParentId())
            .level(classification.getLevel())
            .className(classification.getName())
            .basicClass(classification.getBasicClass())
            .isDensityConfig(ObjectUtil.isNotEmpty(steelDensity))
            .build();
         labelTree.add(build);
      }

      return this.listTree(labelTree);
   }

   @Override
   public String checkSteelDensity(Map<String, BigDecimal> steelDensityMap) {
      List<String> classNameList = new ArrayList<>();
      Map entries = this.redisTemplate.opsForHash().entries("wms-hash-steel-density");
      if (CollectionUtil.isEmpty(entries)) {
         this.updateSteelDensityRedis();
         entries = this.redisTemplate.opsForHash().entries("wms-hash-steel-density");
      }

      for (String l : steelDensityMap.keySet()) {
         BigDecimal sendDensity = steelDensityMap.get(l);
         BigDecimal redisDensity = (BigDecimal)entries.get(l);
         if (sendDensity.compareTo(redisDensity) != 0) {
            Classification byId = this.classificationService.getById(l);
            classNameList.add(byId.getName());
         }
      }

      String msg = "【注意：当前{" + String.join(",", classNameList) + "}最新设置密度与该单据创建时设置密度不一致，将会按照最新设置密度进行计算！！！】";
      return CollectionUtil.isNotEmpty(classNameList) ? msg : null;
   }

   public List<SteelDensityClassTreeDTO> listTree(List<SteelDensityClassTreeDTO> labelTree) {
      Map<Long, List<SteelDensityClassTreeDTO>> collect = labelTree.stream()
         .filter(Objects::nonNull)
         .filter(o -> o.getParentId() != 0L)
         .collect(Collectors.groupingBy(SteelDensityClassTreeDTO::getParentId));

      for (SteelDensityClassTreeDTO data : labelTree) {
         Long code = data.getId();
         List<SteelDensityClassTreeDTO> list = collect.get(code);
         data.setChildren(list);
      }

      return labelTree.stream().filter(e -> e.getParentId() == 0L).collect(Collectors.toList());
   }

   @Override
   public void updateSteelDensityRedis() {
      this.redisTemplate.delete("wms-hash-steel-density");
      List<SteelDensity> steelDensities = this.baseMapper
         .selectList(null)
         .stream()
         .sorted(Comparator.comparing(SteelDensity::getClassifyId))
         .collect(Collectors.toList());
      List<Long> classifyIds = new ArrayList<>();
      Map<String, BigDecimal> map = new HashMap<>();

      for (SteelDensity steelDensity : steelDensities) {
         map.put(steelDensity.getClassifyId().toString(), steelDensity.getDensity());
         classifyIds.add(steelDensity.getClassifyId());
         List<Classification> lastSubject = this.classificationService.getLastSubject(steelDensity.getClassifyId());
         if (CollectionUtil.isNotEmpty(lastSubject)) {
            for (Classification classification : lastSubject) {
               map.put(classification.getId().toString(), steelDensity.getDensity());
               classifyIds.add(classification.getId());
            }
         }
      }

      for (Classification classification : this.classificationService
         .list(
            (Wrapper<Classification>)(((new LambdaQueryWrapper<Classification>()
                        .like(Classification::getName, "不锈钢"))
                     .eq(Classification::getBoolLastEnum, true))
                  .notIn(CollectionUtil.isNotEmpty(classifyIds), Classification::getId, classifyIds))
               .last("and basic_class & " + DENSITY_BASIC_CLASS + " > 0")
         )) {
         map.put(classification.getId().toString(), CommonValue.STAINLESS_STEEL);
         classifyIds.add(classification.getId());
      }

      BigDecimal ordinarySteel = CommonValue.ORDINARY_STEEL;

      for (Classification classification : this.classificationService
         .list(
            (Wrapper<Classification>)((new LambdaQueryWrapper<Classification>().eq(Classification::getBoolLastEnum, true))
                  .notIn(CollectionUtil.isNotEmpty(classifyIds), Classification::getId, classifyIds))
               .last("and basic_class & " + DENSITY_BASIC_CLASS + " > 0")
         )) {
         map.put(classification.getId().toString(), CommonValue.ORDINARY_STEEL);
         classifyIds.add(classification.getId());
      }

      this.redisTemplate.<String, BigDecimal>opsForHash().putAll("wms-hash-steel-density", map);
   }
}
