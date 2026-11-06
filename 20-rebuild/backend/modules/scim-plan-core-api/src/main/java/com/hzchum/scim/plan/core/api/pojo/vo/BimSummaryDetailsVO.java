package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BimSummaryDetailsVO", description = "bim构件工序详情")
public class BimSummaryDetailsVO {
   @ApiModelProperty(name = "name", notes = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "userNames", notes = "上报人")
   @JsonProperty("userNames")
   @JSONField(name = "userNames")
   private String userNames;

   public static BimSummaryDetailsVO.BimSummaryDetailsVOBuilder builder() {
      return new BimSummaryDetailsVO.BimSummaryDetailsVOBuilder();
   }

   public BimSummaryDetailsVO() {
   }

   public BimSummaryDetailsVO(final String name, final Integer completeQuantity, final Integer inspectionQuantity, final String userNames) {
      this.name = name;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.userNames = userNames;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public String getUserNames() {
      return this.userNames;
   }

   @JsonProperty("name")
   public BimSummaryDetailsVO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("completeQuantity")
   public BimSummaryDetailsVO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public BimSummaryDetailsVO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("userNames")
   public BimSummaryDetailsVO setUserNames(final String userNames) {
      this.userNames = userNames;
      return this;
   }

   @Override
   public String toString() {
      return "BimSummaryDetailsVO(name="
         + this.getName()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", userNames="
         + this.getUserNames()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimSummaryDetailsVO)) {
         return false;
      }

      BimSummaryDetailsVO other = (BimSummaryDetailsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$completeQuantity = this.getCompleteQuantity();
      Object other$completeQuantity = other.getCompleteQuantity();
      if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$userNames = this.getUserNames();
               Object other$userNames = other.getUserNames();
               return this$userNames == null ? other$userNames == null : this$userNames.equals(other$userNames);
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
      return other instanceof BimSummaryDetailsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $userNames = this.getUserNames();
      return result * 59 + ($userNames == null ? 43 : $userNames.hashCode());
   }

   public static class BimSummaryDetailsVOBuilder {
      private String name;
      private Integer completeQuantity;
      private Integer inspectionQuantity;
      private String userNames;

      BimSummaryDetailsVOBuilder() {
      }

      @JsonProperty("name")
      public BimSummaryDetailsVO.BimSummaryDetailsVOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("completeQuantity")
      public BimSummaryDetailsVO.BimSummaryDetailsVOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public BimSummaryDetailsVO.BimSummaryDetailsVOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("userNames")
      public BimSummaryDetailsVO.BimSummaryDetailsVOBuilder userNames(final String userNames) {
         this.userNames = userNames;
         return this;
      }

      public BimSummaryDetailsVO build() {
         return new BimSummaryDetailsVO(this.name, this.completeQuantity, this.inspectionQuantity, this.userNames);
      }

      @Override
      public String toString() {
         return "BimSummaryDetailsVO.BimSummaryDetailsVOBuilder(name="
            + this.name
            + ", completeQuantity="
            + this.completeQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", userNames="
            + this.userNames
            + ")";
      }
   }
}
