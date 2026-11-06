package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.ParameterExpireException;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.pangu.redis.util.StringRedisUtil;
import com.hzchum.scim.common.core.api.pojo.common.ClassificationCheckDTO;
import com.hzchum.scim.common.core.api.pojo.common.IdsStatusDTO;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.scm.core.api.enums.ClassifyUpdateStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchaseDetail;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseDetailService;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.pojo._do.MesAuxiliaryRelevancyWmsClass;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassifyLink;
import com.hzchum.scim.system.core.api.service.MesAuxiliaryRelevancyWmsClassService;
import com.hzchum.scim.system.core.api.service.SysSteelClassifyLinkService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ClassExcel;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.ConvertConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpec;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SectionSteelSpecStandardDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Standard;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo.dto.common.IdAndNameConvertDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.ClassifySpecDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SpecificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectSpecMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectTreeDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectTreeImportDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SpecConfigDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SpecConfigDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.ClassificationDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SteelDensityService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.ClassificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.MeasureMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelConfigMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SectionSteelSpecStandardDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SpecificationMapper;
import com.hzchum.scim.wms.core.mapper.wmsConfig.StandardMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialInventoryMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClassificationServiceImpl extends ServiceImpl<ClassificationMapper, Classification> implements ClassificationService {
   @Resource
   StringRedisUtil stringRedisUtil;
   @Resource
   SectionSteelConfigMapper proximateMatterConfigMapper;
   @Resource
   SectionSteelSpecMapper sectionSteelSpecMapper;
   @Resource
   SectionSteelConfigMapper sectionSteelConfigMapper;
   @Resource
   PurchaseOrderService purchaseOrderService;
   @Resource
   PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   SectionSteelSpecStandardDetailMapper standardDetailMapper;
   @Resource
   StandardMapper standardMapper;
   @Resource
   InboundDetailMapper inboundDetailMapper;
   @Resource
   MaterialInventoryMapper materialInventoryMapper;
   @Resource
   ApplyPurchaseService applyPurchaseService;
   @Resource
   ApplyPurchaseDetailService applyPurchaseDetailService;
   @Autowired
   SysSteelClassifyLinkService steelClassifyLinkService;
   @Resource
   MeasureService measureService;
   @Resource
   private ClassificationMapper classificationMapper;
   @Resource
   private SpecificationMapper specificationMapper;
   @Resource
   private MeasureMapper measureMapper;
   @Resource
   private MesAuxiliaryRelevancyWmsClassService mesAuxiliaryRelevancyWmsClassService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private SteelDensityService steelDensityService;
   @Resource
   BasicConfigService basicConfigService;
   @Value("${wms.path-symbol}")
   private String pathSymbol;

   public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
      Map<Object, Boolean> seen = new ConcurrentHashMap<>();
      return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
   }

   @Override
   public List<SubjectTreeDTO> treeNew(Boolean status) {
      List<Classification> classificationsLast = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)((Wrappers.<Classification>lambdaQuery()
                     .eq(ObjectUtil.isNotEmpty(status), Classification::getBoolStatus, status))
                  .eq(Classification::getBoolLastEnum, true))
               .orderByAsc(Classification::getBasicClass)
         );
      if (CollectionUtils.isEmpty(classificationsLast)) {
         return null;
      }

      List<Long> classifyIds = classificationsLast.stream()
         .flatMap(c -> Arrays.stream(c.getPath().split(",")).map(Long::valueOf))
         .distinct()
         .collect(Collectors.toList());
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().in(Classification::getId, classifyIds))
               .orderByAsc(Classification::getBasicClass)
         );
      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      Map<Long, Boolean> classifyLinkMap = this.steelClassifyLinkService
         .list()
         .stream()
         .collect(Collectors.toMap(SysSteelClassifyLink::getClassifyId, e -> true));
      List<SubjectTreeDTO> build = this.build(0L, subjectMap, classifyLinkMap);
      return CollectionUtil.isNotEmpty(build) ? build : new ArrayList<>();
   }

   @Override
   public List<SubjectTreeDTO> tree(Integer type) {
      new ArrayList();
      List<Classification> values = this.redisTemplate.<String, Classification>opsForHash().values("wms-hash-classification-all");
      List<Classification> classifications;
      if (CollectionUtil.isNotEmpty(values)) {
         classifications = values;
      } else {
         classifications = this.classificationMapper.selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
         if (CollectionUtil.isNotEmpty(classifications)) {
            Map<String, Classification> collect = classifications.stream()
               .collect(Collectors.toMap(classification -> String.valueOf(classification.getId()), Function.identity()));
            this.redisTemplate.<String, Classification>opsForHash().putAll("wms-hash-classification-all", collect);
         }
      }

      if (CollectionUtils.isEmpty(classifications)) {
         return null;
      }

      if (type == 2) {
         Integer materialNum = BasicClassEnum.getMaterialNum();
         classifications = classifications.stream()
            .filter(c -> (c.getBasicClass() & materialNum) > 0)
            .sorted(Comparator.comparing(Classification::getParentId).thenComparing(Classification::getId))
            .collect(Collectors.toList());
      }

      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      Map<Long, Boolean> classifyLinkMap = this.steelClassifyLinkService
         .list()
         .stream()
         .collect(Collectors.toMap(SysSteelClassifyLink::getClassifyId, e -> true));
      List<SubjectTreeDTO> build = this.build(0L, subjectMap, classifyLinkMap);
      return CollectionUtil.isNotEmpty(build) ? build : new ArrayList<>();
   }

   @Override
   public void exportClassificationList(HttpServletResponse response) {
      new ArrayList();
      List<Classification> classifications = this.classificationMapper
         .selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      Map<Long, Boolean> classifyLinkMap = this.steelClassifyLinkService
         .list()
         .stream()
         .collect(Collectors.toMap(SysSteelClassifyLink::getClassifyId, e -> true));
      List<SubjectTreeDTO> build = this.build(0L, subjectMap, classifyLinkMap);
      String title = "科目配置清单";
      String sheetName = "科目配置清单";
      String fileName = "科目配置清单.xlsx";
      Integer orderNo = 1;
      List<SubjectTreeImportDTO> subjectTreeImportDTOS = new ArrayList<>();

      for (SubjectTreeDTO subjectTreeDTO : build) {
         SubjectTreeImportDTO copy = BeanUtil.copy(subjectTreeDTO, SubjectTreeImportDTO.class);
         Integer var14 = orderNo;
         orderNo = orderNo + 1;
         copy.setOrderNo(var14);
         copy.setNameA(subjectTreeDTO.getName());
         copy.setCodeA(subjectTreeDTO.getCode());
         if (subjectTreeDTO.getBasicClass() == 1) {
            copy.setBasicClass("钢板");
         }

         if (subjectTreeDTO.getBasicClass() == 2) {
            copy.setBasicClass("型材");
         }

         if (subjectTreeDTO.getBasicClass() == 4) {
            copy.setBasicClass("钢卷");
         }

         if (subjectTreeDTO.getBasicClass() == 8) {
            copy.setBasicClass("辅材");
         }

         if (subjectTreeDTO.getBasicClass() == 16) {
            copy.setBasicClass("气体");
         }

         if (subjectTreeDTO.getBasicClass() == 128) {
            copy.setBasicClass("办公用品");
         }

         if (subjectTreeDTO.getBasicClass() == 256) {
            copy.setBasicClass("其它钢材");
         }

         subjectTreeImportDTOS.add(copy);
         if (subjectTreeDTO.getChildren() != null) {
            for (SubjectTreeDTO child : subjectTreeDTO.getChildren()) {
               SubjectTreeImportDTO copy1 = BeanUtil.copy(child, SubjectTreeImportDTO.class);
               copy1.setNameB(child.getName());
               copy1.setCodeB(child.getCode());
               copy1.setSerialNumberA(child.getSerialNumber());
               copy1.setBasicClass(null);
               subjectTreeImportDTOS.add(copy1);
               if (child.getChildren() != null) {
                  for (SubjectTreeDTO childChild : child.getChildren()) {
                     SubjectTreeImportDTO copy2 = BeanUtil.copy(childChild, SubjectTreeImportDTO.class);
                     copy2.setNameC(childChild.getName());
                     copy2.setCodeC(childChild.getCode());
                     copy2.setSerialNumberB(childChild.getSerialNumber());
                     copy2.setBasicClass(null);
                     subjectTreeImportDTOS.add(copy2);
                  }
               }
            }
         }
      }

      PoiUtils.wmsExportExcel(subjectTreeImportDTOS, title, sheetName, SubjectTreeImportDTO.class, fileName, response);
   }

   private List<SubjectTreeDTO> build(Long pid, Map<Long, List<Classification>> subjectMap, Map<Long, Boolean> classifyLinkMap) {
      List<Classification> classifications = subjectMap.get(pid);
      if (CollectionUtils.isEmpty(classifications)) {
         return null;
      }

      ArrayList<String> objects = new ArrayList<>();
      ArrayList<Classification> objects1 = new ArrayList<>();
      if (classifications.get(0).getParentId() == 0L) {
         Map<Integer, List<Classification>> subjectMap1 = classifications.stream().collect(Collectors.groupingBy(Classification::getBasicClass));
         Map<Integer, List<Classification>> sortedMap = new TreeMap<>(subjectMap1);
         ArrayList<Classification> parentObject = new ArrayList<>();

         for (Entry<Integer, List<Classification>> entry : sortedMap.entrySet()) {
            Integer key = entry.getKey();
            List<Classification> value = entry.getValue();
            ArrayList<String> stringArrayList = new ArrayList<>();
            ArrayList<Classification> ClassificationList = new ArrayList<>();
            value.forEach(classification -> {
               String str1 = classification.getCode().replaceAll("\\D", "");
               if (StrUtil.isNotBlank(str1)) {
                  stringArrayList.add(str1);
               } else {
                  ClassificationList.add(classification);
               }
            });
            if (CollectionUtil.isNotEmpty(stringArrayList)) {
               List<String> collect = stringArrayList.stream().sorted(Comparator.comparing(c -> Integer.parseInt(c))).collect(Collectors.toList());
               collect.forEach(collect1 -> value.forEach(classification -> {
                  if (classification.getCode().replaceAll("\\D", "").equals(collect1)) {
                     parentObject.add(classification);
                  }
               }));
            }

            parentObject.addAll(ClassificationList);
         }

         List<Classification> collect = parentObject.stream().distinct().collect(Collectors.toList());
         objects1.addAll(collect);
      } else {
         ArrayList<Classification> ClassificationList = new ArrayList<>();
         classifications.forEach(classification -> {
            String str1 = classification.getCode().replaceAll("\\D", "");
            if (StrUtil.isNotBlank(str1)) {
               objects.add(str1);
            } else {
               ClassificationList.add(classification);
            }
         });
         if (CollectionUtil.isNotEmpty(objects)) {
            List<String> collect = objects.stream().sorted(Comparator.comparing(c -> Integer.parseInt(c))).collect(Collectors.toList());
            collect.forEach(collect1 -> classifications.forEach(classification -> {
               if (classification.getCode().replaceAll("\\D", "").equals(collect1)) {
                  objects1.add(classification);
               }
            }));
         }

         objects1.addAll(ClassificationList);
      }

      return objects1.stream().distinct().map(subject -> {
         SubjectTreeDTO tree = SubjectTreeDTO.builder().id(subject.getId()).build();
         BeanUtils.copyProperties(subject, tree);
         Boolean isUseSteel = classifyLinkMap.get(subject.getId());
         tree.setIsUseSteel(isUseSteel != null && isUseSteel);
         tree.setChildren(this.build(tree.getId(), subjectMap, classifyLinkMap));
         tree.setBoolLastEnum(subject.getBoolLastEnum());
         tree.setClassifyUpdateStatus(subject.getClassifyUpdateStatus());
         tree.setBoolStatus(subject.getBoolStatus());
         return tree;
      }).collect(Collectors.toList());
   }

   private SubjectDetailDTO setRedisKeyValue(Classification classification) {
      SubjectDetailDTO detailDTO = SubjectDetailDTO.builder().build();
      BeanUtils.copyProperties(classification, detailDTO);
      detailDTO.setSubjectId(classification.getId());
      List<SpecificationDTO> specificationDTOS = this.specificationMapper.selectBySubjectId(classification.getId());
      detailDTO.setSpecifications(specificationDTOS);
      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, classification.getId()));
      if (measure != null) {
         if (measure.getMeasureUnit() == null && classification.getParentId() != 0L) {
            this.setMetrologyMeasure(measure, classification.getParentId());
         }

         BeanUtils.copyProperties(measure, detailDTO);
         detailDTO.setMeasureId(measure.getId());
      }

      this.stringRedisUtil.hPut("wms-subject", String.valueOf(classification.getId()), JSON.toJSONString(detailDTO));
      return detailDTO;
   }

   private void setMetrologyMeasure(Measure measure, Long parentId) {
      Measure parenMeasure = this.measureMapper.selectOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, parentId));
      if (parenMeasure.getMeasureUnit() == null) {
         Classification parentClassification = this.classificationMapper.selectById(parentId);
         this.setMetrologyMeasure(measure, parentClassification.getParentId());
      }

      measure.setMeasureUnit(parenMeasure.getMeasureUnit());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean batchAddSubject(List<ClassificationDTOParam> classificationDTOParams) {
      for (ClassificationDTOParam classificationDTOParam : classificationDTOParams) {
         Classification classification = Classification.builder().build();
         String parentCode = "";
         int level = 1;
         String path = "";
         if (classificationDTOParam.getParentId() != null && !classificationDTOParam.getParentId().equals(0L)) {
            Classification parent = this.classificationMapper.selectById(classificationDTOParam.getParentId());
            Preconditions.checkArgument(parent != null, "父级科目不存在");
            level = parent.getLevel() + 1;
            parentCode = parent.getSerialNumber();
            path = parent.getPath() + ",";
            classification.setBasicClass(parent.getBasicClass());
            if (parent.getBoolLastEnum()) {
               parent.setBoolLastEnum(false);
               parent.setUpdateTime(LocalDateTime.now());
               parent.setUserUpdateTime(LocalDateTime.now());
               this.classificationMapper.updateById(parent);
               this.updateClassRedis(null, parent);
            }
         } else {
            Preconditions.checkArgument(false, "一级科目禁止新增、修改、删除等操作！！！");
            Preconditions.checkArgument(classificationDTOParam.getBasicClass() != null, "一级科目须填写基础物料类型");
            classification.setBasicClass(classificationDTOParam.getBasicClass());
         }

         Preconditions.checkArgument(StringUtils.isNotBlank(classificationDTOParam.getCode()), "代码不能为空");
         String subjectCode = classificationDTOParam.getCode().trim().toUpperCase();
         classification.setCode(subjectCode);
         classification.setParentId(classificationDTOParam.getParentId() == null ? 0L : classificationDTOParam.getParentId());
         classification.setName(classificationDTOParam.getName());
         classification.setLevel(level);
         String number = parentCode + classification.getCode();
         LambdaQueryWrapper<Classification> queryWrapper = Wrappers.<Classification>lambdaQuery();
         queryWrapper.eq(Classification::getParentId, classification.getParentId());
         queryWrapper.and(qw -> {
            LambdaQueryWrapper var10000 = qw.eq(Classification::getSerialNumber, number).or().eq(Classification::getName, classificationDTOParam.getName());
         });
         Classification numberClassification = this.classificationMapper.selectOne(queryWrapper);
         if (numberClassification != null) {
            this.redisTemplate.delete("wms-hash-classification-all");
            throw new IllegalArgumentException(
               numberClassification.getName().equals(classification.getName())
                  ? "科目【" + classificationDTOParam.getName() + "】名称重复"
                  : "科目【" + classificationDTOParam.getName() + "】代码重复"
            );
         }

         classification.setSerialNumber(number);
         if (!classification.getParentId().equals(0L)) {
            Classification classificationParent = this.classificationMapper.selectById(classification.getParentId());
            classification.setBoolStatus(classificationParent.getBoolStatus());
         }

         classification.setBoolLastEnum(Boolean.TRUE);
         this.classificationMapper.insert(classification);
         classification.setPath(path + classification.getId());
         classification.setUpdateTime(LocalDateTime.now());
         classification.setUserUpdateTime(LocalDateTime.now());
         this.classificationMapper.updateById(classification);
         this.updateClassRedis(null, classification);
         if (BasicClassEnum.SECTION_STEEL.getType().equals(classification.getBasicClass())) {
            SectionSteelConfig config = SectionSteelConfig.builder().build();
            config.setClassificationId(classification.getId());
            this.proximateMatterConfigMapper.insert(config);
         }

         if (BasicClassEnum.checkMaterialByType(classification.getBasicClass())) {
            Measure build = Measure.builder().classificationId(classification.getId()).basicClass(classification.getBasicClass()).build();
            if ((classification.getBasicClass() & 7) > 0) {
               build.setOutboundUnitType(1);
            }

            if (classification.getParentId() == 0L) {
               Integer basicClass = classification.getBasicClass();
               if (basicClass.equals(BasicClassEnum.STEEL_PLATE.getType())) {
                  build.setMeasureUnit("张");
                  build.setMeasurePrecision(0);
                  build.setAccountingPrecision(5);
                  build.setAccountingUnit("吨");
               } else if (basicClass.equals(BasicClassEnum.SECTION_STEEL.getType())) {
                  build.setMeasureUnit("根");
                  build.setMeasurePrecision(0);
                  build.setAccountingPrecision(0);
                  build.setAccountingPrecision(5);
                  build.setAccountingUnit("吨");
               } else if (basicClass.equals(BasicClassEnum.COLOR_ROLL.getType())) {
                  build.setMeasureUnit("米");
                  build.setMeasurePrecision(3);
                  build.setAccountingPrecision(5);
                  build.setAccountingUnit("吨");
               }
            } else {
               Measure parentMeasure = this.getParentMeasure(classification);
               if (ObjectUtil.isNotEmpty(parentMeasure)) {
                  build.setAccountingUnit(parentMeasure.getAccountingUnit());
                  build.setAccountingPrecision(parentMeasure.getAccountingPrecision());
                  build.setMeasureUnit(parentMeasure.getMeasureUnit());
                  build.setMeasurePrecision(parentMeasure.getMeasurePrecision());
                  build.setOutboundUnitType(parentMeasure.getOutboundUnitType());
                  build.setUseParentId(parentMeasure.getId());
                  build.setUpdateTime(LocalDateTime.now());
               }
            }

            this.measureMapper.insert(build);
         }

         this.stringRedisUtil.hDelete("wms-subject", classification.getId().toString());
      }

      this.steelDensityService.updateSteelDensityRedis();
      this.measureService.updateRedisTree();
      return true;
   }

   private Measure getParentMeasure(Classification classification) {
      Long parentId = classification.getParentId();
      Classification classificationParent = this.classificationMapper.selectById(parentId);
      if (ObjectUtil.isEmpty(classificationParent)) {
         return null;
      }

      Measure measure = this.measureMapper.selectOne((Wrapper<Measure>)new LambdaQueryWrapper<Measure>().eq(Measure::getClassificationId, classificationParent.getId()));
      return !ObjectUtil.isNotEmpty(measure.getAccountingUnit())
            && !ObjectUtil.isNotEmpty(measure.getAccountingPrecision())
            && !ObjectUtil.isNotEmpty(measure.getMeasureUnit())
            && !ObjectUtil.isNotEmpty(measure.getMeasurePrecision())
         ? this.getParentMeasure(classificationParent)
         : measure;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean delete(List<Long> ids) {
      for (Long id : ids) {
         Classification classification = this.classificationMapper.selectById(id);
         Preconditions.checkArgument(classification != null, "科目不存在");
         Preconditions.checkArgument(!classification.getLevel().equals(1), "一级科目禁止新增、修改、删除等操作！！！");
         List<Classification> children = this.classificationMapper
            .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, id));
         Preconditions.checkArgument(CollectionUtils.isEmpty(children), classification.getName() + "删除失败,科目存在子节点");
         Boolean b1 = this.applyPurchaseService.checkClassify(classification.getId());
         Preconditions.checkArgument(!b1, "删除失败,科目[" + classification.getName() + "]已创建申购单.");
         Boolean b = this.purchaseOrderService.checkClassify(classification.getId());
         Preconditions.checkArgument(!b, "删除失败,科目[" + classification.getName() + "]已添加采购订单.");
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(this.inboundDetailMapper.selectList((Wrapper<InboundDetail>)Wrappers.<InboundDetail>lambdaQuery().eq(InboundDetail::getClassifyId, id))),
            "删除失败,科目[" + classification.getName() + "]已生成入库记录."
         );
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(
               this.materialInventoryMapper.selectList((Wrapper<MaterialInventory>)Wrappers.<MaterialInventory>lambdaQuery().eq(MaterialInventory::getClassifyId, id))
            ),
            "删除失败,科目[" + classification.getName() + "]已在物料仓中使用."
         );
         Preconditions.checkArgument(
            CollectionUtils.isEmpty(
               this.mesAuxiliaryRelevancyWmsClassService
                  .list((Wrapper<MesAuxiliaryRelevancyWmsClass>)Wrappers.<MesAuxiliaryRelevancyWmsClass>lambdaQuery().eq(MesAuxiliaryRelevancyWmsClass::getClassifyId, id))
            ),
            "删除失败,科目[" + classification.getName() + "]已绑定配套件对照表信息."
         );
         if (classification.getBasicClass() == 2) {
            Preconditions.checkArgument(
               CollectionUtil.isEmpty(
                  this.sectionSteelSpecMapper
                     .selectList((Wrapper<SectionSteelSpec>)Wrappers.<SectionSteelSpec>lambdaQuery().eq(SectionSteelSpec::getClassificationId, classification.getId()))
               ),
               "删除失败,型材[" + classification.getName() + "]存在规格配置"
            );
            this.sectionSteelConfigMapper
               .delete((Wrapper<SectionSteelConfig>)Wrappers.<SectionSteelConfig>lambdaQuery().eq(SectionSteelConfig::getClassificationId, classification.getId()));
         }

         this.measureMapper.delete((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, classification.getId()));
         if (classification.getParentId() != 0L) {
            Integer simplePidCount = this.classificationMapper
               .selectCount((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().eq(Classification::getParentId, classification.getParentId()));
            if (simplePidCount == 1) {
               Classification parent = this.classificationMapper.selectById(classification.getParentId());
               parent.setBoolLastEnum(true);
               this.classificationMapper.updateById(parent);
            }
         }

         this.classificationMapper.deleteById(id);
         this.redisTemplate.opsForHash().delete("wms-hash-classification-all", classification.getId().toString());
      }

      this.measureService.updateRedisTree();
      return true;
   }

   @Override
   public List<SubjectSpecMeasureDTO> detailTree() {
      List<Classification> classifications = this.classificationMapper
         .selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getParentId));
      if (CollectionUtils.isEmpty(classifications)) {
         return new ArrayList<>();
      }

      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      List<SubjectSpecMeasureDTO> dtos = this.detailBuild(0L, subjectMap);
      return CollectionUtil.isNotEmpty(dtos) ? dtos : new ArrayList<>();
   }

   private List<SubjectSpecMeasureDTO> detailBuild(Long pid, Map<Long, List<Classification>> subjectMap) {
      List<Classification> classifications = subjectMap.get(pid);
      return CollectionUtils.isEmpty(classifications)
         ? new ArrayList<>()
         : classifications.stream()
            .map(
               subject -> {
                  SubjectDetailDTO subjectDetail = JSON.parseObject(
                     (String)this.stringRedisUtil.hGet("wms-subject", subject.getId().toString()), SubjectDetailDTO.class
                  );
                  if (subjectDetail == null) {
                     subjectDetail = this.setRedisKeyValue(subject);
                  }

                  SubjectSpecMeasureDTO tree = SubjectSpecMeasureDTO.builder().build();
                  BeanUtils.copyProperties(subjectDetail, tree);
                  tree.setChildren(this.detailBuild(tree.getSubjectId(), subjectMap));
                  return tree;
               }
            )
            .collect(Collectors.toList());
   }

   @Override
   public String getFullPath(Long subjectId, String symbol) {
      Classification classification = this.classificationMapper.selectById(subjectId);
      List<Integer> ids = Arrays.stream(classification.getPath().split(",")).map(Integer::parseInt).collect(Collectors.toList());
      return StrUtil.join(symbol, this.classificationMapper.selectBatchIds(ids).stream().map(Classification::getName).collect(Collectors.toList()));
   }

   @Override
   public String getFullPath(String idPath, String symbol) {
      List<Integer> ids = Arrays.stream(idPath.split(",")).map(Integer::parseInt).collect(Collectors.toList());
      List<String> list = new ArrayList<>();

      for (Integer id : ids) {
         list.add(this.classificationMapper.selectById(id).getName());
      }

      return StrUtil.join(symbol, list);
   }

   @Override
   public List<Classification> getLastSubject(Long subjectId) {
      Classification classification = this.classificationMapper.selectById(subjectId);
      return this.classificationMapper
         .selectList(
            (Wrapper<Classification>)((Wrappers.<Classification>lambdaQuery()
                     .eq(Classification::getBasicClass, classification.getBasicClass()))
                  .eq(Classification::getBoolLastEnum, 1))
               .likeRight(Classification::getPath, classification.getPath() + ",")
         );
   }

   @Override
   public List<Classification> getLastSubjectNew(Long subjectId) {
      Classification classification = this.classificationMapper.selectById(subjectId);
      if (classification.getBoolLastEnum()) {
         List<Classification> classifications = new ArrayList<>();
         classifications.add(classification);
         return classifications;
      } else {
         return this.classificationMapper
            .selectList(
               (Wrapper<Classification>)((Wrappers.<Classification>lambdaQuery()
                        .eq(Classification::getBasicClass, classification.getBasicClass()))
                     .eq(Classification::getBoolLastEnum, 1))
                  .likeRight(Classification::getPath, classification.getPath() + ",")
            );
      }
   }

   @Override
   public List<Long> getClassifyIdsByName(List<String> classifyName) {
      List<Long> classifyIds = new ArrayList<>();
      if (CollUtil.isEmpty(classifyName)) {
         return classifyIds;
      }

      for (String notClassifyName : classifyName) {
         for (Classification classification : this.baseMapper
            .selectList(
               (Wrapper<Classification>)(new LambdaQueryWrapper<Classification>().eq(Classification::getLevel, 1))
                  .like(Classification::getName, notClassifyName)
            )) {
            List<Classification> lastSubject = this.getLastSubjectNew(classification.getId());
            List<Long> notClassifyIdsNew = lastSubject.stream().map(Classification::getId).collect(Collectors.toList());
            classifyIds.addAll(notClassifyIdsNew);
         }
      }

      return classifyIds;
   }

   @Override
   public List<SubjectSpecMeasureDTO> getByBasicClass(Long basicClass) {
      List<Classification> classifications = this.classificationMapper
         .selectList(
            (Wrapper<Classification>)(Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getParentId))
               .eq(Classification::getBasicClass, basicClass)
         );
      if (CollectionUtils.isEmpty(classifications)) {
         return new ArrayList<>();
      }

      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      List<SubjectSpecMeasureDTO> dtos = this.detailBuild(0L, subjectMap);
      return CollectionUtil.isNotEmpty(dtos) ? dtos : new ArrayList<>();
   }

   @Override
   public Map<Integer, List<Classification>> getMaterialClassification(Long basicClass) {
      List<MaterialInventory> materialInventories = this.materialInventoryMapper
         .selectList(
            (Wrapper<MaterialInventory>)(new LambdaQueryWrapper<MaterialInventory>().eq(basicClass != null, MaterialInventory::getBasicClass, basicClass))
               .eq(MaterialInventory::getBoolPartyA, false)
         );
      Map<Integer, List<Classification>> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(materialInventories)) {
         List<Long> collect = materialInventories.stream().map(MaterialInventory::getClassifyId).collect(Collectors.toList());
         List<Classification> classifications = this.classificationMapper
            .selectList(
               (Wrappers.<Classification>lambdaQuery().eq(Classification::getBoolLastEnum, true))
                  .in(CollectionUtil.isNotEmpty(collect), Classification::getId, collect)
            );
         return classifications.stream().collect(Collectors.groupingBy(e -> e.getBasicClass()));
      } else {
         return classificationMap;
      }
   }

   @Override
   public Map<Integer, List<Classification>> getPurchaseClassification(Long basicClass) {
      List<InboundDetail> list = this.inboundDetailMapper
         .selectList(
            Wrappers.lambdaQuery(InboundDetail.class).isNotNull(InboundDetail::getAmount).eq(basicClass != null, InboundDetail::getBasicClass, basicClass)
         );
      Map<Integer, List<Classification>> classificationMap = new HashMap<>();
      if (CollectionUtil.isNotEmpty(list)) {
         List<Long> collect = list.stream().map(InboundDetail::getClassifyId).distinct().collect(Collectors.toList());
         List<Classification> classifications = this.classificationMapper
            .selectList(
               (Wrappers.<Classification>lambdaQuery().eq(Classification::getBoolLastEnum, true))
                  .in(CollectionUtil.isNotEmpty(collect), Classification::getId, collect)
            );
         return classifications.stream().collect(Collectors.groupingBy(e -> e.getBasicClass()));
      } else {
         return classificationMap;
      }
   }

   @Override
   public List<Classification> getMaterialClassificationLevel(Long basicClass) {
      return this.classificationMapper.selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().eq(Classification::getLevel, 1));
   }

   @Override
   public ClassifySpecDTO getClassifyById(Long id) {
      Classification classification = this.classificationMapper.selectById(id);
      if (classification == null) {
         return null;
      }

      ClassifySpecDTO classifySpecDTO = ClassifySpecDTO.builder()
         .id(classification.getId())
         .name(classification.getName())
         .basicClass(classification.getBasicClass())
         .serialNumber(classification.getSerialNumber())
         .build();
      Measure measure = this.getMeasure(classification.getId());
      BeanUtils.copyProperties(measure, classifySpecDTO);
      classifySpecDTO.setFullName(this.getFullPath(classification.getPath(), this.pathSymbol));
      classifySpecDTO.setFullPathId(CommonUtil.spilt(classification.getPath(), ","));
      List<SpecConfigDTO> list = new ArrayList<>();
      if (classification.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
         SectionSteelConfig sectionSteelConfig = this.sectionSteelConfigMapper
            .selectOne((Wrapper<SectionSteelConfig>)Wrappers.<SectionSteelConfig>lambdaQuery().eq(SectionSteelConfig::getClassificationId, classification.getId()));
         List<SpecConfigDTO> nationalStandard = new ArrayList<>();
         if (sectionSteelConfig.getStandardId() != null) {
            List<Standard> standards = this.standardMapper.selectList(null);
            Map<Long, List<SectionSteelSpec>> sectionSteelSpecMap = this.sectionSteelSpecMapper
               .selectList((Wrapper<SectionSteelSpec>)new LambdaQueryWrapper<SectionSteelSpec>().eq(SectionSteelSpec::getClassificationId, classification.getId()))
               .stream()
               .collect(Collectors.groupingBy(SectionSteelSpec::getClassificationId));
            Preconditions.checkArgument(CollectionUtil.isNotEmpty(sectionSteelSpecMap), "请先配置型材规格！！！");
            Map<String, List<SectionSteelSpecStandardDetail>> collect1 = this.standardDetailMapper
               .selectList(
                  (Wrapper<SectionSteelSpecStandardDetail>)new LambdaQueryWrapper<SectionSteelSpecStandardDetail>()
                     .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelConfig.getId())
               )
               .stream()
               .collect(Collectors.groupingBy(e -> e.getStandardId() + "-" + e.getSpecId()));

            for (Standard standard : standards) {
               SpecConfigDTO build = SpecConfigDTO.builder().id(sectionSteelConfig.getId()).name(standard.getName()).build();
               build.setStandardId(standard.getId());
               build.setBoolDefault(sectionSteelConfig.getStandardId().equals(standard.getId()));
               List<SpecConfigDetailDTO> collect = new ArrayList<>();

               for (SectionSteelSpec sectionSteelSpec : sectionSteelSpecMap.get(classification.getId())) {
                  List<SectionSteelSpecStandardDetail> sectionSteelSpecStandardDetails = collect1.get(standard.getId() + "-" + sectionSteelSpec.getId());
                  if (CollectionUtil.isNotEmpty(sectionSteelSpecStandardDetails)) {
                     SectionSteelSpecStandardDetail sectionSteelSpecStandardDetail = sectionSteelSpecStandardDetails.get(0);
                     if (sectionSteelSpecStandardDetail != null
                        && sectionSteelSpecStandardDetail.getUnitNet() != null
                        && sectionSteelSpecStandardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0) {
                        SpecConfigDetailDTO specConfigDetailDTO = SpecConfigDetailDTO.builder()
                           .id(sectionSteelSpec.getId())
                           .code(standard.getCode() + "-" + sectionSteelSpecStandardDetail.getCode())
                           .unitWeight(sectionSteelSpecStandardDetail.getUnitNet())
                           .name(sectionSteelSpec.getSpecification())
                           .build();
                        if (sectionSteelSpecStandardDetail.getCode() < 10) {
                           specConfigDetailDTO.setCode(standard.getCode() + "-0" + sectionSteelSpecStandardDetail.getCode());
                        } else {
                           specConfigDetailDTO.setCode(standard.getCode() + "-" + sectionSteelSpecStandardDetail.getCode());
                        }

                        specConfigDetailDTO.setStatus(sectionSteelSpec.getStatus());
                        collect.add(specConfigDetailDTO);
                     }
                  }
               }

               build.setList(collect);
               nationalStandard.add(build);
            }
         }

         classifySpecDTO.setNationalStandard(nationalStandard);
      }

      for (SpecificationDTO dto : this.specificationMapper.selectBySubjectId(id)) {
         SpecConfigDTO specConfigDTO = SpecConfigDTO.builder().id(dto.getId()).name(dto.getName()).build();
         specConfigDTO.setList(
            dto.getList()
               .stream()
               .map(detail -> SpecConfigDetailDTO.builder().id(detail.getId()).code(detail.getCode()).name(detail.getValue()).build())
               .collect(Collectors.toList())
         );
         list.add(specConfigDTO);
      }

      classifySpecDTO.setId(classification.getId());
      classifySpecDTO.setSpecConfig(list);
      return classifySpecDTO;
   }

   @Override
   public List<ClassifySpecDTO> getClassifyListByIds(List<Long> ids) {
      if (CollectionUtil.isEmpty(ids)) {
         return new ArrayList<>();
      }

      List<Classification> classifications = this.classificationMapper
         .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, ids));
      Map<Long, List<SectionSteelSpec>> sectionSteelSpecMap = this.sectionSteelSpecMapper
         .selectList(new LambdaQueryWrapper<>())
         .stream()
         .collect(Collectors.groupingBy(SectionSteelSpec::getClassificationId));
      Map<Long, SectionSteelConfig> collect3 = this.sectionSteelConfigMapper
         .selectList(Wrappers.<SectionSteelConfig>lambdaQuery())
         .stream()
         .collect(Collectors.toMap(SectionSteelConfig::getClassificationId, Function.identity()));
      List<Standard> standards = this.standardMapper.selectList(null);
      return classifications.stream()
         .map(
            classification -> {
               ClassifySpecDTO classifySpecDTO = ClassifySpecDTO.builder()
                  .id(classification.getId())
                  .name(classification.getName())
                  .basicClass(classification.getBasicClass())
                  .serialNumber(classification.getSerialNumber())
                  .build();
               Measure measure = this.getMeasure(classification.getId());
               BeanUtils.copyProperties(measure, classifySpecDTO);
               classifySpecDTO.setFullName(this.getFullPath(classification.getPath(), this.pathSymbol));
               classifySpecDTO.setFullPathId(CommonUtil.spilt(classification.getPath(), ","));
               List<SpecConfigDTO> list = new ArrayList<>();
               if (classification.getBasicClass().equals(BasicClassEnum.SECTION_STEEL.getType())) {
                  SectionSteelConfig sectionSteelConfig = collect3.get(classification.getId());
                  List<SpecConfigDTO> nationalStandard = new ArrayList<>();
                  if (sectionSteelConfig.getStandardId() != null) {
                     Preconditions.checkArgument(CollectionUtil.isNotEmpty(sectionSteelSpecMap), "请先配置型材规格！！！");
                     Map<String, List<SectionSteelSpecStandardDetail>> collect1 = this.standardDetailMapper
                        .selectList(
                           (Wrapper<SectionSteelSpecStandardDetail>)new LambdaQueryWrapper<SectionSteelSpecStandardDetail>()
                              .eq(SectionSteelSpecStandardDetail::getSectionSteelId, sectionSteelConfig.getId())
                        )
                        .stream()
                        .collect(Collectors.groupingBy(e -> e.getStandardId() + "-" + e.getSpecId()));

                     for (Standard standard : standards) {
                        SpecConfigDTO build = SpecConfigDTO.builder().id(sectionSteelConfig.getId()).name(standard.getName()).build();
                        build.setStandardId(standard.getId());
                        build.setBoolDefault(sectionSteelConfig.getStandardId().equals(standard.getId()));
                        List<SpecConfigDetailDTO> collect = new ArrayList<>();
                        List<SectionSteelSpec> sectionSteelSpecs = sectionSteelSpecMap.get(classification.getId());
                        if (CollectionUtil.isNotEmpty(sectionSteelSpecs)) {
                           for (SectionSteelSpec sectionSteelSpec : sectionSteelSpecs) {
                              List<SectionSteelSpecStandardDetail> sectionSteelSpecStandardDetails = collect1.get(
                                 standard.getId() + "-" + sectionSteelSpec.getId()
                              );
                              if (CollectionUtil.isNotEmpty(sectionSteelSpecStandardDetails)) {
                                 SectionSteelSpecStandardDetail sectionSteelSpecStandardDetail = sectionSteelSpecStandardDetails.get(0);
                                 if (sectionSteelSpecStandardDetail != null
                                    && sectionSteelSpecStandardDetail.getUnitNet() != null
                                    && sectionSteelSpecStandardDetail.getUnitNet().compareTo(BigDecimal.ZERO) > 0) {
                                    SpecConfigDetailDTO specConfigDetailDTO = SpecConfigDetailDTO.builder()
                                       .id(sectionSteelSpec.getId())
                                       .code(standard.getCode() + "-" + sectionSteelSpecStandardDetail.getCode())
                                       .unitWeight(sectionSteelSpecStandardDetail.getUnitNet())
                                       .name(sectionSteelSpec.getSpecification())
                                       .build();
                                    if (sectionSteelSpecStandardDetail.getCode() < 10) {
                                       specConfigDetailDTO.setCode(standard.getCode() + "-0" + sectionSteelSpecStandardDetail.getCode());
                                    } else {
                                       specConfigDetailDTO.setCode(standard.getCode() + "-" + sectionSteelSpecStandardDetail.getCode());
                                    }

                                    collect.add(specConfigDetailDTO);
                                 }
                              }
                           }
                        }

                        build.setList(collect);
                        nationalStandard.add(build);
                     }
                  }

                  classifySpecDTO.setNationalStandard(nationalStandard);
               }

               for (SpecificationDTO dto : this.specificationMapper.selectBySubjectId(classification.getId())) {
                  SpecConfigDTO specConfigDTO = SpecConfigDTO.builder().id(dto.getId()).name(dto.getName()).build();
                  specConfigDTO.setList(
                     dto.getList()
                        .stream()
                        .map(detail -> SpecConfigDetailDTO.builder().id(detail.getId()).code(detail.getCode()).name(detail.getValue()).build())
                        .collect(Collectors.toList())
                  );
                  list.add(specConfigDTO);
               }

               classifySpecDTO.setId(classification.getId());
               classifySpecDTO.setSpecConfig(list);
               return classifySpecDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public void excel(MultipartFile file) {
      ImportParams params = new ImportParams();
      params.setHeadRows(1);

      try {
         List<ClassExcel> objects = ExcelImportUtil.importExcel(file.getInputStream(), ClassExcel.class, params);
         List<ClassificationDTOParam> collect = objects.stream()
            .map(
               abc -> ClassificationDTOParam.builder()
                  .parentId(abc.getParentId())
                  .basicClass(abc.getBasicClass())
                  .code(abc.getCode())
                  .name(abc.getName())
                  .build()
            )
            .collect(Collectors.toList());
         this.batchAddSubject(collect);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private Measure getMeasure(Long pid) {
      Measure m = this.measureService.getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, pid));
      Preconditions.checkArgument(m != null, "科目未配置核算单位，请配置后操作。");
      if (m.getAccountingUnit() != null) {
         return m;
      }

      Classification classification = this.classificationMapper.selectById(pid);
      return this.getMeasure(classification.getParentId());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateClassify(List<ClassificationDTOParam> dtoParams) {
      for (ClassificationDTOParam classificationDTOParam : dtoParams) {
         Classification classification = this.classificationMapper.selectById(classificationDTOParam.getId());
         if (classification.getClassifyUpdateStatus().equals(ClassifyUpdateStatusEnum.ALL_CANNOT_UPDATE.getType())) {
            Preconditions.checkArgument(false, classification.getName() + "科目已被使用禁止修改名称和代码！！！");
         }

         if (classification.getClassifyUpdateStatus().equals(ClassifyUpdateStatusEnum.ONLY_NAME_UPDATE.getType())) {
            Preconditions.checkArgument(
               classificationDTOParam.getCode().equals(classification.getCode()), classification.getName() + "科目未被使用，但下级科目已存在被使用的数据，只可修改名称！！！"
            );
         }

         String parentCode = "";
         Integer level = 1;
         if (classificationDTOParam.getParentId() != null && !classificationDTOParam.getParentId().equals(0L)) {
            Classification parent = this.classificationMapper.selectById(classificationDTOParam.getParentId());
            Preconditions.checkArgument(parent != null, "父级科目不存在");
            parentCode = parent.getSerialNumber();
            level = parent.getLevel() + level;
         }

         Preconditions.checkArgument(StringUtils.isNotBlank(classificationDTOParam.getCode()), "代码不能为空");
         String subjectCode = classificationDTOParam.getCode().trim().toUpperCase();
         classification.setCode(subjectCode);
         String number = parentCode + classification.getCode();
         Classification numberClassification = this.classificationMapper
            .selectOne(
               (Wrapper<Classification>)(((new LambdaQueryWrapper<Classification>()
                           .eq(Classification::getBasicClass, classification.getBasicClass()))
                        .and(
                           e -> {
                              LambdaQueryWrapper var10000 = ((e.eq(
                                       Classification::getSerialNumber, number
                                    ))
                                    .or())
                                 .eq(Classification::getName, classificationDTOParam.getName());
                           }
                        ))
                     .eq(Classification::getLevel, level))
                  .ne(Classification::getId, classification.getId())
            );
         if (ObjectUtil.isNotEmpty(numberClassification)) {
            this.redisTemplate.delete("wms-hash-classification-all");
            throw new IllegalArgumentException(
               numberClassification.getName().equals(classificationDTOParam.getName())
                  ? "科目【" + classificationDTOParam.getName() + "】名称重复"
                  : "科目【" + classificationDTOParam.getName() + "】代码重复"
            );
         }

         classification.setName(classificationDTOParam.getName());
         classification.setSerialNumber(number);
         classification.setUpdateTime(LocalDateTime.now());
         classification.setUserUpdateTime(LocalDateTime.now());
         this.classificationMapper.updateById(classification);
         this.updateClassRedis(null, classification);
         if (!classification.getBoolLastEnum() && !classification.getCode().equals(classificationDTOParam.getCode())) {
            this.updateSonSerialNumber(classification);
         }

         this.stringRedisUtil.hDelete("wms-subject", classification.getId().toString());
      }

      return true;
   }

   @Override
   public Boolean updateClassifyStatus(IdsStatusDTO dto) {
      List<Long> ids = new ArrayList<>();
      ids.addAll(dto.getIds());

      for (Long id : dto.getIds()) {
         for (Classification classification : this.classificationMapper
            .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, id))) {
            ids.add(classification.getId());
            if (!classification.getBoolLastEnum()) {
               this.getSonId(ids, classification.getId());
            }
         }
      }

      for (Long id : dto.getIds()) {
         if (dto.getStatus()) {
            Classification classification = this.classificationMapper.selectById(id);
            if (ObjectUtil.isNotEmpty(classification.getParentId())) {
               this.getParentId(ids, classification.getParentId());
            }
         }
      }

      this.classificationMapper
         .update(
            null,
            (Wrapper<Classification>)(((new LambdaUpdateWrapper<Classification>()
                        .set(Classification::getBoolStatus, dto.getStatus()))
                     .set(BaseEntity::getUpdateTime, LocalDateTime.now()))
                  .set(Classification::getUserUpdateTime, LocalDateTime.now()))
               .in(Classification::getId, ids)
         );
      List<Classification> classifications = this.classificationMapper.selectBatchIds(ids);
      this.updateClassRedis(classifications, null);
      this.stringRedisUtil.delete("wms-subject");
      return true;
   }

   @Override
   public Boolean updateClassifyUsed(IdsStatusDTO dto) {
      if (!ObjectUtil.isEmpty(dto) && (!CollectionUtils.isEmpty(dto.getIds()) || !ObjectUtil.isEmpty(dto.getIdsStr()))) {
         TreeSet<Long> longs = new TreeSet<>();
         if (CollectionUtils.isNotEmpty(dto.getIds())) {
            longs.addAll(dto.getIds());
         }

         if (ObjectUtil.isNotEmpty(dto.getIdsStr())) {
            longs.addAll(Arrays.stream(dto.getIdsStr().split(",")).map(idx -> Long.parseLong(idx.trim())).collect(Collectors.toList()));
         }

         List<Long> ids = new ArrayList<>();

         for (Long id : longs) {
            Classification classification = this.classificationMapper.selectById(id);
            if (ObjectUtil.isNotEmpty(classification.getParentId())
               && classification.getClassifyUpdateStatus().equals(ClassifyUpdateStatusEnum.ALL_UPDATE.getType())) {
               this.getParentId(ids, classification.getParentId());
            }
         }

         this.classificationMapper
            .update(
               null,
               (Wrapper<Classification>)(new LambdaUpdateWrapper<Classification>()
                     .set(Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ALL_CANNOT_UPDATE.getType()))
                  .in(Classification::getId, longs)
            );
         if (CollectionUtil.isNotEmpty(ids)) {
            this.classificationMapper
               .update(
                  null,
                  (Wrapper<Classification>)(((new LambdaUpdateWrapper<Classification>()
                              .set(Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ONLY_NAME_UPDATE.getType()))
                           .ne(Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ALL_CANNOT_UPDATE.getType()))
                        .ne(Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ONLY_NAME_UPDATE.getType()))
                     .in(Classification::getId, ids)
               );
         }

         this.stringRedisUtil.delete("wms-subject");
         return true;
      } else {
         return true;
      }
   }

   public void getParentId(List<Long> ids, Long id) {
      Classification classification = this.classificationMapper.selectById(id);
      if (ObjectUtil.isNotEmpty(classification)) {
         ids.add(classification.getId());
         if (ObjectUtil.isNotEmpty(classification.getParentId())) {
            this.getParentId(ids, classification.getParentId());
         }
      }
   }

   public void getSonId(List<Long> ids, Long parentId) {
      for (Classification classification : this.classificationMapper
         .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, parentId))) {
         ids.add(classification.getId());
         if (!classification.getBoolLastEnum()) {
            this.getSonId(ids, parentId);
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteDataUpdateClass(IdsStatusDTO dto) {
      if (CollectionUtils.isEmpty(dto.getIds()) && ObjectUtil.isEmpty(dto.getIdsStr())) {
         return true;
      }

      TreeSet<Long> longs = new TreeSet<>();
      if (CollectionUtils.isNotEmpty(dto.getIds())) {
         longs.addAll(dto.getIds());
      }

      if (ObjectUtil.isNotEmpty(dto.getIdsStr())) {
         longs.addAll(Arrays.stream(dto.getIdsStr().split(",")).map(idx -> Long.parseLong(idx.trim())).collect(Collectors.toList()));
      }

      for (Long id : longs) {
         Integer inboundCount = this.inboundDetailMapper.selectCount((Wrapper<InboundDetail>)new LambdaQueryWrapper<InboundDetail>().eq(InboundDetail::getClassifyId, id));
         if (inboundCount > 0) {
            break;
         }

         int applyCount = this.applyPurchaseDetailService
            .count((Wrapper<ApplyPurchaseDetail>)new LambdaQueryWrapper<ApplyPurchaseDetail>().eq(ApplyPurchaseDetail::getClassifyId, id));
         if (applyCount > 0) {
            break;
         }

         int applyCount1 = this.applyPurchaseService
            .count(
               (Wrapper<ApplyPurchase>)(new LambdaQueryWrapper<ApplyPurchase>()
                     .ne(ObjectUtil.isNotEmpty(dto.getDataType()) && dto.getDataType().equals(1), ApplyPurchase::getId, dto.getDataId()))
                  .last("and find_in_set(" + id + ",classify_ids)")
            );
         if (applyCount1 > 0) {
            break;
         }

         int purchaseCount = this.purchaseOrderDetailService
            .count((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getClassifyId, id));
         if (purchaseCount > 0) {
            break;
         }

         Classification classification = this.classificationMapper.selectById(id);
         List<Classification> classifications = this.classificationMapper
            .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, id));
         Boolean b = this.judgeSubordinateBoolUsed(classifications);
         classification.setClassifyUpdateStatus(b ? ClassifyUpdateStatusEnum.ONLY_NAME_UPDATE.getType() : ClassifyUpdateStatusEnum.ALL_UPDATE.getType());
         this.classificationMapper.updateById(classification);
         if (b) {
            return true;
         }

         this.judgeSuperiorsBoolUsed(classification);
      }

      return true;
   }

   @Override
   public Classification getClassificationById(Long id) {
      Classification classification = (Classification)this.redisTemplate.opsForHash().get("wms-hash-classification-all", id.toString());
      if (ObjectUtil.isEmpty(classification)) {
         classification = this.baseMapper.selectById(id);
         if (ObjectUtil.isNotEmpty(classification)) {
            this.updateClassRedis(null, classification);
         }
      }

      return classification;
   }

   @Override
   public Map<Long, Classification> getClassificationByIds(List<Long> ids) {
      HashMap<Long, Classification> longClassificationHashMap = new HashMap<>();

      for (Long id : ids) {
         Classification classificationById = this.getClassificationById(id);
         if (ObjectUtil.isEmpty(classificationById)) {
            break;
         }

         longClassificationHashMap.put(classificationById.getId(), classificationById);
      }

      return longClassificationHashMap;
   }

   @Override
   public Map<Long, Classification> checkClassification(List<ClassificationCheckDTO> classificationCheckDTOS, LocalDateTime clickTime) {
      HashMap<Long, Classification> longClassificationHashMap = new HashMap<>();
      StringBuilder nothingness = new StringBuilder();
      StringBuilder staleDated = new StringBuilder();
      TreeSet<Long> longs = new TreeSet<>();

      for (ClassificationCheckDTO checkDTO : classificationCheckDTOS) {
         if (!longs.contains(checkDTO.getClassifyId())) {
            Classification classificationById = this.getClassificationById(checkDTO.getClassifyId());
            if (ObjectUtil.isEmpty(classificationById)) {
               longs.add(checkDTO.getClassifyId());
               nothingness.append("【" + checkDTO.getClassifyName() + "】");
            } else if (classificationById.getName().equals(checkDTO.getClassifyName())
               && classificationById.getSerialNumber().equals(checkDTO.getClassifySerialNumber())) {
               longClassificationHashMap.put(classificationById.getId(), classificationById);
            } else {
               longs.add(checkDTO.getClassifyId());
               staleDated.append("【" + checkDTO.getClassifyName() + "】");
            }
         }
      }

      if (CollectionUtil.isNotEmpty(longs)) {
         StringBuilder throwMsg = new StringBuilder();
         if (nothingness.length() > 0) {
            throwMsg.append(nothingness).append("不存在！！！");
         }

         if (staleDated.length() > 0) {
            throwMsg.append(staleDated).append("已过期！！！");
         }

         if (throwMsg.length() > 0) {
            throw new ParameterExpireException(throwMsg.toString(), longs);
         }
      }

      return longClassificationHashMap;
   }

   @Override
   public void updateClassifyUpdateStatus() {
      try {
         this.baseMapper.updateClassifyUpdateStatusApply();
         this.baseMapper.updateClassifyUpdateStatusPurchase();
         this.baseMapper.updateClassifyUpdateStatusInbound();
         TimeUnit.SECONDS.sleep(2L);
         this.baseMapper.updateClassifyUpdateStatusClass();
         TimeUnit.SECONDS.sleep(2L);
         this.baseMapper.updateClassifyUpdateStatusClass();
      } catch (Throwable $ex) {
         throw ClassificationServiceImpl.<RuntimeException>rethrow($ex);
      }
   }

   @Override
   public List<Classification> getClassificationByBasicClassAndUnit(Integer basicClass, String unit) {
      return this.baseMapper.getClassificationByBasicClassAndUnit(basicClass, unit);
   }

   @Override
   public Map<Long, String> getClassFullPathNameMap(List<Long> ids, String symbol) {
      if (CollectionUtil.isEmpty(ids)) {
         return new HashMap<>();
      }

      List<Classification> classifications = this.classificationMapper.selectBatchIds(ids);
      List<Long> classifyIds = classifications.stream().flatMap(c -> Arrays.stream(c.getPath().split(",")).map(Long::valueOf)).collect(Collectors.toList());
      List<Classification> classificationsAll = this.classificationMapper.selectBatchIds(classifyIds);
      Map<Long, String> classFullPathNameMap = new HashMap<>();

      for (Classification classification : classifications) {
         List<Classification> classificationList = classificationsAll.stream()
            .filter(c -> Arrays.stream(classification.getPath().split(",")).map(Long::valueOf).collect(Collectors.toList()).contains(c.getId()))
            .sorted(Comparator.comparing(Classification::getId))
            .collect(Collectors.toList());
         StringBuilder stringBuilder = new StringBuilder();

         for (Classification classification1 : classificationList) {
            if (stringBuilder.length() > 0) {
               stringBuilder.append(symbol);
            }

            stringBuilder.append(classification1.getName());
         }

         classFullPathNameMap.put(classification.getId(), stringBuilder.toString());
      }

      return classFullPathNameMap;
   }

   @Override
   public Classification getSteelPlateByColorRollId(Long colorRollId) {
      List<ConvertConfig> convertConfig = this.basicConfigService.getConvertConfig();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(convertConfig), "请先设置条板转换配置");
      ConvertConfig convertConfig1 = convertConfig.stream()
         .filter(c -> c.getClassifyColorRollIds().stream().map(IdAndNameConvertDTO::getId).collect(Collectors.toList()).contains(colorRollId))
         .findAny()
         .orElse(null);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(convertConfig1), "请先设置条板转换配置");
      return this.classificationMapper.selectById(convertConfig1.getClassifySteelPlateId().getId());
   }

   private Boolean judgeSubordinateBoolUsed(List<Classification> classifications) {
      if (CollectionUtil.isEmpty(classifications)) {
         return false;
      }

      List<Classification> collect = classifications.stream()
         .filter(c -> !c.getClassifyUpdateStatus().equals(ClassifyUpdateStatusEnum.ALL_UPDATE.getType()))
         .collect(Collectors.toList());
      if (CollectionUtil.isNotEmpty(collect)) {
         return true;
      }

      for (Classification classification : classifications) {
         List<Classification> classificationList = this.classificationMapper
            .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, classification.getId()));
         Boolean b = this.judgeSubordinateBoolUsed(classificationList);
         if (b) {
            return b;
         }
      }

      return false;
   }

   private void judgeSuperiorsBoolUsed(Classification classification) {
      if (!ObjectUtil.isEmpty(classification.getParentId()) && !classification.getParentId().equals(0L)) {
         Classification classificationParent = this.classificationMapper.selectById(classification.getParentId());
         List<Classification> classifications = this.classificationMapper
            .selectList(
               (Wrapper<Classification>)(new LambdaQueryWrapper<Classification>()
                     .and(
                        c -> {
                           LambdaQueryWrapper var10000 = ((c.eq(
                                    Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ALL_CANNOT_UPDATE.getType()
                                 ))
                                 .or())
                              .eq(Classification::getClassifyUpdateStatus, ClassifyUpdateStatusEnum.ONLY_NAME_UPDATE.getType());
                        }
                     ))
                  .eq(Classification::getParentId, classificationParent.getId())
            );
         if (!CollectionUtil.isNotEmpty(classifications)
            && !classificationParent.getClassifyUpdateStatus().equals(ClassifyUpdateStatusEnum.ALL_CANNOT_UPDATE.getType())) {
            classificationParent.setClassifyUpdateStatus(ClassifyUpdateStatusEnum.ALL_UPDATE.getType());
            this.classificationMapper.updateById(classificationParent);
            this.judgeSuperiorsBoolUsed(classificationParent);
         }
      }
   }

   private void updateSonSerialNumber(Classification classificationParent) {
      for (Classification classification : this.classificationMapper
         .selectList((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().eq(Classification::getParentId, classificationParent.getId()))) {
         classification.setSerialNumber(classificationParent.getSerialNumber() + classification.getCode());
         classification.setUpdateTime(LocalDateTime.now());
         classification.setUserUpdateTime(LocalDateTime.now());
         this.classificationMapper.updateById(classification);
         this.updateClassRedis(null, classification);
         if (!classification.getBoolLastEnum()) {
            this.updateSonSerialNumber(classification);
         }
      }
   }

   @Override
   public void exportClassificationListV2(HttpServletResponse response) {
      new ArrayList();
      List<Classification> classifications = this.classificationMapper
         .selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
      Map<Long, List<Classification>> subjectMap = classifications.stream().collect(Collectors.groupingBy(Classification::getParentId));
      Map<Long, Boolean> classifyLinkMap = this.steelClassifyLinkService
         .list()
         .stream()
         .collect(Collectors.toMap(SysSteelClassifyLink::getClassifyId, e -> true));
      List<SubjectTreeDTO> build = this.build(0L, subjectMap, classifyLinkMap);
      String title = "科目配置清单";
      String sheetName = "科目配置清单";
      String fileName = "科目配置清单.xlsx";
      Integer orderNo = 1;
      List<SubjectTreeImportDTO> subjectTreeImportDTOS = new ArrayList<>();

      for (SubjectTreeDTO subjectTreeDTO : build) {
         SubjectTreeImportDTO copy = BeanUtil.copy(subjectTreeDTO, SubjectTreeImportDTO.class);
         Integer var14 = orderNo;
         orderNo = orderNo + 1;
         copy.setOrderNo(var14);
         copy.setNameA(subjectTreeDTO.getName());
         copy.setCodeA(subjectTreeDTO.getCode());
         if (subjectTreeDTO.getBasicClass() == 1) {
            copy.setBasicClass("钢板");
         }

         if (subjectTreeDTO.getBasicClass() == 2) {
            copy.setBasicClass("型材");
         }

         if (subjectTreeDTO.getBasicClass() == 4) {
            copy.setBasicClass("钢卷");
         }

         if (subjectTreeDTO.getBasicClass() == 8) {
            copy.setBasicClass("辅材");
         }

         if (subjectTreeDTO.getBasicClass() == 16) {
            copy.setBasicClass("气体");
         }

         if (subjectTreeDTO.getBasicClass() == 128) {
            copy.setBasicClass("办公用品");
         }

         if (subjectTreeDTO.getBasicClass() == 256) {
            copy.setBasicClass("其它钢材");
         }

         subjectTreeImportDTOS.add(copy);
         if (subjectTreeDTO.getChildren() != null) {
            for (SubjectTreeDTO child : subjectTreeDTO.getChildren()) {
               SubjectTreeImportDTO copy1 = BeanUtil.copy(child, SubjectTreeImportDTO.class);
               copy1.setNameB(child.getName());
               copy1.setCodeB(child.getCode());
               copy1.setSerialNumberA(child.getSerialNumber());
               copy1.setBasicClass(null);
               subjectTreeImportDTOS.add(copy1);
               if (child.getChildren() != null) {
                  for (SubjectTreeDTO childChild : child.getChildren()) {
                     SubjectTreeImportDTO copy2 = BeanUtil.copy(childChild, SubjectTreeImportDTO.class);
                     copy2.setNameC(childChild.getName());
                     copy2.setCodeC(childChild.getCode());
                     copy2.setSerialNumberB(childChild.getSerialNumber());
                     copy2.setBasicClass(null);
                     subjectTreeImportDTOS.add(copy2);
                  }
               }
            }
         }
      }

      PoiUtils.wmsExportExcel(subjectTreeImportDTOS, title, sheetName, SubjectTreeImportDTO.class, fileName, response);
   }

   private void updateClassRedis(List<Classification> classifications, Classification classificationUpdate) {
      if (!CollectionUtil.isEmpty(classifications) || !ObjectUtil.isEmpty(classificationUpdate)) {
         if (CollectionUtil.isEmpty(classifications)) {
            classifications = new ArrayList<>();
         }

         if (ObjectUtil.isNotEmpty(classificationUpdate)) {
            classifications.add(classificationUpdate);
         }

         List<Classification> values = this.redisTemplate.<String, Classification>opsForHash().values("wms-hash-classification-all");
         if (CollectionUtil.isNotEmpty(values)) {
            for (Classification classification : classifications) {
               this.redisTemplate.<String, Classification>opsForHash().put("wms-hash-classification-all", classification.getId().toString(), classification);
            }
         } else {
            classifications = this.classificationMapper.selectList((Wrapper<Classification>)Wrappers.<Classification>lambdaQuery().orderByAsc(Classification::getBasicClass));
            if (CollectionUtil.isNotEmpty(classifications)) {
               Map<String, Classification> collect = classifications.stream()
                  .collect(Collectors.toMap(classificationx -> String.valueOf(classificationx.getId()), Function.identity()));
               this.redisTemplate.<String, Classification>opsForHash().putAll("wms-hash-classification-all", collect);
            }
         }
      }
   }
   // Preserve the original Lombok-generated unchecked rethrow without changing public signatures.
   @SuppressWarnings("unchecked")
   private static <E extends Throwable> RuntimeException rethrow(Throwable error) throws E {
      throw (E)error;
   }
}
