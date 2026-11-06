package com.hzchum.scim.crm.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CrmPersonTemplateUserLink对象", description = "")
@Entity
@TableName("crm_person_template_user_link")
@Table(name = "crm_person_template_user_link")
@org.hibernate.annotations.Table(appliesTo = "crm_person_template_user_link")
public class CrmPersonTemplateUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "人员id", notes = "人员id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '人员id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "crmPersonTemplateEnum", value = "负责人类型枚举", notes = "负责人类型枚举")
   @TableField("crm_person_template_enum")
   @Column(name = "crm_person_template_enum", columnDefinition = "int(11)  COMMENT '负责人类型枚举'", nullable = false)
   private Integer crmPersonTemplateEnum;
   @ApiModelProperty(name = "crmPersonTemplateConfigId", value = "人员模板id", notes = "人员模板id")
   @TableField("crm_person_template_config_id")
   @Column(name = "crm_person_template_config_id", columnDefinition = "bigint(20)  COMMENT '人员模板id'", nullable = false)
   private Long crmPersonTemplateConfigId;

   public static CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder builder() {
      return new CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder();
   }

   public CrmPersonTemplateUserLink() {
   }

   public CrmPersonTemplateUserLink(final Long id, final Long userId, final Integer crmPersonTemplateEnum, final Long crmPersonTemplateConfigId) {
      this.id = id;
      this.userId = userId;
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      this.crmPersonTemplateConfigId = crmPersonTemplateConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getCrmPersonTemplateEnum() {
      return this.crmPersonTemplateEnum;
   }

   public Long getCrmPersonTemplateConfigId() {
      return this.crmPersonTemplateConfigId;
   }

   public CrmPersonTemplateUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmPersonTemplateUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public CrmPersonTemplateUserLink setCrmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      return this;
   }

   public CrmPersonTemplateUserLink setCrmPersonTemplateConfigId(final Long crmPersonTemplateConfigId) {
      this.crmPersonTemplateConfigId = crmPersonTemplateConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPersonTemplateUserLink(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", crmPersonTemplateEnum="
         + this.getCrmPersonTemplateEnum()
         + ", crmPersonTemplateConfigId="
         + this.getCrmPersonTemplateConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPersonTemplateUserLink)) {
         return false;
      }

      CrmPersonTemplateUserLink other = (CrmPersonTemplateUserLink)o;
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
            Object this$crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
            Object other$crmPersonTemplateEnum = other.getCrmPersonTemplateEnum();
            if (this$crmPersonTemplateEnum == null ? other$crmPersonTemplateEnum == null : this$crmPersonTemplateEnum.equals(other$crmPersonTemplateEnum)) {
               Object this$crmPersonTemplateConfigId = this.getCrmPersonTemplateConfigId();
               Object other$crmPersonTemplateConfigId = other.getCrmPersonTemplateConfigId();
               return this$crmPersonTemplateConfigId == null
                  ? other$crmPersonTemplateConfigId == null
                  : this$crmPersonTemplateConfigId.equals(other$crmPersonTemplateConfigId);
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
      return other instanceof CrmPersonTemplateUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      result = result * 59 + ($crmPersonTemplateEnum == null ? 43 : $crmPersonTemplateEnum.hashCode());
      Object $crmPersonTemplateConfigId = this.getCrmPersonTemplateConfigId();
      return result * 59 + ($crmPersonTemplateConfigId == null ? 43 : $crmPersonTemplateConfigId.hashCode());
   }

   public static class CrmPersonTemplateUserLinkBuilder {
      private Long id;
      private Long userId;
      private Integer crmPersonTemplateEnum;
      private Long crmPersonTemplateConfigId;

      CrmPersonTemplateUserLinkBuilder() {
      }

      public CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder crmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
         this.crmPersonTemplateEnum = crmPersonTemplateEnum;
         return this;
      }

      public CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder crmPersonTemplateConfigId(final Long crmPersonTemplateConfigId) {
         this.crmPersonTemplateConfigId = crmPersonTemplateConfigId;
         return this;
      }

      public CrmPersonTemplateUserLink build() {
         return new CrmPersonTemplateUserLink(this.id, this.userId, this.crmPersonTemplateEnum, this.crmPersonTemplateConfigId);
      }

      @Override
      public String toString() {
         return "CrmPersonTemplateUserLink.CrmPersonTemplateUserLinkBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", crmPersonTemplateEnum="
            + this.crmPersonTemplateEnum
            + ", crmPersonTemplateConfigId="
            + this.crmPersonTemplateConfigId
            + ")";
      }
   }
}
