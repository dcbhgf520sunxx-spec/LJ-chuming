package com.hzchum.scim.project.core.api.pojo.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("产品统计信息(安装填报使用)")
public class ProjectProductSummaryDO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "category", value = "围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "mete", value = "产品总量(重量kg/长度mm)", notes = "产品总量(重量kg/长度mm)")
   private BigDecimal mete;
   @ApiModelProperty(name = "totalArea", value = "总面积mm2", notes = "总面积mm2")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "receivingQuantity", value = "已收货数量", notes = "已收货数量")
   private Integer receivingQuantity;
   @ApiModelProperty(name = "installQuantity", value = "已安装数量", notes = "已安装数量")
   private Integer installQuantity;

   public static ProjectProductSummaryDO.ProjectProductSummaryDOBuilder builder() {
      return new ProjectProductSummaryDO.ProjectProductSummaryDOBuilder();
   }

   public ProjectProductSummaryDO() {
   }

   public ProjectProductSummaryDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal mete,
      final BigDecimal totalArea,
      final Integer receivingQuantity,
      final Integer installQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.totalArea = totalArea;
      this.receivingQuantity = receivingQuantity;
      this.installQuantity = installQuantity;
   }

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

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getReceivingQuantity() {
      return this.receivingQuantity;
   }

   public Integer getInstallQuantity() {
      return this.installQuantity;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setReceivingQuantity(final Integer receivingQuantity) {
      this.receivingQuantity = receivingQuantity;
   }

   public void setInstallQuantity(final Integer installQuantity) {
      this.installQuantity = installQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductSummaryDO)) {
         return false;
      }

      ProjectProductSummaryDO other = (ProjectProductSummaryDO)o;
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
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$category = this.getCategory();
                     Object other$category = other.getCategory();
                     if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$receivingQuantity = this.getReceivingQuantity();
                              Object other$receivingQuantity = other.getReceivingQuantity();
                              if (this$receivingQuantity == null ? other$receivingQuantity == null : this$receivingQuantity.equals(other$receivingQuantity)) {
                                 Object this$installQuantity = this.getInstallQuantity();
                                 Object other$installQuantity = other.getInstallQuantity();
                                 if (this$installQuantity == null ? other$installQuantity == null : this$installQuantity.equals(other$installQuantity)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$totalArea = this.getTotalArea();
                                                Object other$totalArea = other.getTotalArea();
                                                return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof ProjectProductSummaryDO;
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
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $receivingQuantity = this.getReceivingQuantity();
      result = result * 59 + ($receivingQuantity == null ? 43 : $receivingQuantity.hashCode());
      Object $installQuantity = this.getInstallQuantity();
      result = result * 59 + ($installQuantity == null ? 43 : $installQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductSummaryDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", totalArea="
         + this.getTotalArea()
         + ", receivingQuantity="
         + this.getReceivingQuantity()
         + ", installQuantity="
         + this.getInstallQuantity()
         + ")";
   }

   public static class ProjectProductSummaryDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal mete;
      private BigDecimal totalArea;
      private Integer receivingQuantity;
      private Integer installQuantity;

      ProjectProductSummaryDOBuilder() {
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder receivingQuantity(final Integer receivingQuantity) {
         this.receivingQuantity = receivingQuantity;
         return this;
      }

      public ProjectProductSummaryDO.ProjectProductSummaryDOBuilder installQuantity(final Integer installQuantity) {
         this.installQuantity = installQuantity;
         return this;
      }

      public ProjectProductSummaryDO build() {
         return new ProjectProductSummaryDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.category,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.mete,
            this.totalArea,
            this.receivingQuantity,
            this.installQuantity
         );
      }

      @Override
      public String toString() {
         return "ProjectProductSummaryDO.ProjectProductSummaryDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", totalArea="
            + this.totalArea
            + ", receivingQuantity="
            + this.receivingQuantity
            + ", installQuantity="
            + this.installQuantity
            + ")";
      }
   }
}
