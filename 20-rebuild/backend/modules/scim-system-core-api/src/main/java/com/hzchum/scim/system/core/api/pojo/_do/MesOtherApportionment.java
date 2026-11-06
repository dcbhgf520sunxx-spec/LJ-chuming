package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "MesOtherApportionment对象", description = "其他分摊表")
@Entity
@TableName("mes_other_apportionment")
@Table(name = "mes_other_apportionment")
@org.hibernate.annotations.Table(appliesTo = "mes_other_apportionment", comment = "其他分摊表")
public class MesOtherApportionment extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   @TableField("type")
   @Column(name = "type", columnDefinition = "varchar(255)  COMMENT '类型'", nullable = true)
   private String type;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) default '吨' COMMENT '计量单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default 1 COMMENT '状态'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "workshopId", value = "车间ID", notes = "车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "inventoryQuantity", value = "入库量(吨)", notes = "入库量(吨)")
   @TableField("inventory_quantity")
   @Column(name = "inventory_quantity", columnDefinition = "decimal(32,8)  COMMENT '入库量(吨)'", nullable = true)
   private BigDecimal inventoryQuantity;

   public static MesOtherApportionment.MesOtherApportionmentBuilder builder() {
      return new MesOtherApportionment.MesOtherApportionmentBuilder();
   }

   public MesOtherApportionment() {
   }

   public MesOtherApportionment(
      final Long id,
      final String type,
      final String unit,
      final BigDecimal price,
      final Boolean status,
      final Long workshopId,
      final BigDecimal inventoryQuantity
   ) {
      this.id = id;
      this.type = type;
      this.unit = unit;
      this.price = price;
      this.status = status;
      this.workshopId = workshopId;
      this.inventoryQuantity = inventoryQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public BigDecimal getInventoryQuantity() {
      return this.inventoryQuantity;
   }

   public MesOtherApportionment setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesOtherApportionment setType(final String type) {
      this.type = type;
      return this;
   }

   public MesOtherApportionment setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesOtherApportionment setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesOtherApportionment setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public MesOtherApportionment setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesOtherApportionment setInventoryQuantity(final BigDecimal inventoryQuantity) {
      this.inventoryQuantity = inventoryQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesOtherApportionment(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ", status="
         + this.getStatus()
         + ", workshopId="
         + this.getWorkshopId()
         + ", inventoryQuantity="
         + this.getInventoryQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesOtherApportionment)) {
         return false;
      }

      MesOtherApportionment other = (MesOtherApportionment)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$unit = this.getUnit();
                  Object other$unit = other.getUnit();
                  if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$inventoryQuantity = this.getInventoryQuantity();
                        Object other$inventoryQuantity = other.getInventoryQuantity();
                        return this$inventoryQuantity == null ? other$inventoryQuantity == null : this$inventoryQuantity.equals(other$inventoryQuantity);
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
      return other instanceof MesOtherApportionment;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $inventoryQuantity = this.getInventoryQuantity();
      return result * 59 + ($inventoryQuantity == null ? 43 : $inventoryQuantity.hashCode());
   }

   public static class MesOtherApportionmentBuilder {
      private Long id;
      private String type;
      private String unit;
      private BigDecimal price;
      private Boolean status;
      private Long workshopId;
      private BigDecimal inventoryQuantity;

      MesOtherApportionmentBuilder() {
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesOtherApportionment.MesOtherApportionmentBuilder inventoryQuantity(final BigDecimal inventoryQuantity) {
         this.inventoryQuantity = inventoryQuantity;
         return this;
      }

      public MesOtherApportionment build() {
         return new MesOtherApportionment(this.id, this.type, this.unit, this.price, this.status, this.workshopId, this.inventoryQuantity);
      }

      @Override
      public String toString() {
         return "MesOtherApportionment.MesOtherApportionmentBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ", status="
            + this.status
            + ", workshopId="
            + this.workshopId
            + ", inventoryQuantity="
            + this.inventoryQuantity
            + ")";
      }
   }
}
