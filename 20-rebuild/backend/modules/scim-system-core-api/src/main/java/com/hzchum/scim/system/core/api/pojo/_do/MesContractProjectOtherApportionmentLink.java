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

@ApiModel(value = "MesContractProjectOtherApportionmentLink对象", description = "项目其他分摊关联表")
@Entity
@TableName("mes_contract_project_other_apportionment_link")
@Table(name = "mes_contract_project_other_apportionment_link")
@org.hibernate.annotations.Table(appliesTo = "mes_contract_project_other_apportionment_link", comment = "项目其他分摊关联表")
public class MesContractProjectOtherApportionmentLink extends BaseEntity<Long> {
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
   @Column(name = "unit", columnDefinition = "varchar(255) default '吨' COMMENT '计量单位'", nullable = true)
   private String unit;
   @ApiModelProperty(name = "price", value = "单价(元)", notes = "单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '状态'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "factoryId", value = "工厂ID", notes = "工厂ID")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20) COMMENT '工厂ID'", nullable = true)
   private Long factoryId;

   public static MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder builder() {
      return new MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder();
   }

   public MesContractProjectOtherApportionmentLink() {
   }

   public MesContractProjectOtherApportionmentLink(
      final Long id,
      final Long contractProjectId,
      final String type,
      final Long processId,
      final String unit,
      final BigDecimal price,
      final Boolean status,
      final Long factoryId
   ) {
      this.id = id;
      this.contractProjectId = contractProjectId;
      this.type = type;
      this.processId = processId;
      this.unit = unit;
      this.price = price;
      this.status = status;
      this.factoryId = factoryId;
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

   public Boolean getStatus() {
      return this.status;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public MesContractProjectOtherApportionmentLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setContractProjectId(final Long contractProjectId) {
      this.contractProjectId = contractProjectId;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setType(final String type) {
      this.type = type;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public MesContractProjectOtherApportionmentLink setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @Override
   public String toString() {
      return "MesContractProjectOtherApportionmentLink(id="
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
         + ", status="
         + this.getStatus()
         + ", factoryId="
         + this.getFactoryId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectOtherApportionmentLink)) {
         return false;
      }

      MesContractProjectOtherApportionmentLink other = (MesContractProjectOtherApportionmentLink)o;
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
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectOtherApportionmentLink;
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
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesContractProjectOtherApportionmentLinkBuilder {
      private Long id;
      private Long contractProjectId;
      private String type;
      private Long processId;
      private String unit;
      private BigDecimal price;
      private Boolean status;
      private Long factoryId;

      MesContractProjectOtherApportionmentLinkBuilder() {
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder contractProjectId(final Long contractProjectId) {
         this.contractProjectId = contractProjectId;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesContractProjectOtherApportionmentLink build() {
         return new MesContractProjectOtherApportionmentLink(
            this.id, this.contractProjectId, this.type, this.processId, this.unit, this.price, this.status, this.factoryId
         );
      }

      @Override
      public String toString() {
         return "MesContractProjectOtherApportionmentLink.MesContractProjectOtherApportionmentLinkBuilder(id="
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
            + ", status="
            + this.status
            + ", factoryId="
            + this.factoryId
            + ")";
      }
   }
}
