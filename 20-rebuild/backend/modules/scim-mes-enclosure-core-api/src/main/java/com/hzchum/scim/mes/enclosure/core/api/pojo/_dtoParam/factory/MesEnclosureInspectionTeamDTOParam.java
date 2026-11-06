package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureInspectionTeamDTOParam对象", description = "")
public class MesEnclosureInspectionTeamDTOParam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userLinks", notes = "质检人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks;

   public static MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder builder() {
      return new MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder();
   }

   public MesEnclosureInspectionTeamDTOParam() {
   }

   public MesEnclosureInspectionTeamDTOParam(
      final Long id, final Long factoryId, final Long processId, final Long userId, final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.processId = processId;
      this.userId = userId;
      this.userLinks = userLinks;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public List<MesEnclosureInspectionTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("id")
   public MesEnclosureInspectionTeamDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureInspectionTeamDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureInspectionTeamDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureInspectionTeamDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userLinks")
   public MesEnclosureInspectionTeamDTOParam setUserLinks(final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureInspectionTeamDTOParam(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", userId="
         + this.getUserId()
         + ", userLinks="
         + this.getUserLinks()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureInspectionTeamDTOParam)) {
         return false;
      }

      MesEnclosureInspectionTeamDTOParam other = (MesEnclosureInspectionTeamDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$userLinks = this.getUserLinks();
                  Object other$userLinks = other.getUserLinks();
                  return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureInspectionTeamDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class MesEnclosureInspectionTeamDTOParamBuilder {
      private Long id;
      private Long factoryId;
      private Long processId;
      private Long userId;
      private List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks;

      MesEnclosureInspectionTeamDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userLinks")
      public MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder userLinks(
         final List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinks
      ) {
         this.userLinks = userLinks;
         return this;
      }

      public MesEnclosureInspectionTeamDTOParam build() {
         return new MesEnclosureInspectionTeamDTOParam(this.id, this.factoryId, this.processId, this.userId, this.userLinks);
      }

      @Override
      public String toString() {
         return "MesEnclosureInspectionTeamDTOParam.MesEnclosureInspectionTeamDTOParamBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", userId="
            + this.userId
            + ", userLinks="
            + this.userLinks
            + ")";
      }
   }
}
