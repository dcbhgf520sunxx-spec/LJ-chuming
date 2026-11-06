package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.mes.building.core.api.enums.PartProdModeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessInspectTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProcessReportTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductCategoryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(103)
@Component
public class MesBuildingProcessRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProcessRunner.class);
   @Resource
   private MesBuildingProcessService processService;
   public static final String PART_BAN_SK_XL = "数控火焰,火焰直条,数控等离子,数控激光";
   public static final String PART_BAN_SK_ZK = "平面钻,摇臂钻,冲孔,钻孔";
   public static final String PART_BAN_BZD_XL = "剪板,半自动,卷板";
   public static final String PART_BAN_BZD_ZK = "钻孔";
   public static final String PART_XC_SK_XL = "车丝,相贯切割,钻割锁,型材切割,锯床,冷湾,热弯";
   public static final String PART_XC_SK_ZK = "三维钻,钻孔";
   public static final String ASS_HJ = "组立,箱型组焊,门焊,盖面,埋弧焊,组U,组焊,组焊一体,二次组立";
   public static final String ART_ZC = "装配,焊接,拼装,清磨,机器拼装,机器焊接,抛丸,制造,装配";
   public static final String ART_PAINT = "涂装,机器喷涂";
   public static final String LH_PART_BAN_SK_ZK = "冲孔";
   public static final String LH_ASS_HJ = "端铣,电渣焊,隔板,打底焊,矫正";

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingProcess> processList = this.processService.list();
      if (CollectionUtils.isEmpty(processList)) {
         List<String> partBanSkXl = Arrays.asList("数控火焰,火焰直条,数控等离子,数控激光".split(","));
         List<String> partBanSkZk = Arrays.asList("平面钻,摇臂钻,冲孔,钻孔".split(","));
         List<String> partBanBzdXl = Arrays.asList("剪板,半自动,卷板".split(","));
         List<String> partBanBzdZk = Arrays.asList("钻孔".split(","));
         List<String> partXcSkXl = Arrays.asList("车丝,相贯切割,钻割锁,型材切割,锯床,冷湾,热弯".split(","));
         List<String> partXcSkZk = Arrays.asList("三维钻,钻孔".split(","));
         List<String> assHj = Arrays.asList("组立,箱型组焊,门焊,盖面,埋弧焊,组U,组焊,组焊一体,二次组立".split(","));
         List<String> artZc = Arrays.asList("装配,焊接,拼装,清磨,机器拼装,机器焊接,抛丸,制造,装配".split(","));
         List<String> artAP = Arrays.asList("涂装,机器喷涂".split(","));
         List<String> lhPartBanSkZk = Arrays.asList("冲孔".split(","));
         List<String> lhAssHj = Arrays.asList("端铣,电渣焊,隔板,打底焊,矫正".split(","));
         List<MesBuildingProcess> addLists = new ArrayList<>();
         AtomicInteger i = new AtomicInteger();
         partBanSkXl.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.SHEET_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.CNCUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.MAKINGS.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         partBanSkZk.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.SHEET_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.CNCUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.DRILL_HOLE.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         partBanBzdXl.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.SHEET_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.SEMI_AUTO_CUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.MAKINGS.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         partBanBzdZk.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.SHEET_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.SEMI_AUTO_CUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.DRILL_HOLE.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         partXcSkXl.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.PROFILE_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.CNCUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.MAKINGS.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         partXcSkZk.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.PROFILE_PART.getType())
                  .boolFixedProcess(true)
                  .partProdMode(PartProdModeEnum.CNCUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.DRILL_HOLE.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         assHj.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.WELDED_PROFILE.getType())
                  .boolFixedProcess(true)
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .type(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())
                  .productType(ProductTypeEnum.ASSEMBLE.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         artZc.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.PRIMARY_SECONDARY.getType())
                  .boolFixedProcess(true)
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .type(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         artAP.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.PRIMARY_SECONDARY.getType())
                  .boolFixedProcess(true)
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .type(ProcessTypeEnum.PAINT.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         lhPartBanSkZk.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.SHEET_PART.getType())
                  .boolFixedProcess(false)
                  .partProdMode(PartProdModeEnum.CNCUTTING.getType())
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.MACHINE_PART.getType())
                  .type(ProcessTypeEnum.DRILL_HOLE.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         lhAssHj.forEach(
            e -> {
               i.set(1);
               MesBuildingProcess build = MesBuildingProcess.builder()
                  .name(e)
                  .productCategoryType(ProductCategoryTypeEnum.WELDED_PROFILE.getType())
                  .boolFixedProcess(false)
                  .reportType(ProcessReportTypeEnum.SINGLE_UNSCAN.getType())
                  .inspectType(ProcessInspectTypeEnum.SINGLE_UNSCAN.getType())
                  .productType(ProductTypeEnum.ASSEMBLE.getType())
                  .type(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())
                  .userId(1L)
                  .sort(i.get())
                  .build();
               i.getAndIncrement();
               addLists.add(build);
            }
         );
         this.processService.saveBatch(addLists);
      }
   }

   public MesBuildingProcessRunner(final MesBuildingProcessService processService) {
      this.processService = processService;
   }
}
