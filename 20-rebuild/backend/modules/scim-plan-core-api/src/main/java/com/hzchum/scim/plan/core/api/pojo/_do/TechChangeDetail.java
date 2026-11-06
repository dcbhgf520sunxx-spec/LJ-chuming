package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(description = "技术变更详情 ")
@Entity
@TableName("tech_change_detail")
@Table(name = "tech_change_detail")
public class TechChangeDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("变更id")
   @Column
   private Long changeId;
   @ApiModelProperty("变更类型（产品类型）")
   @Column
   private Integer productType;
   @ApiModelProperty("变更指令")
   @Column
   private String instruction;
   @ApiModelProperty("编号")
   @Column
   private String serialNumber;
   @ApiModelProperty("材质")
   @Column
   private String material;
   @ApiModelProperty("规格")
   @Column
   private String specification;
   @ApiModelProperty("长度")
   @Column
   private BigDecimal length;
   @ApiModelProperty("单毛重")
   @Column
   private BigDecimal grossWeight;
   @ApiModelProperty("单净重")
   @Column
   private BigDecimal netWeight;
   @ApiModelProperty("原有数量")
   @Column
   private Integer oldQuantity;
   @ApiModelProperty("新数量")
   @Column
   private Integer newQuantity;

   public static TechChangeDetail.TechChangeDetailBuilder builder() {
      return new TechChangeDetail.TechChangeDetailBuilder();
   }

   public TechChangeDetail() {
   }

   public TechChangeDetail(
      final Long id,
      final Long changeId,
      final Integer productType,
      final String instruction,
      final String serialNumber,
      final String material,
      final String specification,
      final BigDecimal length,
      final BigDecimal grossWeight,
      final BigDecimal netWeight,
      final Integer oldQuantity,
      final Integer newQuantity
   ) {
      this.id = id;
      this.changeId = changeId;
      this.productType = productType;
      this.instruction = instruction;
      this.serialNumber = serialNumber;
      this.material = material;
      this.specification = specification;
      this.length = length;
      this.grossWeight = grossWeight;
      this.netWeight = netWeight;
      this.oldQuantity = oldQuantity;
      this.newQuantity = newQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeId() {
      return this.changeId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getInstruction() {
      return this.instruction;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getOldQuantity() {
      return this.oldQuantity;
   }

   public Integer getNewQuantity() {
      return this.newQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setChangeId(final Long changeId) {
      this.changeId = changeId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setInstruction(final String instruction) {
      this.instruction = instruction;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setOldQuantity(final Integer oldQuantity) {
      this.oldQuantity = oldQuantity;
   }

   public void setNewQuantity(final Integer newQuantity) {
      this.newQuantity = newQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeDetail)) {
         return false;
      }

      TechChangeDetail other = (TechChangeDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeId = this.getChangeId();
         Object other$changeId = other.getChangeId();
         if (this$changeId == null ? other$changeId == null : this$changeId.equals(other$changeId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$oldQuantity = this.getOldQuantity();
               Object other$oldQuantity = other.getOldQuantity();
               if (this$oldQuantity == null ? other$oldQuantity == null : this$oldQuantity.equals(other$oldQuantity)) {
                  Object this$newQuantity = this.getNewQuantity();
                  Object other$newQuantity = other.getNewQuantity();
                  if (this$newQuantity == null ? other$newQuantity == null : this$newQuantity.equals(other$newQuantity)) {
                     Object this$instruction = this.getInstruction();
                     Object other$instruction = other.getInstruction();
                     if (this$instruction == null ? other$instruction == null : this$instruction.equals(other$instruction)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$material = this.getMaterial();
                           Object other$material = other.getMaterial();
                           if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$grossWeight = this.getGrossWeight();
                                    Object other$grossWeight = other.getGrossWeight();
                                    if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                       Object this$netWeight = this.getNetWeight();
                                       Object other$netWeight = other.getNetWeight();
                                       return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechChangeDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeId = this.getChangeId();
      result = result * 59 + ($changeId == null ? 43 : $changeId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $oldQuantity = this.getOldQuantity();
      result = result * 59 + ($oldQuantity == null ? 43 : $oldQuantity.hashCode());
      Object $newQuantity = this.getNewQuantity();
      result = result * 59 + ($newQuantity == null ? 43 : $newQuantity.hashCode());
      Object $instruction = this.getInstruction();
      result = result * 59 + ($instruction == null ? 43 : $instruction.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeDetail(id="
         + this.getId()
         + ", changeId="
         + this.getChangeId()
         + ", productType="
         + this.getProductType()
         + ", instruction="
         + this.getInstruction()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", oldQuantity="
         + this.getOldQuantity()
         + ", newQuantity="
         + this.getNewQuantity()
         + ")";
   }

   public static class TechChangeDetailBuilder {
      private Long id;
      private Long changeId;
      private Integer productType;
      private String instruction;
      private String serialNumber;
      private String material;
      private String specification;
      private BigDecimal length;
      private BigDecimal grossWeight;
      private BigDecimal netWeight;
      private Integer oldQuantity;
      private Integer newQuantity;

      TechChangeDetailBuilder() {
      }

      public TechChangeDetail.TechChangeDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder changeId(final Long changeId) {
         this.changeId = changeId;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder instruction(final String instruction) {
         this.instruction = instruction;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder oldQuantity(final Integer oldQuantity) {
         this.oldQuantity = oldQuantity;
         return this;
      }

      public TechChangeDetail.TechChangeDetailBuilder newQuantity(final Integer newQuantity) {
         this.newQuantity = newQuantity;
         return this;
      }

      public TechChangeDetail build() {
         return new TechChangeDetail(
            this.id,
            this.changeId,
            this.productType,
            this.instruction,
            this.serialNumber,
            this.material,
            this.specification,
            this.length,
            this.grossWeight,
            this.netWeight,
            this.oldQuantity,
            this.newQuantity
         );
      }

      @Override
      public String toString() {
         return "TechChangeDetail.TechChangeDetailBuilder(id="
            + this.id
            + ", changeId="
            + this.changeId
            + ", productType="
            + this.productType
            + ", instruction="
            + this.instruction
            + ", serialNumber="
            + this.serialNumber
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", grossWeight="
            + this.grossWeight
            + ", netWeight="
            + this.netWeight
            + ", oldQuantity="
            + this.oldQuantity
            + ", newQuantity="
            + this.newQuantity
            + ")";
      }
   }
}
