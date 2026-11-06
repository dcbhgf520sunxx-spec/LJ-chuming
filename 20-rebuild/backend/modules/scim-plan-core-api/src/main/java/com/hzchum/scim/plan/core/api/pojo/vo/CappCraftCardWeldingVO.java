package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "CAPP 焊接产品焊缝列表 响应参数")
public class CappCraftCardWeldingVO {
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   private String weldingSerialNumber;
   @ApiModelProperty(name = "techCappCraftCardStorehouseSerialNumber", value = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "weldingBaseWeldingPosition", value = "焊接位置", notes = "焊接位置")
   private String weldingBaseWeldingPosition;
   @ApiModelProperty(name = "cappCraftCardPassVOS", value = "道次列表", notes = "道次列表")
   private List<CappCraftCardPassVO> cappCraftCardPassVOS;

   public static CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder builder() {
      return new CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder();
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public String getWeldingBaseWeldingPosition() {
      return this.weldingBaseWeldingPosition;
   }

   public List<CappCraftCardPassVO> getCappCraftCardPassVOS() {
      return this.cappCraftCardPassVOS;
   }

   public void setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setWeldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
   }

   public void setCappCraftCardPassVOS(final List<CappCraftCardPassVO> cappCraftCardPassVOS) {
      this.cappCraftCardPassVOS = cappCraftCardPassVOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingVO)) {
         return false;
      }

      CappCraftCardWeldingVO other = (CappCraftCardWeldingVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$weldingSerialNumber = this.getWeldingSerialNumber();
      Object other$weldingSerialNumber = other.getWeldingSerialNumber();
      if (this$weldingSerialNumber == null ? other$weldingSerialNumber == null : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
         Object this$techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
         Object other$techCappCraftCardStorehouseSerialNumber = other.getTechCappCraftCardStorehouseSerialNumber();
         if (this$techCappCraftCardStorehouseSerialNumber == null
            ? other$techCappCraftCardStorehouseSerialNumber == null
            : this$techCappCraftCardStorehouseSerialNumber.equals(other$techCappCraftCardStorehouseSerialNumber)) {
            Object this$weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
            Object other$weldingBaseWeldingPosition = other.getWeldingBaseWeldingPosition();
            if (this$weldingBaseWeldingPosition == null
               ? other$weldingBaseWeldingPosition == null
               : this$weldingBaseWeldingPosition.equals(other$weldingBaseWeldingPosition)) {
               Object this$cappCraftCardPassVOS = this.getCappCraftCardPassVOS();
               Object other$cappCraftCardPassVOS = other.getCappCraftCardPassVOS();
               return this$cappCraftCardPassVOS == null ? other$cappCraftCardPassVOS == null : this$cappCraftCardPassVOS.equals(other$cappCraftCardPassVOS);
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
      return other instanceof CappCraftCardWeldingVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      result = result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
      Object $weldingBaseWeldingPosition = this.getWeldingBaseWeldingPosition();
      result = result * 59 + ($weldingBaseWeldingPosition == null ? 43 : $weldingBaseWeldingPosition.hashCode());
      Object $cappCraftCardPassVOS = this.getCappCraftCardPassVOS();
      return result * 59 + ($cappCraftCardPassVOS == null ? 43 : $cappCraftCardPassVOS.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingVO(weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", weldingBaseWeldingPosition="
         + this.getWeldingBaseWeldingPosition()
         + ", cappCraftCardPassVOS="
         + this.getCappCraftCardPassVOS()
         + ")";
   }

   public CappCraftCardWeldingVO(
      final String weldingSerialNumber,
      final String techCappCraftCardStorehouseSerialNumber,
      final String weldingBaseWeldingPosition,
      final List<CappCraftCardPassVO> cappCraftCardPassVOS
   ) {
      this.weldingSerialNumber = weldingSerialNumber;
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
      this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
      this.cappCraftCardPassVOS = cappCraftCardPassVOS;
   }

   public CappCraftCardWeldingVO() {
   }

   public static class CappCraftCardWeldingVOBuilder {
      private String weldingSerialNumber;
      private String techCappCraftCardStorehouseSerialNumber;
      private String weldingBaseWeldingPosition;
      private List<CappCraftCardPassVO> cappCraftCardPassVOS;

      CappCraftCardWeldingVOBuilder() {
      }

      public CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder weldingSerialNumber(final String weldingSerialNumber) {
         this.weldingSerialNumber = weldingSerialNumber;
         return this;
      }

      public CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder techCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
         this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
         return this;
      }

      public CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder weldingBaseWeldingPosition(final String weldingBaseWeldingPosition) {
         this.weldingBaseWeldingPosition = weldingBaseWeldingPosition;
         return this;
      }

      public CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder cappCraftCardPassVOS(final List<CappCraftCardPassVO> cappCraftCardPassVOS) {
         this.cappCraftCardPassVOS = cappCraftCardPassVOS;
         return this;
      }

      public CappCraftCardWeldingVO build() {
         return new CappCraftCardWeldingVO(
            this.weldingSerialNumber, this.techCappCraftCardStorehouseSerialNumber, this.weldingBaseWeldingPosition, this.cappCraftCardPassVOS
         );
      }

      @Override
      public String toString() {
         return "CappCraftCardWeldingVO.CappCraftCardWeldingVOBuilder(weldingSerialNumber="
            + this.weldingSerialNumber
            + ", techCappCraftCardStorehouseSerialNumber="
            + this.techCappCraftCardStorehouseSerialNumber
            + ", weldingBaseWeldingPosition="
            + this.weldingBaseWeldingPosition
            + ", cappCraftCardPassVOS="
            + this.cappCraftCardPassVOS
            + ")";
      }
   }
}
