package com.hzchum.scim.system.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "团队码配置 ")
public class MesBuildingNestingTeamVO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("二级单位")
   private String company;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("负责人")
   private Long nestingChargePerson;
   @ApiModelProperty("团队码")
   private String teamCode;
   @ApiModelProperty("是否板启用")
   private Integer boolDrillHole;
   @ApiModelProperty("id集合")
   private List<Long> ids;

   public static MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder builder() {
      return new MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder();
   }

   public MesBuildingNestingTeamVO() {
   }

   public MesBuildingNestingTeamVO(
      final Long id,
      final String company,
      final Long workshopId,
      final Long nestingChargePerson,
      final String teamCode,
      final Integer boolDrillHole,
      final List<Long> ids
   ) {
      this.id = id;
      this.company = company;
      this.workshopId = workshopId;
      this.nestingChargePerson = nestingChargePerson;
      this.teamCode = teamCode;
      this.boolDrillHole = boolDrillHole;
      this.ids = ids;
   }

   public Long getId() {
      return this.id;
   }

   public String getCompany() {
      return this.company;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getNestingChargePerson() {
      return this.nestingChargePerson;
   }

   public String getTeamCode() {
      return this.teamCode;
   }

   public Integer getBoolDrillHole() {
      return this.boolDrillHole;
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCompany(final String company) {
      this.company = company;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setNestingChargePerson(final Long nestingChargePerson) {
      this.nestingChargePerson = nestingChargePerson;
   }

   public void setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
   }

   public void setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingTeamVO)) {
         return false;
      }

      MesBuildingNestingTeamVO other = (MesBuildingNestingTeamVO)o;
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
                     Object this$teamCode = this.getTeamCode();
                     Object other$teamCode = other.getTeamCode();
                     if (this$teamCode == null ? other$teamCode == null : this$teamCode.equals(other$teamCode)) {
                        Object this$ids = this.getIds();
                        Object other$ids = other.getIds();
                        return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
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
      return other instanceof MesBuildingNestingTeamVO;
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
      Object $teamCode = this.getTeamCode();
      result = result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingNestingTeamVO(id="
         + this.getId()
         + ", company="
         + this.getCompany()
         + ", workshopId="
         + this.getWorkshopId()
         + ", nestingChargePerson="
         + this.getNestingChargePerson()
         + ", teamCode="
         + this.getTeamCode()
         + ", boolDrillHole="
         + this.getBoolDrillHole()
         + ", ids="
         + this.getIds()
         + ")";
   }

   public static class MesBuildingNestingTeamVOBuilder {
      private Long id;
      private String company;
      private Long workshopId;
      private Long nestingChargePerson;
      private String teamCode;
      private Integer boolDrillHole;
      private List<Long> ids;

      MesBuildingNestingTeamVOBuilder() {
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder company(final String company) {
         this.company = company;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder nestingChargePerson(final Long nestingChargePerson) {
         this.nestingChargePerson = nestingChargePerson;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public MesBuildingNestingTeamVO build() {
         return new MesBuildingNestingTeamVO(this.id, this.company, this.workshopId, this.nestingChargePerson, this.teamCode, this.boolDrillHole, this.ids);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingTeamVO.MesBuildingNestingTeamVOBuilder(id="
            + this.id
            + ", company="
            + this.company
            + ", workshopId="
            + this.workshopId
            + ", nestingChargePerson="
            + this.nestingChargePerson
            + ", teamCode="
            + this.teamCode
            + ", boolDrillHole="
            + this.boolDrillHole
            + ", ids="
            + this.ids
            + ")";
      }
   }
}
