package com.hzchum.scim.project.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "SubBusinessCheckDetail对象", description = "分包商务审核详情 ")
@Entity
@TableName("project_sub_business_check_detail")
@Table(name = "project_sub_business_check_detail")
public class SubBusinessCheckDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "checkInfoId", value = "审核信息id")
   @Column
   private Long checkInfoId;
   @ApiModelProperty(name = "businessId", value = "结构商务id")
   @Column
   private Long businessId;
   @ApiModelProperty(name = "oldUnitPrice", value = "原有单价")
   @Column
   private BigDecimal oldUnitPrice;
   @ApiModelProperty(name = "newUnitPrice", value = "原有单价")
   @Column
   private BigDecimal newUnitPrice;

   public static SubBusinessCheckDetail.SubBusinessCheckDetailBuilder builder() {
      return new SubBusinessCheckDetail.SubBusinessCheckDetailBuilder();
   }

   public SubBusinessCheckDetail() {
   }

   public SubBusinessCheckDetail(final Long id, final Long checkInfoId, final Long businessId, final BigDecimal oldUnitPrice, final BigDecimal newUnitPrice) {
      this.id = id;
      this.checkInfoId = checkInfoId;
      this.businessId = businessId;
      this.oldUnitPrice = oldUnitPrice;
      this.newUnitPrice = newUnitPrice;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCheckInfoId() {
      return this.checkInfoId;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getOldUnitPrice() {
      return this.oldUnitPrice;
   }

   public BigDecimal getNewUnitPrice() {
      return this.newUnitPrice;
   }

   public SubBusinessCheckDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public SubBusinessCheckDetail setCheckInfoId(final Long checkInfoId) {
      this.checkInfoId = checkInfoId;
      return this;
   }

   public SubBusinessCheckDetail setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public SubBusinessCheckDetail setOldUnitPrice(final BigDecimal oldUnitPrice) {
      this.oldUnitPrice = oldUnitPrice;
      return this;
   }

   public SubBusinessCheckDetail setNewUnitPrice(final BigDecimal newUnitPrice) {
      this.newUnitPrice = newUnitPrice;
      return this;
   }

   @Override
   public String toString() {
      return "SubBusinessCheckDetail(id="
         + this.getId()
         + ", checkInfoId="
         + this.getCheckInfoId()
         + ", businessId="
         + this.getBusinessId()
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessCheckDetail)) {
         return false;
      }

      SubBusinessCheckDetail other = (SubBusinessCheckDetail)o;
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
            Object this$businessId = this.getBusinessId();
            Object other$businessId = other.getBusinessId();
            if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
               Object this$oldUnitPrice = this.getOldUnitPrice();
               Object other$oldUnitPrice = other.getOldUnitPrice();
               if (this$oldUnitPrice == null ? other$oldUnitPrice == null : this$oldUnitPrice.equals(other$oldUnitPrice)) {
                  Object this$newUnitPrice = this.getNewUnitPrice();
                  Object other$newUnitPrice = other.getNewUnitPrice();
                  return this$newUnitPrice == null ? other$newUnitPrice == null : this$newUnitPrice.equals(other$newUnitPrice);
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
      return other instanceof SubBusinessCheckDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $checkInfoId = this.getCheckInfoId();
      result = result * 59 + ($checkInfoId == null ? 43 : $checkInfoId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      return result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
   }

   public static class SubBusinessCheckDetailBuilder {
      private Long id;
      private Long checkInfoId;
      private Long businessId;
      private BigDecimal oldUnitPrice;
      private BigDecimal newUnitPrice;

      SubBusinessCheckDetailBuilder() {
      }

      public SubBusinessCheckDetail.SubBusinessCheckDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubBusinessCheckDetail.SubBusinessCheckDetailBuilder checkInfoId(final Long checkInfoId) {
         this.checkInfoId = checkInfoId;
         return this;
      }

      public SubBusinessCheckDetail.SubBusinessCheckDetailBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public SubBusinessCheckDetail.SubBusinessCheckDetailBuilder oldUnitPrice(final BigDecimal oldUnitPrice) {
         this.oldUnitPrice = oldUnitPrice;
         return this;
      }

      public SubBusinessCheckDetail.SubBusinessCheckDetailBuilder newUnitPrice(final BigDecimal newUnitPrice) {
         this.newUnitPrice = newUnitPrice;
         return this;
      }

      public SubBusinessCheckDetail build() {
         return new SubBusinessCheckDetail(this.id, this.checkInfoId, this.businessId, this.oldUnitPrice, this.newUnitPrice);
      }

      @Override
      public String toString() {
         return "SubBusinessCheckDetail.SubBusinessCheckDetailBuilder(id="
            + this.id
            + ", checkInfoId="
            + this.checkInfoId
            + ", businessId="
            + this.businessId
            + ", oldUnitPrice="
            + this.oldUnitPrice
            + ", newUnitPrice="
            + this.newUnitPrice
            + ")";
      }
   }
}
