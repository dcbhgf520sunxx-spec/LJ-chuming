package com.hzchum.scim.system.core.api.pojo._do;

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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysAssembleConfigChange对象", description = "组立配置变更表")
@Entity
@TableName("sys_assemble_config_change")
@Table(name = "sys_assemble_config_change")
public class SysAssembleConfigChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeUserId", value = "变更用户id", notes = "变更用户id")
   @JsonProperty("changeUserId")
   @JSONField(name = "changeUserId")
   @TableField("change_user_id")
   @Column(name = "change_user_id", columnDefinition = "bigint(20)  COMMENT '变更用户id'", nullable = false)
   private Long changeUserId;
   @ApiModelProperty(name = "auditUserId", value = "审批用户id", notes = "审批用户id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审批用户id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditStatus", value = "审批状态。1 待审核 2 通过 4 不通过", notes = "审批状态。1 待审核 2 通过 4 不通过")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11)  COMMENT '审批状态。1 待审核 2 通过 4 不通过'", nullable = true)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审批时间", notes = "审批时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审批时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "assembleConfigId", value = "组立配置表id", notes = "组立配置表id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20)  COMMENT '组立配置表id'", nullable = false)
   private Long assembleConfigId;
   @ApiModelProperty(name = "name", value = "部件类型名称", notes = "部件类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '部件类型名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   @JsonProperty("boolSectionSteel")
   @JSONField(name = "boolSectionSteel")
   @TableField("bool_section_steel")
   @Column(name = "bool_section_steel", columnDefinition = "tinyint(1) default '0' COMMENT '是否成品型材 [0 否, 1 是]'", nullable = false)
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default '1' COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysAssembleConfigChange.SysAssembleConfigChangeBuilder builder() {
      return new SysAssembleConfigChange.SysAssembleConfigChangeBuilder();
   }

   public SysAssembleConfigChange() {
   }

   public SysAssembleConfigChange(
      final Long id,
      final Long changeUserId,
      final Long auditUserId,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final Long assembleConfigId,
      final String name,
      final Boolean boolSectionSteel,
      final Integer sort,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.changeUserId = changeUserId;
      this.auditUserId = auditUserId;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.assembleConfigId = assembleConfigId;
      this.name = name;
      this.boolSectionSteel = boolSectionSteel;
      this.sort = sort;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeUserId() {
      return this.changeUserId;
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

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public SysAssembleConfigChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("changeUserId")
   public SysAssembleConfigChange setChangeUserId(final Long changeUserId) {
      this.changeUserId = changeUserId;
      return this;
   }

   @JsonProperty("auditUserId")
   public SysAssembleConfigChange setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditStatus")
   public SysAssembleConfigChange setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("auditTime")
   public SysAssembleConfigChange setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("assembleConfigId")
   public SysAssembleConfigChange setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("name")
   public SysAssembleConfigChange setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("boolSectionSteel")
   public SysAssembleConfigChange setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
      return this;
   }

   @JsonProperty("sort")
   public SysAssembleConfigChange setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public SysAssembleConfigChange setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysAssembleConfigChange(id="
         + this.getId()
         + ", changeUserId="
         + this.getChangeUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", name="
         + this.getName()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", sort="
         + this.getSort()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAssembleConfigChange)) {
         return false;
      }

      SysAssembleConfigChange other = (SysAssembleConfigChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeUserId = this.getChangeUserId();
         Object other$changeUserId = other.getChangeUserId();
         if (this$changeUserId == null ? other$changeUserId == null : this$changeUserId.equals(other$changeUserId)) {
            Object this$auditUserId = this.getAuditUserId();
            Object other$auditUserId = other.getAuditUserId();
            if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                  Object this$assembleConfigId = this.getAssembleConfigId();
                  Object other$assembleConfigId = other.getAssembleConfigId();
                  if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
                     Object this$boolSectionSteel = this.getBoolSectionSteel();
                     Object other$boolSectionSteel = other.getBoolSectionSteel();
                     if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                        Object this$sort = this.getSort();
                        Object other$sort = other.getSort();
                        if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                           Object this$mesProductEnum = this.getMesProductEnum();
                           Object other$mesProductEnum = other.getMesProductEnum();
                           if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                              Object this$auditTime = this.getAuditTime();
                              Object other$auditTime = other.getAuditTime();
                              if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof SysAssembleConfigChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeUserId = this.getChangeUserId();
      result = result * 59 + ($changeUserId == null ? 43 : $changeUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SysAssembleConfigChangeBuilder {
      private Long id;
      private Long changeUserId;
      private Long auditUserId;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private Long assembleConfigId;
      private String name;
      private Boolean boolSectionSteel;
      private Integer sort;
      private Integer mesProductEnum;

      SysAssembleConfigChangeBuilder() {
      }

      @JsonProperty("id")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("changeUserId")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder changeUserId(final Long changeUserId) {
         this.changeUserId = changeUserId;
         return this;
      }

      @JsonProperty("auditUserId")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditStatus")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("auditTime")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("name")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("boolSectionSteel")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("sort")
      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysAssembleConfigChange.SysAssembleConfigChangeBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysAssembleConfigChange build() {
         return new SysAssembleConfigChange(
            this.id,
            this.changeUserId,
            this.auditUserId,
            this.auditStatus,
            this.auditTime,
            this.assembleConfigId,
            this.name,
            this.boolSectionSteel,
            this.sort,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysAssembleConfigChange.SysAssembleConfigChangeBuilder(id="
            + this.id
            + ", changeUserId="
            + this.changeUserId
            + ", auditUserId="
            + this.auditUserId
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", name="
            + this.name
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", sort="
            + this.sort
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
