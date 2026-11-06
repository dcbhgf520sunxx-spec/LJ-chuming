package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import java.util.List;

public class ProjectRelevancyDTO {
   private Long id;
   private String name;
   private String shortName;
   private String serialNumber;
   private Integer projectAttribute;
   private Integer level;
   private Long contractSignBodyId;
   private Long projectManagerId;
   private String projectManagerName;
   private Integer status;
   private List<ProjectBranchCompanyLinkDTO> companyLinkDTO;
   private List<PlanAreaBatchDTO> areaBatchList;

   public static ProjectRelevancyDTO.ProjectRelevancyDTOBuilder builder() {
      return new ProjectRelevancyDTO.ProjectRelevancyDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<ProjectBranchCompanyLinkDTO> getCompanyLinkDTO() {
      return this.companyLinkDTO;
   }

   public List<PlanAreaBatchDTO> getAreaBatchList() {
      return this.areaBatchList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setCompanyLinkDTO(final List<ProjectBranchCompanyLinkDTO> companyLinkDTO) {
      this.companyLinkDTO = companyLinkDTO;
   }

   public void setAreaBatchList(final List<PlanAreaBatchDTO> areaBatchList) {
      this.areaBatchList = areaBatchList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectRelevancyDTO)) {
         return false;
      }

      ProjectRelevancyDTO other = (ProjectRelevancyDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$level = this.getLevel();
            Object other$level = other.getLevel();
            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
               Object this$contractSignBodyId = this.getContractSignBodyId();
               Object other$contractSignBodyId = other.getContractSignBodyId();
               if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$status = this.getStatus();
                     Object other$status = other.getStatus();
                     if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$shortName = this.getShortName();
                           Object other$shortName = other.getShortName();
                           if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$projectManagerName = this.getProjectManagerName();
                                 Object other$projectManagerName = other.getProjectManagerName();
                                 if (this$projectManagerName == null
                                    ? other$projectManagerName == null
                                    : this$projectManagerName.equals(other$projectManagerName)) {
                                    Object this$companyLinkDTO = this.getCompanyLinkDTO();
                                    Object other$companyLinkDTO = other.getCompanyLinkDTO();
                                    if (this$companyLinkDTO == null ? other$companyLinkDTO == null : this$companyLinkDTO.equals(other$companyLinkDTO)) {
                                       Object this$areaBatchList = this.getAreaBatchList();
                                       Object other$areaBatchList = other.getAreaBatchList();
                                       return this$areaBatchList == null ? other$areaBatchList == null : this$areaBatchList.equals(other$areaBatchList);
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
      return other instanceof ProjectRelevancyDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $companyLinkDTO = this.getCompanyLinkDTO();
      result = result * 59 + ($companyLinkDTO == null ? 43 : $companyLinkDTO.hashCode());
      Object $areaBatchList = this.getAreaBatchList();
      return result * 59 + ($areaBatchList == null ? 43 : $areaBatchList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectRelevancyDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", level="
         + this.getLevel()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", status="
         + this.getStatus()
         + ", companyLinkDTO="
         + this.getCompanyLinkDTO()
         + ", areaBatchList="
         + this.getAreaBatchList()
         + ")";
   }

   public ProjectRelevancyDTO(
      final Long id,
      final String name,
      final String shortName,
      final String serialNumber,
      final Integer projectAttribute,
      final Integer level,
      final Long contractSignBodyId,
      final Long projectManagerId,
      final String projectManagerName,
      final Integer status,
      final List<ProjectBranchCompanyLinkDTO> companyLinkDTO,
      final List<PlanAreaBatchDTO> areaBatchList
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
      this.projectAttribute = projectAttribute;
      this.level = level;
      this.contractSignBodyId = contractSignBodyId;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.status = status;
      this.companyLinkDTO = companyLinkDTO;
      this.areaBatchList = areaBatchList;
   }

   public ProjectRelevancyDTO() {
   }

   public static class ProjectRelevancyDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;
      private Integer projectAttribute;
      private Integer level;
      private Long contractSignBodyId;
      private Long projectManagerId;
      private String projectManagerName;
      private Integer status;
      private List<ProjectBranchCompanyLinkDTO> companyLinkDTO;
      private List<PlanAreaBatchDTO> areaBatchList;

      ProjectRelevancyDTOBuilder() {
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder contractSignBodyId(final Long contractSignBodyId) {
         this.contractSignBodyId = contractSignBodyId;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder companyLinkDTO(final List<ProjectBranchCompanyLinkDTO> companyLinkDTO) {
         this.companyLinkDTO = companyLinkDTO;
         return this;
      }

      public ProjectRelevancyDTO.ProjectRelevancyDTOBuilder areaBatchList(final List<PlanAreaBatchDTO> areaBatchList) {
         this.areaBatchList = areaBatchList;
         return this;
      }

      public ProjectRelevancyDTO build() {
         return new ProjectRelevancyDTO(
            this.id,
            this.name,
            this.shortName,
            this.serialNumber,
            this.projectAttribute,
            this.level,
            this.contractSignBodyId,
            this.projectManagerId,
            this.projectManagerName,
            this.status,
            this.companyLinkDTO,
            this.areaBatchList
         );
      }

      @Override
      public String toString() {
         return "ProjectRelevancyDTO.ProjectRelevancyDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ", projectAttribute="
            + this.projectAttribute
            + ", level="
            + this.level
            + ", contractSignBodyId="
            + this.contractSignBodyId
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", status="
            + this.status
            + ", companyLinkDTO="
            + this.companyLinkDTO
            + ", areaBatchList="
            + this.areaBatchList
            + ")";
      }
   }
}
