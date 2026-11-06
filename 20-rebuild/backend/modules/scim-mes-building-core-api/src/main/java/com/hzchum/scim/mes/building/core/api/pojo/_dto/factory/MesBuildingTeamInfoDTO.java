package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("班组信息DTO")
public class MesBuildingTeamInfoDTO extends MesBuildingTeam {
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("工厂")
   private ShowInfo factory;
   @ApiModelProperty("车间")
   private ShowInfo workshop;
   @ApiModelProperty("生产线")
   private ShowInfo productionLine;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("操作人")
   private ShowInfo user;
   @ApiModelProperty("成员List")
   private List<MesBuildingTeamUserLinkDTO> memberList;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTeamInfoDTO)) {
         return false;
      }

      MesBuildingTeamInfoDTO other = (MesBuildingTeamInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$factory = this.getFactory();
         Object other$factory = other.getFactory();
         if (this$factory == null ? other$factory == null : this$factory.equals(other$factory)) {
            Object this$workshop = this.getWorkshop();
            Object other$workshop = other.getWorkshop();
            if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
               Object this$productionLine = this.getProductionLine();
               Object other$productionLine = other.getProductionLine();
               if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                  Object this$process = this.getProcess();
                  Object other$process = other.getProcess();
                  if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                     Object this$user = this.getUser();
                     Object other$user = other.getUser();
                     if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                        Object this$memberList = this.getMemberList();
                        Object other$memberList = other.getMemberList();
                        return this$memberList == null ? other$memberList == null : this$memberList.equals(other$memberList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTeamInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $memberList = this.getMemberList();
      return result * 59 + ($memberList == null ? 43 : $memberList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTeamInfoDTO(super="
         + super.toString()
         + ", name="
         + this.getName()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", process="
         + this.getProcess()
         + ", user="
         + this.getUser()
         + ", memberList="
         + this.getMemberList()
         + ")";
   }

   public String getName() {
      return this.name;
   }

   public ShowInfo getFactory() {
      return this.factory;
   }

   public ShowInfo getWorkshop() {
      return this.workshop;
   }

   public ShowInfo getProductionLine() {
      return this.productionLine;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public ShowInfo getUser() {
      return this.user;
   }

   public List<MesBuildingTeamUserLinkDTO> getMemberList() {
      return this.memberList;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFactory(final ShowInfo factory) {
      this.factory = factory;
   }

   public void setWorkshop(final ShowInfo workshop) {
      this.workshop = workshop;
   }

   public void setProductionLine(final ShowInfo productionLine) {
      this.productionLine = productionLine;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setUser(final ShowInfo user) {
      this.user = user;
   }

   public void setMemberList(final List<MesBuildingTeamUserLinkDTO> memberList) {
      this.memberList = memberList;
   }
}
