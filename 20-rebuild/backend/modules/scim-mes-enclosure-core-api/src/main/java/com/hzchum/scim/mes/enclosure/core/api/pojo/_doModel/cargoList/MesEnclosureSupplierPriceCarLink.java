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
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureSupplierPriceCarLink对象", description = "物流单位价格")
@Entity
@TableName("mes_enclosure_supplier_price_car_link")
@Table(name = "mes_enclosure_supplier_price_car_link")
public class MesEnclosureSupplierPriceCarLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierPriceId", value = "物流单位id", notes = "物流单位id")
   @JsonProperty("supplierPriceId")
   @JSONField(name = "supplierPriceId")
   @TableField("supplier_price_id")
   @Column(name = "supplier_price_id", columnDefinition = "bigint(20)  COMMENT '物流单位id'", nullable = false)
   private Long supplierPriceId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "carModel", value = "车型", notes = "车型")
   @JsonProperty("carModel")
   @JSONField(name = "carModel")
   @TableField("car_model")
   @Column(name = "car_model", columnDefinition = "varchar(55)  COMMENT '车型'", nullable = false)
   private String carModel;
   @ApiModelProperty(name = "priceType", value = "计价方式 1重量, 2 车次]", notes = "计价方式 1重量, 2 车次]")
   @JsonProperty("priceType")
   @JSONField(name = "priceType")
   @TableField("price_type")
   @Column(name = "price_type", columnDefinition = "int(11) default '1' COMMENT '计价方式 1重量, 2 车次]'", nullable = false)
   private Integer priceType;
   @ApiModelProperty(name = "price", value = "价格", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '价格'")
   private BigDecimal price;

   public static MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder builder() {
      return new MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder();
   }

   public MesEnclosureSupplierPriceCarLink() {
   }

   public MesEnclosureSupplierPriceCarLink(
      final Long id, final Long supplierPriceId, final Long projectId, final String carModel, final Integer priceType, final BigDecimal price
   ) {
      this.id = id;
      this.supplierPriceId = supplierPriceId;
      this.projectId = projectId;
      this.carModel = carModel;
      this.priceType = priceType;
      this.price = price;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public MesEnclosureSupplierPriceCarLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierPriceId")
   public MesEnclosureSupplierPriceCarLink setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureSupplierPriceCarLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("carModel")
   public MesEnclosureSupplierPriceCarLink setCarModel(final String carModel) {
      this.carModel = carModel;
      return this;
   }

   @JsonProperty("priceType")
   public MesEnclosureSupplierPriceCarLink setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureSupplierPriceCarLink setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSupplierPriceCarLink(id="
         + this.getId()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", projectId="
         + this.getProjectId()
         + ", carModel="
         + this.getCarModel()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSupplierPriceCarLink)) {
         return false;
      }

      MesEnclosureSupplierPriceCarLink other = (MesEnclosureSupplierPriceCarLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierPriceId = this.getSupplierPriceId();
         Object other$supplierPriceId = other.getSupplierPriceId();
         if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$priceType = this.getPriceType();
               Object other$priceType = other.getPriceType();
               if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                  Object this$carModel = this.getCarModel();
                  Object other$carModel = other.getCarModel();
                  if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesEnclosureSupplierPriceCarLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesEnclosureSupplierPriceCarLinkBuilder {
      private Long id;
      private Long supplierPriceId;
      private Long projectId;
      private String carModel;
      private Integer priceType;
      private BigDecimal price;

      MesEnclosureSupplierPriceCarLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierPriceId")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder supplierPriceId(final Long supplierPriceId) {
         this.supplierPriceId = supplierPriceId;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("carModel")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder carModel(final String carModel) {
         this.carModel = carModel;
         return this;
      }

      @JsonProperty("priceType")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesEnclosureSupplierPriceCarLink build() {
         return new MesEnclosureSupplierPriceCarLink(this.id, this.supplierPriceId, this.projectId, this.carModel, this.priceType, this.price);
      }

      @Override
      public String toString() {
         return "MesEnclosureSupplierPriceCarLink.MesEnclosureSupplierPriceCarLinkBuilder(id="
            + this.id
            + ", supplierPriceId="
            + this.supplierPriceId
            + ", projectId="
            + this.projectId
            + ", carModel="
            + this.carModel
            + ", priceType="
            + this.priceType
            + ", price="
            + this.price
            + ")";
      }
   }
}
