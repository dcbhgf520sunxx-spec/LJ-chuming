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

@ApiModel(value = "MesContractProjectBoltSleeveLink对象", description = "项目栓钉套筒关联表")
@Entity
@TableName("mes_contract_project_bolt_sleeve_link")
@Table(name = "mes_contract_project_bolt_sleeve_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_bolt_sleeve_link", comment = "项目栓钉套筒关联表")
public class MesContractProjectBoltSleeveLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "contractProjectId", value = "项目ID", notes = "项目ID")
   @TableField("contract_project_id")
   @Column(name = "contract_project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = true)
   private Long contractProjectId;
   @ApiModelProperty(name = "type", value = "类型", notes = "类型")
   @TableField("type")
   @Column(name = "type", columnDefinition = "varchar(255)  COMMENT '类型'", nullable = true)
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

   public static MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder builder() {
      return new MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder();
   }

   public MesContractProjectBoltSleeveLink() {
   }

   public MesContractProjectBoltSleeveLink(
      final Long id, final Long contractProjectId, final String type, final Long processId, final String unit, final BigDecimal price
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.type = type;
      this.processId = processId;
      this.unit = unit;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getContractProjectId() {
      return this.contractProjectId;
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

   public MesContractProjectBoltSleeveLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectBoltSleeveLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectBoltSleeveLink setType(final String type) {
      this.type = type;
      return this;
   }

   public MesContractProjectBoltSleeveLink setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesContractProjectBoltSleeveLink setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesContractProjectBoltSleeveLink setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectBoltSleeveLink(id="
         + this.getId()
         + ", contractProjectId="
         + this.getContractProjectId()
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

      if (!(o instanceof MesContractProjectBoltSleeveLink)) {
         return false;
      }

      MesContractProjectBoltSleeveLink other = (MesContractProjectBoltSleeveLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractProjectId = this.getContractProjectId();
         Object other$contractProjectId = other.getContractProjectId();
         if (this$contractProjectId == null ? other$contractProjectId == null : this$contractProjectId.equals(other$contractProjectId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectBoltSleeveLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractProjectId = this.getContractProjectId();
      result = result * 59 + ($contractProjectId == null ? 43 : $contractProjectId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesContractProjectBoltSleeveLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private String type;
      private Long processId;
      private String unit;
      private BigDecimal price;

      MesContractProjectBoltSleeveLinkBuilder() {
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesContractProjectBoltSleeveLink build() {
         return new MesContractProjectBoltSleeveLink(this.id, this.contractProjectId, this.type, this.processId, this.unit, this.price);
      }

      @Override
      public String toString() {
         return "MesContractProjectBoltSleeveLink.MesContractProjectBoltSleeveLinkBuilder(id="
            + this.id
            + ", contractProjectId="
            + this.contractProjectId
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
