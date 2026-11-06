package com.hzchum.scim.plan.core.api.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class TechSerialNumberQuantityVO {
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", value = "零件和构件的数量比例")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "artifactRecordId", value = "构件审核表Id")
   @JsonProperty("artifactRecordId")
   @JSONField(name = "artifactRecordId")
   private Long artifactRecordId;

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getArtifactRecordId() {
      return this.artifactRecordId;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("artifactRecordId")
   public void setArtifactRecordId(final Long artifactRecordId) {
      this.artifactRecordId = artifactRecordId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechSerialNumberQuantityVO)) {
         return false;
      }

      TechSerialNumberQuantityVO other = (TechSerialNumberQuantityVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$artifactRecordId = this.getArtifactRecordId();
         Object other$artifactRecordId = other.getArtifactRecordId();
         if (this$artifactRecordId == null ? other$artifactRecordId == null : this$artifactRecordId.equals(other$artifactRecordId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechSerialNumberQuantityVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $artifactRecordId = this.getArtifactRecordId();
      result = result * 59 + ($artifactRecordId == null ? 43 : $artifactRecordId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "TechSerialNumberQuantityVO(serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ", artifactRecordId="
         + this.getArtifactRecordId()
         + ")";
   }
}
