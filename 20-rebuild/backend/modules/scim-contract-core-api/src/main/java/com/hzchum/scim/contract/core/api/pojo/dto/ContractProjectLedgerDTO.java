package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel("项目执行台账 返回类")
public class ContractProjectLedgerDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "serial_number", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", notes = "项目名称")
   private String name;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty(name = "business_type", notes = "业务类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "project_type", notes = "项目类型 1建筑钢结构 2桥梁钢结构  4围护材料")
   private Integer projectType;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", notes = "合同签订主体")
   private String contractSignBodyName;
   @ApiModelProperty(name = "settlementStatus", notes = "结算状态")
   private Integer settlementStatus;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名字")
   private String projectManagerName;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", notes = "销售负责人名字")
   private String salesLeaderName;
   @ApiModelProperty(name = "status", notes = "状态 1进行中 2暂停 4已完工 8已结算")
   private Integer status;
   @ApiModelProperty(name = "structureMeasureMode", notes = "结构计量方式")
   private Integer structureMeasureMode;
   @ApiModelProperty(name = "enclosureMeasureMode", notes = "围护计量方式")
   private Integer enclosureMeasureMode;
   @ApiModelProperty(name = "signer_id", notes = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signerName", notes = "签约人姓名")
   private String signerName;
   @ApiModelProperty(name = "signing_date", notes = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "managementFeeRate", notes = "管理费率（%）")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "settlementAmount", notes = "结算金额（元）")
   private BigDecimal settlementAmount;
   @ApiModelProperty(name = "collectionAmount", notes = "已收款金额（元）")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "invoiceAmount", value = "开票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "collectionRatio", notes = "收款比例")
   private BigDecimal collectionRate;
   @ApiModelProperty(name = "invoiceRate", value = "开票比例")
   private BigDecimal invoiceRate;
   @ApiModelProperty(name = "customerUnit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "deliverInstallAmount", value = "发生额")
   private BigDecimal deliverInstallAmount;
   private BigDecimal happenedAmount;
   @ApiModelProperty(name = "availableBalance", value = "可用余额")
   private BigDecimal availableBalance;
   @ApiModelProperty(name = "createTime", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "isTax", notes = "合同额是否含税 1是 0否")
   private Integer isTax;
   @ApiModelProperty(name = "invoiceType", notes = "发票类型 1 增值税专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "payType", notes = "支付方式  1.对公转账 2对私转账 4承兑汇票 8转账支票 ")
   private Integer payType;
   @ApiModelProperty(name = "tax_rate", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty("未审核收款数")
   private Integer unCheckCollectionCount;
   @ApiModelProperty("未审核开票数")
   private Integer unCheckInvoiceCount;
   @ApiModelProperty(name = "contractType", notes = "选择类型 1.主合同 2.工程量增补合同 3.补充合同 参考枚举：ContractTypeEnum")
   private Integer contractType;
   @ApiModelProperty(name = "contractDefinitionType", notes = "合同定义枚举 参考枚举：ContractDefinitionTypeEnum")
   private Integer contractDefinitionType;

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

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getContractSignBodyId() {
      return this.contractSignBodyId;
   }

   public String getContractSignBodyName() {
      return this.contractSignBodyName;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getCollectionRate() {
      return this.collectionRate;
   }

   public BigDecimal getInvoiceRate() {
      return this.invoiceRate;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public BigDecimal getDeliverInstallAmount() {
      return this.deliverInstallAmount;
   }

   public BigDecimal getHappenedAmount() {
      return this.happenedAmount;
   }

   public BigDecimal getAvailableBalance() {
      return this.availableBalance;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getIsTax() {
      return this.isTax;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getPayType() {
      return this.payType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getUnCheckCollectionCount() {
      return this.unCheckCollectionCount;
   }

   public Integer getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public Integer getContractType() {
      return this.contractType;
   }

   public Integer getContractDefinitionType() {
      return this.contractDefinitionType;
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

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setContractSignBodyId(final Long contractSignBodyId) {
      this.contractSignBodyId = contractSignBodyId;
   }

   public void setContractSignBodyName(final String contractSignBodyName) {
      this.contractSignBodyName = contractSignBodyName;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setCollectionRate(final BigDecimal collectionRate) {
      this.collectionRate = collectionRate;
   }

   public void setInvoiceRate(final BigDecimal invoiceRate) {
      this.invoiceRate = invoiceRate;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setDeliverInstallAmount(final BigDecimal deliverInstallAmount) {
      this.deliverInstallAmount = deliverInstallAmount;
   }

   public void setHappenedAmount(final BigDecimal happenedAmount) {
      this.happenedAmount = happenedAmount;
   }

   public void setAvailableBalance(final BigDecimal availableBalance) {
      this.availableBalance = availableBalance;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setIsTax(final Integer isTax) {
      this.isTax = isTax;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setPayType(final Integer payType) {
      this.payType = payType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setUnCheckCollectionCount(final Integer unCheckCollectionCount) {
      this.unCheckCollectionCount = unCheckCollectionCount;
   }

   public void setUnCheckInvoiceCount(final Integer unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public void setContractType(final Integer contractType) {
      this.contractType = contractType;
   }

   public void setContractDefinitionType(final Integer contractDefinitionType) {
      this.contractDefinitionType = contractDefinitionType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectLedgerDTO)) {
         return false;
      }

      ContractProjectLedgerDTO other = (ContractProjectLedgerDTO)o;
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
               Object this$projectAttribute = this.getProjectAttribute();
               Object other$projectAttribute = other.getProjectAttribute();
               if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
                  Object this$contractSignBodyId = this.getContractSignBodyId();
                  Object other$contractSignBodyId = other.getContractSignBodyId();
                  if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                     Object this$settlementStatus = this.getSettlementStatus();
                     Object other$settlementStatus = other.getSettlementStatus();
                     if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$salesLeaderId = this.getSalesLeaderId();
                           Object other$salesLeaderId = other.getSalesLeaderId();
                           if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$structureMeasureMode = this.getStructureMeasureMode();
                                 Object other$structureMeasureMode = other.getStructureMeasureMode();
                                 if (this$structureMeasureMode == null
                                    ? other$structureMeasureMode == null
                                    : this$structureMeasureMode.equals(other$structureMeasureMode)) {
                                    Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
                                    Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
                                    if (this$enclosureMeasureMode == null
                                       ? other$enclosureMeasureMode == null
                                       : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                                       Object this$signerId = this.getSignerId();
                                       Object other$signerId = other.getSignerId();
                                       if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                                          Object this$isTax = this.getIsTax();
                                          Object other$isTax = other.getIsTax();
                                          if (this$isTax == null ? other$isTax == null : this$isTax.equals(other$isTax)) {
                                             Object this$invoiceType = this.getInvoiceType();
                                             Object other$invoiceType = other.getInvoiceType();
                                             if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                                Object this$payType = this.getPayType();
                                                Object other$payType = other.getPayType();
                                                if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                                                   Object this$unCheckCollectionCount = this.getUnCheckCollectionCount();
                                                   Object other$unCheckCollectionCount = other.getUnCheckCollectionCount();
                                                   if (this$unCheckCollectionCount == null
                                                      ? other$unCheckCollectionCount == null
                                                      : this$unCheckCollectionCount.equals(other$unCheckCollectionCount)) {
                                                      Object this$unCheckInvoiceCount = this.getUnCheckInvoiceCount();
                                                      Object other$unCheckInvoiceCount = other.getUnCheckInvoiceCount();
                                                      if (this$unCheckInvoiceCount == null
                                                         ? other$unCheckInvoiceCount == null
                                                         : this$unCheckInvoiceCount.equals(other$unCheckInvoiceCount)) {
                                                         Object this$contractType = this.getContractType();
                                                         Object other$contractType = other.getContractType();
                                                         if (this$contractType == null
                                                            ? other$contractType == null
                                                            : this$contractType.equals(other$contractType)) {
                                                            Object this$contractDefinitionType = this.getContractDefinitionType();
                                                            Object other$contractDefinitionType = other.getContractDefinitionType();
                                                            if (this$contractDefinitionType == null
                                                               ? other$contractDefinitionType == null
                                                               : this$contractDefinitionType.equals(other$contractDefinitionType)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$name = this.getName();
                                                                  Object other$name = other.getName();
                                                                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                     Object this$shortName = this.getShortName();
                                                                     Object other$shortName = other.getShortName();
                                                                     if (this$shortName == null
                                                                        ? other$shortName == null
                                                                        : this$shortName.equals(other$shortName)) {
                                                                        Object this$contractSignBodyName = this.getContractSignBodyName();
                                                                        Object other$contractSignBodyName = other.getContractSignBodyName();
                                                                        if (this$contractSignBodyName == null
                                                                           ? other$contractSignBodyName == null
                                                                           : this$contractSignBodyName.equals(other$contractSignBodyName)) {
                                                                           Object this$projectManagerName = this.getProjectManagerName();
                                                                           Object other$projectManagerName = other.getProjectManagerName();
                                                                           if (this$projectManagerName == null
                                                                              ? other$projectManagerName == null
                                                                              : this$projectManagerName.equals(other$projectManagerName)) {
                                                                              Object this$salesLeaderName = this.getSalesLeaderName();
                                                                              Object other$salesLeaderName = other.getSalesLeaderName();
                                                                              if (this$salesLeaderName == null
                                                                                 ? other$salesLeaderName == null
                                                                                 : this$salesLeaderName.equals(other$salesLeaderName)) {
                                                                                 Object this$signerName = this.getSignerName();
                                                                                 Object other$signerName = other.getSignerName();
                                                                                 if (this$signerName == null
                                                                                    ? other$signerName == null
                                                                                    : this$signerName.equals(other$signerName)) {
                                                                                    Object this$signingDate = this.getSigningDate();
                                                                                    Object other$signingDate = other.getSigningDate();
                                                                                    if (this$signingDate == null
                                                                                       ? other$signingDate == null
                                                                                       : this$signingDate.equals(other$signingDate)) {
                                                                                       Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                       Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                       if (this$managementFeeRate == null
                                                                                          ? other$managementFeeRate == null
                                                                                          : this$managementFeeRate.equals(other$managementFeeRate)) {
                                                                                          Object this$contractAmount = this.getContractAmount();
                                                                                          Object other$contractAmount = other.getContractAmount();
                                                                                          if (this$contractAmount == null
                                                                                             ? other$contractAmount == null
                                                                                             : this$contractAmount.equals(other$contractAmount)) {
                                                                                             Object this$settlementAmount = this.getSettlementAmount();
                                                                                             Object other$settlementAmount = other.getSettlementAmount();
                                                                                             if (this$settlementAmount == null
                                                                                                ? other$settlementAmount == null
                                                                                                : this$settlementAmount.equals(other$settlementAmount)) {
                                                                                                Object this$collectionAmount = this.getCollectionAmount();
                                                                                                Object other$collectionAmount = other.getCollectionAmount();
                                                                                                if (this$collectionAmount == null
                                                                                                   ? other$collectionAmount == null
                                                                                                   : this$collectionAmount.equals(other$collectionAmount)) {
                                                                                                   Object this$invoiceAmount = this.getInvoiceAmount();
                                                                                                   Object other$invoiceAmount = other.getInvoiceAmount();
                                                                                                   if (this$invoiceAmount == null
                                                                                                      ? other$invoiceAmount == null
                                                                                                      : this$invoiceAmount.equals(other$invoiceAmount)) {
                                                                                                      Object this$collectionRate = this.getCollectionRate();
                                                                                                      Object other$collectionRate = other.getCollectionRate();
                                                                                                      if (this$collectionRate == null
                                                                                                         ? other$collectionRate == null
                                                                                                         : this$collectionRate.equals(other$collectionRate)) {
                                                                                                         Object this$invoiceRate = this.getInvoiceRate();
                                                                                                         Object other$invoiceRate = other.getInvoiceRate();
                                                                                                         if (this$invoiceRate == null
                                                                                                            ? other$invoiceRate == null
                                                                                                            : this$invoiceRate.equals(other$invoiceRate)) {
                                                                                                            Object this$customerUnit = this.getCustomerUnit();
                                                                                                            Object other$customerUnit = other.getCustomerUnit();
                                                                                                            if (this$customerUnit == null
                                                                                                               ? other$customerUnit == null
                                                                                                               : this$customerUnit.equals(other$customerUnit)) {
                                                                                                               Object this$deliverInstallAmount = this.getDeliverInstallAmount();
                                                                                                               Object other$deliverInstallAmount = other.getDeliverInstallAmount();
                                                                                                               if (this$deliverInstallAmount == null
                                                                                                                  ? other$deliverInstallAmount == null
                                                                                                                  : this$deliverInstallAmount.equals(
                                                                                                                     other$deliverInstallAmount
                                                                                                                  )) {
                                                                                                                  Object this$happenedAmount = this.getHappenedAmount();
                                                                                                                  Object other$happenedAmount = other.getHappenedAmount();
                                                                                                                  if (this$happenedAmount == null
                                                                                                                     ? other$happenedAmount == null
                                                                                                                     : this$happenedAmount.equals(
                                                                                                                        other$happenedAmount
                                                                                                                     )) {
                                                                                                                     Object this$availableBalance = this.getAvailableBalance();
                                                                                                                     Object other$availableBalance = other.getAvailableBalance();
                                                                                                                     if (this$availableBalance == null
                                                                                                                        ? other$availableBalance == null
                                                                                                                        : this$availableBalance.equals(
                                                                                                                           other$availableBalance
                                                                                                                        )) {
                                                                                                                        Object this$createTime = this.getCreateTime();
                                                                                                                        Object other$createTime = other.getCreateTime();
                                                                                                                        if (this$createTime == null
                                                                                                                           ? other$createTime == null
                                                                                                                           : this$createTime.equals(
                                                                                                                              other$createTime
                                                                                                                           )) {
                                                                                                                           Object this$taxRate = this.getTaxRate();
                                                                                                                           Object other$taxRate = other.getTaxRate();
                                                                                                                           return this$taxRate == null
                                                                                                                              ? other$taxRate == null
                                                                                                                              : this$taxRate.equals(
                                                                                                                                 other$taxRate
                                                                                                                              );
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
      return other instanceof ContractProjectLedgerDTO;
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
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $isTax = this.getIsTax();
      result = result * 59 + ($isTax == null ? 43 : $isTax.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $unCheckCollectionCount = this.getUnCheckCollectionCount();
      result = result * 59 + ($unCheckCollectionCount == null ? 43 : $unCheckCollectionCount.hashCode());
      Object $unCheckInvoiceCount = this.getUnCheckInvoiceCount();
      result = result * 59 + ($unCheckInvoiceCount == null ? 43 : $unCheckInvoiceCount.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $contractDefinitionType = this.getContractDefinitionType();
      result = result * 59 + ($contractDefinitionType == null ? 43 : $contractDefinitionType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $collectionRate = this.getCollectionRate();
      result = result * 59 + ($collectionRate == null ? 43 : $collectionRate.hashCode());
      Object $invoiceRate = this.getInvoiceRate();
      result = result * 59 + ($invoiceRate == null ? 43 : $invoiceRate.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $deliverInstallAmount = this.getDeliverInstallAmount();
      result = result * 59 + ($deliverInstallAmount == null ? 43 : $deliverInstallAmount.hashCode());
      Object $happenedAmount = this.getHappenedAmount();
      result = result * 59 + ($happenedAmount == null ? 43 : $happenedAmount.hashCode());
      Object $availableBalance = this.getAvailableBalance();
      result = result * 59 + ($availableBalance == null ? 43 : $availableBalance.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $taxRate = this.getTaxRate();
      return result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectLedgerDTO(id="
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
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", status="
         + this.getStatus()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", signingDate="
         + this.getSigningDate()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", collectionRate="
         + this.getCollectionRate()
         + ", invoiceRate="
         + this.getInvoiceRate()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", deliverInstallAmount="
         + this.getDeliverInstallAmount()
         + ", happenedAmount="
         + this.getHappenedAmount()
         + ", availableBalance="
         + this.getAvailableBalance()
         + ", createTime="
         + this.getCreateTime()
         + ", isTax="
         + this.getIsTax()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", payType="
         + this.getPayType()
         + ", taxRate="
         + this.getTaxRate()
         + ", unCheckCollectionCount="
         + this.getUnCheckCollectionCount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ", contractType="
         + this.getContractType()
         + ", contractDefinitionType="
         + this.getContractDefinitionType()
         + ")";
   }
}
