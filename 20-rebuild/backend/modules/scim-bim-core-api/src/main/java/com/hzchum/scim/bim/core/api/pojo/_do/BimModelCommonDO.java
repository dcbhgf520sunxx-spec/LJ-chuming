package com.hzchum.scim.bim.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "BimModelCommon对象", description = "bim普通模型")
@Entity
@TableName("bim_model")
@Table(name = "bim_model")
public class BimModelCommonDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'")
   private Long areaId;
   @ApiModelProperty(name = "fileId", value = "文件id")
   @JsonProperty("fileId")
   @JSONField(name = "fileId")
   @TableField(value = "file_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "file_id", columnDefinition = "bigint(20)  COMMENT '文件id'")
   private Long fileId;
   @ApiModelProperty(name = "originalFileId", value = "迁移前的文件id")
   @JsonProperty("originalFileId")
   @JSONField(name = "originalFileId")
   @TableField(value = "original_file_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "original_file_id", columnDefinition = "bigint(20)  COMMENT '迁移前的文件id'")
   private Long originalFileId;
   @ApiModelProperty(name = "oldFileId", value = "上一次集成的文件id")
   @JsonProperty("oldFileId")
   @JSONField(name = "oldFileId")
   @TableField(value = "old_file_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "old_file_id", columnDefinition = "bigint(20)  COMMENT '上一次集成的文件id'")
   private Long oldFileId;
   @ApiModelProperty(name = "attachmentId", value = "文件的 attachment Id")
   @JsonProperty("attachmentId")
   @JSONField(name = "attachmentId")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20)  COMMENT '文件的 attachment Id'")
   private Long attachmentId;
   @ApiModelProperty(name = "edition", value = "Tekla版本")
   @JsonProperty("edition")
   @JSONField(name = "edition")
   @TableField("edition")
   @Column(name = "edition", columnDefinition = "int(2)  COMMENT 'Tekla版本'")
   private Integer edition;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @JsonProperty("fileName")
   @JSONField(name = "fileName")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(64)  COMMENT '文件名称'")
   private String fileName;
   @ApiModelProperty(name = "path", value = "文件位置")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path", columnDefinition = "varchar(255)  COMMENT '文件位置'")
   private String path;
   @ApiModelProperty(name = "translateStatus", value = "文件上传状态 参考枚举 BimStatusCommonEnum")
   @JsonProperty("translateStatus")
   @JSONField(name = "translateStatus")
   @TableField("translate_status")
   @Column(name = "translate_status", columnDefinition = "varchar(32)  COMMENT '文件上传状态'")
   private String translateStatus;
   @ApiModelProperty(name = "integrationStatus", value = "模型集成状态")
   @JsonProperty("integrationStatus")
   @JSONField(name = "integrationStatus")
   @TableField("integration_status")
   @Column(name = "integration_status", columnDefinition = "varchar(32) default 'processing_no' COMMENT '模型集成状态'")
   private String integrationStatus;
   @ApiModelProperty(name = "fileThumbnail", value = "文件缩略图")
   @JsonProperty("fileThumbnail")
   @JSONField(name = "fileThumbnail")
   @TableField(value = "file_thumbnail", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "file_thumbnail", columnDefinition = "varchar(255)  COMMENT '文件缩略图'")
   private String fileThumbnail;
   @ApiModelProperty(name = "fileTinyThumbnail", value = "文件小图")
   @JsonProperty("fileTinyThumbnail")
   @JSONField(name = "fileTinyThumbnail")
   @TableField(value = "file_tiny_thumbnail", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "file_tiny_thumbnail", columnDefinition = "varchar(255)  COMMENT '文件小图'")
   private String fileTinyThumbnail;
   @ApiModelProperty(name = "reason", value = "失败原因")
   @JsonProperty("reason")
   @JSONField(name = "reason")
   @TableField("reason")
   @Column(name = "reason", columnDefinition = "varchar(255)  COMMENT '失败原因'")
   private String reason;
   @ApiModelProperty(name = "createUserId", value = "操作人id")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '导入人id'")
   private Long createUserId;
   @ApiModelProperty(name = "modelType", value = "模型类型")
   @JsonProperty("modelType")
   @JSONField(name = "modelType")
   @TableField("model_type")
   @Column(name = "model_type", columnDefinition = "varchar(32)  default'file' COMMENT '模型类型'", nullable = false)
   private String modelType;
   @ApiModelProperty(name = "importMode", value = "导入模式")
   @JsonProperty("importMode")
   @JSONField(name = "importMode")
   @TableField("import_mode")
   @Column(name = "import_mode", columnDefinition = "int(2)  default'1' COMMENT '导入模式'", nullable = false)
   private Integer importMode;
   @ApiModelProperty(name = "success_quantity", value = "成功导入的次数")
   @JsonProperty("success_quantity")
   @JSONField(name = "success_quantity")
   @TableField("success_quantity")
   @Column(name = "success_quantity", columnDefinition = "bigint(20) default'0' COMMENT '成功导入的次数'", nullable = false)
   private Long successQuantity;
   @ApiModelProperty(name = "fileSize", value = "文件大小")
   @JsonProperty("fileSize")
   @JSONField(name = "fileSize")
   @TableField("file_size")
   @Column(name = "file_size", columnDefinition = "DECIMAL(20,4) COMMENT '文件大小'")
   private Double fileSize;
   @ApiModelProperty(name = "reportTime", value = "上报时间", notes = "上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   @TableField("report_time")
   @Column(name = "report_time", columnDefinition = "datetime(6)  COMMENT '上报时间'")
   private LocalDateTime reportTime;
   @ApiModelProperty(name = "boolRendering", value = "是否渲染过")
   @JsonProperty("boolRendering")
   @JSONField(name = "boolRendering")
   @TableField("bool_rendering")
   @Column(name = "bool_rendering", columnDefinition = "tinyint(1) default '0' COMMENT '是否渲染过'", nullable = false)
   private Boolean boolRendering;

   public static BimModelCommonDO.BimModelCommonDOBuilder builder() {
      return new BimModelCommonDO.BimModelCommonDOBuilder();
   }

   public BimModelCommonDO() {
   }

   public BimModelCommonDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long fileId,
      final Long originalFileId,
      final Long oldFileId,
      final Long attachmentId,
      final Integer edition,
      final String fileName,
      final String path,
      final String translateStatus,
      final String integrationStatus,
      final String fileThumbnail,
      final String fileTinyThumbnail,
      final String reason,
      final Long createUserId,
      final String modelType,
      final Integer importMode,
      final Long successQuantity,
      final Double fileSize,
      final LocalDateTime reportTime,
      final Boolean boolRendering
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.fileId = fileId;
      this.originalFileId = originalFileId;
      this.oldFileId = oldFileId;
      this.attachmentId = attachmentId;
      this.edition = edition;
      this.fileName = fileName;
      this.path = path;
      this.translateStatus = translateStatus;
      this.integrationStatus = integrationStatus;
      this.fileThumbnail = fileThumbnail;
      this.fileTinyThumbnail = fileTinyThumbnail;
      this.reason = reason;
      this.createUserId = createUserId;
      this.modelType = modelType;
      this.importMode = importMode;
      this.successQuantity = successQuantity;
      this.fileSize = fileSize;
      this.reportTime = reportTime;
      this.boolRendering = boolRendering;
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

   public Long getFileId() {
      return this.fileId;
   }

   public Long getOriginalFileId() {
      return this.originalFileId;
   }

   public Long getOldFileId() {
      return this.oldFileId;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Integer getEdition() {
      return this.edition;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getPath() {
      return this.path;
   }

   public String getTranslateStatus() {
      return this.translateStatus;
   }

   public String getIntegrationStatus() {
      return this.integrationStatus;
   }

   public String getFileThumbnail() {
      return this.fileThumbnail;
   }

   public String getFileTinyThumbnail() {
      return this.fileTinyThumbnail;
   }

   public String getReason() {
      return this.reason;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getModelType() {
      return this.modelType;
   }

   public Integer getImportMode() {
      return this.importMode;
   }

   public Long getSuccessQuantity() {
      return this.successQuantity;
   }

   public Double getFileSize() {
      return this.fileSize;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Boolean getBoolRendering() {
      return this.boolRendering;
   }

   @JsonProperty("id")
   public BimModelCommonDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public BimModelCommonDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public BimModelCommonDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public BimModelCommonDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("fileId")
   public BimModelCommonDO setFileId(final Long fileId) {
      this.fileId = fileId;
      return this;
   }

   @JsonProperty("originalFileId")
   public BimModelCommonDO setOriginalFileId(final Long originalFileId) {
      this.originalFileId = originalFileId;
      return this;
   }

   @JsonProperty("oldFileId")
   public BimModelCommonDO setOldFileId(final Long oldFileId) {
      this.oldFileId = oldFileId;
      return this;
   }

   @JsonProperty("attachmentId")
   public BimModelCommonDO setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   @JsonProperty("edition")
   public BimModelCommonDO setEdition(final Integer edition) {
      this.edition = edition;
      return this;
   }

   @JsonProperty("fileName")
   public BimModelCommonDO setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   @JsonProperty("path")
   public BimModelCommonDO setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("translateStatus")
   public BimModelCommonDO setTranslateStatus(final String translateStatus) {
      this.translateStatus = translateStatus;
      return this;
   }

   @JsonProperty("integrationStatus")
   public BimModelCommonDO setIntegrationStatus(final String integrationStatus) {
      this.integrationStatus = integrationStatus;
      return this;
   }

   @JsonProperty("fileThumbnail")
   public BimModelCommonDO setFileThumbnail(final String fileThumbnail) {
      this.fileThumbnail = fileThumbnail;
      return this;
   }

   @JsonProperty("fileTinyThumbnail")
   public BimModelCommonDO setFileTinyThumbnail(final String fileTinyThumbnail) {
      this.fileTinyThumbnail = fileTinyThumbnail;
      return this;
   }

   @JsonProperty("reason")
   public BimModelCommonDO setReason(final String reason) {
      this.reason = reason;
      return this;
   }

   @JsonProperty("createUserId")
   public BimModelCommonDO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   @JsonProperty("modelType")
   public BimModelCommonDO setModelType(final String modelType) {
      this.modelType = modelType;
      return this;
   }

   @JsonProperty("importMode")
   public BimModelCommonDO setImportMode(final Integer importMode) {
      this.importMode = importMode;
      return this;
   }

   @JsonProperty("success_quantity")
   public BimModelCommonDO setSuccessQuantity(final Long successQuantity) {
      this.successQuantity = successQuantity;
      return this;
   }

   @JsonProperty("fileSize")
   public BimModelCommonDO setFileSize(final Double fileSize) {
      this.fileSize = fileSize;
      return this;
   }

   @JsonProperty("reportTime")
   public BimModelCommonDO setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @JsonProperty("boolRendering")
   public BimModelCommonDO setBoolRendering(final Boolean boolRendering) {
      this.boolRendering = boolRendering;
      return this;
   }

   @Override
   public String toString() {
      return "BimModelCommonDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", fileId="
         + this.getFileId()
         + ", originalFileId="
         + this.getOriginalFileId()
         + ", oldFileId="
         + this.getOldFileId()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", edition="
         + this.getEdition()
         + ", fileName="
         + this.getFileName()
         + ", path="
         + this.getPath()
         + ", translateStatus="
         + this.getTranslateStatus()
         + ", integrationStatus="
         + this.getIntegrationStatus()
         + ", fileThumbnail="
         + this.getFileThumbnail()
         + ", fileTinyThumbnail="
         + this.getFileTinyThumbnail()
         + ", reason="
         + this.getReason()
         + ", createUserId="
         + this.getCreateUserId()
         + ", modelType="
         + this.getModelType()
         + ", importMode="
         + this.getImportMode()
         + ", successQuantity="
         + this.getSuccessQuantity()
         + ", fileSize="
         + this.getFileSize()
         + ", reportTime="
         + this.getReportTime()
         + ", boolRendering="
         + this.getBoolRendering()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelCommonDO)) {
         return false;
      }

      BimModelCommonDO other = (BimModelCommonDO)o;
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
                  Object this$fileId = this.getFileId();
                  Object other$fileId = other.getFileId();
                  if (this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId)) {
                     Object this$originalFileId = this.getOriginalFileId();
                     Object other$originalFileId = other.getOriginalFileId();
                     if (this$originalFileId == null ? other$originalFileId == null : this$originalFileId.equals(other$originalFileId)) {
                        Object this$oldFileId = this.getOldFileId();
                        Object other$oldFileId = other.getOldFileId();
                        if (this$oldFileId == null ? other$oldFileId == null : this$oldFileId.equals(other$oldFileId)) {
                           Object this$attachmentId = this.getAttachmentId();
                           Object other$attachmentId = other.getAttachmentId();
                           if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                              Object this$edition = this.getEdition();
                              Object other$edition = other.getEdition();
                              if (this$edition == null ? other$edition == null : this$edition.equals(other$edition)) {
                                 Object this$createUserId = this.getCreateUserId();
                                 Object other$createUserId = other.getCreateUserId();
                                 if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                    Object this$importMode = this.getImportMode();
                                    Object other$importMode = other.getImportMode();
                                    if (this$importMode == null ? other$importMode == null : this$importMode.equals(other$importMode)) {
                                       Object this$successQuantity = this.getSuccessQuantity();
                                       Object other$successQuantity = other.getSuccessQuantity();
                                       if (this$successQuantity == null ? other$successQuantity == null : this$successQuantity.equals(other$successQuantity)) {
                                          Object this$fileSize = this.getFileSize();
                                          Object other$fileSize = other.getFileSize();
                                          if (this$fileSize == null ? other$fileSize == null : this$fileSize.equals(other$fileSize)) {
                                             Object this$boolRendering = this.getBoolRendering();
                                             Object other$boolRendering = other.getBoolRendering();
                                             if (this$boolRendering == null ? other$boolRendering == null : this$boolRendering.equals(other$boolRendering)) {
                                                Object this$fileName = this.getFileName();
                                                Object other$fileName = other.getFileName();
                                                if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                                   Object this$path = this.getPath();
                                                   Object other$path = other.getPath();
                                                   if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                                      Object this$translateStatus = this.getTranslateStatus();
                                                      Object other$translateStatus = other.getTranslateStatus();
                                                      if (this$translateStatus == null
                                                         ? other$translateStatus == null
                                                         : this$translateStatus.equals(other$translateStatus)) {
                                                         Object this$integrationStatus = this.getIntegrationStatus();
                                                         Object other$integrationStatus = other.getIntegrationStatus();
                                                         if (this$integrationStatus == null
                                                            ? other$integrationStatus == null
                                                            : this$integrationStatus.equals(other$integrationStatus)) {
                                                            Object this$fileThumbnail = this.getFileThumbnail();
                                                            Object other$fileThumbnail = other.getFileThumbnail();
                                                            if (this$fileThumbnail == null
                                                               ? other$fileThumbnail == null
                                                               : this$fileThumbnail.equals(other$fileThumbnail)) {
                                                               Object this$fileTinyThumbnail = this.getFileTinyThumbnail();
                                                               Object other$fileTinyThumbnail = other.getFileTinyThumbnail();
                                                               if (this$fileTinyThumbnail == null
                                                                  ? other$fileTinyThumbnail == null
                                                                  : this$fileTinyThumbnail.equals(other$fileTinyThumbnail)) {
                                                                  Object this$reason = this.getReason();
                                                                  Object other$reason = other.getReason();
                                                                  if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                                                                     Object this$modelType = this.getModelType();
                                                                     Object other$modelType = other.getModelType();
                                                                     if (this$modelType == null
                                                                        ? other$modelType == null
                                                                        : this$modelType.equals(other$modelType)) {
                                                                        Object this$reportTime = this.getReportTime();
                                                                        Object other$reportTime = other.getReportTime();
                                                                        return this$reportTime == null
                                                                           ? other$reportTime == null
                                                                           : this$reportTime.equals(other$reportTime);
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
      return other instanceof BimModelCommonDO;
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
      Object $fileId = this.getFileId();
      result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
      Object $originalFileId = this.getOriginalFileId();
      result = result * 59 + ($originalFileId == null ? 43 : $originalFileId.hashCode());
      Object $oldFileId = this.getOldFileId();
      result = result * 59 + ($oldFileId == null ? 43 : $oldFileId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $edition = this.getEdition();
      result = result * 59 + ($edition == null ? 43 : $edition.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $importMode = this.getImportMode();
      result = result * 59 + ($importMode == null ? 43 : $importMode.hashCode());
      Object $successQuantity = this.getSuccessQuantity();
      result = result * 59 + ($successQuantity == null ? 43 : $successQuantity.hashCode());
      Object $fileSize = this.getFileSize();
      result = result * 59 + ($fileSize == null ? 43 : $fileSize.hashCode());
      Object $boolRendering = this.getBoolRendering();
      result = result * 59 + ($boolRendering == null ? 43 : $boolRendering.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $translateStatus = this.getTranslateStatus();
      result = result * 59 + ($translateStatus == null ? 43 : $translateStatus.hashCode());
      Object $integrationStatus = this.getIntegrationStatus();
      result = result * 59 + ($integrationStatus == null ? 43 : $integrationStatus.hashCode());
      Object $fileThumbnail = this.getFileThumbnail();
      result = result * 59 + ($fileThumbnail == null ? 43 : $fileThumbnail.hashCode());
      Object $fileTinyThumbnail = this.getFileTinyThumbnail();
      result = result * 59 + ($fileTinyThumbnail == null ? 43 : $fileTinyThumbnail.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $modelType = this.getModelType();
      result = result * 59 + ($modelType == null ? 43 : $modelType.hashCode());
      Object $reportTime = this.getReportTime();
      return result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
   }

   public static class BimModelCommonDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long fileId;
      private Long originalFileId;
      private Long oldFileId;
      private Long attachmentId;
      private Integer edition;
      private String fileName;
      private String path;
      private String translateStatus;
      private String integrationStatus;
      private String fileThumbnail;
      private String fileTinyThumbnail;
      private String reason;
      private Long createUserId;
      private String modelType;
      private Integer importMode;
      private Long successQuantity;
      private Double fileSize;
      private LocalDateTime reportTime;
      private Boolean boolRendering;

      BimModelCommonDOBuilder() {
      }

      @JsonProperty("id")
      public BimModelCommonDO.BimModelCommonDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public BimModelCommonDO.BimModelCommonDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public BimModelCommonDO.BimModelCommonDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public BimModelCommonDO.BimModelCommonDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("fileId")
      public BimModelCommonDO.BimModelCommonDOBuilder fileId(final Long fileId) {
         this.fileId = fileId;
         return this;
      }

      @JsonProperty("originalFileId")
      public BimModelCommonDO.BimModelCommonDOBuilder originalFileId(final Long originalFileId) {
         this.originalFileId = originalFileId;
         return this;
      }

      @JsonProperty("oldFileId")
      public BimModelCommonDO.BimModelCommonDOBuilder oldFileId(final Long oldFileId) {
         this.oldFileId = oldFileId;
         return this;
      }

      @JsonProperty("attachmentId")
      public BimModelCommonDO.BimModelCommonDOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      @JsonProperty("edition")
      public BimModelCommonDO.BimModelCommonDOBuilder edition(final Integer edition) {
         this.edition = edition;
         return this;
      }

      @JsonProperty("fileName")
      public BimModelCommonDO.BimModelCommonDOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      @JsonProperty("path")
      public BimModelCommonDO.BimModelCommonDOBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("translateStatus")
      public BimModelCommonDO.BimModelCommonDOBuilder translateStatus(final String translateStatus) {
         this.translateStatus = translateStatus;
         return this;
      }

      @JsonProperty("integrationStatus")
      public BimModelCommonDO.BimModelCommonDOBuilder integrationStatus(final String integrationStatus) {
         this.integrationStatus = integrationStatus;
         return this;
      }

      @JsonProperty("fileThumbnail")
      public BimModelCommonDO.BimModelCommonDOBuilder fileThumbnail(final String fileThumbnail) {
         this.fileThumbnail = fileThumbnail;
         return this;
      }

      @JsonProperty("fileTinyThumbnail")
      public BimModelCommonDO.BimModelCommonDOBuilder fileTinyThumbnail(final String fileTinyThumbnail) {
         this.fileTinyThumbnail = fileTinyThumbnail;
         return this;
      }

      @JsonProperty("reason")
      public BimModelCommonDO.BimModelCommonDOBuilder reason(final String reason) {
         this.reason = reason;
         return this;
      }

      @JsonProperty("createUserId")
      public BimModelCommonDO.BimModelCommonDOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      @JsonProperty("modelType")
      public BimModelCommonDO.BimModelCommonDOBuilder modelType(final String modelType) {
         this.modelType = modelType;
         return this;
      }

      @JsonProperty("importMode")
      public BimModelCommonDO.BimModelCommonDOBuilder importMode(final Integer importMode) {
         this.importMode = importMode;
         return this;
      }

      @JsonProperty("success_quantity")
      public BimModelCommonDO.BimModelCommonDOBuilder successQuantity(final Long successQuantity) {
         this.successQuantity = successQuantity;
         return this;
      }

      @JsonProperty("fileSize")
      public BimModelCommonDO.BimModelCommonDOBuilder fileSize(final Double fileSize) {
         this.fileSize = fileSize;
         return this;
      }

      @JsonProperty("reportTime")
      public BimModelCommonDO.BimModelCommonDOBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      @JsonProperty("boolRendering")
      public BimModelCommonDO.BimModelCommonDOBuilder boolRendering(final Boolean boolRendering) {
         this.boolRendering = boolRendering;
         return this;
      }

      public BimModelCommonDO build() {
         return new BimModelCommonDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.fileId,
            this.originalFileId,
            this.oldFileId,
            this.attachmentId,
            this.edition,
            this.fileName,
            this.path,
            this.translateStatus,
            this.integrationStatus,
            this.fileThumbnail,
            this.fileTinyThumbnail,
            this.reason,
            this.createUserId,
            this.modelType,
            this.importMode,
            this.successQuantity,
            this.fileSize,
            this.reportTime,
            this.boolRendering
         );
      }

      @Override
      public String toString() {
         return "BimModelCommonDO.BimModelCommonDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", fileId="
            + this.fileId
            + ", originalFileId="
            + this.originalFileId
            + ", oldFileId="
            + this.oldFileId
            + ", attachmentId="
            + this.attachmentId
            + ", edition="
            + this.edition
            + ", fileName="
            + this.fileName
            + ", path="
            + this.path
            + ", translateStatus="
            + this.translateStatus
            + ", integrationStatus="
            + this.integrationStatus
            + ", fileThumbnail="
            + this.fileThumbnail
            + ", fileTinyThumbnail="
            + this.fileTinyThumbnail
            + ", reason="
            + this.reason
            + ", createUserId="
            + this.createUserId
            + ", modelType="
            + this.modelType
            + ", importMode="
            + this.importMode
            + ", successQuantity="
            + this.successQuantity
            + ", fileSize="
            + this.fileSize
            + ", reportTime="
            + this.reportTime
            + ", boolRendering="
            + this.boolRendering
            + ")";
      }
   }
}
