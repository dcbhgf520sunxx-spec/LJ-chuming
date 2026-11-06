package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class PickingAllocationDTOParam {
   @ApiModelProperty(name = "pickingDetailIds", value = "领料明细ID集合")
   @NotNull(message = "领料明细ID集合不能为空")
   private List<Long> pickingDetailIds;
   @ApiModelProperty(name = "materialType", value = "领料类型")
   @NotNull(message = "领料类型不能为空")
   private String materialType;
   private List<MaterialDTOParam> materialDTOParams;

   public static PickingAllocationDTOParam.PickingAllocationDTOParamBuilder builder() {
      return new PickingAllocationDTOParam.PickingAllocationDTOParamBuilder();
   }

   public List<Long> getPickingDetailIds() {
      return this.pickingDetailIds;
   }

   public String getMaterialType() {
      return this.materialType;
   }

   public List<MaterialDTOParam> getMaterialDTOParams() {
      return this.materialDTOParams;
   }

   public void setPickingDetailIds(final List<Long> pickingDetailIds) {
      this.pickingDetailIds = pickingDetailIds;
   }

   public void setMaterialType(final String materialType) {
      this.materialType = materialType;
   }

   public void setMaterialDTOParams(final List<MaterialDTOParam> materialDTOParams) {
      this.materialDTOParams = materialDTOParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingAllocationDTOParam)) {
         return false;
      }

      PickingAllocationDTOParam other = (PickingAllocationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pickingDetailIds = this.getPickingDetailIds();
      Object other$pickingDetailIds = other.getPickingDetailIds();
      if (this$pickingDetailIds == null ? other$pickingDetailIds == null : this$pickingDetailIds.equals(other$pickingDetailIds)) {
         Object this$materialType = this.getMaterialType();
         Object other$materialType = other.getMaterialType();
         if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
            Object this$materialDTOParams = this.getMaterialDTOParams();
            Object other$materialDTOParams = other.getMaterialDTOParams();
            return this$materialDTOParams == null ? other$materialDTOParams == null : this$materialDTOParams.equals(other$materialDTOParams);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PickingAllocationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pickingDetailIds = this.getPickingDetailIds();
      result = result * 59 + ($pickingDetailIds == null ? 43 : $pickingDetailIds.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $materialDTOParams = this.getMaterialDTOParams();
      return result * 59 + ($materialDTOParams == null ? 43 : $materialDTOParams.hashCode());
   }

   @Override
   public String toString() {
      return "PickingAllocationDTOParam(pickingDetailIds="
         + this.getPickingDetailIds()
         + ", materialType="
         + this.getMaterialType()
         + ", materialDTOParams="
         + this.getMaterialDTOParams()
         + ")";
   }

   public PickingAllocationDTOParam(final List<Long> pickingDetailIds, final String materialType, final List<MaterialDTOParam> materialDTOParams) {
      this.pickingDetailIds = pickingDetailIds;
      this.materialType = materialType;
      this.materialDTOParams = materialDTOParams;
   }

   public PickingAllocationDTOParam() {
   }

   public static class PickingAllocationDTOParamBuilder {
      private List<Long> pickingDetailIds;
      private String materialType;
      private List<MaterialDTOParam> materialDTOParams;

      PickingAllocationDTOParamBuilder() {
      }

      public PickingAllocationDTOParam.PickingAllocationDTOParamBuilder pickingDetailIds(final List<Long> pickingDetailIds) {
         this.pickingDetailIds = pickingDetailIds;
         return this;
      }

      public PickingAllocationDTOParam.PickingAllocationDTOParamBuilder materialType(final String materialType) {
         this.materialType = materialType;
         return this;
      }

      public PickingAllocationDTOParam.PickingAllocationDTOParamBuilder materialDTOParams(final List<MaterialDTOParam> materialDTOParams) {
         this.materialDTOParams = materialDTOParams;
         return this;
      }

      public PickingAllocationDTOParam build() {
         return new PickingAllocationDTOParam(this.pickingDetailIds, this.materialType, this.materialDTOParams);
      }

      @Override
      public String toString() {
         return "PickingAllocationDTOParam.PickingAllocationDTOParamBuilder(pickingDetailIds="
            + this.pickingDetailIds
            + ", materialType="
            + this.materialType
            + ", materialDTOParams="
            + this.materialDTOParams
            + ")";
      }
   }
}
