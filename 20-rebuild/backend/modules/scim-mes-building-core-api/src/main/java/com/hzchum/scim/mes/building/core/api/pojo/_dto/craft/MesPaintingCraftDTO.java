package com.hzchum.scim.mes.building.core.api.pojo._dto.craft;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraftDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("涂装工艺DTO")
public class MesPaintingCraftDTO extends MesPaintingCraft {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("单体idList")
   private List<Long> monomerIdList;
   @ApiModelProperty("单体信息List")
   private List<NameInfo> monomerList;
   @ApiModelProperty("创建人信息")
   private NameInfo createUser;
   @ApiModelProperty("审批人信息")
   private NameInfo approvalUser;
   @ApiModelProperty("审批信息")
   private WmsApproveRecordFlowDTO approveRecord;
   @ApiModelProperty("详情List")
   private List<MesPaintingCraftDetail> detailList;

   public List<Long> getMonomerIdList() {
      return CollUtil.isEmpty(this.monomerIdList) && StrUtil.isNotBlank(super.getMonomerIds())
         ? Convert.toList(Long.class, StrUtil.split(super.getMonomerIds(), ","))
         : this.monomerIdList;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public List<NameInfo> getMonomerList() {
      return this.monomerList;
   }

   public NameInfo getCreateUser() {
      return this.createUser;
   }

   public NameInfo getApprovalUser() {
      return this.approvalUser;
   }

   public WmsApproveRecordFlowDTO getApproveRecord() {
      return this.approveRecord;
   }

   public List<MesPaintingCraftDetail> getDetailList() {
      return this.detailList;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerIdList(final List<Long> monomerIdList) {
      this.monomerIdList = monomerIdList;
   }

   public void setMonomerList(final List<NameInfo> monomerList) {
      this.monomerList = monomerList;
   }

   public void setCreateUser(final NameInfo createUser) {
      this.createUser = createUser;
   }

   public void setApprovalUser(final NameInfo approvalUser) {
      this.approvalUser = approvalUser;
   }

   public void setApproveRecord(final WmsApproveRecordFlowDTO approveRecord) {
      this.approveRecord = approveRecord;
   }

   public void setDetailList(final List<MesPaintingCraftDetail> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraftDTO)) {
         return false;
      }

      MesPaintingCraftDTO other = (MesPaintingCraftDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$monomerIdList = this.getMonomerIdList();
         Object other$monomerIdList = other.getMonomerIdList();
         if (this$monomerIdList == null ? other$monomerIdList == null : this$monomerIdList.equals(other$monomerIdList)) {
            Object this$monomerList = this.getMonomerList();
            Object other$monomerList = other.getMonomerList();
            if (this$monomerList == null ? other$monomerList == null : this$monomerList.equals(other$monomerList)) {
               Object this$createUser = this.getCreateUser();
               Object other$createUser = other.getCreateUser();
               if (this$createUser == null ? other$createUser == null : this$createUser.equals(other$createUser)) {
                  Object this$approvalUser = this.getApprovalUser();
                  Object other$approvalUser = other.getApprovalUser();
                  if (this$approvalUser == null ? other$approvalUser == null : this$approvalUser.equals(other$approvalUser)) {
                     Object this$approveRecord = this.getApproveRecord();
                     Object other$approveRecord = other.getApproveRecord();
                     if (this$approveRecord == null ? other$approveRecord == null : this$approveRecord.equals(other$approveRecord)) {
                        Object this$detailList = this.getDetailList();
                        Object other$detailList = other.getDetailList();
                        return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof MesPaintingCraftDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerIdList = this.getMonomerIdList();
      result = result * 59 + ($monomerIdList == null ? 43 : $monomerIdList.hashCode());
      Object $monomerList = this.getMonomerList();
      result = result * 59 + ($monomerList == null ? 43 : $monomerList.hashCode());
      Object $createUser = this.getCreateUser();
      result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
      Object $approvalUser = this.getApprovalUser();
      result = result * 59 + ($approvalUser == null ? 43 : $approvalUser.hashCode());
      Object $approveRecord = this.getApproveRecord();
      result = result * 59 + ($approveRecord == null ? 43 : $approveRecord.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingCraftDTO(project="
         + this.getProject()
         + ", monomerIdList="
         + this.getMonomerIdList()
         + ", monomerList="
         + this.getMonomerList()
         + ", createUser="
         + this.getCreateUser()
         + ", approvalUser="
         + this.getApprovalUser()
         + ", approveRecord="
         + this.getApproveRecord()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }
}
