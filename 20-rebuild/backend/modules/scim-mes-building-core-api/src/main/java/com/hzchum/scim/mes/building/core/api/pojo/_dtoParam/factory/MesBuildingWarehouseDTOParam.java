package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "MesBuildingWarehouse对象", description = "库位表")
public class MesBuildingWarehouseDTOParam {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @NotBlank(message = "请填写库位名称!")
   @ApiModelProperty(name = "name", value = "库位名称", notes = "库位名称")
   private String name;
   @NotNull(message = "请先选择车间!")
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @Max(value = 2147483647L, message = "排序数值过大!")
   @Min(value = 1L, message = "排序数值过大!")
   private Integer sort;
   @Size(max = 255, message = "备注超出字数限制(255字)!")
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder builder() {
      return new MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder();
   }

   public MesBuildingWarehouseDTOParam() {
   }

   public MesBuildingWarehouseDTOParam(final Long id, final String name, final Long workshopId, final Integer sort, final String remark) {
      this.id = id;
      this.name = name;
      this.workshopId = workshopId;
      this.sort = sort;
      this.remark = remark;
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

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseDTOParam)) {
         return false;
      }

      MesBuildingWarehouseDTOParam other = (MesBuildingWarehouseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWarehouseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class MesBuildingWarehouseDTOParamBuilder {
      private Long id;
      private String name;
      private Long workshopId;
      private Integer sort;
      private String remark;

      MesBuildingWarehouseDTOParamBuilder() {
      }

      public MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingWarehouseDTOParam build() {
         return new MesBuildingWarehouseDTOParam(this.id, this.name, this.workshopId, this.sort, this.remark);
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseDTOParam.MesBuildingWarehouseDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", workshopId="
            + this.workshopId
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
