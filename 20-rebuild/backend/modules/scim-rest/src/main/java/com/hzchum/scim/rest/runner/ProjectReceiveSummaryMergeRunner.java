package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.project.core.api.enums.ProductTypeUpEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectReceiveSummaryMergeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectReceiveSummaryMergeRunner.class);
   @Resource
   private ProjectReceivingSummaryService summaryService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      List<ProjectReceivingSummary> allList = this.summaryService
         .list(Wrappers.lambdaQuery(ProjectReceivingSummary.class).ne(ProjectReceivingSummary::getProductType, ProductTypeUpEnum.RAW_MATERIAL.getType()));
      if (!CollectionUtils.isEmpty(allList)) {
         Map<String, List<ProjectReceivingSummary>> groupedByFields = allList.stream()
            .collect(Collectors.groupingBy(product -> product.getProjectType() + "-" + product.getProductType() + "-" + product.getProductId()));
         Map<String, List<ProjectReceivingSummary>> repeatedMap = groupedByFields.entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() > 1)
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
         List<Long> deleteIds = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(repeatedMap.keySet())) {
            repeatedMap.forEach((key, repeatedList) -> {
               repeatedList.sort(Comparator.comparing(BaseEntity::getCreateTime));
               ProjectReceivingSummary firstItem = repeatedList.get(0);

               for (int i = 1; i < repeatedList.size(); i++) {
                  ProjectReceivingSummary currentItem = repeatedList.get(i);
                  firstItem.setTotalArea(firstItem.getTotalArea().add(currentItem.getTotalArea()));
                  firstItem.setQuantity(firstItem.getQuantity().add(currentItem.getQuantity()));
                  firstItem.setMete(firstItem.getMete().add(currentItem.getMete()));
                  firstItem.setInstallQuantity(firstItem.getInstallQuantity().add(currentItem.getInstallQuantity()));
                  deleteIds.add(currentItem.getId());
               }

               this.summaryService.updateById(firstItem);
            });
         }

         this.summaryService.removeByIds(deleteIds);
      }
   }

   public ProjectReceiveSummaryMergeRunner(final ProjectReceivingSummaryService summaryService) {
      this.summaryService = summaryService;
   }
}
