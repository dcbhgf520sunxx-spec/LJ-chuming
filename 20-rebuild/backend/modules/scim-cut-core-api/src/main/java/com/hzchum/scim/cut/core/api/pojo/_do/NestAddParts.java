package com.hzchum.scim.cut.core.api.pojo._do;

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

@ApiModel(value = "NestAddParts对象", description = "")
@Entity
@TableName("nest_add_parts")
@Table(name = "nest_add_parts")
public class NestAddParts extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "partSchedulingLinkId")
   @JsonProperty("partSchedulingLinkId")
   @JSONField(name = "partSchedulingLinkId")
   @TableField("part_scheduling_link_id")
   @Column(name = "part_scheduling_link_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long partSchedulingLinkId;
   @ApiModelProperty(name = "quantity")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "state")
   @JsonProperty("state")
   @JSONField(name = "state")
   @TableField("state")
   @Column(name = "state", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer state;

   public static NestAddParts.NestAddPartsBuilder builder() {
      return new NestAddParts.NestAddPartsBuilder();
   }

   public NestAddParts() {
   }

   public NestAddParts(final Long id, final Long partSchedulingLinkId, final Integer quantity, final Integer state) {
      this.id = id;
      this.partSchedulingLinkId = partSchedulingLinkId;
      this.quantity = quantity;
      this.state = state;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPartSchedulingLinkId() {
      return this.partSchedulingLinkId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getState() {
      return this.state;
   }

   @JsonProperty("id")
   public NestAddParts setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("partSchedulingLinkId")
   public NestAddParts setPartSchedulingLinkId(final Long partSchedulingLinkId) {
      this.partSchedulingLinkId = partSchedulingLinkId;
      return this;
   }

   @JsonProperty("quantity")
   public NestAddParts setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("state")
   public NestAddParts setState(final Integer state) {
      this.state = state;
      return this;
   }

   @Override
   public String toString() {
      return "NestAddParts(id="
         + this.getId()
         + ", partSchedulingLinkId="
         + this.getPartSchedulingLinkId()
         + ", quantity="
         + this.getQuantity()
         + ", state="
         + this.getState()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestAddParts)) {
         return false;
      }

      NestAddParts other = (NestAddParts)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partSchedulingLinkId = this.getPartSchedulingLinkId();
         Object other$partSchedulingLinkId = other.getPartSchedulingLinkId();
         if (this$partSchedulingLinkId == null ? other$partSchedulingLinkId == null : this$partSchedulingLinkId.equals(other$partSchedulingLinkId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$state = this.getState();
               Object other$state = other.getState();
               return this$state == null ? other$state == null : this$state.equals(other$state);
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
      return other instanceof NestAddParts;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partSchedulingLinkId = this.getPartSchedulingLinkId();
      result = result * 59 + ($partSchedulingLinkId == null ? 43 : $partSchedulingLinkId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $state = this.getState();
      return result * 59 + ($state == null ? 43 : $state.hashCode());
   }

   public static class NestAddPartsBuilder {
      private Long id;
      private Long partSchedulingLinkId;
      private Integer quantity;
      private Integer state;

      NestAddPartsBuilder() {
      }

      @JsonProperty("id")
      public NestAddParts.NestAddPartsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("partSchedulingLinkId")
      public NestAddParts.NestAddPartsBuilder partSchedulingLinkId(final Long partSchedulingLinkId) {
         this.partSchedulingLinkId = partSchedulingLinkId;
         return this;
      }

      @JsonProperty("quantity")
      public NestAddParts.NestAddPartsBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("state")
      public NestAddParts.NestAddPartsBuilder state(final Integer state) {
         this.state = state;
         return this;
      }

      public NestAddParts build() {
         return new NestAddParts(this.id, this.partSchedulingLinkId, this.quantity, this.state);
      }

      @Override
      public String toString() {
         return "NestAddParts.NestAddPartsBuilder(id="
            + this.id
            + ", partSchedulingLinkId="
            + this.partSchedulingLinkId
            + ", quantity="
            + this.quantity
            + ", state="
            + this.state
            + ")";
      }
   }
}
