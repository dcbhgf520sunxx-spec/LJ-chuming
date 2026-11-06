package com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse;

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

@ApiModel(value = "MesBuildingQhseUserLink对象", description = "问题曝光抄送表 ")
@Entity
@TableName("mes_building_qhse_user_link")
@Table(name = "mes_building_qhse_user_link")
public class MesBuildingQhseUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id", notes = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   @TableField("qhse_id")
   @Column(name = "qhse_id", columnDefinition = "bigint(20)  COMMENT '问题曝光id'", nullable = false)
   private Long qhseId;
   @ApiModelProperty(name = "userId", value = "抄送人", notes = "抄送人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '抄送人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "powerType", value = "权限类型 [1 查看, 2 整改，4审核]", notes = "权限类型 [1 查看, 2 整改，4审核]")
   @JsonProperty("powerType")
   @JSONField(name = "powerType")
   @TableField("power_type")
   @Column(name = "power_type", columnDefinition = "int(11) default '1' COMMENT '权限类型 [1 查看, 2 整改，4审核]'", nullable = false)
   private Integer powerType;

   public static MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder builder() {
      return new MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder();
   }

   public MesBuildingQhseUserLink() {
   }

   public MesBuildingQhseUserLink(final Long id, final Long qhseId, final Long userId, final Integer powerType) {
      this.id = id;
      this.qhseId = qhseId;
      this.userId = userId;
      this.powerType = powerType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getPowerType() {
      return this.powerType;
   }

   @JsonProperty("id")
   public MesBuildingQhseUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseUserLink setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("powerType")
   public MesBuildingQhseUserLink setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseUserLink(id="
         + this.getId()
         + ", qhseId="
         + this.getQhseId()
         + ", userId="
         + this.getUserId()
         + ", powerType="
         + this.getPowerType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseUserLink)) {
         return false;
      }

      MesBuildingQhseUserLink other = (MesBuildingQhseUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseId = this.getQhseId();
         Object other$qhseId = other.getQhseId();
         if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$powerType = this.getPowerType();
               Object other$powerType = other.getPowerType();
               return this$powerType == null ? other$powerType == null : this$powerType.equals(other$powerType);
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
      return other instanceof MesBuildingQhseUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $powerType = this.getPowerType();
      return result * 59 + ($powerType == null ? 43 : $powerType.hashCode());
   }

   public static class MesBuildingQhseUserLinkBuilder {
      private Long id;
      private Long qhseId;
      private Long userId;
      private Integer powerType;

      MesBuildingQhseUserLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("powerType")
      public MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      public MesBuildingQhseUserLink build() {
         return new MesBuildingQhseUserLink(this.id, this.qhseId, this.userId, this.powerType);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseUserLink.MesBuildingQhseUserLinkBuilder(id="
            + this.id
            + ", qhseId="
            + this.qhseId
            + ", userId="
            + this.userId
            + ", powerType="
            + this.powerType
            + ")";
      }
   }
}
