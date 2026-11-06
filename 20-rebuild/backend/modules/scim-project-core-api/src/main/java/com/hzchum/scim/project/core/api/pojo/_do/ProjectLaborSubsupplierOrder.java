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

@ApiModel(value = "ProjectLaborSubsupplierOrder对象", description = "")
@Entity
@TableName("project_labor_subsupplier_order")
@Table(name = "project_labor_subsupplier_order")
public class ProjectLaborSubsupplierOrder extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   @TableField("project_type")
   @Column(name = "project_type", columnDefinition = "int(11) default 1  COMMENT '项目类型 1建钢项目 2桥梁项目 4立体停车库'", nullable = false)
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "serialNumber", value = "分包编号", notes = "分包编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '分包编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "supplierId", value = "分包商", notes = "分包商")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '分包商'", nullable = false)
   private Long supplierId;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人", notes = "操作人")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '操作人'", nullable = true)
   private String userName;
   @ApiModelProperty(name = "supplierType", value = "分包类型", notes = "分包类型")
   @TableField("supplier_type")
   @Column(name = "supplier_type", columnDefinition = "int(11)  COMMENT '分包类型'", nullable = true)
   private Integer supplierType;
   @ApiModelProperty(name = "notes", value = "备注", notes = "备注")
   @TableField("notes")
   @Column(name = "notes", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String notes;

   public static ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder builder() {
      return new ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder();
   }

   public ProjectLaborSubsupplierOrder() {
   }

   public ProjectLaborSubsupplierOrder(
      final Long id,
      final Long projectId,
      final Integer projectType,
      final Integer productType,
      final String serialNumber,
      final Long supplierId,
      final Long userId,
      final String userName,
      final Integer supplierType,
      final String notes
   ) {
      this.id = id;
      this.projectId = projectId;
      this.projectType = projectType;
      this.productType = productType;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.userId = userId;
      this.userName = userName;
      this.supplierType = supplierType;
      this.notes = notes;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getSupplierType() {
      return this.supplierType;
   }

   public String getNotes() {
      return this.notes;
   }

   public ProjectLaborSubsupplierOrder setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectLaborSubsupplierOrder setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectLaborSubsupplierOrder setProjectType(final Integer projectType) {
      this.projectType = projectType;
      return this;
   }

   public ProjectLaborSubsupplierOrder setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectLaborSubsupplierOrder setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ProjectLaborSubsupplierOrder setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public ProjectLaborSubsupplierOrder setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectLaborSubsupplierOrder setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ProjectLaborSubsupplierOrder setSupplierType(final Integer supplierType) {
      this.supplierType = supplierType;
      return this;
   }

   public ProjectLaborSubsupplierOrder setNotes(final String notes) {
      this.notes = notes;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectLaborSubsupplierOrder(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", supplierType="
         + this.getSupplierType()
         + ", notes="
         + this.getNotes()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLaborSubsupplierOrder)) {
         return false;
      }

      ProjectLaborSubsupplierOrder other = (ProjectLaborSubsupplierOrder)o;
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
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$supplierType = this.getSupplierType();
                        Object other$supplierType = other.getSupplierType();
                        if (this$supplierType == null ? other$supplierType == null : this$supplierType.equals(other$supplierType)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$userName = this.getUserName();
                              Object other$userName = other.getUserName();
                              if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                 Object this$notes = this.getNotes();
                                 Object other$notes = other.getNotes();
                                 return this$notes == null ? other$notes == null : this$notes.equals(other$notes);
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
      return other instanceof ProjectLaborSubsupplierOrder;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $supplierType = this.getSupplierType();
      result = result * 59 + ($supplierType == null ? 43 : $supplierType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $notes = this.getNotes();
      return result * 59 + ($notes == null ? 43 : $notes.hashCode());
   }

   public static class ProjectLaborSubsupplierOrderBuilder {
      private Long id;
      private Long projectId;
      private Integer projectType;
      private Integer productType;
      private String serialNumber;
      private Long supplierId;
      private Long userId;
      private String userName;
      private Integer supplierType;
      private String notes;

      ProjectLaborSubsupplierOrderBuilder() {
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder supplierType(final Integer supplierType) {
         this.supplierType = supplierType;
         return this;
      }

      public ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder notes(final String notes) {
         this.notes = notes;
         return this;
      }

      public ProjectLaborSubsupplierOrder build() {
         return new ProjectLaborSubsupplierOrder(
            this.id,
            this.projectId,
            this.projectType,
            this.productType,
            this.serialNumber,
            this.supplierId,
            this.userId,
            this.userName,
            this.supplierType,
            this.notes
         );
      }

      @Override
      public String toString() {
         return "ProjectLaborSubsupplierOrder.ProjectLaborSubsupplierOrderBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", serialNumber="
            + this.serialNumber
            + ", supplierId="
            + this.supplierId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", supplierType="
            + this.supplierType
            + ", notes="
            + this.notes
            + ")";
      }
   }
}
