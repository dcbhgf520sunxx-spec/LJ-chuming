package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel("项目执行台账 返回类")
public class ProjectLedgerDTO {
   @ApiModelProperty(name = "id", value = "项目id")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目返回类")
   private ProjectInfo project;
   @ApiModelProperty(name = "deptName", value = "部门名称")
   private String deptName;
   @ApiModelProperty(name = "business_type", notes = "订单类型 1.加工承揽  2.项目承包")
   private Integer businessType;
   @ApiModelProperty(name = "projectAttribute", notes = "项目属性: 1.自营 2.合营 3.包干制 枚举:ProjectAttributeEnum")
   private Integer projectAttribute;
   @ApiModelProperty(name = "contractSignBodyId", notes = "合同签订主体id")
   private Long contractSignBodyId;
   @ApiModelProperty(name = "contractSignBodyName", notes = "合同签订主体")
   private String contractSignBodyName;
   @ApiModelProperty(name = "projectManagerId", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", notes = "项目经理名字")
   private String projectManagerName;
   @ApiModelProperty(name = "structureArea", notes = "建筑面积")
   private BigDecimal structureArea;
   @ApiModelProperty(name = "salesLeaderId", value = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "salesLeaderName", notes = "签约人名字")
   private String signerName;
   @ApiModelProperty(name = "salesLeaderId", value = "销售负责人id")
   private Long salesLeaderId;
   @ApiModelProperty(name = "salesLeaderName", notes = "销售负责人名字")
   private String salesLeaderName;
   @ApiModelProperty(name = "signing_date", notes = "签订日期")
   private LocalDate signingDate;
   @ApiModelProperty(name = "managementFeeRateId", notes = "管理费率（%）")
   private Long managementFeeRateId;
   @ApiModelProperty(name = "managementFeeRate", notes = "管理费率（%）")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "contractAmount", notes = "合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "settlement_status", notes = "结算状态 0 未结算 1已结算")
   private Integer settlementStatus;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("预结算额")
   private BigDecimal preSettlementAmount;
   @ApiModelProperty(name = "customerUnit", notes = "客户单位名称")
   private String customerUnit;
   @ApiModelProperty(name = "invoiceType", notes = "发票类型 1 增值税专用发票  2普通发票 4收据")
   private Integer invoiceType;
   @ApiModelProperty(name = "payType", notes = "支付方式  1.对公转账 2对私转账 4承兑汇票 8转账支票 ")
   private Integer payType;
   @ApiModelProperty(name = "tax_rate", notes = "发票税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "contractType", notes = "选择类型 1.主合同 2.工程量增补合同 3.补充合同 参考枚举：ContractTypeEnum")
   private Integer contractType;
   @ApiModelProperty(name = "contractDefinitionType", notes = "合同定义枚举 参考枚举：ContractDefinitionTypeEnum")
   private Integer contractDefinitionType;
   @ApiModelProperty(name = "structureStatus", notes = "结构类型")
   private String structureStatus;
   @ApiModelProperty(name = "countryId", notes = "国家")
   private Long countryId;
   @ApiModelProperty(name = "countryName", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceName", notes = "省/洲")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", notes = "省/洲名称")
   private String provinceName;
   @ApiModelProperty(name = "cityId", notes = "市")
   private String cityId;
   @ApiModelProperty(name = "cityName", notes = "市名称")
   private String cityName;
   @ApiModelProperty(name = "address", notes = "客户单位详细地址")
   private String address;
   @ApiModelProperty(name = "partyType", notes = "甲方类型")
   private String partyType;
   @ApiModelProperty(name = "sendingMode", notes = "发包类型")
   private String sendingMode;
   @ApiModelProperty(name = "startDate", notes = "开始日期")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", notes = "结束日期")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "allDays", notes = "工期")
   private Integer allDays;
   @ApiModelProperty(name = "amount", notes = "合同金额（元）")
   private BigDecimal amount;
   @ApiModelProperty(name = "currencyType", value = "币种 (暂时先固定几种) RMB,EUR,USD,JPY")
   private String currencyType;
   @ApiModelProperty(name = "cashDeposit", notes = "保证金（元）")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "margin", notes = "保证金类型")
   private Integer marginType;
   @ApiModelProperty(name = "status", value = "项目状态  1：进行中，2：已暂停，4：已完工")
   private Integer status;
   @ApiModelProperty(name = "technologyClause", notes = "技术条款")
   private String technologyClause;
   @ApiModelProperty(name = "payTypeDesc", notes = "支付方式描述")
   private String payTypeDesc;
   @ApiModelProperty(name = "accumulatedCollection", notes = "累计收款")
   private BigDecimal accumulatedCollection;
   @ApiModelProperty(name = "accumulatedInvoice", notes = "累计开票")
   private BigDecimal accumulatedInvoice;
   @ApiModelProperty(name = "collectionRatio", notes = "收款比例")
   private BigDecimal collectionRatio;
   @ApiModelProperty(name = "invoiceRatio", notes = "开票比例")
   private BigDecimal invoiceRatio;
   @ApiModelProperty(name = "advancesReceived", notes = "预收款")
   private BigDecimal advancesReceived;
   @ApiModelProperty(name = "accumulatedCost", notes = "累计成本")
   private BigDecimal accumulatedCost;
   @ApiModelProperty(name = "availableBalance", notes = "可用余额")
   private BigDecimal availableBalance;
   @ApiModelProperty(name = "createTime", notes = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "level", notes = "单位层级 一级单位 二级单位")
   private Integer level;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public Integer getBusinessType() {
      return this.businessType;
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

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
   }

   public Long getManagementFeeRateId() {
      return this.managementFeeRateId;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
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

   public BigDecimal getPreSettlementAmount() {
      return this.preSettlementAmount;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
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

   public Integer getContractType() {
      return this.contractType;
   }

   public Integer getContractDefinitionType() {
      return this.contractDefinitionType;
   }

   public String getStructureStatus() {
      return this.structureStatus;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public String getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public String getAddress() {
      return this.address;
   }

   public String getPartyType() {
      return this.partyType;
   }

   public String getSendingMode() {
      return this.sendingMode;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public Integer getAllDays() {
      return this.allDays;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getCurrencyType() {
      return this.currencyType;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Integer getMarginType() {
      return this.marginType;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getTechnologyClause() {
      return this.technologyClause;
   }

   public String getPayTypeDesc() {
      return this.payTypeDesc;
   }

   public BigDecimal getAccumulatedCollection() {
      return this.accumulatedCollection;
   }

   public BigDecimal getAccumulatedInvoice() {
      return this.accumulatedInvoice;
   }

   public BigDecimal getCollectionRatio() {
      return this.collectionRatio;
   }

   public BigDecimal getInvoiceRatio() {
      return this.invoiceRatio;
   }

   public BigDecimal getAdvancesReceived() {
      return this.advancesReceived;
   }

   public BigDecimal getAccumulatedCost() {
      return this.accumulatedCost;
   }

   public BigDecimal getAvailableBalance() {
      return this.availableBalance;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Integer getLevel() {
      return this.level;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setDeptName(final String deptName) {
      this.deptName = deptName;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
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

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
   }

   public void setManagementFeeRateId(final Long managementFeeRateId) {
      this.managementFeeRateId = managementFeeRateId;
   }

   public void setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
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

   public void setPreSettlementAmount(final BigDecimal preSettlementAmount) {
      this.preSettlementAmount = preSettlementAmount;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
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

   public void setContractType(final Integer contractType) {
      this.contractType = contractType;
   }

   public void setContractDefinitionType(final Integer contractDefinitionType) {
      this.contractDefinitionType = contractDefinitionType;
   }

   public void setStructureStatus(final String structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityId(final String cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setPartyType(final String partyType) {
      this.partyType = partyType;
   }

   public void setSendingMode(final String sendingMode) {
      this.sendingMode = sendingMode;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
   }

   public void setAllDays(final Integer allDays) {
      this.allDays = allDays;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setMarginType(final Integer marginType) {
      this.marginType = marginType;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setTechnologyClause(final String technologyClause) {
      this.technologyClause = technologyClause;
   }

   public void setPayTypeDesc(final String payTypeDesc) {
      this.payTypeDesc = payTypeDesc;
   }

   public void setAccumulatedCollection(final BigDecimal accumulatedCollection) {
      this.accumulatedCollection = accumulatedCollection;
   }

   public void setAccumulatedInvoice(final BigDecimal accumulatedInvoice) {
      this.accumulatedInvoice = accumulatedInvoice;
   }

   public void setCollectionRatio(final BigDecimal collectionRatio) {
      this.collectionRatio = collectionRatio;
   }

   public void setInvoiceRatio(final BigDecimal invoiceRatio) {
      this.invoiceRatio = invoiceRatio;
   }

   public void setAdvancesReceived(final BigDecimal advancesReceived) {
      this.advancesReceived = advancesReceived;
   }

   public void setAccumulatedCost(final BigDecimal accumulatedCost) {
      this.accumulatedCost = accumulatedCost;
   }

   public void setAvailableBalance(final BigDecimal availableBalance) {
      this.availableBalance = availableBalance;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerDTO)) {
         return false;
      }

      ProjectLedgerDTO other = (ProjectLedgerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$contractSignBodyId = this.getContractSignBodyId();
               Object other$contractSignBodyId = other.getContractSignBodyId();
               if (this$contractSignBodyId == null ? other$contractSignBodyId == null : this$contractSignBodyId.equals(other$contractSignBodyId)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$signerId = this.getSignerId();
                     Object other$signerId = other.getSignerId();
                     if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                        Object this$salesLeaderId = this.getSalesLeaderId();
                        Object other$salesLeaderId = other.getSalesLeaderId();
                        if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                           Object this$managementFeeRateId = this.getManagementFeeRateId();
                           Object other$managementFeeRateId = other.getManagementFeeRateId();
                           if (this$managementFeeRateId == null
                              ? other$managementFeeRateId == null
                              : this$managementFeeRateId.equals(other$managementFeeRateId)) {
                              Object this$settlementStatus = this.getSettlementStatus();
                              Object other$settlementStatus = other.getSettlementStatus();
                              if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                                 Object this$invoiceType = this.getInvoiceType();
                                 Object other$invoiceType = other.getInvoiceType();
                                 if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                                    Object this$payType = this.getPayType();
                                    Object other$payType = other.getPayType();
                                    if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                                       Object this$contractType = this.getContractType();
                                       Object other$contractType = other.getContractType();
                                       if (this$contractType == null ? other$contractType == null : this$contractType.equals(other$contractType)) {
                                          Object this$contractDefinitionType = this.getContractDefinitionType();
                                          Object other$contractDefinitionType = other.getContractDefinitionType();
                                          if (this$contractDefinitionType == null
                                             ? other$contractDefinitionType == null
                                             : this$contractDefinitionType.equals(other$contractDefinitionType)) {
                                             Object this$countryId = this.getCountryId();
                                             Object other$countryId = other.getCountryId();
                                             if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
                                                Object this$provinceId = this.getProvinceId();
                                                Object other$provinceId = other.getProvinceId();
                                                if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
                                                   Object this$allDays = this.getAllDays();
                                                   Object other$allDays = other.getAllDays();
                                                   if (this$allDays == null ? other$allDays == null : this$allDays.equals(other$allDays)) {
                                                      Object this$marginType = this.getMarginType();
                                                      Object other$marginType = other.getMarginType();
                                                      if (this$marginType == null ? other$marginType == null : this$marginType.equals(other$marginType)) {
                                                         Object this$status = this.getStatus();
                                                         Object other$status = other.getStatus();
                                                         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                            Object this$level = this.getLevel();
                                                            Object other$level = other.getLevel();
                                                            if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                               Object this$project = this.getProject();
                                                               Object other$project = other.getProject();
                                                               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                  Object this$deptName = this.getDeptName();
                                                                  Object other$deptName = other.getDeptName();
                                                                  if (this$deptName == null ? other$deptName == null : this$deptName.equals(other$deptName)) {
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
                                                                           Object this$structureArea = this.getStructureArea();
                                                                           Object other$structureArea = other.getStructureArea();
                                                                           if (this$structureArea == null
                                                                              ? other$structureArea == null
                                                                              : this$structureArea.equals(other$structureArea)) {
                                                                              Object this$signerName = this.getSignerName();
                                                                              Object other$signerName = other.getSignerName();
                                                                              if (this$signerName == null
                                                                                 ? other$signerName == null
                                                                                 : this$signerName.equals(other$signerName)) {
                                                                                 Object this$salesLeaderName = this.getSalesLeaderName();
                                                                                 Object other$salesLeaderName = other.getSalesLeaderName();
                                                                                 if (this$salesLeaderName == null
                                                                                    ? other$salesLeaderName == null
                                                                                    : this$salesLeaderName.equals(other$salesLeaderName)) {
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
                                                                                                Object this$preSettlementAmount = this.getPreSettlementAmount();
                                                                                                Object other$preSettlementAmount = other.getPreSettlementAmount();
                                                                                                if (this$preSettlementAmount == null
                                                                                                   ? other$preSettlementAmount == null
                                                                                                   : this$preSettlementAmount.equals(other$preSettlementAmount)
                                                                                                   )
                                                                                                 {
                                                                                                   Object this$customerUnit = this.getCustomerUnit();
                                                                                                   Object other$customerUnit = other.getCustomerUnit();
                                                                                                   if (this$customerUnit == null
                                                                                                      ? other$customerUnit == null
                                                                                                      : this$customerUnit.equals(other$customerUnit)) {
                                                                                                      Object this$taxRate = this.getTaxRate();
                                                                                                      Object other$taxRate = other.getTaxRate();
                                                                                                      if (this$taxRate == null
                                                                                                         ? other$taxRate == null
                                                                                                         : this$taxRate.equals(other$taxRate)) {
                                                                                                         Object this$structureStatus = this.getStructureStatus();
                                                                                                         Object other$structureStatus = other.getStructureStatus();
                                                                                                         if (this$structureStatus == null
                                                                                                            ? other$structureStatus == null
                                                                                                            : this$structureStatus.equals(other$structureStatus)
                                                                                                            )
                                                                                                          {
                                                                                                            Object this$countryName = this.getCountryName();
                                                                                                            Object other$countryName = other.getCountryName();
                                                                                                            if (this$countryName == null
                                                                                                               ? other$countryName == null
                                                                                                               : this$countryName.equals(other$countryName)) {
                                                                                                               Object this$provinceName = this.getProvinceName();
                                                                                                               Object other$provinceName = other.getProvinceName();
                                                                                                               if (this$provinceName == null
                                                                                                                  ? other$provinceName == null
                                                                                                                  : this$provinceName.equals(other$provinceName)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$cityId = this.getCityId();
                                                                                                                  Object other$cityId = other.getCityId();
                                                                                                                  if (this$cityId == null
                                                                                                                     ? other$cityId == null
                                                                                                                     : this$cityId.equals(other$cityId)) {
                                                                                                                     Object this$cityName = this.getCityName();
                                                                                                                     Object other$cityName = other.getCityName();
                                                                                                                     if (this$cityName == null
                                                                                                                        ? other$cityName == null
                                                                                                                        : this$cityName.equals(other$cityName)) {
                                                                                                                        Object this$address = this.getAddress();
                                                                                                                        Object other$address = other.getAddress();
                                                                                                                        if (this$address == null
                                                                                                                           ? other$address == null
                                                                                                                           : this$address.equals(other$address)
                                                                                                                           )
                                                                                                                         {
                                                                                                                           Object this$partyType = this.getPartyType();
                                                                                                                           Object other$partyType = other.getPartyType();
                                                                                                                           if (this$partyType == null
                                                                                                                              ? other$partyType == null
                                                                                                                              : this$partyType.equals(
                                                                                                                                 other$partyType
                                                                                                                              )) {
                                                                                                                              Object this$sendingMode = this.getSendingMode();
                                                                                                                              Object other$sendingMode = other.getSendingMode();
                                                                                                                              if (this$sendingMode == null
                                                                                                                                 ? other$sendingMode == null
                                                                                                                                 : this$sendingMode.equals(
                                                                                                                                    other$sendingMode
                                                                                                                                 )) {
                                                                                                                                 Object this$startDate = this.getStartDate();
                                                                                                                                 Object other$startDate = other.getStartDate();
                                                                                                                                 if (this$startDate == null
                                                                                                                                    ? other$startDate == null
                                                                                                                                    : this$startDate.equals(
                                                                                                                                       other$startDate
                                                                                                                                    )) {
                                                                                                                                    Object this$endDate = this.getEndDate();
                                                                                                                                    Object other$endDate = other.getEndDate();
                                                                                                                                    if (this$endDate == null
                                                                                                                                       ? other$endDate == null
                                                                                                                                       : this$endDate.equals(
                                                                                                                                          other$endDate
                                                                                                                                       )) {
                                                                                                                                       Object this$amount = this.getAmount();
                                                                                                                                       Object other$amount = other.getAmount();
                                                                                                                                       if (this$amount == null
                                                                                                                                          ? other$amount
                                                                                                                                             == null
                                                                                                                                          : this$amount.equals(
                                                                                                                                             other$amount
                                                                                                                                          )) {
                                                                                                                                          Object this$currencyType = this.getCurrencyType();
                                                                                                                                          Object other$currencyType = other.getCurrencyType();
                                                                                                                                          if (this$currencyType
                                                                                                                                                == null
                                                                                                                                             ? other$currencyType
                                                                                                                                                == null
                                                                                                                                             : this$currencyType.equals(
                                                                                                                                                other$currencyType
                                                                                                                                             )) {
                                                                                                                                             Object this$cashDeposit = this.getCashDeposit();
                                                                                                                                             Object other$cashDeposit = other.getCashDeposit();
                                                                                                                                             if (this$cashDeposit
                                                                                                                                                   == null
                                                                                                                                                ? other$cashDeposit
                                                                                                                                                   == null
                                                                                                                                                : this$cashDeposit.equals(
                                                                                                                                                   other$cashDeposit
                                                                                                                                                )) {
                                                                                                                                                Object this$technologyClause = this.getTechnologyClause();
                                                                                                                                                Object other$technologyClause = other.getTechnologyClause();
                                                                                                                                                if (this$technologyClause
                                                                                                                                                      == null
                                                                                                                                                   ? other$technologyClause
                                                                                                                                                      == null
                                                                                                                                                   : this$technologyClause.equals(
                                                                                                                                                      other$technologyClause
                                                                                                                                                   )) {
                                                                                                                                                   Object this$payTypeDesc = this.getPayTypeDesc();
                                                                                                                                                   Object other$payTypeDesc = other.getPayTypeDesc();
                                                                                                                                                   if (this$payTypeDesc
                                                                                                                                                         == null
                                                                                                                                                      ? other$payTypeDesc
                                                                                                                                                         == null
                                                                                                                                                      : this$payTypeDesc.equals(
                                                                                                                                                         other$payTypeDesc
                                                                                                                                                      )) {
                                                                                                                                                      Object this$accumulatedCollection = this.getAccumulatedCollection();
                                                                                                                                                      Object other$accumulatedCollection = other.getAccumulatedCollection();
                                                                                                                                                      if (this$accumulatedCollection
                                                                                                                                                            == null
                                                                                                                                                         ? other$accumulatedCollection
                                                                                                                                                            == null
                                                                                                                                                         : this$accumulatedCollection.equals(
                                                                                                                                                            other$accumulatedCollection
                                                                                                                                                         )) {
                                                                                                                                                         Object this$accumulatedInvoice = this.getAccumulatedInvoice();
                                                                                                                                                         Object other$accumulatedInvoice = other.getAccumulatedInvoice();
                                                                                                                                                         if (this$accumulatedInvoice
                                                                                                                                                               == null
                                                                                                                                                            ? other$accumulatedInvoice
                                                                                                                                                               == null
                                                                                                                                                            : this$accumulatedInvoice.equals(
                                                                                                                                                               other$accumulatedInvoice
                                                                                                                                                            )) {
                                                                                                                                                            Object this$collectionRatio = this.getCollectionRatio();
                                                                                                                                                            Object other$collectionRatio = other.getCollectionRatio();
                                                                                                                                                            if (this$collectionRatio
                                                                                                                                                                  == null
                                                                                                                                                               ? other$collectionRatio
                                                                                                                                                                  == null
                                                                                                                                                               : this$collectionRatio.equals(
                                                                                                                                                                  other$collectionRatio
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$invoiceRatio = this.getInvoiceRatio();
                                                                                                                                                               Object other$invoiceRatio = other.getInvoiceRatio();
                                                                                                                                                               if (this$invoiceRatio
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$invoiceRatio
                                                                                                                                                                     == null
                                                                                                                                                                  : this$invoiceRatio.equals(
                                                                                                                                                                     other$invoiceRatio
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$advancesReceived = this.getAdvancesReceived();
                                                                                                                                                                  Object other$advancesReceived = other.getAdvancesReceived();
                                                                                                                                                                  if (this$advancesReceived
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$advancesReceived
                                                                                                                                                                        == null
                                                                                                                                                                     : this$advancesReceived.equals(
                                                                                                                                                                        other$advancesReceived
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$accumulatedCost = this.getAccumulatedCost();
                                                                                                                                                                     Object other$accumulatedCost = other.getAccumulatedCost();
                                                                                                                                                                     if (this$accumulatedCost
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$accumulatedCost
                                                                                                                                                                           == null
                                                                                                                                                                        : this$accumulatedCost.equals(
                                                                                                                                                                           other$accumulatedCost
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$availableBalance = this.getAvailableBalance();
                                                                                                                                                                        Object other$availableBalance = other.getAvailableBalance();
                                                                                                                                                                        if (this$availableBalance
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$availableBalance
                                                                                                                                                                              == null
                                                                                                                                                                           : this$availableBalance.equals(
                                                                                                                                                                              other$availableBalance
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$createTime = this.getCreateTime();
                                                                                                                                                                           Object other$createTime = other.getCreateTime();
                                                                                                                                                                           return this$createTime
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$createTime
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$createTime.equals(
                                                                                                                                                                                 other$createTime
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
      return other instanceof ProjectLedgerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $contractSignBodyId = this.getContractSignBodyId();
      result = result * 59 + ($contractSignBodyId == null ? 43 : $contractSignBodyId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $managementFeeRateId = this.getManagementFeeRateId();
      result = result * 59 + ($managementFeeRateId == null ? 43 : $managementFeeRateId.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $contractType = this.getContractType();
      result = result * 59 + ($contractType == null ? 43 : $contractType.hashCode());
      Object $contractDefinitionType = this.getContractDefinitionType();
      result = result * 59 + ($contractDefinitionType == null ? 43 : $contractDefinitionType.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $allDays = this.getAllDays();
      result = result * 59 + ($allDays == null ? 43 : $allDays.hashCode());
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $deptName = this.getDeptName();
      result = result * 59 + ($deptName == null ? 43 : $deptName.hashCode());
      Object $contractSignBodyName = this.getContractSignBodyName();
      result = result * 59 + ($contractSignBodyName == null ? 43 : $contractSignBodyName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $preSettlementAmount = this.getPreSettlementAmount();
      result = result * 59 + ($preSettlementAmount == null ? 43 : $preSettlementAmount.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $sendingMode = this.getSendingMode();
      result = result * 59 + ($sendingMode == null ? 43 : $sendingMode.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $technologyClause = this.getTechnologyClause();
      result = result * 59 + ($technologyClause == null ? 43 : $technologyClause.hashCode());
      Object $payTypeDesc = this.getPayTypeDesc();
      result = result * 59 + ($payTypeDesc == null ? 43 : $payTypeDesc.hashCode());
      Object $accumulatedCollection = this.getAccumulatedCollection();
      result = result * 59 + ($accumulatedCollection == null ? 43 : $accumulatedCollection.hashCode());
      Object $accumulatedInvoice = this.getAccumulatedInvoice();
      result = result * 59 + ($accumulatedInvoice == null ? 43 : $accumulatedInvoice.hashCode());
      Object $collectionRatio = this.getCollectionRatio();
      result = result * 59 + ($collectionRatio == null ? 43 : $collectionRatio.hashCode());
      Object $invoiceRatio = this.getInvoiceRatio();
      result = result * 59 + ($invoiceRatio == null ? 43 : $invoiceRatio.hashCode());
      Object $advancesReceived = this.getAdvancesReceived();
      result = result * 59 + ($advancesReceived == null ? 43 : $advancesReceived.hashCode());
      Object $accumulatedCost = this.getAccumulatedCost();
      result = result * 59 + ($accumulatedCost == null ? 43 : $accumulatedCost.hashCode());
      Object $availableBalance = this.getAvailableBalance();
      result = result * 59 + ($availableBalance == null ? 43 : $availableBalance.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", deptName="
         + this.getDeptName()
         + ", businessType="
         + this.getBusinessType()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", contractSignBodyId="
         + this.getContractSignBodyId()
         + ", contractSignBodyName="
         + this.getContractSignBodyName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", structureArea="
         + this.getStructureArea()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", signingDate="
         + this.getSigningDate()
         + ", managementFeeRateId="
         + this.getManagementFeeRateId()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", contractAmount="
         + this.getContractAmount()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", preSettlementAmount="
         + this.getPreSettlementAmount()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", payType="
         + this.getPayType()
         + ", taxRate="
         + this.getTaxRate()
         + ", contractType="
         + this.getContractType()
         + ", contractDefinitionType="
         + this.getContractDefinitionType()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", address="
         + this.getAddress()
         + ", partyType="
         + this.getPartyType()
         + ", sendingMode="
         + this.getSendingMode()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", allDays="
         + this.getAllDays()
         + ", amount="
         + this.getAmount()
         + ", currencyType="
         + this.getCurrencyType()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", marginType="
         + this.getMarginType()
         + ", status="
         + this.getStatus()
         + ", technologyClause="
         + this.getTechnologyClause()
         + ", payTypeDesc="
         + this.getPayTypeDesc()
         + ", accumulatedCollection="
         + this.getAccumulatedCollection()
         + ", accumulatedInvoice="
         + this.getAccumulatedInvoice()
         + ", collectionRatio="
         + this.getCollectionRatio()
         + ", invoiceRatio="
         + this.getInvoiceRatio()
         + ", advancesReceived="
         + this.getAdvancesReceived()
         + ", accumulatedCost="
         + this.getAccumulatedCost()
         + ", availableBalance="
         + this.getAvailableBalance()
         + ", createTime="
         + this.getCreateTime()
         + ", level="
         + this.getLevel()
         + ")";
   }
}
