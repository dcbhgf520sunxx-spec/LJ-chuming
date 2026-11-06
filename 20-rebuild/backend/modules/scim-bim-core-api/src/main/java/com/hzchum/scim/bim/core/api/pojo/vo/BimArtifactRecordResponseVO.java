package com.hzchum.scim.bim.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("bim构件操作数量响应类")
public class BimArtifactRecordResponseVO {
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "quantity", value = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "producedQuantity", value = "进入生产数量")
   private Integer producedQuantity;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量")
   private Integer inboundQuantity;
   @ApiModelProperty(name = "outboundQuantity", value = "出库数量")
   private Integer outboundQuantity;
   @ApiModelProperty(name = "installationQuantity", value = "安装数量")
   private Integer installationQuantity;
   @ApiModelProperty(name = "receiptQuantity", value = "收货数量")
   private Integer receiptQuantity;
   @ApiModelProperty(name = "unitSerialNumberList", value = "单元件编号集合")
   private List<String> unitSerialNumberList;

   public static BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder builder() {
      return new BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder();
   }

   public BimArtifactRecordResponseVO() {
   }

   public BimArtifactRecordResponseVO(
      final Long areaId,
      final String areaName,
      final Integer quantity,
      final Integer producedQuantity,
      final Integer inboundQuantity,
      final Integer outboundQuantity,
      final Integer installationQuantity,
      final Integer receiptQuantity,
      final List<String> unitSerialNumberList
   ) {
      this.areaId = areaId;
      this.areaName = areaName;
      this.quantity = quantity;
      this.producedQuantity = producedQuantity;
      this.inboundQuantity = inboundQuantity;
      this.outboundQuantity = outboundQuantity;
      this.installationQuantity = installationQuantity;
      this.receiptQuantity = receiptQuantity;
      this.unitSerialNumberList = unitSerialNumberList;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public Integer getInstallationQuantity() {
      return this.installationQuantity;
   }

   public Integer getReceiptQuantity() {
      return this.receiptQuantity;
   }

   public List<String> getUnitSerialNumberList() {
      return this.unitSerialNumberList;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setOutboundQuantity(final Integer outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setInstallationQuantity(final Integer installationQuantity) {
      this.installationQuantity = installationQuantity;
   }

   public void setReceiptQuantity(final Integer receiptQuantity) {
      this.receiptQuantity = receiptQuantity;
   }

   public void setUnitSerialNumberList(final List<String> unitSerialNumberList) {
      this.unitSerialNumberList = unitSerialNumberList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimArtifactRecordResponseVO)) {
         return false;
      }

      BimArtifactRecordResponseVO other = (BimArtifactRecordResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$areaId = this.getAreaId();
      Object other$areaId = other.getAreaId();
      if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$producedQuantity = this.getProducedQuantity();
            Object other$producedQuantity = other.getProducedQuantity();
            if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
               Object this$inboundQuantity = this.getInboundQuantity();
               Object other$inboundQuantity = other.getInboundQuantity();
               if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                  Object this$outboundQuantity = this.getOutboundQuantity();
                  Object other$outboundQuantity = other.getOutboundQuantity();
                  if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
                     Object this$installationQuantity = this.getInstallationQuantity();
                     Object other$installationQuantity = other.getInstallationQuantity();
                     if (this$installationQuantity == null ? other$installationQuantity == null : this$installationQuantity.equals(other$installationQuantity)) {
                        Object this$receiptQuantity = this.getReceiptQuantity();
                        Object other$receiptQuantity = other.getReceiptQuantity();
                        if (this$receiptQuantity == null ? other$receiptQuantity == null : this$receiptQuantity.equals(other$receiptQuantity)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$unitSerialNumberList = this.getUnitSerialNumberList();
                              Object other$unitSerialNumberList = other.getUnitSerialNumberList();
                              return this$unitSerialNumberList == null
                                 ? other$unitSerialNumberList == null
                                 : this$unitSerialNumberList.equals(other$unitSerialNumberList);
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
      return other instanceof BimArtifactRecordResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $installationQuantity = this.getInstallationQuantity();
      result = result * 59 + ($installationQuantity == null ? 43 : $installationQuantity.hashCode());
      Object $receiptQuantity = this.getReceiptQuantity();
      result = result * 59 + ($receiptQuantity == null ? 43 : $receiptQuantity.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $unitSerialNumberList = this.getUnitSerialNumberList();
      return result * 59 + ($unitSerialNumberList == null ? 43 : $unitSerialNumberList.hashCode());
   }

   @Override
   public String toString() {
      return "BimArtifactRecordResponseVO(areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", quantity="
         + this.getQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", installationQuantity="
         + this.getInstallationQuantity()
         + ", receiptQuantity="
         + this.getReceiptQuantity()
         + ", unitSerialNumberList="
         + this.getUnitSerialNumberList()
         + ")";
   }

   public static class BimArtifactRecordResponseVOBuilder {
      private Long areaId;
      private String areaName;
      private Integer quantity;
      private Integer producedQuantity;
      private Integer inboundQuantity;
      private Integer outboundQuantity;
      private Integer installationQuantity;
      private Integer receiptQuantity;
      private List<String> unitSerialNumberList;

      BimArtifactRecordResponseVOBuilder() {
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder outboundQuantity(final Integer outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder installationQuantity(final Integer installationQuantity) {
         this.installationQuantity = installationQuantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder receiptQuantity(final Integer receiptQuantity) {
         this.receiptQuantity = receiptQuantity;
         return this;
      }

      public BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder unitSerialNumberList(final List<String> unitSerialNumberList) {
         this.unitSerialNumberList = unitSerialNumberList;
         return this;
      }

      public BimArtifactRecordResponseVO build() {
         return new BimArtifactRecordResponseVO(
            this.areaId,
            this.areaName,
            this.quantity,
            this.producedQuantity,
            this.inboundQuantity,
            this.outboundQuantity,
            this.installationQuantity,
            this.receiptQuantity,
            this.unitSerialNumberList
         );
      }

      @Override
      public String toString() {
         return "BimArtifactRecordResponseVO.BimArtifactRecordResponseVOBuilder(areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", quantity="
            + this.quantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", installationQuantity="
            + this.installationQuantity
            + ", receiptQuantity="
            + this.receiptQuantity
            + ", unitSerialNumberList="
            + this.unitSerialNumberList
            + ")";
      }
   }
}
