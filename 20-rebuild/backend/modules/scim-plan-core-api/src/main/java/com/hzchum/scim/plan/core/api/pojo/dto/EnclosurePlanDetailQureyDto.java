package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("围护计划 查询条件类")
public class EnclosurePlanDetailQureyDto {
   @ApiModelProperty(name = "year", value = "年")
   private String year;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "signerName", value = "销售负责人")
   private String signerName;
   @ApiModelProperty(name = "createName", value = "创建人")
   private String createName;
   @ApiModelProperty(name = "pageNumber", value = "页码")
   private Integer pageNumber = 1;
   @ApiModelProperty(name = "pageSize", value = "条目")
   private Integer pageSize = 20;

   public String getYear() {
      return this.year;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public String getCreateName() {
      return this.createName;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setYear(final String year) {
      this.year = year;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setCreateName(final String createName) {
      this.createName = createName;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosurePlanDetailQureyDto)) {
         return false;
      }

      EnclosurePlanDetailQureyDto other = (EnclosurePlanDetailQureyDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pageNumber = this.getPageNumber();
      Object other$pageNumber = other.getPageNumber();
      if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
         Object this$pageSize = this.getPageSize();
         Object other$pageSize = other.getPageSize();
         if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$signerName = this.getSignerName();
                  Object other$signerName = other.getSignerName();
                  if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                     Object this$createName = this.getCreateName();
                     Object other$createName = other.getCreateName();
                     return this$createName == null ? other$createName == null : this$createName.equals(other$createName);
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
      return other instanceof EnclosurePlanDetailQureyDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $createName = this.getCreateName();
      return result * 59 + ($createName == null ? 43 : $createName.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosurePlanDetailQureyDto(year="
         + this.getYear()
         + ", projectName="
         + this.getProjectName()
         + ", signerName="
         + this.getSignerName()
         + ", createName="
         + this.getCreateName()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
