package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class QueryMaterialManufacturedDTOParam {
   @ApiModelProperty("基础物料类型")
   private Integer basicClass;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("制成品名称")
   private String manufacturedName;
   @ApiModelProperty("制成品编号")
   private String manufacturedSn;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("颜色")
   private String color;
   @ApiModelProperty("品牌")
   private String brand;
   @ApiModelProperty("仓库ID")
   private Long workshopId;
   @ApiModelProperty("仓库ID集合")
   private List<Long> workshopIds;
   @ApiModelProperty("仓库位置ID")
   private Long warehouseId;

   public static QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder builder() {
      return new QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder();
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
   }

   public void setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryMaterialManufacturedDTOParam)) {
         return false;
      }

      QueryMaterialManufacturedDTOParam other = (QueryMaterialManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$warehouseId = this.getWarehouseId();
                     Object other$warehouseId = other.getWarehouseId();
                     if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                        Object this$manufacturedName = this.getManufacturedName();
                        Object other$manufacturedName = other.getManufacturedName();
                        if (this$manufacturedName == null ? other$manufacturedName == null : this$manufacturedName.equals(other$manufacturedName)) {
                           Object this$manufacturedSn = this.getManufacturedSn();
                           Object other$manufacturedSn = other.getManufacturedSn();
                           if (this$manufacturedSn == null ? other$manufacturedSn == null : this$manufacturedSn.equals(other$manufacturedSn)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$color = this.getColor();
                                 Object other$color = other.getColor();
                                 if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                       Object this$workshopIds = this.getWorkshopIds();
                                       Object other$workshopIds = other.getWorkshopIds();
                                       return this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryMaterialManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryMaterialManufacturedDTOParam(basicClass="
         + this.getBasicClass()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", projectId="
         + this.getProjectId()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", warehouseId="
         + this.getWarehouseId()
         + ")";
   }

   public QueryMaterialManufacturedDTOParam(
      final Integer basicClass,
      final Long monomerId,
      final Long areaId,
      final Long projectId,
      final String manufacturedName,
      final String manufacturedSn,
      final String specification,
      final String color,
      final String brand,
      final Long workshopId,
      final List<Long> workshopIds,
      final Long warehouseId
   ) {
      this.basicClass = basicClass;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.projectId = projectId;
      this.manufacturedName = manufacturedName;
      this.manufacturedSn = manufacturedSn;
      this.specification = specification;
      this.color = color;
      this.brand = brand;
      this.workshopId = workshopId;
      this.workshopIds = workshopIds;
      this.warehouseId = warehouseId;
   }

   public QueryMaterialManufacturedDTOParam() {
   }

   public static class QueryMaterialManufacturedDTOParamBuilder {
      private Integer basicClass;
      private Long monomerId;
      private Long areaId;
      private Long projectId;
      private String manufacturedName;
      private String manufacturedSn;
      private String specification;
      private String color;
      private String brand;
      private Long workshopId;
      private List<Long> workshopIds;
      private Long warehouseId;

      QueryMaterialManufacturedDTOParamBuilder() {
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryMaterialManufacturedDTOParam build() {
         return new QueryMaterialManufacturedDTOParam(
            this.basicClass,
            this.monomerId,
            this.areaId,
            this.projectId,
            this.manufacturedName,
            this.manufacturedSn,
            this.specification,
            this.color,
            this.brand,
            this.workshopId,
            this.workshopIds,
            this.warehouseId
         );
      }

      @Override
      public String toString() {
         return "QueryMaterialManufacturedDTOParam.QueryMaterialManufacturedDTOParamBuilder(basicClass="
            + this.basicClass
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", projectId="
            + this.projectId
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", workshopId="
            + this.workshopId
            + ", workshopIds="
            + this.workshopIds
            + ", warehouseId="
            + this.warehouseId
            + ")";
      }
   }
}
