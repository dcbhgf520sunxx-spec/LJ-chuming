package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("项目列表查询条件类")
public class ProjectListQueryParam {
   @ApiModelProperty("用户id")
   Long userId;
   @ApiModelProperty("项目状态 1进行中 2暂停 4完工")
   Integer status;
   @ApiModelProperty("结算状态 0未结算 1已结算")
   Integer settlementStatus;
   @ApiModelProperty("年份 例2021")
   Integer year;
   @ApiModelProperty("项目名称或编号")
   String noOrProjectName;
   @ApiModelProperty("项目经理或者销售名字")
   String signerName;
   @ApiModelProperty("业务类型 1生产加工 2项目承包")
   Integer businessType;
   @ApiModelProperty("项目类型1建钢 2桥梁 4立体停车库")
   Integer projectType;
   @ApiModelProperty("项目内容id")
   Long projectContentId;
   @ApiModelProperty("签约主体id")
   Long contractSignBodyId;
   @ApiModelProperty("项目出库(安装)完成状态  1出库(安装)完成 0未完成")
   Boolean outFinishStatus;
   @Deprecated
   @ApiModelProperty("结构类型")
   Integer structureStatus;
   @ApiModelProperty("项目属性: 1.自营 2.合营 3.包干制 参考枚举：ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty("项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @ApiModelProperty("装配式建筑 1.是  0.否")
   private Integer isBuilding;
   @ApiModelProperty(name = "isEffective", notes = "合同是否有效  1.有效 0.无效")
   private Integer isEffective;
   @ApiModelProperty(name = "address", notes = "项目地址")
   private String address;
   @ApiModelProperty(name = "customerUnit", notes = "客户名称")
   private String customerUnit;
   @ApiModelProperty(name = "structureTypeId", value = "结构类型id")
   private Long structureTypeId;
   @ApiModelProperty("创建时间")
   LocalDate yearDate;
   @ApiModelProperty("分支机构")
   Long branchCompanyId;

   public Long getUserId() {
      return this.userId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getYear() {
      return this.year;
   }

   public String getNoOrProjectName() {
      return this.noOrProjectName;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Long getProjectContentId() {
      return this.projectContentId;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public Boolean getOutFinishStatus() {
      return this.outFinishStatus;
   }

   @Deprecated
   public Integer getStructureStatus() {
      return this.structureStatus;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public Integer getIsBuilding() {
      return this.isBuilding;
   }

   public Integer getIsEffective() {
      return this.isEffective;
   }

   public String getAddress() {
      return this.address;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public Long getStructureTypeId() {
      return this.structureTypeId;
   }

   public LocalDate getYearDate() {
      return this.yearDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setNoOrProjectName(final String noOrProjectName) {
      this.noOrProjectName = noOrProjectName;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProjectContentId(final Long projectContentId) {
      this.projectContentId = projectContentId;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setOutFinishStatus(final Boolean outFinishStatus) {
      this.outFinishStatus = outFinishStatus;
   }

   @Deprecated
   public void setStructureStatus(final Integer structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setIsBuilding(final Integer isBuilding) {
      this.isBuilding = isBuilding;
   }

   public void setIsEffective(final Integer isEffective) {
      this.isEffective = isEffective;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setStructureTypeId(final Long structureTypeId) {
      this.structureTypeId = structureTypeId;
   }

   public void setYearDate(final LocalDate yearDate) {
      this.yearDate = yearDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectListQueryParam)) {
         return false;
      }

      ProjectListQueryParam other = (ProjectListQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$settlementStatus = this.getSettlementStatus();
            Object other$settlementStatus = other.getSettlementStatus();
            if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
               Object this$year = this.getYear();
               Object other$year = other.getYear();
               if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                     Object this$projectType = this.getProjectType();
                     Object other$projectType = other.getProjectType();
                     if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                        Object this$projectContentId = this.getProjectContentId();
                        Object other$projectContentId = other.getProjectContentId();
                        if (this$projectContentId == null ? other$projectContentId == null : this$projectContentId.equals(other$projectContentId)) {
                           Object this$contractSignBodyId = this.getContractSignBodyId();
                           Object other$contractSignBodyId = other.getContractSignBodyId();
                           if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                              Object this$outFinishStatus = this.getOutFinishStatus();
                              Object other$outFinishStatus = other.getOutFinishStatus();
                              if (this$outFinishStatus == null ? other$outFinishStatus == null : this$outFinishStatus.equals(other$outFinishStatus)) {
                                 Object this$structureStatus = this.getStructureStatus();
                                 Object other$structureStatus = other.getStructureStatus();
                                 if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
                                    Object this$projectAttribute = this.getProjectAttribute();
                                    Object other$projectAttribute = other.getProjectAttribute();
                                    if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                                       Object this$orderSourceType = this.getOrderSourceType();
                                       Object other$orderSourceType = other.getOrderSourceType();
                                       if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                                          Object this$isBuilding = this.getIsBuilding();
                                          Object other$isBuilding = other.getIsBuilding();
                                          if (this$isBuilding == null ? other$isBuilding == null : this$isBuilding.equals(other$isBuilding)) {
                                             Object this$isEffective = this.getIsEffective();
                                             Object other$isEffective = other.getIsEffective();
                                             if (this$isEffective == null ? other$isEffective == null : this$isEffective.equals(other$isEffective)) {
                                                Object this$structureTypeId = this.getStructureTypeId();
                                                Object other$structureTypeId = other.getStructureTypeId();
                                                if (this$structureTypeId == null
                                                   ? other$structureTypeId == null
                                                   : this$structureTypeId.equals(other$structureTypeId)) {
                                                   Object this$branchCompanyId = this.getBranchCompanyId();
                                                   Object other$branchCompanyId = other.getBranchCompanyId();
                                                   if (this$branchCompanyId == null
                                                      ? other$branchCompanyId == null
                                                      : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                      Object this$noOrProjectName = this.getNoOrProjectName();
                                                      Object other$noOrProjectName = other.getNoOrProjectName();
                                                      if (this$noOrProjectName == null
                                                         ? other$noOrProjectName == null
                                                         : this$noOrProjectName.equals(other$noOrProjectName)) {
                                                         Object this$signerName = this.getSignerName();
                                                         Object other$signerName = other.getSignerName();
                                                         if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                                                            Object this$address = this.getAddress();
                                                            Object other$address = other.getAddress();
                                                            if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                               Object this$customerUnit = this.getCustomerUnit();
                                                               Object other$customerUnit = other.getCustomerUnit();
                                                               if (this$customerUnit == null
                                                                  ? other$customerUnit == null
                                                                  : this$customerUnit.equals(other$customerUnit)) {
                                                                  Object this$yearDate = this.getYearDate();
                                                                  Object other$yearDate = other.getYearDate();
                                                                  return this$yearDate == null ? other$yearDate == null : this$yearDate.equals(other$yearDate);
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
      return other instanceof ProjectListQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $projectContentId = this.getProjectContentId();
      result = result * 59 + ($projectContentId == null ? 43 : $projectContentId.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $outFinishStatus = this.getOutFinishStatus();
      result = result * 59 + ($outFinishStatus == null ? 43 : $outFinishStatus.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $isEffective = this.getIsEffective();
      result = result * 59 + ($isEffective == null ? 43 : $isEffective.hashCode());
      Object $structureTypeId = this.getStructureTypeId();
      result = result * 59 + ($structureTypeId == null ? 43 : $structureTypeId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $noOrProjectName = this.getNoOrProjectName();
      result = result * 59 + ($noOrProjectName == null ? 43 : $noOrProjectName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $yearDate = this.getYearDate();
      return result * 59 + ($yearDate == null ? 43 : $yearDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectListQueryParam(userId="
         + this.getUserId()
         + ", status="
         + this.getStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", year="
         + this.getYear()
         + ", noOrProjectName="
         + this.getNoOrProjectName()
         + ", signerName="
         + this.getSignerName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", projectContentId="
         + this.getProjectContentId()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", outFinishStatus="
         + this.getOutFinishStatus()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", isEffective="
         + this.getIsEffective()
         + ", address="
         + this.getAddress()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", structureTypeId="
         + this.getStructureTypeId()
         + ", yearDate="
         + this.getYearDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }
}
