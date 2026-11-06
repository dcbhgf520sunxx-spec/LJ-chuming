package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysHomeEnterpriseNetdisk对象", description = "")
@Entity
@TableName("sys_home_enterprise_netdisk")
@Table(name = "sys_home_enterprise_netdisk")
@org.hibernate.annotations.Table(appliesTo = "sys_home_enterprise_netdisk")
public class SysHomeEnterpriseNetdisk extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "int  COMMENT '创建人'", nullable = true)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人姓名'", nullable = true)
   private String createUserName;
   @ApiModelProperty(name = "sysHomeFileType", value = "系统文件类型", notes = "系统文件类型")
   @TableField("sys_home_file_type")
   @Column(name = "sys_home_file_type", columnDefinition = "int  COMMENT '系统文件类型'", nullable = false)
   private Integer sysHomeFileType;
   @ApiModelProperty(name = "attachmentIds", value = "附件id 字符串", notes = "附件id 字符串")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '附件id 字符串'", nullable = false)
   private String attachmentIds;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '创建日期'", nullable = true)
   private LocalDateTime informantDateTime;

   public static SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder builder() {
      return new SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder();
   }

   public SysHomeEnterpriseNetdisk() {
   }

   public SysHomeEnterpriseNetdisk(
      final Long id,
      final Long createUserId,
      final String createUserName,
      final Integer sysHomeFileType,
      final String attachmentIds,
      final LocalDateTime informantDateTime
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.sysHomeFileType = sysHomeFileType;
      this.attachmentIds = attachmentIds;
      this.informantDateTime = informantDateTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getSysHomeFileType() {
      return this.sysHomeFileType;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public SysHomeEnterpriseNetdisk setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeEnterpriseNetdisk setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysHomeEnterpriseNetdisk setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeEnterpriseNetdisk setSysHomeFileType(final Integer sysHomeFileType) {
      this.sysHomeFileType = sysHomeFileType;
      return this;
   }

   public SysHomeEnterpriseNetdisk setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SysHomeEnterpriseNetdisk setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeEnterpriseNetdisk(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", sysHomeFileType="
         + this.getSysHomeFileType()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeEnterpriseNetdisk)) {
         return false;
      }

      SysHomeEnterpriseNetdisk other = (SysHomeEnterpriseNetdisk)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$sysHomeFileType = this.getSysHomeFileType();
            Object other$sysHomeFileType = other.getSysHomeFileType();
            if (this$sysHomeFileType == null ? other$sysHomeFileType == null : this$sysHomeFileType.equals(other$sysHomeFileType)) {
               Object this$createUserName = this.getCreateUserName();
               Object other$createUserName = other.getCreateUserName();
               if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                  Object this$attachmentIds = this.getAttachmentIds();
                  Object other$attachmentIds = other.getAttachmentIds();
                  if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                     Object this$informantDateTime = this.getInformantDateTime();
                     Object other$informantDateTime = other.getInformantDateTime();
                     return this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeEnterpriseNetdisk;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $sysHomeFileType = this.getSysHomeFileType();
      result = result * 59 + ($sysHomeFileType == null ? 43 : $sysHomeFileType.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   public static class SysHomeEnterpriseNetdiskBuilder {
      private Long id;
      private Long createUserId;
      private String createUserName;
      private Integer sysHomeFileType;
      private String attachmentIds;
      private LocalDateTime informantDateTime;

      SysHomeEnterpriseNetdiskBuilder() {
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder sysHomeFileType(final Integer sysHomeFileType) {
         this.sysHomeFileType = sysHomeFileType;
         return this;
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeEnterpriseNetdisk build() {
         return new SysHomeEnterpriseNetdisk(this.id, this.createUserId, this.createUserName, this.sysHomeFileType, this.attachmentIds, this.informantDateTime);
      }

      @Override
      public String toString() {
         return "SysHomeEnterpriseNetdisk.SysHomeEnterpriseNetdiskBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", sysHomeFileType="
            + this.sysHomeFileType
            + ", attachmentIds="
            + this.attachmentIds
            + ", informantDateTime="
            + this.informantDateTime
            + ")";
      }
   }
}
