package com.hzchum.scim.bim.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("bim模型返回类VO")
public class BimModelCommonResponseVO {
   @ApiModelProperty(name = "id", value = "BimModelDO主键id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "fileId", value = "bim文件id")
   private Long fileId;
   @ApiModelProperty(name = "fileId", value = "bim文件名称")
   private String fileName;
   @ApiModelProperty(name = "translateStatus", value = "上传状态")
   private String translateStatus;
   @ApiModelProperty(name = "fileThumbnail", value = "文件缩略图")
   private String fileThumbnail;
   @ApiModelProperty(name = "fileTinyThumbnail", value = "文件小图")
   private String fileTinyThumbnail;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "updateTime", value = "更新时间")
   private LocalDateTime updateTime;
   @ApiModelProperty(name = "createUserName", value = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "edition", value = "Tekla版本")
   private Integer edition;
   @ApiModelProperty(name = "integrationStatus", value = "模型集成状态")
   private String integrationStatus;
   @ApiModelProperty(name = "modelType", value = "模型类型")
   private String modelType;
   @ApiModelProperty(name = "importMode", value = "导入模式")
   private Integer importMode;
   @ApiModelProperty(name = "SuccessQuantity", value = "成功次数")
   private Integer SuccessQuantity;
   @ApiModelProperty(name = "fileSize", value = "bim文件大小")
   private Integer fileSize;

   public static BimModelCommonResponseVO.BimModelCommonResponseVOBuilder builder() {
      return new BimModelCommonResponseVO.BimModelCommonResponseVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Long getFileId() {
      return this.fileId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getTranslateStatus() {
      return this.translateStatus;
   }

   public String getFileThumbnail() {
      return this.fileThumbnail;
   }

   public String getFileTinyThumbnail() {
      return this.fileTinyThumbnail;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getEdition() {
      return this.edition;
   }

   public String getIntegrationStatus() {
      return this.integrationStatus;
   }

   public String getModelType() {
      return this.modelType;
   }

   public Integer getImportMode() {
      return this.importMode;
   }

   public Integer getSuccessQuantity() {
      return this.SuccessQuantity;
   }

   public Integer getFileSize() {
      return this.fileSize;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setFileId(final Long fileId) {
      this.fileId = fileId;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setTranslateStatus(final String translateStatus) {
      this.translateStatus = translateStatus;
   }

   public void setFileThumbnail(final String fileThumbnail) {
      this.fileThumbnail = fileThumbnail;
   }

   public void setFileTinyThumbnail(final String fileTinyThumbnail) {
      this.fileTinyThumbnail = fileTinyThumbnail;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setEdition(final Integer edition) {
      this.edition = edition;
   }

   public void setIntegrationStatus(final String integrationStatus) {
      this.integrationStatus = integrationStatus;
   }

   public void setModelType(final String modelType) {
      this.modelType = modelType;
   }

   public void setImportMode(final Integer importMode) {
      this.importMode = importMode;
   }

   public void setSuccessQuantity(final Integer SuccessQuantity) {
      this.SuccessQuantity = SuccessQuantity;
   }

   public void setFileSize(final Integer fileSize) {
      this.fileSize = fileSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimModelCommonResponseVO)) {
         return false;
      }

      BimModelCommonResponseVO other = (BimModelCommonResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$fileId = this.getFileId();
         Object other$fileId = other.getFileId();
         if (this$fileId == null ? other$fileId == null : this$fileId.equals(other$fileId)) {
            Object this$edition = this.getEdition();
            Object other$edition = other.getEdition();
            if (this$edition == null ? other$edition == null : this$edition.equals(other$edition)) {
               Object this$importMode = this.getImportMode();
               Object other$importMode = other.getImportMode();
               if (this$importMode == null ? other$importMode == null : this$importMode.equals(other$importMode)) {
                  Object this$SuccessQuantity = this.getSuccessQuantity();
                  Object other$SuccessQuantity = other.getSuccessQuantity();
                  if (this$SuccessQuantity == null ? other$SuccessQuantity == null : this$SuccessQuantity.equals(other$SuccessQuantity)) {
                     Object this$fileSize = this.getFileSize();
                     Object other$fileSize = other.getFileSize();
                     if (this$fileSize == null ? other$fileSize == null : this$fileSize.equals(other$fileSize)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                 Object this$fileName = this.getFileName();
                                 Object other$fileName = other.getFileName();
                                 if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                    Object this$translateStatus = this.getTranslateStatus();
                                    Object other$translateStatus = other.getTranslateStatus();
                                    if (this$translateStatus == null ? other$translateStatus == null : this$translateStatus.equals(other$translateStatus)) {
                                       Object this$fileThumbnail = this.getFileThumbnail();
                                       Object other$fileThumbnail = other.getFileThumbnail();
                                       if (this$fileThumbnail == null ? other$fileThumbnail == null : this$fileThumbnail.equals(other$fileThumbnail)) {
                                          Object this$fileTinyThumbnail = this.getFileTinyThumbnail();
                                          Object other$fileTinyThumbnail = other.getFileTinyThumbnail();
                                          if (this$fileTinyThumbnail == null
                                             ? other$fileTinyThumbnail == null
                                             : this$fileTinyThumbnail.equals(other$fileTinyThumbnail)) {
                                             Object this$createTime = this.getCreateTime();
                                             Object other$createTime = other.getCreateTime();
                                             if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                Object this$updateTime = this.getUpdateTime();
                                                Object other$updateTime = other.getUpdateTime();
                                                if (this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime)) {
                                                   Object this$createUserName = this.getCreateUserName();
                                                   Object other$createUserName = other.getCreateUserName();
                                                   if (this$createUserName == null
                                                      ? other$createUserName == null
                                                      : this$createUserName.equals(other$createUserName)) {
                                                      Object this$integrationStatus = this.getIntegrationStatus();
                                                      Object other$integrationStatus = other.getIntegrationStatus();
                                                      if (this$integrationStatus == null
                                                         ? other$integrationStatus == null
                                                         : this$integrationStatus.equals(other$integrationStatus)) {
                                                         Object this$modelType = this.getModelType();
                                                         Object other$modelType = other.getModelType();
                                                         return this$modelType == null ? other$modelType == null : this$modelType.equals(other$modelType);
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

   protected boolean canEqual(final Object other) {
      return other instanceof BimModelCommonResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $fileId = this.getFileId();
      result = result * 59 + ($fileId == null ? 43 : $fileId.hashCode());
      Object $edition = this.getEdition();
      result = result * 59 + ($edition == null ? 43 : $edition.hashCode());
      Object $importMode = this.getImportMode();
      result = result * 59 + ($importMode == null ? 43 : $importMode.hashCode());
      Object $SuccessQuantity = this.getSuccessQuantity();
      result = result * 59 + ($SuccessQuantity == null ? 43 : $SuccessQuantity.hashCode());
      Object $fileSize = this.getFileSize();
      result = result * 59 + ($fileSize == null ? 43 : $fileSize.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $translateStatus = this.getTranslateStatus();
      result = result * 59 + ($translateStatus == null ? 43 : $translateStatus.hashCode());
      Object $fileThumbnail = this.getFileThumbnail();
      result = result * 59 + ($fileThumbnail == null ? 43 : $fileThumbnail.hashCode());
      Object $fileTinyThumbnail = this.getFileTinyThumbnail();
      result = result * 59 + ($fileTinyThumbnail == null ? 43 : $fileTinyThumbnail.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      result = result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $integrationStatus = this.getIntegrationStatus();
      result = result * 59 + ($integrationStatus == null ? 43 : $integrationStatus.hashCode());
      Object $modelType = this.getModelType();
      return result * 59 + ($modelType == null ? 43 : $modelType.hashCode());
   }

   @Override
   public String toString() {
      return "BimModelCommonResponseVO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", fileId="
         + this.getFileId()
         + ", fileName="
         + this.getFileName()
         + ", translateStatus="
         + this.getTranslateStatus()
         + ", fileThumbnail="
         + this.getFileThumbnail()
         + ", fileTinyThumbnail="
         + this.getFileTinyThumbnail()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", createUserName="
         + this.getCreateUserName()
         + ", edition="
         + this.getEdition()
         + ", integrationStatus="
         + this.getIntegrationStatus()
         + ", modelType="
         + this.getModelType()
         + ", importMode="
         + this.getImportMode()
         + ", SuccessQuantity="
         + this.getSuccessQuantity()
         + ", fileSize="
         + this.getFileSize()
         + ")";
   }

   public BimModelCommonResponseVO(
      final Long id,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Long fileId,
      final String fileName,
      final String translateStatus,
      final String fileThumbnail,
      final String fileTinyThumbnail,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final String createUserName,
      final Integer edition,
      final String integrationStatus,
      final String modelType,
      final Integer importMode,
      final Integer SuccessQuantity,
      final Integer fileSize
   ) {
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.fileId = fileId;
      this.fileName = fileName;
      this.translateStatus = translateStatus;
      this.fileThumbnail = fileThumbnail;
      this.fileTinyThumbnail = fileTinyThumbnail;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.createUserName = createUserName;
      this.edition = edition;
      this.integrationStatus = integrationStatus;
      this.modelType = modelType;
      this.importMode = importMode;
      this.SuccessQuantity = SuccessQuantity;
      this.fileSize = fileSize;
   }

   public BimModelCommonResponseVO() {
   }

   public static class BimModelCommonResponseVOBuilder {
      private Long id;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Long fileId;
      private String fileName;
      private String translateStatus;
      private String fileThumbnail;
      private String fileTinyThumbnail;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private String createUserName;
      private Integer edition;
      private String integrationStatus;
      private String modelType;
      private Integer importMode;
      private Integer SuccessQuantity;
      private Integer fileSize;

      BimModelCommonResponseVOBuilder() {
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder fileId(final Long fileId) {
         this.fileId = fileId;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder translateStatus(final String translateStatus) {
         this.translateStatus = translateStatus;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder fileThumbnail(final String fileThumbnail) {
         this.fileThumbnail = fileThumbnail;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder fileTinyThumbnail(final String fileTinyThumbnail) {
         this.fileTinyThumbnail = fileTinyThumbnail;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder edition(final Integer edition) {
         this.edition = edition;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder integrationStatus(final String integrationStatus) {
         this.integrationStatus = integrationStatus;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder modelType(final String modelType) {
         this.modelType = modelType;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder importMode(final Integer importMode) {
         this.importMode = importMode;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder SuccessQuantity(final Integer SuccessQuantity) {
         this.SuccessQuantity = SuccessQuantity;
         return this;
      }

      public BimModelCommonResponseVO.BimModelCommonResponseVOBuilder fileSize(final Integer fileSize) {
         this.fileSize = fileSize;
         return this;
      }

      public BimModelCommonResponseVO build() {
         return new BimModelCommonResponseVO(
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.fileId,
            this.fileName,
            this.translateStatus,
            this.fileThumbnail,
            this.fileTinyThumbnail,
            this.createTime,
            this.updateTime,
            this.createUserName,
            this.edition,
            this.integrationStatus,
            this.modelType,
            this.importMode,
            this.SuccessQuantity,
            this.fileSize
         );
      }

      @Override
      public String toString() {
         return "BimModelCommonResponseVO.BimModelCommonResponseVOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", fileId="
            + this.fileId
            + ", fileName="
            + this.fileName
            + ", translateStatus="
            + this.translateStatus
            + ", fileThumbnail="
            + this.fileThumbnail
            + ", fileTinyThumbnail="
            + this.fileTinyThumbnail
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", createUserName="
            + this.createUserName
            + ", edition="
            + this.edition
            + ", integrationStatus="
            + this.integrationStatus
            + ", modelType="
            + this.modelType
            + ", importMode="
            + this.importMode
            + ", SuccessQuantity="
            + this.SuccessQuantity
            + ", fileSize="
            + this.fileSize
            + ")";
      }
   }
}
