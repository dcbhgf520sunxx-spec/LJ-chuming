package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "供应商-招标科目关联表", description = "")
@TableName("supplier_subject")
@Table(name = "supplier_subject")
public class SupplierSubject implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "supplierId", value = "招标项目-供应商关联表主键id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "projectSubjectId", value = "招标科目表主键id")
   @JsonProperty("projectSubjectId")
   @JSONField(name = "projectSubjectId")
   @TableField("project_subject_id")
   @Column(name = "project_subject_id")
   private Long projectSubjectId;
   @ApiModelProperty(name = "offerDetailId", value = "报价详情表主键id(淘汰/拟中标)")
   @JsonProperty("offerDetailId")
   @JSONField(name = "offerDetailId")
   @TableField("offer_detail_id")
   @Column(name = "offer_detail_id")
   private Long offerDetailId;
   @ApiModelProperty(name = "isFollow", value = "结果")
   @JsonProperty("isFollow")
   @JSONField(name = "isFollow")
   @TableField("is_follow")
   @Column(name = "is_follow")
   private Integer isFollow;
   @ApiModelProperty(name = "winningTime", value = "中标时间")
   @JsonProperty("winningTime")
   @JSONField(name = "winningTime")
   @TableField("winning_time")
   @Column(name = "winning_time")
   private Date winningTime;

   public static SupplierSubject.SupplierSubjectBuilder builder() {
      return new SupplierSubject.SupplierSubjectBuilder();
   }

   public SupplierSubject() {
   }

   public SupplierSubject(
      final Long id,
      final Long supplierId,
      final Long projectId,
      final Long projectSubjectId,
      final Long offerDetailId,
      final Integer isFollow,
      final Date winningTime
   ) {
      this.id = id;
      this.supplierId = supplierId;
      this.projectId = projectId;
      this.projectSubjectId = projectSubjectId;
      this.offerDetailId = offerDetailId;
      this.isFollow = isFollow;
      this.winningTime = winningTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Long getOfferDetailId() {
      return this.offerDetailId;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public Date getWinningTime() {
      return this.winningTime;
   }

   @JsonProperty("id")
   public SupplierSubject setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("supplierId")
   public SupplierSubject setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("projectId")
   public SupplierSubject setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectSubjectId")
   public SupplierSubject setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
      return this;
   }

   @JsonProperty("offerDetailId")
   public SupplierSubject setOfferDetailId(final Long offerDetailId) {
      this.offerDetailId = offerDetailId;
      return this;
   }

   @JsonProperty("isFollow")
   public SupplierSubject setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
      return this;
   }

   @JsonProperty("winningTime")
   public SupplierSubject setWinningTime(final Date winningTime) {
      this.winningTime = winningTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSubject)) {
         return false;
      }

      SupplierSubject other = (SupplierSubject)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectSubjectId = this.getProjectSubjectId();
               Object other$projectSubjectId = other.getProjectSubjectId();
               if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
                  Object this$offerDetailId = this.getOfferDetailId();
                  Object other$offerDetailId = other.getOfferDetailId();
                  if (this$offerDetailId == null ? other$offerDetailId == null : this$offerDetailId.equals(other$offerDetailId)) {
                     Object this$isFollow = this.getIsFollow();
                     Object other$isFollow = other.getIsFollow();
                     if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                        Object this$winningTime = this.getWinningTime();
                        Object other$winningTime = other.getWinningTime();
                        return this$winningTime == null ? other$winningTime == null : this$winningTime.equals(other$winningTime);
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
      return other instanceof SupplierSubject;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $offerDetailId = this.getOfferDetailId();
      result = result * 59 + ($offerDetailId == null ? 43 : $offerDetailId.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $winningTime = this.getWinningTime();
      return result * 59 + ($winningTime == null ? 43 : $winningTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSubject(id="
         + this.getId()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectId="
         + this.getProjectId()
         + ", projectSubjectId="
         + this.getProjectSubjectId()
         + ", offerDetailId="
         + this.getOfferDetailId()
         + ", isFollow="
         + this.getIsFollow()
         + ", winningTime="
         + this.getWinningTime()
         + ")";
   }

   public static class SupplierSubjectBuilder {
      private Long id;
      private Long supplierId;
      private Long projectId;
      private Long projectSubjectId;
      private Long offerDetailId;
      private Integer isFollow;
      private Date winningTime;

      SupplierSubjectBuilder() {
      }

      @JsonProperty("id")
      public SupplierSubject.SupplierSubjectBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("supplierId")
      public SupplierSubject.SupplierSubjectBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("projectId")
      public SupplierSubject.SupplierSubjectBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectSubjectId")
      public SupplierSubject.SupplierSubjectBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      @JsonProperty("offerDetailId")
      public SupplierSubject.SupplierSubjectBuilder offerDetailId(final Long offerDetailId) {
         this.offerDetailId = offerDetailId;
         return this;
      }

      @JsonProperty("isFollow")
      public SupplierSubject.SupplierSubjectBuilder isFollow(final Integer isFollow) {
         this.isFollow = isFollow;
         return this;
      }

      @JsonProperty("winningTime")
      public SupplierSubject.SupplierSubjectBuilder winningTime(final Date winningTime) {
         this.winningTime = winningTime;
         return this;
      }

      public SupplierSubject build() {
         return new SupplierSubject(this.id, this.supplierId, this.projectId, this.projectSubjectId, this.offerDetailId, this.isFollow, this.winningTime);
      }

      @Override
      public String toString() {
         return "SupplierSubject.SupplierSubjectBuilder(id="
            + this.id
            + ", supplierId="
            + this.supplierId
            + ", projectId="
            + this.projectId
            + ", projectSubjectId="
            + this.projectSubjectId
            + ", offerDetailId="
            + this.offerDetailId
            + ", isFollow="
            + this.isFollow
            + ", winningTime="
            + this.winningTime
            + ")";
      }
   }
}
