package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectReceivedProblem对象", description = "")
@Entity
@TableName("project_received_problem")
@Table(name = "project_received_problem")
@org.hibernate.annotations.Table(appliesTo = "project_received_problem", comment = "项目管理收货记录表")
public class ProjectReceivedProblem extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "supplierId", value = "分供商", notes = "分供商")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分供商'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分供商名称", notes = "分供商名称")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(64)  COMMENT '分供商名称'", nullable = true)
   private String supplierName;
   @ApiModelProperty(name = "cargoListId", value = "车次id", notes = "车次id")
   @TableField("cargo_list_id")
   @Column(name = "cargo_list_id", columnDefinition = "bigint(20)  COMMENT '车次id'", nullable = true)
   private Long cargoListId;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   @TableField("license_plate")
   @Column(name = "license_plate", columnDefinition = "varchar(64)  COMMENT '车牌号'", nullable = true)
   private String licensePlate;
   @ApiModelProperty(name = "userId", value = "收货人", notes = "收货人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '收货人'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "收货人", notes = "收货人")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(255)  COMMENT '收货人'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "state", value = "是否关闭", notes = "是否关闭")
   @TableField("state")
   @Column(name = "state", columnDefinition = "int(1) default '0'  COMMENT '是否关闭'", nullable = true)
   private Integer state;
   @ApiModelProperty(name = "attachmentIds", value = "问题附件", notes = "问题附件")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '问题附件'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "closeAttachmentIds", value = "关闭附件", notes = "关闭附件")
   @TableField("close_attachment_ids")
   @Column(name = "close_attachment_ids", columnDefinition = "varchar(255)  COMMENT '关闭附件'", nullable = true)
   private String closeAttachmentIds;
   @ApiModelProperty(name = "remark", value = "关闭描述", notes = "关闭描述")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '关闭描述'", nullable = true)
   private String remark;

   public static ProjectReceivedProblem.ProjectReceivedProblemBuilder builder() {
      return new ProjectReceivedProblem.ProjectReceivedProblemBuilder();
   }

   public ProjectReceivedProblem() {
   }

   public ProjectReceivedProblem(
      final Long id,
      final Long projectId,
      final Long supplierId,
      final String supplierName,
      final Long cargoListId,
      final String licensePlate,
      final Long userId,
      final String userName,
      final Integer state,
      final String attachmentIds,
      final String closeAttachmentIds,
      final String remark
   ) {
      this.id = id;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.cargoListId = cargoListId;
      this.licensePlate = licensePlate;
      this.userId = userId;
      this.userName = userName;
      this.state = state;
      this.attachmentIds = attachmentIds;
      this.closeAttachmentIds = closeAttachmentIds;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getCargoListId() {
      return this.cargoListId;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getState() {
      return this.state;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getCloseAttachmentIds() {
      return this.closeAttachmentIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public ProjectReceivedProblem setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectReceivedProblem setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectReceivedProblem setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectReceivedProblem setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectReceivedProblem setCargoListId(final Long cargoListId) {
      this.cargoListId = cargoListId;
      return this;
   }

   public ProjectReceivedProblem setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public ProjectReceivedProblem setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectReceivedProblem setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectReceivedProblem setState(final Integer state) {
      this.state = state;
      return this;
   }

   public ProjectReceivedProblem setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public ProjectReceivedProblem setCloseAttachmentIds(final String closeAttachmentIds) {
      this.closeAttachmentIds = closeAttachmentIds;
      return this;
   }

   public ProjectReceivedProblem setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectReceivedProblem(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", cargoListId="
         + this.getCargoListId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", state="
         + this.getState()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", closeAttachmentIds="
         + this.getCloseAttachmentIds()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivedProblem)) {
         return false;
      }

      ProjectReceivedProblem other = (ProjectReceivedProblem)o;
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
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$cargoListId = this.getCargoListId();
               Object other$cargoListId = other.getCargoListId();
               if (this$cargoListId == null ? other$cargoListId == null : this$cargoListId.equals(other$cargoListId)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$state = this.getState();
                     Object other$state = other.getState();
                     if (this$state == null ? other$state == null : this$state.equals(other$state)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$licensePlate = this.getLicensePlate();
                           Object other$licensePlate = other.getLicensePlate();
                           if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$attachmentIds = this.getAttachmentIds();
                                 Object other$attachmentIds = other.getAttachmentIds();
                                 if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                                    Object this$closeAttachmentIds = this.getCloseAttachmentIds();
                                    Object other$closeAttachmentIds = other.getCloseAttachmentIds();
                                    if (this$closeAttachmentIds == null
                                       ? other$closeAttachmentIds == null
                                       : this$closeAttachmentIds.equals(other$closeAttachmentIds)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReceivedProblem;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $cargoListId = this.getCargoListId();
      result = result * 59 + ($cargoListId == null ? 43 : $cargoListId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $state = this.getState();
      result = result * 59 + ($state == null ? 43 : $state.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $closeAttachmentIds = this.getCloseAttachmentIds();
      result = result * 59 + ($closeAttachmentIds == null ? 43 : $closeAttachmentIds.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class ProjectReceivedProblemBuilder {
      private Long id;
      private Long projectId;
      private Long supplierId;
      private String supplierName;
      private Long cargoListId;
      private String licensePlate;
      private Long userId;
      private String userName;
      private Integer state;
      private String attachmentIds;
      private String closeAttachmentIds;
      private String remark;

      ProjectReceivedProblemBuilder() {
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder cargoListId(final Long cargoListId) {
         this.cargoListId = cargoListId;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder state(final Integer state) {
         this.state = state;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder closeAttachmentIds(final String closeAttachmentIds) {
         this.closeAttachmentIds = closeAttachmentIds;
         return this;
      }

      public ProjectReceivedProblem.ProjectReceivedProblemBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectReceivedProblem build() {
         return new ProjectReceivedProblem(
            this.id,
            this.projectId,
            this.supplierId,
            this.supplierName,
            this.cargoListId,
            this.licensePlate,
            this.userId,
            this.userName,
            this.state,
            this.attachmentIds,
            this.closeAttachmentIds,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ProjectReceivedProblem.ProjectReceivedProblemBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", cargoListId="
            + this.cargoListId
            + ", licensePlate="
            + this.licensePlate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", state="
            + this.state
            + ", attachmentIds="
            + this.attachmentIds
            + ", closeAttachmentIds="
            + this.closeAttachmentIds
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
