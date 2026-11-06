package com.hzchum.scim.mes.building.core.api.pojo._doModel._package;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingPackageNumberLink对象", description = "包的产品关联表")
@Entity
@TableName("mes_building_package_number_link")
@Table(
   name = "mes_building_package_number_link",
   indexes = {
         @Index(name = "product_number", columnList = "product_id,number,product_type"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date")
   }
)
public class MesBuildingPackageNumberLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "packageLinkId", value = "包id", notes = "包id")
   @JsonProperty("packageLinkId")
   @JSONField(name = "packageLinkId")
   @TableField("package_link_id")
   @Column(name = "package_link_id", columnDefinition = "bigint(20)  COMMENT '包关联id'", nullable = false)
   private Long packageLinkId;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   @JsonProperty("packageId")
   @JSONField(name = "packageId")
   @TableField("package_id")
   @Column(name = "package_id", columnDefinition = "bigint(20)  COMMENT '包id'", nullable = false)
   private Long packageId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "number", value = "一物一码序号", notes = "一物一码序号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '出入库id'", nullable = false)
   private Integer number;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) default 2 COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "warehouseType")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int(11) default '0' COMMENT ''", nullable = false)
   private Integer warehouseType;
   @ApiModelProperty(name = "inYearMonthDayDate")
   @JsonProperty("inYearMonthDayDate")
   @JSONField(name = "inYearMonthDayDate")
   @TableField(value = "in_year_month_day_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_day_date", columnDefinition = "varchar(564) COMMENT '日期(年-月-日)'")
   private String inYearMonthDayDate;
   @ApiModelProperty(name = "inYearMonthDate")
   @JsonProperty("inYearMonthDate")
   @JSONField(name = "inYearMonthDate")
   @TableField(value = "in_year_month_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_date", columnDefinition = "varchar(564) COMMENT '日期(年-月)'")
   private String inYearMonthDate;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '操作人名称'", nullable = true)
   private String userName;

   public static MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder builder() {
      return new MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder();
   }

   public MesBuildingPackageNumberLink() {
   }

   public MesBuildingPackageNumberLink(
      final Long id,
      final Long packageLinkId,
      final Long packageId,
      final Long productId,
      final Integer number,
      final Integer productType,
      final Integer warehouseType,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final String userName
   ) {
      this.id = id;
      this.packageLinkId = packageLinkId;
      this.packageId = packageId;
      this.productId = productId;
      this.number = number;
      this.productType = productType;
      this.warehouseType = warehouseType;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPackageLinkId() {
      return this.packageLinkId;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("id")
   public MesBuildingPackageNumberLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("packageLinkId")
   public MesBuildingPackageNumberLink setPackageLinkId(final Long packageLinkId) {
      this.packageLinkId = packageLinkId;
      return this;
   }

   @JsonProperty("packageId")
   public MesBuildingPackageNumberLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingPackageNumberLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingPackageNumberLink setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingPackageNumberLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("warehouseType")
   public MesBuildingPackageNumberLink setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingPackageNumberLink setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingPackageNumberLink setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingPackageNumberLink setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageNumberLink(id="
         + this.getId()
         + ", packageLinkId="
         + this.getPackageLinkId()
         + ", packageId="
         + this.getPackageId()
         + ", productId="
         + this.getProductId()
         + ", number="
         + this.getNumber()
         + ", productType="
         + this.getProductType()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageNumberLink)) {
         return false;
      }

      MesBuildingPackageNumberLink other = (MesBuildingPackageNumberLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$packageLinkId = this.getPackageLinkId();
         Object other$packageLinkId = other.getPackageLinkId();
         if (this$packageLinkId == null ? other$packageLinkId == null : this$packageLinkId.equals(other$packageLinkId)) {
            Object this$packageId = this.getPackageId();
            Object other$packageId = other.getPackageId();
            if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$number = this.getNumber();
                  Object other$number = other.getNumber();
                  if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$warehouseType = this.getWarehouseType();
                        Object other$warehouseType = other.getWarehouseType();
                        if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                           Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                           Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                           if (this$inYearMonthDayDate == null ? other$inYearMonthDayDate == null : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)) {
                              Object this$inYearMonthDate = this.getInYearMonthDate();
                              Object other$inYearMonthDate = other.getInYearMonthDate();
                              if (this$inYearMonthDate == null ? other$inYearMonthDate == null : this$inYearMonthDate.equals(other$inYearMonthDate)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof MesBuildingPackageNumberLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $packageLinkId = this.getPackageLinkId();
      result = result * 59 + ($packageLinkId == null ? 43 : $packageLinkId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      result = result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingPackageNumberLinkBuilder {
      private Long id;
      private Long packageLinkId;
      private Long packageId;
      private Long productId;
      private Integer number;
      private Integer productType;
      private Integer warehouseType;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private String userName;

      MesBuildingPackageNumberLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("packageLinkId")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder packageLinkId(final Long packageLinkId) {
         this.packageLinkId = packageLinkId;
         return this;
      }

      @JsonProperty("packageId")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("warehouseType")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingPackageNumberLink build() {
         return new MesBuildingPackageNumberLink(
            this.id,
            this.packageLinkId,
            this.packageId,
            this.productId,
            this.number,
            this.productType,
            this.warehouseType,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPackageNumberLink.MesBuildingPackageNumberLinkBuilder(id="
            + this.id
            + ", packageLinkId="
            + this.packageLinkId
            + ", packageId="
            + this.packageId
            + ", productId="
            + this.productId
            + ", number="
            + this.number
            + ", productType="
            + this.productType
            + ", warehouseType="
            + this.warehouseType
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
