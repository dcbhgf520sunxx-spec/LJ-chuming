package com.hzchum.scim.rest.runner.common;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

@Order(86)
public class MeasureInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MeasureInitRunner.class);
   @Resource
   private MeasureService measureService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private RedisTemplate redisTemplate;

   @Override
   public void run(String... args) throws Exception {
      this.redisTemplate.delete("subjectMeasureDTO");
      List<Measure> measuresLast = this.measureService.initGetMeasure();
      if (!CollectionUtil.isEmpty(measuresLast)) {
         List<Classification> classifications = this.classificationService.list();
         Map<Long, Classification> classificationMap = classifications.stream().collect(Collectors.toMap(Classification::getId, Function.identity()));
         List<Measure> measures = this.measureService.list();
         Map<Long, Measure> measureMap = measures.stream().collect(Collectors.toMap(Measure::getClassificationId, Function.identity()));

         for (Measure measure : measuresLast) {
            Long classificationId = measure.getClassificationId();
            Classification classification = classifications.stream().filter(c -> c.getId().equals(classificationId)).findAny().orElse(null);
            Measure parentMeasure = this.getParentMeasure(classification, classificationMap, measureMap);
            if (!ObjectUtil.isEmpty(parentMeasure)) {
               measure.setAccountingUnit(parentMeasure.getAccountingUnit());
               measure.setAccountingPrecision(parentMeasure.getAccountingPrecision());
               measure.setMeasureUnit(parentMeasure.getMeasureUnit());
               measure.setMeasurePrecision(parentMeasure.getMeasurePrecision());
               measure.setOutboundUnitType(parentMeasure.getOutboundUnitType());
               measure.setUseParentId(parentMeasure.getId());
               measure.setUpdateTime(LocalDateTime.now());
               this.measureService.updateById(measure);
            }
         }
      }
   }

   private Measure getParentMeasure(Classification classification, Map<Long, Classification> classificationMap, Map<Long, Measure> measureMap) {
      Long parentId = classification.getParentId();
      Classification classificationParent = classificationMap.get(parentId);
      if (ObjectUtil.isEmpty(classificationParent)) {
         return null;
      }

      Measure measure = measureMap.get(classificationParent.getId());
      return !ObjectUtil.isNotEmpty(measure.getAccountingUnit())
            && !ObjectUtil.isNotEmpty(measure.getAccountingPrecision())
            && !ObjectUtil.isNotEmpty(measure.getMeasureUnit())
            && !ObjectUtil.isNotEmpty(measure.getMeasurePrecision())
         ? this.getParentMeasure(classificationParent, classificationMap, measureMap)
         : measure;
   }

   public MeasureInitRunner(final MeasureService measureService, final ClassificationService classificationService, final RedisTemplate redisTemplate) {
      this.measureService = measureService;
      this.classificationService = classificationService;
      this.redisTemplate = redisTemplate;
   }
}
