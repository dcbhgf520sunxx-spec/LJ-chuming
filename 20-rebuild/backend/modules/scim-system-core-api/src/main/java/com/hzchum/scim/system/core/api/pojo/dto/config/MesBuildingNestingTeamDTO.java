package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesBuildingNestingTeamDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "company", value = "二级单位", notes = "二级单位")
   private String company;
   @ApiModelProperty(name = "companyName", value = "二级单位名称", notes = "二级单位名称")
   private String companyName;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "车间名称", notes = "车间名称")
   private String workshopName;
   @ApiModelProperty(name = "nestingChargePerson", value = "负责人", notes = "负责人")
   private Long nestingChargePerson;
   @ApiModelProperty(name = "nestingChargePersonName", value = "负责人名称", notes = "负责人名称")
   private String nestingChargePersonName;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   private String teamCode;
   @ApiModelProperty(name = "boolDrillHole", value = "是否板启用", notes = "是否板启用")
   private Integer boolDrillHole;

   public static MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder builder() {
      return new MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder();
   }

   public MesBuildingNestingTeamDTO() {
   }

   public MesBuildingNestingTeamDTO(
      final Long id,
      final String company,
      final String companyName,
      final Long workshopId,
      final String workshopName,
      final Long nestingChargePerson,
      final String nestingChargePersonName,
      final String teamCode,
      final Integer boolDrillHole
   ) {
      this.id = id;
      this.company = company;
      this.companyName = companyName;
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.nestingChargePerson = nestingChargePerson;
      this.nestingChargePersonName = nestingChargePersonName;
      this.teamCode = teamCode;
      this.boolDrillHole = boolDrillHole;
   }

   public Long getId() {
      return this.id;
   }

   public String getCompany() {
      return this.company;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getNestingChargePerson() {
      return this.nestingChargePerson;
   }

   public String getNestingChargePersonName() {
      return this.nestingChargePersonName;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public Integer getBoolDrillHole() {
      return this.boolDrillHole;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCompany(final String company) {
      this.company = company;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setNestingChargePerson(final Long nestingChargePerson) {
      this.nestingChargePerson = nestingChargePerson;
   }

   public void setNestingChargePersonName(final String nestingChargePersonName) {
      this.nestingChargePersonName = nestingChargePersonName;
   }

   public void setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
   }

   public void setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingTeamDTO)) {
         return false;
      }

      MesBuildingNestingTeamDTO other = (MesBuildingNestingTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$nestingChargePerson = this.getNestingChargePerson();
            Object other$nestingChargePerson = other.getNestingChargePerson();
            if (this$nestingChargePerson == null ? other$nestingChargePerson == null : this$nestingChargePerson.equals(other$nestingChargePerson)) {
               Object this$boolDrillHole = this.getBoolDrillHole();
               Object other$boolDrillHole = other.getBoolDrillHole();
               if (this$boolDrillHole == null ? other$boolDrillHole == null : this$boolDrillHole.equals(other$boolDrillHole)) {
                  Object this$company = this.getCompany();
                  Object other$company = other.getCompany();
                  if (this$company == null ? other$company == null : this$company.equals(other$company)) {
                     Object this$companyName = this.getCompanyName();
                     Object other$companyName = other.getCompanyName();
                     if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
                        Object this$workshopName = this.getWorkshopName();
                        Object other$workshopName = other.getWorkshopName();
                        if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                           Object this$nestingChargePersonName = this.getNestingChargePersonName();
                           Object other$nestingChargePersonName = other.getNestingChargePersonName();
                           if (this$nestingChargePersonName == null
                              ? other$nestingChargePersonName == null
                              : this$nestingChargePersonName.equals(other$nestingChargePersonName)) {
                              Object this$teamCode = this.getTeamCode();
                              Object other$teamCode = other.getTeamCode();
                              return this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode);
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
      return other instanceof MesBuildingNestingTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $nestingChargePerson = this.getNestingChargePerson();
      result = result * 59 + ($nestingChargePerson == null ? 43 : $nestingChargePerson.hashCode());
      Object $boolDrillHole = this.getBoolDrillHole();
      result = result * 59 + ($boolDrillHole == null ? 43 : $boolDrillHole.hashCode());
      Object $company = this.getCompany();
      result = result * 59 + ($company == null ? 43 : $company.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $nestingChargePersonName = this.getNestingChargePersonName();
      result = result * 59 + ($nestingChargePersonName == null ? 43 : $nestingChargePersonName.hashCode());
      Object $teamCode = this.getTeamCode();
      return result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingNestingTeamDTO(id="
         + this.getId()
         + ", company="
         + this.getCompany()
         + ", companyName="
         + this.getCompanyName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", nestingChargePerson="
         + this.getNestingChargePerson()
         + ", nestingChargePersonName="
         + this.getNestingChargePersonName()
         + ", teamCode="
         + this.getTeamCode()
         + ", boolDrillHole="
         + this.getBoolDrillHole()
         + ")";
   }

   public static class MesBuildingNestingTeamDTOBuilder {
      private Long id;
      private String company;
      private String companyName;
      private Long workshopId;
      private String workshopName;
      private Long nestingChargePerson;
      private String nestingChargePersonName;
      private String teamCode;
      private Integer boolDrillHole;

      MesBuildingNestingTeamDTOBuilder() {
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder company(final String company) {
         this.company = company;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder companyName(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder nestingChargePerson(final Long nestingChargePerson) {
         this.nestingChargePerson = nestingChargePerson;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder nestingChargePersonName(final String nestingChargePersonName) {
         this.nestingChargePersonName = nestingChargePersonName;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public MesBuildingNestingTeamDTO build() {
         return new MesBuildingNestingTeamDTO(
            this.id,
            this.company,
            this.companyName,
            this.workshopId,
            this.workshopName,
            this.nestingChargePerson,
            this.nestingChargePersonName,
            this.teamCode,
            this.boolDrillHole
         );
      }

      @Override
      public String toString() {
         return "MesBuildingNestingTeamDTO.MesBuildingNestingTeamDTOBuilder(id="
            + this.id
            + ", company="
            + this.company
            + ", companyName="
            + this.companyName
            + ", workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", nestingChargePerson="
            + this.nestingChargePerson
            + ", nestingChargePersonName="
            + this.nestingChargePersonName
            + ", teamCode="
            + this.teamCode
            + ", boolDrillHole="
            + this.boolDrillHole
            + ")";
      }
   }
}
