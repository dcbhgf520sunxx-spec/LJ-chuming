package com.hzchum.scim.mes.building.core.api.pojo._doModel.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPriceChange对象", description = "")
@Entity
@TableName("mes_building_price_change")
@Table(name = "mes_building_price_change")
public class MesBuildingPriceChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "wage", value = "单价", notes = "新价格")
   @JsonProperty("wage")
   @JSONField(name = "wage")
   @TableField("wage")
   @Column(name = "wage", columnDefinition = "decimal(19,2)  COMMENT '新价格'")
   private BigDecimal wage;
   @ApiModelProperty(name = "primerWage", value = "底漆价格", notes = "底漆价格")
   @JsonProperty("primerWage")
   @JSONField(name = "primerWage")
   @TableField("primer_wage")
   @Column(name = "primer_wage", columnDefinition = "decimal(19,2)  COMMENT '底漆价格'")
   private BigDecimal primerWage;
   @ApiModelProperty(name = "intermediatePaintWage", value = "中间漆价格", notes = "中间漆价格")
   @JsonProperty("intermediatePaintWage")
   @JSONField(name = "intermediatePaintWage")
   @TableField("intermediate_paint_wage")
   @Column(name = "intermediate_paint_wage", columnDefinition = "decimal(19,2)  COMMENT '中间漆价格'")
   private BigDecimal intermediatePaintWage;
   @ApiModelProperty(name = "topcoatWage", value = "面漆单价", notes = "面漆单价")
   @JsonProperty("topcoatWage")
   @JSONField(name = "topcoatWage")
   @TableField("topcoat_wage")
   @Column(name = "topcoat_wage", columnDefinition = "decimal(19,2)  COMMENT '面漆单价'")
   private BigDecimal topcoatWage;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '计价方式'", nullable = false)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "userId", value = "工序id", notes = "工序id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long userId;

   public static MesBuildingPriceChange.MesBuildingPriceChangeBuilder builder() {
      return new MesBuildingPriceChange.MesBuildingPriceChangeBuilder();
   }

   public MesBuildingPriceChange() {
   }

   public MesBuildingPriceChange(
      final Long id,
      final Integer productType,
      final Long productId,
      final Long processId,
      final BigDecimal wage,
      final BigDecimal primerWage,
      final BigDecimal intermediatePaintWage,
      final BigDecimal topcoatWage,
      final Integer wageQuotaType,
      final Long userId
   ) {
      this.id = id;
      this.productType = productType;
      this.productId = productId;
      this.processId = processId;
      this.wage = wage;
      this.primerWage = primerWage;
      this.intermediatePaintWage = intermediatePaintWage;
      this.topcoatWage = topcoatWage;
      this.wageQuotaType = wageQuotaType;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getPrimerWage() {
      return this.primerWage;
   }

   public BigDecimal getIntermediatePaintWage() {
      return this.intermediatePaintWage;
   }

   public BigDecimal getTopcoatWage() {
      return this.topcoatWage;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingPriceChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingPriceChange setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingPriceChange setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingPriceChange setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("wage")
   public MesBuildingPriceChange setWage(final BigDecimal wage) {
      this.wage = wage;
      return this;
   }

   @JsonProperty("primerWage")
   public MesBuildingPriceChange setPrimerWage(final BigDecimal primerWage) {
      this.primerWage = primerWage;
      return this;
   }

   @JsonProperty("intermediatePaintWage")
   public MesBuildingPriceChange setIntermediatePaintWage(final BigDecimal intermediatePaintWage) {
      this.intermediatePaintWage = intermediatePaintWage;
      return this;
   }

   @JsonProperty("topcoatWage")
   public MesBuildingPriceChange setTopcoatWage(final BigDecimal topcoatWage) {
      this.topcoatWage = topcoatWage;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingPriceChange setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingPriceChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPriceChange(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", wage="
         + this.getWage()
         + ", primerWage="
         + this.getPrimerWage()
         + ", intermediatePaintWage="
         + this.getIntermediatePaintWage()
         + ", topcoatWage="
         + this.getTopcoatWage()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPriceChange)) {
         return false;
      }

      MesBuildingPriceChange other = (MesBuildingPriceChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$wageQuotaType = this.getWageQuotaType();
                  Object other$wageQuotaType = other.getWageQuotaType();
                  if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$wage = this.getWage();
                        Object other$wage = other.getWage();
                        if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                           Object this$primerWage = this.getPrimerWage();
                           Object other$primerWage = other.getPrimerWage();
                           if (this$primerWage == null ? other$primerWage == null : this$primerWage.equals(other$primerWage)) {
                              Object this$intermediatePaintWage = this.getIntermediatePaintWage();
                              Object other$intermediatePaintWage = other.getIntermediatePaintWage();
                              if (this$intermediatePaintWage == null
                                 ? other$intermediatePaintWage == null
                                 : this$intermediatePaintWage.equals(other$intermediatePaintWage)) {
                                 Object this$topcoatWage = this.getTopcoatWage();
                                 Object other$topcoatWage = other.getTopcoatWage();
                                 return this$topcoatWage == null ? other$topcoatWage == null : this$topcoatWage.equals(other$topcoatWage);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPriceChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $primerWage = this.getPrimerWage();
      result = result * 59 + ($primerWage == null ? 43 : $primerWage.hashCode());
      Object $intermediatePaintWage = this.getIntermediatePaintWage();
      result = result * 59 + ($intermediatePaintWage == null ? 43 : $intermediatePaintWage.hashCode());
      Object $topcoatWage = this.getTopcoatWage();
      return result * 59 + ($topcoatWage == null ? 43 : $topcoatWage.hashCode());
   }

   public static class MesBuildingPriceChangeBuilder {
      private Long id;
      private Integer productType;
      private Long productId;
      private Long processId;
      private BigDecimal wage;
      private BigDecimal primerWage;
      private BigDecimal intermediatePaintWage;
      private BigDecimal topcoatWage;
      private Integer wageQuotaType;
      private Long userId;

      MesBuildingPriceChangeBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("wage")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder wage(final BigDecimal wage) {
         this.wage = wage;
         return this;
      }

      @JsonProperty("primerWage")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder primerWage(final BigDecimal primerWage) {
         this.primerWage = primerWage;
         return this;
      }

      @JsonProperty("intermediatePaintWage")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder intermediatePaintWage(final BigDecimal intermediatePaintWage) {
         this.intermediatePaintWage = intermediatePaintWage;
         return this;
      }

      @JsonProperty("topcoatWage")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder topcoatWage(final BigDecimal topcoatWage) {
         this.topcoatWage = topcoatWage;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingPriceChange.MesBuildingPriceChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingPriceChange build() {
         return new MesBuildingPriceChange(
            this.id,
            this.productType,
            this.productId,
            this.processId,
            this.wage,
            this.primerWage,
            this.intermediatePaintWage,
            this.topcoatWage,
            this.wageQuotaType,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPriceChange.MesBuildingPriceChangeBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", processId="
            + this.processId
            + ", wage="
            + this.wage
            + ", primerWage="
            + this.primerWage
            + ", intermediatePaintWage="
            + this.intermediatePaintWage
            + ", topcoatWage="
            + this.topcoatWage
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
