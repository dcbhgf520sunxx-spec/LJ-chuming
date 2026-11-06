package com.hzchum.scim.mes.building.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("配套件发运")
public class TechStandardPartDetailDO extends TechStandardPartBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(name = "warehouseType", value = "入库类型")
   private Integer warehouseType;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "inQuantity", notes = "入库数量")
   private BigDecimal inQuantity;
   @ApiModelProperty(name = "packageQuantity", value = "打包数量")
   private BigDecimal packageQuantity;
   @ApiModelProperty(name = "packageMete", value = "打包核算量")
   private BigDecimal packageMete;
   @ApiModelProperty(name = "unPackageQuantity", value = "可使用数量")
   private BigDecimal unPackageQuantity;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "createUserName", value = "导入人")
   private String createUserName;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   private String classifyName;

   public static TechStandardPartDetailDO.TechStandardPartDetailDOBuilder builder() {
      return new TechStandardPartDetailDO.TechStandardPartDetailDOBuilder();
   }

   public TechStandardPartDetailDO() {
   }

   public TechStandardPartDetailDO(
      final Long id,
      final Integer warehouseType,
      final Long productId,
      final BigDecimal inQuantity,
      final BigDecimal packageQuantity,
      final BigDecimal packageMete,
      final BigDecimal unPackageQuantity,
      final Integer productType,
      final String createUserName,
      final String classifyName
   ) {
      this.id = id;
      this.warehouseType = warehouseType;
      this.productId = productId;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.packageMete = packageMete;
      this.unPackageQuantity = unPackageQuantity;
      this.productType = productType;
      this.createUserName = createUserName;
      this.classifyName = classifyName;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public BigDecimal getInQuantity() {
      return this.inQuantity;
   }

   public BigDecimal getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getPackageMete() {
      return this.packageMete;
   }

   public BigDecimal getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public TechStandardPartDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechStandardPartDetailDO setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   public TechStandardPartDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public TechStandardPartDetailDO setInQuantity(final BigDecimal inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public TechStandardPartDetailDO setPackageQuantity(final BigDecimal packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public TechStandardPartDetailDO setPackageMete(final BigDecimal packageMete) {
      this.packageMete = packageMete;
      return this;
   }

   public TechStandardPartDetailDO setUnPackageQuantity(final BigDecimal unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   public TechStandardPartDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public TechStandardPartDetailDO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public TechStandardPartDetailDO setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @Override
   public String toString() {
      return "TechStandardPartDetailDO(id="
         + this.getId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", productId="
         + this.getProductId()
         + ", inQuantity="
         + this.getInQuantity()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", packageMete="
         + this.getPackageMete()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ", productType="
         + this.getProductType()
         + ", createUserName="
         + this.getCreateUserName()
         + ", classifyName="
         + this.getClassifyName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechStandardPartDetailDO)) {
         return false;
      }

      TechStandardPartDetailDO other = (TechStandardPartDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseType = this.getWarehouseType();
         Object other$warehouseType = other.getWarehouseType();
         if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$inQuantity = this.getInQuantity();
                  Object other$inQuantity = other.getInQuantity();
                  if (this$inQuantity == null ? other$inQuantity == null : this$inQuantity.equals(other$inQuantity)) {
                     Object this$packageQuantity = this.getPackageQuantity();
                     Object other$packageQuantity = other.getPackageQuantity();
                     if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                        Object this$packageMete = this.getPackageMete();
                        Object other$packageMete = other.getPackageMete();
                        if (this$packageMete == null ? other$packageMete == null : this$packageMete.equals(other$packageMete)) {
                           Object this$unPackageQuantity = this.getUnPackageQuantity();
                           Object other$unPackageQuantity = other.getUnPackageQuantity();
                           if (this$unPackageQuantity == null ? other$unPackageQuantity == null : this$unPackageQuantity.equals(other$unPackageQuantity)) {
                              Object this$createUserName = this.getCreateUserName();
                              Object other$createUserName = other.getCreateUserName();
                              if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof TechStandardPartDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $packageMete = this.getPackageMete();
      result = result * 59 + ($packageMete == null ? 43 : $packageMete.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $classifyName = this.getClassifyName();
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   public static class TechStandardPartDetailDOBuilder {
      private Long id;
      private Integer warehouseType;
      private Long productId;
      private BigDecimal inQuantity;
      private BigDecimal packageQuantity;
      private BigDecimal packageMete;
      private BigDecimal unPackageQuantity;
      private Integer productType;
      private String createUserName;
      private String classifyName;

      TechStandardPartDetailDOBuilder() {
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder inQuantity(final BigDecimal inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder packageQuantity(final BigDecimal packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder packageMete(final BigDecimal packageMete) {
         this.packageMete = packageMete;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder unPackageQuantity(final BigDecimal unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public TechStandardPartDetailDO.TechStandardPartDetailDOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public TechStandardPartDetailDO build() {
         return new TechStandardPartDetailDO(
            this.id,
            this.warehouseType,
            this.productId,
            this.inQuantity,
            this.packageQuantity,
            this.packageMete,
            this.unPackageQuantity,
            this.productType,
            this.createUserName,
            this.classifyName
         );
      }

      @Override
      public String toString() {
         return "TechStandardPartDetailDO.TechStandardPartDetailDOBuilder(id="
            + this.id
            + ", warehouseType="
            + this.warehouseType
            + ", productId="
            + this.productId
            + ", inQuantity="
            + this.inQuantity
            + ", packageQuantity="
            + this.packageQuantity
            + ", packageMete="
            + this.packageMete
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ", productType="
            + this.productType
            + ", createUserName="
            + this.createUserName
            + ", classifyName="
            + this.classifyName
            + ")";
      }
   }
}
