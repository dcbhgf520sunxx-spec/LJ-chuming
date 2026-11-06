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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "供应商报价表", description = "")
@TableName("offer_rounds")
@Table(name = "offer_rounds")
public class OfferRounds implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectTenderingId", value = "招标项目id")
   @JsonProperty("projectTenderingId")
   @JSONField(name = "projectTenderingId")
   @TableField("project_tendering_id")
   @Column(name = "project_tendering_id")
   private Long projectTenderingId;
   @ApiModelProperty(name = "supplierId", value = "供应商-招标项目关联表id")
   @JsonProperty("supplierId")
   @JSONField(name = "supplierId")
   @TableField("supplier_id")
   @Column(name = "supplier_id")
   private Long supplierId;
   @ApiModelProperty(name = "offerRound", value = "报价轮次")
   @JsonProperty("offerRound")
   @JSONField(name = "offer_round")
   @TableField("offer_round")
   @Column(name = "offer_round")
   private Integer offerRound;
   @ApiModelProperty(name = "bidGrossAmount", value = "报价总金额")
   @JsonProperty("bidGrossAmount")
   @JSONField(name = "bid_gross_amount")
   @TableField("bid_gross_amount")
   @Column(name = "bid_gross_amount")
   private BigDecimal bidGrossAmount;
   @ApiModelProperty(name = "remark", value = "报价说明")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "offerTime", value = "报价时间")
   @JsonProperty("offerTime")
   @JSONField(name = "offerTime")
   @TableField("offer_time")
   @Column(name = "offer_time")
   private Date offerTime;
   @ApiModelProperty(name = "isHold", value = "报价是否暂存")
   @JsonProperty("isHold")
   @JSONField(name = "isHold")
   @TableField("is_hold")
   @Column(name = "is_hold", columnDefinition = "0")
   private Integer isHold;
   @ApiModelProperty(name = "ipAddress", value = "用户报价时的ip地址")
   @JsonProperty("ipAddress")
   @JSONField(name = "ipAddress")
   @TableField("ip_address")
   @Column(name = "ip_address")
   private String ipAddress;
   @ApiModelProperty(name = "depositUrl", value = "保证金回单附件Url")
   @JsonProperty("depositUrl")
   @JSONField(name = "depositUrl")
   @TableField("deposit_url")
   @Column(name = "deposit_url")
   private String depositUrl;
   @ApiModelProperty(name = "depositName", value = "保证金回单附件名称")
   @JsonProperty("depositName")
   @JSONField(name = "depositName")
   @TableField("deposit_name")
   @Column(name = "deposit_name")
   private String depositName;
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

   public static OfferRounds.OfferRoundsBuilder builder() {
      return new OfferRounds.OfferRoundsBuilder();
   }

   public OfferRounds() {
   }

   public OfferRounds(
      final Long id,
      final Long projectTenderingId,
      final Long supplierId,
      final Integer offerRound,
      final BigDecimal bidGrossAmount,
      final String remark,
      final Date offerTime,
      final Integer isHold,
      final String ipAddress,
      final String depositUrl,
      final String depositName,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.projectTenderingId = projectTenderingId;
      this.supplierId = supplierId;
      this.offerRound = offerRound;
      this.bidGrossAmount = bidGrossAmount;
      this.remark = remark;
      this.offerTime = offerTime;
      this.isHold = isHold;
      this.ipAddress = ipAddress;
      this.depositUrl = depositUrl;
      this.depositName = depositName;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectTenderingId() {
      return this.projectTenderingId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getOfferRound() {
      return this.offerRound;
   }

   public BigDecimal getBidGrossAmount() {
      return this.bidGrossAmount;
   }

   public String getRemark() {
      return this.remark;
   }

   public Date getOfferTime() {
      return this.offerTime;
   }

   public Integer getIsHold() {
      return this.isHold;
   }

   public String getIpAddress() {
      return this.ipAddress;
   }

   public String getDepositUrl() {
      return this.depositUrl;
   }

   public String getDepositName() {
      return this.depositName;
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
   public OfferRounds setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectTenderingId")
   public OfferRounds setProjectTenderingId(final Long projectTenderingId) {
      this.projectTenderingId = projectTenderingId;
      return this;
   }

   @JsonProperty("supplierId")
   public OfferRounds setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   @JsonProperty("offerRound")
   public OfferRounds setOfferRound(final Integer offerRound) {
      this.offerRound = offerRound;
      return this;
   }

   @JsonProperty("bidGrossAmount")
   public OfferRounds setBidGrossAmount(final BigDecimal bidGrossAmount) {
      this.bidGrossAmount = bidGrossAmount;
      return this;
   }

   @JsonProperty("remark")
   public OfferRounds setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("offerTime")
   public OfferRounds setOfferTime(final Date offerTime) {
      this.offerTime = offerTime;
      return this;
   }

   @JsonProperty("isHold")
   public OfferRounds setIsHold(final Integer isHold) {
      this.isHold = isHold;
      return this;
   }

   @JsonProperty("ipAddress")
   public OfferRounds setIpAddress(final String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
   }

   @JsonProperty("depositUrl")
   public OfferRounds setDepositUrl(final String depositUrl) {
      this.depositUrl = depositUrl;
      return this;
   }

   @JsonProperty("depositName")
   public OfferRounds setDepositName(final String depositName) {
      this.depositName = depositName;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public OfferRounds setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public OfferRounds setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public OfferRounds setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OfferRounds)) {
         return false;
      }

      OfferRounds other = (OfferRounds)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectTenderingId = this.getProjectTenderingId();
         Object other$projectTenderingId = other.getProjectTenderingId();
         if (this$projectTenderingId == null ? other$projectTenderingId == null : this$projectTenderingId.equals(other$projectTenderingId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$offerRound = this.getOfferRound();
               Object other$offerRound = other.getOfferRound();
               if (this$offerRound == null ? other$offerRound == null : this$offerRound.equals(other$offerRound)) {
                  Object this$isHold = this.getIsHold();
                  Object other$isHold = other.getIsHold();
                  if (this$isHold == null ? other$isHold == null : this$isHold.equals(other$isHold)) {
                     Object this$version = this.getVersion();
                     Object other$version = other.getVersion();
                     if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                        Object this$bidGrossAmount = this.getBidGrossAmount();
                        Object other$bidGrossAmount = other.getBidGrossAmount();
                        if (this$bidGrossAmount == null ? other$bidGrossAmount == null : this$bidGrossAmount.equals(other$bidGrossAmount)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$offerTime = this.getOfferTime();
                              Object other$offerTime = other.getOfferTime();
                              if (this$offerTime == null ? other$offerTime == null : this$offerTime.equals(other$offerTime)) {
                                 Object this$ipAddress = this.getIpAddress();
                                 Object other$ipAddress = other.getIpAddress();
                                 if (this$ipAddress == null ? other$ipAddress == null : this$ipAddress.equals(other$ipAddress)) {
                                    Object this$depositUrl = this.getDepositUrl();
                                    Object other$depositUrl = other.getDepositUrl();
                                    if (this$depositUrl == null ? other$depositUrl == null : this$depositUrl.equals(other$depositUrl)) {
                                       Object this$depositName = this.getDepositName();
                                       Object other$depositName = other.getDepositName();
                                       if (this$depositName == null ? other$depositName == null : this$depositName.equals(other$depositName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OfferRounds;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectTenderingId = this.getProjectTenderingId();
      result = result * 59 + ($projectTenderingId == null ? 43 : $projectTenderingId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $offerRound = this.getOfferRound();
      result = result * 59 + ($offerRound == null ? 43 : $offerRound.hashCode());
      Object $isHold = this.getIsHold();
      result = result * 59 + ($isHold == null ? 43 : $isHold.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $bidGrossAmount = this.getBidGrossAmount();
      result = result * 59 + ($bidGrossAmount == null ? 43 : $bidGrossAmount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $offerTime = this.getOfferTime();
      result = result * 59 + ($offerTime == null ? 43 : $offerTime.hashCode());
      Object $ipAddress = this.getIpAddress();
      result = result * 59 + ($ipAddress == null ? 43 : $ipAddress.hashCode());
      Object $depositUrl = this.getDepositUrl();
      result = result * 59 + ($depositUrl == null ? 43 : $depositUrl.hashCode());
      Object $depositName = this.getDepositName();
      result = result * 59 + ($depositName == null ? 43 : $depositName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "OfferRounds(id="
         + this.getId()
         + ", projectTenderingId="
         + this.getProjectTenderingId()
         + ", supplierId="
         + this.getSupplierId()
         + ", offerRound="
         + this.getOfferRound()
         + ", bidGrossAmount="
         + this.getBidGrossAmount()
         + ", remark="
         + this.getRemark()
         + ", offerTime="
         + this.getOfferTime()
         + ", isHold="
         + this.getIsHold()
         + ", ipAddress="
         + this.getIpAddress()
         + ", depositUrl="
         + this.getDepositUrl()
         + ", depositName="
         + this.getDepositName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class OfferRoundsBuilder {
      private Long id;
      private Long projectTenderingId;
      private Long supplierId;
      private Integer offerRound;
      private BigDecimal bidGrossAmount;
      private String remark;
      private Date offerTime;
      private Integer isHold;
      private String ipAddress;
      private String depositUrl;
      private String depositName;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      OfferRoundsBuilder() {
      }

      @JsonProperty("id")
      public OfferRounds.OfferRoundsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectTenderingId")
      public OfferRounds.OfferRoundsBuilder projectTenderingId(final Long projectTenderingId) {
         this.projectTenderingId = projectTenderingId;
         return this;
      }

      @JsonProperty("supplierId")
      public OfferRounds.OfferRoundsBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      @JsonProperty("offerRound")
      public OfferRounds.OfferRoundsBuilder offerRound(final Integer offerRound) {
         this.offerRound = offerRound;
         return this;
      }

      @JsonProperty("bidGrossAmount")
      public OfferRounds.OfferRoundsBuilder bidGrossAmount(final BigDecimal bidGrossAmount) {
         this.bidGrossAmount = bidGrossAmount;
         return this;
      }

      @JsonProperty("remark")
      public OfferRounds.OfferRoundsBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("offerTime")
      public OfferRounds.OfferRoundsBuilder offerTime(final Date offerTime) {
         this.offerTime = offerTime;
         return this;
      }

      @JsonProperty("isHold")
      public OfferRounds.OfferRoundsBuilder isHold(final Integer isHold) {
         this.isHold = isHold;
         return this;
      }

      @JsonProperty("ipAddress")
      public OfferRounds.OfferRoundsBuilder ipAddress(final String ipAddress) {
         this.ipAddress = ipAddress;
         return this;
      }

      @JsonProperty("depositUrl")
      public OfferRounds.OfferRoundsBuilder depositUrl(final String depositUrl) {
         this.depositUrl = depositUrl;
         return this;
      }

      @JsonProperty("depositName")
      public OfferRounds.OfferRoundsBuilder depositName(final String depositName) {
         this.depositName = depositName;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public OfferRounds.OfferRoundsBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public OfferRounds.OfferRoundsBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public OfferRounds.OfferRoundsBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public OfferRounds build() {
         return new OfferRounds(
            this.id,
            this.projectTenderingId,
            this.supplierId,
            this.offerRound,
            this.bidGrossAmount,
            this.remark,
            this.offerTime,
            this.isHold,
            this.ipAddress,
            this.depositUrl,
            this.depositName,
            this.createTime,
            this.updateTime,
            this.version
         );
      }

      @Override
      public String toString() {
         return "OfferRounds.OfferRoundsBuilder(id="
            + this.id
            + ", projectTenderingId="
            + this.projectTenderingId
            + ", supplierId="
            + this.supplierId
            + ", offerRound="
            + this.offerRound
            + ", bidGrossAmount="
            + this.bidGrossAmount
            + ", remark="
            + this.remark
            + ", offerTime="
            + this.offerTime
            + ", isHold="
            + this.isHold
            + ", ipAddress="
            + this.ipAddress
            + ", depositUrl="
            + this.depositUrl
            + ", depositName="
            + this.depositName
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
