package com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList;

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

@ApiModel(value = "MesBuildingCargoListChange对象", description = "发运表")
@Entity
@TableName("mes_building_cargo_list_change")
@Table(name = "mes_building_cargo_list_change")
public class MesBuildingCargoListChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "cargoListId", value = "发运id", notes = "发运id")
   @JsonProperty("cargoListId")
   @JSONField(name = "cargoListId")
   @TableField("cargo_list_id")
   @Column(name = "cargo_list_id", columnDefinition = "bigint(20)  COMMENT '发运id'", nullable = false)
   private Long cargoListId;
   @ApiModelProperty(name = "totalPrice", value = "总价格", notes = "总价格")
   @JsonProperty("totalPrice")
   @JSONField(name = "totalPrice")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8)  COMMENT '总价格'", nullable = false)
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "price", value = "单价", notes = "单价")
   @JsonProperty("price")
   @JSONField(name = "price")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8)  COMMENT '单价'", nullable = false)
   private BigDecimal price;
   @ApiModelProperty(name = "priceType", value = "物流价格类型", notes = "物流价格类型")
   @JsonProperty("priceType")
   @JSONField(name = "priceType")
   @TableField("price_type")
   @Column(name = "price_type", columnDefinition = "int(11)  COMMENT '物流价格类型'", nullable = false)
   private Integer priceType;
   @ApiModelProperty(name = "changeUserId", value = "修改人id", notes = "修改人id")
   @JsonProperty("changeUserId")
   @JSONField(name = "changeUserId")
   @TableField("change_user_id")
   @Column(name = "change_user_id", columnDefinition = "bigint(20)  COMMENT '修改人id'", nullable = false)
   private Long changeUserId;
   @ApiModelProperty(name = "changeUserName", value = "修改人", notes = "修改人")
   @JsonProperty("changeUserName")
   @JSONField(name = "changeUserName")
   @TableField("change_user_name")
   @Column(name = "change_user_name", columnDefinition = "varchar(255)  COMMENT '修改人'", nullable = false)
   private String changeUserName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)   COMMENT '备注'")
   private String remark;

   public static MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder builder() {
      return new MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder();
   }

   public MesBuildingCargoListChange() {
   }

   public MesBuildingCargoListChange(
      final Long id,
      final Long cargoListId,
      final BigDecimal totalPrice,
      final BigDecimal price,
      final Integer priceType,
      final Long changeUserId,
      final String changeUserName,
      final String remark
   ) {
      this.id = id;
      this.cargoListId = cargoListId;
      this.totalPrice = totalPrice;
      this.price = price;
      this.priceType = priceType;
      this.changeUserId = changeUserId;
      this.changeUserName = changeUserName;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public Long getChangeUserId() {
      return this.changeUserId;
   }

   public String getChangeUserName() {
      return this.changeUserName;
   }

   public String getRemark() {
      return this.remark;
   }

   @JsonProperty("id")
   public MesBuildingCargoListChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("cargoListId")
   public MesBuildingCargoListChange setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   @JsonProperty("totalPrice")
   public MesBuildingCargoListChange setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("price")
   public MesBuildingCargoListChange setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @JsonProperty("priceType")
   public MesBuildingCargoListChange setPriceType(final Integer priceType) {
      this.priceType = priceType;
      return this;
   }

   @JsonProperty("changeUserId")
   public MesBuildingCargoListChange setChangeUserId(final Long changeUserId) {
      this.changeUserId = changeUserId;
      return this;
   }

   @JsonProperty("changeUserName")
   public MesBuildingCargoListChange setChangeUserName(final String changeUserName) {
      this.changeUserName = changeUserName;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingCargoListChange setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCargoListChange(id="
         + this.getId()
         + ", cargoListId="
         + this.getCargoListId()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", price="
         + this.getPrice()
         + ", priceType="
         + this.getPriceType()
         + ", changeUserId="
         + this.getChangeUserId()
         + ", changeUserName="
         + this.getChangeUserName()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCargoListChange)) {
         return false;
      }

      MesBuildingCargoListChange other = (MesBuildingCargoListChange)o;
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
            Object this$priceType = this.getPriceType();
            Object other$priceType = other.getPriceType();
            if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
               Object this$changeUserId = this.getChangeUserId();
               Object other$changeUserId = other.getChangeUserId();
               if (this$changeUserId == null ? other$changeUserId == null : this$changeUserId.equals(other$changeUserId)) {
                  Object this$totalPrice = this.getTotalPrice();
                  Object other$totalPrice = other.getTotalPrice();
                  if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                     Object this$price = this.getPrice();
                     Object other$price = other.getPrice();
                     if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                        Object this$changeUserName = this.getChangeUserName();
                        Object other$changeUserName = other.getChangeUserName();
                        if (this$changeUserName == null ? other$changeUserName == null : this$changeUserName.equals(other$changeUserName)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MesBuildingCargoListChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $changeUserId = this.getChangeUserId();
      result = result * 59 + ($changeUserId == null ? 43 : $changeUserId.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $changeUserName = this.getChangeUserName();
      result = result * 59 + ($changeUserName == null ? 43 : $changeUserName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesBuildingCargoListChangeBuilder {
      private Long id;
      private Long cargoListId;
      private BigDecimal totalPrice;
      private BigDecimal price;
      private Integer priceType;
      private Long changeUserId;
      private String changeUserName;
      private String remark;

      MesBuildingCargoListChangeBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("cargoListId")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      @JsonProperty("totalPrice")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("price")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      @JsonProperty("priceType")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder priceType(final Integer priceType) {
         this.priceType = priceType;
         return this;
      }

      @JsonProperty("changeUserId")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder changeUserId(final Long changeUserId) {
         this.changeUserId = changeUserId;
         return this;
      }

      @JsonProperty("changeUserName")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder changeUserName(final String changeUserName) {
         this.changeUserName = changeUserName;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesBuildingCargoListChange build() {
         return new MesBuildingCargoListChange(
            this.id, this.cargoListId, this.totalPrice, this.price, this.priceType, this.changeUserId, this.changeUserName, this.remark
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCargoListChange.MesBuildingCargoListChangeBuilder(id="
            + this.id
            + ", cargoListId="
            + this.cargoListId
            + ", totalPrice="
            + this.totalPrice
            + ", price="
            + this.price
            + ", priceType="
            + this.priceType
            + ", changeUserId="
            + this.changeUserId
            + ", changeUserName="
            + this.changeUserName
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
