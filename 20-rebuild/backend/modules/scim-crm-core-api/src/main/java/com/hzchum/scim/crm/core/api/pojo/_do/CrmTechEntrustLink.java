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

@ApiModel(value = "CrmTechEntrustLink对象", description = "技术委托指定连接表（用户绑定项目）")
@Entity
@TableName("crm_tech_entrust_link")
@Table(name = "crm_tech_entrust_link")
@org.hibernate.annotations.Table(appliesTo = "crm_tech_entrust_link", comment = "技术委托指定连接表（用户绑定项目）")
public class CrmTechEntrustLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "用户名称", notes = "用户名称")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户名称'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "crmSettlementBusinessTypeEnum", value = "直营非直营类型", notes = "直营非直营类型")
   @TableField("crm_settlement_business_type_enum")
   @Column(name = "crm_settlement_business_type_enum", columnDefinition = "int(11)  COMMENT '直营非直营类型'", nullable = false)
   private Integer crmSettlementBusinessTypeEnum;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目id", notes = "项目id")
   @TableField("crm_project_information_warehousing_id")
   @Column(name = "crm_project_information_warehousing_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmSubmissionStatusEnum", value = "提报状态", notes = "提报状态")
   @TableField("crm_submission_status_enum")
   @Column(name = "crm_submission_status_enum", columnDefinition = "int(11)  COMMENT '提报状态'", nullable = false)
   private Integer crmSubmissionStatusEnum;

   public static CrmTechEntrustLink.CrmTechEntrustLinkBuilder builder() {
      return new CrmTechEntrustLink.CrmTechEntrustLinkBuilder();
   }

   public CrmTechEntrustLink() {
   }

   public CrmTechEntrustLink(
      final Long id,
      final Long userId,
      final Long createUserId,
      final Integer crmSettlementBusinessTypeEnum,
      final Long crmProjectInformationWarehousingId,
      final Integer crmSubmissionStatusEnum
   ) {
      this.id = id;
      this.userId = userId;
      this.createUserId = createUserId;
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Integer getCrmSettlementBusinessTypeEnum() {
      return this.crmSettlementBusinessTypeEnum;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Integer getCrmSubmissionStatusEnum() {
      return this.crmSubmissionStatusEnum;
   }

   public CrmTechEntrustLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmTechEntrustLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public CrmTechEntrustLink setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public CrmTechEntrustLink setCrmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
      this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
      return this;
   }

   public CrmTechEntrustLink setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmTechEntrustLink setCrmSubmissionStatusEnum(final Integer crmSubmissionStatusEnum) {
      this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTechEntrustLink(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", crmSettlementBusinessTypeEnum="
         + this.getCrmSettlementBusinessTypeEnum()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmSubmissionStatusEnum="
         + this.getCrmSubmissionStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTechEntrustLink)) {
         return false;
      }

      CrmTechEntrustLink other = (CrmTechEntrustLink)o;
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
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
               Object other$crmSettlementBusinessTypeEnum = other.getCrmSettlementBusinessTypeEnum();
               if (this$crmSettlementBusinessTypeEnum == null
                  ? other$crmSettlementBusinessTypeEnum == null
                  : this$crmSettlementBusinessTypeEnum.equals(other$crmSettlementBusinessTypeEnum)) {
                  Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
                  Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
                  if (this$crmProjectInformationWarehousingId == null
                     ? other$crmProjectInformationWarehousingId == null
                     : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
                     Object this$crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
                     Object other$crmSubmissionStatusEnum = other.getCrmSubmissionStatusEnum();
                     return this$crmSubmissionStatusEnum == null
                        ? other$crmSubmissionStatusEnum == null
                        : this$crmSubmissionStatusEnum.equals(other$crmSubmissionStatusEnum);
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
      return other instanceof CrmTechEntrustLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $crmSettlementBusinessTypeEnum = this.getCrmSettlementBusinessTypeEnum();
      result = result * 59 + ($crmSettlementBusinessTypeEnum == null ? 43 : $crmSettlementBusinessTypeEnum.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmSubmissionStatusEnum = this.getCrmSubmissionStatusEnum();
      return result * 59 + ($crmSubmissionStatusEnum == null ? 43 : $crmSubmissionStatusEnum.hashCode());
   }

   public static class CrmTechEntrustLinkBuilder {
      private Long id;
      private Long userId;
      private Long createUserId;
      private Integer crmSettlementBusinessTypeEnum;
      private Long crmProjectInformationWarehousingId;
      private Integer crmSubmissionStatusEnum;

      CrmTechEntrustLinkBuilder() {
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder crmSettlementBusinessTypeEnum(final Integer crmSettlementBusinessTypeEnum) {
         this.crmSettlementBusinessTypeEnum = crmSettlementBusinessTypeEnum;
         return this;
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder crmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmTechEntrustLink.CrmTechEntrustLinkBuilder crmSubmissionStatusEnum(final Integer crmSubmissionStatusEnum) {
         this.crmSubmissionStatusEnum = crmSubmissionStatusEnum;
         return this;
      }

      public CrmTechEntrustLink build() {
         return new CrmTechEntrustLink(
            this.id, this.userId, this.createUserId, this.crmSettlementBusinessTypeEnum, this.crmProjectInformationWarehousingId, this.crmSubmissionStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmTechEntrustLink.CrmTechEntrustLinkBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", createUserId="
            + this.createUserId
            + ", crmSettlementBusinessTypeEnum="
            + this.crmSettlementBusinessTypeEnum
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", crmSubmissionStatusEnum="
            + this.crmSubmissionStatusEnum
            + ")";
      }
   }
}
