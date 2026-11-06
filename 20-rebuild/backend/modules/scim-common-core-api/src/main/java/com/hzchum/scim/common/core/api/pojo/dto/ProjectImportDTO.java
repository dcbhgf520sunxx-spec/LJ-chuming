package com.hzchum.scim.common.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class ProjectImportDTO {
   @Excel(name = "序号", width = 5.0, orderNum = "1")
   private Integer orderNo;
   @Excel(name = "订单类型*", width = 5.0, orderNum = "2")
   private String businessType;
   @Excel(name = "经营方式*", width = 5.0, orderNum = "3")
   private String projectAttribute;
   @Excel(name = "承接部门*", width = 5.0, orderNum = "4")
   private String dept;
   @Excel(name = "销售负责人*", width = 5.0, orderNum = "5")
   private String salesLeaderName;
   @Excel(name = "签订日期*", width = 5.0, orderNum = "6")
   @DateTimeFormat(pattern = "yyyy/MM/dd")
   private LocalDate signingDate;
   @Excel(name = "合同编号*", width = 5.0, orderNum = "7")
   private String serialNumber;
   @Excel(name = "项目名称*", width = 5.0, orderNum = "8")
   private String name;
   @Excel(name = "项目简称*", width = 5.0, orderNum = "9")
   private String shortName;
   @Excel(name = "结构工程量*", width = 5.0, orderNum = "10")
   private BigDecimal structureArea;
   @Excel(name = "工程量单位", width = 5.0, orderNum = "11")
   private String unitType;
   @Excel(name = "项目地点*", width = 5.0, orderNum = "12")
   private String provincesAndMunicipalities;
   @Excel(name = "合同详细地址", width = 5.0, orderNum = "13")
   private String address;
   @Excel(name = "开工时间*", width = 5.0, orderNum = "14")
   @DateTimeFormat(pattern = "yyyy/MM/dd")
   private LocalDate startDate;
   @Excel(name = "完工时间*", width = 5.0, orderNum = "15")
   @DateTimeFormat(pattern = "yyyy/MM/dd")
   private LocalDate endDate;
   @Excel(name = "合同签订主体*", width = 5.0, orderNum = "16")
   private String contractSignBody;
   @Excel(name = "结构类型*", width = 5.0, orderNum = "17")
   private String structureStatus;
   @Excel(name = "甲方类型*", width = 5.0, orderNum = "18")
   private String partyType;
   @Excel(name = "发包类型*", width = 5.0, orderNum = "19")
   private String sendingMode;
   @Excel(name = "装配式建筑", width = 5.0, orderNum = "20")
   private String isBuilding;
   @Excel(name = "信息来源*", width = 5.0, orderNum = "21")
   private String infoSource;
   @Excel(name = "合同金额(元)*", width = 5.0, orderNum = "22")
   private BigDecimal contractAmount;
   @Excel(name = "税率", width = 5.0, orderNum = "23")
   private BigDecimal taxRate;
   @Excel(name = "币种", width = 5.0, orderNum = "24")
   private String currencyType;
   @Excel(name = "商务条款", width = 5.0, orderNum = "25")
   private String commercialClause;
   @Excel(name = "技术条款", width = 5.0, orderNum = "26")
   private String technologyClause;
   @Excel(name = "其他", width = 5.0, orderNum = "27")
   private String otherRemarks;
   @Excel(name = "客户名称*", width = 5.0, orderNum = "28")
   private String customerUnit;
   @Excel(name = "社会统一代码", width = 5.0, orderNum = "29")
   private String socialCode;
   @Excel(name = "联系电话", width = 5.0, orderNum = "30")
   private String customerUnitPhone;
   @Excel(name = "邮箱", width = 5.0, orderNum = "31")
   private String customerEmail;
   @Excel(name = "省市区", width = 5.0, orderNum = "32")
   private String partProvincesAndMunicipalities;
   @Excel(name = "客户详细地址", width = 5.0, orderNum = "33")
   private String customerAddress;
   @Excel(name = "银行账户户名", width = 5.0, orderNum = "34")
   private String customerBankUserName;
   @Excel(name = "银行账户账号", width = 5.0, orderNum = "35")
   private String customerBankCode;
   @Excel(name = "开户行", width = 5.0, orderNum = "36")
   private String customerBankName;
   @Excel(name = "收货负责人*", width = 5.0, orderNum = "37")
   private String receivingManager;
   @Excel(name = "收货负责人电话", width = 5.0, orderNum = "38")
   private String receivingManagerPhone;
   @Excel(name = "结算负责人", width = 5.0, orderNum = "39")
   private String settleManager;
   @Excel(name = "结算负责人电话", width = 5.0, orderNum = "40")
   private String settleManagerPhone;
   @Excel(name = "财务负责人", width = 5.0, orderNum = "41")
   private String financeManager;
   @Excel(name = "财务负责人电话", width = 5.0, orderNum = "42")
   private String financeManagerPhone;
   @Excel(name = "审核负责人", width = 5.0, orderNum = "43")
   private String auditManager;
   @Excel(name = "审核负责人电话", width = 5.0, orderNum = "44")
   private String auditManagerPhone;
   @Excel(name = "设计负责人", width = 5.0, orderNum = "45")
   private String designManager;
   @Excel(name = "设计负责人电话", width = 5.0, orderNum = "46")
   private String designManagerPhone;
   @Excel(name = "备注", width = 5.0, orderNum = "47")
   private String customerRemark;
   @Excel(name = "合同主体比例", width = 5.0, orderNum = "48")
   private BigDecimal contractSignBodyScale;
   @Excel(name = "项目经理比例", width = 5.0, orderNum = "49")
   private BigDecimal projectManagerScale;

   public ProjectImportDTO(
      final Integer orderNo,
      final String businessType,
      final String projectAttribute,
      final String dept,
      final String salesLeaderName,
      final LocalDate signingDate,
      final String serialNumber,
      final String name,
      final String shortName,
      final BigDecimal structureArea,
      final String unitType,
      final String provincesAndMunicipalities,
      final String address,
      final LocalDate startDate,
      final LocalDate endDate,
      final String contractSignBody,
      final String structureStatus,
      final String partyType,
      final String sendingMode,
      final String isBuilding,
      final String infoSource,
      final BigDecimal contractAmount,
      final BigDecimal taxRate,
      final String currencyType,
      final String commercialClause,
      final String technologyClause,
      final String otherRemarks,
      final String customerUnit,
      final String socialCode,
      final String customerUnitPhone,
      final String customerEmail,
      final String partProvincesAndMunicipalities,
      final String customerAddress,
      final String customerBankUserName,
      final String customerBankCode,
      final String customerBankName,
      final String receivingManager,
      final String receivingManagerPhone,
      final String settleManager,
      final String settleManagerPhone,
      final String financeManager,
      final String financeManagerPhone,
      final String auditManager,
      final String auditManagerPhone,
      final String designManager,
      final String designManagerPhone,
      final String customerRemark,
      final BigDecimal contractSignBodyScale,
      final BigDecimal projectManagerScale
   ) {
      this.orderNo = orderNo;
      this.businessType = businessType;
      this.projectAttribute = projectAttribute;
      this.dept = dept;
      this.salesLeaderName = salesLeaderName;
      this.signingDate = signingDate;
      this.serialNumber = serialNumber;
      this.name = name;
      this.shortName = shortName;
      this.structureArea = structureArea;
      this.unitType = unitType;
      this.provincesAndMunicipalities = provincesAndMunicipalities;
      this.address = address;
      this.startDate = startDate;
      this.endDate = endDate;
      this.contractSignBody = contractSignBody;
      this.structureStatus = structureStatus;
      this.partyType = partyType;
      this.sendingMode = sendingMode;
      this.isBuilding = isBuilding;
      this.infoSource = infoSource;
      this.contractAmount = contractAmount;
      this.taxRate = taxRate;
      this.currencyType = currencyType;
      this.commercialClause = commercialClause;
      this.technologyClause = technologyClause;
      this.otherRemarks = otherRemarks;
      this.customerUnit = customerUnit;
      this.socialCode = socialCode;
      this.customerUnitPhone = customerUnitPhone;
      this.customerEmail = customerEmail;
      this.partProvincesAndMunicipalities = partProvincesAndMunicipalities;
      this.customerAddress = customerAddress;
      this.customerBankUserName = customerBankUserName;
      this.customerBankCode = customerBankCode;
      this.customerBankName = customerBankName;
      this.receivingManager = receivingManager;
      this.receivingManagerPhone = receivingManagerPhone;
      this.settleManager = settleManager;
      this.settleManagerPhone = settleManagerPhone;
      this.financeManager = financeManager;
      this.financeManagerPhone = financeManagerPhone;
      this.auditManager = auditManager;
      this.auditManagerPhone = auditManagerPhone;
      this.designManager = designManager;
      this.designManagerPhone = designManagerPhone;
      this.customerRemark = customerRemark;
      this.contractSignBodyScale = contractSignBodyScale;
      this.projectManagerScale = projectManagerScale;
   }

   public ProjectImportDTO() {
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getBusinessType() {
      return this.businessType;
   }

   public String getProjectAttribute() {
      return this.projectAttribute;
   }

   public String getDept() {
      return this.dept;
   }

   public String getSalesLeaderName() {
      return this.salesLeaderName;
   }

   public LocalDate getSigningDate() {
      return this.signingDate;
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

   public BigDecimal getStructureArea() {
      return this.structureArea;
   }

   public String getUnitType() {
      return this.unitType;
   }

   public String getProvincesAndMunicipalities() {
      return this.provincesAndMunicipalities;
   }

   public String getAddress() {
      return this.address;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getContractSignBody() {
      return this.contractSignBody;
   }

   public String getStructureStatus() {
      return this.structureStatus;
   }

   public String getPartyType() {
      return this.partyType;
   }

   public String getSendingMode() {
      return this.sendingMode;
   }

   public String getIsBuilding() {
      return this.isBuilding;
   }

   public String getInfoSource() {
      return this.infoSource;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getCurrencyType() {
      return this.currencyType;
   }

   public String getCommercialClause() {
      return this.commercialClause;
   }

   public String getTechnologyClause() {
      return this.technologyClause;
   }

   public String getOtherRemarks() {
      return this.otherRemarks;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public String getCustomerUnitPhone() {
      return this.customerUnitPhone;
   }

   public String getCustomerEmail() {
      return this.customerEmail;
   }

   public String getPartProvincesAndMunicipalities() {
      return this.partProvincesAndMunicipalities;
   }

   public String getCustomerAddress() {
      return this.customerAddress;
   }

   public String getCustomerBankUserName() {
      return this.customerBankUserName;
   }

   public String getCustomerBankCode() {
      return this.customerBankCode;
   }

   public String getCustomerBankName() {
      return this.customerBankName;
   }

   public String getReceivingManager() {
      return this.receivingManager;
   }

   public String getReceivingManagerPhone() {
      return this.receivingManagerPhone;
   }

   public String getSettleManager() {
      return this.settleManager;
   }

   public String getSettleManagerPhone() {
      return this.settleManagerPhone;
   }

   public String getFinanceManager() {
      return this.financeManager;
   }

   public String getFinanceManagerPhone() {
      return this.financeManagerPhone;
   }

   public String getAuditManager() {
      return this.auditManager;
   }

   public String getAuditManagerPhone() {
      return this.auditManagerPhone;
   }

   public String getDesignManager() {
      return this.designManager;
   }

   public String getDesignManagerPhone() {
      return this.designManagerPhone;
   }

   public String getCustomerRemark() {
      return this.customerRemark;
   }

   public BigDecimal getContractSignBodyScale() {
      return this.contractSignBodyScale;
   }

   public BigDecimal getProjectManagerScale() {
      return this.projectManagerScale;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setBusinessType(final String businessType) {
      this.businessType = businessType;
   }

   public void setProjectAttribute(final String projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setDept(final String dept) {
      this.dept = dept;
   }

   public void setSalesLeaderName(final String salesLeaderName) {
      this.salesLeaderName = salesLeaderName;
   }

   public void setSigningDate(final LocalDate signingDate) {
      this.signingDate = signingDate;
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

   public void setStructureArea(final BigDecimal structureArea) {
      this.structureArea = structureArea;
   }

   public void setUnitType(final String unitType) {
      this.unitType = unitType;
   }

   public void setProvincesAndMunicipalities(final String provincesAndMunicipalities) {
      this.provincesAndMunicipalities = provincesAndMunicipalities;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setContractSignBody(final String contractSignBody) {
      this.contractSignBody = contractSignBody;
   }

   public void setStructureStatus(final String structureStatus) {
      this.structureStatus = structureStatus;
   }

   public void setPartyType(final String partyType) {
      this.partyType = partyType;
   }

   public void setSendingMode(final String sendingMode) {
      this.sendingMode = sendingMode;
   }

   public void setIsBuilding(final String isBuilding) {
      this.isBuilding = isBuilding;
   }

   public void setInfoSource(final String infoSource) {
      this.infoSource = infoSource;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
   }

   public void setCommercialClause(final String commercialClause) {
      this.commercialClause = commercialClause;
   }

   public void setTechnologyClause(final String technologyClause) {
      this.technologyClause = technologyClause;
   }

   public void setOtherRemarks(final String otherRemarks) {
      this.otherRemarks = otherRemarks;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setCustomerUnitPhone(final String customerUnitPhone) {
      this.customerUnitPhone = customerUnitPhone;
   }

   public void setCustomerEmail(final String customerEmail) {
      this.customerEmail = customerEmail;
   }

   public void setPartProvincesAndMunicipalities(final String partProvincesAndMunicipalities) {
      this.partProvincesAndMunicipalities = partProvincesAndMunicipalities;
   }

   public void setCustomerAddress(final String customerAddress) {
      this.customerAddress = customerAddress;
   }

   public void setCustomerBankUserName(final String customerBankUserName) {
      this.customerBankUserName = customerBankUserName;
   }

   public void setCustomerBankCode(final String customerBankCode) {
      this.customerBankCode = customerBankCode;
   }

   public void setCustomerBankName(final String customerBankName) {
      this.customerBankName = customerBankName;
   }

   public void setReceivingManager(final String receivingManager) {
      this.receivingManager = receivingManager;
   }

   public void setReceivingManagerPhone(final String receivingManagerPhone) {
      this.receivingManagerPhone = receivingManagerPhone;
   }

   public void setSettleManager(final String settleManager) {
      this.settleManager = settleManager;
   }

   public void setSettleManagerPhone(final String settleManagerPhone) {
      this.settleManagerPhone = settleManagerPhone;
   }

   public void setFinanceManager(final String financeManager) {
      this.financeManager = financeManager;
   }

   public void setFinanceManagerPhone(final String financeManagerPhone) {
      this.financeManagerPhone = financeManagerPhone;
   }

   public void setAuditManager(final String auditManager) {
      this.auditManager = auditManager;
   }

   public void setAuditManagerPhone(final String auditManagerPhone) {
      this.auditManagerPhone = auditManagerPhone;
   }

   public void setDesignManager(final String designManager) {
      this.designManager = designManager;
   }

   public void setDesignManagerPhone(final String designManagerPhone) {
      this.designManagerPhone = designManagerPhone;
   }

   public void setCustomerRemark(final String customerRemark) {
      this.customerRemark = customerRemark;
   }

   public void setContractSignBodyScale(final BigDecimal contractSignBodyScale) {
      this.contractSignBodyScale = contractSignBodyScale;
   }

   public void setProjectManagerScale(final BigDecimal projectManagerScale) {
      this.projectManagerScale = projectManagerScale;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectImportDTO)) {
         return false;
      }

      ProjectImportDTO other = (ProjectImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$dept = this.getDept();
               Object other$dept = other.getDept();
               if (this$dept == null ? other$dept == null : this$dept.equals(other$dept)) {
                  Object this$salesLeaderName = this.getSalesLeaderName();
                  Object other$salesLeaderName = other.getSalesLeaderName();
                  if (this$salesLeaderName == null ? other$salesLeaderName == null : this$salesLeaderName.equals(other$salesLeaderName)) {
                     Object this$signingDate = this.getSigningDate();
                     Object other$signingDate = other.getSigningDate();
                     if (this$signingDate == null ? other$signingDate == null : this$signingDate.equals(other$signingDate)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$shortName = this.getShortName();
                              Object other$shortName = other.getShortName();
                              if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                 Object this$structureArea = this.getStructureArea();
                                 Object other$structureArea = other.getStructureArea();
                                 if (this$structureArea == null ? other$structureArea == null : this$structureArea.equals(other$structureArea)) {
                                    Object this$unitType = this.getUnitType();
                                    Object other$unitType = other.getUnitType();
                                    if (this$unitType == null ? other$unitType == null : this$unitType.equals(other$unitType)) {
                                       Object this$provincesAndMunicipalities = this.getProvincesAndMunicipalities();
                                       Object other$provincesAndMunicipalities = other.getProvincesAndMunicipalities();
                                       if (this$provincesAndMunicipalities == null
                                          ? other$provincesAndMunicipalities == null
                                          : this$provincesAndMunicipalities.equals(other$provincesAndMunicipalities)) {
                                          Object this$address = this.getAddress();
                                          Object other$address = other.getAddress();
                                          if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                             Object this$startDate = this.getStartDate();
                                             Object other$startDate = other.getStartDate();
                                             if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                Object this$endDate = this.getEndDate();
                                                Object other$endDate = other.getEndDate();
                                                if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                   Object this$contractSignBody = this.getContractSignBody();
                                                   Object other$contractSignBody = other.getContractSignBody();
                                                   if (this$contractSignBody == null
                                                      ? other$contractSignBody == null
                                                      : this$contractSignBody.equals(other$contractSignBody)) {
                                                      Object this$structureStatus = this.getStructureStatus();
                                                      Object other$structureStatus = other.getStructureStatus();
                                                      if (this$structureStatus == null
                                                         ? other$structureStatus == null
                                                         : this$structureStatus.equals(other$structureStatus)) {
                                                         Object this$partyType = this.getPartyType();
                                                         Object other$partyType = other.getPartyType();
                                                         if (this$partyType == null ? other$partyType == null : this$partyType.equals(other$partyType)) {
                                                            Object this$sendingMode = this.getSendingMode();
                                                            Object other$sendingMode = other.getSendingMode();
                                                            if (this$sendingMode == null
                                                               ? other$sendingMode == null
                                                               : this$sendingMode.equals(other$sendingMode)) {
                                                               Object this$isBuilding = this.getIsBuilding();
                                                               Object other$isBuilding = other.getIsBuilding();
                                                               if (this$isBuilding == null
                                                                  ? other$isBuilding == null
                                                                  : this$isBuilding.equals(other$isBuilding)) {
                                                                  Object this$infoSource = this.getInfoSource();
                                                                  Object other$infoSource = other.getInfoSource();
                                                                  if (this$infoSource == null
                                                                     ? other$infoSource == null
                                                                     : this$infoSource.equals(other$infoSource)) {
                                                                     Object this$contractAmount = this.getContractAmount();
                                                                     Object other$contractAmount = other.getContractAmount();
                                                                     if (this$contractAmount == null
                                                                        ? other$contractAmount == null
                                                                        : this$contractAmount.equals(other$contractAmount)) {
                                                                        Object this$taxRate = this.getTaxRate();
                                                                        Object other$taxRate = other.getTaxRate();
                                                                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                                           Object this$currencyType = this.getCurrencyType();
                                                                           Object other$currencyType = other.getCurrencyType();
                                                                           if (this$currencyType == null
                                                                              ? other$currencyType == null
                                                                              : this$currencyType.equals(other$currencyType)) {
                                                                              Object this$commercialClause = this.getCommercialClause();
                                                                              Object other$commercialClause = other.getCommercialClause();
                                                                              if (this$commercialClause == null
                                                                                 ? other$commercialClause == null
                                                                                 : this$commercialClause.equals(other$commercialClause)) {
                                                                                 Object this$technologyClause = this.getTechnologyClause();
                                                                                 Object other$technologyClause = other.getTechnologyClause();
                                                                                 if (this$technologyClause == null
                                                                                    ? other$technologyClause == null
                                                                                    : this$technologyClause.equals(other$technologyClause)) {
                                                                                    Object this$otherRemarks = this.getOtherRemarks();
                                                                                    Object other$otherRemarks = other.getOtherRemarks();
                                                                                    if (this$otherRemarks == null
                                                                                       ? other$otherRemarks == null
                                                                                       : this$otherRemarks.equals(other$otherRemarks)) {
                                                                                       Object this$customerUnit = this.getCustomerUnit();
                                                                                       Object other$customerUnit = other.getCustomerUnit();
                                                                                       if (this$customerUnit == null
                                                                                          ? other$customerUnit == null
                                                                                          : this$customerUnit.equals(other$customerUnit)) {
                                                                                          Object this$socialCode = this.getSocialCode();
                                                                                          Object other$socialCode = other.getSocialCode();
                                                                                          if (this$socialCode == null
                                                                                             ? other$socialCode == null
                                                                                             : this$socialCode.equals(other$socialCode)) {
                                                                                             Object this$customerUnitPhone = this.getCustomerUnitPhone();
                                                                                             Object other$customerUnitPhone = other.getCustomerUnitPhone();
                                                                                             if (this$customerUnitPhone == null
                                                                                                ? other$customerUnitPhone == null
                                                                                                : this$customerUnitPhone.equals(other$customerUnitPhone)) {
                                                                                                Object this$customerEmail = this.getCustomerEmail();
                                                                                                Object other$customerEmail = other.getCustomerEmail();
                                                                                                if (this$customerEmail == null
                                                                                                   ? other$customerEmail == null
                                                                                                   : this$customerEmail.equals(other$customerEmail)) {
                                                                                                   Object this$partProvincesAndMunicipalities = this.getPartProvincesAndMunicipalities();
                                                                                                   Object other$partProvincesAndMunicipalities = other.getPartProvincesAndMunicipalities();
                                                                                                   if (this$partProvincesAndMunicipalities == null
                                                                                                      ? other$partProvincesAndMunicipalities == null
                                                                                                      : this$partProvincesAndMunicipalities.equals(
                                                                                                         other$partProvincesAndMunicipalities
                                                                                                      )) {
                                                                                                      Object this$customerAddress = this.getCustomerAddress();
                                                                                                      Object other$customerAddress = other.getCustomerAddress();
                                                                                                      if (this$customerAddress == null
                                                                                                         ? other$customerAddress == null
                                                                                                         : this$customerAddress.equals(other$customerAddress)) {
                                                                                                         Object this$customerBankUserName = this.getCustomerBankUserName();
                                                                                                         Object other$customerBankUserName = other.getCustomerBankUserName();
                                                                                                         if (this$customerBankUserName == null
                                                                                                            ? other$customerBankUserName == null
                                                                                                            : this$customerBankUserName.equals(
                                                                                                               other$customerBankUserName
                                                                                                            )) {
                                                                                                            Object this$customerBankCode = this.getCustomerBankCode();
                                                                                                            Object other$customerBankCode = other.getCustomerBankCode();
                                                                                                            if (this$customerBankCode == null
                                                                                                               ? other$customerBankCode == null
                                                                                                               : this$customerBankCode.equals(
                                                                                                                  other$customerBankCode
                                                                                                               )) {
                                                                                                               Object this$customerBankName = this.getCustomerBankName();
                                                                                                               Object other$customerBankName = other.getCustomerBankName();
                                                                                                               if (this$customerBankName == null
                                                                                                                  ? other$customerBankName == null
                                                                                                                  : this$customerBankName.equals(
                                                                                                                     other$customerBankName
                                                                                                                  )) {
                                                                                                                  Object this$receivingManager = this.getReceivingManager();
                                                                                                                  Object other$receivingManager = other.getReceivingManager();
                                                                                                                  if (this$receivingManager == null
                                                                                                                     ? other$receivingManager == null
                                                                                                                     : this$receivingManager.equals(
                                                                                                                        other$receivingManager
                                                                                                                     )) {
                                                                                                                     Object this$receivingManagerPhone = this.getReceivingManagerPhone();
                                                                                                                     Object other$receivingManagerPhone = other.getReceivingManagerPhone();
                                                                                                                     if (this$receivingManagerPhone == null
                                                                                                                        ? other$receivingManagerPhone == null
                                                                                                                        : this$receivingManagerPhone.equals(
                                                                                                                           other$receivingManagerPhone
                                                                                                                        )) {
                                                                                                                        Object this$settleManager = this.getSettleManager();
                                                                                                                        Object other$settleManager = other.getSettleManager();
                                                                                                                        if (this$settleManager == null
                                                                                                                           ? other$settleManager == null
                                                                                                                           : this$settleManager.equals(
                                                                                                                              other$settleManager
                                                                                                                           )) {
                                                                                                                           Object this$settleManagerPhone = this.getSettleManagerPhone();
                                                                                                                           Object other$settleManagerPhone = other.getSettleManagerPhone();
                                                                                                                           if (this$settleManagerPhone == null
                                                                                                                              ? other$settleManagerPhone
                                                                                                                                 == null
                                                                                                                              : this$settleManagerPhone.equals(
                                                                                                                                 other$settleManagerPhone
                                                                                                                              )) {
                                                                                                                              Object this$financeManager = this.getFinanceManager();
                                                                                                                              Object other$financeManager = other.getFinanceManager();
                                                                                                                              if (this$financeManager == null
                                                                                                                                 ? other$financeManager == null
                                                                                                                                 : this$financeManager.equals(
                                                                                                                                    other$financeManager
                                                                                                                                 )) {
                                                                                                                                 Object this$financeManagerPhone = this.getFinanceManagerPhone();
                                                                                                                                 Object other$financeManagerPhone = other.getFinanceManagerPhone();
                                                                                                                                 if (this$financeManagerPhone
                                                                                                                                       == null
                                                                                                                                    ? other$financeManagerPhone
                                                                                                                                       == null
                                                                                                                                    : this$financeManagerPhone.equals(
                                                                                                                                       other$financeManagerPhone
                                                                                                                                    )) {
                                                                                                                                    Object this$auditManager = this.getAuditManager();
                                                                                                                                    Object other$auditManager = other.getAuditManager();
                                                                                                                                    if (this$auditManager
                                                                                                                                          == null
                                                                                                                                       ? other$auditManager
                                                                                                                                          == null
                                                                                                                                       : this$auditManager.equals(
                                                                                                                                          other$auditManager
                                                                                                                                       )) {
                                                                                                                                       Object this$auditManagerPhone = this.getAuditManagerPhone();
                                                                                                                                       Object other$auditManagerPhone = other.getAuditManagerPhone();
                                                                                                                                       if (this$auditManagerPhone
                                                                                                                                             == null
                                                                                                                                          ? other$auditManagerPhone
                                                                                                                                             == null
                                                                                                                                          : this$auditManagerPhone.equals(
                                                                                                                                             other$auditManagerPhone
                                                                                                                                          )) {
                                                                                                                                          Object this$designManager = this.getDesignManager();
                                                                                                                                          Object other$designManager = other.getDesignManager();
                                                                                                                                          if (this$designManager
                                                                                                                                                == null
                                                                                                                                             ? other$designManager
                                                                                                                                                == null
                                                                                                                                             : this$designManager.equals(
                                                                                                                                                other$designManager
                                                                                                                                             )) {
                                                                                                                                             Object this$designManagerPhone = this.getDesignManagerPhone();
                                                                                                                                             Object other$designManagerPhone = other.getDesignManagerPhone();
                                                                                                                                             if (this$designManagerPhone
                                                                                                                                                   == null
                                                                                                                                                ? other$designManagerPhone
                                                                                                                                                   == null
                                                                                                                                                : this$designManagerPhone.equals(
                                                                                                                                                   other$designManagerPhone
                                                                                                                                                )) {
                                                                                                                                                Object this$customerRemark = this.getCustomerRemark();
                                                                                                                                                Object other$customerRemark = other.getCustomerRemark();
                                                                                                                                                if (this$customerRemark
                                                                                                                                                      == null
                                                                                                                                                   ? other$customerRemark
                                                                                                                                                      == null
                                                                                                                                                   : this$customerRemark.equals(
                                                                                                                                                      other$customerRemark
                                                                                                                                                   )) {
                                                                                                                                                   Object this$contractSignBodyScale = this.getContractSignBodyScale();
                                                                                                                                                   Object other$contractSignBodyScale = other.getContractSignBodyScale();
                                                                                                                                                   if (this$contractSignBodyScale
                                                                                                                                                         == null
                                                                                                                                                      ? other$contractSignBodyScale
                                                                                                                                                         == null
                                                                                                                                                      : this$contractSignBodyScale.equals(
                                                                                                                                                         other$contractSignBodyScale
                                                                                                                                                      )) {
                                                                                                                                                      Object this$projectManagerScale = this.getProjectManagerScale();
                                                                                                                                                      Object other$projectManagerScale = other.getProjectManagerScale();
                                                                                                                                                      return this$projectManagerScale
                                                                                                                                                            == null
                                                                                                                                                         ? other$projectManagerScale
                                                                                                                                                            == null
                                                                                                                                                         : this$projectManagerScale.equals(
                                                                                                                                                            other$projectManagerScale
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $dept = this.getDept();
      result = result * 59 + ($dept == null ? 43 : $dept.hashCode());
      Object $salesLeaderName = this.getSalesLeaderName();
      result = result * 59 + ($salesLeaderName == null ? 43 : $salesLeaderName.hashCode());
      Object $signingDate = this.getSigningDate();
      result = result * 59 + ($signingDate == null ? 43 : $signingDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $structureArea = this.getStructureArea();
      result = result * 59 + ($structureArea == null ? 43 : $structureArea.hashCode());
      Object $unitType = this.getUnitType();
      result = result * 59 + ($unitType == null ? 43 : $unitType.hashCode());
      Object $provincesAndMunicipalities = this.getProvincesAndMunicipalities();
      result = result * 59 + ($provincesAndMunicipalities == null ? 43 : $provincesAndMunicipalities.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $contractSignBody = this.getContractSignBody();
      result = result * 59 + ($contractSignBody == null ? 43 : $contractSignBody.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $partyType = this.getPartyType();
      result = result * 59 + ($partyType == null ? 43 : $partyType.hashCode());
      Object $sendingMode = this.getSendingMode();
      result = result * 59 + ($sendingMode == null ? 43 : $sendingMode.hashCode());
      Object $isBuilding = this.getIsBuilding();
      result = result * 59 + ($isBuilding == null ? 43 : $isBuilding.hashCode());
      Object $infoSource = this.getInfoSource();
      result = result * 59 + ($infoSource == null ? 43 : $infoSource.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $commercialClause = this.getCommercialClause();
      result = result * 59 + ($commercialClause == null ? 43 : $commercialClause.hashCode());
      Object $technologyClause = this.getTechnologyClause();
      result = result * 59 + ($technologyClause == null ? 43 : $technologyClause.hashCode());
      Object $otherRemarks = this.getOtherRemarks();
      result = result * 59 + ($otherRemarks == null ? 43 : $otherRemarks.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $customerUnitPhone = this.getCustomerUnitPhone();
      result = result * 59 + ($customerUnitPhone == null ? 43 : $customerUnitPhone.hashCode());
      Object $customerEmail = this.getCustomerEmail();
      result = result * 59 + ($customerEmail == null ? 43 : $customerEmail.hashCode());
      Object $partProvincesAndMunicipalities = this.getPartProvincesAndMunicipalities();
      result = result * 59 + ($partProvincesAndMunicipalities == null ? 43 : $partProvincesAndMunicipalities.hashCode());
      Object $customerAddress = this.getCustomerAddress();
      result = result * 59 + ($customerAddress == null ? 43 : $customerAddress.hashCode());
      Object $customerBankUserName = this.getCustomerBankUserName();
      result = result * 59 + ($customerBankUserName == null ? 43 : $customerBankUserName.hashCode());
      Object $customerBankCode = this.getCustomerBankCode();
      result = result * 59 + ($customerBankCode == null ? 43 : $customerBankCode.hashCode());
      Object $customerBankName = this.getCustomerBankName();
      result = result * 59 + ($customerBankName == null ? 43 : $customerBankName.hashCode());
      Object $receivingManager = this.getReceivingManager();
      result = result * 59 + ($receivingManager == null ? 43 : $receivingManager.hashCode());
      Object $receivingManagerPhone = this.getReceivingManagerPhone();
      result = result * 59 + ($receivingManagerPhone == null ? 43 : $receivingManagerPhone.hashCode());
      Object $settleManager = this.getSettleManager();
      result = result * 59 + ($settleManager == null ? 43 : $settleManager.hashCode());
      Object $settleManagerPhone = this.getSettleManagerPhone();
      result = result * 59 + ($settleManagerPhone == null ? 43 : $settleManagerPhone.hashCode());
      Object $financeManager = this.getFinanceManager();
      result = result * 59 + ($financeManager == null ? 43 : $financeManager.hashCode());
      Object $financeManagerPhone = this.getFinanceManagerPhone();
      result = result * 59 + ($financeManagerPhone == null ? 43 : $financeManagerPhone.hashCode());
      Object $auditManager = this.getAuditManager();
      result = result * 59 + ($auditManager == null ? 43 : $auditManager.hashCode());
      Object $auditManagerPhone = this.getAuditManagerPhone();
      result = result * 59 + ($auditManagerPhone == null ? 43 : $auditManagerPhone.hashCode());
      Object $designManager = this.getDesignManager();
      result = result * 59 + ($designManager == null ? 43 : $designManager.hashCode());
      Object $designManagerPhone = this.getDesignManagerPhone();
      result = result * 59 + ($designManagerPhone == null ? 43 : $designManagerPhone.hashCode());
      Object $customerRemark = this.getCustomerRemark();
      result = result * 59 + ($customerRemark == null ? 43 : $customerRemark.hashCode());
      Object $contractSignBodyScale = this.getContractSignBodyScale();
      result = result * 59 + ($contractSignBodyScale == null ? 43 : $contractSignBodyScale.hashCode());
      Object $projectManagerScale = this.getProjectManagerScale();
      return result * 59 + ($projectManagerScale == null ? 43 : $projectManagerScale.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectImportDTO(orderNo="
         + this.getOrderNo()
         + ", businessType="
         + this.getBusinessType()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", dept="
         + this.getDept()
         + ", salesLeaderName="
         + this.getSalesLeaderName()
         + ", signingDate="
         + this.getSigningDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", structureArea="
         + this.getStructureArea()
         + ", unitType="
         + this.getUnitType()
         + ", provincesAndMunicipalities="
         + this.getProvincesAndMunicipalities()
         + ", address="
         + this.getAddress()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", contractSignBody="
         + this.getContractSignBody()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", partyType="
         + this.getPartyType()
         + ", sendingMode="
         + this.getSendingMode()
         + ", isBuilding="
         + this.getIsBuilding()
         + ", infoSource="
         + this.getInfoSource()
         + ", contractAmount="
         + this.getContractAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", currencyType="
         + this.getCurrencyType()
         + ", commercialClause="
         + this.getCommercialClause()
         + ", technologyClause="
         + this.getTechnologyClause()
         + ", otherRemarks="
         + this.getOtherRemarks()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", socialCode="
         + this.getSocialCode()
         + ", customerUnitPhone="
         + this.getCustomerUnitPhone()
         + ", customerEmail="
         + this.getCustomerEmail()
         + ", partProvincesAndMunicipalities="
         + this.getPartProvincesAndMunicipalities()
         + ", customerAddress="
         + this.getCustomerAddress()
         + ", customerBankUserName="
         + this.getCustomerBankUserName()
         + ", customerBankCode="
         + this.getCustomerBankCode()
         + ", customerBankName="
         + this.getCustomerBankName()
         + ", receivingManager="
         + this.getReceivingManager()
         + ", receivingManagerPhone="
         + this.getReceivingManagerPhone()
         + ", settleManager="
         + this.getSettleManager()
         + ", settleManagerPhone="
         + this.getSettleManagerPhone()
         + ", financeManager="
         + this.getFinanceManager()
         + ", financeManagerPhone="
         + this.getFinanceManagerPhone()
         + ", auditManager="
         + this.getAuditManager()
         + ", auditManagerPhone="
         + this.getAuditManagerPhone()
         + ", designManager="
         + this.getDesignManager()
         + ", designManagerPhone="
         + this.getDesignManagerPhone()
         + ", customerRemark="
         + this.getCustomerRemark()
         + ", contractSignBodyScale="
         + this.getContractSignBodyScale()
         + ", projectManagerScale="
         + this.getProjectManagerScale()
         + ")";
   }
}
