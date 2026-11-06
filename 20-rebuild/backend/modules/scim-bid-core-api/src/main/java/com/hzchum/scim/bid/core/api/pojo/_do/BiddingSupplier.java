package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeDeserializer;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "招采-我的供应商", description = "")
@TableName("bidding_supplier")
@Table(name = "bidding_supplier")
public class BiddingSupplier implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "供应商id(投标方)")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "UUID", value = "系统唯一id")
   @JsonProperty("UUID")
   @JSONField(name = "UUID")
   @TableField("UUID")
   @Column(name = "UUID")
   private String UUID;
   @ApiModelProperty(name = "isBlock", value = "是否拉黑")
   @JsonProperty("isBlock")
   @JSONField(name = "isBlock")
   @TableField("is_block")
   @Column(name = "is_block", columnDefinition = "int default 0")
   private Integer isBlock;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT)
   @Column
   @JsonInclude(Include.NON_NULL)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime createTime;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT_UPDATE)
   @Column
   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime updateTime;
   @ApiModelProperty(hidden = true)
   @Version
   @Column
   @JsonIgnore
   private Integer version;

   public static BiddingSupplier.BiddingSupplierBuilder builder() {
      return new BiddingSupplier.BiddingSupplierBuilder();
   }

   public BiddingSupplier() {
   }

   public BiddingSupplier(
      final Long id,
      final Long supplierId,
      final String UUID,
      final Integer isBlock,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.UUID = UUID;
      this.isBlock = isBlock;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getUUID() {
      return this.UUID;
   }

   public Integer getIsBlock() {
      return this.isBlock;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getVersion() {
      return this.version;
   }

   @JsonProperty("id")
   public BiddingSupplier setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public BiddingSupplier setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("UUID")
   public BiddingSupplier setUUID(final String UUID) {
      this.UUID = UUID;
      return this;
   }

   @JsonProperty("isBlock")
   public BiddingSupplier setIsBlock(final Integer isBlock) {
      this.isBlock = isBlock;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public BiddingSupplier setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public BiddingSupplier setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public BiddingSupplier setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingSupplier)) {
         return false;
      }

      BiddingSupplier other = (BiddingSupplier)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$isBlock = this.getIsBlock();
            Object other$isBlock = other.getIsBlock();
            if (this$isBlock == null ? other$isBlock == null : this$isBlock.equals(other$isBlock)) {
               Object this$version = this.getVersion();
               Object other$version = other.getVersion();
               if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                  Object this$UUID = this.getUUID();
                  Object other$UUID = other.getUUID();
                  if (this$UUID == null ? other$UUID == null : this$UUID.equals(other$UUID)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$updateTime = this.getUpdateTime();
                        Object other$updateTime = other.getUpdateTime();
                        return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof BiddingSupplier;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $isBlock = this.getIsBlock();
      result = result * 59 + ($isBlock == null ? 43 : $isBlock.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $UUID = this.getUUID();
      result = result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingSupplier(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", UUID="
         + this.getUUID()
         + ", isBlock="
         + this.getIsBlock()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class BiddingSupplierBuilder {
      private Long id;
      private Long supplierId;
      private String UUID;
      private Integer isBlock;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      BiddingSupplierBuilder() {
      }

      @JsonProperty("id")
      public BiddingSupplier.BiddingSupplierBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public BiddingSupplier.BiddingSupplierBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("UUID")
      public BiddingSupplier.BiddingSupplierBuilder UUID(final String UUID) {
         this.UUID = UUID;
         return this;
      }

      @JsonProperty("isBlock")
      public BiddingSupplier.BiddingSupplierBuilder isBlock(final Integer isBlock) {
         this.isBlock = isBlock;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public BiddingSupplier.BiddingSupplierBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public BiddingSupplier.BiddingSupplierBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public BiddingSupplier.BiddingSupplierBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public BiddingSupplier build() {
         return new BiddingSupplier(this.id, this.supplierId, this.UUID, this.isBlock, this.createTime, this.updateTime, this.version);
      }

      @Override
      public String toString() {
         return "BiddingSupplier.BiddingSupplierBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", UUID="
            + this.UUID
            + ", isBlock="
            + this.isBlock
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", version="
            + this.version
            + ")";
      }
   }
}
