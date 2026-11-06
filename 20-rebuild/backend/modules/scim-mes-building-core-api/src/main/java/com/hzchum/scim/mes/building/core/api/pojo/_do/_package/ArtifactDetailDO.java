package com.hzchum.scim.mes.building.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "构件发运")
public class ArtifactDetailDO extends ArtifactBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(name = "warehouseType", value = "入库类型")
   private Integer warehouseType;
   @ApiModelProperty(notes = "工厂")
   private NameInfo factory;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshopInf;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "入库数量")
   private BigDecimal inQuantity;
   @ApiModelProperty("当前打包装车数")
   private BigDecimal packageQuantity;
   @ApiModelProperty("库存数量(包含当前包数量)")
   private BigDecimal unPackageQuantity;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty("编号列表")
   private List<ArtifactStockNumberDO> numberList;
   @ApiModelProperty("构件对应未发运的直发件列表")
   private List<SendDirectlyDetailDO> unshippedPartList;
   @ApiModelProperty("问题码号")
   private List<Integer> qhseNumbers;

   public static ArtifactDetailDO.ArtifactDetailDOBuilder builder() {
      return new ArtifactDetailDO.ArtifactDetailDOBuilder();
   }

   public ArtifactDetailDO() {
   }

   public ArtifactDetailDO(
      final Long id,
      final Integer warehouseType,
      final NameInfo factory,
      final NameInfo workshopInf,
      final NameInfo workshop,
      final Long productId,
      final BigDecimal inQuantity,
      final BigDecimal packageQuantity,
      final BigDecimal unPackageQuantity,
      final Boolean boolOneCode,
      final Integer productType,
      final List<ArtifactStockNumberDO> numberList,
      final List<SendDirectlyDetailDO> unshippedPartList,
      final List<Integer> qhseNumbers
   ) {
      this.id = id;
      this.warehouseType = warehouseType;
      this.factory = factory;
      this.workshopInf = workshopInf;
      this.workshop = workshop;
      this.productId = productId;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
      this.boolOneCode = boolOneCode;
      this.productType = productType;
      this.numberList = numberList;
      this.unshippedPartList = unshippedPartList;
      this.qhseNumbers = qhseNumbers;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public NameInfo getFactory() {
      return this.factory;
   }

   public NameInfo getWorkshopInf() {
      return this.workshopInf;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
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

   public BigDecimal getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<ArtifactStockNumberDO> getNumberList() {
      return this.numberList;
   }

   public List<SendDirectlyDetailDO> getUnshippedPartList() {
      return this.unshippedPartList;
   }

   public List<Integer> getQhseNumbers() {
      return this.qhseNumbers;
   }

   public ArtifactDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ArtifactDetailDO setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   public ArtifactDetailDO setFactory(final NameInfo factory) {
      this.factory = factory;
      return this;
   }

   public ArtifactDetailDO setWorkshopInf(final NameInfo workshopInf) {
      this.workshopInf = workshopInf;
      return this;
   }

   public ArtifactDetailDO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   public ArtifactDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ArtifactDetailDO setInQuantity(final BigDecimal inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public ArtifactDetailDO setPackageQuantity(final BigDecimal packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public ArtifactDetailDO setUnPackageQuantity(final BigDecimal unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   public ArtifactDetailDO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   public ArtifactDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ArtifactDetailDO setNumberList(final List<ArtifactStockNumberDO> numberList) {
      this.numberList = numberList;
      return this;
   }

   public ArtifactDetailDO setUnshippedPartList(final List<SendDirectlyDetailDO> unshippedPartList) {
      this.unshippedPartList = unshippedPartList;
      return this;
   }

   public ArtifactDetailDO setQhseNumbers(final List<Integer> qhseNumbers) {
      this.qhseNumbers = qhseNumbers;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactDetailDO(id="
         + this.getId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", factory="
         + this.getFactory()
         + ", workshopInf="
         + this.getWorkshopInf()
         + ", workshop="
         + this.getWorkshop()
         + ", productId="
         + this.getProductId()
         + ", inQuantity="
         + this.getInQuantity()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", productType="
         + this.getProductType()
         + ", numberList="
         + this.getNumberList()
         + ", unshippedPartList="
         + this.getUnshippedPartList()
         + ", qhseNumbers="
         + this.getQhseNumbers()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactDetailDO)) {
         return false;
      }

      ArtifactDetailDO other = (ArtifactDetailDO)o;
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
               Object this$boolOneCode = this.getBoolOneCode();
               Object other$boolOneCode = other.getBoolOneCode();
               if (this$boolOneCode == null ? other$boolOneCode == null : this$boolOneCode.equals(other$boolOneCode)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$factory = this.getFactory();
                     Object other$factory = other.getFactory();
                     if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                        Object this$workshopInf = this.getWorkshopInf();
                        Object other$workshopInf = other.getWorkshopInf();
                        if (this$workshopInf == null ? other$workshopInf == null : this$workshopInf.equals(other$workshopInf)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$inQuantity = this.getInQuantity();
                              Object other$inQuantity = other.getInQuantity();
                              if (this$inQuantity == null ? other$inQuantity == null : this$inQuantity.equals(other$inQuantity)) {
                                 Object this$packageQuantity = this.getPackageQuantity();
                                 Object other$packageQuantity = other.getPackageQuantity();
                                 if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                                    Object this$unPackageQuantity = this.getUnPackageQuantity();
                                    Object other$unPackageQuantity = other.getUnPackageQuantity();
                                    if (this$unPackageQuantity == null
                                       ? other$unPackageQuantity == null
                                       : this$unPackageQuantity.equals(other$unPackageQuantity)) {
                                       Object this$numberList = this.getNumberList();
                                       Object other$numberList = other.getNumberList();
                                       if (this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList)) {
                                          Object this$unshippedPartList = this.getUnshippedPartList();
                                          Object other$unshippedPartList = other.getUnshippedPartList();
                                          if (this$unshippedPartList == null
                                             ? other$unshippedPartList == null
                                             : this$unshippedPartList.equals(other$unshippedPartList)) {
                                             Object this$qhseNumbers = this.getQhseNumbers();
                                             Object other$qhseNumbers = other.getQhseNumbers();
                                             return this$qhseNumbers == null ? other$qhseNumbers == null : this$qhseNumbers.equals(other$qhseNumbers);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactDetailDO;
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
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshopInf = this.getWorkshopInf();
      result = result * 59 + ($workshopInf == null ? 43 : $workshopInf.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $unshippedPartList = this.getUnshippedPartList();
      result = result * 59 + ($unshippedPartList == null ? 43 : $unshippedPartList.hashCode());
      Object $qhseNumbers = this.getQhseNumbers();
      return result * 59 + ($qhseNumbers == null ? 43 : $qhseNumbers.hashCode());
   }

   public static class ArtifactDetailDOBuilder {
      private Long id;
      private Integer warehouseType;
      private NameInfo factory;
      private NameInfo workshopInf;
      private NameInfo workshop;
      private Long productId;
      private BigDecimal inQuantity;
      private BigDecimal packageQuantity;
      private BigDecimal unPackageQuantity;
      private Boolean boolOneCode;
      private Integer productType;
      private List<ArtifactStockNumberDO> numberList;
      private List<SendDirectlyDetailDO> unshippedPartList;
      private List<Integer> qhseNumbers;

      ArtifactDetailDOBuilder() {
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder factory(final NameInfo factory) {
         this.factory = factory;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder workshopInf(final NameInfo workshopInf) {
         this.workshopInf = workshopInf;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder inQuantity(final BigDecimal inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder packageQuantity(final BigDecimal packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder unPackageQuantity(final BigDecimal unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder numberList(final List<ArtifactStockNumberDO> numberList) {
         this.numberList = numberList;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder unshippedPartList(final List<SendDirectlyDetailDO> unshippedPartList) {
         this.unshippedPartList = unshippedPartList;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder qhseNumbers(final List<Integer> qhseNumbers) {
         this.qhseNumbers = qhseNumbers;
         return this;
      }

      public ArtifactDetailDO build() {
         return new ArtifactDetailDO(
            this.id,
            this.warehouseType,
            this.factory,
            this.workshopInf,
            this.workshop,
            this.productId,
            this.inQuantity,
            this.packageQuantity,
            this.unPackageQuantity,
            this.boolOneCode,
            this.productType,
            this.numberList,
            this.unshippedPartList,
            this.qhseNumbers
         );
      }

      @Override
      public String toString() {
         return "ArtifactDetailDO.ArtifactDetailDOBuilder(id="
            + this.id
            + ", warehouseType="
            + this.warehouseType
            + ", factory="
            + this.factory
            + ", workshopInf="
            + this.workshopInf
            + ", workshop="
            + this.workshop
            + ", productId="
            + this.productId
            + ", inQuantity="
            + this.inQuantity
            + ", packageQuantity="
            + this.packageQuantity
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ", boolOneCode="
            + this.boolOneCode
            + ", productType="
            + this.productType
            + ", numberList="
            + this.numberList
            + ", unshippedPartList="
            + this.unshippedPartList
            + ", qhseNumbers="
            + this.qhseNumbers
            + ")";
      }
   }
}
