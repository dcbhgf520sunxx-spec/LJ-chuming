package com.hzchum.scim.mes.enclosure.core.api.pojo._do._package;

import com.hzchum.scim.common.core.api.pojo.common.ArtifactBaseInfo;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "直发件DO")
public class SendDirectlyDetailDO extends ArtifactBaseInfo {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty(notes = "工厂")
   private NameInfo factory;
   @ApiModelProperty(notes = "车间")
   private NameInfo workshop;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "入库数量")
   private Integer inQuantity;
   @ApiModelProperty("当前装车数量")
   private Integer packageQuantity;
   @ApiModelProperty("库存数量(包含当前包数量)")
   private Integer unPackageQuantity;
   @ApiModelProperty(notes = "构件id")
   private Long artifactId;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "包单号")
   private String packSerialNumber;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "status", value = "直发件状态 [0 未装车未打包, 1 已打包未装车 2 已装车未发运 ]", notes = "状态 [0 未装车未打包, 1 已打包未装车 2 已装车未发运 ]")
   private Integer status;

   public static SendDirectlyDetailDO.SendDirectlyDetailDOBuilder builder() {
      return new SendDirectlyDetailDO.SendDirectlyDetailDOBuilder();
   }

   public SendDirectlyDetailDO() {
   }

   public SendDirectlyDetailDO(
      final Long id,
      final NameInfo factory,
      final NameInfo workshop,
      final Long productId,
      final Integer inQuantity,
      final Integer packageQuantity,
      final Integer unPackageQuantity,
      final Long artifactId,
      final Integer productType,
      final String packSerialNumber,
      final String licensePlate,
      final Integer status
   ) {
      this.id = id;
      this.factory = factory;
      this.workshop = workshop;
      this.productId = productId;
      this.inQuantity = inQuantity;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
      this.artifactId = artifactId;
      this.productType = productType;
      this.packSerialNumber = packSerialNumber;
      this.licensePlate = licensePlate;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public NameInfo getFactory() {
      return this.factory;
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

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getPackSerialNumber() {
      return this.packSerialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public SendDirectlyDetailDO setId(final Long id) {
      this.id = id;
      return this;
   }

   public SendDirectlyDetailDO setFactory(final NameInfo factory) {
      this.factory = factory;
      return this;
   }

   public SendDirectlyDetailDO setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
      return this;
   }

   public SendDirectlyDetailDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public SendDirectlyDetailDO setInQuantity(final Integer inQuantity) {
      this.inQuantity = inQuantity;
      return this;
   }

   public SendDirectlyDetailDO setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public SendDirectlyDetailDO setUnPackageQuantity(final Integer unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   public SendDirectlyDetailDO setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public SendDirectlyDetailDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public SendDirectlyDetailDO setPackSerialNumber(final String packSerialNumber) {
      this.packSerialNumber = packSerialNumber;
      return this;
   }

   public SendDirectlyDetailDO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public SendDirectlyDetailDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "SendDirectlyDetailDO(id="
         + this.getId()
         + ", factory="
         + this.getFactory()
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
         + ", artifactId="
         + this.getArtifactId()
         + ", productType="
         + this.getProductType()
         + ", packSerialNumber="
         + this.getPackSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SendDirectlyDetailDO)) {
         return false;
      }

      SendDirectlyDetailDO other = (SendDirectlyDetailDO)o;
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
                     Object this$artifactId = this.getArtifactId();
                     Object other$artifactId = other.getArtifactId();
                     if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$factory = this.getFactory();
                              Object other$factory = other.getFactory();
                              if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
                                 Object this$workshop = this.getWorkshop();
                                 Object other$workshop = other.getWorkshop();
                                 if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                    Object this$packSerialNumber = this.getPackSerialNumber();
                                    Object other$packSerialNumber = other.getPackSerialNumber();
                                    if (this$packSerialNumber == null ? other$packSerialNumber == null : this$packSerialNumber.equals(other$packSerialNumber)) {
                                       Object this$licensePlate = this.getLicensePlate();
                                       Object other$licensePlate = other.getLicensePlate();
                                       return this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate);
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
      return other instanceof SendDirectlyDetailDO;
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
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $packSerialNumber = this.getPackSerialNumber();
      result = result * 59 + ($packSerialNumber == null ? 43 : $packSerialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      return result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
   }

   public static class SendDirectlyDetailDOBuilder {
      private Long id;
      private NameInfo factory;
      private NameInfo workshop;
      private Long productId;
      private Integer inQuantity;
      private Integer packageQuantity;
      private Integer unPackageQuantity;
      private Long artifactId;
      private Integer productType;
      private String packSerialNumber;
      private String licensePlate;
      private Integer status;

      SendDirectlyDetailDOBuilder() {
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder factory(final NameInfo factory) {
         this.factory = factory;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder workshop(final NameInfo workshop) {
         this.workshop = workshop;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder inQuantity(final Integer inQuantity) {
         this.inQuantity = inQuantity;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder unPackageQuantity(final Integer unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder packSerialNumber(final String packSerialNumber) {
         this.packSerialNumber = packSerialNumber;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public SendDirectlyDetailDO.SendDirectlyDetailDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SendDirectlyDetailDO build() {
         return new SendDirectlyDetailDO(
            this.id,
            this.factory,
            this.workshop,
            this.productId,
            this.inQuantity,
            this.packageQuantity,
            this.unPackageQuantity,
            this.artifactId,
            this.productType,
            this.packSerialNumber,
            this.licensePlate,
            this.status
         );
      }

      @Override
      public String toString() {
         return "SendDirectlyDetailDO.SendDirectlyDetailDOBuilder(id="
            + this.id
            + ", factory="
            + this.factory
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
            + ", artifactId="
            + this.artifactId
            + ", productType="
            + this.productType
            + ", packSerialNumber="
            + this.packSerialNumber
            + ", licensePlate="
            + this.licensePlate
            + ", status="
            + this.status
            + ")";
      }
   }
}
