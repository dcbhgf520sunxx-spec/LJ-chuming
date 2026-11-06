package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("合同归档查询-返回类")
public class ContractProjectArchivistDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("OA编号")
   private String oaNumber;
   @ApiModelProperty("合同类型")
   private String contractType;
   @ApiModelProperty("合同编号")
   private String serialNumber;
   @ApiModelProperty("合同名称")
   private String name;
   @ApiModelProperty("甲方")
   private String firstParty;
   @ApiModelProperty("乙方")
   private String secondParty;
   @ApiModelProperty("创建人")
   private String contractCreatorName;
   @ApiModelProperty("归档人")
   private String contractArchivistName;
   @ApiModelProperty("终结日期（审批）")
   private LocalDateTime endDate;
   @ApiModelProperty("导入日期")
   private LocalDateTime importDate;
   @ApiModelProperty(name = "contractDefinitionType", notes = "合同定义枚举 参考枚举：ContractDefinitionTypeEnum")
   private Integer contractDefinitionType;
   @ApiModelProperty("附件集合")
   private List<ProjectAttachmentDTO> projectAttachmentDTOList;

   public Long getId() {
      return this.id;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public String getContractType() {
      return this.contractType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getFirstParty() {
      return this.firstParty;
   }

   public String getSecondParty() {
      return this.secondParty;
   }

   public String getContractCreatorName() {
      return this.contractCreatorName;
   }

   public String getContractArchivistName() {
      return this.contractArchivistName;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public LocalDateTime getImportDate() {
      return this.importDate;
   }

   public Integer getContractDefinitionType() {
      return this.contractDefinitionType;
   }

   public List<ProjectAttachmentDTO> getProjectAttachmentDTOList() {
      return this.projectAttachmentDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
   }

   public void setContractType(final String contractType) {
      this.contractType = contractType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFirstParty(final String firstParty) {
      this.firstParty = firstParty;
   }

   public void setSecondParty(final String secondParty) {
      this.secondParty = secondParty;
   }

   public void setContractCreatorName(final String contractCreatorName) {
      this.contractCreatorName = contractCreatorName;
   }

   public void setContractArchivistName(final String contractArchivistName) {
      this.contractArchivistName = contractArchivistName;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setImportDate(final LocalDateTime importDate) {
      this.importDate = importDate;
   }

   public void setContractDefinitionType(final Integer contractDefinitionType) {
      this.contractDefinitionType = contractDefinitionType;
   }

   public void setProjectAttachmentDTOList(final List<ProjectAttachmentDTO> projectAttachmentDTOList) {
      this.projectAttachmentDTOList = projectAttachmentDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectArchivistDTO)) {
         return false;
      }

      ContractProjectArchivistDTO other = (ContractProjectArchivistDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$contractDefinitionType = this.getContractDefinitionType();
         Object other$contractDefinitionType = other.getContractDefinitionType();
         if (this$contractDefinitionType == null ? other$contractDefinitionType == null : this$contractDefinitionType.equals(other$contractDefinitionType)) {
            Object this$oaNumber = this.getOaNumber();
            Object other$oaNumber = other.getOaNumber();
            if (this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber)) {
               Object this$contractType = this.getContractType();
               Object other$contractType = other.getContractType();
               if (this$contractType == null ? other$contractType == null : this$contractType.equals(other$contractType)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$firstParty = this.getFirstParty();
                        Object other$firstParty = other.getFirstParty();
                        if (this$firstParty == null ? other$firstParty == null : this$firstParty.equals(other$firstParty)) {
                           Object this$secondParty = this.getSecondParty();
                           Object other$secondParty = other.getSecondParty();
                           if (this$secondParty == null ? other$secondParty == null : this$secondParty.equals(other$secondParty)) {
                              Object this$contractCreatorName = this.getContractCreatorName();
                              Object other$contractCreatorName = other.getContractCreatorName();
                              if (this$contractCreatorName == null
                                 ? other$contractCreatorName == null
                                 : this$contractCreatorName.equals(other$contractCreatorName)) {
                                 Object this$contractArchivistName = this.getContractArchivistName();
                                 Object other$contractArchivistName = other.getContractArchivistName();
                                 if (this$contractArchivistName == null
                                    ? other$contractArchivistName == null
                                    : this$contractArchivistName.equals(other$contractArchivistName)) {
                                    Object this$endDate = this.getEndDate();
                                    Object other$endDate = other.getEndDate();
                                    if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                       Object this$importDate = this.getImportDate();
                                       Object other$importDate = other.getImportDate();
                                       if (this$importDate == null ? other$importDate == null : this$importDate.equals(other$importDate)) {
                                          Object this$projectAttachmentDTOList = this.getProjectAttachmentDTOList();
                                          Object other$projectAttachmentDTOList = other.getProjectAttachmentDTOList();
                                          return this$projectAttachmentDTOList == null
                                             ? other$projectAttachmentDTOList == null
                                             : this$projectAttachmentDTOList.equals(other$projectAttachmentDTOList);
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
      return other instanceof ContractProjectArchivistDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $contractDefinitionType = this.getContractDefinitionType();
      result = result * 59 + ($contractDefinitionType == null ? 43 : $contractDefinitionType.hashCode());
      Object $oaNumber = this.getOaNumber();
      result = result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $firstParty = this.getFirstParty();
      result = result * 59 + ($firstParty == null ? 43 : $firstParty.hashCode());
      Object $secondParty = this.getSecondParty();
      result = result * 59 + ($secondParty == null ? 43 : $secondParty.hashCode());
      Object $contractCreatorName = this.getContractCreatorName();
      result = result * 59 + ($contractCreatorName == null ? 43 : $contractCreatorName.hashCode());
      Object $contractArchivistName = this.getContractArchivistName();
      result = result * 59 + ($contractArchivistName == null ? 43 : $contractArchivistName.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $importDate = this.getImportDate();
      result = result * 59 + ($importDate == null ? 43 : $importDate.hashCode());
      Object $projectAttachmentDTOList = this.getProjectAttachmentDTOList();
      return result * 59 + ($projectAttachmentDTOList == null ? 43 : $projectAttachmentDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectArchivistDTO(id="
         + this.getId()
         + ", oaNumber="
         + this.getOaNumber()
         + ", contractType="
         + this.getContractType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", firstParty="
         + this.getFirstParty()
         + ", secondParty="
         + this.getSecondParty()
         + ", contractCreatorName="
         + this.getContractCreatorName()
         + ", contractArchivistName="
         + this.getContractArchivistName()
         + ", endDate="
         + this.getEndDate()
         + ", importDate="
         + this.getImportDate()
         + ", contractDefinitionType="
         + this.getContractDefinitionType()
         + ", projectAttachmentDTOList="
         + this.getProjectAttachmentDTOList()
         + ")";
   }
}
