package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesEnclosureInspectionTeamUserLink对象", description = "质检班组用户关联表 ")
@Entity
@TableName("mes_enclosure_inspection_team_user_link")
@Table(name = "mes_enclosure_inspection_team_user_link")
public class MesEnclosureInspectionTeamUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名", notes = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(128)  COMMENT '用户名'", nullable = false)
   private String userName;
   @ApiModelProperty(name = "inspectionTeamId", value = "质检班组id", notes = "质检班组id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   @TableField("inspection_team_id")
   @Column(name = "inspection_team_id", columnDefinition = "bigint(20)  COMMENT '质检班组id'", nullable = false)
   private Long inspectionTeamId;

   public static MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder builder() {
      return new MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder();
   }

   public MesEnclosureInspectionTeamUserLink() {
   }

   public MesEnclosureInspectionTeamUserLink(final Long id, final Long userId, final String userName, final Long inspectionTeamId) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.inspectionTeamId = inspectionTeamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   @JsonProperty("id")
   public MesEnclosureInspectionTeamUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureInspectionTeamUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureInspectionTeamUserLink setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesEnclosureInspectionTeamUserLink setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureInspectionTeamUserLink(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureInspectionTeamUserLink)) {
         return false;
      }

      MesEnclosureInspectionTeamUserLink other = (MesEnclosureInspectionTeamUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$inspectionTeamId = this.getInspectionTeamId();
            Object other$inspectionTeamId = other.getInspectionTeamId();
            if (this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof MesEnclosureInspectionTeamUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      result = result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesEnclosureInspectionTeamUserLinkBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long inspectionTeamId;

      MesEnclosureInspectionTeamUserLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      public MesEnclosureInspectionTeamUserLink build() {
         return new MesEnclosureInspectionTeamUserLink(this.id, this.userId, this.userName, this.inspectionTeamId);
      }

      @Override
      public String toString() {
         return "MesEnclosureInspectionTeamUserLink.MesEnclosureInspectionTeamUserLinkBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ")";
      }
   }
}
