package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.system.core.api.service.MenuService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:module/module.properties", encoding = "UTF-8")
public class MenuRootRunner {
   @Autowired
   private MenuService menuService;
   @Resource
   private ContractProjectContentService projectContentService;
   private static Long CONTRACT = 3L;
   private static Long CONTRACT_SUPPLIER = 1019L;
   private static Long CONTRACT_SUPPLIER_PURCHASE_ORDER = 1020L;
   private static Long CONTRACT_SUPPLIER_MANUFACTURE_ORDER = 1021L;
   private static Long CONTRACT_SUPPLIER_LOGISTICS = 1022L;
   private static Long CONTRACT_SUPPLIER_PAYABLE_SUM = 1024L;
   private static Long CONTRACT_SUPPLIER_PAYMENT = 1025L;
   private static Long PROJECT = 4L;
   private static Long CONTRACT_PAYMENT_SUBORDER = 1023L;
   private static Long CONFIG_MANAGE_SUBCONFIG = 1208L;
   private static Long CONFIG_MANAGE_PROJECT_CONFIG = 1209L;
   private static Long SITE_QHSE = 8322L;
   private static Long SITE_INSTALL_AUDIT = 8323L;
   private static Long SITE_VISA_AUDIT = 8324L;
   private static Long SITE_IMAGE_PROCESS = 8325L;
   private static Long WMS = 5L;
   private static Long QIE_GE = 886L;
   private static Long MES = 2L;
   private static Long CHANGE_MANAGE = 43L;
   private static Long MES_PRODUCTION_CONFIG = 1178L;
   private static Long ASSEMBLE_TYPESETTING = 1236L;
   private static Long MACHINE_PART_SCHEDULING = 1244L;
   private static Long MACHINE_PART_ORDER = 1250L;
   private static Long DRILL_ORDER = 9347L;
   private static Long SEND_DIRECTLY_PART = 9030L;
   private static Long ENCLOSURE_MES = 11L;
   private static Long MES_ENCLOSURE_CONFIG = 9463L;
   private static Long APP_BUILDING_STATUS = 8381L;
   private static Long APP_BUILDING_CHART = 8308L;
   private static Long APP_BUILDING_MES = 8300L;
   private static Long APP_BUILDING_SMARTLINE = 8317L;
   private static Long MES_ENCLOSURE_CARGO = 9585L;
   private static Long MES_ENCLOSURE_PRODUCE = 9630L;
   private static Long APP_WORKBENCH = 565L;
   private static Long APP_REPORT = 566L;
   private static Long MATERIALS = 569L;
   private static Long SUPPLY_CHAIN = 7L;
   private static Long PURCHASE_ORDER_MANAGE = 1212L;
   private static Long REQUISITIONS_MANAGE = 1214L;
   private static Long PURCHASE_RECONCILIATION_MANAGE = 1216L;
   private static Long LOGISTICS_PAYMENT_MANAGE = 1221L;
   private static Long SUPPLY_SUB_MANAGE = 1224L;
   private static Long LOGISTICS_ORDER_MANAGE = 1227L;
   private static Long SUPPLIER_MANAGE = 1229L;
   private static Long PLAN_MODULE = 6L;
   private static Long PLAN_MANAGE = 1051L;
   private static Long TECHNICAL_MANAGE = 1057L;
   private static Long SMARTLINE_XML_MENU = 1069L;
   private static Long PLAN_ARTIFACT_MACHINE_PART = 1058L;
   private static Long PLAN_ARTIFACT_ = 1059L;
   private static Long PLAN_MACHINE_PART = 1060L;
   private static Long PLAN_ASSEMBLE = 1061L;
   private static Long PLAN_ENCLOSURE = 1062L;
   private static Long ENCLOSURE_INFO_CONFIG = 1203L;
   private static Long PLAN_AUXILIARY_MATERIAL = 1063L;
   private static Long AUXILIARY_MATERIAL_CONFIG = 1183L;
   private static Long SMARTLINE_MENU = 8317L;
   private static Long ENCLOSURE_MES_NEW = 9637L;
   private static Long CONFIG = 1L;
   private static final Long PROJECT_MODE_CONFIG = 1163L;
   private static Long ADD_SUBJECT = 612L;
   private static Long DELETE_SUBJECT = 613L;
   private static Long ADD_SPEC_CONFIG = 615L;
   private static Long EDIT_SPEC_CONFIG = 616L;
   private static Long DELETE_SPEC_CONFIG = 617L;
   private static Long AVERAGE_PRICE = 618L;
   private static Long EDIT_METERING_CONFIG = 620L;
   private static Long PROFILE_LIBRARY_ADD = 627L;
   private static Long PROFILE_LIBRARY_DELETE = 631L;
   private static Long PROFILE_LIBRARY_EDIT = 783L;
   private static Long WMS_CONFIG = 1170L;
   private static Long MACHINE_PART_CONFIG = 1182L;
   private static Long MACHINE_PART_PROCESS = 1188L;
   private static Long PART_BLANKING_CONFIG = 1201L;
   private static Long STANDARD_PART_CONFIG = 9344L;
   private static Long ASSEMBLE_RIVET_WELD_CONFIG = 1197L;
   private static Long PART_FABRICATED_CONFIG = 1198L;
   private static Long PARTS_DRILL_HOLE_CONFIG = 1199L;
   private static Long PARTS_LAYING_CONFIG = 1200L;
   private static Long OPERATION = 10L;
   private static Long BIM = 9L;
   private static Long BRIDGE_PRODUCT_CONFIG = 10000L;
   private static Long BRIDGE_MES = 12L;
   private static Long APP_BRIDGE_MES = 10367L;
   private static Long APP_BRIDGE_PROJECT = 10368L;
   private static Long APP_BRIDGE_report = 10354L;
   private static Long APP_BRIDGE_STATISTICS = 10362L;
   private static Long SHIP_BURIDGE_COUNT = 12394L;
   private static Long SHIP_MODULE = 9578L;

   public void deleteContract() {
      this.menuService.deleteMenuTree(CONTRACT);
   }

   public void deleteBim() {
      this.menuService.deleteMenuTree(BIM);
   }

   public void deletePlan() {
      this.menuService.deleteMenuTree(PLAN_MODULE);
   }

   public void deleteMes() {
      this.menuService.deleteMenuTree(MES);
      this.menuService.deleteMenuTree(PLAN_MODULE);
      this.menuService.deleteMenuTree(MES_PRODUCTION_CONFIG);
      this.menuService.deleteMenuTree(APP_BUILDING_STATUS);
      this.menuService.deleteMenuTree(APP_BUILDING_CHART);
      this.menuService.deleteMenuTree(APP_BUILDING_MES);
      this.menuService.deleteMenuTree(APP_BUILDING_SMARTLINE);
   }

   public void deleteAT() {
      this.menuService.deleteMenuTree(ASSEMBLE_TYPESETTING);
   }

   public void deletePartScheduling() {
      this.menuService.deleteMenuTree(MACHINE_PART_SCHEDULING);
   }

   public void deleteMachinePartOrder() {
      this.menuService.deleteMenuTree(MACHINE_PART_ORDER);
   }

   public void deleteDrillOrder() {
      this.menuService.deleteMenuTree(DRILL_ORDER);
   }

   public void deleteSendDirectlyPart() {
      this.menuService.deleteMenuTree(SEND_DIRECTLY_PART);
   }

   public void deleteWms() {
      this.menuService.deleteMenuTree(WMS);
      this.menuService.deleteMenuTree(WMS_CONFIG);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_PURCHASE_ORDER);
      this.menuService.deleteMenuTree(PURCHASE_ORDER_MANAGE);
      this.menuService.deleteMenuTree(PURCHASE_RECONCILIATION_MANAGE);
      this.menuService.deleteMenuTree(8301L);
   }

   public void deleteCut() {
      this.menuService.deleteMenuTree(QIE_GE);
   }

   public void deleteProject() {
      this.menuService.deleteMenuTree(CONTRACT_PAYMENT_SUBORDER);
      this.menuService.deleteMenuTree(SUPPLY_SUB_MANAGE);
      this.menuService.deleteMenuTree(CONFIG_MANAGE_SUBCONFIG);
      this.menuService.deleteMenuTree(CONFIG_MANAGE_PROJECT_CONFIG);
      this.menuService.deleteMenuTree(SITE_QHSE);
      this.menuService.deleteMenuTree(SITE_INSTALL_AUDIT);
      this.menuService.deleteMenuTree(SITE_VISA_AUDIT);
      this.menuService.deleteMenuTree(SITE_IMAGE_PROCESS);
   }

   public void deleteScmModule() {
      this.menuService.deleteMenuTree(SUPPLY_CHAIN);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER);
   }

   public void deleteScm() {
      this.menuService.deleteMenuTree(PURCHASE_ORDER_MANAGE);
      this.menuService.deleteMenuTree(REQUISITIONS_MANAGE);
      this.menuService.deleteMenuTree(PURCHASE_RECONCILIATION_MANAGE);
      this.menuService.deleteMenuTree(LOGISTICS_PAYMENT_MANAGE);
      this.menuService.deleteMenuTree(LOGISTICS_ORDER_MANAGE);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_PURCHASE_ORDER);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_MANUFACTURE_ORDER);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_LOGISTICS);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_PAYABLE_SUM);
      this.menuService.deleteMenuTree(CONTRACT_SUPPLIER_PAYMENT);
   }

   public void deleteClassify() {
      this.menuService.deleteMenuTree(ADD_SUBJECT);
      this.menuService.deleteMenuTree(DELETE_SUBJECT);
      this.menuService.deleteMenuTree(ADD_SPEC_CONFIG);
      this.menuService.deleteMenuTree(EDIT_SPEC_CONFIG);
      this.menuService.deleteMenuTree(DELETE_SPEC_CONFIG);
      this.menuService.deleteMenuTree(AVERAGE_PRICE);
      this.menuService.deleteMenuTree(EDIT_METERING_CONFIG);
      this.menuService.deleteMenuTree(PROFILE_LIBRARY_ADD);
      this.menuService.deleteMenuTree(PROFILE_LIBRARY_DELETE);
      this.menuService.deleteMenuTree(PROFILE_LIBRARY_EDIT);
   }

   public void deletePlanArtifact() {
   }

   public void deleteMachinePart() {
      this.menuService.deleteMenuTree(PLAN_MACHINE_PART);
   }

   public void deletePlanEnclosure() {
      this.menuService.deleteMenuTree(PLAN_ENCLOSURE);
      this.projectContentService
         .remove(Wrappers.lambdaQuery(ContractProjectContent.class).eq(ContractProjectContent::getCategoryType, ProjectContentCategoryEnum.ENCLOSURE.getType()));
      this.menuService.deleteMenuTree(ENCLOSURE_INFO_CONFIG);
   }

   public void deletePlanAm() {
      this.menuService.deleteMenuTree(PLAN_AUXILIARY_MATERIAL);
      this.menuService.deleteMenuTree(AUXILIARY_MATERIAL_CONFIG);
      this.projectContentService
         .remove(Wrappers.lambdaQuery(ContractProjectContent.class).eq(ContractProjectContent::getCategoryType, ProjectContentCategoryEnum.AUXILIARY.getType()));
   }

   public void deleteMesArtifact() {
   }

   public void deleteMesEnclosure() {
   }

   public void deleteMesAuxiliaryAaterial() {
   }

   public void deleteOperation() {
      this.menuService.deleteMenuTree(OPERATION);
   }

   public void deleteSmartLine() {
      this.menuService.deleteMenuTree(SMARTLINE_XML_MENU);
      this.menuService.deleteMenuTree(SMARTLINE_MENU);
   }

   public void deleteEnclosure() {
      this.menuService.deleteMenuTree(ENCLOSURE_MES);
      this.menuService.deleteMenuTree(MES_ENCLOSURE_CONFIG);
      this.menuService.deleteMenuTree(MES_ENCLOSURE_CARGO);
      this.menuService.deleteMenuTree(MES_ENCLOSURE_PRODUCE);
      this.menuService.deleteMenuTree(ENCLOSURE_MES_NEW);
      this.deletePlanEnclosure();
   }

   public void deleteBridge() {
      this.menuService.deleteMenuTree(BRIDGE_PRODUCT_CONFIG);
      this.menuService.deleteMenuTree(BRIDGE_MES);
      this.menuService.deleteMenuTree(APP_BRIDGE_MES);
      this.menuService.deleteMenuTree(APP_BRIDGE_PROJECT);
      this.menuService.deleteMenuTree(APP_BRIDGE_report);
      this.menuService.deleteMenuTree(APP_BRIDGE_STATISTICS);
      this.menuService.deleteMenuTree(SHIP_BURIDGE_COUNT);
      this.projectContentService
         .remove(Wrappers.lambdaQuery(ContractProjectContent.builder().categoryType(ProjectContentCategoryEnum.BODY_PARTS.getType()).build()));
   }

   public void deleteShip() {
      this.menuService.deleteMenuTree(SHIP_MODULE);
   }

   public void deleteModeConfig() {
      this.menuService.deleteMenuTree(PROJECT_MODE_CONFIG);
      this.menuService.deleteMenuTree(PART_BLANKING_CONFIG);
      this.menuService.deleteMenuTree(STANDARD_PART_CONFIG);
      this.menuService.deleteMenuTree(ASSEMBLE_RIVET_WELD_CONFIG);
      this.menuService.deleteMenuTree(PART_FABRICATED_CONFIG);
      this.menuService.deleteMenuTree(PARTS_DRILL_HOLE_CONFIG);
      this.menuService.deleteMenuTree(PARTS_LAYING_CONFIG);
   }

   public void deleteLeasedEditionMenu() {
      this.menuService.deleteMenuTree(MACHINE_PART_CONFIG);
      this.menuService.deleteMenuTree(MACHINE_PART_PROCESS);
      this.menuService.deleteMenuTree(PART_BLANKING_CONFIG);
      this.menuService.deleteMenuTree(PART_FABRICATED_CONFIG);
      this.menuService.deleteMenuTree(PARTS_DRILL_HOLE_CONFIG);
      this.menuService.deleteMenuTree(PARTS_LAYING_CONFIG);
   }
}
