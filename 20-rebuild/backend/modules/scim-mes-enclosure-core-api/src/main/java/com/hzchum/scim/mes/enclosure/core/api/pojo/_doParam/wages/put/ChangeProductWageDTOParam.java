package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.wages.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ChangeProductWageDTOParam", description = "")
public class ChangeProductWageDTOParam {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @NotNull(message = "任务类型不能为空")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id")
   private Long processId;
   @ApiModelProperty(name = "wage", notes = "价格")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   private BigDecimal wage;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "primerWage", value = "底漆价格", notes = "底漆价格")
   @JsonProperty("primerWage")
   @JSONField(name = "primerWage")
   private BigDecimal primerWage;
   @ApiModelProperty(name = "intermediatePaintWage", value = "中间漆价格", notes = "中间漆价格")
   @JsonProperty("intermediatePaintWage")
   @JSONField(name = "intermediatePaintWage")
   private BigDecimal intermediatePaintWage;
   @ApiModelProperty(name = "topcoatWage", value = "面漆单价", notes = "面漆单价")
   @JsonProperty("topcoatWage")
   @JSONField(name = "topcoatWage")
   private BigDecimal topcoatWage;

   public static ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder builder() {
      return new ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder();
   }

   public ChangeProductWageDTOParam(
      final Long id,
      final Integer taskTypeEnum,
      final Long processId,
      final BigDecimal wage,
      final Integer wageQuotaType,
      final BigDecimal primerWage,
      final BigDecimal intermediatePaintWage,
      final BigDecimal topcoatWage
   ) {
      this.id = id;
      this.taskTypeEnum = taskTypeEnum;
      this.processId = processId;
      this.wage = wage;
      this.wageQuotaType = wageQuotaType;
      this.primerWage = primerWage;
      this.intermediatePaintWage = intermediatePaintWage;
      this.topcoatWage = topcoatWage;
   }

   public ChangeProductWageDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getPrimerWage() {
      return this.primerWage;
   }

   public BigDecimal getIntermediatePaintWage() {
      return this.intermediatePaintWage;
   }

   public BigDecimal getTopcoatWage() {
      return this.topcoatWage;
   }

   @JsonProperty("id")
   public ChangeProductWageDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ChangeProductWageDTOParam setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("processId")
   public ChangeProductWageDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wage")
   public ChangeProductWageDTOParam setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public ChangeProductWageDTOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("primerWage")
   public ChangeProductWageDTOParam setPrimerWage(final BigDecimal primerWage) {
      this.primerWage = primerWage;
      return this;
   }

   @JsonProperty("intermediatePaintWage")
   public ChangeProductWageDTOParam setIntermediatePaintWage(final BigDecimal intermediatePaintWage) {
      this.intermediatePaintWage = intermediatePaintWage;
      return this;
   }

   @JsonProperty("topcoatWage")
   public ChangeProductWageDTOParam setTopcoatWage(final BigDecimal topcoatWage) {
      this.topcoatWage = topcoatWage;
      return this;
   }

   @Override
   public String toString() {
      return "ChangeProductWageDTOParam(id="
         + this.getId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", processId="
         + this.getProcessId()
         + ", wage="
         + this.getWage()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", primerWage="
         + this.getPrimerWage()
         + ", intermediatePaintWage="
         + this.getIntermediatePaintWage()
         + ", topcoatWage="
         + this.getTopcoatWage()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ChangeProductWageDTOParam)) {
         return false;
      }

      ChangeProductWageDTOParam other = (ChangeProductWageDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskTypeEnum = this.getTaskTypeEnum();
         Object other$taskTypeEnum = other.getTaskTypeEnum();
         if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$wage = this.getWage();
                  Object other$wage = other.getWage();
                  if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                     Object this$primerWage = this.getPrimerWage();
                     Object other$primerWage = other.getPrimerWage();
                     if (this$primerWage == null ? other$primerWage == null : this$primerWage.equals(other$primerWage)) {
                        Object this$intermediatePaintWage = this.getIntermediatePaintWage();
                        Object other$intermediatePaintWage = other.getIntermediatePaintWage();
                        if (this$intermediatePaintWage == null
                           ? other$intermediatePaintWage == null
                           : this$intermediatePaintWage.equals(other$intermediatePaintWage)) {
                           Object this$topcoatWage = this.getTopcoatWage();
                           Object other$topcoatWage = other.getTopcoatWage();
                           return this$topcoatWage == null ? other$topcoatWage == null : this$topcoatWage.equals(other$topcoatWage);
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
      return other instanceof ChangeProductWageDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $primerWage = this.getPrimerWage();
      result = result * 59 + ($primerWage == null ? 43 : $primerWage.hashCode());
      Object $intermediatePaintWage = this.getIntermediatePaintWage();
      result = result * 59 + ($intermediatePaintWage == null ? 43 : $intermediatePaintWage.hashCode());
      Object $topcoatWage = this.getTopcoatWage();
      return result * 59 + ($topcoatWage == null ? 43 : $topcoatWage.hashCode());
   }

   public static class ChangeProductWageDTOParamBuilder {
      private Long id;
      private Integer taskTypeEnum;
      private Long processId;
      private BigDecimal wage;
      private Integer wageQuotaType;
      private BigDecimal primerWage;
      private BigDecimal intermediatePaintWage;
      private BigDecimal topcoatWage;

      ChangeProductWageDTOParamBuilder() {
      }

      @JsonProperty("id")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("processId")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wage")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("primerWage")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder primerWage(final BigDecimal primerWage) {
         this.primerWage = primerWage;
         return this;
      }

      @JsonProperty("intermediatePaintWage")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder intermediatePaintWage(final BigDecimal intermediatePaintWage) {
         this.intermediatePaintWage = intermediatePaintWage;
         return this;
      }

      @JsonProperty("topcoatWage")
      public ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder topcoatWage(final BigDecimal topcoatWage) {
         this.topcoatWage = topcoatWage;
         return this;
      }

      public ChangeProductWageDTOParam build() {
         return new ChangeProductWageDTOParam(
            this.id, this.taskTypeEnum, this.processId, this.wage, this.wageQuotaType, this.primerWage, this.intermediatePaintWage, this.topcoatWage
         );
      }

      @Override
      public String toString() {
         return "ChangeProductWageDTOParam.ChangeProductWageDTOParamBuilder(id="
            + this.id
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", processId="
            + this.processId
            + ", wage="
            + this.wage
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", primerWage="
            + this.primerWage
            + ", intermediatePaintWage="
            + this.intermediatePaintWage
            + ", topcoatWage="
            + this.topcoatWage
            + ")";
      }
   }
}
