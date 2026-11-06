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
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "供应商报价详情表", description = "")
@TableName("offer_round_detail")
@Table(name = "offer_round_detail")
public class OfferRoundDetail implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "offerId", value = "供应商报价表id")
   @JsonProperty("offerId")
   @JSONField(name = "offerId")
   @TableField("offer_id")
   @Column(name = "offer_id")
   private Long offerId;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "bidAmount", value = "报价金额")
   @JsonProperty("bidAmount")
   @JSONField(name = "bidAmount")
   @TableField("bid_amount")
   @Column(name = "bid_amount")
   private BigDecimal bidAmount;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   @JsonProperty("unitPrice")
   @JSONField(name = "unitPrice")
   @TableField("unit_price")
   @Column(name = "unit_price")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "projectSubjectId", value = "招标科目表主键id")
   @JsonProperty("projectSubjectId")
   @JSONField(name = "projectSubjectId")
   @TableField("project_subject_id")
   @Column(name = "project_subject_id")
   private Long projectSubjectId;
   @ApiModelProperty(name = "isFollow", value = "投标结果")
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

   public static OfferRoundDetail.OfferRoundDetailBuilder builder() {
      return new OfferRoundDetail.OfferRoundDetailBuilder();
   }

   public OfferRoundDetail() {
   }

   public OfferRoundDetail(
      final Long id,
      final Long offerId,
      final Long projectId,
      final BigDecimal bidAmount,
      final BigDecimal unitPrice,
      final Long projectSubjectId,
      final Integer isFollow,
      final Date winningTime
   ) {
      this.id = id;
      this.offerId = offerId;
      this.projectId = projectId;
      this.bidAmount = bidAmount;
      this.unitPrice = unitPrice;
      this.projectSubjectId = projectSubjectId;
      this.isFollow = isFollow;
      this.winningTime = winningTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOfferId() {
      return this.offerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getBidAmount() {
      return this.bidAmount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Long getProjectSubjectId() {
      return this.projectSubjectId;
   }

   public Integer getIsFollow() {
      return this.isFollow;
   }

   public Date getWinningTime() {
      return this.winningTime;
   }

   @JsonProperty("id")
   public OfferRoundDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("offerId")
   public OfferRoundDetail setOfferId(final Long offerId) {
      this.offerId = offerId;
      return this;
   }

   @JsonProperty("projectId")
   public OfferRoundDetail setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("bidAmount")
   public OfferRoundDetail setBidAmount(final BigDecimal bidAmount) {
      this.bidAmount = bidAmount;
      return this;
   }

   @JsonProperty("unitPrice")
   public OfferRoundDetail setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   @JsonProperty("projectSubjectId")
   public OfferRoundDetail setProjectSubjectId(final Long projectSubjectId) {
      this.projectSubjectId = projectSubjectId;
      return this;
   }

   @JsonProperty("isFollow")
   public OfferRoundDetail setIsFollow(final Integer isFollow) {
      this.isFollow = isFollow;
      return this;
   }

   @JsonProperty("winningTime")
   public OfferRoundDetail setWinningTime(final Date winningTime) {
      this.winningTime = winningTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OfferRoundDetail)) {
         return false;
      }

      OfferRoundDetail other = (OfferRoundDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$offerId = this.getOfferId();
         Object other$offerId = other.getOfferId();
         if (this$offerId == null ? other$offerId == null : this$offerId.equals(other$offerId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$projectSubjectId = this.getProjectSubjectId();
               Object other$projectSubjectId = other.getProjectSubjectId();
               if (this$projectSubjectId == null ? other$projectSubjectId == null : this$projectSubjectId.equals(other$projectSubjectId)) {
                  Object this$isFollow = this.getIsFollow();
                  Object other$isFollow = other.getIsFollow();
                  if (this$isFollow == null ? other$isFollow == null : this$isFollow.equals(other$isFollow)) {
                     Object this$bidAmount = this.getBidAmount();
                     Object other$bidAmount = other.getBidAmount();
                     if (this$bidAmount == null ? other$bidAmount == null : this$bidAmount.equals(other$bidAmount)) {
                        Object this$unitPrice = this.getUnitPrice();
                        Object other$unitPrice = other.getUnitPrice();
                        if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OfferRoundDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $offerId = this.getOfferId();
      result = result * 59 + ($offerId == null ? 43 : $offerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectSubjectId = this.getProjectSubjectId();
      result = result * 59 + ($projectSubjectId == null ? 43 : $projectSubjectId.hashCode());
      Object $isFollow = this.getIsFollow();
      result = result * 59 + ($isFollow == null ? 43 : $isFollow.hashCode());
      Object $bidAmount = this.getBidAmount();
      result = result * 59 + ($bidAmount == null ? 43 : $bidAmount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $winningTime = this.getWinningTime();
      return result * 59 + ($winningTime == null ? 43 : $winningTime.hashCode());
   }

   @Override
   public String toString() {
      return "OfferRoundDetail(id="
         + this.getId()
         + ", offerId="
         + this.getOfferId()
         + ", projectId="
         + this.getProjectId()
         + ", bidAmount="
         + this.getBidAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", projectSubjectId="
         + this.getProjectSubjectId()
         + ", isFollow="
         + this.getIsFollow()
         + ", winningTime="
         + this.getWinningTime()
         + ")";
   }

   public static class OfferRoundDetailBuilder {
      private Long id;
      private Long offerId;
      private Long projectId;
      private BigDecimal bidAmount;
      private BigDecimal unitPrice;
      private Long projectSubjectId;
      private Integer isFollow;
      private Date winningTime;

      OfferRoundDetailBuilder() {
      }

      @JsonProperty("id")
      public OfferRoundDetail.OfferRoundDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("offerId")
      public OfferRoundDetail.OfferRoundDetailBuilder offerId(final Long offerId) {
         this.offerId = offerId;
         return this;
      }

      @JsonProperty("projectId")
      public OfferRoundDetail.OfferRoundDetailBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("bidAmount")
      public OfferRoundDetail.OfferRoundDetailBuilder bidAmount(final BigDecimal bidAmount) {
         this.bidAmount = bidAmount;
         return this;
      }

      @JsonProperty("unitPrice")
      public OfferRoundDetail.OfferRoundDetailBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      @JsonProperty("projectSubjectId")
      public OfferRoundDetail.OfferRoundDetailBuilder projectSubjectId(final Long projectSubjectId) {
         this.projectSubjectId = projectSubjectId;
         return this;
      }

      @JsonProperty("isFollow")
      public OfferRoundDetail.OfferRoundDetailBuilder isFollow(final Integer isFollow) {
         this.isFollow = isFollow;
         return this;
      }

      @JsonProperty("winningTime")
      public OfferRoundDetail.OfferRoundDetailBuilder winningTime(final Date winningTime) {
         this.winningTime = winningTime;
         return this;
      }

      public OfferRoundDetail build() {
         return new OfferRoundDetail(
            this.id, this.offerId, this.projectId, this.bidAmount, this.unitPrice, this.projectSubjectId, this.isFollow, this.winningTime
         );
      }

      @Override
      public String toString() {
         return "OfferRoundDetail.OfferRoundDetailBuilder(id="
            + this.id
            + ", offerId="
            + this.offerId
            + ", projectId="
            + this.projectId
            + ", bidAmount="
            + this.bidAmount
            + ", unitPrice="
            + this.unitPrice
            + ", projectSubjectId="
            + this.projectSubjectId
            + ", isFollow="
            + this.isFollow
            + ", winningTime="
            + this.winningTime
            + ")";
      }
   }
}
