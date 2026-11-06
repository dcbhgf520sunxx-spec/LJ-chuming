package com.hzchum.scim.mes.building.core.biz.impl.craft;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.craft.MesPaintConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.craft.MesPaintConfigService;
import com.hzchum.scim.mes.building.core.mapper.craft.MesPaintConfigMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MesPaintConfigBizImpl extends IBizImpl<MesPaintConfigService, MesPaintConfigMapper, MesPaintConfig> implements MesPaintConfigBiz {
   @Override
   public PageVO<MesPaintConfigDTO> pageInfo(MesPaintConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.baseService.pageInfo(query, pageNumber, pageSize, sort);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesPaintConfigParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesPaintConfigParam param) {
      return this.baseService.edit(param);
   }

   @Override
   public void templateDownload(HttpServletResponse response) {
      this.baseService.templateDownload(response);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void importData(MultipartFile file, HttpServletResponse response) {
      this.baseService.importData(file, response);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      return this.baseService.deleteById(id);
   }

   @Override
   public List<MesPaintConfigDTO> paintingCraftSelectList(MesPaintConfigQuery query) {
      return this.baseService.paintingCraftSelectList(query);
   }

   @Override
   public List<String> paintBrandList(String paintBrand) {
      return this.baseService.paintBrandList(paintBrand);
   }

   @Override
   public List<NameInfo> paintSelectList(Integer paintingTypeEnum) {
      return this.baseService.paintSelectList(paintingTypeEnum);
   }

   @Override
   public List<Map<String, Object>> commonPaintList(List<Integer> paintingTypeEnumList, List<String> paintBrandList, List<String> paintTypeList) {
      List<MesPaintConfig> list = this.baseService
         .list(
            ((new LambdaQueryWrapper<MesPaintConfig>()
                     .in(CollUtil.isNotEmpty(paintingTypeEnumList), MesPaintConfig::getPaintingTypeEnum, paintingTypeEnumList))
                  .in(CollUtil.isNotEmpty(paintBrandList), MesPaintConfig::getPaintBrand, paintBrandList))
               .in(CollUtil.isNotEmpty(paintTypeList), MesPaintConfig::getPaintType, paintTypeList)
         );
      return list.stream().map(i -> {
         Map<String, Object> m = new HashMap<>();
         m.put("paintingTypeEnum", i.getPaintingTypeEnum());
         m.put("paintBrand", i.getPaintBrand());
         m.put("paintType", i.getPaintType());
         return m;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean clear() {
      return this.baseService.remove((Wrapper<MesPaintConfig>)new LambdaUpdateWrapper<MesPaintConfig>().eq(BaseEntity::getBoolDeleteEnum, false));
   }

   @Override
   public List<Map<String, Object>> listAllPaintConfig(Integer paintingTypeEnum) {
      List<MesPaintConfig> paintConfigList = this.baseService
         .list(Wrappers.lambdaQuery(MesPaintConfig.class).eq(paintingTypeEnum != null, MesPaintConfig::getPaintingTypeEnum, paintingTypeEnum));
      if (paintConfigList.isEmpty()) {
         return Collections.emptyList();
      }

      List<Map<String, Object>> configMapList = new ArrayList<>(paintConfigList.size());
      paintConfigList.forEach(config -> {
         Map<String, Object> configMap = new HashMap<>(16);
         configMap.put("paintConfigId", config.getId());
         configMap.put("paintType", config.getPaintType());
         configMap.put("paintBrand", config.getPaintBrand());
         configMapList.add(configMap);
      });
      return configMapList;
   }
}
