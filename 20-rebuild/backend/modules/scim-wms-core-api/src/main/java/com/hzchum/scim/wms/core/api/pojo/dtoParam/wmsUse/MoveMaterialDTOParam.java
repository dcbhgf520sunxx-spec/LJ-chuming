package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;
import javax.validation.constraints.NotNull;

public class MoveMaterialDTOParam {
   @NotNull(message = "移库办理目标仓库存储位置不能为空")
   private Long directionWarehouseId;
   @NotNull(message = "移库办理目标仓库不能为空")
   private Long directionWorkshopId;
   private List<MoveMaterialDetailDTOParam> detailList;
   private String remark;
   private Integer reviewStatus;

   public static MoveMaterialDTOParam.MoveMaterialDTOParamBuilder builder() {
      return new MoveMaterialDTOParam.MoveMaterialDTOParamBuilder();
   }

   public Long getDirectionWarehouseId() {
      return this.directionWarehouseId;
   }

   public Long getDirectionWorkshopId() {
      return this.directionWorkshopId;
   }

   public List<MoveMaterialDetailDTOParam> getDetailList() {
      return this.detailList;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setDirectionWarehouseId(final Long directionWarehouseId) {
      this.directionWarehouseId = directionWarehouseId;
   }

   public void setDirectionWorkshopId(final Long directionWorkshopId) {
      this.directionWorkshopId = directionWorkshopId;
   }

   public void setDetailList(final List<MoveMaterialDetailDTOParam> detailList) {
      this.detailList = detailList;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDTOParam)) {
         return false;
      }

      MoveMaterialDTOParam other = (MoveMaterialDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$directionWarehouseId = this.getDirectionWarehouseId();
      Object other$directionWarehouseId = other.getDirectionWarehouseId();
      if (this$directionWarehouseId == null ? other$directionWarehouseId == null : this$directionWarehouseId.equals(other$directionWarehouseId)) {
         Object this$directionWorkshopId = this.getDirectionWorkshopId();
         Object other$directionWorkshopId = other.getDirectionWorkshopId();
         if (this$directionWorkshopId == null ? other$directionWorkshopId == null : this$directionWorkshopId.equals(other$directionWorkshopId)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$detailList = this.getDetailList();
               Object other$detailList = other.getDetailList();
               if (this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList)) {
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
      return other instanceof MoveMaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $directionWarehouseId = this.getDirectionWarehouseId();
      result = result * 59 + ($directionWarehouseId == null ? 43 : $directionWarehouseId.hashCode());
      Object $directionWorkshopId = this.getDirectionWorkshopId();
      result = result * 59 + ($directionWorkshopId == null ? 43 : $directionWorkshopId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $detailList = this.getDetailList();
      result = result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialDTOParam(directionWarehouseId="
         + this.getDirectionWarehouseId()
         + ", directionWorkshopId="
         + this.getDirectionWorkshopId()
         + ", detailList="
         + this.getDetailList()
         + ", remark="
         + this.getRemark()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public MoveMaterialDTOParam(
      final Long directionWarehouseId,
      final Long directionWorkshopId,
      final List<MoveMaterialDetailDTOParam> detailList,
      final String remark,
      final Integer reviewStatus
   ) {
      this.directionWarehouseId = directionWarehouseId;
      this.directionWorkshopId = directionWorkshopId;
      this.detailList = detailList;
      this.remark = remark;
      this.reviewStatus = reviewStatus;
   }

   public MoveMaterialDTOParam() {
   }

   public static class MoveMaterialDTOParamBuilder {
      private Long directionWarehouseId;
      private Long directionWorkshopId;
      private List<MoveMaterialDetailDTOParam> detailList;
      private String remark;
      private Integer reviewStatus;

      MoveMaterialDTOParamBuilder() {
      }

      public MoveMaterialDTOParam.MoveMaterialDTOParamBuilder directionWarehouseId(final Long directionWarehouseId) {
         this.directionWarehouseId = directionWarehouseId;
         return this;
      }

      public MoveMaterialDTOParam.MoveMaterialDTOParamBuilder directionWorkshopId(final Long directionWorkshopId) {
         this.directionWorkshopId = directionWorkshopId;
         return this;
      }

      public MoveMaterialDTOParam.MoveMaterialDTOParamBuilder detailList(final List<MoveMaterialDetailDTOParam> detailList) {
         this.detailList = detailList;
         return this;
      }

      public MoveMaterialDTOParam.MoveMaterialDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MoveMaterialDTOParam.MoveMaterialDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public MoveMaterialDTOParam build() {
         return new MoveMaterialDTOParam(this.directionWarehouseId, this.directionWorkshopId, this.detailList, this.remark, this.reviewStatus);
      }

      @Override
      public String toString() {
         return "MoveMaterialDTOParam.MoveMaterialDTOParamBuilder(directionWarehouseId="
            + this.directionWarehouseId
            + ", directionWorkshopId="
            + this.directionWorkshopId
            + ", detailList="
            + this.detailList
            + ", remark="
            + this.remark
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
