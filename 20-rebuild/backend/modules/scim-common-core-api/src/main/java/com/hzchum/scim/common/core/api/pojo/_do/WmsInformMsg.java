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

@ApiModel(value = "WmsInformMsg对象", description = "通知信息表")
@Entity
@TableName("wms_inform_msg")
@Table(name = "wms_inform_msg")
@org.hibernate.annotations.Table(appliesTo = "wms_inform_msg", comment = "通知信息表")
public class WmsInformMsg extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "headline", value = "标题", notes = "标题")
   @TableField("headline")
   @Column(name = "headline", columnDefinition = "varchar(50)  COMMENT '标题'", nullable = true)
   private String headline;
   @ApiModelProperty(name = "userId", value = "接收人ID", notes = "接收人ID")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '接收人ID'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "dataId", value = "数据ID", notes = "数据ID")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint  COMMENT '数据ID'", nullable = true)
   private Long dataId;
   @ApiModelProperty(name = "approveRecordSerialNumber", value = "审批日志表编号", notes = "审批日志表编号")
   @TableField("approve_record_serial_number")
   @Column(name = "approve_record_serial_number", columnDefinition = "varchar(30)  COMMENT '审批日志表编号'", nullable = true)
   private String approveRecordSerialNumber;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   @TableField("content")
   @Column(name = "content", columnDefinition = "varchar(500)  COMMENT '内容'", nullable = true)
   private String content;
   @ApiModelProperty(name = "status", value = "读取状态 0未读  1已读  默认未读", notes = "读取状态 0未读  1已读  默认未读")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '0' COMMENT '读取状态 0未读  1已读  默认未读'", nullable = true)
   private Boolean status;
   @ApiModelProperty(name = "componentName", value = "跳转路径名称", notes = "跳转路径名称")
   @TableField("component_name")
   @Column(name = "component_name", columnDefinition = "varchar(255) COMMENT '跳转路径名称'", nullable = true)
   private String componentName;
   @ApiModelProperty(name = "informType", value = "消息类型 InformTypeEnum", notes = "消息类型 InformTypeEnum")
   @TableField("inform_type")
   @Column(name = "inform_type", columnDefinition = "int COMMENT '消息类型 InformTypeEnum'", nullable = true)
   private Integer informType;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(500)  COMMENT '备注'", nullable = true)
   private String remark;

   public static WmsInformMsg.WmsInformMsgBuilder builder() {
      return new WmsInformMsg.WmsInformMsgBuilder();
   }

   public WmsInformMsg() {
   }

   public WmsInformMsg(
      final Long id,
      final String headline,
      final Long userId,
      final Long dataId,
      final String approveRecordSerialNumber,
      final String content,
      final Boolean status,
      final String componentName,
      final Integer informType,
      final String remark
   ) {
      this.id = id;
      this.headline = headline;
      this.userId = userId;
      this.dataId = dataId;
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      this.content = content;
      this.status = status;
      this.componentName = componentName;
      this.informType = informType;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getHeadline() {
      return this.headline;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public String getApproveRecordSerialNumber() {
      return this.approveRecordSerialNumber;
   }

   public String getContent() {
      return this.content;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public String getComponentName() {
      return this.componentName;
   }

   public Integer getInformType() {
      return this.informType;
   }

   public String getRemark() {
      return this.remark;
   }

   public WmsInformMsg setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsInformMsg setHeadline(final String headline) {
      this.headline = headline;
      return this;
   }

   public WmsInformMsg setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public WmsInformMsg setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public WmsInformMsg setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      return this;
   }

   public WmsInformMsg setContent(final String content) {
      this.content = content;
      return this;
   }

   public WmsInformMsg setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public WmsInformMsg setComponentName(final String componentName) {
      this.componentName = componentName;
      return this;
   }

   public WmsInformMsg setInformType(final Integer informType) {
      this.informType = informType;
      return this;
   }

   public WmsInformMsg setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "WmsInformMsg(id="
         + this.getId()
         + ", headline="
         + this.getHeadline()
         + ", userId="
         + this.getUserId()
         + ", dataId="
         + this.getDataId()
         + ", approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ", content="
         + this.getContent()
         + ", status="
         + this.getStatus()
         + ", componentName="
         + this.getComponentName()
         + ", informType="
         + this.getInformType()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsInformMsg)) {
         return false;
      }

      WmsInformMsg other = (WmsInformMsg)o;
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
            Object this$dataId = this.getDataId();
            Object other$dataId = other.getDataId();
            if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$informType = this.getInformType();
                  Object other$informType = other.getInformType();
                  if (this$informType == null ? other$informType == null : this$informType.equals(other$informType)) {
                     Object this$headline = this.getHeadline();
                     Object other$headline = other.getHeadline();
                     if (this$headline == null ? other$headline == null : this$headline.equals(other$headline)) {
                        Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
                        Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
                        if (this$approveRecordSerialNumber == null
                           ? other$approveRecordSerialNumber == null
                           : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber)) {
                           Object this$content = this.getContent();
                           Object other$content = other.getContent();
                           if (this$content == null ? other$content == null : this$content.equals(other$content)) {
                              Object this$componentName = this.getComponentName();
                              Object other$componentName = other.getComponentName();
                              if (this$componentName == null ? other$componentName == null : this$componentName.equals(other$componentName)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsInformMsg;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $informType = this.getInformType();
      result = result * 59 + ($informType == null ? 43 : $informType.hashCode());
      Object $headline = this.getHeadline();
      result = result * 59 + ($headline == null ? 43 : $headline.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      result = result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $componentName = this.getComponentName();
      result = result * 59 + ($componentName == null ? 43 : $componentName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class WmsInformMsgBuilder {
      private Long id;
      private String headline;
      private Long userId;
      private Long dataId;
      private String approveRecordSerialNumber;
      private String content;
      private Boolean status;
      private String componentName;
      private Integer informType;
      private String remark;

      WmsInformMsgBuilder() {
      }

      public WmsInformMsg.WmsInformMsgBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder headline(final String headline) {
         this.headline = headline;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder componentName(final String componentName) {
         this.componentName = componentName;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder informType(final Integer informType) {
         this.informType = informType;
         return this;
      }

      public WmsInformMsg.WmsInformMsgBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsInformMsg build() {
         return new WmsInformMsg(
            this.id,
            this.headline,
            this.userId,
            this.dataId,
            this.approveRecordSerialNumber,
            this.content,
            this.status,
            this.componentName,
            this.informType,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "WmsInformMsg.WmsInformMsgBuilder(id="
            + this.id
            + ", headline="
            + this.headline
            + ", userId="
            + this.userId
            + ", dataId="
            + this.dataId
            + ", approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ", content="
            + this.content
            + ", status="
            + this.status
            + ", componentName="
            + this.componentName
            + ", informType="
            + this.informType
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
