package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessProductionControlCheckDetail对象", description = "商务管理-生产控制审核详情 ")
@TableName("business_production_control_check_detail")
@Table(name = "business_production_control_check_detail")
public class BusinessProductionControlCheckDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "checkInfoId", value = "审核信息id")
   @JsonProperty("checkInfoId")
   @JSONField(name = "checkInfoId")
   @TableField("check_info_id")
   @Column(name = "check_info_id")
   private Long checkInfoId;
   @ApiModelProperty(name = "productionControlId", value = "生产控制id")
   @JsonProperty("productionControlId")
   @JSONField(name = "productionControlId")
   @TableField("production_control_id")
   @Column(name = "production_control_id")
   private Long productionControlId;
   @ApiModelProperty(name = "oldBoolEnableEnum", value = "原有启用状态")
   @JsonProperty("oldBoolEnableEnum")
   @JSONField(name = "oldBoolEnableEnum")
   @TableField("old_bool_enable_enum")
   @Column(name = "old_bool_enable_enum")
   private Boolean oldBoolEnableEnum;
   @ApiModelProperty(name = "newBoolEnableEnum", value = "新启用状态")
   @JsonProperty("newBoolEnableEnum")
   @JSONField(name = "newBoolEnableEnum")
   @TableField("new_bool_enable_enum")
   @Column(name = "new_bool_enable_enum")
   private Boolean newBoolEnableEnum;
   @ApiModelProperty(name = "oldLossFactor", value = "原有系数")
   @JsonProperty("oldLossFactor")
   @JSONField(name = "oldLossFactor")
   @TableField("old_loss_factor")
   @Column(name = "old_loss_factor")
   private BigDecimal oldLossFactor;
   @ApiModelProperty(name = "newLossFactor", value = "新系数")
   @JsonProperty("newLossFactor")
   @JSONField(name = "newLossFactor")
   @TableField("new_loss_factor")
   @Column(name = "new_loss_factor")
   private BigDecimal newLossFactor;

   public static BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder builder() {
      return new BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder();
   }

   public BusinessProductionControlCheckDetail() {
   }

   public BusinessProductionControlCheckDetail(
      final Long id,
      final Long checkInfoId,
      final Long productionControlId,
      final Boolean oldBoolEnableEnum,
      final Boolean newBoolEnableEnum,
      final BigDecimal oldLossFactor,
      final BigDecimal newLossFactor
   ) {
      this.id = id;
      this.checkInfoId = checkInfoId;
      this.productionControlId = productionControlId;
      this.oldBoolEnableEnum = oldBoolEnableEnum;
      this.newBoolEnableEnum = newBoolEnableEnum;
      this.oldLossFactor = oldLossFactor;
      this.newLossFactor = newLossFactor;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCheckInfoId() {
      return this.checkInfoId;
   }

   public Long getProductionControlId() {
      return this.productionControlId;
   }

   public Boolean getOldBoolEnableEnum() {
      return this.oldBoolEnableEnum;
   }

   public Boolean getNewBoolEnableEnum() {
      return this.newBoolEnableEnum;
   }

   public BigDecimal getOldLossFactor() {
      return this.oldLossFactor;
   }

   public BigDecimal getNewLossFactor() {
      return this.newLossFactor;
   }

   @JsonProperty("id")
   public BusinessProductionControlCheckDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("checkInfoId")
   public BusinessProductionControlCheckDetail setCheckInfoId(final Long checkInfoId) {
      this.checkInfoId = checkInfoId;
      return this;
   }

   @JsonProperty("productionControlId")
   public BusinessProductionControlCheckDetail setProductionControlId(final Long productionControlId) {
      this.productionControlId = productionControlId;
      return this;
   }

   @JsonProperty("oldBoolEnableEnum")
   public BusinessProductionControlCheckDetail setOldBoolEnableEnum(final Boolean oldBoolEnableEnum) {
      this.oldBoolEnableEnum = oldBoolEnableEnum;
      return this;
   }

   @JsonProperty("newBoolEnableEnum")
   public BusinessProductionControlCheckDetail setNewBoolEnableEnum(final Boolean newBoolEnableEnum) {
      this.newBoolEnableEnum = newBoolEnableEnum;
      return this;
   }

   @JsonProperty("oldLossFactor")
   public BusinessProductionControlCheckDetail setOldLossFactor(final BigDecimal oldLossFactor) {
      this.oldLossFactor = oldLossFactor;
      return this;
   }

   @JsonProperty("newLossFactor")
   public BusinessProductionControlCheckDetail setNewLossFactor(final BigDecimal newLossFactor) {
      this.newLossFactor = newLossFactor;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessProductionControlCheckDetail(id="
         + this.getId()
         + ", checkInfoId="
         + this.getCheckInfoId()
         + ", productionControlId="
         + this.getProductionControlId()
         + ", oldBoolEnableEnum="
         + this.getOldBoolEnableEnum()
         + ", newBoolEnableEnum="
         + this.getNewBoolEnableEnum()
         + ", oldLossFactor="
         + this.getOldLossFactor()
         + ", newLossFactor="
         + this.getNewLossFactor()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessProductionControlCheckDetail)) {
         return false;
      }

      BusinessProductionControlCheckDetail other = (BusinessProductionControlCheckDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$checkInfoId = this.getCheckInfoId();
         Object other$checkInfoId = other.getCheckInfoId();
         if (this$checkInfoId == null ? other$checkInfoId == null : this$checkInfoId.equals(other$checkInfoId)) {
            Object this$productionControlId = this.getProductionControlId();
            Object other$productionControlId = other.getProductionControlId();
            if (this$productionControlId == null ? other$productionControlId == null : this$productionControlId.equals(other$productionControlId)) {
               Object this$oldBoolEnableEnum = this.getOldBoolEnableEnum();
               Object other$oldBoolEnableEnum = other.getOldBoolEnableEnum();
               if (this$oldBoolEnableEnum == null ? other$oldBoolEnableEnum == null : this$oldBoolEnableEnum.equals(other$oldBoolEnableEnum)) {
                  Object this$newBoolEnableEnum = this.getNewBoolEnableEnum();
                  Object other$newBoolEnableEnum = other.getNewBoolEnableEnum();
                  if (this$newBoolEnableEnum == null ? other$newBoolEnableEnum == null : this$newBoolEnableEnum.equals(other$newBoolEnableEnum)) {
                     Object this$oldLossFactor = this.getOldLossFactor();
                     Object other$oldLossFactor = other.getOldLossFactor();
                     if (this$oldLossFactor == null ? other$oldLossFactor == null : this$oldLossFactor.equals(other$oldLossFactor)) {
                        Object this$newLossFactor = this.getNewLossFactor();
                        Object other$newLossFactor = other.getNewLossFactor();
                        return this$newLossFactor == null ? other$newLossFactor == null : this$newLossFactor.equals(other$newLossFactor);
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
      return other instanceof BusinessProductionControlCheckDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkInfoId = this.getCheckInfoId();
      result = result * 59 + ($checkInfoId == null ? 43 : $checkInfoId.hashCode());
      Object $productionControlId = this.getProductionControlId();
      result = result * 59 + ($productionControlId == null ? 43 : $productionControlId.hashCode());
      Object $oldBoolEnableEnum = this.getOldBoolEnableEnum();
      result = result * 59 + ($oldBoolEnableEnum == null ? 43 : $oldBoolEnableEnum.hashCode());
      Object $newBoolEnableEnum = this.getNewBoolEnableEnum();
      result = result * 59 + ($newBoolEnableEnum == null ? 43 : $newBoolEnableEnum.hashCode());
      Object $oldLossFactor = this.getOldLossFactor();
      result = result * 59 + ($oldLossFactor == null ? 43 : $oldLossFactor.hashCode());
      Object $newLossFactor = this.getNewLossFactor();
      return result * 59 + ($newLossFactor == null ? 43 : $newLossFactor.hashCode());
   }

   public static class BusinessProductionControlCheckDetailBuilder {
      private Long id;
      private Long checkInfoId;
      private Long productionControlId;
      private Boolean oldBoolEnableEnum;
      private Boolean newBoolEnableEnum;
      private BigDecimal oldLossFactor;
      private BigDecimal newLossFactor;

      BusinessProductionControlCheckDetailBuilder() {
      }

      @JsonProperty("id")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("checkInfoId")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder checkInfoId(final Long checkInfoId) {
         this.checkInfoId = checkInfoId;
         return this;
      }

      @JsonProperty("productionControlId")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder productionControlId(final Long productionControlId) {
         this.productionControlId = productionControlId;
         return this;
      }

      @JsonProperty("oldBoolEnableEnum")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder oldBoolEnableEnum(final Boolean oldBoolEnableEnum) {
         this.oldBoolEnableEnum = oldBoolEnableEnum;
         return this;
      }

      @JsonProperty("newBoolEnableEnum")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder newBoolEnableEnum(final Boolean newBoolEnableEnum) {
         this.newBoolEnableEnum = newBoolEnableEnum;
         return this;
      }

      @JsonProperty("oldLossFactor")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder oldLossFactor(final BigDecimal oldLossFactor) {
         this.oldLossFactor = oldLossFactor;
         return this;
      }

      @JsonProperty("newLossFactor")
      public BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder newLossFactor(final BigDecimal newLossFactor) {
         this.newLossFactor = newLossFactor;
         return this;
      }

      public BusinessProductionControlCheckDetail build() {
         return new BusinessProductionControlCheckDetail(
            this.id, this.checkInfoId, this.productionControlId, this.oldBoolEnableEnum, this.newBoolEnableEnum, this.oldLossFactor, this.newLossFactor
         );
      }

      @Override
      public String toString() {
         return "BusinessProductionControlCheckDetail.BusinessProductionControlCheckDetailBuilder(id="
            + this.id
            + ", checkInfoId="
            + this.checkInfoId
            + ", productionControlId="
            + this.productionControlId
            + ", oldBoolEnableEnum="
            + this.oldBoolEnableEnum
            + ", newBoolEnableEnum="
            + this.newBoolEnableEnum
            + ", oldLossFactor="
            + this.oldLossFactor
            + ", newLossFactor="
            + this.newLossFactor
            + ")";
      }
   }
}
