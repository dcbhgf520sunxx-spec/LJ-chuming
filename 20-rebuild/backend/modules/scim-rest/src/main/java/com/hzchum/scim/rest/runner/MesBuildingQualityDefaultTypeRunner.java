package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(102)
@Component
public class MesBuildingQualityDefaultTypeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingQualityDefaultTypeRunner.class);
   @Autowired
   private SysDictionaryService dictionaryService;
   @Autowired
   private MesQualityClassConfigService qualityClassConfigService;
   @Autowired
   private MesBuildingQhseService qhseService;

   @Override
   public void run(String... args) throws Exception {
      List<SysDictionary> sysDictionaries = this.dictionaryService.listByName(DictionaryEnum.MES_QHSE_PRODUCT_PROBLEM_TYPE.getName());
      List<String> lableList = sysDictionaries.stream().map(e -> e.getLabel()).collect(Collectors.toList());
      if (!CollectionUtils.isEmpty(lableList)) {
         List<MesQualityClassConfig> classConfigs = this.qualityClassConfigService
            .list(Wrappers.lambdaQuery(MesQualityClassConfig.class).in(MesQualityClassConfig::getName, lableList));
         if (CollectionUtils.isEmpty(classConfigs)) {
            ArrayList<MesQualityClassConfig> arrayList = new ArrayList<>();

            for (SysDictionary dictionary : sysDictionaries) {
               MesQualityClassConfig classConfig = new MesQualityClassConfig();
               classConfig.setId(Long.valueOf(dictionary.getValue()));
               classConfig.setPid(0L);
               classConfig.setName(dictionary.getLabel());
               classConfig.setStatus(true);
               classConfig.setFactoryOrConstructionSite(0);
               arrayList.add(classConfig);
            }

            this.qualityClassConfigService.saveBatch(arrayList);
         }

         List<MesBuildingQhse> qhseList = this.qhseService.list().stream().filter(e -> e.getQualityType() != null).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(qhseList)) {
            qhseList = qhseList.stream().map(e -> e.setLevelOneType(Long.valueOf(e.getQualityType().split(",")[0]))).collect(Collectors.toList());
            this.qhseService.updateBatchById(qhseList);
         }
      }
   }
}
