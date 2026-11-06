package com.hzchum.scim.project.core.api.pojo.dto.plan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel("单体类")
public class ProjectMonomerDTO {
   @ApiModelProperty(name = "id", notes = "单体ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "单体名称")
   private String name;
   @ApiModelProperty(name = "date", notes = "单体完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "supplierList", value = "供应商列表")
   private List<SupplierInfo> supplierList;
   @ApiModelProperty(name = "monomerDetailList", notes = "单体详情列表")
   private List<ProjectMonomerDetailDTO> monomerDetailList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<SupplierInfo> getSupplierList() {
      return this.supplierList;
   }

   public List<ProjectMonomerDetailDTO> getMonomerDetailList() {
      return this.monomerDetailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setSupplierList(final List<SupplierInfo> supplierList) {
      this.supplierList = supplierList;
   }

   public void setMonomerDetailList(final List<ProjectMonomerDetailDTO> monomerDetailList) {
      this.monomerDetailList = monomerDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMonomerDTO)) {
         return false;
      }

      ProjectMonomerDTO other = (ProjectMonomerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$date = this.getDate();
               Object other$date = other.getDate();
               if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$supplierList = this.getSupplierList();
                     Object other$supplierList = other.getSupplierList();
                     if (this$supplierList == null ? other$supplierList == null : this$supplierList.equals(other$supplierList)) {
                        Object this$monomerDetailList = this.getMonomerDetailList();
                        Object other$monomerDetailList = other.getMonomerDetailList();
                        return this$monomerDetailList == null ? other$monomerDetailList == null : this$monomerDetailList.equals(other$monomerDetailList);
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
      return other instanceof ProjectMonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $supplierList = this.getSupplierList();
      result = result * 59 + ($supplierList == null ? 43 : $supplierList.hashCode());
      Object $monomerDetailList = this.getMonomerDetailList();
      return result * 59 + ($monomerDetailList == null ? 43 : $monomerDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMonomerDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", supplierList="
         + this.getSupplierList()
         + ", monomerDetailList="
         + this.getMonomerDetailList()
         + ")";
   }
}
