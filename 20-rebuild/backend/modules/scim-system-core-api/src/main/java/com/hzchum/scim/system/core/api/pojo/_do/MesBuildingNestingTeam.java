package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingNestingTeam对象", description = "套料团队码表")
@Entity
@TableName("mes_building_nesting_team")
@Table(name = "mes_building_nesting_team")
public class MesBuildingNestingTeam extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "company", value = "二级单位", notes = "二级单位")
   @TableField("company")
   @Column(name = "company", columnDefinition = "bigint(20)  COMMENT '二级单位'", nullable = false)
   private String company;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "nestingChargePerson", value = "负责人", notes = "负责人")
   @TableField("nesting_charge_person")
   @Column(name = "nesting_charge_person", columnDefinition = "bigint(20)  COMMENT '负责人'", nullable = true)
   private Long nestingChargePerson;
   @ApiModelProperty(name = "teamCode", value = "团队码", notes = "团队码")
   @TableField("team_code")
   @Column(name = "team_code", columnDefinition = "varchar(255)  COMMENT '团队码'", nullable = false)
   private String teamCode;
   @ApiModelProperty(name = "boolDrillHole", value = "是否板启用", notes = "是否板启用")
   @TableField("bool_drill_hole")
   @Column(name = "bool_drill_hole", columnDefinition = "tinyint(1) default '1' COMMENT '是否板启用'", nullable = false)
   private Integer boolDrillHole;

   public static MesBuildingNestingTeam.MesBuildingNestingTeamBuilder builder() {
      return new MesBuildingNestingTeam.MesBuildingNestingTeamBuilder();
   }

   public MesBuildingNestingTeam() {
   }

   public MesBuildingNestingTeam(
      final Long id, final String company, final Long workshopId, final Long nestingChargePerson, final String teamCode, final Integer boolDrillHole
   ) {
      this.id = id;
      this.company = company;
      this.workshopId = workshopId;
      this.nestingChargePerson = nestingChargePerson;
      this.teamCode = teamCode;
      this.boolDrillHole = boolDrillHole;
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

   public MesBuildingNestingTeam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingNestingTeam setCompany(final String company) {
      this.company = company;
      return this;
   }

   public MesBuildingNestingTeam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesBuildingNestingTeam setNestingChargePerson(final Long nestingChargePerson) {
      this.nestingChargePerson = nestingChargePerson;
      return this;
   }

   public MesBuildingNestingTeam setTeamCode(final String teamCode) {
      this.teamCode = teamCode;
      return this;
   }

   public MesBuildingNestingTeam setBoolDrillHole(final Integer boolDrillHole) {
      this.boolDrillHole = boolDrillHole;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNestingTeam(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNestingTeam)) {
         return false;
      }

      MesBuildingNestingTeam other = (MesBuildingNestingTeam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingNestingTeam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      return result * 59 + ($teamCode == null ? 43 : $teamCode.hashCode());
   }

   public static class MesBuildingNestingTeamBuilder {
      private Long id;
      private String company;
      private Long workshopId;
      private Long nestingChargePerson;
      private String teamCode;
      private Integer boolDrillHole;

      MesBuildingNestingTeamBuilder() {
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder company(final String company) {
         this.company = company;
         return this;
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder nestingChargePerson(final Long nestingChargePerson) {
         this.nestingChargePerson = nestingChargePerson;
         return this;
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder teamCode(final String teamCode) {
         this.teamCode = teamCode;
         return this;
      }

      public MesBuildingNestingTeam.MesBuildingNestingTeamBuilder boolDrillHole(final Integer boolDrillHole) {
         this.boolDrillHole = boolDrillHole;
         return this;
      }

      public MesBuildingNestingTeam build() {
         return new MesBuildingNestingTeam(this.id, this.company, this.workshopId, this.nestingChargePerson, this.teamCode, this.boolDrillHole);
      }

      @Override
      public String toString() {
         return "MesBuildingNestingTeam.MesBuildingNestingTeamBuilder(id="
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
            + ")";
      }
   }
}
