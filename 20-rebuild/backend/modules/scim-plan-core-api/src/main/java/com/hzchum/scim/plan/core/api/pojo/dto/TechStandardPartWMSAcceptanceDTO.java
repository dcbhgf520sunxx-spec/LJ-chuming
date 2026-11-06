package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechStandardPartWMSAcceptanceDTO对象", description = "提供给物料展示")
public class TechStandardPartWMSAcceptanceDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id", notes = "主键id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "useProperty", value = "使用范围 1工地 2工厂", notes = "使用范围 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "userId", value = "创建用户id")
   private Long userId;
   @ApiModelProperty(name = "outboundWeight", value = "已出库量")
   private BigDecimal outboundWeight;
   @ApiModelProperty(name = "canOutWarehouseWeight", value = "可出库量")
   private BigDecimal canOutWarehouseWeight;
   @ApiModelProperty(name = "actualCanOutWarehouseWeight", value = "实际可出库量")
   private BigDecimal actualCanOutWarehouseWeight;
   @ApiModelProperty(name = "boolUnderReview", value = "是否存在审核中数据", notes = "是否存在审核中数据")
   private Boolean boolUnderReview;

   public static TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder builder() {
      return new TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder();
   }

   public TechStandardPartWMSAcceptanceDTO() {
   }

   public TechStandardPartWMSAcceptanceDTO(
      final Long id,
      final String name,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String accountingUnit,
      final Integer useProperty,
      final Long userId,
      final BigDecimal outboundWeight,
      final BigDecimal canOutWarehouseWeight,
      final BigDecimal actualCanOutWarehouseWeight,
      final Boolean boolUnderReview
   ) {
      this.id = id;
      this.name = name;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.useProperty = useProperty;
      this.userId = userId;
      this.outboundWeight = outboundWeight;
      this.canOutWarehouseWeight = canOutWarehouseWeight;
      this.actualCanOutWarehouseWeight = actualCanOutWarehouseWeight;
      this.boolUnderReview = boolUnderReview;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getOutboundWeight() {
      return this.outboundWeight;
   }

   public BigDecimal getCanOutWarehouseWeight() {
      return this.canOutWarehouseWeight;
   }

   public BigDecimal getActualCanOutWarehouseWeight() {
      return this.actualCanOutWarehouseWeight;
   }

   public Boolean getBoolUnderReview() {
      return this.boolUnderReview;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setOutboundWeight(final BigDecimal outboundWeight) {
      this.outboundWeight = outboundWeight;
   }

   public void setCanOutWarehouseWeight(final BigDecimal canOutWarehouseWeight) {
      this.canOutWarehouseWeight = canOutWarehouseWeight;
   }

   public void setActualCanOutWarehouseWeight(final BigDecimal actualCanOutWarehouseWeight) {
      this.actualCanOutWarehouseWeight = actualCanOutWarehouseWeight;
   }

   public void setBoolUnderReview(final Boolean boolUnderReview) {
      this.boolUnderReview = boolUnderReview;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartWMSAcceptanceDTO)) {
         return false;
      }

      TechStandardPartWMSAcceptanceDTO other = (TechStandardPartWMSAcceptanceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$useProperty = this.getUseProperty();
         Object other$useProperty = other.getUseProperty();
         if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$boolUnderReview = this.getBoolUnderReview();
               Object other$boolUnderReview = other.getBoolUnderReview();
               if (this$boolUnderReview == null ? other$boolUnderReview == null : this$boolUnderReview.equals(other$boolUnderReview)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$mete = this.getMete();
                           Object other$mete = other.getMete();
                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                              Object this$accountingUnit = this.getAccountingUnit();
                              Object other$accountingUnit = other.getAccountingUnit();
                              if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                 Object this$outboundWeight = this.getOutboundWeight();
                                 Object other$outboundWeight = other.getOutboundWeight();
                                 if (this$outboundWeight == null ? other$outboundWeight == null : this$outboundWeight.equals(other$outboundWeight)) {
                                    Object this$canOutWarehouseWeight = this.getCanOutWarehouseWeight();
                                    Object other$canOutWarehouseWeight = other.getCanOutWarehouseWeight();
                                    if (this$canOutWarehouseWeight == null
                                       ? other$canOutWarehouseWeight == null
                                       : this$canOutWarehouseWeight.equals(other$canOutWarehouseWeight)) {
                                       Object this$actualCanOutWarehouseWeight = this.getActualCanOutWarehouseWeight();
                                       Object other$actualCanOutWarehouseWeight = other.getActualCanOutWarehouseWeight();
                                       return this$actualCanOutWarehouseWeight == null
                                          ? other$actualCanOutWarehouseWeight == null
                                          : this$actualCanOutWarehouseWeight.equals(other$actualCanOutWarehouseWeight);
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
      return other instanceof TechStandardPartWMSAcceptanceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolUnderReview = this.getBoolUnderReview();
      result = result * 59 + ($boolUnderReview == null ? 43 : $boolUnderReview.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $outboundWeight = this.getOutboundWeight();
      result = result * 59 + ($outboundWeight == null ? 43 : $outboundWeight.hashCode());
      Object $canOutWarehouseWeight = this.getCanOutWarehouseWeight();
      result = result * 59 + ($canOutWarehouseWeight == null ? 43 : $canOutWarehouseWeight.hashCode());
      Object $actualCanOutWarehouseWeight = this.getActualCanOutWarehouseWeight();
      return result * 59 + ($actualCanOutWarehouseWeight == null ? 43 : $actualCanOutWarehouseWeight.hashCode());
   }

   @Override
   public String toString() {
      return "TechStandardPartWMSAcceptanceDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", useProperty="
         + this.getUseProperty()
         + ", userId="
         + this.getUserId()
         + ", outboundWeight="
         + this.getOutboundWeight()
         + ", canOutWarehouseWeight="
         + this.getCanOutWarehouseWeight()
         + ", actualCanOutWarehouseWeight="
         + this.getActualCanOutWarehouseWeight()
         + ", boolUnderReview="
         + this.getBoolUnderReview()
         + ")";
   }

   public static class TechStandardPartWMSAcceptanceDTOBuilder {
      private Long id;
      private String name;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String accountingUnit;
      private Integer useProperty;
      private Long userId;
      private BigDecimal outboundWeight;
      private BigDecimal canOutWarehouseWeight;
      private BigDecimal actualCanOutWarehouseWeight;
      private Boolean boolUnderReview;

      TechStandardPartWMSAcceptanceDTOBuilder() {
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder outboundWeight(final BigDecimal outboundWeight) {
         this.outboundWeight = outboundWeight;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder canOutWarehouseWeight(final BigDecimal canOutWarehouseWeight) {
         this.canOutWarehouseWeight = canOutWarehouseWeight;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder actualCanOutWarehouseWeight(final BigDecimal actualCanOutWarehouseWeight) {
         this.actualCanOutWarehouseWeight = actualCanOutWarehouseWeight;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder boolUnderReview(final Boolean boolUnderReview) {
         this.boolUnderReview = boolUnderReview;
         return this;
      }

      public TechStandardPartWMSAcceptanceDTO build() {
         return new TechStandardPartWMSAcceptanceDTO(
            this.id,
            this.name,
            this.specification,
            this.quantity,
            this.mete,
            this.accountingUnit,
            this.useProperty,
            this.userId,
            this.outboundWeight,
            this.canOutWarehouseWeight,
            this.actualCanOutWarehouseWeight,
            this.boolUnderReview
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartWMSAcceptanceDTO.TechStandardPartWMSAcceptanceDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", useProperty="
            + this.useProperty
            + ", userId="
            + this.userId
            + ", outboundWeight="
            + this.outboundWeight
            + ", canOutWarehouseWeight="
            + this.canOutWarehouseWeight
            + ", actualCanOutWarehouseWeight="
            + this.actualCanOutWarehouseWeight
            + ", boolUnderReview="
            + this.boolUnderReview
            + ")";
      }
   }
}
