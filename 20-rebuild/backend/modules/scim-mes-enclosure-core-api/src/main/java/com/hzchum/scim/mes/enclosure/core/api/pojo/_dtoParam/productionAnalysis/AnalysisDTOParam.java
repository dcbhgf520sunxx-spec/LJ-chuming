package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "AnalysisDTOParam", description = "生产分析请求")
public class AnalysisDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "dateTime", value = "时间")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   @NotNull(message = "时间不能为空")
   private LocalDateTime dateTime;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static AnalysisDTOParam.AnalysisDTOParamBuilder builder() {
      return new AnalysisDTOParam.AnalysisDTOParamBuilder();
   }

   public AnalysisDTOParam() {
   }

   public AnalysisDTOParam(final Long projectId, final Long monomerId, final Integer productType, final LocalDateTime dateTime, final String name) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productType = productType;
      this.dateTime = dateTime;
      this.name = name;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("projectId")
   public AnalysisDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public AnalysisDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("productType")
   public AnalysisDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("dateTime")
   public AnalysisDTOParam setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("name")
   public AnalysisDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "AnalysisDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productType="
         + this.getProductType()
         + ", dateTime="
         + this.getDateTime()
         + ", name="
         + this.getName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnalysisDTOParam)) {
         return false;
      }

      AnalysisDTOParam other = (AnalysisDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$dateTime = this.getDateTime();
               Object other$dateTime = other.getDateTime();
               if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof AnalysisDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class AnalysisDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Integer productType;
      private LocalDateTime dateTime;
      private String name;

      AnalysisDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public AnalysisDTOParam.AnalysisDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public AnalysisDTOParam.AnalysisDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("productType")
      public AnalysisDTOParam.AnalysisDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("dateTime")
      public AnalysisDTOParam.AnalysisDTOParamBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("name")
      public AnalysisDTOParam.AnalysisDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AnalysisDTOParam build() {
         return new AnalysisDTOParam(this.projectId, this.monomerId, this.productType, this.dateTime, this.name);
      }

      @Override
      public String toString() {
         return "AnalysisDTOParam.AnalysisDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productType="
            + this.productType
            + ", dateTime="
            + this.dateTime
            + ", name="
            + this.name
            + ")";
      }
   }
}
