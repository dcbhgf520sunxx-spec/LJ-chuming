package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("技术资料列表")
public class DrawingDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "serialNumber", value = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "构件产品序列号")
   private Integer number;
   @ApiModelProperty(name = "number", value = "构件产品图号")
   private String dwgNum;
   @ApiModelProperty(name = "dataType", value = "资料类型 1深化图 2零件图 4变更文件 8施工蓝图")
   private String dataType;
   @ApiModelProperty(name = "productType", value = "产品类型【1零件, 2构件，16组立】")
   private Integer productType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   private String fileName;
   @ApiModelProperty(name = "filePath", value = "文件路径")
   private String filePath;
   @ApiModelProperty(name = "filePath", value = "服务端绝对路径")
   private String absolutePath;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "filePath", value = "零件dxf图云路径")
   private String cloudPath;
   @ApiModelProperty(name = "translateStatus", value = "文件上传状态 参考枚举 BimStatusEnum")
   private String translateStatus;
   @ApiModelProperty(name = "createUserId", value = "上传人id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "上传人")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "导入时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "updateTime", value = "修改时间")
   private LocalDateTime updateTime;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getDwgNum() {
      return this.dwgNum;
   }

   public String getDataType() {
      return this.dataType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public String getAbsolutePath() {
      return this.absolutePath;
   }

   public String getCloudPath() {
      return this.cloudPath;
   }

   public String getTranslateStatus() {
      return this.translateStatus;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setDwgNum(final String dwgNum) {
      this.dwgNum = dwgNum;
   }

   public void setDataType(final String dataType) {
      this.dataType = dataType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setAbsolutePath(final String absolutePath) {
      this.absolutePath = absolutePath;
   }

   public void setCloudPath(final String cloudPath) {
      this.cloudPath = cloudPath;
   }

   public void setTranslateStatus(final String translateStatus) {
      this.translateStatus = translateStatus;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DrawingDTO)) {
         return false;
      }

      DrawingDTO other = (DrawingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$dwgNum = this.getDwgNum();
                           Object other$dwgNum = other.getDwgNum();
                           if (this$dwgNum == null ? other$dwgNum == null : this$dwgNum.equals(other$dwgNum)) {
                              Object this$dataType = this.getDataType();
                              Object other$dataType = other.getDataType();
                              if (this$dataType == null ? other$dataType == null : this$dataType.equals(other$dataType)) {
                                 Object this$fileName = this.getFileName();
                                 Object other$fileName = other.getFileName();
                                 if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                    Object this$filePath = this.getFilePath();
                                    Object other$filePath = other.getFilePath();
                                    if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                                       Object this$absolutePath = this.getAbsolutePath();
                                       Object other$absolutePath = other.getAbsolutePath();
                                       if (this$absolutePath == null ? other$absolutePath == null : this$absolutePath.equals(other$absolutePath)) {
                                          Object this$cloudPath = this.getCloudPath();
                                          Object other$cloudPath = other.getCloudPath();
                                          if (this$cloudPath == null ? other$cloudPath == null : this$cloudPath.equals(other$cloudPath)) {
                                             Object this$translateStatus = this.getTranslateStatus();
                                             Object other$translateStatus = other.getTranslateStatus();
                                             if (this$translateStatus == null
                                                ? other$translateStatus == null
                                                : this$translateStatus.equals(other$translateStatus)) {
                                                Object this$createUserName = this.getCreateUserName();
                                                Object other$createUserName = other.getCreateUserName();
                                                if (this$createUserName == null
                                                   ? other$createUserName == null
                                                   : this$createUserName.equals(other$createUserName)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$updateTime = this.getUpdateTime();
                                                      Object other$updateTime = other.getUpdateTime();
                                                      return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof DrawingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $dwgNum = this.getDwgNum();
      result = result * 59 + ($dwgNum == null ? 43 : $dwgNum.hashCode());
      Object $dataType = this.getDataType();
      result = result * 59 + ($dataType == null ? 43 : $dataType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $absolutePath = this.getAbsolutePath();
      result = result * 59 + ($absolutePath == null ? 43 : $absolutePath.hashCode());
      Object $cloudPath = this.getCloudPath();
      result = result * 59 + ($cloudPath == null ? 43 : $cloudPath.hashCode());
      Object $translateStatus = this.getTranslateStatus();
      result = result * 59 + ($translateStatus == null ? 43 : $translateStatus.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "DrawingDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", number="
         + this.getNumber()
         + ", dwgNum="
         + this.getDwgNum()
         + ", dataType="
         + this.getDataType()
         + ", productType="
         + this.getProductType()
         + ", fileName="
         + this.getFileName()
         + ", filePath="
         + this.getFilePath()
         + ", absolutePath="
         + this.getAbsolutePath()
         + ", cloudPath="
         + this.getCloudPath()
         + ", translateStatus="
         + this.getTranslateStatus()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }
}
