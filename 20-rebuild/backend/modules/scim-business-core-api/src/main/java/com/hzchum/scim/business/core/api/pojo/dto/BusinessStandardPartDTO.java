package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "BusinessStandardPart对象DTO", description = "标准件商务表 ")
public class BusinessStandardPartDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;
   @ApiModelProperty(name = "quantity", value = "数量 0", notes = "数量 0")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2已审核")
   private Integer status;

   public static BusinessStandardPartDTO.BusinessStandardPartDTOBuilder builder() {
      return new BusinessStandardPartDTO.BusinessStandardPartDTOBuilder();
   }

   public BusinessStandardPartDTO() {
   }

   public BusinessStandardPartDTO(
      final Long id,
      final Long projectId,
      final String name,
      final Integer useProperty,
      final String specification,
      final String measureUnit,
      final Integer quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer status
   ) {
      this.id = id;
      this.projectId = projectId;
      this.name = name;
      this.useProperty = useProperty;
      this.specification = specification;
      this.measureUnit = measureUnit;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessStandardPartDTO)) {
         return false;
      }

      BusinessStandardPartDTO other = (BusinessStandardPartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$useProperty = this.getUseProperty();
            Object other$useProperty = other.getUseProperty();
            if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$measureUnit = this.getMeasureUnit();
                           Object other$measureUnit = other.getMeasureUnit();
                           if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$accountingUnit = this.getAccountingUnit();
                                 Object other$accountingUnit = other.getAccountingUnit();
                                 if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                    Object this$unitPrice = this.getUnitPrice();
                                    Object other$unitPrice = other.getUnitPrice();
                                    if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                       Object this$totalPrice = this.getTotalPrice();
                                       Object other$totalPrice = other.getTotalPrice();
                                       return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessStandardPartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessStandardPartDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", name="
         + this.getName()
         + ", useProperty="
         + this.getUseProperty()
         + ", specification="
         + this.getSpecification()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class BusinessStandardPartDTOBuilder {
      private Long id;
      private Long projectId;
      private String name;
      private Integer useProperty;
      private String specification;
      private String measureUnit;
      private Integer quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer status;

      BusinessStandardPartDTOBuilder() {
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessStandardPartDTO.BusinessStandardPartDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessStandardPartDTO build() {
         return new BusinessStandardPartDTO(
            this.id,
            this.projectId,
            this.name,
            this.useProperty,
            this.specification,
            this.measureUnit,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.unitPrice,
            this.totalPrice,
            this.status
         );
      }

      @Override
      public String toString() {
         return "BusinessStandardPartDTO.BusinessStandardPartDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", name="
            + this.name
            + ", useProperty="
            + this.useProperty
            + ", specification="
            + this.specification
            + ", measureUnit="
            + this.measureUnit
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", status="
            + this.status
            + ")";
      }
   }
}
