package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliary;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliaryRelevancyWmsClass;
import com.hzchum.scim.system.core.api.pojo.dto.MesAuxiliaryDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesAuxiliaryRelevancyClassDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesAuxiliaryDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.MesAuxiliaryRelevancyClassDTOParam;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryRelevancyWmsClassService;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryService;
import com.hzchum.scim.system.core.mapper.MesAuxiliaryMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesAuxiliaryServiceImpl extends ServiceImpl<MesAuxiliaryMapper, MesAuxiliary> implements MesAuxiliaryService {
   @Autowired
   private MesAuxiliaryRelevancyWmsClassService mesAuxiliaryRelevancyWmsClassService;
   @Autowired
   private ClassificationService classificationService;
   @Autowired
   private MeasureService measureService;
   @Autowired
   private TechStandardPartService techStandardPartService;

   @Override
   public List<MesAuxiliaryDTO> selectList(Integer basicClass, String auxiliaryName, String className) {
      List<MesAuxiliary> mesAuxiliaries = this.baseMapper.list(basicClass, auxiliaryName, className);
      if (CollectionUtils.isEmpty(mesAuxiliaries)) {
         return new ArrayList<>();
      }

      List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClasses = this.mesAuxiliaryRelevancyWmsClassService.list(null);
      Map<Long, Classification> allClassifications = new HashMap<>();
      List<Long> allClassifyIds = mesAuxiliaryRelevancyWmsClasses.stream().map(MesAuxiliaryRelevancyWmsClass::getClassifyId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(allClassifyIds)) {
         allClassifications = this.classificationService
            .listByIds(allClassifyIds)
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
      }

      List<MesAuxiliaryDTO> mesAuxiliaryRelevancyWmsClassDTOS = new ArrayList<>();

      for (MesAuxiliary mesAuxiliary : mesAuxiliaries) {
         List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList = mesAuxiliaryRelevancyWmsClasses.stream()
            .filter(i -> i.getAuxiliaryId().equals(mesAuxiliary.getId()))
            .collect(Collectors.toList());
         MesAuxiliaryDTO mesAuxiliaryDTO = this.convertMesAuxiliaryDTO(mesAuxiliary, mesAuxiliaryRelevancyWmsClassList, allClassifications);
         mesAuxiliaryRelevancyWmsClassDTOS.add(mesAuxiliaryDTO);
      }

      return mesAuxiliaryRelevancyWmsClassDTOS;
   }

   @Override
   public MesAuxiliaryDTO selectById(Long id) {
      MesAuxiliary mesAuxiliary = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(mesAuxiliary), "配套件不存在");
      List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList = this.mesAuxiliaryRelevancyWmsClassService
         .list((Wrapper<MesAuxiliaryRelevancyWmsClass>)new LambdaQueryWrapper<MesAuxiliaryRelevancyWmsClass>().eq(MesAuxiliaryRelevancyWmsClass::getAuxiliaryId, id));
      Map<Long, Classification> allClassifications = new HashMap<>();
      List<Long> allClassifyIds = mesAuxiliaryRelevancyWmsClassList.stream().map(MesAuxiliaryRelevancyWmsClass::getClassifyId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(allClassifyIds)) {
         allClassifications = this.classificationService
            .listByIds(allClassifyIds)
            .stream()
            .collect(Collectors.toMap(Classification::getId, Function.identity()));
      }

      return this.convertMesAuxiliaryDTO(mesAuxiliary, mesAuxiliaryRelevancyWmsClassList, allClassifications);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean save(List<MesAuxiliaryDTOParam> dtoParams) {
      List<String> auxiliaryNameList = dtoParams.stream().flatMap(i -> i.getAuxiliaryNameList().stream()).collect(Collectors.toList());
      List<String> auxiliaryNameDistinctList = auxiliaryNameList.stream().distinct().collect(Collectors.toList());
      Preconditions.checkArgument(auxiliaryNameList.size() == auxiliaryNameDistinctList.size(), "配套件名称存在重复数据");
      List<String> errorAuxiliaryName = new ArrayList<>();

      for (String s : auxiliaryNameDistinctList) {
         List<MesAuxiliary> mesAuxiliaries = this.baseMapper
            .selectList((Wrapper<MesAuxiliary>)new LambdaQueryWrapper<MesAuxiliary>().last("and find_in_set('" + s + "',auxiliary_name)"));
         if (CollectionUtils.isNotEmpty(mesAuxiliaries)) {
            errorAuxiliaryName.add(s);
         }
      }

      Preconditions.checkArgument(CollectionUtils.isEmpty(errorAuxiliaryName), "配套件名称：" + String.join(",", errorAuxiliaryName) + "已存在");

      for (MesAuxiliaryDTOParam dtoParam : dtoParams) {
         if (CollectionUtils.isNotEmpty(dtoParam.getMesAuxiliaryRelevancyClassDTOParams())) {
            List<MesAuxiliaryRelevancyClassDTOParam> mesAuxiliaryRelevancyClassDTOParams = dtoParam.getMesAuxiliaryRelevancyClassDTOParams();
            List<Long> classifyIds = mesAuxiliaryRelevancyClassDTOParams.stream()
               .map(MesAuxiliaryRelevancyClassDTOParam::getClassifyId)
               .collect(Collectors.toList());
            List<Classification> classifications = this.classificationService.listByIds(classifyIds);
            List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
            this.checkClassification(classifications, measures, dtoParam.getBasicClass(), dtoParam.getAccountingUnit());
            MesAuxiliary mesAuxiliary = MesAuxiliary.builder()
               .auxiliaryName(String.join(",", dtoParam.getAuxiliaryNameList()))
               .accountingUnit(dtoParam.getAccountingUnit())
               .basicClass(dtoParam.getBasicClass())
               .meteDiff(ObjectUtil.isNotEmpty(dtoParam.getMeteDiff()) ? dtoParam.getMeteDiff() : BigDecimal.ZERO)
               .build();
            this.baseMapper.insert(mesAuxiliary);

            for (MesAuxiliaryRelevancyClassDTOParam mesAuxiliaryRelevancyClassDTOParam : mesAuxiliaryRelevancyClassDTOParams) {
               Classification classification = classifications.stream()
                  .filter(c -> c.getId().equals(mesAuxiliaryRelevancyClassDTOParam.getClassifyId()))
                  .findAny()
                  .orElse(null);
               Preconditions.checkArgument(classification != null, mesAuxiliaryRelevancyClassDTOParam.getClassifyName() + "科目不存在");
               Preconditions.checkArgument(classification.getBoolLastEnum(), mesAuxiliaryRelevancyClassDTOParam.getClassifyName() + "科目不属于末级科目");
               MesAuxiliaryRelevancyWmsClass mesAuxiliaryRelevancyWmsClass = MesAuxiliaryRelevancyWmsClass.builder()
                  .auxiliaryId(mesAuxiliary.getId())
                  .classifyId(mesAuxiliaryRelevancyClassDTOParam.getClassifyId())
                  .build();
               this.mesAuxiliaryRelevancyWmsClassService.save(mesAuxiliaryRelevancyWmsClass);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(dtoParams)) {
         Map<String, String> auxiliaryMap = dtoParams.stream()
            .flatMap(auxiliary -> auxiliary.getAuxiliaryNameList().stream().map(name -> new SimpleEntry<>(name.trim(), auxiliary.getAccountingUnit())))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         LambdaQueryWrapper<TechStandardPart> wrapper = new LambdaQueryWrapper<>();
         auxiliaryMap.forEach((key, value) -> wrapper.or().eq(TechStandardPart::getName, key).eq(TechStandardPart::getAccountingUnit, value));
         wrapper.eq(TechStandardPart::getConfigStatus, Boolean.FALSE);
         List<TechStandardPart> techStandardParts = this.techStandardPartService.list(wrapper);
         techStandardParts.forEach(e -> e.setConfigStatus(Boolean.TRUE));
         this.techStandardPartService.updateBatchById(techStandardParts);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean update(MesAuxiliaryDTOParam dtoParam) {
      if (CollectionUtils.isNotEmpty(dtoParam.getDelMesAuxiliaryRelevancyClassIds())) {
         this.mesAuxiliaryRelevancyWmsClassService.removeByIds(dtoParam.getDelMesAuxiliaryRelevancyClassIds());
      }

      MesAuxiliary mesAuxiliary = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(mesAuxiliary != null, "配套件不存在");
      List<String> errorAuxiliaryName = new ArrayList<>();

      for (String s : dtoParam.getAuxiliaryNameList()) {
         MesAuxiliary otherMesAuxiliary = this.baseMapper
            .selectOne(
               (Wrapper<MesAuxiliary>)(new LambdaQueryWrapper<MesAuxiliary>().ne(MesAuxiliary::getId, dtoParam.getId()))
                  .last("and find_in_set('" + s + "',auxiliary_name)")
            );
         if (otherMesAuxiliary != null) {
            errorAuxiliaryName.add(s);
         }
      }

      Preconditions.checkArgument(CollectionUtils.isEmpty(errorAuxiliaryName), "修改后配套件名称：" + String.join(",", errorAuxiliaryName) + "已存在配置");
      if (CollectionUtils.isNotEmpty(dtoParam.getMesAuxiliaryRelevancyClassDTOParams())) {
         List<Long> classifyIds = dtoParam.getMesAuxiliaryRelevancyClassDTOParams()
            .stream()
            .map(MesAuxiliaryRelevancyClassDTOParam::getClassifyId)
            .collect(Collectors.toList());
         List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList = this.mesAuxiliaryRelevancyWmsClassService
            .list((Wrapper<MesAuxiliaryRelevancyWmsClass>)new LambdaQueryWrapper<MesAuxiliaryRelevancyWmsClass>().eq(MesAuxiliaryRelevancyWmsClass::getAuxiliaryId, dtoParam.getId()));
         if (CollectionUtils.isNotEmpty(mesAuxiliaryRelevancyWmsClassList)) {
            Preconditions.checkArgument(ObjectUtil.equals(mesAuxiliary.getBasicClass(), dtoParam.getBasicClass()), "修改后基础类型与已关联的科目基础类型不匹配");
            Preconditions.checkArgument(ObjectUtil.equals(mesAuxiliary.getAccountingUnit(), dtoParam.getAccountingUnit()), "修改后核算单位与已关联的科目核算单位不匹配");
         }

         List<Long> equalsClassifyIds = mesAuxiliaryRelevancyWmsClassList.stream()
            .map(MesAuxiliaryRelevancyWmsClass::getClassifyId)
            .collect(Collectors.toList());
         classifyIds.removeAll(equalsClassifyIds);
         if (CollectionUtils.isNotEmpty(classifyIds)) {
            List<Classification> classifications = this.classificationService.listByIds(classifyIds);
            List<Measure> measures = this.measureService.list((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().in(Measure::getClassificationId, classifyIds));
            this.checkClassification(classifications, measures, dtoParam.getBasicClass(), dtoParam.getAccountingUnit());

            for (MesAuxiliaryRelevancyClassDTOParam mesAuxiliaryRelevancyClassDTOParam : dtoParam.getMesAuxiliaryRelevancyClassDTOParams()) {
               MesAuxiliaryRelevancyWmsClass mesAuxiliaryRelevancyWmsClass = MesAuxiliaryRelevancyWmsClass.builder()
                  .auxiliaryId(dtoParam.getId())
                  .classifyId(mesAuxiliaryRelevancyClassDTOParam.getClassifyId())
                  .build();
               this.mesAuxiliaryRelevancyWmsClassService.save(mesAuxiliaryRelevancyWmsClass);
            }
         }
      }

      List<String> oldAuxiliaryNameList = Arrays.stream(mesAuxiliary.getAuxiliaryName().split(",")).map(String::valueOf).collect(Collectors.toList());
      String oldAccountingUnit = mesAuxiliary.getAccountingUnit();
      String newAccountingUnit = ObjectUtil.isNotEmpty(dtoParam.getAccountingUnit()) ? dtoParam.getAccountingUnit() : oldAccountingUnit;
      if (ObjectUtil.notEqual(oldAccountingUnit, newAccountingUnit)) {
         for (String s : oldAuxiliaryNameList) {
            TechStandardPart techStandardPart = this.techStandardPartService
               .getOne((Wrapper<TechStandardPart>)(new LambdaQueryWrapper<TechStandardPart>().eq(TechStandardPart::getName, s)).last("limit 1"));
            if (ObjectUtil.isNotEmpty(techStandardPart)) {
               errorAuxiliaryName.add(s);
            }
         }

         Preconditions.checkArgument(CollectionUtils.isEmpty(errorAuxiliaryName), "配套件：" + String.join(",", errorAuxiliaryName) + "已导入配套件清单");
      }

      List<String> newAuxiliaryNameList = CollectionUtils.isNotEmpty(dtoParam.getAuxiliaryNameList()) ? dtoParam.getAuxiliaryNameList() : oldAuxiliaryNameList;
      oldAuxiliaryNameList.removeAll(newAuxiliaryNameList);
      if (CollectionUtils.isNotEmpty(oldAuxiliaryNameList)) {
         for (String s : oldAuxiliaryNameList) {
            TechStandardPart techStandardPart = this.techStandardPartService
               .getOne((Wrapper<TechStandardPart>)(new LambdaQueryWrapper<TechStandardPart>().eq(TechStandardPart::getName, s)).last("limit 1"));
            if (ObjectUtil.isNotEmpty(techStandardPart)) {
               errorAuxiliaryName.add(s);
            }
         }

         Preconditions.checkArgument(CollectionUtils.isEmpty(errorAuxiliaryName), "配套件《" + String.join(",", errorAuxiliaryName) + "》已导入配套件清单");
      }

      if (CollectionUtils.isNotEmpty(dtoParam.getAuxiliaryNameList())) {
         mesAuxiliary.setAuxiliaryName(String.join(",", dtoParam.getAuxiliaryNameList()));
      }

      if (dtoParam.getAccountingUnit() != null) {
         mesAuxiliary.setAccountingUnit(dtoParam.getAccountingUnit());
      }

      if (dtoParam.getBasicClass() != null) {
         mesAuxiliary.setBasicClass(dtoParam.getBasicClass());
      }

      if (dtoParam.getMeteDiff() != null) {
         mesAuxiliary.setMeteDiff(dtoParam.getMeteDiff());
      }

      if (dtoParam.getAccountingUnit() != null && dtoParam.getAccountingUnit() != null) {
         LambdaQueryWrapper<TechStandardPart> wrapper = new LambdaQueryWrapper<>();
         dtoParam.getAuxiliaryNameList()
            .forEach(
               name -> wrapper.or()
                  .eq(TechStandardPart::getName, name)
                  .eq(TechStandardPart::getAccountingUnit, dtoParam.getAccountingUnit())
                  .eq(TechStandardPart::getConfigStatus, Boolean.FALSE)
            );
         List<TechStandardPart> techStandardParts = this.techStandardPartService.list(wrapper);
         techStandardParts.forEach(e -> e.setConfigStatus(Boolean.TRUE));
         this.techStandardPartService.updateBatchById(techStandardParts);
      }

      return this.baseMapper.updateById(mesAuxiliary) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleted(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      this.mesAuxiliaryRelevancyWmsClassService
         .remove((Wrapper<MesAuxiliaryRelevancyWmsClass>)new LambdaQueryWrapper<MesAuxiliaryRelevancyWmsClass>().in(MesAuxiliaryRelevancyWmsClass::getAuxiliaryId, ids));
      return true;
   }

   @Override
   public Map<Long, String> getClassification(Integer basicClass, String accountingUnit) {
      List<Classification> classificationByBasicClassAndUnit = this.classificationService.getClassificationByBasicClassAndUnit(basicClass, accountingUnit);
      if (CollectionUtils.isEmpty(classificationByBasicClassAndUnit)) {
         return new HashMap<>();
      }

      Map<Long, String> map = new HashMap<>();

      for (Classification classification : classificationByBasicClassAndUnit) {
         List<Long> classifyIds = Arrays.stream(classification.getPath().split(",")).map(Long::valueOf).sorted().collect(Collectors.toList());
         List<Classification> classifications = this.classificationService
            .listByIds(classifyIds)
            .stream()
            .sorted(Comparator.comparing(Classification::getId))
            .collect(Collectors.toList());
         StringBuilder stringBuilder = new StringBuilder();

         for (Classification classification1 : classifications) {
            if (stringBuilder.length() > 0) {
               stringBuilder.append("->");
            }

            stringBuilder.append(classification1.getName());
         }

         map.put(classification.getId(), stringBuilder.toString());
      }

      return map;
   }

   private void checkClassification(List<Classification> classifications, List<Measure> measures, Integer basicClass, String accountingUnit) {
      String errorMsg = classifications.stream()
         .filter(c -> !c.getBasicClass().equals(basicClass))
         .map(Classification::getName)
         .collect(Collectors.joining(","));
      Preconditions.checkArgument(StringUtils.isBlank(errorMsg), errorMsg + "与配套件所选基础类型不一致");
      List<Long> measureClassifyIds = measures.stream()
         .filter(m -> !m.getAccountingUnit().equals(accountingUnit))
         .map(Measure::getClassificationId)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(measureClassifyIds)) {
         errorMsg = classifications.stream().filter(c -> measureClassifyIds.contains(c.getId())).map(Classification::getName).collect(Collectors.joining(","));
         Preconditions.checkArgument(StringUtils.isBlank(errorMsg), errorMsg + "核算单位与配套件所选科目核算单位不一致");
      }
   }

   private MesAuxiliaryDTO convertMesAuxiliaryDTO(
      MesAuxiliary mesAuxiliary, List<MesAuxiliaryRelevancyWmsClass> mesAuxiliaryRelevancyWmsClassList, Map<Long, Classification> allClassifications
   ) {
      List<MesAuxiliaryRelevancyClassDTO> mesAuxiliaryRelevancyClassDTOS = new ArrayList<>();

      for (MesAuxiliaryRelevancyWmsClass mesAuxiliaryRelevancyWmsClass : mesAuxiliaryRelevancyWmsClassList) {
         Classification classification = allClassifications.get(mesAuxiliaryRelevancyWmsClass.getClassifyId());
         MesAuxiliaryRelevancyClassDTO mesAuxiliaryRelevancyClassDTO = MesAuxiliaryRelevancyClassDTO.builder()
            .id(mesAuxiliaryRelevancyWmsClass.getId())
            .classifyId(mesAuxiliaryRelevancyWmsClass.getClassifyId())
            .auxiliaryId(mesAuxiliaryRelevancyWmsClass.getAuxiliaryId())
            .classifyName(classification.getName())
            .auxiliaryName(mesAuxiliary.getAuxiliaryName())
            .build();
         mesAuxiliaryRelevancyClassDTOS.add(mesAuxiliaryRelevancyClassDTO);
      }

      MesAuxiliaryDTO mesAuxiliaryDTO = MesAuxiliaryDTO.builder()
         .id(mesAuxiliary.getId())
         .basicClass(mesAuxiliary.getBasicClass())
         .auxiliaryNameList(Arrays.stream(mesAuxiliary.getAuxiliaryName().split(",")).collect(Collectors.toList()))
         .accountingUnit(mesAuxiliary.getAccountingUnit())
         .meteDiff(mesAuxiliary.getMeteDiff())
         .mesAuxiliaryRelevancyClassDTOS(mesAuxiliaryRelevancyClassDTOS)
         .build();
      return mesAuxiliaryDTO;
   }
}
