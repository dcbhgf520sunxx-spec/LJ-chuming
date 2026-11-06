package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

@ApiModel(description = "产品清单汇总 ")
@Entity
@Table(name = "tech_product_summary")
public class TechProductSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("项目id")
   @Column
   private Long projectId;
   @ApiModelProperty("单体id")
   @Column
   private Long monomerId;
   @ApiModelProperty("区域id")
   @Column
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id")
   @Column(name = "area_batch_id")
   private Long areaBatchId;
   @ApiModelProperty("围护分类 仅供围护分类使用")
   @Column
   private Integer category;
   @ApiModelProperty("产品类型")
   @Column
   private Integer productType;
   @ApiModelProperty("数量")
   @Column
   private Integer quantity;
   @ApiModelProperty("量1")
   @Column
   private BigDecimal meteOne;
   @ApiModelProperty("量2")
   @Column
   private BigDecimal meteTwo;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMeteOne() {
      return this.meteOne;
   }

   public BigDecimal getMeteTwo() {
      return this.meteTwo;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMeteOne(final BigDecimal meteOne) {
      this.meteOne = meteOne;
   }

   public void setMeteTwo(final BigDecimal meteTwo) {
      this.meteTwo = meteTwo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechProductSummary)) {
         return false;
      }

      TechProductSummary other = (TechProductSummary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$meteOne = this.getMeteOne();
                              Object other$meteOne = other.getMeteOne();
                              if (this$meteOne == null ? other$meteOne == null : this$meteOne.equals(other$meteOne)) {
                                 Object this$meteTwo = this.getMeteTwo();
                                 Object other$meteTwo = other.getMeteTwo();
                                 return this$meteTwo == null ? other$meteTwo == null : this$meteTwo.equals(other$meteTwo);
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
      return other instanceof TechProductSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $meteOne = this.getMeteOne();
      result = result * 59 + ($meteOne == null ? 43 : $meteOne.hashCode());
      Object $meteTwo = this.getMeteTwo();
      return result * 59 + ($meteTwo == null ? 43 : $meteTwo.hashCode());
   }

   @Override
   public String toString() {
      return "TechProductSummary(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", category="
         + this.getCategory()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", meteOne="
         + this.getMeteOne()
         + ", meteTwo="
         + this.getMeteTwo()
         + ")";
   }
}
