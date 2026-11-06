package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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

@ApiModel(value = "WasteSaleDetail对象", description = "废料出售明细表 ")
@Entity
@TableName("wms_waste_sale_detail")
@Table(name = "wms_waste_sale_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_waste_sale_detail", comment = "废料出售明细表 ")
public class WasteSaleDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "WasteSaleId", value = "废料销售表id", notes = "废料销售表id")
   @TableField("waste_sale_id")
   @Column(name = "waste_sale_id", columnDefinition = "bigint(20)  COMMENT '废料销售表id'", nullable = false)
   private Long wasteSaleId;
   @ApiModelProperty(name = "wasteClassificationId", value = "废料种类表id", notes = "废料种类表id")
   @TableField("waste_classification_id")
   @Column(name = "waste_classification_id", columnDefinition = "bigint(20)  COMMENT '废料种类表id'", nullable = false)
   private Long wasteClassificationId;
   @ApiModelProperty(name = "saleMete", value = "销量", notes = "销量")
   @TableField("sale_mete")
   @Column(name = "sale_mete", columnDefinition = "decimal(32,4)  COMMENT '销量'", nullable = false)
   private BigDecimal saleMete;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,4)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "amount", value = "金额(元) = 销量*单价", notes = "金额(元) = 销量*单价")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,4)  COMMENT '金额(元) = 销量*单价'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatusEnum;

   public static WasteSaleDetail.WasteSaleDetailBuilder builder() {
      return new WasteSaleDetail.WasteSaleDetailBuilder();
   }

   public WasteSaleDetail() {
   }

   public WasteSaleDetail(
      final Long id,
      final Long wasteSaleId,
      final Long wasteClassificationId,
      final BigDecimal saleMete,
      final BigDecimal price,
      final BigDecimal amount,
      final String remark,
      final Integer auditStatusEnum
   ) {
      this.id = id;
      this.wasteSaleId = wasteSaleId;
      this.wasteClassificationId = wasteClassificationId;
      this.saleMete = saleMete;
      this.price = price;
      this.amount = amount;
      this.remark = remark;
      this.auditStatusEnum = auditStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWasteSaleId() {
      return this.wasteSaleId;
   }

   public Long getWasteClassificationId() {
      return this.wasteClassificationId;
   }

   public BigDecimal getSaleMete() {
      return this.saleMete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public WasteSaleDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WasteSaleDetail setWasteSaleId(final Long wasteSaleId) {
      this.wasteSaleId = wasteSaleId;
      return this;
   }

   public WasteSaleDetail setWasteClassificationId(final Long wasteClassificationId) {
      this.wasteClassificationId = wasteClassificationId;
      return this;
   }

   public WasteSaleDetail setSaleMete(final BigDecimal saleMete) {
      this.saleMete = saleMete;
      return this;
   }

   public WasteSaleDetail setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public WasteSaleDetail setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public WasteSaleDetail setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public WasteSaleDetail setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "WasteSaleDetail(id="
         + this.getId()
         + ", wasteSaleId="
         + this.getWasteSaleId()
         + ", wasteClassificationId="
         + this.getWasteClassificationId()
         + ", saleMete="
         + this.getSaleMete()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSaleDetail)) {
         return false;
      }

      WasteSaleDetail other = (WasteSaleDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$wasteSaleId = this.getWasteSaleId();
         Object other$wasteSaleId = other.getWasteSaleId();
         if (this$wasteSaleId == null ? other$wasteSaleId == null : this$wasteSaleId.equals(other$wasteSaleId)) {
            Object this$wasteClassificationId = this.getWasteClassificationId();
            Object other$wasteClassificationId = other.getWasteClassificationId();
            if (this$wasteClassificationId == null ? other$wasteClassificationId == null : this$wasteClassificationId.equals(other$wasteClassificationId)) {
               Object this$auditStatusEnum = this.getAuditStatusEnum();
               Object other$auditStatusEnum = other.getAuditStatusEnum();
               if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                  Object this$saleMete = this.getSaleMete();
                  Object other$saleMete = other.getSaleMete();
                  if (this$saleMete == null ? other$saleMete == null : this$saleMete.equals(other$saleMete)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$amount = this.getAmount();
                        Object other$amount = other.getAmount();
                        if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
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
      return other instanceof WasteSaleDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $wasteSaleId = this.getWasteSaleId();
      result = result * 59 + ($wasteSaleId == null ? 43 : $wasteSaleId.hashCode());
      Object $wasteClassificationId = this.getWasteClassificationId();
      result = result * 59 + ($wasteClassificationId == null ? 43 : $wasteClassificationId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $saleMete = this.getSaleMete();
      result = result * 59 + ($saleMete == null ? 43 : $saleMete.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WasteSaleDetailBuilder {
      private Long id;
      private Long wasteSaleId;
      private Long wasteClassificationId;
      private BigDecimal saleMete;
      private BigDecimal price;
      private BigDecimal amount;
      private String remark;
      private Integer auditStatusEnum;

      WasteSaleDetailBuilder() {
      }

      public WasteSaleDetail.WasteSaleDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder wasteSaleId(final Long wasteSaleId) {
         this.wasteSaleId = wasteSaleId;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder wasteClassificationId(final Long wasteClassificationId) {
         this.wasteClassificationId = wasteClassificationId;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder saleMete(final BigDecimal saleMete) {
         this.saleMete = saleMete;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WasteSaleDetail.WasteSaleDetailBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSaleDetail build() {
         return new WasteSaleDetail(
            this.id, this.wasteSaleId, this.wasteClassificationId, this.saleMete, this.price, this.amount, this.remark, this.auditStatusEnum
         );
      }

      @Override
      public String toString() {
         return "WasteSaleDetail.WasteSaleDetailBuilder(id="
            + this.id
            + ", wasteSaleId="
            + this.wasteSaleId
            + ", wasteClassificationId="
            + this.wasteClassificationId
            + ", saleMete="
            + this.saleMete
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ")";
      }
   }
}
