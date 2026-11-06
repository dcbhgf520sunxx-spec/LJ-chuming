package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureCargoListProductNumberLink对象", description = "发运产品关联")
@Entity
@TableName("mes_enclosure_cargo_list_product_number_link")
@Table(name = "mes_enclosure_cargo_list_product_number_link")
public class MesEnclosureCargoListProductNumberLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cargoListId", value = "装车id", notes = "装车id")
   @JsonProperty("cargoListId")
   @JSONField(name = "cargoListId")
   @TableField("cargo_list_id")
   @Column(name = "cargo_list_id", columnDefinition = "bigint(20)  COMMENT '装车id'", nullable = false)
   private Long cargoListId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   @JsonProperty("packageId")
   @JSONField(name = "packageId")
   @TableField("package_id")
   @Column(name = "package_id", columnDefinition = "bigint(20)  COMMENT '包id'", nullable = true)
   private Long packageId;
   @ApiModelProperty(name = "cargoListLinkId", value = "装车详情id", notes = "装车详情id")
   @JsonProperty("cargoListLinkId")
   @JSONField(name = "cargoListLinkId")
   @TableField("cargo_list_link_id")
   @Column(name = "cargo_list_link_id", columnDefinition = "bigint(20)  COMMENT '装车详情id'", nullable = false)
   private Long cargoListLinkId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "number", value = "构件序号", notes = "构件序号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '构件序号'", nullable = false)
   private Integer number;

   public static MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder builder() {
      return new MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder();
   }

   public MesEnclosureCargoListProductNumberLink() {
   }

   public MesEnclosureCargoListProductNumberLink(
      final Long id, final Long cargoListId, final Long packageId, final Long cargoListLinkId, final Long productId, final Integer number
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.packageId = packageId;
      this.cargoListLinkId = cargoListLinkId;
      this.productId = productId;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getCargoListLinkId() {
      return this.cargoListLinkId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public MesEnclosureCargoListProductNumberLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesEnclosureCargoListProductNumberLink setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("packageId")
   public MesEnclosureCargoListProductNumberLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("cargoListLinkId")
   public MesEnclosureCargoListProductNumberLink setCargoListLinkId(final Long cargoListLinkId) {
      this.cargoListLinkId = cargoListLinkId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureCargoListProductNumberLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("number")
   public MesEnclosureCargoListProductNumberLink setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureCargoListProductNumberLink(id="
         + this.getId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", packageId="
         + this.getPackageId()
         + ", cargoListLinkId="
         + this.getCargoListLinkId()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureCargoListProductNumberLink)) {
         return false;
      }

      MesEnclosureCargoListProductNumberLink other = (MesEnclosureCargoListProductNumberLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$cargoListId = this.getCargoListId();
         Object other$cargoListId = other.getCargoListId();
         if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
            Object this$packageId = this.getPackageId();
            Object other$packageId = other.getPackageId();
            if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
               Object this$cargoListLinkId = this.getCargoListLinkId();
               Object other$cargoListLinkId = other.getCargoListLinkId();
               if (this$cargoListLinkId == null ? other$cargoListLinkId == null : this$cargoListLinkId.equals(other$cargoListLinkId)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof MesEnclosureCargoListProductNumberLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $cargoListLinkId = this.getCargoListLinkId();
      result = result * 59 + ($cargoListLinkId == null ? 43 : $cargoListLinkId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   public static class MesEnclosureCargoListProductNumberLinkBuilder {
      private Long id;
      private Long cargoListId;
      private Long packageId;
      private Long cargoListLinkId;
      private Long productId;
      private Integer number;

      MesEnclosureCargoListProductNumberLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("packageId")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("cargoListLinkId")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder cargoListLinkId(final Long cargoListLinkId) {
         this.cargoListLinkId = cargoListLinkId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("number")
      public MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesEnclosureCargoListProductNumberLink build() {
         return new MesEnclosureCargoListProductNumberLink(this.id, this.cargoListId, this.packageId, this.cargoListLinkId, this.productId, this.number);
      }

      @Override
      public String toString() {
         return "MesEnclosureCargoListProductNumberLink.MesEnclosureCargoListProductNumberLinkBuilder(id="
            + this.id
            + ", cargoListId="
            + this.cargoListId
            + ", packageId="
            + this.packageId
            + ", cargoListLinkId="
            + this.cargoListLinkId
            + ", productId="
            + this.productId
            + ", number="
            + this.number
            + ")";
      }
   }
}
