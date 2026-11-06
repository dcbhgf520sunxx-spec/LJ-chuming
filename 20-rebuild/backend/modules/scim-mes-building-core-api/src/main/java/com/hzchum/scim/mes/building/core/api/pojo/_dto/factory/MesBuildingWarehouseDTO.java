package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingWarehouse对象", description = "仓库表")
public class MesBuildingWarehouseDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "库位名称", notes = "库位名称")
   private String name;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "workshop", value = "所属车间", notes = "所属车间")
   private NameInfo workshop;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "boolEnableEnum", value = "启用状态 1启用 0禁用", notes = "启用状态 1启用 0禁用")
   private Boolean boolEnableEnum;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   private Long createUserId;

   public static MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder builder() {
      return new MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder();
   }

   public MesBuildingWarehouseDTO() {
   }

   public MesBuildingWarehouseDTO(
      final Long id,
      final String name,
      final Long workshopId,
      final NameInfo workshop,
      final Long factoryId,
      final Boolean boolEnableEnum,
      final Integer sort,
      final String remark,
      final Long createUserId
   ) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
      this.workshop = workshop;
      this.factoryId = factoryId;
      this.boolEnableEnum = boolEnableEnum;
      this.sort = sort;
      this.remark = remark;
      this.createUserId = createUserId;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Boolean getBoolEnableEnum() {
      return this.boolEnableEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setBoolEnableEnum(final Boolean boolEnableEnum) {
      this.boolEnableEnum = boolEnableEnum;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseDTO)) {
         return false;
      }

      MesBuildingWarehouseDTO other = (MesBuildingWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$boolEnableEnum = this.getBoolEnableEnum();
               Object other$boolEnableEnum = other.getBoolEnableEnum();
               if (this$boolEnableEnum == null ? other$boolEnableEnum == null : this$boolEnableEnum.equals(other$boolEnableEnum)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$remark = this.getRemark();
                              Object other$remark = other.getRemark();
                              return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesBuildingWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $boolEnableEnum = this.getBoolEnableEnum();
      result = result * 59 + ($boolEnableEnum == null ? 43 : $boolEnableEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshop="
         + this.getWorkshop()
         + ", factoryId="
         + this.getFactoryId()
         + ", boolEnableEnum="
         + this.getBoolEnableEnum()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", createUserId="
         + this.getCreateUserId()
         + ")";
   }

   public static class MesBuildingWarehouseDTOBuilder {
      private Long id;
      private String name;
      private Long workshopId;
      private NameInfo workshop;
      private Long factoryId;
      private Boolean boolEnableEnum;
      private Integer sort;
      private String remark;
      private Long createUserId;

      MesBuildingWarehouseDTOBuilder() {
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder boolEnableEnum(final Boolean boolEnableEnum) {
         this.boolEnableEnum = boolEnableEnum;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public MesBuildingWarehouseDTO build() {
         return new MesBuildingWarehouseDTO(
            this.id, this.name, this.workshopId, this.workshop, this.factoryId, this.boolEnableEnum, this.sort, this.remark, this.createUserId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseDTO.MesBuildingWarehouseDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", workshop="
            + this.workshop
            + ", factoryId="
            + this.factoryId
            + ", boolEnableEnum="
            + this.boolEnableEnum
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", createUserId="
            + this.createUserId
            + ")";
      }
   }
}
