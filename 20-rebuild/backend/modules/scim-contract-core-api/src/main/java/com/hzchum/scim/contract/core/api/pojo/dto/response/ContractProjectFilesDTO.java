package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("合同档案列表-返回类")
public class ContractProjectFilesDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("签订日期")
   private LocalDate signingDate;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("项目名称")
   private String name;
   @ApiModelProperty(name = "customerUnit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id(公司,单位...)")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", notes = "签订主体名称")
   private String contractSignBodyName;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "businessType", notes = "业务类型 1.加工承揽  2.项目承包 ")
   private Integer businessType;
   @ApiModelProperty(name = "structureArea", value = "建筑面积")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "structureStatus", value = "结构类型")
   private Long structureStatus;
   @ApiModelProperty(name = "structureStatusName", value = "结构类型名称")
   private String structureStatusName;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理")
   private String projectManagerName;
   @ApiModelProperty(name = "salesLeaderName", notes = "销售负责人名字")
   private String salesLeaderName;
   @ApiModelProperty(name = "contractQuantity", notes = "合同数量")
   private Integer contractQuantity;
   @ApiModelProperty(name = "alreadyArchive", notes = "已归档数量")
   private Integer alreadyArchive;
   @ApiModelProperty(name = "notArchive", notes = "未归档数量")
   private Integer notArchive;
   @ApiModelProperty(name = "contractCreatorName", notes = "合同创建人")
   private String contractCreatorName;
   @ApiModelProperty(name = "attachments", notes = "附件id字符串")
   private String attachments;
   @ApiModelProperty(name = "attachmentDTOList", notes = "附件数量")
   private int attachmentCount;
   @ApiModelProperty(name = "attachmentDTOList", notes = "附件集合")
   private List<ProjectAttachmentDTO> attachmentDTOList;
   @ApiModelProperty(name = "contractArchivistName", notes = "合同归档人")
   private String contractArchivistName;
   @ApiModelProperty(name = "archivistDate", notes = "归档日期")
   private LocalDateTime archivistDate;
   @ApiModelProperty(name = "contractType", notes = "选择类型 1.主合同 2.工程量增补合同 3.补充合同 参考枚举：ContractTypeEnum")
   private Integer contractType;
   @ApiModelProperty(name = "isArchive", notes = "是否归档 1.是 0.否")
   private Integer isArchive;
   @ApiModelProperty(name = "contractDefinitionType", notes = "合同定义枚举 参考枚举：ContractDefinitionTypeEnum")
   private Integer contractDefinitionType;
   @ApiModelProperty(name = "pId", notes = "父合同id")
   private Long pId;
   @ApiModelProperty(name = "projectFilesDTO", notes = "子合同集合")
   private List<ContractProjectFilesDTO> projectFilesDTOS;
   @ApiModelProperty(name = "projectIds", notes = "包含子合同Id和自己本身的Id")
   private List<Long> projectIds;

   public Long getId() {
      return this.id;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public String getStructureStatusName() {
      return this.structureStatusName;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public Integer getContractQuantity() {
      return this.contractQuantity;
   }

   public Integer getAlreadyArchive() {
      return this.alreadyArchive;
   }

   public Integer getNotArchive() {
      return this.notArchive;
   }

   public String getContractCreatorName() {
      return this.contractCreatorName;
   }

   public String getAttachments() {
      return this.attachments;
   }

   public int getAttachmentCount() {
      return this.attachmentCount;
   }

   public List<ProjectAttachmentDTO> getAttachmentDTOList() {
      return this.attachmentDTOList;
   }

   public String getContractArchivistName() {
      return this.contractArchivistName;
   }

   public LocalDateTime getArchivistDate() {
      return this.archivistDate;
   }

   public Integer getContractType() {
      return this.contractType;
   }

   public Integer getIsArchive() {
      return this.isArchive;
   }

   public Integer getContractDefinitionType() {
      return this.contractDefinitionType;
   }

   public Long getPId() {
      return this.pId;
   }

   public List<ContractProjectFilesDTO> getProjectFilesDTOS() {
      return this.projectFilesDTOS;
   }

   public List<Long> getProjectIds() {
      return this.projectIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setStructureStatusName(final String structureStatusName) {
      this.structureStatusName = structureStatusName;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setContractQuantity(final Integer contractQuantity) {
      this.contractQuantity = contractQuantity;
   }

   public void setAlreadyArchive(final Integer alreadyArchive) {
      this.alreadyArchive = alreadyArchive;
   }

   public void setNotArchive(final Integer notArchive) {
      this.notArchive = notArchive;
   }

   public void setContractCreatorName(final String contractCreatorName) {
      this.contractCreatorName = contractCreatorName;
   }

   public void setAttachments(final String attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentCount(final int attachmentCount) {
      this.attachmentCount = attachmentCount;
   }

   public void setAttachmentDTOList(final List<ProjectAttachmentDTO> attachmentDTOList) {
      this.attachmentDTOList = attachmentDTOList;
   }

   public void setContractArchivistName(final String contractArchivistName) {
      this.contractArchivistName = contractArchivistName;
   }

   public void setArchivistDate(final LocalDateTime archivistDate) {
      this.archivistDate = archivistDate;
   }

   public void setContractType(final Integer contractType) {
      this.contractType = contractType;
   }

   public void setIsArchive(final Integer isArchive) {
      this.isArchive = isArchive;
   }

   public void setContractDefinitionType(final Integer contractDefinitionType) {
      this.contractDefinitionType = contractDefinitionType;
   }

   public void setPId(final Long pId) {
      this.pId = pId;
   }

   public void setProjectFilesDTOS(final List<ContractProjectFilesDTO> projectFilesDTOS) {
      this.projectFilesDTOS = projectFilesDTOS;
   }

   public void setProjectIds(final List<Long> projectIds) {
      this.projectIds = projectIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectFilesDTO)) {
         return false;
      }

      ContractProjectFilesDTO other = (ContractProjectFilesDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAttachmentCount() != other.getAttachmentCount()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractSignBodyId = this.getContractSignBodyId();
         Object other$contractSignBodyId = other.getContractSignBodyId();
         if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$businessType = this.getBusinessType();
               Object other$businessType = other.getBusinessType();
               if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                  Object this$structureStatus = this.getStructureStatus();
                  Object other$structureStatus = other.getStructureStatus();
                  if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                     Object this$contractQuantity = this.getContractQuantity();
                     Object other$contractQuantity = other.getContractQuantity();
                     if (this$contractQuantity == null ? other$contractQuantity == null : this$contractQuantity.equals(other$contractQuantity)) {
                        Object this$alreadyArchive = this.getAlreadyArchive();
                        Object other$alreadyArchive = other.getAlreadyArchive();
                        if (this$alreadyArchive == null ? other$alreadyArchive == null : this$alreadyArchive.equals(other$alreadyArchive)) {
                           Object this$notArchive = this.getNotArchive();
                           Object other$notArchive = other.getNotArchive();
                           if (this$notArchive == null ? other$notArchive == null : this$notArchive.equals(other$notArchive)) {
                              Object this$contractType = this.getContractType();
                              Object other$contractType = other.getContractType();
                              if (this$contractType == null ? other$contractType == null : this$contractType.equals(other$contractType)) {
                                 Object this$isArchive = this.getIsArchive();
                                 Object other$isArchive = other.getIsArchive();
                                 if (this$isArchive == null ? other$isArchive == null : this$isArchive.equals(other$isArchive)) {
                                    Object this$contractDefinitionType = this.getContractDefinitionType();
                                    Object other$contractDefinitionType = other.getContractDefinitionType();
                                    if (this$contractDefinitionType == null
                                       ? other$contractDefinitionType == null
                                       : this$contractDefinitionType.equals(other$contractDefinitionType)) {
                                       Object this$pId = this.getPId();
                                       Object other$pId = other.getPId();
                                       if (this$pId == null ? other$pId == null : this$pId.equals(other$pId)) {
                                          Object this$signingDate = this.getSigningDate();
                                          Object other$signingDate = other.getSigningDate();
                                          if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$customerUnit = this.getCustomerUnit();
                                                   Object other$customerUnit = other.getCustomerUnit();
                                                   if (this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit)) {
                                                      Object this$contractSignBodyName = this.getContractSignBodyName();
                                                      Object other$contractSignBodyName = other.getContractSignBodyName();
                                                      if (this$contractSignBodyName == null
                                                         ? other$contractSignBodyName == null
                                                         : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                                         Object this$structureArea = this.getStructureArea();
                                                         Object other$structureArea = other.getStructureArea();
                                                         if (this$structureArea == null
                                                            ? other$structureArea == null
                                                            : this$structureArea.equals(other$structureArea)) {
                                                            Object this$structureStatusName = this.getStructureStatusName();
                                                            Object other$structureStatusName = other.getStructureStatusName();
                                                            if (this$structureStatusName == null
                                                               ? other$structureStatusName == null
                                                               : this$structureStatusName.equals(other$structureStatusName)) {
                                                               Object this$projectManagerName = this.getProjectManagerName();
                                                               Object other$projectManagerName = other.getProjectManagerName();
                                                               if (this$projectManagerName == null
                                                                  ? other$projectManagerName == null
                                                                  : this$projectManagerName.equals(other$projectManagerName)) {
                                                                  Object this$salesLeaderName = this.getSalesLeaderName();
                                                                  Object other$salesLeaderName = other.getSalesLeaderName();
                                                                  if (this$salesLeaderName == null
                                                                     ? other$salesLeaderName == null
                                                                     : this$salesLeaderName.equals(other$salesLeaderName)) {
                                                                     Object this$contractCreatorName = this.getContractCreatorName();
                                                                     Object other$contractCreatorName = other.getContractCreatorName();
                                                                     if (this$contractCreatorName == null
                                                                        ? other$contractCreatorName == null
                                                                        : this$contractCreatorName.equals(other$contractCreatorName)) {
                                                                        Object this$attachments = this.getAttachments();
                                                                        Object other$attachments = other.getAttachments();
                                                                        if (this$attachments == null
                                                                           ? other$attachments == null
                                                                           : this$attachments.equals(other$attachments)) {
                                                                           Object this$attachmentDTOList = this.getAttachmentDTOList();
                                                                           Object other$attachmentDTOList = other.getAttachmentDTOList();
                                                                           if (this$attachmentDTOList == null
                                                                              ? other$attachmentDTOList == null
                                                                              : this$attachmentDTOList.equals(other$attachmentDTOList)) {
                                                                              Object this$contractArchivistName = this.getContractArchivistName();
                                                                              Object other$contractArchivistName = other.getContractArchivistName();
                                                                              if (this$contractArchivistName == null
                                                                                 ? other$contractArchivistName == null
                                                                                 : this$contractArchivistName.equals(other$contractArchivistName)) {
                                                                                 Object this$archivistDate = this.getArchivistDate();
                                                                                 Object other$archivistDate = other.getArchivistDate();
                                                                                 if (this$archivistDate == null
                                                                                    ? other$archivistDate == null
                                                                                    : this$archivistDate.equals(other$archivistDate)) {
                                                                                    Object this$projectFilesDTOS = this.getProjectFilesDTOS();
                                                                                    Object other$projectFilesDTOS = other.getProjectFilesDTOS();
                                                                                    if (this$projectFilesDTOS == null
                                                                                       ? other$projectFilesDTOS == null
                                                                                       : this$projectFilesDTOS.equals(other$projectFilesDTOS)) {
                                                                                       Object this$projectIds = this.getProjectIds();
                                                                                       Object other$projectIds = other.getProjectIds();
                                                                                       return this$projectIds == null
                                                                                          ? other$projectIds == null
                                                                                          : this$projectIds.equals(other$projectIds);
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
      return other instanceof ContractProjectFilesDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAttachmentCount();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $contractQuantity = this.getContractQuantity();
      result = result * 59 + ($contractQuantity == null ? 43 : $contractQuantity.hashCode());
      Object $alreadyArchive = this.getAlreadyArchive();
      result = result * 59 + ($alreadyArchive == null ? 43 : $alreadyArchive.hashCode());
      Object $notArchive = this.getNotArchive();
      result = result * 59 + ($notArchive == null ? 43 : $notArchive.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $isArchive = this.getIsArchive();
      result = result * 59 + ($isArchive == null ? 43 : $isArchive.hashCode());
      Object $contractDefinitionType = this.getContractDefinitionType();
      result = result * 59 + ($contractDefinitionType == null ? 43 : $contractDefinitionType.hashCode());
      Object $pId = this.getPId();
      result = result * 59 + ($pId == null ? 43 : $pId.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $structureStatusName = this.getStructureStatusName();
      result = result * 59 + ($structureStatusName == null ? 43 : $structureStatusName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $contractCreatorName = this.getContractCreatorName();
      result = result * 59 + ($contractCreatorName == null ? 43 : $contractCreatorName.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $attachmentDTOList = this.getAttachmentDTOList();
      result = result * 59 + ($attachmentDTOList == null ? 43 : $attachmentDTOList.hashCode());
      Object $contractArchivistName = this.getContractArchivistName();
      result = result * 59 + ($contractArchivistName == null ? 43 : $contractArchivistName.hashCode());
      Object $archivistDate = this.getArchivistDate();
      result = result * 59 + ($archivistDate == null ? 43 : $archivistDate.hashCode());
      Object $projectFilesDTOS = this.getProjectFilesDTOS();
      result = result * 59 + ($projectFilesDTOS == null ? 43 : $projectFilesDTOS.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectFilesDTO(id="
         + this.getId()
         + ", signingDate="
         + this.getSigningDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", businessType="
         + this.getBusinessType()
         + ", structureArea="
         + this.getStructureArea()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", structureStatusName="
         + this.getStructureStatusName()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", contractQuantity="
         + this.getContractQuantity()
         + ", alreadyArchive="
         + this.getAlreadyArchive()
         + ", notArchive="
         + this.getNotArchive()
         + ", contractCreatorName="
         + this.getContractCreatorName()
         + ", attachments="
         + this.getAttachments()
         + ", attachmentCount="
         + this.getAttachmentCount()
         + ", attachmentDTOList="
         + this.getAttachmentDTOList()
         + ", contractArchivistName="
         + this.getContractArchivistName()
         + ", archivistDate="
         + this.getArchivistDate()
         + ", contractType="
         + this.getContractType()
         + ", isArchive="
         + this.getIsArchive()
         + ", contractDefinitionType="
         + this.getContractDefinitionType()
         + ", pId="
         + this.getPId()
         + ", projectFilesDTOS="
         + this.getProjectFilesDTOS()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }
}
