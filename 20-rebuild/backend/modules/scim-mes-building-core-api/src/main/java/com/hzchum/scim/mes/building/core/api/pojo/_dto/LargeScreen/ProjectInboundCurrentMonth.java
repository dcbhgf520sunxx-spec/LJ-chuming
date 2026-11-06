package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "本月项目入库数据")
public class ProjectInboundCurrentMonth {
   @ApiModelProperty(name = "projectName", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "inboundWeight", value = "入库吨")
   @JsonProperty("inboundWeight")
   @JSONField(name = "inboundWeight")
   private BigDecimal inboundWeight;

   public static ProjectInboundCurrentMonth.ProjectInboundCurrentMonthBuilder builder() {
      return new ProjectInboundCurrentMonth.ProjectInboundCurrentMonthBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getInboundWeight() {
      return this.inboundWeight;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("inboundWeight")
   public void setInboundWeight(final BigDecimal inboundWeight) {
      this.inboundWeight = inboundWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectInboundCurrentMonth)) {
         return false;
      } else {
         ProjectInboundCurrentMonth other = (ProjectInboundCurrentMonth)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$inboundWeight = this.getInboundWeight();
               Object other$inboundWeight = other.getInboundWeight();
               return this$inboundWeight == null ? other$inboundWeight == null : this$inboundWeight.equals(other$inboundWeight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInboundCurrentMonth;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $inboundWeight = this.getInboundWeight();
      return result * 59 + ($inboundWeight == null ? 43 : $inboundWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInboundCurrentMonth(super="
         + super.toString()
         + ", projectName="
         + this.getProjectName()
         + ", inboundWeight="
         + this.getInboundWeight()
         + ")";
   }

   public ProjectInboundCurrentMonth(final String projectName, final BigDecimal inboundWeight) {
      this.projectName = projectName;
      this.inboundWeight = inboundWeight;
   }

   public ProjectInboundCurrentMonth() {
   }

   public static class ProjectInboundCurrentMonthBuilder {
      private String projectName;
      private BigDecimal inboundWeight;

      ProjectInboundCurrentMonthBuilder() {
      }

      @JsonProperty("projectName")
      public ProjectInboundCurrentMonth.ProjectInboundCurrentMonthBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("inboundWeight")
      public ProjectInboundCurrentMonth.ProjectInboundCurrentMonthBuilder inboundWeight(final BigDecimal inboundWeight) {
         this.inboundWeight = inboundWeight;
         return this;
      }

      public ProjectInboundCurrentMonth build() {
         return new ProjectInboundCurrentMonth(this.projectName, this.inboundWeight);
      }

      @Override
      public String toString() {
         return "ProjectInboundCurrentMonth.ProjectInboundCurrentMonthBuilder(projectName=" + this.projectName + ", inboundWeight=" + this.inboundWeight + ")";
      }
   }
}
