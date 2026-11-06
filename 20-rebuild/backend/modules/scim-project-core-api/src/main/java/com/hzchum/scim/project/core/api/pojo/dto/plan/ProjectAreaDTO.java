package com.hzchum.scim.project.core.api.pojo.dto.plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("区域类")
public class ProjectAreaDTO {
   @ApiModelProperty(name = "id", notes = "区域ID")
   private Long id;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "axis", notes = "轴线或标高")
   private String axis;
   @ApiModelProperty(name = "date", notes = "区域完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外协")
   private Integer type;
   @ApiModelProperty(name = "productType", notes = "产品类型  1夹芯板 2压型彩板 3桁架楼承板 4压型楼承板 5结构件 6折边件")
   private Integer productType;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "supplierId", value = "分包供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "startDate", value = "安装计划开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "安装计划结束日期")
   private LocalDate endDate;

   public static ProjectAreaDTO.ProjectAreaDTOBuilder builder() {
      return new ProjectAreaDTO.ProjectAreaDTOBuilder();
   }

   public ProjectAreaDTO() {
   }

   public ProjectAreaDTO(
      final Long id,
      final String name,
      final String axis,
      final LocalDate date,
      final Integer type,
      final Integer productType,
      final Integer sort,
      final Long supplierId,
      final String supplierName,
      final LocalDate startDate,
      final LocalDate endDate
   ) {
      this.id = id;
      this.name = name;
      this.axis = axis;
      this.date = date;
      this.type = type;
      this.productType = productType;
      this.sort = sort;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.startDate = startDate;
      this.endDate = endDate;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAxis() {
      return this.axis;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAreaDTO)) {
         return false;
      }

      ProjectAreaDTO other = (ProjectAreaDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$axis = this.getAxis();
                        Object other$axis = other.getAxis();
                        if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                           Object this$date = this.getDate();
                           Object other$date = other.getDate();
                           if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                 Object this$startDate = this.getStartDate();
                                 Object other$startDate = other.getStartDate();
                                 if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof ProjectAreaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAreaDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", axis="
         + this.getAxis()
         + ", date="
         + this.getDate()
         + ", type="
         + this.getType()
         + ", productType="
         + this.getProductType()
         + ", sort="
         + this.getSort()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   public static class ProjectAreaDTOBuilder {
      private Long id;
      private String name;
      private String axis;
      private LocalDate date;
      private Integer type;
      private Integer productType;
      private Integer sort;
      private Long supplierId;
      private String supplierName;
      private LocalDate startDate;
      private LocalDate endDate;

      ProjectAreaDTOBuilder() {
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder axis(final String axis) {
         this.axis = axis;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder date(final LocalDate date) {
         this.date = date;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ProjectAreaDTO.ProjectAreaDTOBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ProjectAreaDTO build() {
         return new ProjectAreaDTO(
            this.id, this.name, this.axis, this.date, this.type, this.productType, this.sort, this.supplierId, this.supplierName, this.startDate, this.endDate
         );
      }

      @Override
      public String toString() {
         return "ProjectAreaDTO.ProjectAreaDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", axis="
            + this.axis
            + ", date="
            + this.date
            + ", type="
            + this.type
            + ", productType="
            + this.productType
            + ", sort="
            + this.sort
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
