package com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse;

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

@ApiModel(value = "WmsOutboundRemind对象", description = "")
@Entity
@TableName("wms_outbound_remind")
@Table(name = "wms_outbound_remind")
@org.hibernate.annotations.Table(appliesTo = "wms_outbound_remind")
public class WmsOutboundRemind extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "出库项目", notes = "出库项目")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '出库项目'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "outboundId", value = "出库单id", notes = "出库单id")
   @TableField("outbound_id")
   @Column(name = "outbound_id", columnDefinition = "bigint  COMMENT '出库单id'", nullable = true)
   private Long outboundId;
   @ApiModelProperty(name = "outboundSn", value = "出库单编号", notes = "出库单编号")
   @TableField("outbound_sn")
   @Column(name = "outbound_sn", columnDefinition = "varchar(255)  COMMENT '出库单编号'", nullable = true)
   private String outboundSn;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   @TableField("content")
   @Column(name = "content", columnDefinition = "varchar(1023)  COMMENT '内容'", nullable = true)
   private String content;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "isCheck", value = "是否查看", notes = "是否查看")
   @TableField("is_check")
   @Column(name = "is_check", columnDefinition = "tinyint(1) default'0' COMMENT '是否查看'", nullable = true)
   private Boolean isCheck;

   public static WmsOutboundRemind.WmsOutboundRemindBuilder builder() {
      return new WmsOutboundRemind.WmsOutboundRemindBuilder();
   }

   public WmsOutboundRemind() {
   }

   public WmsOutboundRemind(
      final Long id,
      final Long projectId,
      final Long outboundId,
      final String outboundSn,
      final String content,
      final Long applicantId,
      final String applicantName,
      final Boolean isCheck
   ) {
      this.id = id;
      this.projectId = projectId;
      this.outboundId = outboundId;
      this.outboundSn = outboundSn;
      this.content = content;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.isCheck = isCheck;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getOutboundId() {
      return this.outboundId;
   }

   public String getOutboundSn() {
      return this.outboundSn;
   }

   public String getContent() {
      return this.content;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Boolean getIsCheck() {
      return this.isCheck;
   }

   public WmsOutboundRemind setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsOutboundRemind setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public WmsOutboundRemind setOutboundId(final Long outboundId) {
      this.outboundId = outboundId;
      return this;
   }

   public WmsOutboundRemind setOutboundSn(final String outboundSn) {
      this.outboundSn = outboundSn;
      return this;
   }

   public WmsOutboundRemind setContent(final String content) {
      this.content = content;
      return this;
   }

   public WmsOutboundRemind setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsOutboundRemind setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public WmsOutboundRemind setIsCheck(final Boolean isCheck) {
      this.isCheck = isCheck;
      return this;
   }

   @Override
   public String toString() {
      return "WmsOutboundRemind(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", outboundId="
         + this.getOutboundId()
         + ", outboundSn="
         + this.getOutboundSn()
         + ", content="
         + this.getContent()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", isCheck="
         + this.getIsCheck()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsOutboundRemind)) {
         return false;
      }

      WmsOutboundRemind other = (WmsOutboundRemind)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$outboundId = this.getOutboundId();
            Object other$outboundId = other.getOutboundId();
            if (this$outboundId == null ? other$outboundId == null : this$outboundId.equals(other$outboundId)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$isCheck = this.getIsCheck();
                  Object other$isCheck = other.getIsCheck();
                  if (this$isCheck == null ? other$isCheck == null : this$isCheck.equals(other$isCheck)) {
                     Object this$outboundSn = this.getOutboundSn();
                     Object other$outboundSn = other.getOutboundSn();
                     if (this$outboundSn == null ? other$outboundSn == null : this$outboundSn.equals(other$outboundSn)) {
                        Object this$content = this.getContent();
                        Object other$content = other.getContent();
                        if (this$content == null ? other$content == null : this$content.equals(other$content)) {
                           Object this$applicantName = this.getApplicantName();
                           Object other$applicantName = other.getApplicantName();
                           return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsOutboundRemind;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $outboundId = this.getOutboundId();
      result = result * 59 + ($outboundId == null ? 43 : $outboundId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $isCheck = this.getIsCheck();
      result = result * 59 + ($isCheck == null ? 43 : $isCheck.hashCode());
      Object $outboundSn = this.getOutboundSn();
      result = result * 59 + ($outboundSn == null ? 43 : $outboundSn.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   public static class WmsOutboundRemindBuilder {
      private Long id;
      private Long projectId;
      private Long outboundId;
      private String outboundSn;
      private String content;
      private Long applicantId;
      private String applicantName;
      private Boolean isCheck;

      WmsOutboundRemindBuilder() {
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder outboundId(final Long outboundId) {
         this.outboundId = outboundId;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder outboundSn(final String outboundSn) {
         this.outboundSn = outboundSn;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsOutboundRemind.WmsOutboundRemindBuilder isCheck(final Boolean isCheck) {
         this.isCheck = isCheck;
         return this;
      }

      public WmsOutboundRemind build() {
         return new WmsOutboundRemind(
            this.id, this.projectId, this.outboundId, this.outboundSn, this.content, this.applicantId, this.applicantName, this.isCheck
         );
      }

      @Override
      public String toString() {
         return "WmsOutboundRemind.WmsOutboundRemindBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", outboundId="
            + this.outboundId
            + ", outboundSn="
            + this.outboundSn
            + ", content="
            + this.content
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", isCheck="
            + this.isCheck
            + ")";
      }
   }
}
