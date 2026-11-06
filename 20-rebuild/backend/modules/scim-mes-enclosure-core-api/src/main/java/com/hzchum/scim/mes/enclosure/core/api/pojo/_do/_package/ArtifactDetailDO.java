package com.hzchum.scim.mes.enclosure.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.warehouse.ArtifactStockNumberDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "构件发运")
public class ArtifactDetailDO extends ArtifactBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(notes = "工厂")
   private NameInfo factory;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshopInf;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "入库数量")
   private Integer inQuantity;
   @ApiModelProperty("当前打包装车数")
   private Integer packageQuantity;
   @ApiModelProperty("库存数量(包含当前包数量)")
   private Integer unPackageQuantity;
   @ApiModelProperty("是否一物一码")
   private Boolean boolOneCode;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty("编号列表")
   private List<ArtifactStockNumberDO> numberList;
   @ApiModelProperty("构件对应未发运的直发件列表")
   private List<SendDirectlyDetailDO> unshippedPartList;

   public static ArtifactDetailDO.ArtifactDetailDOBuilder builder() {
      return new ArtifactDetailDO.ArtifactDetailDOBuilder();
   }

   public ArtifactDetailDO() {
   }

   public ArtifactDetailDO(
      final Long id,
      final NameInfo factory,
      final NameInfo workshopInf,
      final NameInfo workshop,
      final Long productId,
      final Integer inQuantity,
      final Integer packageQuantity,
      final Integer unPackageQuantity,
      final Boolean boolOneCode,
      final Integer productType,
      final List<ArtifactStockNumberDO> numberList,
      final List<SendDirectlyDetailDO> unshippedPartList
   ) {
      this.id = id;
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
   }

   public Long getId() {
      return this.id;
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

   public Integer getInQuantity() {
      return this.inQuantity;
   }

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public Integer getUnPackageQuantity() {
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

   public ArtifactDetailDO setId(final Long id) {
      this.id = id;
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

   public ArtifactDetailDO setInQuantity(final Integer inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public ArtifactDetailDO setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public ArtifactDetailDO setUnPackageQuantity(final Integer unPackageQuantity) {
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

   @Override
   public String toString() {
      return "ArtifactDetailDO(id="
         + this.getId()
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
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$inQuantity = this.getInQuantity();
            Object other$inQuantity = other.getInQuantity();
            if (this$inQuantity == null ? other$inQuantity == null : this$inQuantity.equals(other$inQuantity)) {
               Object this$packageQuantity = this.getPackageQuantity();
               Object other$packageQuantity = other.getPackageQuantity();
               if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                  Object this$unPackageQuantity = this.getUnPackageQuantity();
                  Object other$unPackageQuantity = other.getUnPackageQuantity();
                  if (this$unPackageQuantity == null ? other$unPackageQuantity == null : this$unPackageQuantity.equals(other$unPackageQuantity)) {
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
                                    Object this$numberList = this.getNumberList();
                                    Object other$numberList = other.getNumberList();
                                    if (this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList)) {
                                       Object this$unshippedPartList = this.getUnshippedPartList();
                                       Object other$unshippedPartList = other.getUnshippedPartList();
                                       return this$unshippedPartList == null
                                          ? other$unshippedPartList == null
                                          : this$unshippedPartList.equals(other$unshippedPartList);
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
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $inQuantity = this.getInQuantity();
      result = result * 59 + ($inQuantity == null ? 43 : $inQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
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
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $unshippedPartList = this.getUnshippedPartList();
      return result * 59 + ($unshippedPartList == null ? 43 : $unshippedPartList.hashCode());
   }

   public static class ArtifactDetailDOBuilder {
      private Long id;
      private NameInfo factory;
      private NameInfo workshopInf;
      private NameInfo workshop;
      private Long productId;
      private Integer inQuantity;
      private Integer packageQuantity;
      private Integer unPackageQuantity;
      private Boolean boolOneCode;
      private Integer productType;
      private List<ArtifactStockNumberDO> numberList;
      private List<SendDirectlyDetailDO> unshippedPartList;

      ArtifactDetailDOBuilder() {
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder id(final Long id) {
         this.id = id;
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

      public ArtifactDetailDO.ArtifactDetailDOBuilder inQuantity(final Integer inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public ArtifactDetailDO.ArtifactDetailDOBuilder unPackageQuantity(final Integer unPackageQuantity) {
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

      public ArtifactDetailDO build() {
         return new ArtifactDetailDO(
            this.id,
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
            this.unshippedPartList
         );
      }

      @Override
      public String toString() {
         return "ArtifactDetailDO.ArtifactDetailDOBuilder(id="
            + this.id
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
            + ")";
      }
   }
}
