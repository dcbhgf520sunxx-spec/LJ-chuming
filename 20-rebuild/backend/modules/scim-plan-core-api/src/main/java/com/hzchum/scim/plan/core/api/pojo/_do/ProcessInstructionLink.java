package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ProcessInstructionLink对象", description = "工艺指导书与产品关联关系")
@Entity
@TableName("process_instruction_link")
@Table(name = "process_instruction_link")
@org.hibernate.annotations.Table(appliesTo = "process_instruction_link", comment = "工艺指导书与产品关联关系")
public class ProcessInstructionLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "上传人id", notes = "上传人id")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '上传人id'", nullable = false)
   private Long createUserId;
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
   @ApiModelProperty(name = "serialNumber", value = "产品编号(深化图纸和零件图)", notes = "产品编号(深化图纸和零件图)")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '产品编号(深化图纸和零件图)'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "productType", value = "产品类型 1零件, 2构件，4围护, 8辅材, 16组立】", notes = "产品类型 1零件, 2构件，4围护, 8辅材, 16组立】")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(2)  COMMENT '产品类型 1零件, 2构件，4围护, 8辅材, 16组立】'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书", notes = "资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书")
   @JsonProperty("dataType")
   @JSONField(name = "dataType")
   @TableField("data_type")
   @Column(name = "data_type", columnDefinition = "int(2)  COMMENT '资料类型 1深化图 2数控图纸 4变更文件 8施工蓝图 16xml 17工艺指导书'", nullable = false)
   private Integer dataType;
   @ApiModelProperty(name = "drawingId", value = "图纸id", notes = "图纸id")
   @JsonProperty("drawingId")
   @JSONField(name = "drawingId")
   @TableField("drawing_id")
   @Column(name = "drawing_id", columnDefinition = "bigint(20)  COMMENT '图纸id'", nullable = false)
   private Long drawingId;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '文件名称'", nullable = false)
   private String fileName;

   public static ProcessInstructionLink.ProcessInstructionLinkBuilder builder() {
      return new ProcessInstructionLink.ProcessInstructionLinkBuilder();
   }

   public ProcessInstructionLink() {
   }

   public ProcessInstructionLink(
      final Long id,
      final Long createUserId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String serialNumber,
      final Integer productType,
      final Integer dataType,
      final Long drawingId,
      final String fileName
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.productType = productType;
      this.dataType = dataType;
      this.drawingId = drawingId;
      this.fileName = fileName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCreateUserId() {
      return this.createUserId;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getDataType() {
      return this.dataType;
   }

   public Long getDrawingId() {
      return this.drawingId;
   }

   public String getFileName() {
      return this.fileName;
   }

   @JsonProperty("id")
   public ProcessInstructionLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("createUserId")
   public ProcessInstructionLink setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @JsonProperty("projectId")
   public ProcessInstructionLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ProcessInstructionLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public ProcessInstructionLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("serialNumber")
   public ProcessInstructionLink setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("productType")
   public ProcessInstructionLink setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("dataType")
   public ProcessInstructionLink setDataType(final Integer dataType) {
      this.dataType = dataType;
      return this;
   }

   @JsonProperty("drawingId")
   public ProcessInstructionLink setDrawingId(final Long drawingId) {
      this.drawingId = drawingId;
      return this;
   }

   @JsonProperty("fileName")
   public ProcessInstructionLink setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessInstructionLink(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", dataType="
         + this.getDataType()
         + ", drawingId="
         + this.getDrawingId()
         + ", fileName="
         + this.getFileName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessInstructionLink)) {
         return false;
      }

      ProcessInstructionLink other = (ProcessInstructionLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$dataType = this.getDataType();
                        Object other$dataType = other.getDataType();
                        if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                           Object this$drawingId = this.getDrawingId();
                           Object other$drawingId = other.getDrawingId();
                           if (this$drawingId == null ? other$drawingId == null : this$drawingId.equals(other$drawingId)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$fileName = this.getFileName();
                                 Object other$fileName = other.getFileName();
                                 return this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName);
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
      return other instanceof ProcessInstructionLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $drawingId = this.getDrawingId();
      result = result * 59 + ($drawingId == null ? 43 : $drawingId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $fileName = this.getFileName();
      return result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
   }

   public static class ProcessInstructionLinkBuilder {
      private Long id;
      private Long createUserId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String serialNumber;
      private Integer productType;
      private Integer dataType;
      private Long drawingId;
      private String fileName;

      ProcessInstructionLinkBuilder() {
      }

      @JsonProperty("id")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("createUserId")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      @JsonProperty("projectId")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("serialNumber")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("productType")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("dataType")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder dataType(final Integer dataType) {
         this.dataType = dataType;
         return this;
      }

      @JsonProperty("drawingId")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder drawingId(final Long drawingId) {
         this.drawingId = drawingId;
         return this;
      }

      @JsonProperty("fileName")
      public ProcessInstructionLink.ProcessInstructionLinkBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ProcessInstructionLink build() {
         return new ProcessInstructionLink(
            this.id,
            this.createUserId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.serialNumber,
            this.productType,
            this.dataType,
            this.drawingId,
            this.fileName
         );
      }

      @Override
      public String toString() {
         return "ProcessInstructionLink.ProcessInstructionLinkBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", productType="
            + this.productType
            + ", dataType="
            + this.dataType
            + ", drawingId="
            + this.drawingId
            + ", fileName="
            + this.fileName
            + ")";
      }
   }
}
