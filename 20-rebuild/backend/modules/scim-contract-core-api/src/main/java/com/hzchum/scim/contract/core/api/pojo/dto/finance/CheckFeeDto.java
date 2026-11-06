package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;

@ApiModel("运营分析-检测费返回类")
public class CheckFeeDto {
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private ProjectInfo project;
   @ApiModelProperty(name = "capacity", value = "产能(吨)")
   private BigDecimal capacity;
   @ApiModelProperty(name = "checkType", value = "所有的检查类型")
   private Map<Long, BigDecimal> checkType;

   public static CheckFeeDto.CheckFeeDtoBuilder builder() {
      return new CheckFeeDto.CheckFeeDtoBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getCapacity() {
      return this.capacity;
   }

   public Map<Long, BigDecimal> getCheckType() {
      return this.checkType;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCapacity(final BigDecimal capacity) {
      this.capacity = capacity;
   }

   public void setCheckType(final Map<Long, BigDecimal> checkType) {
      this.checkType = checkType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CheckFeeDto)) {
         return false;
      }

      CheckFeeDto other = (CheckFeeDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$capacity = this.getCapacity();
         Object other$capacity = other.getCapacity();
         if (this$capacity == null ? other$capacity == null : this$capacity.equals(other$capacity)) {
            Object this$checkType = this.getCheckType();
            Object other$checkType = other.getCheckType();
            return this$checkType == null ? other$checkType == null : this$checkType.equals(other$checkType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CheckFeeDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $capacity = this.getCapacity();
      result = result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
      Object $checkType = this.getCheckType();
      return result * 59 + ($checkType == null ? 43 : $checkType.hashCode());
   }

   @Override
   public String toString() {
      return "CheckFeeDto(project=" + this.getProject() + ", capacity=" + this.getCapacity() + ", checkType=" + this.getCheckType() + ")";
   }

   public CheckFeeDto(final ProjectInfo project, final BigDecimal capacity, final Map<Long, BigDecimal> checkType) {
      this.project = project;
      this.capacity = capacity;
      this.checkType = checkType;
   }

   public CheckFeeDto() {
   }

   public static class CheckFeeDtoBuilder {
      private ProjectInfo project;
      private BigDecimal capacity;
      private Map<Long, BigDecimal> checkType;

      CheckFeeDtoBuilder() {
      }

      public CheckFeeDto.CheckFeeDtoBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public CheckFeeDto.CheckFeeDtoBuilder capacity(final BigDecimal capacity) {
         this.capacity = capacity;
         return this;
      }

      public CheckFeeDto.CheckFeeDtoBuilder checkType(final Map<Long, BigDecimal> checkType) {
         this.checkType = checkType;
         return this;
      }

      public CheckFeeDto build() {
         return new CheckFeeDto(this.project, this.capacity, this.checkType);
      }

      @Override
      public String toString() {
         return "CheckFeeDto.CheckFeeDtoBuilder(project=" + this.project + ", capacity=" + this.capacity + ", checkType=" + this.checkType + ")";
      }
   }
}
