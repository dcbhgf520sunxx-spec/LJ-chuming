package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

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

@ApiModel(value = "MesBuildingExternalRecord对象", description = "建刚生产外协产品记录")
@Entity
@TableName("mes_building_external_record")
@Table(name = "mes_building_external_record")
@org.hibernate.annotations.Table(appliesTo = "mes_building_external_record", comment = "建刚生产外协产品记录")
public class MesBuildingExternalRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "warehousingType", value = "外协产品类型", notes = "外协产品类型")
   @JsonProperty("warehousingType")
   @JSONField(name = "warehousingType")
   @TableField("warehousing_type")
   @Column(name = "warehousing_type", columnDefinition = "int(11)  COMMENT '外协产品类型'", nullable = true)
   private Integer warehousingType;
   @ApiModelProperty(name = "number", value = "一物一码号", notes = "一物一码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '一物一码号'", nullable = true)
   private Integer number;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   @JsonProperty("coding_type")
   @JSONField(name = "coding_type")
   @TableField("coding_type")
   @Column(name = "coding_type", columnDefinition = "int(2) default 2 comment '扫码方式'")
   private Integer codingType;
   @ApiModelProperty(name = "boolPrint", value = "是否已打印 1是 0否", notes = "是否已打印 1是 0否")
   @JsonProperty("boolPrint")
   @JSONField(name = "boolPrint")
   @TableField("bool_print")
   @Column(name = "bool_print", columnDefinition = "tinyint(1) default '0' COMMENT '是否已打印 1是 0否'", nullable = false)
   private Boolean boolPrint;
   @ApiModelProperty(name = "warehousing_id", value = "入库人ID", notes = "入库人ID")
   @JsonProperty("warehousing_id")
   @JSONField(name = "warehousing_id")
   @TableField("warehousing_id")
   @Column(name = "warehousing_id", columnDefinition = "bigint(20)  COMMENT '入库人ID'", nullable = true)
   private Long warehousingId;
   @ApiModelProperty(name = "outbounderId", value = "出库人ID", notes = "出库人ID")
   @JsonProperty("outbounderId")
   @JSONField(name = "outbounderId")
   @TableField("outbounder_id")
   @Column(name = "outbounder_id", columnDefinition = "bigint(20)  COMMENT '出库人ID'", nullable = true)
   private Long outbounderId;

   public static MesBuildingExternalRecord.MesBuildingExternalRecordBuilder builder() {
      return new MesBuildingExternalRecord.MesBuildingExternalRecordBuilder();
   }

   public MesBuildingExternalRecord() {
   }

   public MesBuildingExternalRecord(
      final Long id,
      final Long productId,
      final Long workshopId,
      final Integer quantity,
      final Integer warehousingType,
      final Integer number,
      final Integer codingType,
      final Boolean boolPrint,
      final Long warehousingId,
      final Long outbounderId
   ) {
      this.id = id;
      this.productId = productId;
      this.workshopId = workshopId;
      this.quantity = quantity;
      this.warehousingType = warehousingType;
      this.number = number;
      this.codingType = codingType;
      this.boolPrint = boolPrint;
      this.warehousingId = warehousingId;
      this.outbounderId = outbounderId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getWarehousingType() {
      return this.warehousingType;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Boolean getBoolPrint() {
      return this.boolPrint;
   }

   public Long getWarehousingId() {
      return this.warehousingId;
   }

   public Long getOutbounderId() {
      return this.outbounderId;
   }

   @JsonProperty("id")
   public MesBuildingExternalRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingExternalRecord setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingExternalRecord setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingExternalRecord setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("warehousingType")
   public MesBuildingExternalRecord setWarehousingType(final Integer warehousingType) {
      this.warehousingType = warehousingType;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingExternalRecord setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("coding_type")
   public MesBuildingExternalRecord setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   @JsonProperty("boolPrint")
   public MesBuildingExternalRecord setBoolPrint(final Boolean boolPrint) {
      this.boolPrint = boolPrint;
      return this;
   }

   @JsonProperty("warehousing_id")
   public MesBuildingExternalRecord setWarehousingId(final Long warehousingId) {
      this.warehousingId = warehousingId;
      return this;
   }

   @JsonProperty("outbounderId")
   public MesBuildingExternalRecord setOutbounderId(final Long outbounderId) {
      this.outbounderId = outbounderId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingExternalRecord(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", quantity="
         + this.getQuantity()
         + ", warehousingType="
         + this.getWarehousingType()
         + ", number="
         + this.getNumber()
         + ", codingType="
         + this.getCodingType()
         + ", boolPrint="
         + this.getBoolPrint()
         + ", warehousingId="
         + this.getWarehousingId()
         + ", outbounderId="
         + this.getOutbounderId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingExternalRecord)) {
         return false;
      }

      MesBuildingExternalRecord other = (MesBuildingExternalRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$warehousingType = this.getWarehousingType();
                  Object other$warehousingType = other.getWarehousingType();
                  if (this$warehousingType == null ? other$warehousingType == null : this$warehousingType.equals(other$warehousingType)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$codingType = this.getCodingType();
                        Object other$codingType = other.getCodingType();
                        if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                           Object this$boolPrint = this.getBoolPrint();
                           Object other$boolPrint = other.getBoolPrint();
                           if (this$boolPrint == null ? other$boolPrint == null : this$boolPrint.equals(other$boolPrint)) {
                              Object this$warehousingId = this.getWarehousingId();
                              Object other$warehousingId = other.getWarehousingId();
                              if (this$warehousingId == null ? other$warehousingId == null : this$warehousingId.equals(other$warehousingId)) {
                                 Object this$outbounderId = this.getOutbounderId();
                                 Object other$outbounderId = other.getOutbounderId();
                                 return this$outbounderId == null ? other$outbounderId == null : this$outbounderId.equals(other$outbounderId);
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
      return other instanceof MesBuildingExternalRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $warehousingType = this.getWarehousingType();
      result = result * 59 + ($warehousingType == null ? 43 : $warehousingType.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $boolPrint = this.getBoolPrint();
      result = result * 59 + ($boolPrint == null ? 43 : $boolPrint.hashCode());
      Object $warehousingId = this.getWarehousingId();
      result = result * 59 + ($warehousingId == null ? 43 : $warehousingId.hashCode());
      Object $outbounderId = this.getOutbounderId();
      return result * 59 + ($outbounderId == null ? 43 : $outbounderId.hashCode());
   }

   public static class MesBuildingExternalRecordBuilder {
      private Long id;
      private Long productId;
      private Long workshopId;
      private Integer quantity;
      private Integer warehousingType;
      private Integer number;
      private Integer codingType;
      private Boolean boolPrint;
      private Long warehousingId;
      private Long outbounderId;

      MesBuildingExternalRecordBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("warehousingType")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder warehousingType(final Integer warehousingType) {
         this.warehousingType = warehousingType;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("coding_type")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      @JsonProperty("boolPrint")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder boolPrint(final Boolean boolPrint) {
         this.boolPrint = boolPrint;
         return this;
      }

      @JsonProperty("warehousing_id")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder warehousingId(final Long warehousingId) {
         this.warehousingId = warehousingId;
         return this;
      }

      @JsonProperty("outbounderId")
      public MesBuildingExternalRecord.MesBuildingExternalRecordBuilder outbounderId(final Long outbounderId) {
         this.outbounderId = outbounderId;
         return this;
      }

      public MesBuildingExternalRecord build() {
         return new MesBuildingExternalRecord(
            this.id,
            this.productId,
            this.workshopId,
            this.quantity,
            this.warehousingType,
            this.number,
            this.codingType,
            this.boolPrint,
            this.warehousingId,
            this.outbounderId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingExternalRecord.MesBuildingExternalRecordBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", workshopId="
            + this.workshopId
            + ", quantity="
            + this.quantity
            + ", warehousingType="
            + this.warehousingType
            + ", number="
            + this.number
            + ", codingType="
            + this.codingType
            + ", boolPrint="
            + this.boolPrint
            + ", warehousingId="
            + this.warehousingId
            + ", outbounderId="
            + this.outbounderId
            + ")";
      }
   }
}
