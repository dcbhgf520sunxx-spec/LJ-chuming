package com.hzchum.scim.scm.core.api.pojo.dtoParam.scm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ScmSupplierEvaluateDTOParam", description = "供应商评价新增入参")
public class ScmSupplierEvaluateDTOParam {
   @ApiModelProperty(value = "供应商id", required = true)
   @NotNull(message = "供应商id不能为空")
   private Long supplierId;
   @ApiModelProperty(value = "评价模板id", required = true)
   @NotNull(message = "评价模板id不能为空")
   private Long templateId;
   @ApiModelProperty(value = "总分", required = true)
   private Integer score;
   @ApiModelProperty(value = "评价分数详情JSON字符串", required = true)
   @NotNull(message = "评价分数详情不能为空")
   private String evaluateDetailsJson;
   @ApiModelProperty("评审模板固定字段映射")
   private Map<String, String> columnMap = new HashMap<>();

   public static ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder builder() {
      return new ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder();
   }

   public ScmSupplierEvaluateDTOParam() {
   }

   public ScmSupplierEvaluateDTOParam(
      final Long supplierId, final Long templateId, final Integer score, final String evaluateDetailsJson, final Map<String, String> columnMap
   ) {
      this.supplierId = supplierId;
      this.templateId = templateId;
      this.score = score;
      this.evaluateDetailsJson = evaluateDetailsJson;
      this.columnMap = columnMap;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getTemplateId() {
      return this.templateId;
   }

   public Integer getScore() {
      return this.score;
   }

   public String getEvaluateDetailsJson() {
      return this.evaluateDetailsJson;
   }

   public Map<String, String> getColumnMap() {
      return this.columnMap;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setTemplateId(final Long templateId) {
      this.templateId = templateId;
   }

   public void setScore(final Integer score) {
      this.score = score;
   }

   public void setEvaluateDetailsJson(final String evaluateDetailsJson) {
      this.evaluateDetailsJson = evaluateDetailsJson;
   }

   public void setColumnMap(final Map<String, String> columnMap) {
      this.columnMap = columnMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierEvaluateDTOParam)) {
         return false;
      }

      ScmSupplierEvaluateDTOParam other = (ScmSupplierEvaluateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$templateId = this.getTemplateId();
         Object other$templateId = other.getTemplateId();
         if (this$templateId == null ? other$templateId == null : this$templateId.equals(other$templateId)) {
            Object this$score = this.getScore();
            Object other$score = other.getScore();
            if (this$score == null ? other$score == null : this$score.equals(other$score)) {
               Object this$evaluateDetailsJson = this.getEvaluateDetailsJson();
               Object other$evaluateDetailsJson = other.getEvaluateDetailsJson();
               if (this$evaluateDetailsJson == null ? other$evaluateDetailsJson == null : this$evaluateDetailsJson.equals(other$evaluateDetailsJson)) {
                  Object this$columnMap = this.getColumnMap();
                  Object other$columnMap = other.getColumnMap();
                  return this$columnMap == null ? other$columnMap == null : this$columnMap.equals(other$columnMap);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScmSupplierEvaluateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $templateId = this.getTemplateId();
      result = result * 59 + ($templateId == null ? 43 : $templateId.hashCode());
      Object $score = this.getScore();
      result = result * 59 + ($score == null ? 43 : $score.hashCode());
      Object $evaluateDetailsJson = this.getEvaluateDetailsJson();
      result = result * 59 + ($evaluateDetailsJson == null ? 43 : $evaluateDetailsJson.hashCode());
      Object $columnMap = this.getColumnMap();
      return result * 59 + ($columnMap == null ? 43 : $columnMap.hashCode());
   }

   @Override
   public String toString() {
      return "ScmSupplierEvaluateDTOParam(supplierId="
         + this.getSupplierId()
         + ", templateId="
         + this.getTemplateId()
         + ", score="
         + this.getScore()
         + ", evaluateDetailsJson="
         + this.getEvaluateDetailsJson()
         + ", columnMap="
         + this.getColumnMap()
         + ")";
   }

   public static class ScmSupplierEvaluateDTOParamBuilder {
      private Long supplierId;
      private Long templateId;
      private Integer score;
      private String evaluateDetailsJson;
      private Map<String, String> columnMap;

      ScmSupplierEvaluateDTOParamBuilder() {
      }

      public ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder templateId(final Long templateId) {
         this.templateId = templateId;
         return this;
      }

      public ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder score(final Integer score) {
         this.score = score;
         return this;
      }

      public ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder evaluateDetailsJson(final String evaluateDetailsJson) {
         this.evaluateDetailsJson = evaluateDetailsJson;
         return this;
      }

      public ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder columnMap(final Map<String, String> columnMap) {
         this.columnMap = columnMap;
         return this;
      }

      public ScmSupplierEvaluateDTOParam build() {
         return new ScmSupplierEvaluateDTOParam(this.supplierId, this.templateId, this.score, this.evaluateDetailsJson, this.columnMap);
      }

      @Override
      public String toString() {
         return "ScmSupplierEvaluateDTOParam.ScmSupplierEvaluateDTOParamBuilder(supplierId="
            + this.supplierId
            + ", templateId="
            + this.templateId
            + ", score="
            + this.score
            + ", evaluateDetailsJson="
            + this.evaluateDetailsJson
            + ", columnMap="
            + this.columnMap
            + ")";
      }
   }
}
