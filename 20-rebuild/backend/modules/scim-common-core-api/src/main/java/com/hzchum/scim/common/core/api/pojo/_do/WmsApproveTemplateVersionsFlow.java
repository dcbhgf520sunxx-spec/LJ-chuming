package com.hzchum.scim.common.core.api.pojo._do;

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

@ApiModel(value = "WmsApproveTemplateVersionsFlow对象", description = "审批模版版本流程表")
@Entity
@TableName("wms_approve_template_versions_flow")
@Table(name = "wms_approve_template_versions_flow")
@org.hibernate.annotations.Table(appliesTo = "wms_approve_template_versions_flow", comment = "审批模版版本流程表")
public class WmsApproveTemplateVersionsFlow extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "approveVersionsId", value = "对应审批版本id", notes = "对应审批版本id")
   @TableField("approve_versions_id")
   @Column(name = "approve_versions_id", columnDefinition = "bigint  COMMENT '对应审批版本id'", nullable = true)
   private Long approveVersionsId;
   @ApiModelProperty(
      name = "type",
      value = "审批流程标识 1 会签 2或签 3单人 4抄送、通知 5发起申请 6质检 ApproveTemplateVersionsFlowEnum",
      notes = "审批流程标识 1 会签 2或签 3单人 4抄送、通知 5发起申请 6质检 ApproveTemplateVersionsFlowEnum"
   )
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '审批流程标识 1 会签 2或签 3单人 4抄送、通知 5发起申请 6质检 ApproveTemplateVersionsFlowEnum'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "name", value = "对应本身的type 会签 或签 单人 ", notes = "对应本身的type 会签 或签 单人 ")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(20)  COMMENT '对应本身的type 会签 或签 单人 '", nullable = true)
   private String name;
   @ApiModelProperty(name = "userIds", value = "审批人ids  用逗号隔开", notes = "审批人ids  用逗号隔开")
   @TableField("user_ids")
   @Column(name = "user_ids", columnDefinition = "varchar(255)  COMMENT '审批人ids  用逗号隔开'", nullable = true)
   private String userIds;

   public static WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder builder() {
      return new WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder();
   }

   public WmsApproveTemplateVersionsFlow() {
   }

   public WmsApproveTemplateVersionsFlow(final Long id, final Long approveVersionsId, final Integer type, final String name, final String userIds) {
      this.id = id;
      this.approveVersionsId = approveVersionsId;
      this.type = type;
      this.name = name;
      this.userIds = userIds;
   }

   public Long getId() {
      return this.id;
   }

   public Long getApproveVersionsId() {
      return this.approveVersionsId;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getUserIds() {
      return this.userIds;
   }

   public WmsApproveTemplateVersionsFlow setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsApproveTemplateVersionsFlow setApproveVersionsId(final Long approveVersionsId) {
      this.approveVersionsId = approveVersionsId;
      return this;
   }

   public WmsApproveTemplateVersionsFlow setType(final Integer type) {
      this.type = type;
      return this;
   }

   public WmsApproveTemplateVersionsFlow setName(final String name) {
      this.name = name;
      return this;
   }

   public WmsApproveTemplateVersionsFlow setUserIds(final String userIds) {
      this.userIds = userIds;
      return this;
   }

   @Override
   public String toString() {
      return "WmsApproveTemplateVersionsFlow(id="
         + this.getId()
         + ", approveVersionsId="
         + this.getApproveVersionsId()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", userIds="
         + this.getUserIds()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveTemplateVersionsFlow)) {
         return false;
      }

      WmsApproveTemplateVersionsFlow other = (WmsApproveTemplateVersionsFlow)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$approveVersionsId = this.getApproveVersionsId();
         Object other$approveVersionsId = other.getApproveVersionsId();
         if (this$approveVersionsId == null ? other$approveVersionsId == null : this$approveVersionsId.equals(other$approveVersionsId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$userIds = this.getUserIds();
                  Object other$userIds = other.getUserIds();
                  return this$userIds == null ? other$userIds == null : this$userIds.equals(other$userIds);
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
      return other instanceof WmsApproveTemplateVersionsFlow;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $approveVersionsId = this.getApproveVersionsId();
      result = result * 59 + ($approveVersionsId == null ? 43 : $approveVersionsId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $userIds = this.getUserIds();
      return result * 59 + ($userIds == null ? 43 : $userIds.hashCode());
   }

   public static class WmsApproveTemplateVersionsFlowBuilder {
      private Long id;
      private Long approveVersionsId;
      private Integer type;
      private String name;
      private String userIds;

      WmsApproveTemplateVersionsFlowBuilder() {
      }

      public WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder approveVersionsId(final Long approveVersionsId) {
         this.approveVersionsId = approveVersionsId;
         return this;
      }

      public WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder userIds(final String userIds) {
         this.userIds = userIds;
         return this;
      }

      public WmsApproveTemplateVersionsFlow build() {
         return new WmsApproveTemplateVersionsFlow(this.id, this.approveVersionsId, this.type, this.name, this.userIds);
      }

      @Override
      public String toString() {
         return "WmsApproveTemplateVersionsFlow.WmsApproveTemplateVersionsFlowBuilder(id="
            + this.id
            + ", approveVersionsId="
            + this.approveVersionsId
            + ", type="
            + this.type
            + ", name="
            + this.name
            + ", userIds="
            + this.userIds
            + ")";
      }
   }
}
