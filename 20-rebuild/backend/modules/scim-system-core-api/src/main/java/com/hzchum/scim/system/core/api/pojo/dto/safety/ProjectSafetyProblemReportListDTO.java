package com.hzchum.scim.system.core.api.pojo.dto.safety;

import cn.afterturn.easypoi.entity.ImageEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "ProjectSafetyProblemReportListDTO", description = "治安报表列表源数据")
public class ProjectSafetyProblemReportListDTO {
   @ApiModelProperty(name = "id", value = "问题id")
   private Long id;
   @ApiModelProperty(name = "projectName", value = "项目名")
   private String projectName;
   @ApiModelProperty(name = "supplierName", value = "供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "qualityOrSafetyEnum", value = "问题类型")
   private Integer qualityOrSafetyEnum;
   @ApiModelProperty(name = "createTime", value = "发起时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "siteName", value = "问题名称")
   private String siteName;
   @ApiModelProperty(name = "remark", value = "问题描述")
   private String remark;
   @ApiModelProperty(name = "beforeAttachment", value = "整改前图片")
   private List<AttachmentDTO> beforeAttachment;
   @ApiModelProperty(name = "dutyName", value = "责任人")
   private String dutyName;
   @ApiModelProperty(name = "promoterName", notes = "发起人名称")
   private String promoterName;
   @ApiModelProperty(name = "afterAttachment", value = "整改后图片")
   private List<AttachmentDTO> afterAttachment;
   @ApiModelProperty(name = "problemStatus", value = "问题状态")
   private Integer problemStatus;
   @ApiModelProperty(name = "afterAttachment", value = "整改前图片", notes = "用于map版导出图片")
   private ImageEntity beforeImage1;
   @ApiModelProperty(name = "afterAttachment", value = "整改前图片", notes = "用于map版导出图片")
   private ImageEntity beforeImage2;
   @ApiModelProperty(name = "afterAttachment", value = "整改前图片", notes = "用于map版导出图片")
   private ImageEntity beforeImage3;
   @ApiModelProperty(name = "afterAttachment", value = "整改后图片", notes = "用于map版导出图片")
   private ImageEntity afterImage1;
   @ApiModelProperty(name = "afterAttachment", value = "整改后图片", notes = "用于map版导出图片")
   private ImageEntity afterImage2;
   @ApiModelProperty(name = "afterAttachment", value = "整改后图片", notes = "用于map版导出图片")
   private ImageEntity afterImage3;

   public static ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder builder() {
      return new ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder();
   }

   public ProjectSafetyProblemReportListDTO() {
   }

   public ProjectSafetyProblemReportListDTO(
      final Long id,
      final String projectName,
      final String supplierName,
      final Integer qualityOrSafetyEnum,
      final LocalDateTime createTime,
      final String siteName,
      final String remark,
      final List<AttachmentDTO> beforeAttachment,
      final String dutyName,
      final String promoterName,
      final List<AttachmentDTO> afterAttachment,
      final Integer problemStatus,
      final ImageEntity beforeImage1,
      final ImageEntity beforeImage2,
      final ImageEntity beforeImage3,
      final ImageEntity afterImage1,
      final ImageEntity afterImage2,
      final ImageEntity afterImage3
   ) {
      this.id = id;
      this.projectName = projectName;
      this.supplierName = supplierName;
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
      this.createTime = createTime;
      this.siteName = siteName;
      this.remark = remark;
      this.beforeAttachment = beforeAttachment;
      this.dutyName = dutyName;
      this.promoterName = promoterName;
      this.afterAttachment = afterAttachment;
      this.problemStatus = problemStatus;
      this.beforeImage1 = beforeImage1;
      this.beforeImage2 = beforeImage2;
      this.beforeImage3 = beforeImage3;
      this.afterImage1 = afterImage1;
      this.afterImage2 = afterImage2;
      this.afterImage3 = afterImage3;
   }

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getQualityOrSafetyEnum() {
      return this.qualityOrSafetyEnum;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSiteName() {
      return this.siteName;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<AttachmentDTO> getBeforeAttachment() {
      return this.beforeAttachment;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public String getPromoterName() {
      return this.promoterName;
   }

   public List<AttachmentDTO> getAfterAttachment() {
      return this.afterAttachment;
   }

   public Integer getProblemStatus() {
      return this.problemStatus;
   }

   public ImageEntity getBeforeImage1() {
      return this.beforeImage1;
   }

   public ImageEntity getBeforeImage2() {
      return this.beforeImage2;
   }

   public ImageEntity getBeforeImage3() {
      return this.beforeImage3;
   }

   public ImageEntity getAfterImage1() {
      return this.afterImage1;
   }

   public ImageEntity getAfterImage2() {
      return this.afterImage2;
   }

   public ImageEntity getAfterImage3() {
      return this.afterImage3;
   }

   public ProjectSafetyProblemReportListDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setQualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setSiteName(final String siteName) {
      this.siteName = siteName;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setBeforeAttachment(final List<AttachmentDTO> beforeAttachment) {
      this.beforeAttachment = beforeAttachment;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setPromoterName(final String promoterName) {
      this.promoterName = promoterName;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setAfterAttachment(final List<AttachmentDTO> afterAttachment) {
      this.afterAttachment = afterAttachment;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setProblemStatus(final Integer problemStatus) {
      this.problemStatus = problemStatus;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setBeforeImage1(final ImageEntity beforeImage1) {
      this.beforeImage1 = beforeImage1;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setBeforeImage2(final ImageEntity beforeImage2) {
      this.beforeImage2 = beforeImage2;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setBeforeImage3(final ImageEntity beforeImage3) {
      this.beforeImage3 = beforeImage3;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setAfterImage1(final ImageEntity afterImage1) {
      this.afterImage1 = afterImage1;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setAfterImage2(final ImageEntity afterImage2) {
      this.afterImage2 = afterImage2;
      return this;
   }

   public ProjectSafetyProblemReportListDTO setAfterImage3(final ImageEntity afterImage3) {
      this.afterImage3 = afterImage3;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemReportListDTO)) {
         return false;
      }

      ProjectSafetyProblemReportListDTO other = (ProjectSafetyProblemReportListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
         Object other$qualityOrSafetyEnum = other.getQualityOrSafetyEnum();
         if (this$qualityOrSafetyEnum == null ? other$qualityOrSafetyEnum == null : this$qualityOrSafetyEnum.equals(other$qualityOrSafetyEnum)) {
            Object this$problemStatus = this.getProblemStatus();
            Object other$problemStatus = other.getProblemStatus();
            if (this$problemStatus == null ? other$problemStatus == null : this$problemStatus.equals(other$problemStatus)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$siteName = this.getSiteName();
                        Object other$siteName = other.getSiteName();
                        if (this$siteName == null ? other$siteName == null : this$siteName.equals(other$siteName)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$beforeAttachment = this.getBeforeAttachment();
                              Object other$beforeAttachment = other.getBeforeAttachment();
                              if (this$beforeAttachment == null ? other$beforeAttachment == null : this$beforeAttachment.equals(other$beforeAttachment)) {
                                 Object this$dutyName = this.getDutyName();
                                 Object other$dutyName = other.getDutyName();
                                 if (this$dutyName == null ? other$dutyName == null : this$dutyName.equals(other$dutyName)) {
                                    Object this$promoterName = this.getPromoterName();
                                    Object other$promoterName = other.getPromoterName();
                                    if (this$promoterName == null ? other$promoterName == null : this$promoterName.equals(other$promoterName)) {
                                       Object this$afterAttachment = this.getAfterAttachment();
                                       Object other$afterAttachment = other.getAfterAttachment();
                                       if (this$afterAttachment == null ? other$afterAttachment == null : this$afterAttachment.equals(other$afterAttachment)) {
                                          Object this$beforeImage1 = this.getBeforeImage1();
                                          Object other$beforeImage1 = other.getBeforeImage1();
                                          if (this$beforeImage1 == null ? other$beforeImage1 == null : this$beforeImage1.equals(other$beforeImage1)) {
                                             Object this$beforeImage2 = this.getBeforeImage2();
                                             Object other$beforeImage2 = other.getBeforeImage2();
                                             if (this$beforeImage2 == null ? other$beforeImage2 == null : this$beforeImage2.equals(other$beforeImage2)) {
                                                Object this$beforeImage3 = this.getBeforeImage3();
                                                Object other$beforeImage3 = other.getBeforeImage3();
                                                if (this$beforeImage3 == null ? other$beforeImage3 == null : this$beforeImage3.equals(other$beforeImage3)) {
                                                   Object this$afterImage1 = this.getAfterImage1();
                                                   Object other$afterImage1 = other.getAfterImage1();
                                                   if (this$afterImage1 == null ? other$afterImage1 == null : this$afterImage1.equals(other$afterImage1)) {
                                                      Object this$afterImage2 = this.getAfterImage2();
                                                      Object other$afterImage2 = other.getAfterImage2();
                                                      if (this$afterImage2 == null ? other$afterImage2 == null : this$afterImage2.equals(other$afterImage2)) {
                                                         Object this$afterImage3 = this.getAfterImage3();
                                                         Object other$afterImage3 = other.getAfterImage3();
                                                         return this$afterImage3 == null
                                                            ? other$afterImage3 == null
                                                            : this$afterImage3.equals(other$afterImage3);
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
      return other instanceof ProjectSafetyProblemReportListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
      result = result * 59 + ($qualityOrSafetyEnum == null ? 43 : $qualityOrSafetyEnum.hashCode());
      Object $problemStatus = this.getProblemStatus();
      result = result * 59 + ($problemStatus == null ? 43 : $problemStatus.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $siteName = this.getSiteName();
      result = result * 59 + ($siteName == null ? 43 : $siteName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $beforeAttachment = this.getBeforeAttachment();
      result = result * 59 + ($beforeAttachment == null ? 43 : $beforeAttachment.hashCode());
      Object $dutyName = this.getDutyName();
      result = result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
      Object $promoterName = this.getPromoterName();
      result = result * 59 + ($promoterName == null ? 43 : $promoterName.hashCode());
      Object $afterAttachment = this.getAfterAttachment();
      result = result * 59 + ($afterAttachment == null ? 43 : $afterAttachment.hashCode());
      Object $beforeImage1 = this.getBeforeImage1();
      result = result * 59 + ($beforeImage1 == null ? 43 : $beforeImage1.hashCode());
      Object $beforeImage2 = this.getBeforeImage2();
      result = result * 59 + ($beforeImage2 == null ? 43 : $beforeImage2.hashCode());
      Object $beforeImage3 = this.getBeforeImage3();
      result = result * 59 + ($beforeImage3 == null ? 43 : $beforeImage3.hashCode());
      Object $afterImage1 = this.getAfterImage1();
      result = result * 59 + ($afterImage1 == null ? 43 : $afterImage1.hashCode());
      Object $afterImage2 = this.getAfterImage2();
      result = result * 59 + ($afterImage2 == null ? 43 : $afterImage2.hashCode());
      Object $afterImage3 = this.getAfterImage3();
      return result * 59 + ($afterImage3 == null ? 43 : $afterImage3.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemReportListDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierName="
         + this.getSupplierName()
         + ", qualityOrSafetyEnum="
         + this.getQualityOrSafetyEnum()
         + ", createTime="
         + this.getCreateTime()
         + ", siteName="
         + this.getSiteName()
         + ", remark="
         + this.getRemark()
         + ", beforeAttachment="
         + this.getBeforeAttachment()
         + ", dutyName="
         + this.getDutyName()
         + ", promoterName="
         + this.getPromoterName()
         + ", afterAttachment="
         + this.getAfterAttachment()
         + ", problemStatus="
         + this.getProblemStatus()
         + ", beforeImage1="
         + this.getBeforeImage1()
         + ", beforeImage2="
         + this.getBeforeImage2()
         + ", beforeImage3="
         + this.getBeforeImage3()
         + ", afterImage1="
         + this.getAfterImage1()
         + ", afterImage2="
         + this.getAfterImage2()
         + ", afterImage3="
         + this.getAfterImage3()
         + ")";
   }

   public static class ProjectSafetyProblemReportListDTOBuilder {
      private Long id;
      private String projectName;
      private String supplierName;
      private Integer qualityOrSafetyEnum;
      private LocalDateTime createTime;
      private String siteName;
      private String remark;
      private List<AttachmentDTO> beforeAttachment;
      private String dutyName;
      private String promoterName;
      private List<AttachmentDTO> afterAttachment;
      private Integer problemStatus;
      private ImageEntity beforeImage1;
      private ImageEntity beforeImage2;
      private ImageEntity beforeImage3;
      private ImageEntity afterImage1;
      private ImageEntity afterImage2;
      private ImageEntity afterImage3;

      ProjectSafetyProblemReportListDTOBuilder() {
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder qualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
         this.qualityOrSafetyEnum = qualityOrSafetyEnum;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder siteName(final String siteName) {
         this.siteName = siteName;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder beforeAttachment(final List<AttachmentDTO> beforeAttachment) {
         this.beforeAttachment = beforeAttachment;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder promoterName(final String promoterName) {
         this.promoterName = promoterName;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder afterAttachment(final List<AttachmentDTO> afterAttachment) {
         this.afterAttachment = afterAttachment;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder problemStatus(final Integer problemStatus) {
         this.problemStatus = problemStatus;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder beforeImage1(final ImageEntity beforeImage1) {
         this.beforeImage1 = beforeImage1;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder beforeImage2(final ImageEntity beforeImage2) {
         this.beforeImage2 = beforeImage2;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder beforeImage3(final ImageEntity beforeImage3) {
         this.beforeImage3 = beforeImage3;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder afterImage1(final ImageEntity afterImage1) {
         this.afterImage1 = afterImage1;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder afterImage2(final ImageEntity afterImage2) {
         this.afterImage2 = afterImage2;
         return this;
      }

      public ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder afterImage3(final ImageEntity afterImage3) {
         this.afterImage3 = afterImage3;
         return this;
      }

      public ProjectSafetyProblemReportListDTO build() {
         return new ProjectSafetyProblemReportListDTO(
            this.id,
            this.projectName,
            this.supplierName,
            this.qualityOrSafetyEnum,
            this.createTime,
            this.siteName,
            this.remark,
            this.beforeAttachment,
            this.dutyName,
            this.promoterName,
            this.afterAttachment,
            this.problemStatus,
            this.beforeImage1,
            this.beforeImage2,
            this.beforeImage3,
            this.afterImage1,
            this.afterImage2,
            this.afterImage3
         );
      }

      @Override
      public String toString() {
         return "ProjectSafetyProblemReportListDTO.ProjectSafetyProblemReportListDTOBuilder(id="
            + this.id
            + ", projectName="
            + this.projectName
            + ", supplierName="
            + this.supplierName
            + ", qualityOrSafetyEnum="
            + this.qualityOrSafetyEnum
            + ", createTime="
            + this.createTime
            + ", siteName="
            + this.siteName
            + ", remark="
            + this.remark
            + ", beforeAttachment="
            + this.beforeAttachment
            + ", dutyName="
            + this.dutyName
            + ", promoterName="
            + this.promoterName
            + ", afterAttachment="
            + this.afterAttachment
            + ", problemStatus="
            + this.problemStatus
            + ", beforeImage1="
            + this.beforeImage1
            + ", beforeImage2="
            + this.beforeImage2
            + ", beforeImage3="
            + this.beforeImage3
            + ", afterImage1="
            + this.afterImage1
            + ", afterImage2="
            + this.afterImage2
            + ", afterImage3="
            + this.afterImage3
            + ")";
      }
   }
}
