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

@ApiModel(value = "MesEnclosureSupplierPrice对象", description = "物流单位价格")
@Entity
@TableName("mes_enclosure_supplier_price")
@Table(name = "mes_enclosure_supplier_price")
public class MesEnclosureSupplierPrice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "物流单位id", notes = "物流单位id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '物流单位id'")
   private Long supplierId;
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
   @Column(name = "price", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '价格'", nullable = false)
   private BigDecimal price;
   @ApiModelProperty(name = "invoiceTypeEnum", value = "发票类型[1 增值税专用发票 2 增值税普通发票 4 收据]", notes = "发票类型[1 增值税专用发票 2 增值税普通发票 4 收据]")
   @JsonProperty("invoiceTypeEnum")
   @JSONField(name = "invoiceTypeEnum")
   @TableField("invoice_type_enum")
   @Column(name = "invoice_type_enum", columnDefinition = "int(11) default '0' COMMENT '发票类型[1 增值税专用发票 2 增值税普通发票 4 收据]'", nullable = false)
   private Integer invoiceTypeEnum;
   @ApiModelProperty(name = "tax", value = "税率", notes = "税率")
   @JsonProperty("tax")
   @JSONField(name = "tax")
   @TableField("tax")
   @Column(name = "tax", columnDefinition = "decimal(32,8)  COMMENT '税率'", nullable = true)
   private BigDecimal tax;
   @ApiModelProperty(name = "userId", value = "填写人id", notes = "填写人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '填写人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "填写人名称", notes = "填写人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '填写人名称'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   @TableField("license_plate")
   @Column(name = "license_plate", columnDefinition = "varchar(64)  COMMENT '车牌号'")
   private String licensePlate;
   @ApiModelProperty(name = "boolPersonalEnum", value = "是否个人  ", notes = "是否个人 ")
   @JsonProperty("boolPersonalEnum")
   @JSONField(name = "boolPersonalEnum")
   @TableField("bool_personal_enum")
   @Column(name = "bool_personal_enum", columnDefinition = "tinyint(1) default '0'  COMMENT '是否个人'", nullable = false)
   private Boolean boolPersonalEnum;

   public static MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder builder() {
      return new MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder();
   }

   public MesEnclosureSupplierPrice() {
   }

   public MesEnclosureSupplierPrice(
      final Long id,
      final Long projectId,
      final Long supplierId,
      final Integer priceType,
      final BigDecimal price,
      final Integer invoiceTypeEnum,
      final BigDecimal tax,
      final Long userId,
      final String userName,
      final String licensePlate,
      final Boolean boolPersonalEnum
   ) {
      this.id = id;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.priceType = priceType;
      this.price = price;
      this.invoiceTypeEnum = invoiceTypeEnum;
      this.tax = tax;
      this.userId = userId;
      this.userName = userName;
      this.licensePlate = licensePlate;
      this.boolPersonalEnum = boolPersonalEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getInvoiceTypeEnum() {
      return this.invoiceTypeEnum;
   }

   public BigDecimal getTax() {
      return this.tax;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Boolean getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   @JsonProperty("id")
   public MesEnclosureSupplierPrice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureSupplierPrice setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("supplierId")
   public MesEnclosureSupplierPrice setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("priceType")
   public MesEnclosureSupplierPrice setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @JsonProperty("price")
   public MesEnclosureSupplierPrice setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("invoiceTypeEnum")
   public MesEnclosureSupplierPrice setInvoiceTypeEnum(final Integer invoiceTypeEnum) {
      this.invoiceTypeEnum = invoiceTypeEnum;
      return this;
   }

   @JsonProperty("tax")
   public MesEnclosureSupplierPrice setTax(final BigDecimal tax) {
      this.tax = tax;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureSupplierPrice setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureSupplierPrice setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("licensePlate")
   public MesEnclosureSupplierPrice setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   @JsonProperty("boolPersonalEnum")
   public MesEnclosureSupplierPrice setBoolPersonalEnum(final Boolean boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSupplierPrice(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ", invoiceTypeEnum="
         + this.getInvoiceTypeEnum()
         + ", tax="
         + this.getTax()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureSupplierPrice)) {
         return false;
      }

      MesEnclosureSupplierPrice other = (MesEnclosureSupplierPrice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$priceType = this.getPriceType();
               Object other$priceType = other.getPriceType();
               if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
                  Object this$invoiceTypeEnum = this.getInvoiceTypeEnum();
                  Object other$invoiceTypeEnum = other.getInvoiceTypeEnum();
                  if (this$invoiceTypeEnum == null ? other$invoiceTypeEnum == null : this$invoiceTypeEnum.equals(other$invoiceTypeEnum)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                        Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                        if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                           Object this$price = this.getPrice();
                           Object other$price = other.getPrice();
                           if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                              Object this$tax = this.getTax();
                              Object other$tax = other.getTax();
                              if (this$tax == null ? other$tax == null : this$tax.equals(other$tax)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureSupplierPrice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $invoiceTypeEnum = this.getInvoiceTypeEnum();
      result = result * 59 + ($invoiceTypeEnum == null ? 43 : $invoiceTypeEnum.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $tax = this.getTax();
      result = result * 59 + ($tax == null ? 43 : $tax.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      return result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
   }

   public static class MesEnclosureSupplierPriceBuilder {
      private Long id;
      private Long projectId;
      private Long supplierId;
      private Integer priceType;
      private BigDecimal price;
      private Integer invoiceTypeEnum;
      private BigDecimal tax;
      private Long userId;
      private String userName;
      private String licensePlate;
      private Boolean boolPersonalEnum;

      MesEnclosureSupplierPriceBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("supplierId")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("priceType")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      @JsonProperty("price")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("invoiceTypeEnum")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder invoiceTypeEnum(final Integer invoiceTypeEnum) {
         this.invoiceTypeEnum = invoiceTypeEnum;
         return this;
      }

      @JsonProperty("tax")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder tax(final BigDecimal tax) {
         this.tax = tax;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("licensePlate")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("boolPersonalEnum")
      public MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder boolPersonalEnum(final Boolean boolPersonalEnum) {
         this.boolPersonalEnum = boolPersonalEnum;
         return this;
      }

      public MesEnclosureSupplierPrice build() {
         return new MesEnclosureSupplierPrice(
            this.id,
            this.projectId,
            this.supplierId,
            this.priceType,
            this.price,
            this.invoiceTypeEnum,
            this.tax,
            this.userId,
            this.userName,
            this.licensePlate,
            this.boolPersonalEnum
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureSupplierPrice.MesEnclosureSupplierPriceBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", priceType="
            + this.priceType
            + ", price="
            + this.price
            + ", invoiceTypeEnum="
            + this.invoiceTypeEnum
            + ", tax="
            + this.tax
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", licensePlate="
            + this.licensePlate
            + ", boolPersonalEnum="
            + this.boolPersonalEnum
            + ")";
      }
   }
}
