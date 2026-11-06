package com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class ProductKanBanDO {
   @ApiModelProperty(name = "id", notes = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inProductionQuantity", notes = "进入生产数")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "quantity", notes = "清单量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "pictureUrl", notes = "图片路径")
   @JsonProperty("pictureUrl")
   @JSONField(name = "pictureUrl")
   private String pictureUrl;

   public static ProductKanBanDO.ProductKanBanDOBuilder builder() {
      return new ProductKanBanDO.ProductKanBanDOBuilder();
   }

   public ProductKanBanDO() {
   }

   public ProductKanBanDO(
      final Long id,
      final Long monomerId,
      final Long areaId,
      final String name,
      final String serialNumber,
      final String specification,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final Integer inProductionQuantity,
      final Integer quantity,
      final BigDecimal netWeight,
      final Integer productType,
      final String pictureUrl
   ) {
      this.id = id;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.productType = productType;
      this.pictureUrl = pictureUrl;
   }

   public Long getId() {
      return this.id;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getPictureUrl() {
      return this.pictureUrl;
   }

   @JsonProperty("id")
   public ProductKanBanDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("monomerId")
   public ProductKanBanDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProductKanBanDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("name")
   public ProductKanBanDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProductKanBanDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public ProductKanBanDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ProductKanBanDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ProductKanBanDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public ProductKanBanDO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public ProductKanBanDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public ProductKanBanDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("productType")
   public ProductKanBanDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("pictureUrl")
   public ProductKanBanDO setPictureUrl(final String pictureUrl) {
      this.pictureUrl = pictureUrl;
      return this;
   }

   @Override
   public String toString() {
      return "ProductKanBanDO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", productType="
         + this.getProductType()
         + ", pictureUrl="
         + this.getPictureUrl()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductKanBanDO)) {
         return false;
      }

      ProductKanBanDO other = (ProductKanBanDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                     Object this$inProductionQuantity = this.getInProductionQuantity();
                     Object other$inProductionQuantity = other.getInProductionQuantity();
                     if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$productType = this.getProductType();
                           Object other$productType = other.getProductType();
                           if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$netWeight = this.getNetWeight();
                                       Object other$netWeight = other.getNetWeight();
                                       if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                          Object this$pictureUrl = this.getPictureUrl();
                                          Object other$pictureUrl = other.getPictureUrl();
                                          return this$pictureUrl == null ? other$pictureUrl == null : this$pictureUrl.equals(other$pictureUrl);
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
      return other instanceof ProductKanBanDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $pictureUrl = this.getPictureUrl();
      return result * 59 + ($pictureUrl == null ? 43 : $pictureUrl.hashCode());
   }

   public static class ProductKanBanDOBuilder {
      private Long id;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String serialNumber;
      private String specification;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private Integer inProductionQuantity;
      private Integer quantity;
      private BigDecimal netWeight;
      private Integer productType;
      private String pictureUrl;

      ProductKanBanDOBuilder() {
      }

      @JsonProperty("id")
      public ProductKanBanDO.ProductKanBanDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("monomerId")
      public ProductKanBanDO.ProductKanBanDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProductKanBanDO.ProductKanBanDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("name")
      public ProductKanBanDO.ProductKanBanDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProductKanBanDO.ProductKanBanDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public ProductKanBanDO.ProductKanBanDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ProductKanBanDO.ProductKanBanDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ProductKanBanDO.ProductKanBanDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public ProductKanBanDO.ProductKanBanDOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public ProductKanBanDO.ProductKanBanDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public ProductKanBanDO.ProductKanBanDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("productType")
      public ProductKanBanDO.ProductKanBanDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("pictureUrl")
      public ProductKanBanDO.ProductKanBanDOBuilder pictureUrl(final String pictureUrl) {
         this.pictureUrl = pictureUrl;
         return this;
      }

      public ProductKanBanDO build() {
         return new ProductKanBanDO(
            this.id,
            this.monomerId,
            this.areaId,
            this.name,
            this.serialNumber,
            this.specification,
            this.taskQuantity,
            this.completeQuantity,
            this.inProductionQuantity,
            this.quantity,
            this.netWeight,
            this.productType,
            this.pictureUrl
         );
      }

      @Override
      public String toString() {
         return "ProductKanBanDO.ProductKanBanDOBuilder(id="
            + this.id
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", quantity="
            + this.quantity
            + ", netWeight="
            + this.netWeight
            + ", productType="
            + this.productType
            + ", pictureUrl="
            + this.pictureUrl
            + ")";
      }
   }
}
