package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

public class DeviceDetailDTO {
   @ApiModelProperty(name = "receiveDetailId", value = "物联领用明细id(物联领用明细id)")
   @JsonProperty("receiveDetailId")
   @JSONField(name = "receiveDetailId")
   @TableField("receive_detail_id")
   @Column(name = "receive_detail_id", columnDefinition = "bigint(20) COMMENT '物联领用明细id(物联领用明细id)'", nullable = true)
   private Long receiveDetailId;
   @ApiModelProperty(name = "receiveId", value = "物联设备配件领料单id(物联设备配件领料)")
   @JsonProperty("receiveId")
   @JSONField(name = "receiveId")
   @TableField("receive_id")
   @Column(name = "receive_id", columnDefinition = "bigint(20) COMMENT '物联设备配件领料单id(物联设备配件领料)'", nullable = true)
   private Long receiveId;
   @ApiModelProperty(name = "amount", value = "总价", notes = "总价")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '总价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价", notes = "不含税总价")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_vat")
   @Column(name = "amount_excluding_vat", columnDefinition = "decimal(32,12)  COMMENT '不含税总价'", nullable = true)
   private BigDecimal amountExcludingVat;

   public static DeviceDetailDTO.DeviceDetailDTOBuilder builder() {
      return new DeviceDetailDTO.DeviceDetailDTOBuilder();
   }

   public Long getReceiveDetailId() {
      return this.receiveDetailId;
   }

   public Long getReceiveId() {
      return this.receiveId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   @JsonProperty("receiveDetailId")
   public void setReceiveDetailId(final Long receiveDetailId) {
      this.receiveDetailId = receiveDetailId;
   }

   @JsonProperty("receiveId")
   public void setReceiveId(final Long receiveId) {
      this.receiveId = receiveId;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("amountExcludingVat")
   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceDetailDTO)) {
         return false;
      }

      DeviceDetailDTO other = (DeviceDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$receiveDetailId = this.getReceiveDetailId();
      Object other$receiveDetailId = other.getReceiveDetailId();
      if (this$receiveDetailId == null ? other$receiveDetailId == null : this$receiveDetailId.equals(other$receiveDetailId)) {
         Object this$receiveId = this.getReceiveId();
         Object other$receiveId = other.getReceiveId();
         if (this$receiveId == null ? other$receiveId == null : this$receiveId.equals(other$receiveId)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountExcludingVat = this.getAmountExcludingVat();
               Object other$amountExcludingVat = other.getAmountExcludingVat();
               return this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat);
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
      return other instanceof DeviceDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receiveDetailId = this.getReceiveDetailId();
      result = result * 59 + ($receiveDetailId == null ? 43 : $receiveDetailId.hashCode());
      Object $receiveId = this.getReceiveId();
      result = result * 59 + ($receiveId == null ? 43 : $receiveId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      return result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceDetailDTO(receiveDetailId="
         + this.getReceiveDetailId()
         + ", receiveId="
         + this.getReceiveId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ")";
   }

   public DeviceDetailDTO(final Long receiveDetailId, final Long receiveId, final BigDecimal amount, final BigDecimal amountExcludingVat) {
      this.receiveDetailId = receiveDetailId;
      this.receiveId = receiveId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
   }

   public DeviceDetailDTO() {
   }

   public static class DeviceDetailDTOBuilder {
      private Long receiveDetailId;
      private Long receiveId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;

      DeviceDetailDTOBuilder() {
      }

      @JsonProperty("receiveDetailId")
      public DeviceDetailDTO.DeviceDetailDTOBuilder receiveDetailId(final Long receiveDetailId) {
         this.receiveDetailId = receiveDetailId;
         return this;
      }

      @JsonProperty("receiveId")
      public DeviceDetailDTO.DeviceDetailDTOBuilder receiveId(final Long receiveId) {
         this.receiveId = receiveId;
         return this;
      }

      @JsonProperty("amount")
      public DeviceDetailDTO.DeviceDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public DeviceDetailDTO.DeviceDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public DeviceDetailDTO build() {
         return new DeviceDetailDTO(this.receiveDetailId, this.receiveId, this.amount, this.amountExcludingVat);
      }

      @Override
      public String toString() {
         return "DeviceDetailDTO.DeviceDetailDTOBuilder(receiveDetailId="
            + this.receiveDetailId
            + ", receiveId="
            + this.receiveId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ")";
      }
   }
}
