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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "项目与供应商关联表", description = "")
@TableName("project_tendering_supplier")
@Table(name = "project_tendering_supplier")
public class ProjectTenderingSupplier implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "供应商id(我的供应商列表)")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "bidSupplierId", value = "投标端供应商id")
   @JsonProperty("bidSupplierId")
   @JSONField(name = "bidSupplierId")
   @TableField("bid_supplier_id")
   @Column(name = "bid_supplier_id")
   private Long bidSupplierId;
   @ApiModelProperty(name = "bidStatus", value = "应标状态")
   @JsonProperty("bidStatus")
   @JSONField(name = "bidStatus")
   @TableField("bid_status")
   @Column(name = "bid_status", columnDefinition = "int default 0")
   private Integer bidStatus;
   @ApiModelProperty(name = "biddingTime", value = "应标时间")
   @JsonProperty("biddingTime")
   @JSONField(name = "biddingTime")
   @TableField("bidding_time")
   @Column(name = "bidding_time")
   private Date biddingTime;
   @ApiModelProperty(name = "projectTenderingId", value = "招采项目id")
   @JsonProperty("projectTenderingId")
   @JSONField(name = "projectTenderingId")
   @TableField("project_tendering_id")
   @Column(name = "project_tendering_id")
   private Long projectTenderingId;
   @ApiModelProperty(name = "UUID", value = "系统唯一id")
   @JsonProperty("UUID")
   @JSONField(name = "UUID")
   @TableField("UUID")
   @Column(name = "UUID")
   private String UUID;
   @ApiModelProperty(name = "result", value = "是否已完成")
   @JsonProperty("result")
   @JSONField(name = "result")
   @TableField("result")
   @Column(name = "result", columnDefinition = "int default 0")
   private Integer result;
   @ApiModelProperty(name = "source", value = "来源")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source", columnDefinition = "int default 0")
   private Integer source;
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

   public static ProjectTenderingSupplier.ProjectTenderingSupplierBuilder builder() {
      return new ProjectTenderingSupplier.ProjectTenderingSupplierBuilder();
   }

   public ProjectTenderingSupplier() {
   }

   public ProjectTenderingSupplier(
      final Long id,
      final Long supplierId,
      final Long bidSupplierId,
      final Integer bidStatus,
      final Date biddingTime,
      final Long projectTenderingId,
      final String UUID,
      final Integer result,
      final Integer source,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.bidSupplierId = bidSupplierId;
      this.bidStatus = bidStatus;
      this.biddingTime = biddingTime;
      this.projectTenderingId = projectTenderingId;
      this.UUID = UUID;
      this.result = result;
      this.source = source;
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

   public Long getBidSupplierId() {
      return this.bidSupplierId;
   }

   public Integer getBidStatus() {
      return this.bidStatus;
   }

   public Date getBiddingTime() {
      return this.biddingTime;
   }

   public Long getProjectTenderingId() {
      return this.projectTenderingId;
   }

   public String getUUID() {
      return this.UUID;
   }

   public Integer getResult() {
      return this.result;
   }

   public Integer getSource() {
      return this.source;
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
   public ProjectTenderingSupplier setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public ProjectTenderingSupplier setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("bidSupplierId")
   public ProjectTenderingSupplier setBidSupplierId(final Long bidSupplierId) {
      this.bidSupplierId = bidSupplierId;
      return this;
   }

   @JsonProperty("bidStatus")
   public ProjectTenderingSupplier setBidStatus(final Integer bidStatus) {
      this.bidStatus = bidStatus;
      return this;
   }

   @JsonProperty("biddingTime")
   public ProjectTenderingSupplier setBiddingTime(final Date biddingTime) {
      this.biddingTime = biddingTime;
      return this;
   }

   @JsonProperty("projectTenderingId")
   public ProjectTenderingSupplier setProjectTenderingId(final Long projectTenderingId) {
      this.projectTenderingId = projectTenderingId;
      return this;
   }

   @JsonProperty("UUID")
   public ProjectTenderingSupplier setUUID(final String UUID) {
      this.UUID = UUID;
      return this;
   }

   @JsonProperty("result")
   public ProjectTenderingSupplier setResult(final Integer result) {
      this.result = result;
      return this;
   }

   @JsonProperty("source")
   public ProjectTenderingSupplier setSource(final Integer source) {
      this.source = source;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public ProjectTenderingSupplier setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public ProjectTenderingSupplier setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public ProjectTenderingSupplier setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectTenderingSupplier)) {
         return false;
      }

      ProjectTenderingSupplier other = (ProjectTenderingSupplier)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$bidSupplierId = this.getBidSupplierId();
            Object other$bidSupplierId = other.getBidSupplierId();
            if (this$bidSupplierId == null ? other$bidSupplierId == null : this$bidSupplierId.equals(other$bidSupplierId)) {
               Object this$bidStatus = this.getBidStatus();
               Object other$bidStatus = other.getBidStatus();
               if (this$bidStatus == null ? other$bidStatus == null : this$bidStatus.equals(other$bidStatus)) {
                  Object this$projectTenderingId = this.getProjectTenderingId();
                  Object other$projectTenderingId = other.getProjectTenderingId();
                  if (this$projectTenderingId == null ? other$projectTenderingId == null : this$projectTenderingId.equals(other$projectTenderingId)) {
                     Object this$result = this.getResult();
                     Object other$result = other.getResult();
                     if (this$result == null ? other$result == null : this$result.equals(other$result)) {
                        Object this$source = this.getSource();
                        Object other$source = other.getSource();
                        if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                           Object this$version = this.getVersion();
                           Object other$version = other.getVersion();
                           if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                              Object this$biddingTime = this.getBiddingTime();
                              Object other$biddingTime = other.getBiddingTime();
                              if (this$biddingTime == null ? other$biddingTime == null : this$biddingTime.equals(other$biddingTime)) {
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
      return other instanceof ProjectTenderingSupplier;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $bidSupplierId = this.getBidSupplierId();
      result = result * 59 + ($bidSupplierId == null ? 43 : $bidSupplierId.hashCode());
      Object $bidStatus = this.getBidStatus();
      result = result * 59 + ($bidStatus == null ? 43 : $bidStatus.hashCode());
      Object $projectTenderingId = this.getProjectTenderingId();
      result = result * 59 + ($projectTenderingId == null ? 43 : $projectTenderingId.hashCode());
      Object $result = this.getResult();
      result = result * 59 + ($result == null ? 43 : $result.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $biddingTime = this.getBiddingTime();
      result = result * 59 + ($biddingTime == null ? 43 : $biddingTime.hashCode());
      Object $UUID = this.getUUID();
      result = result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectTenderingSupplier(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", bidSupplierId="
         + this.getBidSupplierId()
         + ", bidStatus="
         + this.getBidStatus()
         + ", biddingTime="
         + this.getBiddingTime()
         + ", projectTenderingId="
         + this.getProjectTenderingId()
         + ", UUID="
         + this.getUUID()
         + ", result="
         + this.getResult()
         + ", source="
         + this.getSource()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class ProjectTenderingSupplierBuilder {
      private Long id;
      private Long supplierId;
      private Long bidSupplierId;
      private Integer bidStatus;
      private Date biddingTime;
      private Long projectTenderingId;
      private String UUID;
      private Integer result;
      private Integer source;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      ProjectTenderingSupplierBuilder() {
      }

      @JsonProperty("id")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("bidSupplierId")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder bidSupplierId(final Long bidSupplierId) {
         this.bidSupplierId = bidSupplierId;
         return this;
      }

      @JsonProperty("bidStatus")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder bidStatus(final Integer bidStatus) {
         this.bidStatus = bidStatus;
         return this;
      }

      @JsonProperty("biddingTime")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder biddingTime(final Date biddingTime) {
         this.biddingTime = biddingTime;
         return this;
      }

      @JsonProperty("projectTenderingId")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder projectTenderingId(final Long projectTenderingId) {
         this.projectTenderingId = projectTenderingId;
         return this;
      }

      @JsonProperty("UUID")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder UUID(final String UUID) {
         this.UUID = UUID;
         return this;
      }

      @JsonProperty("result")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder result(final Integer result) {
         this.result = result;
         return this;
      }

      @JsonProperty("source")
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public ProjectTenderingSupplier.ProjectTenderingSupplierBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public ProjectTenderingSupplier build() {
         return new ProjectTenderingSupplier(
            this.id,
            this.supplierId,
            this.bidSupplierId,
            this.bidStatus,
            this.biddingTime,
            this.projectTenderingId,
            this.UUID,
            this.result,
            this.source,
            this.createTime,
            this.updateTime,
            this.version
         );
      }

      @Override
      public String toString() {
         return "ProjectTenderingSupplier.ProjectTenderingSupplierBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", bidSupplierId="
            + this.bidSupplierId
            + ", bidStatus="
            + this.bidStatus
            + ", biddingTime="
            + this.biddingTime
            + ", projectTenderingId="
            + this.projectTenderingId
            + ", UUID="
            + this.UUID
            + ", result="
            + this.result
            + ", source="
            + this.source
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
