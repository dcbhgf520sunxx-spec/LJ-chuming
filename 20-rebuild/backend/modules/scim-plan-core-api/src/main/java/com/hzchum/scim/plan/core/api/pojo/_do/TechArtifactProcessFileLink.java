package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechArtifactProcessFileLink对象", description = "构件和工艺文件关联表 ")
@Entity
@TableName("tech_artifact_process_file_link")
@Table(name = "tech_artifact_process_file_link")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_process_file_link", comment = "构件和工艺文件关联表 ")
public class TechArtifactProcessFileLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty("构件种类表id")
   @TableField("structure_class_id")
   @Column(name = "structure_class_id", columnDefinition = "bigint(20)  comment '构件种类表id'", nullable = false)
   private Long structureClassId;
   @ApiModelProperty(name = "name", value = "构件名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) COMMENT '构件名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '构件编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "构件规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255) COMMENT '构件规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "material", value = "构件材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '构件材质'")
   private String material;
   @ApiModelProperty(name = "processFileId", value = "工艺文件表id", notes = "工艺文件表id")
   @TableField("process_file_id")
   @Column(name = "process_file_id", columnDefinition = "bigint(20)  COMMENT '工艺文件表id'", nullable = false)
   private Long processFileId;
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   @TableField("process_type")
   @Column(name = "process_type", columnDefinition = "int(11)  COMMENT '工艺类型 1焊接工艺 2装配工艺 4涂装工艺'", nullable = false)
   private Integer processType;

   public static TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder builder() {
      return new TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder();
   }

   public TechArtifactProcessFileLink() {
   }

   public TechArtifactProcessFileLink(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long structureClassId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Long processFileId,
      final Integer processType
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.structureClassId = structureClassId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.processFileId = processFileId;
      this.processType = processType;
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

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getProcessFileId() {
      return this.processFileId;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public TechArtifactProcessFileLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactProcessFileLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechArtifactProcessFileLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechArtifactProcessFileLink setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public TechArtifactProcessFileLink setName(final String name) {
      this.name = name;
      return this;
   }

   public TechArtifactProcessFileLink setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechArtifactProcessFileLink setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechArtifactProcessFileLink setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechArtifactProcessFileLink setProcessFileId(final Long processFileId) {
      this.processFileId = processFileId;
      return this;
   }

   public TechArtifactProcessFileLink setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileLink(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", processFileId="
         + this.getProcessFileId()
         + ", processType="
         + this.getProcessType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileLink)) {
         return false;
      }

      TechArtifactProcessFileLink other = (TechArtifactProcessFileLink)o;
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
               Object this$structureClassId = this.getStructureClassId();
               Object other$structureClassId = other.getStructureClassId();
               if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                  Object this$processFileId = this.getProcessFileId();
                  Object other$processFileId = other.getProcessFileId();
                  if (this$processFileId == null ? other$processFileId == null : this$processFileId.equals(other$processFileId)) {
                     Object this$processType = this.getProcessType();
                     Object other$processType = other.getProcessType();
                     if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof TechArtifactProcessFileLink;
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
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $processFileId = this.getProcessFileId();
      result = result * 59 + ($processFileId == null ? 43 : $processFileId.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   public static class TechArtifactProcessFileLinkBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long structureClassId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Long processFileId;
      private Integer processType;

      TechArtifactProcessFileLinkBuilder() {
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder processFileId(final Long processFileId) {
         this.processFileId = processFileId;
         return this;
      }

      public TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFileLink build() {
         return new TechArtifactProcessFileLink(
            this.id,
            this.projectId,
            this.monomerId,
            this.structureClassId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.processFileId,
            this.processType
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileLink.TechArtifactProcessFileLinkBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", structureClassId="
            + this.structureClassId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", processFileId="
            + this.processFileId
            + ", processType="
            + this.processType
            + ")";
      }
   }
}
