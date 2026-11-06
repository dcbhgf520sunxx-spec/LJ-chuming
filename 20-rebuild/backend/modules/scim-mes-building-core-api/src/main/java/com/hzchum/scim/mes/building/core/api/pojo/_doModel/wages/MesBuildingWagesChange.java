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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWagesChange对象", description = "")
@TableName("mes_building_wages_change")
@Table(name = "mes_building_wages_change")
public class MesBuildingWagesChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @ApiModelProperty(name = "newPrice", value = "新价格", notes = "新价格")
   @JsonProperty("newPrice")
   @JSONField(name = "newPrice")
   @TableField("new_price")
   @Column(name = "new_price", columnDefinition = "decimal(19,2)  COMMENT '新价格'", nullable = false)
   private BigDecimal newPrice;
   @ApiModelProperty(name = "oldPrice", value = "旧价格", notes = "旧价格")
   @JsonProperty("oldPrice")
   @JSONField(name = "oldPrice")
   @TableField("old_price")
   @Column(name = "old_price", columnDefinition = "decimal(19,2)  COMMENT '旧价格'", nullable = false)
   private BigDecimal oldPrice;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "changeAuditId", value = "审核id", notes = "审核id")
   @JsonProperty("changeAuditId")
   @JSONField(name = "changeAuditId")
   @TableField("change_audit_id")
   @Column(name = "change_audit_id", columnDefinition = "bigint(20)  COMMENT '审核id'", nullable = false)
   private Long changeAuditId;
   @ApiModelProperty(name = "boolUsedEnum", value = "是否使用中", notes = "是否使用中")
   @JsonProperty("boolUsedEnum")
   @JSONField(name = "boolUsedEnum")
   @TableField("bool_used_enum")
   @Column(name = "bool_used_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否使用中'", nullable = false)
   private Boolean boolUsedEnum;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   @TableField("wage_quota_type")
   @Column(name = "wage_quota_type", columnDefinition = "int(11)  COMMENT '计价方式'", nullable = false)
   private Integer wageQuotaType;

   public static MesBuildingWagesChange.MesBuildingWagesChangeBuilder builder() {
      return new MesBuildingWagesChange.MesBuildingWagesChangeBuilder();
   }

   public MesBuildingWagesChange() {
   }

   public MesBuildingWagesChange(
      final Long id,
      final Integer productType,
      final Long productId,
      final Long processId,
      final BigDecimal newPrice,
      final BigDecimal oldPrice,
      final Long teamId,
      final Long changeAuditId,
      final Boolean boolUsedEnum,
      final Integer wageQuotaType
   ) {
      this.id = id;
      this.productType = productType;
      this.productId = productId;
      this.processId = processId;
      this.newPrice = newPrice;
      this.oldPrice = oldPrice;
      this.teamId = teamId;
      this.changeAuditId = changeAuditId;
      this.boolUsedEnum = boolUsedEnum;
      this.wageQuotaType = wageQuotaType;
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

   public BigDecimal getNewPrice() {
      return this.newPrice;
   }

   public BigDecimal getOldPrice() {
      return this.oldPrice;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getChangeAuditId() {
      return this.changeAuditId;
   }

   public Boolean getBoolUsedEnum() {
      return this.boolUsedEnum;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   @JsonProperty("id")
   public MesBuildingWagesChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingWagesChange setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingWagesChange setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingWagesChange setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("newPrice")
   public MesBuildingWagesChange setNewPrice(final BigDecimal newPrice) {
      this.newPrice = newPrice;
      return this;
   }

   @JsonProperty("oldPrice")
   public MesBuildingWagesChange setOldPrice(final BigDecimal oldPrice) {
      this.oldPrice = oldPrice;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingWagesChange setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("changeAuditId")
   public MesBuildingWagesChange setChangeAuditId(final Long changeAuditId) {
      this.changeAuditId = changeAuditId;
      return this;
   }

   @JsonProperty("boolUsedEnum")
   public MesBuildingWagesChange setBoolUsedEnum(final Boolean boolUsedEnum) {
      this.boolUsedEnum = boolUsedEnum;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesBuildingWagesChange setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWagesChange(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", newPrice="
         + this.getNewPrice()
         + ", oldPrice="
         + this.getOldPrice()
         + ", teamId="
         + this.getTeamId()
         + ", changeAuditId="
         + this.getChangeAuditId()
         + ", boolUsedEnum="
         + this.getBoolUsedEnum()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWagesChange)) {
         return false;
      }

      MesBuildingWagesChange other = (MesBuildingWagesChange)o;
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
                  Object this$teamId = this.getTeamId();
                  Object other$teamId = other.getTeamId();
                  if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                     Object this$changeAuditId = this.getChangeAuditId();
                     Object other$changeAuditId = other.getChangeAuditId();
                     if (this$changeAuditId == null ? other$changeAuditId == null : this$changeAuditId.equals(other$changeAuditId)) {
                        Object this$boolUsedEnum = this.getBoolUsedEnum();
                        Object other$boolUsedEnum = other.getBoolUsedEnum();
                        if (this$boolUsedEnum == null ? other$boolUsedEnum == null : this$boolUsedEnum.equals(other$boolUsedEnum)) {
                           Object this$wageQuotaType = this.getWageQuotaType();
                           Object other$wageQuotaType = other.getWageQuotaType();
                           if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                              Object this$newPrice = this.getNewPrice();
                              Object other$newPrice = other.getNewPrice();
                              if (this$newPrice == null ? other$newPrice == null : this$newPrice.equals(other$newPrice)) {
                                 Object this$oldPrice = this.getOldPrice();
                                 Object other$oldPrice = other.getOldPrice();
                                 return this$oldPrice == null ? other$oldPrice == null : this$oldPrice.equals(other$oldPrice);
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
      return other instanceof MesBuildingWagesChange;
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
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $changeAuditId = this.getChangeAuditId();
      result = result * 59 + ($changeAuditId == null ? 43 : $changeAuditId.hashCode());
      Object $boolUsedEnum = this.getBoolUsedEnum();
      result = result * 59 + ($boolUsedEnum == null ? 43 : $boolUsedEnum.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $newPrice = this.getNewPrice();
      result = result * 59 + ($newPrice == null ? 43 : $newPrice.hashCode());
      Object $oldPrice = this.getOldPrice();
      return result * 59 + ($oldPrice == null ? 43 : $oldPrice.hashCode());
   }

   public static class MesBuildingWagesChangeBuilder {
      private Long id;
      private Integer productType;
      private Long productId;
      private Long processId;
      private BigDecimal newPrice;
      private BigDecimal oldPrice;
      private Long teamId;
      private Long changeAuditId;
      private Boolean boolUsedEnum;
      private Integer wageQuotaType;

      MesBuildingWagesChangeBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("newPrice")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder newPrice(final BigDecimal newPrice) {
         this.newPrice = newPrice;
         return this;
      }

      @JsonProperty("oldPrice")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder oldPrice(final BigDecimal oldPrice) {
         this.oldPrice = oldPrice;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("changeAuditId")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder changeAuditId(final Long changeAuditId) {
         this.changeAuditId = changeAuditId;
         return this;
      }

      @JsonProperty("boolUsedEnum")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder boolUsedEnum(final Boolean boolUsedEnum) {
         this.boolUsedEnum = boolUsedEnum;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesBuildingWagesChange.MesBuildingWagesChangeBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesBuildingWagesChange build() {
         return new MesBuildingWagesChange(
            this.id,
            this.productType,
            this.productId,
            this.processId,
            this.newPrice,
            this.oldPrice,
            this.teamId,
            this.changeAuditId,
            this.boolUsedEnum,
            this.wageQuotaType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWagesChange.MesBuildingWagesChangeBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", processId="
            + this.processId
            + ", newPrice="
            + this.newPrice
            + ", oldPrice="
            + this.oldPrice
            + ", teamId="
            + this.teamId
            + ", changeAuditId="
            + this.changeAuditId
            + ", boolUsedEnum="
            + this.boolUsedEnum
            + ", wageQuotaType="
            + this.wageQuotaType
            + ")";
      }
   }
}
