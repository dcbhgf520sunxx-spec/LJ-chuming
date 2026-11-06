package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Scrap;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.ScrapDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
import com.hzchum.scim.wms.core.api.service.wmsUse.ScrapService;
import com.hzchum.scim.wms.core.mapper.wmsUse.ScrapMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ScrapServiceImpl extends ServiceImpl<ScrapMapper, Scrap> implements ScrapService {
   @Resource
   ScrapMapper scrapMapper;
   @Resource
   ClassificationService classificationService;
   @Resource
   WorkshopService workshopService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   ContractProjectService contractProjectService;

   @Override
   public PageVO<ScrapDTO> pageInfo(QueryByMaterialDTOParam param, Integer pageNum, Integer size, List<String> sort) {
      if (CollectionUtil.isNotEmpty(param.getClassifyId())) {
         List<Classification> classifications = this.classificationService.listByIds(param.getClassifyId());
         ArrayList<Long> objects = new ArrayList<>();
         classifications.forEach(
            classification -> {
               if (!classification.getBoolLastEnum()) {
                  List<Long> collectx = this.classificationService
                     .getLastSubject(classification.getId())
                     .stream()
                     .map(Classification::getId)
                     .collect(Collectors.toList());
                  objects.addAll(collectx);
               } else {
                  objects.add(classification.getId());
               }
            }
         );
         param.setClassifyIds(objects);
      }

      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<Scrap> pageInfo = PageHelper.<Scrap>startPage(pageNum, size, s).doSelectPageInfo(() -> this.listInfo(param));
      List<ScrapDTO> collect = pageInfo.getList().stream().map(scrap -> {
         ScrapDTO scrapDTO = BeanUtil.copy(scrap, ScrapDTO.class);
         scrapDTO.setNationalStandard(scrap.getStandardName());
         Workshop workshop = this.workshopService.getById(scrap.getWorkshopId());
         if (workshop != null) {
            scrapDTO.setWorkshop(BeanUtil.copy(workshop, BriefIdAndNameDTO.class));
         }

         scrapDTO.setWarehouse(this.warehouseService.getById(scrap.getWarehouseId()));
         scrapDTO.setSerialNumber(this.classificationService.getById(scrap.getClassifyId()).getSerialNumber());
         if (scrap.getProjectId() != null) {
            scrapDTO.setProject(BeanUtil.copy(this.contractProjectService.getSimpleById(scrap.getProjectId()), ProjectInfoDTO.class));
         }

         return scrapDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(pageInfo, collect);
   }

   private List<Scrap> listInfo(QueryByMaterialDTOParam param) {
      return this.scrapMapper.listInfo(param);
   }
}
