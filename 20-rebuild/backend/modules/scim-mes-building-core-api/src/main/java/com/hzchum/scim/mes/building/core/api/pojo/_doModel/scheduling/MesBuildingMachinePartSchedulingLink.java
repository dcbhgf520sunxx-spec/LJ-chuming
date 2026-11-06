package com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingMachinePartSchedulingLink对象", description = "")
@Entity
@TableName("mes_building_machine_part_scheduling_link")
@Table(name = "mes_building_machine_part_scheduling_link", indexes = @Index(name = "productId_index", columnList = "product_id"))
public class MesBuildingMachinePartSchedulingLink extends BaseEntity<Long> {
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
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'", nullable = false)
   private Long schedulingId;
   @ApiModelProperty(name = "quantity", value = "排产数量", notes = "排产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '排产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "prdRef")
   @JsonProperty("prdRef")
   @JSONField(name = "prdRef")
   @TableField("prd_ref")
   @Column(name = "prd_ref", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String prdRef;

   public static MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder builder() {
      return new MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder();
   }

   public MesBuildingMachinePartSchedulingLink() {
   }

   public MesBuildingMachinePartSchedulingLink(
      final Long id, final Long productId, final Long schedulingId, final Integer quantity, final Long userId, final String prdRef
   ) {
      this.id = id;
      this.productId = productId;
      this.schedulingId = schedulingId;
      this.quantity = quantity;
      this.userId = userId;
      this.prdRef = prdRef;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getPrdRef() {
      return this.prdRef;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingMachinePartSchedulingLink setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingMachinePartSchedulingLink setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingLink setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartSchedulingLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("prdRef")
   public MesBuildingMachinePartSchedulingLink setPrdRef(final String prdRef) {
      this.prdRef = prdRef;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingLink(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", prdRef="
         + this.getPrdRef()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingLink)) {
         return false;
      }

      MesBuildingMachinePartSchedulingLink other = (MesBuildingMachinePartSchedulingLink)o;
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
            Object this$schedulingId = this.getSchedulingId();
            Object other$schedulingId = other.getSchedulingId();
            if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$prdRef = this.getPrdRef();
                     Object other$prdRef = other.getPrdRef();
                     return this$prdRef == null ? other$prdRef == null : this$prdRef.equals(other$prdRef);
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
      return other instanceof MesBuildingMachinePartSchedulingLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $prdRef = this.getPrdRef();
      return result * 59 + ($prdRef == null ? 43 : $prdRef.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingLinkBuilder {
      private Long id;
      private Long productId;
      private Long schedulingId;
      private Integer quantity;
      private Long userId;
      private String prdRef;

      MesBuildingMachinePartSchedulingLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("prdRef")
      public MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder prdRef(final String prdRef) {
         this.prdRef = prdRef;
         return this;
      }

      public MesBuildingMachinePartSchedulingLink build() {
         return new MesBuildingMachinePartSchedulingLink(this.id, this.productId, this.schedulingId, this.quantity, this.userId, this.prdRef);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingLink.MesBuildingMachinePartSchedulingLinkBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", schedulingId="
            + this.schedulingId
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", prdRef="
            + this.prdRef
            + ")";
      }
   }
}
