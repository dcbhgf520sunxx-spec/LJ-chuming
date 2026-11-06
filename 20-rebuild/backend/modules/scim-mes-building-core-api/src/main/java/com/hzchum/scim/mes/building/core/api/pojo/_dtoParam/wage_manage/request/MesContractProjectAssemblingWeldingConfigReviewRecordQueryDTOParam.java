package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("项目装焊配置工价修改审批记录表条件查询类")
public class MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam {
   @NotNull(message = "年份不能为空")
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private Integer year;
   @ApiModelProperty(name = "contractProjectShortName", value = "项目简称", notes = "项目简称")
   private String contractProjectShortName;
   @ApiModelProperty(name = "artifactClassificationName", value = "构件分类名称", notes = "构件分类名称")
   private String artifactClassificationName;
   @ApiModelProperty(name = "initiatorName", value = "发起人名称", notes = "发起人名称")
   private String initiatorName;
   @ApiModelProperty(name = "reviewerName", value = "审批人名称", notes = "审批人名称")
   private String reviewerName;

   public static MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder builder() {
      return new MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder();
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam() {
   }

   public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam(
      final Integer year, final String contractProjectShortName, final String artifactClassificationName, final String initiatorName, final String reviewerName
   ) {
      this.year = year;
      this.contractProjectShortName = contractProjectShortName;
      this.artifactClassificationName = artifactClassificationName;
      this.initiatorName = initiatorName;
      this.reviewerName = reviewerName;
   }

   public Integer getYear() {
      return this.year;
   }

   public String getContractProjectShortName() {
      return this.contractProjectShortName;
   }

   public String getArtifactClassificationName() {
      return this.artifactClassificationName;
   }

   public String getInitiatorName() {
      return this.initiatorName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setContractProjectShortName(final String contractProjectShortName) {
      this.contractProjectShortName = contractProjectShortName;
   }

   public void setArtifactClassificationName(final String artifactClassificationName) {
      this.artifactClassificationName = artifactClassificationName;
   }

   public void setInitiatorName(final String initiatorName) {
      this.initiatorName = initiatorName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam other = (MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$contractProjectShortName = this.getContractProjectShortName();
         Object other$contractProjectShortName = other.getContractProjectShortName();
         if (this$contractProjectShortName == null
            ? other$contractProjectShortName == null
            : this$contractProjectShortName.equals(other$contractProjectShortName)) {
            Object this$artifactClassificationName = this.getArtifactClassificationName();
            Object other$artifactClassificationName = other.getArtifactClassificationName();
            if (this$artifactClassificationName == null
               ? other$artifactClassificationName == null
               : this$artifactClassificationName.equals(other$artifactClassificationName)) {
               Object this$initiatorName = this.getInitiatorName();
               Object other$initiatorName = other.getInitiatorName();
               if (this$initiatorName == null ? other$initiatorName == null : this$initiatorName.equals(other$initiatorName)) {
                  Object this$reviewerName = this.getReviewerName();
                  Object other$reviewerName = other.getReviewerName();
                  return this$reviewerName == null ? other$reviewerName == null : this$reviewerName.equals(other$reviewerName);
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
      return other instanceof MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $contractProjectShortName = this.getContractProjectShortName();
      result = result * 59 + ($contractProjectShortName == null ? 43 : $contractProjectShortName.hashCode());
      Object $artifactClassificationName = this.getArtifactClassificationName();
      result = result * 59 + ($artifactClassificationName == null ? 43 : $artifactClassificationName.hashCode());
      Object $initiatorName = this.getInitiatorName();
      result = result * 59 + ($initiatorName == null ? 43 : $initiatorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      return result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam(year="
         + this.getYear()
         + ", contractProjectShortName="
         + this.getContractProjectShortName()
         + ", artifactClassificationName="
         + this.getArtifactClassificationName()
         + ", initiatorName="
         + this.getInitiatorName()
         + ", reviewerName="
         + this.getReviewerName()
         + ")";
   }

   public static class MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder {
      private Integer year;
      private String contractProjectShortName;
      private String artifactClassificationName;
      private String initiatorName;
      private String reviewerName;

      MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder() {
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder year(
         final Integer year
      ) {
         this.year = year;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder contractProjectShortName(
         final String contractProjectShortName
      ) {
         this.contractProjectShortName = contractProjectShortName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder artifactClassificationName(
         final String artifactClassificationName
      ) {
         this.artifactClassificationName = artifactClassificationName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder initiatorName(
         final String initiatorName
      ) {
         this.initiatorName = initiatorName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder reviewerName(
         final String reviewerName
      ) {
         this.reviewerName = reviewerName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam build() {
         return new MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam(
            this.year, this.contractProjectShortName, this.artifactClassificationName, this.initiatorName, this.reviewerName
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParam.MesContractProjectAssemblingWeldingConfigReviewRecordQueryDTOParamBuilder(year="
            + this.year
            + ", contractProjectShortName="
            + this.contractProjectShortName
            + ", artifactClassificationName="
            + this.artifactClassificationName
            + ", initiatorName="
            + this.initiatorName
            + ", reviewerName="
            + this.reviewerName
            + ")";
      }
   }
}
