package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureQhseUserLinkDOParam", description = "问题曝光抄送")
public class MesEnclosureQhseUserLinkDOParam extends BaseEntity<Long> {
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

   public static MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder builder() {
      return new MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder();
   }

   public MesEnclosureQhseUserLinkDOParam() {
   }

   public MesEnclosureQhseUserLinkDOParam(final Long id, final Long qhseId, final Long userId, final Integer powerType) {
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
   public MesEnclosureQhseUserLinkDOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesEnclosureQhseUserLinkDOParam setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseUserLinkDOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("powerType")
   public MesEnclosureQhseUserLinkDOParam setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseUserLinkDOParam(id="
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

      if (!(o instanceof MesEnclosureQhseUserLinkDOParam)) {
         return false;
      }

      MesEnclosureQhseUserLinkDOParam other = (MesEnclosureQhseUserLinkDOParam)o;
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
      return other instanceof MesEnclosureQhseUserLinkDOParam;
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

   public static class MesEnclosureQhseUserLinkDOParamBuilder {
      private Long id;
      private Long qhseId;
      private Long userId;
      private Integer powerType;

      MesEnclosureQhseUserLinkDOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("powerType")
      public MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      public MesEnclosureQhseUserLinkDOParam build() {
         return new MesEnclosureQhseUserLinkDOParam(this.id, this.qhseId, this.userId, this.powerType);
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseUserLinkDOParam.MesEnclosureQhseUserLinkDOParamBuilder(id="
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
