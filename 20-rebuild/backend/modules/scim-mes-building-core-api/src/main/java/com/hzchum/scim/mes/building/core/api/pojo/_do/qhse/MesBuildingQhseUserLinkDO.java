package com.hzchum.scim.mes.building.core.api.pojo._do.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingQhseUserLinkDO对象", description = "问题曝光抄送")
public class MesBuildingQhseUserLinkDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   private Long qhseId;
   @ApiModelProperty(name = "userId", value = "抄送人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "powerType", value = "权限类型")
   @JsonProperty("powerType")
   @JSONField(name = "powerType")
   private Integer powerType;

   public static MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder builder() {
      return new MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder();
   }

   public MesBuildingQhseUserLinkDO() {
   }

   public MesBuildingQhseUserLinkDO(final Long id, final Long qhseId, final Long userId, final Integer powerType) {
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
   public MesBuildingQhseUserLinkDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseUserLinkDO setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseUserLinkDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("powerType")
   public MesBuildingQhseUserLinkDO setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseUserLinkDO(id="
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

      if (!(o instanceof MesBuildingQhseUserLinkDO)) {
         return false;
      }

      MesBuildingQhseUserLinkDO other = (MesBuildingQhseUserLinkDO)o;
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
      return other instanceof MesBuildingQhseUserLinkDO;
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

   public static class MesBuildingQhseUserLinkDOBuilder {
      private Long id;
      private Long qhseId;
      private Long userId;
      private Integer powerType;

      MesBuildingQhseUserLinkDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("powerType")
      public MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      public MesBuildingQhseUserLinkDO build() {
         return new MesBuildingQhseUserLinkDO(this.id, this.qhseId, this.userId, this.powerType);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseUserLinkDO.MesBuildingQhseUserLinkDOBuilder(id="
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
