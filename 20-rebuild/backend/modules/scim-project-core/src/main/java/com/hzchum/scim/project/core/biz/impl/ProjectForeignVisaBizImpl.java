package com.hzchum.scim.project.core.biz.impl;

import com.hzchum.pangu.common.util.ChineseYuanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractVisa;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractVisaService;
import com.hzchum.scim.project.core.api.biz.ProjectForeignVisaBiz;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ProjectForeignVisaBizImpl implements ProjectForeignVisaBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectForeignVisaBizImpl.class);
   @Resource
   private ContractVisaService contractVisaService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ConfigService configService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   @Lazy
   private UserService userService;

   @Override
   public void exportSettlement(Long id, HttpServletResponse response) {
      String resourcePath = "files/ProjectManagerSettlement.xlsx";
      String tempFileName = "ProjectManagerSettlement";
      String exportFileName = "项目结算单.xlsx";
      ContractVisa visa = this.contractVisaService.getById(id);
      ContractProject project = this.projectService.getById(visa.getProjectId());
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      Map<String, Object> map = new HashMap<>();
      String projectName = configVO.getShowProjectFullName() ? project.getName() : project.getShortName();
      String serialNumber = configVO.getShowSerialNumber() ? project.getSerialNumber() : "";
      if (configVO.getArrangement().equals(1)) {
         map.put("projectName", serialNumber + projectName);
      } else {
         map.put("projectName", projectName + serialNumber);
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      String contractSignBodyName = branchCompany != null ? branchCompany.getName() : "";
      map.put("contractSignBodyName", contractSignBodyName);
      map.put("settlementDate", DateTimeUtil.getLocalDateZhStr(visa.getSettlementDate()));
      map.put("userName", visa.getUserName());
      map.put("customerUnit", project.getCustomerUnit());
      map.put("signingDate", project.getSigningDate() != null ? DateTimeUtil.getLocalDateZhStr(project.getSigningDate()) : null);
      map.put("contractAmount", project.getContractAmount());
      map.put("marginAmount", project.getMarginAmount());
      map.put("projectManagerName", this.userService.getNameById(project.getProjectManagerId()));
      map.put("breachAmount", visa.getBreachAmount());
      map.put("visaAmount", visa.getVisaAmount());
      map.put("settlementAmount", visa.getSettlementAmount());
      map.put("settlementAmountStr", ChineseYuanUtil.toChinese(visa.getSettlementAmount().toString()));
      map.put("collectionAmount", project.getCollectionAmount());
      map.put("invoiceAmount", project.getInvoiceAmount());
      map.put("remark", visa.getRemark());
      map.put("attachmentRemark", visa.getAttachmentRemark());
      map.put("amountOwed", visa.getSettlementAmount().subtract(project.getCollectionAmount().setScale(2, RoundingMode.HALF_UP)));
      map.put("supplementaryInvoice", visa.getSettlementAmount().subtract(project.getInvoiceAmount().setScale(2, RoundingMode.HALF_UP)));
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }
}
