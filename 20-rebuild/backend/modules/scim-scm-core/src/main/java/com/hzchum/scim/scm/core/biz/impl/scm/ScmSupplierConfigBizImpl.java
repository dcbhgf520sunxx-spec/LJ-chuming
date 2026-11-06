package com.hzchum.scim.scm.core.biz.impl.scm;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.scm.core.api.biz.scm.ScmSupplierConfigBiz;
import com.hzchum.scim.scm.core.api.common.constant.ScmSupplierConstants;
import com.hzchum.scim.scm.core.api.enums.SupplierConfigTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierConfig;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ReviewTemplateDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ReviewTemplateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierConfigDTOParam;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.api.service.scm.ScmSupplierConfigService;
import com.hzchum.scim.scm.core.mapper.scm.ScmSupplierConfigMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScmSupplierConfigBizImpl extends IBizImpl<ScmSupplierConfigService, ScmSupplierConfigMapper, ScmSupplierConfig> implements ScmSupplierConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(ScmSupplierConfigBizImpl.class);
   @Resource
   private ScmSupplierConfigService scmSupplierConfigService;
   @Resource
   private SupplierService supplierService;
   private static final List<String> EVALUATION_CATEGORY_NAMES = Arrays.asList("物资类", "采购类", "服务类", "劳务分包类", "物流类", "外协加工类");
   private static final Snowflake snowflake = IdUtil.createSnowflake(1L, 1L);

   // Reconstructed databases retain their snapshot; initialization is an explicit migration step.
   public void initEvaluationCategory() {
      int count = this.scmSupplierConfigService
         .count(Wrappers.lambdaQuery(ScmSupplierConfig.class).eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.EVALUATION_CATEGORY.getType()));
      if (count == 0) {
         for (String name : EVALUATION_CATEGORY_NAMES) {
            ScmSupplierConfig config = new ScmSupplierConfig();
            config.setConfigTypeEnum(SupplierConfigTypeEnum.EVALUATION_CATEGORY.getType());
            config.setName(name);
            this.scmSupplierConfigService.save(config);
            log.info("初始化评价分类配置: {}", name);
         }

         this.initReviewTemplate();
      }
   }

   private void initReviewTemplate() {
      List<ScmSupplierConfig> categories = this.scmSupplierConfigService
         .list(Wrappers.lambdaQuery(ScmSupplierConfig.class).eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.EVALUATION_CATEGORY.getType()));
      Set<Long> existingClassifyIds = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.REVIEW_TEMPLATE.getType())
               .select(ScmSupplierConfig::getClassifyId)
         )
         .stream()
         .map(ScmSupplierConfig::getClassifyId)
         .collect(Collectors.toSet());

      for (ScmSupplierConfig category : categories) {
         if (!existingClassifyIds.contains(category.getId())) {
            ScmSupplierConfig template = new ScmSupplierConfig();
            Map<String, String> columnMap = new HashMap<>();
            columnMap.put("serialNumber", "编号");
            columnMap.put("assessmentProject", "考核项目");
            columnMap.put("assessmentContents", "考核内容");
            columnMap.put("fraction", "分数");
            template.setConfigTypeEnum(SupplierConfigTypeEnum.REVIEW_TEMPLATE.getType());
            template.setClassifyId(category.getId());
            List<ReviewTemplateDTO> reviewTemplateDTOList = new ArrayList<>();
            if ("物资类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.GOODS_TEMPLATE;
            }

            if ("采购类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.PURCHASE_TEMPLATE;
               columnMap.put("hasVeto", "是否有否决项");
            }

            if ("服务类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.SERVICE_TEMPLATE;
               columnMap.put("hasVeto", "是否有否决项");
            }

            if ("劳务分包类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.LABOR_SUBCONTRACT_TEMPLATE;
            }

            if ("物流类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.LOGISTICS_OUTSOURCING_TEMPLATE;
               columnMap.put("remarks", "备注");
            }

            if ("外协加工类".equals(category.getName())) {
               reviewTemplateDTOList = ScmSupplierConstants.OUTSOURCING_TEMPLATE;
               columnMap.put("remarks", "备注");
            }

            for (ReviewTemplateDTO reviewTemplateDTO : reviewTemplateDTOList) {
               reviewTemplateDTO.setSerialNumber(snowflake.nextIdStr());
            }

            template.setColumnMapJson(JSON.toJSONString(columnMap));
            template.setValue(JSON.toJSONString(reviewTemplateDTOList));
            this.scmSupplierConfigService.save(template);
            log.info("初始化评审模板配置: classifyId={}, name={}", category.getId(), category.getName());
         }
      }
   }

   @Override
   public List<ScmSupplierConfigDTO> listEvaluationCategory() {
      List<ScmSupplierConfig> list = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.EVALUATION_CATEGORY.getType())
               .orderByAsc(ScmSupplierConfig::getId)
         );
      return list.stream().map(c -> BeanUtil.copy(c, ScmSupplierConfigDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editEvaluationCategory(List<ScmSupplierConfigDTOParam> params) {
      params.forEach(param -> {
         Preconditions.checkArgument(param.getId() != null, "id不能为空");
         ScmSupplierConfig config = this.scmSupplierConfigService.getById(param.getId());
         Preconditions.checkArgument(config != null, "修改失败，数据不存在");
         Preconditions.checkArgument(SupplierConfigTypeEnum.EVALUATION_CATEGORY.getType().equals(config.getConfigTypeEnum()), "修改失败，数据类型不匹配");
         config.setName(param.getName());
         this.scmSupplierConfigService.updateById(config);
      });
      return true;
   }

   @Override
   public List<ScmSupplierConfigDTO> listScoreRating() {
      List<ScmSupplierConfig> list = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.SCORE_RATING.getType())
               .orderByAsc(ScmSupplierConfig::getMinValue)
         );
      return list.stream().map(c -> BeanUtil.copy(c, ScmSupplierConfigDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editScoreRating(List<ScmSupplierConfigDTOParam> params) {
      this.validateScoreRangeCoverage(params);
      Set<Long> incomingIds = params.stream().filter(p -> p.getId() != null).map(ScmSupplierConfigDTOParam::getId).collect(Collectors.toSet());
      List<Long> existingIds = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.SCORE_RATING.getType())
               .select(ScmSupplierConfig::getId)
         )
         .stream()
         .map(ScmSupplierConfig::getId)
         .collect(Collectors.toList());
      existingIds.stream().filter(id -> !incomingIds.contains(id)).forEach(this.scmSupplierConfigService::removeById);
      params.forEach(param -> {
         if (param.getId() != null) {
            ScmSupplierConfig config = this.scmSupplierConfigService.getById(param.getId());
            Preconditions.checkArgument(config != null, "修改失败，数据不存在");
            config.setName(param.getName());
            config.setMinValue(param.getMinValue());
            config.setMaxValue(param.getMaxValue());
            this.scmSupplierConfigService.updateById(config);
         } else {
            ScmSupplierConfig config = new ScmSupplierConfig();
            config.setConfigTypeEnum(SupplierConfigTypeEnum.SCORE_RATING.getType());
            config.setName(param.getName());
            config.setMinValue(param.getMinValue());
            config.setMaxValue(param.getMaxValue());
            this.scmSupplierConfigService.save(config);
         }
      });
      return true;
   }

   private void validateScoreRangeCoverage(List<ScmSupplierConfigDTOParam> params) {
      Preconditions.checkArgument(params != null && !params.isEmpty(), "分数评级配置不能为空");

      for (ScmSupplierConfigDTOParam param : params) {
         Preconditions.checkArgument(param.getMinValue() != null, "评级【" + param.getName() + "】的最小分值不能为空");
         Preconditions.checkArgument(param.getMaxValue() != null, "评级【" + param.getName() + "】的最大分值不能为空");
         Preconditions.checkArgument(param.getMinValue() >= 0, "评级【" + param.getName() + "】的最小分值不能小于0");
         Preconditions.checkArgument(param.getMaxValue() <= 100, "评级【" + param.getName() + "】的最大分值不能大于100");
         Preconditions.checkArgument(param.getMinValue() <= param.getMaxValue(), "评级【" + param.getName() + "】的最小分值不能大于最大分值");
      }

      List<ScmSupplierConfigDTOParam> sortedParams = params.stream()
         .sorted(Comparator.comparing(ScmSupplierConfigDTOParam::getMinValue))
         .collect(Collectors.toList());
      Preconditions.checkArgument(sortedParams.get(0).getMinValue() == 0, "分数评级必须从0分开始，当前最小值为：" + sortedParams.get(0).getMinValue());
      ScmSupplierConfigDTOParam lastParam = sortedParams.get(sortedParams.size() - 1);
      Preconditions.checkArgument(lastParam.getMaxValue() == 100, "分数评级必须到100分结束，当前最大值为：" + lastParam.getMaxValue());

      for (int i = 0; i < sortedParams.size() - 1; i++) {
         ScmSupplierConfigDTOParam current = sortedParams.get(i);
         ScmSupplierConfigDTOParam next = sortedParams.get(i + 1);
         if (current.getMaxValue() + 1 != next.getMinValue()) {
            throw new IllegalArgumentException(
               String.format(
                  "分数评级区间不连续：评级【%s】的范围是[%d-%d]，评级【%s】的范围是[%d-%d]，中间存在分值遗漏或重叠",
                  current.getName(),
                  current.getMinValue(),
                  current.getMaxValue(),
                  next.getName(),
                  next.getMinValue(),
                  next.getMaxValue()
               )
            );
         }
      }

      boolean[] covered = new boolean[101];

      for (ScmSupplierConfigDTOParam param : sortedParams) {
         for (int score = param.getMinValue(); score <= param.getMaxValue(); score++) {
            Preconditions.checkArgument(!covered[score], String.format("分数评级区间重叠：分值%d被多个评级覆盖", score));
            covered[score] = true;
         }
      }

      for (int score = 0; score <= 100; score++) {
         Preconditions.checkArgument(covered[score], String.format("分数评级未覆盖全部分值：分值%d没有被任何评级覆盖", score));
      }
   }

   @Override
   public List<ScmSupplierConfigDTO> listQualification() {
      List<ScmSupplierConfig> list = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.QUALIFICATION.getType())
               .orderByAsc(ScmSupplierConfig::getId)
         );
      return list.stream().map(c -> BeanUtil.copy(c, ScmSupplierConfigDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editQualification(List<ScmSupplierConfigDTOParam> params) {
      Set<Long> incomingIds = params.stream().filter(p -> p.getId() != null).map(ScmSupplierConfigDTOParam::getId).collect(Collectors.toSet());
      List<Long> existingIds = this.scmSupplierConfigService
         .list(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.QUALIFICATION.getType())
               .select(ScmSupplierConfig::getId)
         )
         .stream()
         .map(ScmSupplierConfig::getId)
         .collect(Collectors.toList());
      List<Long> idsToDelete = existingIds.stream().filter(id -> !incomingIds.contains(id)).collect(Collectors.toList());
      if (!idsToDelete.isEmpty()) {
         List<Supplier> suppliersUsingQualifications = this.supplierService
            .list(
               (Wrappers.<Supplier>lambdaQuery().in(Supplier::getQualificationsId, idsToDelete))
                  .select(Supplier::getId, Supplier::getName, Supplier::getQualificationsId)
            );
         if (!suppliersUsingQualifications.isEmpty()) {
            String supplierNames = suppliersUsingQualifications.stream().map(Supplier::getName).limit(5L).collect(Collectors.joining("、"));
            String message = String.format("删除失败，以下供应商正在使用该资质：%s等，共%d个供应商", supplierNames, suppliersUsingQualifications.size());
            throw new IllegalArgumentException(message);
         }

         idsToDelete.forEach(this.scmSupplierConfigService::removeById);
      }

      params.forEach(
         param -> {
            if (param.getId() != null) {
               ScmSupplierConfig config = this.scmSupplierConfigService.getById(param.getId());
               Preconditions.checkArgument(config != null, "修改失败，数据不存在");
               if (!param.getName().equals(config.getName())) {
                  int count = this.scmSupplierConfigService
                     .count(
                        Wrappers.lambdaQuery(ScmSupplierConfig.class)
                           .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.QUALIFICATION.getType())
                           .eq(ScmSupplierConfig::getName, param.getName())
                     );
                  Preconditions.checkArgument(count == 0, "修改失败，资质名称（" + param.getName() + "）已存在");
               }

               config.setName(param.getName());
               this.scmSupplierConfigService.updateById(config);
            } else {
               int count = this.scmSupplierConfigService
                  .count(
                     Wrappers.lambdaQuery(ScmSupplierConfig.class)
                        .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.QUALIFICATION.getType())
                        .eq(ScmSupplierConfig::getName, param.getName())
                  );
               Preconditions.checkArgument(count == 0, "新增失败，资质名称（" + param.getName() + "）已存在");
               ScmSupplierConfig config = new ScmSupplierConfig();
               config.setConfigTypeEnum(SupplierConfigTypeEnum.QUALIFICATION.getType());
               config.setName(param.getName());
               this.scmSupplierConfigService.save(config);
            }
         }
      );
      return true;
   }

   @Override
   public ScmSupplierConfigDTO getReviewTemplate(Long classifyId) {
      ScmSupplierConfig scmSupplierConfig = this.scmSupplierConfigService
         .getOne(
            Wrappers.lambdaQuery(ScmSupplierConfig.class)
               .eq(ScmSupplierConfig::getConfigTypeEnum, SupplierConfigTypeEnum.REVIEW_TEMPLATE.getType())
               .eq(ScmSupplierConfig::getClassifyId, classifyId)
         );
      if (scmSupplierConfig == null) {
         return null;
      }

      ScmSupplierConfigDTO dto = BeanUtil.copy(scmSupplierConfig, ScmSupplierConfigDTO.class);
      HashMap<String, String> columnMap = JSON.parseObject(scmSupplierConfig.getColumnMapJson(), HashMap.class);
      dto.setColumnMap(columnMap);
      return dto;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean editReviewTemplate(ReviewTemplateDTOParam param) {
      String paramTemplatesJson = param.getValue();
      Preconditions.checkArgument(param.getId() != null, "id不能为空");
      Preconditions.checkArgument(StringUtils.isNotBlank(param.getValue()), "评审模板内容不能为空");
      ScmSupplierConfig config = this.scmSupplierConfigService.getById(param.getId());
      Preconditions.checkArgument(config != null, "修改失败，评审模板数据不存在");
      String configTemplatesJson = config.getValue();
      Preconditions.checkArgument(StringUtils.isNotBlank(paramTemplatesJson), "修改失败，评审模板数据不存在");
      Preconditions.checkArgument(SupplierConfigTypeEnum.REVIEW_TEMPLATE.getType().equals(config.getConfigTypeEnum()), "修改失败，数据类型不匹配");
      HashMap<String, String> oldFractionMap = new HashMap<>();
      if (StringUtils.isNotBlank(configTemplatesJson)) {
         try {
            JSONArray oldJsonArray = JSON.parseArray(configTemplatesJson);

            for (int i = 0; i < oldJsonArray.size(); i++) {
               JSONObject oldTemplateJson = oldJsonArray.getJSONObject(i);
               String serialNumber = oldTemplateJson.getString("serialNumber");
               String fraction = oldTemplateJson.getString("fraction");
               if (serialNumber != null) {
                  oldFractionMap.put(serialNumber, fraction);
               }
            }
         } catch (Exception e) {
            log.warn("解析原有评审模板JSON失败，将重新生成所有编号: {}", configTemplatesJson, e);
         }
      }

      JSONArray jsonArray = JSON.parseArray(paramTemplatesJson);

      for (int i = 0; i < jsonArray.size(); i++) {
         JSONObject templateJson = jsonArray.getJSONObject(i);
         String assessmentProject = templateJson.getString("assessmentProject");
         if (!"否决项".equals(assessmentProject)) {
            templateJson.put("hasVeto", null);
         }

         String serialNumber = templateJson.getString("serialNumber");
         if (serialNumber == null) {
            templateJson.put("serialNumber", snowflake.nextIdStr());
         } else {
            String oldFraction = oldFractionMap.get(serialNumber);
            String currentFraction = templateJson.getString("fraction");
            if (oldFraction == null || !oldFraction.equals(currentFraction)) {
               templateJson.put("serialNumber", snowflake.nextIdStr());
            }
         }
      }

      String updatedJson = jsonArray.toJSONString();
      config.setValue(updatedJson);
      config.setColumnMapJson(JSON.toJSONString(param.getColumnMap()));
      this.scmSupplierConfigService.updateById(config);
      return true;
   }
}
