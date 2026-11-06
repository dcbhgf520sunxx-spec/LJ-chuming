package com.hzchum.scim.business.core.api.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessArtifact;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessMachinePart;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessStandardPart;
import com.hzchum.scim.business.core.api.pojo.doModel.bridge.BusinessBridgeBox;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@ApiModel(value = "BusinessPriceTemp对象", description = "商务价格临时表 ")
public class BusinessPriceTempDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotNull(message = "项目类型不能为空")
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目", notes = "项目类型 1建钢 2桥梁 4立体停车库 8围护项目")
   private Integer projectType;
   @ApiModelProperty(name = "type", value = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护", notes = "产品类型 建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件 围护项目: 4围护")
   private Integer type;
   @ApiModelProperty(name = "businessId", value = "商务表id", notes = "商务表id")
   private Long businessId;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalPrice", value = "总价", notes = "总价")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  构件: 0重量 1长度 围护: 1长度 2面积")
   private Integer pricingManner;
   @ApiModelProperty("构件")
   private BusinessArtifact artifact;
   @ApiModelProperty("桥梁分段")
   private BusinessBridgeBox bridgeBox;
   @ApiModelProperty("围护")
   private BusinessEnclosure enclosure;
   @ApiModelProperty("标准件(配套件)")
   private BusinessStandardPart standardPart;
   @ApiModelProperty("直发零件")
   private BusinessMachinePart machinePart;

   public static BusinessPriceTempDTO.BusinessPriceTempDTOBuilder builder() {
      return new BusinessPriceTempDTO.BusinessPriceTempDTOBuilder();
   }

   public BusinessPriceTempDTO() {
   }

   public BusinessPriceTempDTO(
      final Long id,
      final Integer projectType,
      final Integer type,
      final Long businessId,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final Integer pricingManner,
      final BusinessArtifact artifact,
      final BusinessBridgeBox bridgeBox,
      final BusinessEnclosure enclosure,
      final BusinessStandardPart standardPart,
      final BusinessMachinePart machinePart
   ) {
      this.id = id;
      this.projectType = projectType;
      this.type = type;
      this.businessId = businessId;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.pricingManner = pricingManner;
      this.artifact = artifact;
      this.bridgeBox = bridgeBox;
      this.enclosure = enclosure;
      this.standardPart = standardPart;
      this.machinePart = machinePart;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public BusinessArtifact getArtifact() {
      return this.artifact;
   }

   public BusinessBridgeBox getBridgeBox() {
      return this.bridgeBox;
   }

   public BusinessEnclosure getEnclosure() {
      return this.enclosure;
   }

   public BusinessStandardPart getStandardPart() {
      return this.standardPart;
   }

   public BusinessMachinePart getMachinePart() {
      return this.machinePart;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   public void setArtifact(final BusinessArtifact artifact) {
      this.artifact = artifact;
   }

   public void setBridgeBox(final BusinessBridgeBox bridgeBox) {
      this.bridgeBox = bridgeBox;
   }

   public void setEnclosure(final BusinessEnclosure enclosure) {
      this.enclosure = enclosure;
   }

   public void setStandardPart(final BusinessStandardPart standardPart) {
      this.standardPart = standardPart;
   }

   public void setMachinePart(final BusinessMachinePart machinePart) {
      this.machinePart = machinePart;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceTempDTO)) {
         return false;
      }

      BusinessPriceTempDTO other = (BusinessPriceTempDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$businessId = this.getBusinessId();
               Object other$businessId = other.getBusinessId();
               if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                  Object this$pricingManner = this.getPricingManner();
                  Object other$pricingManner = other.getPricingManner();
                  if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                     Object this$unitPrice = this.getUnitPrice();
                     Object other$unitPrice = other.getUnitPrice();
                     if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                        Object this$totalPrice = this.getTotalPrice();
                        Object other$totalPrice = other.getTotalPrice();
                        if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                           Object this$artifact = this.getArtifact();
                           Object other$artifact = other.getArtifact();
                           if (this$artifact == null ? other$artifact == null : this$artifact.equals(other$artifact)) {
                              Object this$bridgeBox = this.getBridgeBox();
                              Object other$bridgeBox = other.getBridgeBox();
                              if (this$bridgeBox == null ? other$bridgeBox == null : this$bridgeBox.equals(other$bridgeBox)) {
                                 Object this$enclosure = this.getEnclosure();
                                 Object other$enclosure = other.getEnclosure();
                                 if (this$enclosure == null ? other$enclosure == null : this$enclosure.equals(other$enclosure)) {
                                    Object this$standardPart = this.getStandardPart();
                                    Object other$standardPart = other.getStandardPart();
                                    if (this$standardPart == null ? other$standardPart == null : this$standardPart.equals(other$standardPart)) {
                                       Object this$machinePart = this.getMachinePart();
                                       Object other$machinePart = other.getMachinePart();
                                       return this$machinePart == null ? other$machinePart == null : this$machinePart.equals(other$machinePart);
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
      return other instanceof BusinessPriceTempDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $artifact = this.getArtifact();
      result = result * 59 + ($artifact == null ? 43 : $artifact.hashCode());
      Object $bridgeBox = this.getBridgeBox();
      result = result * 59 + ($bridgeBox == null ? 43 : $bridgeBox.hashCode());
      Object $enclosure = this.getEnclosure();
      result = result * 59 + ($enclosure == null ? 43 : $enclosure.hashCode());
      Object $standardPart = this.getStandardPart();
      result = result * 59 + ($standardPart == null ? 43 : $standardPart.hashCode());
      Object $machinePart = this.getMachinePart();
      return result * 59 + ($machinePart == null ? 43 : $machinePart.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceTempDTO(id="
         + this.getId()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ", businessId="
         + this.getBusinessId()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", pricingManner="
         + this.getPricingManner()
         + ", artifact="
         + this.getArtifact()
         + ", bridgeBox="
         + this.getBridgeBox()
         + ", enclosure="
         + this.getEnclosure()
         + ", standardPart="
         + this.getStandardPart()
         + ", machinePart="
         + this.getMachinePart()
         + ")";
   }

   public static class BusinessPriceTempDTOBuilder {
      private Long id;
      private Integer projectType;
      private Integer type;
      private Long businessId;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private Integer pricingManner;
      private BusinessArtifact artifact;
      private BusinessBridgeBox bridgeBox;
      private BusinessEnclosure enclosure;
      private BusinessStandardPart standardPart;
      private BusinessMachinePart machinePart;

      BusinessPriceTempDTOBuilder() {
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder artifact(final BusinessArtifact artifact) {
         this.artifact = artifact;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder bridgeBox(final BusinessBridgeBox bridgeBox) {
         this.bridgeBox = bridgeBox;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder enclosure(final BusinessEnclosure enclosure) {
         this.enclosure = enclosure;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder standardPart(final BusinessStandardPart standardPart) {
         this.standardPart = standardPart;
         return this;
      }

      public BusinessPriceTempDTO.BusinessPriceTempDTOBuilder machinePart(final BusinessMachinePart machinePart) {
         this.machinePart = machinePart;
         return this;
      }

      public BusinessPriceTempDTO build() {
         return new BusinessPriceTempDTO(
            this.id,
            this.projectType,
            this.type,
            this.businessId,
            this.unitPrice,
            this.totalPrice,
            this.pricingManner,
            this.artifact,
            this.bridgeBox,
            this.enclosure,
            this.standardPart,
            this.machinePart
         );
      }

      @Override
      public String toString() {
         return "BusinessPriceTempDTO.BusinessPriceTempDTOBuilder(id="
            + this.id
            + ", projectType="
            + this.projectType
            + ", type="
            + this.type
            + ", businessId="
            + this.businessId
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", pricingManner="
            + this.pricingManner
            + ", artifact="
            + this.artifact
            + ", bridgeBox="
            + this.bridgeBox
            + ", enclosure="
            + this.enclosure
            + ", standardPart="
            + this.standardPart
            + ", machinePart="
            + this.machinePart
            + ")";
      }
   }
}
