package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

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

@ApiModel(value = "MesBuildingCargoListProductNumberLink对象", description = "发运产品关联")
@Entity
@TableName("mes_building_cargo_list_product_number_link")
@Table(
   name = "mes_building_cargo_list_product_number_link",
   indexes = {
         @Index(name = "product_number", columnList = "product_id,number,product_type"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date"),
         @Index(name = "cargo_list_link_id", columnList = "cargo_list_link_id"),
         @Index(name = "cargo_list_id", columnList = "cargo_list_id")
   }
)
public class MesBuildingCargoListProductNumberLink extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) default 2 COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "boolCancelShip", value = "是否取消发运 ", notes = "是否取消发运")
   @JsonProperty("boolCancelShip")
   @JSONField(name = "boolCancelShip")
   @TableField("bool_cancel_ship")
   @Column(name = "bool_cancel_ship", columnDefinition = "tinyint(1) default 0  COMMENT '是否取消发运'")
   private Boolean boolCancelShip;
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

   public static MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder builder() {
      return new MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder();
   }

   public MesBuildingCargoListProductNumberLink() {
   }

   public MesBuildingCargoListProductNumberLink(
      final Long id,
      final Long cargoListId,
      final Long packageId,
      final Long cargoListLinkId,
      final Long productId,
      final Integer number,
      final Integer productType,
      final Boolean boolCancelShip,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final String userName
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.packageId = packageId;
      this.cargoListLinkId = cargoListLinkId;
      this.productId = productId;
      this.number = number;
      this.productType = productType;
      this.boolCancelShip = boolCancelShip;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.userName = userName;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getBoolCancelShip() {
      return this.boolCancelShip;
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
   public MesBuildingCargoListProductNumberLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesBuildingCargoListProductNumberLink setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("packageId")
   public MesBuildingCargoListProductNumberLink setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   @JsonProperty("cargoListLinkId")
   public MesBuildingCargoListProductNumberLink setCargoListLinkId(final Long cargoListLinkId) {
      this.cargoListLinkId = cargoListLinkId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingCargoListProductNumberLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingCargoListProductNumberLink setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingCargoListProductNumberLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("boolCancelShip")
   public MesBuildingCargoListProductNumberLink setBoolCancelShip(final Boolean boolCancelShip) {
      this.boolCancelShip = boolCancelShip;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingCargoListProductNumberLink setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingCargoListProductNumberLink setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingCargoListProductNumberLink setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCargoListProductNumberLink(id="
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
         + ", productType="
         + this.getProductType()
         + ", boolCancelShip="
         + this.getBoolCancelShip()
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

      if (!(o instanceof MesBuildingCargoListProductNumberLink)) {
         return false;
      }

      MesBuildingCargoListProductNumberLink other = (MesBuildingCargoListProductNumberLink)o;
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
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$boolCancelShip = this.getBoolCancelShip();
                           Object other$boolCancelShip = other.getBoolCancelShip();
                           if (this$boolCancelShip == null ? other$boolCancelShip == null : this$boolCancelShip.equals(other$boolCancelShip)) {
                              Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                              Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                              if (this$inYearMonthDayDate == null ? other$inYearMonthDayDate == null : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)
                                 )
                               {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCargoListProductNumberLink;
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
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $boolCancelShip = this.getBoolCancelShip();
      result = result * 59 + ($boolCancelShip == null ? 43 : $boolCancelShip.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      result = result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingCargoListProductNumberLinkBuilder {
      private Long id;
      private Long cargoListId;
      private Long packageId;
      private Long cargoListLinkId;
      private Long productId;
      private Integer number;
      private Integer productType;
      private Boolean boolCancelShip;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private String userName;

      MesBuildingCargoListProductNumberLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("packageId")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      @JsonProperty("cargoListLinkId")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder cargoListLinkId(final Long cargoListLinkId) {
         this.cargoListLinkId = cargoListLinkId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("boolCancelShip")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder boolCancelShip(final Boolean boolCancelShip) {
         this.boolCancelShip = boolCancelShip;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingCargoListProductNumberLink build() {
         return new MesBuildingCargoListProductNumberLink(
            this.id,
            this.cargoListId,
            this.packageId,
            this.cargoListLinkId,
            this.productId,
            this.number,
            this.productType,
            this.boolCancelShip,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCargoListProductNumberLink.MesBuildingCargoListProductNumberLinkBuilder(id="
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
            + ", productType="
            + this.productType
            + ", boolCancelShip="
            + this.boolCancelShip
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
