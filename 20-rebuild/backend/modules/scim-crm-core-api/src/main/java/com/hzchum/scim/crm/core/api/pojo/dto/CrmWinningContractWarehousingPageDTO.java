package com.hzchum.scim.crm.core.api.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CrmWinningContractWarehousingPageDTO {
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "serialNumber", value = "备案号", notes = "备案号")
   private String serialNumber;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案Name", notes = "企业备案Name")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "regionNames", value = "区域名称", notes = "区域名称")
   private String regionNames;
   @ApiModelProperty(name = "structureTypeConfigurationName", value = "结构类型Name", notes = "结构类型Name")
   private String structureTypeConfigurationName;
   @ApiModelProperty(name = "estimatedCost", value = "预估造价", notes = "预估造价")
   private BigDecimal estimatedCost;
   @ApiModelProperty(name = "projectLevelConfigId", value = "项目级别 CrmProjectInformationConfig", notes = "项目级别 CrmProjectInformationConfig")
   private String projectLevelConfigName;
   @ApiModelProperty(name = "departmentName", value = "所属部门", notes = "所属部门")
   private String departmentName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "isUploadStampedContract", value = "是否上传盖章合同", notes = "是否上传盖章合同")
   private String isUploadStampedContract;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnum", value = "当前状态枚举", notes = "当前状态枚举")
   private Integer crmProjectScheduleTypeEnum;
   @ApiModelProperty(name = "crmProjectScheduleTypeEnumName", value = "当前状态", notes = "当前状态")
   private String crmProjectScheduleTypeEnumName;
   @ApiModelProperty(name = "sealContractAttachmentList", value = "盖章合同附件列表", notes = "盖章合同附件列表")
   private List<AttachmentDTO> sealContractAttachmentList;

   public static CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder builder() {
      return new CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder();
   }

   public CrmWinningContractWarehousingPageDTO() {
   }

   public CrmWinningContractWarehousingPageDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String serialNumber,
      final String projectName,
      final String crmEnterpriseWarehousingName,
      final Long crmProjectInformationWarehousingId,
      final String regionNames,
      final String structureTypeConfigurationName,
      final BigDecimal estimatedCost,
      final String projectLevelConfigName,
      final String departmentName,
      final String informantUserName,
      final String isUploadStampedContract,
      final Integer crmProjectScheduleTypeEnum,
      final String crmProjectScheduleTypeEnumName,
      final List<AttachmentDTO> sealContractAttachmentList
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.regionNames = regionNames;
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      this.estimatedCost = estimatedCost;
      this.projectLevelConfigName = projectLevelConfigName;
      this.departmentName = departmentName;
      this.informantUserName = informantUserName;
      this.isUploadStampedContract = isUploadStampedContract;
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      this.sealContractAttachmentList = sealContractAttachmentList;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getRegionNames() {
      return this.regionNames;
   }

   public String getStructureTypeConfigurationName() {
      return this.structureTypeConfigurationName;
   }

   public BigDecimal getEstimatedCost() {
      return this.estimatedCost;
   }

   public String getProjectLevelConfigName() {
      return this.projectLevelConfigName;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getIsUploadStampedContract() {
      return this.isUploadStampedContract;
   }

   public Integer getCrmProjectScheduleTypeEnum() {
      return this.crmProjectScheduleTypeEnum;
   }

   public String getCrmProjectScheduleTypeEnumName() {
      return this.crmProjectScheduleTypeEnumName;
   }

   public List<AttachmentDTO> getSealContractAttachmentList() {
      return this.sealContractAttachmentList;
   }

   public CrmWinningContractWarehousingPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setRegionNames(final String regionNames) {
      this.regionNames = regionNames;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setStructureTypeConfigurationName(final String structureTypeConfigurationName) {
      this.structureTypeConfigurationName = structureTypeConfigurationName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setEstimatedCost(final BigDecimal estimatedCost) {
      this.estimatedCost = estimatedCost;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setProjectLevelConfigName(final String projectLevelConfigName) {
      this.projectLevelConfigName = projectLevelConfigName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setIsUploadStampedContract(final String isUploadStampedContract) {
      this.isUploadStampedContract = isUploadStampedContract;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setCrmProjectScheduleTypeEnum(final Integer crmProjectScheduleTypeEnum) {
      this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setCrmProjectScheduleTypeEnumName(final String crmProjectScheduleTypeEnumName) {
      this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
      return this;
   }

   public CrmWinningContractWarehousingPageDTO setSealContractAttachmentList(final List<AttachmentDTO> sealContractAttachmentList) {
      this.sealContractAttachmentList = sealContractAttachmentList;
      return this;
   }

   @Override
   public String toString() {
      return "CrmWinningContractWarehousingPageDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", regionNames="
         + this.getRegionNames()
         + ", structureTypeConfigurationName="
         + this.getStructureTypeConfigurationName()
         + ", estimatedCost="
         + this.getEstimatedCost()
         + ", projectLevelConfigName="
         + this.getProjectLevelConfigName()
         + ", departmentName="
         + this.getDepartmentName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", isUploadStampedContract="
         + this.getIsUploadStampedContract()
         + ", crmProjectScheduleTypeEnum="
         + this.getCrmProjectScheduleTypeEnum()
         + ", crmProjectScheduleTypeEnumName="
         + this.getCrmProjectScheduleTypeEnumName()
         + ", sealContractAttachmentList="
         + this.getSealContractAttachmentList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmWinningContractWarehousingPageDTO)) {
         return false;
      }

      CrmWinningContractWarehousingPageDTO other = (CrmWinningContractWarehousingPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
            Object other$crmProjectScheduleTypeEnum = other.getCrmProjectScheduleTypeEnum();
            if (this$crmProjectScheduleTypeEnum == null
               ? other$crmProjectScheduleTypeEnum == null
               : this$crmProjectScheduleTypeEnum.equals(other$crmProjectScheduleTypeEnum)) {
               Object this$informantDateTime = this.getInformantDateTime();
               Object other$informantDateTime = other.getInformantDateTime();
               if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                        Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                        if (this$crmEnterpriseWarehousingName == null
                           ? other$crmEnterpriseWarehousingName == null
                           : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                           Object this$regionNames = this.getRegionNames();
                           Object other$regionNames = other.getRegionNames();
                           if (this$regionNames == null ? other$regionNames == null : this$regionNames.equals(other$regionNames)) {
                              Object this$structureTypeConfigurationName = this.getStructureTypeConfigurationName();
                              Object other$structureTypeConfigurationName = other.getStructureTypeConfigurationName();
                              if (this$structureTypeConfigurationName == null
                                 ? other$structureTypeConfigurationName == null
                                 : this$structureTypeConfigurationName.equals(other$structureTypeConfigurationName)) {
                                 Object this$estimatedCost = this.getEstimatedCost();
                                 Object other$estimatedCost = other.getEstimatedCost();
                                 if (this$estimatedCost == null ? other$estimatedCost == null : this$estimatedCost.equals(other$estimatedCost)) {
                                    Object this$projectLevelConfigName = this.getProjectLevelConfigName();
                                    Object other$projectLevelConfigName = other.getProjectLevelConfigName();
                                    if (this$projectLevelConfigName == null
                                       ? other$projectLevelConfigName == null
                                       : this$projectLevelConfigName.equals(other$projectLevelConfigName)) {
                                       Object this$departmentName = this.getDepartmentName();
                                       Object other$departmentName = other.getDepartmentName();
                                       if (this$departmentName == null ? other$departmentName == null : this$departmentName.equals(other$departmentName)) {
                                          Object this$informantUserName = this.getInformantUserName();
                                          Object other$informantUserName = other.getInformantUserName();
                                          if (this$informantUserName == null
                                             ? other$informantUserName == null
                                             : this$informantUserName.equals(other$informantUserName)) {
                                             Object this$isUploadStampedContract = this.getIsUploadStampedContract();
                                             Object other$isUploadStampedContract = other.getIsUploadStampedContract();
                                             if (this$isUploadStampedContract == null
                                                ? other$isUploadStampedContract == null
                                                : this$isUploadStampedContract.equals(other$isUploadStampedContract)) {
                                                Object this$crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
                                                Object other$crmProjectScheduleTypeEnumName = other.getCrmProjectScheduleTypeEnumName();
                                                if (this$crmProjectScheduleTypeEnumName == null
                                                   ? other$crmProjectScheduleTypeEnumName == null
                                                   : this$crmProjectScheduleTypeEnumName.equals(other$crmProjectScheduleTypeEnumName)) {
                                                   Object this$sealContractAttachmentList = this.getSealContractAttachmentList();
                                                   Object other$sealContractAttachmentList = other.getSealContractAttachmentList();
                                                   return this$sealContractAttachmentList == null
                                                      ? other$sealContractAttachmentList == null
                                                      : this$sealContractAttachmentList.equals(other$sealContractAttachmentList);
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
      return other instanceof CrmWinningContractWarehousingPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmProjectScheduleTypeEnum = this.getCrmProjectScheduleTypeEnum();
      result = result * 59 + ($crmProjectScheduleTypeEnum == null ? 43 : $crmProjectScheduleTypeEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $regionNames = this.getRegionNames();
      result = result * 59 + ($regionNames == null ? 43 : $regionNames.hashCode());
      Object $structureTypeConfigurationName = this.getStructureTypeConfigurationName();
      result = result * 59 + ($structureTypeConfigurationName == null ? 43 : $structureTypeConfigurationName.hashCode());
      Object $estimatedCost = this.getEstimatedCost();
      result = result * 59 + ($estimatedCost == null ? 43 : $estimatedCost.hashCode());
      Object $projectLevelConfigName = this.getProjectLevelConfigName();
      result = result * 59 + ($projectLevelConfigName == null ? 43 : $projectLevelConfigName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $isUploadStampedContract = this.getIsUploadStampedContract();
      result = result * 59 + ($isUploadStampedContract == null ? 43 : $isUploadStampedContract.hashCode());
      Object $crmProjectScheduleTypeEnumName = this.getCrmProjectScheduleTypeEnumName();
      result = result * 59 + ($crmProjectScheduleTypeEnumName == null ? 43 : $crmProjectScheduleTypeEnumName.hashCode());
      Object $sealContractAttachmentList = this.getSealContractAttachmentList();
      return result * 59 + ($sealContractAttachmentList == null ? 43 : $sealContractAttachmentList.hashCode());
   }

   public static class CrmWinningContractWarehousingPageDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String serialNumber;
      private String projectName;
      private String crmEnterpriseWarehousingName;
      private Long crmProjectInformationWarehousingId;
      private String regionNames;
      private String structureTypeConfigurationName;
      private BigDecimal estimatedCost;
      private String projectLevelConfigName;
      private String departmentName;
      private String informantUserName;
      private String isUploadStampedContract;
      private Integer crmProjectScheduleTypeEnum;
      private String crmProjectScheduleTypeEnumName;
      private List<AttachmentDTO> sealContractAttachmentList;

      CrmWinningContractWarehousingPageDTOBuilder() {
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder crmEnterpriseWarehousingName(
         final String crmEnterpriseWarehousingName
      ) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder crmProjectInformationWarehousingId(
         final Long crmProjectInformationWarehousingId
      ) {
         this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder regionNames(final String regionNames) {
         this.regionNames = regionNames;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder structureTypeConfigurationName(
         final String structureTypeConfigurationName
      ) {
         this.structureTypeConfigurationName = structureTypeConfigurationName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder estimatedCost(final BigDecimal estimatedCost) {
         this.estimatedCost = estimatedCost;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder projectLevelConfigName(final String projectLevelConfigName) {
         this.projectLevelConfigName = projectLevelConfigName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder isUploadStampedContract(final String isUploadStampedContract) {
         this.isUploadStampedContract = isUploadStampedContract;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder crmProjectScheduleTypeEnum(
         final Integer crmProjectScheduleTypeEnum
      ) {
         this.crmProjectScheduleTypeEnum = crmProjectScheduleTypeEnum;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder crmProjectScheduleTypeEnumName(
         final String crmProjectScheduleTypeEnumName
      ) {
         this.crmProjectScheduleTypeEnumName = crmProjectScheduleTypeEnumName;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder sealContractAttachmentList(
         final List<AttachmentDTO> sealContractAttachmentList
      ) {
         this.sealContractAttachmentList = sealContractAttachmentList;
         return this;
      }

      public CrmWinningContractWarehousingPageDTO build() {
         return new CrmWinningContractWarehousingPageDTO(
            this.id,
            this.informantDateTime,
            this.serialNumber,
            this.projectName,
            this.crmEnterpriseWarehousingName,
            this.crmProjectInformationWarehousingId,
            this.regionNames,
            this.structureTypeConfigurationName,
            this.estimatedCost,
            this.projectLevelConfigName,
            this.departmentName,
            this.informantUserName,
            this.isUploadStampedContract,
            this.crmProjectScheduleTypeEnum,
            this.crmProjectScheduleTypeEnumName,
            this.sealContractAttachmentList
         );
      }

      @Override
      public String toString() {
         return "CrmWinningContractWarehousingPageDTO.CrmWinningContractWarehousingPageDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", crmProjectInformationWarehousingId="
            + this.crmProjectInformationWarehousingId
            + ", regionNames="
            + this.regionNames
            + ", structureTypeConfigurationName="
            + this.structureTypeConfigurationName
            + ", estimatedCost="
            + this.estimatedCost
            + ", projectLevelConfigName="
            + this.projectLevelConfigName
            + ", departmentName="
            + this.departmentName
            + ", informantUserName="
            + this.informantUserName
            + ", isUploadStampedContract="
            + this.isUploadStampedContract
            + ", crmProjectScheduleTypeEnum="
            + this.crmProjectScheduleTypeEnum
            + ", crmProjectScheduleTypeEnumName="
            + this.crmProjectScheduleTypeEnumName
            + ", sealContractAttachmentList="
            + this.sealContractAttachmentList
            + ")";
      }
   }
}
