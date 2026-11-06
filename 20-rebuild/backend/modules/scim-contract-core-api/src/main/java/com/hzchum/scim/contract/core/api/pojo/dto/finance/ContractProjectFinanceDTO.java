package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("项目业财报表类")
public class ContractProjectFinanceDTO implements Serializable {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "businessType", notes = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectType", notes = "项目类型 1.建钢项目 2.桥梁项目 4.立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @ApiModelProperty(name = "status", notes = "项目状态  1：进行中，2：已暂停，4：已完工 ")
   private Integer status;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "settlementStatus", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty(name = "settlementAmount", notes = "结算额(元)")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "costAmount", notes = "成本金额(元)")
   private BigDecimal costAmount;
   @ApiModelProperty(name = "grossProfit", notes = "毛利润(元)")
   private BigDecimal grossProfit;
   @ApiModelProperty(name = "grossProfitRate", notes = "毛利率")
   private BigDecimal grossProfitRate;
   @ApiModelProperty(name = "collection_amount", notes = "已收款额")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "receivableAmount", notes = "应收金额")
   private BigDecimal receivableAmount;
   @ApiModelProperty(name = "availableBalance", notes = "可用余额")
   private BigDecimal availableBalance;
   @ApiModelProperty(name = "happenedAmount", notes = "已发生额")
   private BigDecimal happenedAmount;
   @ApiModelProperty(name = "settlementAttachments", notes = "结算附件字符串")
   private String settlementAttachmentIds;
   @ApiModelProperty(name = "settlementAttachments", notes = "结算附件列表")
   private List<AttachmentDTO> settlementAttachments;
   @ApiModelProperty(name = "compositeCostDTO", notes = "综合成本对象")
   private ProjectCompositeCostDTO compositeCostDTO;

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getCostAmount() {
      return this.costAmount;
   }

   public BigDecimal getGrossProfit() {
      return this.grossProfit;
   }

   public BigDecimal getGrossProfitRate() {
      return this.grossProfitRate;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getReceivableAmount() {
      return this.receivableAmount;
   }

   public BigDecimal getAvailableBalance() {
      return this.availableBalance;
   }

   public BigDecimal getHappenedAmount() {
      return this.happenedAmount;
   }

   public String getSettlementAttachmentIds() {
      return this.settlementAttachmentIds;
   }

   public List<AttachmentDTO> getSettlementAttachments() {
      return this.settlementAttachments;
   }

   public ProjectCompositeCostDTO getCompositeCostDTO() {
      return this.compositeCostDTO;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCostAmount(final BigDecimal costAmount) {
      this.costAmount = costAmount;
   }

   public void setGrossProfit(final BigDecimal grossProfit) {
      this.grossProfit = grossProfit;
   }

   public void setGrossProfitRate(final BigDecimal grossProfitRate) {
      this.grossProfitRate = grossProfitRate;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setReceivableAmount(final BigDecimal receivableAmount) {
      this.receivableAmount = receivableAmount;
   }

   public void setAvailableBalance(final BigDecimal availableBalance) {
      this.availableBalance = availableBalance;
   }

   public void setHappenedAmount(final BigDecimal happenedAmount) {
      this.happenedAmount = happenedAmount;
   }

   public void setSettlementAttachmentIds(final String settlementAttachmentIds) {
      this.settlementAttachmentIds = settlementAttachmentIds;
   }

   public void setSettlementAttachments(final List<AttachmentDTO> settlementAttachments) {
      this.settlementAttachments = settlementAttachments;
   }

   public void setCompositeCostDTO(final ProjectCompositeCostDTO compositeCostDTO) {
      this.compositeCostDTO = compositeCostDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectFinanceDTO)) {
         return false;
      }

      ContractProjectFinanceDTO other = (ContractProjectFinanceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$orderSourceType = this.getOrderSourceType();
               Object other$orderSourceType = other.getOrderSourceType();
               if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$settlementStatus = this.getSettlementStatus();
                     Object other$settlementStatus = other.getSettlementStatus();
                     if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$shortName = this.getShortName();
                                 Object other$shortName = other.getShortName();
                                 if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                    Object this$contractAmount = this.getContractAmount();
                                    Object other$contractAmount = other.getContractAmount();
                                    if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                       Object this$settlementAmount = this.getSettlementAmount();
                                       Object other$settlementAmount = other.getSettlementAmount();
                                       if (this$settlementAmount == null
                                          ? other$settlementAmount == null
                                          : this$settlementAmount.equals(other$settlementAmount)) {
                                          Object this$costAmount = this.getCostAmount();
                                          Object other$costAmount = other.getCostAmount();
                                          if (this$costAmount == null ? other$costAmount == null : this$costAmount.equals(other$costAmount)) {
                                             Object this$grossProfit = this.getGrossProfit();
                                             Object other$grossProfit = other.getGrossProfit();
                                             if (this$grossProfit == null ? other$grossProfit == null : this$grossProfit.equals(other$grossProfit)) {
                                                Object this$grossProfitRate = this.getGrossProfitRate();
                                                Object other$grossProfitRate = other.getGrossProfitRate();
                                                if (this$grossProfitRate == null
                                                   ? other$grossProfitRate == null
                                                   : this$grossProfitRate.equals(other$grossProfitRate)) {
                                                   Object this$collectionAmount = this.getCollectionAmount();
                                                   Object other$collectionAmount = other.getCollectionAmount();
                                                   if (this$collectionAmount == null
                                                      ? other$collectionAmount == null
                                                      : this$collectionAmount.equals(other$collectionAmount)) {
                                                      Object this$receivableAmount = this.getReceivableAmount();
                                                      Object other$receivableAmount = other.getReceivableAmount();
                                                      if (this$receivableAmount == null
                                                         ? other$receivableAmount == null
                                                         : this$receivableAmount.equals(other$receivableAmount)) {
                                                         Object this$availableBalance = this.getAvailableBalance();
                                                         Object other$availableBalance = other.getAvailableBalance();
                                                         if (this$availableBalance == null
                                                            ? other$availableBalance == null
                                                            : this$availableBalance.equals(other$availableBalance)) {
                                                            Object this$happenedAmount = this.getHappenedAmount();
                                                            Object other$happenedAmount = other.getHappenedAmount();
                                                            if (this$happenedAmount == null
                                                               ? other$happenedAmount == null
                                                               : this$happenedAmount.equals(other$happenedAmount)) {
                                                               Object this$settlementAttachmentIds = this.getSettlementAttachmentIds();
                                                               Object other$settlementAttachmentIds = other.getSettlementAttachmentIds();
                                                               if (this$settlementAttachmentIds == null
                                                                  ? other$settlementAttachmentIds == null
                                                                  : this$settlementAttachmentIds.equals(other$settlementAttachmentIds)) {
                                                                  Object this$settlementAttachments = this.getSettlementAttachments();
                                                                  Object other$settlementAttachments = other.getSettlementAttachments();
                                                                  if (this$settlementAttachments == null
                                                                     ? other$settlementAttachments == null
                                                                     : this$settlementAttachments.equals(other$settlementAttachments)) {
                                                                     Object this$compositeCostDTO = this.getCompositeCostDTO();
                                                                     Object other$compositeCostDTO = other.getCompositeCostDTO();
                                                                     return this$compositeCostDTO == null
                                                                        ? other$compositeCostDTO == null
                                                                        : this$compositeCostDTO.equals(other$compositeCostDTO);
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
      return other instanceof ContractProjectFinanceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $costAmount = this.getCostAmount();
      result = result * 59 + ($costAmount == null ? 43 : $costAmount.hashCode());
      Object $grossProfit = this.getGrossProfit();
      result = result * 59 + ($grossProfit == null ? 43 : $grossProfit.hashCode());
      Object $grossProfitRate = this.getGrossProfitRate();
      result = result * 59 + ($grossProfitRate == null ? 43 : $grossProfitRate.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $receivableAmount = this.getReceivableAmount();
      result = result * 59 + ($receivableAmount == null ? 43 : $receivableAmount.hashCode());
      Object $availableBalance = this.getAvailableBalance();
      result = result * 59 + ($availableBalance == null ? 43 : $availableBalance.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $settlementAttachmentIds = this.getSettlementAttachmentIds();
      result = result * 59 + ($settlementAttachmentIds == null ? 43 : $settlementAttachmentIds.hashCode());
      Object $settlementAttachments = this.getSettlementAttachments();
      result = result * 59 + ($settlementAttachments == null ? 43 : $settlementAttachments.hashCode());
      Object $compositeCostDTO = this.getCompositeCostDTO();
      return result * 59 + ($compositeCostDTO == null ? 43 : $compositeCostDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectFinanceDTO(project="
         + this.getProject()
         + ", id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectType="
         + this.getProjectType()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", status="
         + this.getStatus()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", costAmount="
         + this.getCostAmount()
         + ", grossProfit="
         + this.getGrossProfit()
         + ", grossProfitRate="
         + this.getGrossProfitRate()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", receivableAmount="
         + this.getReceivableAmount()
         + ", availableBalance="
         + this.getAvailableBalance()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", settlementAttachmentIds="
         + this.getSettlementAttachmentIds()
         + ", settlementAttachments="
         + this.getSettlementAttachments()
         + ", compositeCostDTO="
         + this.getCompositeCostDTO()
         + ")";
   }
}
