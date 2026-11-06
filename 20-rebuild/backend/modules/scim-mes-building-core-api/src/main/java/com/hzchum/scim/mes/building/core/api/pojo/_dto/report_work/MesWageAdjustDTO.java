package com.hzchum.scim.mes.building.core.api.pojo._dto.report_work;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("工价调整DTO")
public class MesWageAdjustDTO extends MesWageAdjust {
   @ApiModelProperty("总数量")
   private BigDecimal totalQuantity;
   @ApiModelProperty("总重量")
   private BigDecimal totalWeight;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("车间")
   private NameInfo workshop;
   @ApiModelProperty("工序")
   private NameInfo process;
   @ApiModelProperty("创建人")
   private NameInfo createUser;
   @ApiModelProperty("审批人")
   private NameInfo approveUser;
   private List<Long> teamIdList;
   @ApiModelProperty("班组列表")
   private List<NameInfo> teamList;
   @ApiModelProperty("产品列表")
   private List<MesWageAdjustProductDTO> productList;
   @ApiModelProperty("审批信息")
   private WmsApproveRecordFlowDTO approveRecord;

   public List<Long> getTeamIdList() {
      return CollUtil.isEmpty(this.teamIdList) && StrUtil.isNotBlank(super.getTeamIds())
         ? Convert.toList(Long.class, super.getTeamIds().split(","))
         : this.teamIdList;
   }

   public BigDecimal getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getWorkshop() {
      return this.workshop;
   }

   public NameInfo getProcess() {
      return this.process;
   }

   public NameInfo getCreateUser() {
      return this.createUser;
   }

   public NameInfo getApproveUser() {
      return this.approveUser;
   }

   public List<NameInfo> getTeamList() {
      return this.teamList;
   }

   public List<MesWageAdjustProductDTO> getProductList() {
      return this.productList;
   }

   public WmsApproveRecordFlowDTO getApproveRecord() {
      return this.approveRecord;
   }

   public void setTotalQuantity(final BigDecimal totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setWorkshop(final NameInfo workshop) {
      this.workshop = workshop;
   }

   public void setProcess(final NameInfo process) {
      this.process = process;
   }

   public void setCreateUser(final NameInfo createUser) {
      this.createUser = createUser;
   }

   public void setApproveUser(final NameInfo approveUser) {
      this.approveUser = approveUser;
   }

   public void setTeamIdList(final List<Long> teamIdList) {
      this.teamIdList = teamIdList;
   }

   public void setTeamList(final List<NameInfo> teamList) {
      this.teamList = teamList;
   }

   public void setProductList(final List<MesWageAdjustProductDTO> productList) {
      this.productList = productList;
   }

   public void setApproveRecord(final WmsApproveRecordFlowDTO approveRecord) {
      this.approveRecord = approveRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustDTO)) {
         return false;
      }

      MesWageAdjustDTO other = (MesWageAdjustDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$totalWeight = this.getTotalWeight();
         Object other$totalWeight = other.getTotalWeight();
         if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$workshop = this.getWorkshop();
                  Object other$workshop = other.getWorkshop();
                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                     Object this$process = this.getProcess();
                     Object other$process = other.getProcess();
                     if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                        Object this$createUser = this.getCreateUser();
                        Object other$createUser = other.getCreateUser();
                        if (this$createUser == null ? other$createUser == null : this$createUser.equals(other$createUser)) {
                           Object this$approveUser = this.getApproveUser();
                           Object other$approveUser = other.getApproveUser();
                           if (this$approveUser == null ? other$approveUser == null : this$approveUser.equals(other$approveUser)) {
                              Object this$teamIdList = this.getTeamIdList();
                              Object other$teamIdList = other.getTeamIdList();
                              if (this$teamIdList == null ? other$teamIdList == null : this$teamIdList.equals(other$teamIdList)) {
                                 Object this$teamList = this.getTeamList();
                                 Object other$teamList = other.getTeamList();
                                 if (this$teamList == null ? other$teamList == null : this$teamList.equals(other$teamList)) {
                                    Object this$productList = this.getProductList();
                                    Object other$productList = other.getProductList();
                                    if (this$productList == null ? other$productList == null : this$productList.equals(other$productList)) {
                                       Object this$approveRecord = this.getApproveRecord();
                                       Object other$approveRecord = other.getApproveRecord();
                                       return this$approveRecord == null ? other$approveRecord == null : this$approveRecord.equals(other$approveRecord);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $createUser = this.getCreateUser();
      result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
      Object $approveUser = this.getApproveUser();
      result = result * 59 + ($approveUser == null ? 43 : $approveUser.hashCode());
      Object $teamIdList = this.getTeamIdList();
      result = result * 59 + ($teamIdList == null ? 43 : $teamIdList.hashCode());
      Object $teamList = this.getTeamList();
      result = result * 59 + ($teamList == null ? 43 : $teamList.hashCode());
      Object $productList = this.getProductList();
      result = result * 59 + ($productList == null ? 43 : $productList.hashCode());
      Object $approveRecord = this.getApproveRecord();
      return result * 59 + ($approveRecord == null ? 43 : $approveRecord.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustDTO(totalQuantity="
         + this.getTotalQuantity()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", workshop="
         + this.getWorkshop()
         + ", process="
         + this.getProcess()
         + ", createUser="
         + this.getCreateUser()
         + ", approveUser="
         + this.getApproveUser()
         + ", teamIdList="
         + this.getTeamIdList()
         + ", teamList="
         + this.getTeamList()
         + ", productList="
         + this.getProductList()
         + ", approveRecord="
         + this.getApproveRecord()
         + ")";
   }
}
