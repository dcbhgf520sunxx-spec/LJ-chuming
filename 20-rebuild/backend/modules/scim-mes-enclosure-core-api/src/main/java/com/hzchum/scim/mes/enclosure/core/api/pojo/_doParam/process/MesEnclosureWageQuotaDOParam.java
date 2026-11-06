package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureWageQuotaDOParam对象", description = "")
public class MesEnclosureWageQuotaDOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "weightPrice", notes = "重量价格")
   @JsonProperty("weightPrice")
   @JSONField(name = "weightPrice")
   private BigDecimal weightPrice;
   @ApiModelProperty(name = "lengthPrice", notes = "长度价格")
   @JsonProperty("lengthPrice")
   @JSONField(name = "lengthPrice")
   private BigDecimal lengthPrice;
   @ApiModelProperty(name = "areaPice", notes = "面积价格")
   @JsonProperty("areaPice")
   @JSONField(name = "areaPice")
   private BigDecimal areaPice;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder builder() {
      return new MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder();
   }

   public MesEnclosureWageQuotaDOParam() {
   }

   public MesEnclosureWageQuotaDOParam(
      final Long id,
      final Long productProcessId,
      final Long processId,
      final Integer wageQuotaType,
      final BigDecimal weightPrice,
      final BigDecimal lengthPrice,
      final BigDecimal areaPice,
      final Long userId
   ) {
      this.id = id;
      this.productProcessId = productProcessId;
      this.processId = processId;
      this.wageQuotaType = wageQuotaType;
      this.weightPrice = weightPrice;
      this.lengthPrice = lengthPrice;
      this.areaPice = areaPice;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getWeightPrice() {
      return this.weightPrice;
   }

   public BigDecimal getLengthPrice() {
      return this.lengthPrice;
   }

   public BigDecimal getAreaPice() {
      return this.areaPice;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesEnclosureWageQuotaDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesEnclosureWageQuotaDOParam setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureWageQuotaDOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesEnclosureWageQuotaDOParam setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("weightPrice")
   public MesEnclosureWageQuotaDOParam setWeightPrice(final BigDecimal weightPrice) {
      this.weightPrice = weightPrice;
      return this;
   }

   @JsonProperty("lengthPrice")
   public MesEnclosureWageQuotaDOParam setLengthPrice(final BigDecimal lengthPrice) {
      this.lengthPrice = lengthPrice;
      return this;
   }

   @JsonProperty("areaPice")
   public MesEnclosureWageQuotaDOParam setAreaPice(final BigDecimal areaPice) {
      this.areaPice = areaPice;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureWageQuotaDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureWageQuotaDOParam(id="
         + this.getId()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", processId="
         + this.getProcessId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", weightPrice="
         + this.getWeightPrice()
         + ", lengthPrice="
         + this.getLengthPrice()
         + ", areaPice="
         + this.getAreaPice()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWageQuotaDOParam)) {
         return false;
      }

      MesEnclosureWageQuotaDOParam other = (MesEnclosureWageQuotaDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productProcessId = this.getProductProcessId();
         Object other$productProcessId = other.getProductProcessId();
         if (this$productProcessId == null ? other$productProcessId == null : this$productProcessId.equals(other$productProcessId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$weightPrice = this.getWeightPrice();
                     Object other$weightPrice = other.getWeightPrice();
                     if (this$weightPrice == null ? other$weightPrice == null : this$weightPrice.equals(other$weightPrice)) {
                        Object this$lengthPrice = this.getLengthPrice();
                        Object other$lengthPrice = other.getLengthPrice();
                        if (this$lengthPrice == null ? other$lengthPrice == null : this$lengthPrice.equals(other$lengthPrice)) {
                           Object this$areaPice = this.getAreaPice();
                           Object other$areaPice = other.getAreaPice();
                           return this$areaPice == null ? other$areaPice == null : this$areaPice.equals(other$areaPice);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureWageQuotaDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $weightPrice = this.getWeightPrice();
      result = result * 59 + ($weightPrice == null ? 43 : $weightPrice.hashCode());
      Object $lengthPrice = this.getLengthPrice();
      result = result * 59 + ($lengthPrice == null ? 43 : $lengthPrice.hashCode());
      Object $areaPice = this.getAreaPice();
      return result * 59 + ($areaPice == null ? 43 : $areaPice.hashCode());
   }

   public static class MesEnclosureWageQuotaDOParamBuilder {
      private Long id;
      private Long productProcessId;
      private Long processId;
      private Integer wageQuotaType;
      private BigDecimal weightPrice;
      private BigDecimal lengthPrice;
      private BigDecimal areaPice;
      private Long userId;

      MesEnclosureWageQuotaDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("weightPrice")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder weightPrice(final BigDecimal weightPrice) {
         this.weightPrice = weightPrice;
         return this;
      }

      @JsonProperty("lengthPrice")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder lengthPrice(final BigDecimal lengthPrice) {
         this.lengthPrice = lengthPrice;
         return this;
      }

      @JsonProperty("areaPice")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder areaPice(final BigDecimal areaPice) {
         this.areaPice = areaPice;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesEnclosureWageQuotaDOParam build() {
         return new MesEnclosureWageQuotaDOParam(
            this.id, this.productProcessId, this.processId, this.wageQuotaType, this.weightPrice, this.lengthPrice, this.areaPice, this.userId
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureWageQuotaDOParam.MesEnclosureWageQuotaDOParamBuilder(id="
            + this.id
            + ", productProcessId="
            + this.productProcessId
            + ", processId="
            + this.processId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", weightPrice="
            + this.weightPrice
            + ", lengthPrice="
            + this.lengthPrice
            + ", areaPice="
            + this.areaPice
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
