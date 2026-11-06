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

@ApiModel(value = "招标轮次表", description = "")
@TableName("bidding_rounds")
@Table(name = "bidding_rounds")
public class BiddingRounds implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "招标项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "round", value = "轮次")
   @JsonProperty("round")
   @JSONField(name = "round")
   @TableField("round")
   @Column(name = "round", columnDefinition = "int default 1")
   private Integer round;
   @ApiModelProperty(name = "releaseDate", value = "发布日期")
   @JsonProperty("releaseDate")
   @JSONField(name = "releaseDate")
   @TableField("release_date")
   @Column(name = "release_date")
   private Date releaseDate;
   @ApiModelProperty(name = "bidDeadline", value = "投标截止时间")
   @JsonProperty("bidDeadline")
   @JSONField(name = "bidDeadline")
   @TableField("bid_deadline")
   @Column(name = "bid_deadline")
   private Date bidDeadline;
   @ApiModelProperty(name = "bidOpeningTime", value = "开标时间")
   @JsonProperty("bidOpeningTime")
   @JSONField(name = "bidOpeningTime")
   @TableField("bid_opening_time")
   @Column(name = "bid_opening_time")
   private Date bidOpeningTime;
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

   public static BiddingRounds.BiddingRoundsBuilder builder() {
      return new BiddingRounds.BiddingRoundsBuilder();
   }

   public BiddingRounds() {
   }

   public BiddingRounds(
      final Long id,
      final Long projectId,
      final Integer round,
      final Date releaseDate,
      final Date bidDeadline,
      final Date bidOpeningTime,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.projectId = projectId;
      this.round = round;
      this.releaseDate = releaseDate;
      this.bidDeadline = bidDeadline;
      this.bidOpeningTime = bidOpeningTime;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getRound() {
      return this.round;
   }

   public Date getReleaseDate() {
      return this.releaseDate;
   }

   public Date getBidDeadline() {
      return this.bidDeadline;
   }

   public Date getBidOpeningTime() {
      return this.bidOpeningTime;
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
   public BiddingRounds setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public BiddingRounds setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("round")
   public BiddingRounds setRound(final Integer round) {
      this.round = round;
      return this;
   }

   @JsonProperty("releaseDate")
   public BiddingRounds setReleaseDate(final Date releaseDate) {
      this.releaseDate = releaseDate;
      return this;
   }

   @JsonProperty("bidDeadline")
   public BiddingRounds setBidDeadline(final Date bidDeadline) {
      this.bidDeadline = bidDeadline;
      return this;
   }

   @JsonProperty("bidOpeningTime")
   public BiddingRounds setBidOpeningTime(final Date bidOpeningTime) {
      this.bidOpeningTime = bidOpeningTime;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public BiddingRounds setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public BiddingRounds setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public BiddingRounds setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BiddingRounds)) {
         return false;
      }

      BiddingRounds other = (BiddingRounds)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$round = this.getRound();
            Object other$round = other.getRound();
            if (this$round == null ? other$round == null : this$round.equals(other$round)) {
               Object this$version = this.getVersion();
               Object other$version = other.getVersion();
               if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                  Object this$releaseDate = this.getReleaseDate();
                  Object other$releaseDate = other.getReleaseDate();
                  if (this$releaseDate == null ? other$releaseDate == null : this$releaseDate.equals(other$releaseDate)) {
                     Object this$bidDeadline = this.getBidDeadline();
                     Object other$bidDeadline = other.getBidDeadline();
                     if (this$bidDeadline == null ? other$bidDeadline == null : this$bidDeadline.equals(other$bidDeadline)) {
                        Object this$bidOpeningTime = this.getBidOpeningTime();
                        Object other$bidOpeningTime = other.getBidOpeningTime();
                        if (this$bidOpeningTime == null ? other$bidOpeningTime == null : this$bidOpeningTime.equals(other$bidOpeningTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BiddingRounds;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $round = this.getRound();
      result = result * 59 + ($round == null ? 43 : $round.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $releaseDate = this.getReleaseDate();
      result = result * 59 + ($releaseDate == null ? 43 : $releaseDate.hashCode());
      Object $bidDeadline = this.getBidDeadline();
      result = result * 59 + ($bidDeadline == null ? 43 : $bidDeadline.hashCode());
      Object $bidOpeningTime = this.getBidOpeningTime();
      result = result * 59 + ($bidOpeningTime == null ? 43 : $bidOpeningTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "BiddingRounds(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", round="
         + this.getRound()
         + ", releaseDate="
         + this.getReleaseDate()
         + ", bidDeadline="
         + this.getBidDeadline()
         + ", bidOpeningTime="
         + this.getBidOpeningTime()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class BiddingRoundsBuilder {
      private Long id;
      private Long projectId;
      private Integer round;
      private Date releaseDate;
      private Date bidDeadline;
      private Date bidOpeningTime;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      BiddingRoundsBuilder() {
      }

      @JsonProperty("id")
      public BiddingRounds.BiddingRoundsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public BiddingRounds.BiddingRoundsBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("round")
      public BiddingRounds.BiddingRoundsBuilder round(final Integer round) {
         this.round = round;
         return this;
      }

      @JsonProperty("releaseDate")
      public BiddingRounds.BiddingRoundsBuilder releaseDate(final Date releaseDate) {
         this.releaseDate = releaseDate;
         return this;
      }

      @JsonProperty("bidDeadline")
      public BiddingRounds.BiddingRoundsBuilder bidDeadline(final Date bidDeadline) {
         this.bidDeadline = bidDeadline;
         return this;
      }

      @JsonProperty("bidOpeningTime")
      public BiddingRounds.BiddingRoundsBuilder bidOpeningTime(final Date bidOpeningTime) {
         this.bidOpeningTime = bidOpeningTime;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public BiddingRounds.BiddingRoundsBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public BiddingRounds.BiddingRoundsBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public BiddingRounds.BiddingRoundsBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public BiddingRounds build() {
         return new BiddingRounds(
            this.id, this.projectId, this.round, this.releaseDate, this.bidDeadline, this.bidOpeningTime, this.createTime, this.updateTime, this.version
         );
      }

      @Override
      public String toString() {
         return "BiddingRounds.BiddingRoundsBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", round="
            + this.round
            + ", releaseDate="
            + this.releaseDate
            + ", bidDeadline="
            + this.bidDeadline
            + ", bidOpeningTime="
            + this.bidOpeningTime
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
