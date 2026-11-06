package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SourceEnum;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.SmallArtifactClassEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfigDetail;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class MesSectionWarehouseConfigV2Runner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesSectionWarehouseConfigV2Runner.class);
   private final MesSectionWarehouseConfigService sectionWarehouseConfigService;
   private final MesSectionWarehouseConfigDetailService sectionWarehouseConfigDetailService;

   @Override
   public void run(String... args) throws Exception {
      List<MesSectionWarehouseConfig> warehouseConfigs = this.sectionWarehouseConfigService.list();
      if (CollectionUtils.isEmpty(warehouseConfigs)) {
         this.buildArtifactConfig();
         this.buildAssembleConfig();
         this.buildPartConfig();
         this.buildAuxiliaryConfig();
      }
   }

   private void buildArtifactConfig() {
      MesSectionWarehouseConfig artifactMemberTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .productClassificationEnum(ArtifactTypeEnum.COMMON.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(artifactMemberTypeNameConfig);
      List<String> artifactMemberTypeNameList = Arrays.asList(
         "焊接型H型钢",
         "焊接T型钢",
         "焊接型箱型钢",
         "热轧H型钢",
         "宽翼缘H型钢",
         "中翼缘H型钢",
         "窄翼缘H型钢",
         "桩用H型钢",
         "薄壁H型钢",
         "宽翼缘T型钢",
         "中翼缘T型钢",
         "窄翼缘T型钢",
         "圆管构件",
         "方/矩形管构件",
         "成品方管构件",
         "成品矩形构件",
         "圆管形构件",
         "板卷锥管",
         "C型钢",
         "Z型钢",
         "工字钢",
         "槽钢",
         "圆钢",
         "高频焊H型构件",
         "焊接十字构件",
         "工字钢构件",
         "天沟构件",
         "花纹板",
         "异型构件",
         "牛腿",
         "丌型构件",
         "直发件",
         "定位板",
         "埋件",
         "平台板",
         "油漆直发板",
         "焊接槽钢",
         "折弯主构件",
         "构件增加吊耳",
         "爬梯构件",
         "栏杆",
         "拉条",
         "檩托",
         "钢板墙"
      );
      List<MesSectionWarehouseConfigDetail> artifactMemberTypeNameConfigDetailList = artifactMemberTypeNameList.stream()
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(artifactMemberTypeNameConfig.getId())
               .name(name)
               .productType(artifactMemberTypeNameConfig.getProductType())
               .productSectionNameEnum(artifactMemberTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(artifactMemberTypeNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(artifactMemberTypeNameConfigDetailList);
      MesSectionWarehouseConfig artifactSmallTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .productClassificationEnum(ArtifactTypeEnum.SMALL.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(artifactSmallTypeNameConfig);
      List<String> artifactSmallTypeNameList = Arrays.asList(
         "圆钢制品", "槽钢制品", "Z型檩条", "C型檩条", "预埋件", "钢板制品", "圆管制品", "角钢制品", "热轧T型构件", "型材T型次构件", "折弯构件", "油漆类角钢", "柱间支撑", "行槽型构件", "钢楼梯", "组合桥"
      );
      List<MesSectionWarehouseConfigDetail> artifactSmallTypeNameConfigDetailList = artifactSmallTypeNameList.stream()
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(artifactSmallTypeNameConfig.getId())
               .name(name)
               .productType(artifactSmallTypeNameConfig.getProductType())
               .productSectionNameEnum(artifactSmallTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(artifactSmallTypeNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(artifactSmallTypeNameConfigDetailList);
      MesSectionWarehouseConfig artifactMemberNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .productClassificationEnum(ProductClassificationEnum.PRIMARY_MEMBER.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_NAME.getType())
         .build();
      this.sectionWarehouseConfigService.save(artifactMemberNameConfig);

      for (String name : Arrays.asList(
         "钢柱",
         "箱型柱",
         "十字转箱型柱",
         "丁字柱",
         "十字柱",
         "方管柱",
         "圆管柱",
         "格构柱",
         "女儿墙柱",
         "天窗柱",
         "楼梯柱",
         "气楼柱",
         "抗风柱",
         "管桁架",
         "桁架柱",
         "牛腿",
         "平台柱",
         "山墙柱",
         "双支柱",
         "异形柱",
         "变截面柱",
         "转接钢柱",
         "双抱柱",
         "地下柱",
         "实腹柱",
         "支撑柱",
         "网格柱",
         "拱形柱",
         "大小头柱",
         "抗震柱",
         "预埋柱脚",
         "钢梁",
         "吊车梁",
         "行车梁",
         "平台梁",
         "框架梁",
         "箱型梁",
         "雨蓬梁",
         "屋面梁",
         "人字梁",
         "楼梯梁",
         "天窗梁",
         "框架次梁",
         "支柱",
         "钢桁架",
         "钢托架",
         "连廊钢梁",
         "緞带梁",
         "自制圆管柱"
      )) {
         MesSectionWarehouseConfigDetail configNameDetail = MesSectionWarehouseConfigDetail.builder()
            .configId(artifactMemberNameConfig.getId())
            .name(name)
            .productType(artifactMemberNameConfig.getProductType())
            .productSectionNameEnum(artifactMemberNameConfig.getProductSectionNameEnum())
            .productClassificationEnum(artifactMemberNameConfig.getProductClassificationEnum())
            .source(SourceEnum.CURRENT_SYSTEM.getType())
            .build();
         this.sectionWarehouseConfigDetailService.save(configNameDetail);
      }

      MesSectionWarehouseConfig artifactSmallNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .productClassificationEnum(ProductClassificationEnum.SECONDARY_MEMBER.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_NAME.getType())
         .build();
      this.sectionWarehouseConfigService.save(artifactSmallNameConfig);

      for (String name : Arrays.asList(
         "系杆",
         "方管系杆",
         "圆管系杆",
         "隅撑",
         "拉条",
         "支撑",
         "圆管支撑",
         "方管支撑",
         "圆钢支撑",
         "柱撑",
         "制动斜撑",
         "水撑",
         "车档",
         "套管",
         "天沟托架",
         "支托",
         "楼梯",
         "爬梯",
         "检修爬梯",
         "气楼架",
         "花纹钢板",
         "斜拉条",
         "预埋件",
         "埋件",
         "方管",
         "圆管",
         "角钢",
         "圆钢",
         "斜撑",
         "槽钢",
         "焊成型钢板",
         "墙檩连接角钢",
         "门柱连接角钢",
         "墙檩连接折弯件",
         "撑杆",
         "封山角钢杆",
         "室外爬梯平台",
         "支撑系杆",
         "平台板",
         "吊钩",
         "墙面撑杆",
         "柱间支撑",
         "双拼檩条",
         "双抱檩条",
         "檩条"
      )) {
         MesSectionWarehouseConfigDetail configNameDetail = MesSectionWarehouseConfigDetail.builder()
            .configId(artifactSmallNameConfig.getId())
            .name(name)
            .productType(artifactSmallNameConfig.getProductType())
            .productSectionNameEnum(artifactSmallNameConfig.getProductSectionNameEnum())
            .productClassificationEnum(artifactSmallNameConfig.getProductClassificationEnum())
            .source(SourceEnum.CURRENT_SYSTEM.getType())
            .build();
         this.sectionWarehouseConfigDetailService.save(configNameDetail);
      }

      MesSectionWarehouseConfig artifactMemberSectionNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .productClassificationEnum(ProductClassificationEnum.SECONDARY_MEMBER.getType() | ProductClassificationEnum.PRIMARY_MEMBER.getType())
         .productSectionNameEnum(ProductSectionNameEnum.SECTION_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(artifactMemberSectionNameConfig);
      List<String> artifactMemberSectionNameList = Arrays.asList(
         "BH",
         "BP",
         "H",
         "HI",
         "PHI",
         "HN",
         "HP",
         "T",
         "HM",
         "ZZ",
         "HW",
         "BOX",
         "HK",
         "CHS",
         "PD",
         "PIP",
         "SHS",
         "RHS",
         "P",
         "GPH",
         "LH",
         "HFW",
         "D",
         "C",
         "CC",
         "PL",
         "L",
         "I",
         "BTG",
         "BT",
         "ZTG",
         "TW",
         "TM",
         "TN",
         "HWB",
         "PTB",
         "BL",
         "BLL",
         "WLT",
         "EPD",
         "QD"
      );
      List<String> sendDirectlyList = Arrays.asList("CC,ZZ,WLT".split(","));
      List<MesSectionWarehouseConfigDetail> artifactMemberSectionNameConfigDetailList = artifactMemberSectionNameList.stream()
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(artifactMemberSectionNameConfig.getId())
               .name(name)
               .smallArtifactClassEnum(sendDirectlyList.contains(name) ? SmallArtifactClassEnum.PURLIN.getType() : null)
               .productType(artifactMemberSectionNameConfig.getProductType())
               .productSectionNameEnum(artifactMemberSectionNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(artifactMemberSectionNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(artifactMemberSectionNameConfigDetailList);
   }

   private void buildAssembleConfig() {
      MesSectionWarehouseConfig assembleProductNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ASSEMBLE.getType())
         .productClassificationEnum(ProductClassificationEnum.ASSEMBLE.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(assembleProductNameConfig);
      List<String> assembleProductNameList = Arrays.asList(
         "焊接H型部件", "焊接箱型部件", "焊接T型部件", "焊接十字部件", "热轧T型钢部件", "板卷锥管", "C型钢", "Z型钢", "成品T型钢部件", "天沟制品", "钢板制作角钢", "折弯件", "变更外带件", "钢筋连接器", "丌型构件", "锥形管部件"
      );
      List<MesSectionWarehouseConfigDetail> assembleProductNameConfigDetailList = assembleProductNameList.stream()
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(assembleProductNameConfig.getId())
               .name(name)
               .productType(assembleProductNameConfig.getProductType())
               .productSectionNameEnum(assembleProductNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(assembleProductNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(assembleProductNameConfigDetailList);
      MesSectionWarehouseConfig assembleTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.ASSEMBLE.getType())
         .productClassificationEnum(ProductClassificationEnum.ASSEMBLE.getType())
         .productSectionNameEnum(ProductSectionNameEnum.SECTION_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(assembleTypeNameConfig);
      List<String> assembleTypeNameList = Arrays.asList(
         "BH",
         "PHI",
         "HI",
         "H",
         "BOX",
         "HK",
         "WB",
         "十",
         "CC",
         "ZZ",
         "BT",
         "TW",
         "TN",
         "TM",
         "BTG",
         "ZTG",
         "BLL",
         "BL",
         "Z",
         "W",
         "WP",
         "X",
         "WX",
         "GTT",
         "丌",
         "LJ",
         "PL",
         "EPD",
         "BP",
         "T"
      );
      List<MesSectionWarehouseConfigDetail> assembleTypeNameConfigDetailList = assembleTypeNameList.stream()
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(assembleTypeNameConfig.getId())
               .name(name)
               .productType(assembleTypeNameConfig.getProductType())
               .productSectionNameEnum(assembleTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(assembleTypeNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(assembleTypeNameConfigDetailList);
   }

   private void buildPartConfig() {
      MesSectionWarehouseConfig partPlateTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .productClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(partPlateTypeNameConfig);
      List<MesSectionWarehouseConfigDetail> partPlateTypeNameConfigDetailList = Stream.of("零件板", "翼腹板")
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(partPlateTypeNameConfig.getId())
               .name(name)
               .productType(partPlateTypeNameConfig.getProductType())
               .productSectionNameEnum(partPlateTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(partPlateTypeNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(partPlateTypeNameConfigDetailList);
      MesSectionWarehouseConfig specPartConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .productClassificationEnum(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
         .productSectionNameEnum(ProductSectionNameEnum.SECTION_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(specPartConfig);
      List<MesSectionWarehouseConfigDetail> specPartConfigDetailList = Stream.of("PL")
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(specPartConfig.getId())
               .name(name)
               .productType(specPartConfig.getProductType())
               .productSectionNameEnum(specPartConfig.getProductSectionNameEnum())
               .productClassificationEnum(specPartConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(specPartConfigDetailList);
      MesSectionWarehouseConfig assemblePlateTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .productClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(assemblePlateTypeNameConfig);
      List<MesSectionWarehouseConfigDetail> assemblePlateTypeNameConfigDetailList = Stream.of(
            "热轧H型部件", "成品方管部件", "成品矩形管部件", "圆管形部件", "角钢", "圆钢", "工字钢", "槽钢", "钢格栅", "高频焊"
         )
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(assemblePlateTypeNameConfig.getId())
               .name(name)
               .productType(assemblePlateTypeNameConfig.getProductType())
               .productSectionNameEnum(assemblePlateTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(assemblePlateTypeNameConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(assemblePlateTypeNameConfigDetailList);
      MesSectionWarehouseConfig assemblePartConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .productClassificationEnum(ProductClassificationEnum.SECTION_PRODUCT.getType())
         .productSectionNameEnum(ProductSectionNameEnum.SECTION_TYPE_ENUM.getType())
         .build();
      this.sectionWarehouseConfigService.save(assemblePartConfig);
      List<MesSectionWarehouseConfigDetail> assemblePartConfigDetailList = Stream.of(
            "HN", "HW", "HM", "HP", "HT", "FL", "T", "SHS", "RHS", "P", "CHS", "PD", "PIP", "L", "D", "I", "C", "GS", "LH", "GPH", "HFW", "CC", "ZZ"
         )
         .map(
            name -> MesSectionWarehouseConfigDetail.builder()
               .configId(assemblePartConfig.getId())
               .name(name)
               .productType(assemblePartConfig.getProductType())
               .productSectionNameEnum(assemblePartConfig.getProductSectionNameEnum())
               .productClassificationEnum(assemblePartConfig.getProductClassificationEnum())
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build()
         )
         .collect(Collectors.toList());
      this.sectionWarehouseConfigDetailService.saveBatch(assemblePartConfigDetailList);
   }

   private void buildAuxiliaryConfig() {
      List<String> auxiliaryProductTypeNames = Arrays.asList("栓钉", "套筒", "螺栓");
      MesSectionWarehouseConfig auxiliaryProductTypeNameConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         .productClassificationEnum(ProductClassificationEnum.AUXILIARY_MATERIAL.getType())
         .productSectionNameEnum(ProductSectionNameEnum.PRODUCT_NAME.getType())
         .build();
      this.sectionWarehouseConfigService.save(auxiliaryProductTypeNameConfig);
      auxiliaryProductTypeNames.forEach(
         name -> {
            MesSectionWarehouseConfigDetail detail = MesSectionWarehouseConfigDetail.builder()
               .configId(auxiliaryProductTypeNameConfig.getId())
               .productType(auxiliaryProductTypeNameConfig.getProductType())
               .productSectionNameEnum(auxiliaryProductTypeNameConfig.getProductSectionNameEnum())
               .productClassificationEnum(auxiliaryProductTypeNameConfig.getProductClassificationEnum())
               .name(name)
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build();
            this.sectionWarehouseConfigDetailService.save(detail);
         }
      );
      List<String> auxiliaryNumberPrefix = Collections.singletonList("STUD");
      MesSectionWarehouseConfig auxiliaryNumberPrefixConfig = MesSectionWarehouseConfig.builder()
         .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
         .productClassificationEnum(ProductClassificationEnum.AUXILIARY_MATERIAL.getType())
         .productSectionNameEnum(ProductSectionNameEnum.NUMBERING_PREFIX.getType())
         .build();
      this.sectionWarehouseConfigService.save(auxiliaryNumberPrefixConfig);
      auxiliaryNumberPrefix.forEach(
         name -> {
            MesSectionWarehouseConfigDetail detail = MesSectionWarehouseConfigDetail.builder()
               .configId(auxiliaryNumberPrefixConfig.getId())
               .productType(auxiliaryNumberPrefixConfig.getProductType())
               .productSectionNameEnum(auxiliaryNumberPrefixConfig.getProductSectionNameEnum())
               .productClassificationEnum(auxiliaryNumberPrefixConfig.getProductClassificationEnum())
               .name(name)
               .source(SourceEnum.CURRENT_SYSTEM.getType())
               .build();
            this.sectionWarehouseConfigDetailService.save(detail);
         }
      );
   }

   public MesSectionWarehouseConfigV2Runner(
      final MesSectionWarehouseConfigService sectionWarehouseConfigService, final MesSectionWarehouseConfigDetailService sectionWarehouseConfigDetailService
   ) {
      this.sectionWarehouseConfigService = sectionWarehouseConfigService;
      this.sectionWarehouseConfigDetailService = sectionWarehouseConfigDetailService;
   }
}
