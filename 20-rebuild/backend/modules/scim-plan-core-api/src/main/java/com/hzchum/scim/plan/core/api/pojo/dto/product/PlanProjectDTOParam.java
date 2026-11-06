package com.hzchum.scim.plan.core.api.pojo.dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("项目查询条件")
public class PlanProjectDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty("项目年份")
   private String year;
   @ApiModelProperty("页码")
   private Integer pageNumber = 1;
   @ApiModelProperty("页数")
   private Integer pageSize = 10;
   @ApiModelProperty("排序")
   private List<String> sort;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public String getYear() {
      return this.year;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public List<String> getSort() {
      return this.sort;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setYear(final String year) {
      this.year = year;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setSort(final List<String> sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanProjectDTOParam)) {
         return false;
      }

      PlanProjectDTOParam other = (PlanProjectDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$pageNumber = this.getPageNumber();
         Object other$pageNumber = other.getPageNumber();
         if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
            Object this$pageSize = this.getPageSize();
            Object other$pageSize = other.getPageSize();
            if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$year = this.getYear();
                  Object other$year = other.getYear();
                  if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                     Object this$sort = this.getSort();
                     Object other$sort = other.getSort();
                     return this$sort == null ? other$sort == null : this$sort.equals(other$sort);
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
      return other instanceof PlanProjectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $sort = this.getSort();
      return result * 59 + ($sort == null ? 43 : $sort.hashCode());
   }

   @Override
   public String toString() {
      return "PlanProjectDTOParam(projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", year="
         + this.getYear()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
