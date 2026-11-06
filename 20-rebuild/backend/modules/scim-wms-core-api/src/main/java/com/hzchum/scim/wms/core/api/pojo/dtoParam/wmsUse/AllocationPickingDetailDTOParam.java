package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SplitMaterialDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingDetailDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class AllocationPickingDetailDTOParam {
   @ApiModelProperty("领料明细详情信息")
   private List<WmsPickingDetailDTO> wmsPickingDetailDTOList;
   @ApiModelProperty("拆分物料信息")
   private List<SplitMaterialDTO> splitMaterialDTOList;
   @ApiModelProperty("领料明细和物料对应信息")
   private List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams;
   @ApiModelProperty("最终分配的领料明细信息 -> 前端原封不动在传回来")
   private List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams;
   @ApiModelProperty("最终分配的物料数据信息 -> 前端原封不动在传回来")
   private List<MaterialBriefDTOParam> lastMaterialBriefDTOParams;
   @ApiModelProperty("齐套明细ID -> 前端传")
   private List<Long> completePickingDetailIds;
   @ApiModelProperty("涉及到的领料单ID集合 -> 前端传")
   private List<Long> pickingIds;

   public static AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder builder() {
      return new AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder();
   }

   public List<WmsPickingDetailDTO> getWmsPickingDetailDTOList() {
      return this.wmsPickingDetailDTOList;
   }

   public List<SplitMaterialDTO> getSplitMaterialDTOList() {
      return this.splitMaterialDTOList;
   }

   public List<PickingDetailAndMaterialDTOParam> getPickingDetailAndMaterialDTOParams() {
      return this.pickingDetailAndMaterialDTOParams;
   }

   public List<PickingDetailBriefDTOParam> getLastPickingDetailBriefDTOParams() {
      return this.lastPickingDetailBriefDTOParams;
   }

   public List<MaterialBriefDTOParam> getLastMaterialBriefDTOParams() {
      return this.lastMaterialBriefDTOParams;
   }

   public List<Long> getCompletePickingDetailIds() {
      return this.completePickingDetailIds;
   }

   public List<Long> getPickingIds() {
      return this.pickingIds;
   }

   public void setWmsPickingDetailDTOList(final List<WmsPickingDetailDTO> wmsPickingDetailDTOList) {
      this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
   }

   public void setSplitMaterialDTOList(final List<SplitMaterialDTO> splitMaterialDTOList) {
      this.splitMaterialDTOList = splitMaterialDTOList;
   }

   public void setPickingDetailAndMaterialDTOParams(final List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams) {
      this.pickingDetailAndMaterialDTOParams = pickingDetailAndMaterialDTOParams;
   }

   public void setLastPickingDetailBriefDTOParams(final List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams) {
      this.lastPickingDetailBriefDTOParams = lastPickingDetailBriefDTOParams;
   }

   public void setLastMaterialBriefDTOParams(final List<MaterialBriefDTOParam> lastMaterialBriefDTOParams) {
      this.lastMaterialBriefDTOParams = lastMaterialBriefDTOParams;
   }

   public void setCompletePickingDetailIds(final List<Long> completePickingDetailIds) {
      this.completePickingDetailIds = completePickingDetailIds;
   }

   public void setPickingIds(final List<Long> pickingIds) {
      this.pickingIds = pickingIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AllocationPickingDetailDTOParam)) {
         return false;
      }

      AllocationPickingDetailDTOParam other = (AllocationPickingDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
      Object other$wmsPickingDetailDTOList = other.getWmsPickingDetailDTOList();
      if (this$wmsPickingDetailDTOList == null ? other$wmsPickingDetailDTOList == null : this$wmsPickingDetailDTOList.equals(other$wmsPickingDetailDTOList)) {
         Object this$splitMaterialDTOList = this.getSplitMaterialDTOList();
         Object other$splitMaterialDTOList = other.getSplitMaterialDTOList();
         if (this$splitMaterialDTOList == null ? other$splitMaterialDTOList == null : this$splitMaterialDTOList.equals(other$splitMaterialDTOList)) {
            Object this$pickingDetailAndMaterialDTOParams = this.getPickingDetailAndMaterialDTOParams();
            Object other$pickingDetailAndMaterialDTOParams = other.getPickingDetailAndMaterialDTOParams();
            if (this$pickingDetailAndMaterialDTOParams == null
               ? other$pickingDetailAndMaterialDTOParams == null
               : this$pickingDetailAndMaterialDTOParams.equals(other$pickingDetailAndMaterialDTOParams)) {
               Object this$lastPickingDetailBriefDTOParams = this.getLastPickingDetailBriefDTOParams();
               Object other$lastPickingDetailBriefDTOParams = other.getLastPickingDetailBriefDTOParams();
               if (this$lastPickingDetailBriefDTOParams == null
                  ? other$lastPickingDetailBriefDTOParams == null
                  : this$lastPickingDetailBriefDTOParams.equals(other$lastPickingDetailBriefDTOParams)) {
                  Object this$lastMaterialBriefDTOParams = this.getLastMaterialBriefDTOParams();
                  Object other$lastMaterialBriefDTOParams = other.getLastMaterialBriefDTOParams();
                  if (this$lastMaterialBriefDTOParams == null
                     ? other$lastMaterialBriefDTOParams == null
                     : this$lastMaterialBriefDTOParams.equals(other$lastMaterialBriefDTOParams)) {
                     Object this$completePickingDetailIds = this.getCompletePickingDetailIds();
                     Object other$completePickingDetailIds = other.getCompletePickingDetailIds();
                     if (this$completePickingDetailIds == null
                        ? other$completePickingDetailIds == null
                        : this$completePickingDetailIds.equals(other$completePickingDetailIds)) {
                        Object this$pickingIds = this.getPickingIds();
                        Object other$pickingIds = other.getPickingIds();
                        return this$pickingIds == null ? other$pickingIds == null : this$pickingIds.equals(other$pickingIds);
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
      return other instanceof AllocationPickingDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
      result = result * 59 + ($wmsPickingDetailDTOList == null ? 43 : $wmsPickingDetailDTOList.hashCode());
      Object $splitMaterialDTOList = this.getSplitMaterialDTOList();
      result = result * 59 + ($splitMaterialDTOList == null ? 43 : $splitMaterialDTOList.hashCode());
      Object $pickingDetailAndMaterialDTOParams = this.getPickingDetailAndMaterialDTOParams();
      result = result * 59 + ($pickingDetailAndMaterialDTOParams == null ? 43 : $pickingDetailAndMaterialDTOParams.hashCode());
      Object $lastPickingDetailBriefDTOParams = this.getLastPickingDetailBriefDTOParams();
      result = result * 59 + ($lastPickingDetailBriefDTOParams == null ? 43 : $lastPickingDetailBriefDTOParams.hashCode());
      Object $lastMaterialBriefDTOParams = this.getLastMaterialBriefDTOParams();
      result = result * 59 + ($lastMaterialBriefDTOParams == null ? 43 : $lastMaterialBriefDTOParams.hashCode());
      Object $completePickingDetailIds = this.getCompletePickingDetailIds();
      result = result * 59 + ($completePickingDetailIds == null ? 43 : $completePickingDetailIds.hashCode());
      Object $pickingIds = this.getPickingIds();
      return result * 59 + ($pickingIds == null ? 43 : $pickingIds.hashCode());
   }

   @Override
   public String toString() {
      return "AllocationPickingDetailDTOParam(wmsPickingDetailDTOList="
         + this.getWmsPickingDetailDTOList()
         + ", splitMaterialDTOList="
         + this.getSplitMaterialDTOList()
         + ", pickingDetailAndMaterialDTOParams="
         + this.getPickingDetailAndMaterialDTOParams()
         + ", lastPickingDetailBriefDTOParams="
         + this.getLastPickingDetailBriefDTOParams()
         + ", lastMaterialBriefDTOParams="
         + this.getLastMaterialBriefDTOParams()
         + ", completePickingDetailIds="
         + this.getCompletePickingDetailIds()
         + ", pickingIds="
         + this.getPickingIds()
         + ")";
   }

   public AllocationPickingDetailDTOParam(
      final List<WmsPickingDetailDTO> wmsPickingDetailDTOList,
      final List<SplitMaterialDTO> splitMaterialDTOList,
      final List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams,
      final List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams,
      final List<MaterialBriefDTOParam> lastMaterialBriefDTOParams,
      final List<Long> completePickingDetailIds,
      final List<Long> pickingIds
   ) {
      this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
      this.splitMaterialDTOList = splitMaterialDTOList;
      this.pickingDetailAndMaterialDTOParams = pickingDetailAndMaterialDTOParams;
      this.lastPickingDetailBriefDTOParams = lastPickingDetailBriefDTOParams;
      this.lastMaterialBriefDTOParams = lastMaterialBriefDTOParams;
      this.completePickingDetailIds = completePickingDetailIds;
      this.pickingIds = pickingIds;
   }

   public AllocationPickingDetailDTOParam() {
   }

   public static class AllocationPickingDetailDTOParamBuilder {
      private List<WmsPickingDetailDTO> wmsPickingDetailDTOList;
      private List<SplitMaterialDTO> splitMaterialDTOList;
      private List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams;
      private List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams;
      private List<MaterialBriefDTOParam> lastMaterialBriefDTOParams;
      private List<Long> completePickingDetailIds;
      private List<Long> pickingIds;

      AllocationPickingDetailDTOParamBuilder() {
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder wmsPickingDetailDTOList(
         final List<WmsPickingDetailDTO> wmsPickingDetailDTOList
      ) {
         this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder splitMaterialDTOList(final List<SplitMaterialDTO> splitMaterialDTOList) {
         this.splitMaterialDTOList = splitMaterialDTOList;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder pickingDetailAndMaterialDTOParams(
         final List<PickingDetailAndMaterialDTOParam> pickingDetailAndMaterialDTOParams
      ) {
         this.pickingDetailAndMaterialDTOParams = pickingDetailAndMaterialDTOParams;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder lastPickingDetailBriefDTOParams(
         final List<PickingDetailBriefDTOParam> lastPickingDetailBriefDTOParams
      ) {
         this.lastPickingDetailBriefDTOParams = lastPickingDetailBriefDTOParams;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder lastMaterialBriefDTOParams(
         final List<MaterialBriefDTOParam> lastMaterialBriefDTOParams
      ) {
         this.lastMaterialBriefDTOParams = lastMaterialBriefDTOParams;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder completePickingDetailIds(final List<Long> completePickingDetailIds) {
         this.completePickingDetailIds = completePickingDetailIds;
         return this;
      }

      public AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder pickingIds(final List<Long> pickingIds) {
         this.pickingIds = pickingIds;
         return this;
      }

      public AllocationPickingDetailDTOParam build() {
         return new AllocationPickingDetailDTOParam(
            this.wmsPickingDetailDTOList,
            this.splitMaterialDTOList,
            this.pickingDetailAndMaterialDTOParams,
            this.lastPickingDetailBriefDTOParams,
            this.lastMaterialBriefDTOParams,
            this.completePickingDetailIds,
            this.pickingIds
         );
      }

      @Override
      public String toString() {
         return "AllocationPickingDetailDTOParam.AllocationPickingDetailDTOParamBuilder(wmsPickingDetailDTOList="
            + this.wmsPickingDetailDTOList
            + ", splitMaterialDTOList="
            + this.splitMaterialDTOList
            + ", pickingDetailAndMaterialDTOParams="
            + this.pickingDetailAndMaterialDTOParams
            + ", lastPickingDetailBriefDTOParams="
            + this.lastPickingDetailBriefDTOParams
            + ", lastMaterialBriefDTOParams="
            + this.lastMaterialBriefDTOParams
            + ", completePickingDetailIds="
            + this.completePickingDetailIds
            + ", pickingIds="
            + this.pickingIds
            + ")";
      }
   }
}
