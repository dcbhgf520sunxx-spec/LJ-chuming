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

@ApiModel(value = "MesBoltSleeve对象", description = "栓钉套筒表")
@Entity
@TableName("mes_bolt_sleeve")
@Table(name = "mes_bolt_sleeve")
@org.hibernate.annotations.Table(appliesTo = "mes_bolt_sleeve", comment = "栓钉套筒表")
public class MesBoltSleeve extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   @TableField("type")
   @Column(name = "type", columnDefinition = "varchar(500)  COMMENT '类型'", nullable = true)
   private String type;
   @ApiModelProperty(name = "processId", value = "工序ID", notes = "工序ID")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序ID'", nullable = true)
   private Long processId;
   @ApiModelProperty(name = "unit", value = "计量单位", notes = "计量单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) default '支' COMMENT '计量单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;

   public static MesBoltSleeve.MesBoltSleeveBuilder builder() {
      return new MesBoltSleeve.MesBoltSleeveBuilder();
   }

   public MesBoltSleeve() {
   }

   public MesBoltSleeve(final Long id, final String type, final Long processId, final String unit, final BigDecimal price) {
      this.id = id;
      this.type = type;
      this.processId = processId;
      this.unit = unit;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public String getType() {
      return this.type;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesBoltSleeve setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBoltSleeve setType(final String type) {
      this.type = type;
      return this;
   }

   public MesBoltSleeve setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBoltSleeve setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesBoltSleeve setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesBoltSleeve(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", processId="
         + this.getProcessId()
         + ", unit="
         + this.getUnit()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBoltSleeve)) {
         return false;
      }

      MesBoltSleeve other = (MesBoltSleeve)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$unit = this.getUnit();
               Object other$unit = other.getUnit();
               if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                  Object this$price = this.getPrice();
                  Object other$price = other.getPrice();
                  return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesBoltSleeve;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBoltSleeveBuilder {
      private Long id;
      private String type;
      private Long processId;
      private String unit;
      private BigDecimal price;

      MesBoltSleeveBuilder() {
      }

      public MesBoltSleeve.MesBoltSleeveBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBoltSleeve.MesBoltSleeveBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public MesBoltSleeve.MesBoltSleeveBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBoltSleeve.MesBoltSleeveBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesBoltSleeve.MesBoltSleeveBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBoltSleeve build() {
         return new MesBoltSleeve(this.id, this.type, this.processId, this.unit, this.price);
      }

      @Override
      public String toString() {
         return "MesBoltSleeve.MesBoltSleeveBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", processId="
            + this.processId
            + ", unit="
            + this.unit
            + ", price="
            + this.price
            + ")";
      }
   }
}
