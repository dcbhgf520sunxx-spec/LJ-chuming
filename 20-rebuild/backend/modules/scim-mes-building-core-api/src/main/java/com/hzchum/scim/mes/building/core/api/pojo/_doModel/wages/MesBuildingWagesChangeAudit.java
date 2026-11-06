package com.hzchum.scim.mes.building.core.api.pojo._doModel.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWagesChangeAudit对象", description = "")
@TableName("mes_building_wages_change_audit")
@Table(name = "mes_building_wages_change_audit")
public class MesBuildingWagesChangeAudit extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "auditUserId", value = "审核人", notes = "审核人")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 [0 待审核 1 审核通过 2审核不通过]", notes = "审核状态 [0 待审核 1 审核通过 2审核不通过]")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(1) default '0' COMMENT '审核状态 [0 待审核 1 审核通过 2审核不通过]'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "organizationType", value = "编制类型", notes = "编制类型")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   @TableField("organization_type")
   @Column(name = "organization_type", columnDefinition = "tinyint(1)  COMMENT '编制类型'", nullable = false)
   private Boolean organizationType;

   public static MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder builder() {
      return new MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder();
   }

   public MesBuildingWagesChangeAudit() {
   }

   public MesBuildingWagesChangeAudit(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long userId,
      final Long auditUserId,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final Long productId,
      final Integer productType,
      final Long processId,
      final Boolean organizationType
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.userId = userId;
      this.auditUserId = auditUserId;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.productId = productId;
      this.productType = productType;
      this.processId = processId;
      this.organizationType = organizationType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("id")
   public MesBuildingWagesChangeAudit setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingWagesChangeAudit setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingWagesChangeAudit setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingWagesChangeAudit setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingWagesChangeAudit setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingWagesChangeAudit setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("auditUserId")
   public MesBuildingWagesChangeAudit setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditStatus")
   public MesBuildingWagesChangeAudit setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("auditTime")
   public MesBuildingWagesChangeAudit setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingWagesChangeAudit setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingWagesChangeAudit setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingWagesChangeAudit setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("organizationType")
   public MesBuildingWagesChangeAudit setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWagesChangeAudit(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", userId="
         + this.getUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", processId="
         + this.getProcessId()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWagesChangeAudit)) {
         return false;
      }

      MesBuildingWagesChangeAudit other = (MesBuildingWagesChangeAudit)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$auditUserId = this.getAuditUserId();
                        Object other$auditUserId = other.getAuditUserId();
                        if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$productType = this.getProductType();
                                 Object other$productType = other.getProductType();
                                 if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                    Object this$processId = this.getProcessId();
                                    Object other$processId = other.getProcessId();
                                    if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                       Object this$organizationType = this.getOrganizationType();
                                       Object other$organizationType = other.getOrganizationType();
                                       if (this$organizationType == null
                                          ? other$organizationType == null
                                          : this$organizationType.equals(other$organizationType)) {
                                          Object this$auditTime = this.getAuditTime();
                                          Object other$auditTime = other.getAuditTime();
                                          return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof MesBuildingWagesChangeAudit;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $organizationType = this.getOrganizationType();
      result = result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   public static class MesBuildingWagesChangeAuditBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long userId;
      private Long auditUserId;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private Long productId;
      private Integer productType;
      private Long processId;
      private Boolean organizationType;

      MesBuildingWagesChangeAuditBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("auditUserId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditStatus")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("auditTime")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("organizationType")
      public MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public MesBuildingWagesChangeAudit build() {
         return new MesBuildingWagesChangeAudit(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.userId,
            this.auditUserId,
            this.auditStatus,
            this.auditTime,
            this.productId,
            this.productType,
            this.processId,
            this.organizationType
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWagesChangeAudit.MesBuildingWagesChangeAuditBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", userId="
            + this.userId
            + ", auditUserId="
            + this.auditUserId
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", processId="
            + this.processId
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
