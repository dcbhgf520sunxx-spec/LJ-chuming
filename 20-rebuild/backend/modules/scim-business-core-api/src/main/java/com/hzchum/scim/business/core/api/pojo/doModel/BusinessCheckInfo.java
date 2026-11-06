package com.hzchum.scim.business.core.api.pojo.doModel;

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

@ApiModel(value = "BusinessCheckInfo对象", description = "商务价格修改记录表")
@Entity
@TableName("business_check_info")
@Table(name = "business_check_info")
public class BusinessCheckInfo extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @Column(name = "area_id", columnDefinition = "bigint(20) COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint(20) COMMENT '围护计划id'")
   private Long enclosurePlanId;
   @ApiModelProperty(name = "projectType", notes = "项目类型   1建筑钢结构 2桥梁钢结构  4立体停车库 8围护项目")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) comment '项目类型  1建筑钢结构 2桥梁钢结构  4立体停车库'")
   private Integer projectType;
   @ApiModelProperty(name = "type", value = "建钢项目: 1零件 2构件 4围护 8标准件 桥梁项目: 1分段件")
   @Column(name = "type", columnDefinition = "int(11) COMMENT '类型 1零件 2构件 4围护 8标准件'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "status", value = "审核状态 1未审核 2通过 4驳回")
   @Column(name = "status", columnDefinition = "int(11) DEFAULT 1 COMMENT '审核状态 1未审核 2通过 4驳回'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "createUserId", value = "创建人id（编辑人）")
   @Column(name = "create_user_id", columnDefinition = "bigint(20) COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "create_user_name", value = "创建人名称（编辑人）")
   @Column(name = "create_user_name", columnDefinition = "varchar(255) COMMENT '创建人名称'")
   private String createUserName;
   @ApiModelProperty(name = "check_user_id", value = "审核人id")
   @Column(name = "check_user_id", columnDefinition = "bigint(20) comment '审核人id'")
   private Long checkUserId;
   @ApiModelProperty(name = "check_user_name", value = "审核人名称")
   @Column(name = "check_user_name", columnDefinition = "varchar(255) comment '审核人'")
   private String checkUserName;
   @ApiModelProperty(name = "checkTime", value = "审核时间")
   @Column(name = "check_time", columnDefinition = "datetime(6) comment '审核时间'")
   private LocalDateTime checkTime;
   @ApiModelProperty(name = "remark", value = "备注")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;

   public static BusinessCheckInfo.BusinessCheckInfoBuilder builder() {
      return new BusinessCheckInfo.BusinessCheckInfoBuilder();
   }

   public BusinessCheckInfo() {
   }

   public BusinessCheckInfo(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long enclosurePlanId,
      final Integer projectType,
      final Integer type,
      final Integer status,
      final Long createUserId,
      final String createUserName,
      final Long checkUserId,
      final String checkUserName,
      final LocalDateTime checkTime,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.projectType = projectType;
      this.type = type;
      this.status = status;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.checkUserId = checkUserId;
      this.checkUserName = checkUserName;
      this.checkTime = checkTime;
      this.remark = remark;
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

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public BusinessCheckInfo setId(final Long id) {
      this.id = id;
      return this;
   }

   public BusinessCheckInfo setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public BusinessCheckInfo setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public BusinessCheckInfo setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public BusinessCheckInfo setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   public BusinessCheckInfo setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public BusinessCheckInfo setType(final Integer type) {
      this.type = type;
      return this;
   }

   public BusinessCheckInfo setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public BusinessCheckInfo setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public BusinessCheckInfo setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public BusinessCheckInfo setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
      return this;
   }

   public BusinessCheckInfo setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
      return this;
   }

   public BusinessCheckInfo setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
      return this;
   }

   public BusinessCheckInfo setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "BusinessCheckInfo(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", projectType="
         + this.getProjectType()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessCheckInfo)) {
         return false;
      }

      BusinessCheckInfo other = (BusinessCheckInfo)o;
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
                  Object this$enclosurePlanId = this.getEnclosurePlanId();
                  Object other$enclosurePlanId = other.getEnclosurePlanId();
                  if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                     Object this$projectType = this.getProjectType();
                     Object other$projectType = other.getProjectType();
                     if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                           Object this$status = this.getStatus();
                           Object other$status = other.getStatus();
                           if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                              Object this$createUserId = this.getCreateUserId();
                              Object other$createUserId = other.getCreateUserId();
                              if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                 Object this$checkUserId = this.getCheckUserId();
                                 Object other$checkUserId = other.getCheckUserId();
                                 if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                                    Object this$createUserName = this.getCreateUserName();
                                    Object other$createUserName = other.getCreateUserName();
                                    if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                       Object this$checkUserName = this.getCheckUserName();
                                       Object other$checkUserName = other.getCheckUserName();
                                       if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                                          Object this$checkTime = this.getCheckTime();
                                          Object other$checkTime = other.getCheckTime();
                                          if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
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
      return other instanceof BusinessCheckInfo;
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
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class BusinessCheckInfoBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long enclosurePlanId;
      private Integer projectType;
      private Integer type;
      private Integer status;
      private Long createUserId;
      private String createUserName;
      private Long checkUserId;
      private String checkUserName;
      private LocalDateTime checkTime;
      private String remark;

      BusinessCheckInfoBuilder() {
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder checkTime(final LocalDateTime checkTime) {
         this.checkTime = checkTime;
         return this;
      }

      public BusinessCheckInfo.BusinessCheckInfoBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public BusinessCheckInfo build() {
         return new BusinessCheckInfo(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.enclosurePlanId,
            this.projectType,
            this.type,
            this.status,
            this.createUserId,
            this.createUserName,
            this.checkUserId,
            this.checkUserName,
            this.checkTime,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "BusinessCheckInfo.BusinessCheckInfoBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", projectType="
            + this.projectType
            + ", type="
            + this.type
            + ", status="
            + this.status
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", checkUserId="
            + this.checkUserId
            + ", checkUserName="
            + this.checkUserName
            + ", checkTime="
            + this.checkTime
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
