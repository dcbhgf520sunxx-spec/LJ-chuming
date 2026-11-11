package com.hzchum.scim.bim.core.biz.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.bimface.data.bean.SearchElementIdsResp;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.QueryElementIdsRequest;
import com.google.common.base.Preconditions;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.enums.BimModelTypeEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusCommonEnum;
import com.hzchum.scim.bim.core.api.enums.BimTeklaEditionEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BimMonomerElementService {
   private static final Logger log = LoggerFactory.getLogger(BimMonomerElementService.class);
   private static final long CACHE_SECONDS = 3600L;
   private static final long MISS_CACHE_SECONDS = 60L;
   private static final int PAGE_SIZE = 10000;

   @Resource
   private BimfaceClient bimfaceClient;
   @Resource
   private RedisUtils redisUtils;
   @Value("${ljaps.integrations.bim.enabled:false}")
   private boolean enabled;

   public List<String> getElementIds(BimModelCommonDO model, Integer edition, String serialNumber) {
      String cacheKey = this.serialKey(model, edition, serialNumber);
      return this.findElementIds(model, edition, serialNumber, this.getViewerElementIds(model), cacheKey);
   }

   List<String> getElementIds(BimModelCommonDO model, Integer edition, String serialNumber, Set<String> viewerIds) {
      return this.findElementIds(model, edition, serialNumber, viewerIds, this.serialKey(model, edition, serialNumber));
   }

   private List<String> findElementIds(BimModelCommonDO model, Integer edition, String serialNumber, Set<String> viewerIds, String cacheKey) {
      List<String> cached = this.readIds(cacheKey);
      if (cached != null && viewerIds.containsAll(cached)) {
         return cached;
      }
      if (viewerIds.isEmpty()) {
         return Collections.emptyList();
      }

      String fileId = model.getFileId().toString();
      String property = edition <= BimTeklaEditionEnum.SEVENTEEN.getType() ? "Assembly_mark" : "Assembly mark";
      Map<String, Object> request = new LinkedHashMap<>();
      request.put("targetType", model.getModelType());
      request.put("targetIds", Collections.singletonList(fileId));
      request.put("query", Collections.singletonMap("in", Collections.singletonMap(property, Collections.singletonList(serialNumber))));

      Set<String> matched = new LinkedHashSet<>();
      int outsideViewer = 0;
      try {
         List<SearchElementIdsResp> results = this.bimfaceClient.getElements(JSON.toJSONString(request));
         Preconditions.checkState(results != null, "BIM 构件编号查询未返回结果");
         boolean foundTarget = results.isEmpty();
         for (SearchElementIdsResp result : results) {
            Preconditions.checkState(result != null && StrUtil.isNotBlank(result.getTargetId()), "BIM 构件编号查询返回格式错误");
            if (!fileId.equals(result.getTargetId())) {
               continue;
            }
            foundTarget = true;
            List<String> ids = result.getElementIds();
            Preconditions.checkState(ids != null, "BIM 构件编号查询缺少元件列表");
            for (String id : ids) {
               Preconditions.checkState(StrUtil.isNotBlank(id), "BIM 构件编号查询返回无效元件 ID");
               if (viewerIds.contains(id)) {
                  matched.add(id);
               } else {
                  outsideViewer++;
               }
            }
         }
         Preconditions.checkState(foundTarget, "BIM 构件编号查询返回了其他模型的数据");
         Preconditions.checkState(outsideViewer == 0 || !matched.isEmpty(), "BIM 构件映射与当前模型不一致，请重试");
      } catch (BimfaceException e) {
         throw new IllegalStateException("BIM 构件编号查询暂不可用，请重试", e);
      }
      if (outsideViewer > 0) {
         log.warn("BIM 构件编号查询忽略了当前模型 {} 中不存在的 {} 个元件 ID", fileId, outsideViewer);
      }
      List<String> ids = new ArrayList<>(matched);
      this.redisUtils.set(cacheKey, ids, ids.isEmpty() ? MISS_CACHE_SECONDS : CACHE_SECONDS);
      return ids;
   }

   List<String> getCachedElementIds(BimModelCommonDO model, Integer edition, String serialNumber) {
      if (StrUtil.isBlank(serialNumber)) {
         return Collections.emptyList();
      }
      List<String> cached = this.readIds(this.serialKey(model, edition, serialNumber));
      return cached == null ? Collections.emptyList() : cached;
   }

   public Set<String> getViewerElementIds(BimModelCommonDO model) {
      String cacheKey = this.fileKey(model) + ":VIEWER";
      List<String> cached = this.readIds(cacheKey);
      if (cached != null) {
         return new LinkedHashSet<>(cached);
      }

      Set<String> ids = new LinkedHashSet<>();
      try {
         String contextId = this.bimfaceClient.getPaginationContextId();
         Preconditions.checkState(StrUtil.isNotBlank(contextId), "BIM 模型元件列表缺少分页标识");
         QueryElementIdsRequest request = new QueryElementIdsRequest();
         request.setPaginationContextId(contextId);
         request.setPaginationSize(PAGE_SIZE);
         while (true) {
            List<String> page = this.bimfaceClient.getElementService().getElementIdsV2(model.getFileId(), request);
            Preconditions.checkState(page != null && page.stream().allMatch(StrUtil::isNotBlank), "BIM 模型元件列表返回格式错误");
            boolean advanced = ids.addAll(page);
            if (page.size() < PAGE_SIZE) {
               break;
            }
            Preconditions.checkState(advanced, "BIM 模型元件列表分页未推进");
         }
      } catch (BimfaceException e) {
         throw new IllegalStateException("BIM 模型元件列表暂不可用，请重试", e);
      }
      if (!ids.isEmpty()) {
         this.redisUtils.set(cacheKey, new ArrayList<>(ids), CACHE_SECONDS);
      }
      return ids;
   }

   private String serialKey(BimModelCommonDO model, Integer edition, String serialNumber) {
      Preconditions.checkArgument(edition != null && BimTeklaEditionEnum.isExist(edition), "单体模型缺少有效的 Tekla 版本配置");
      Preconditions.checkArgument(StrUtil.isNotBlank(serialNumber), "构件编号不能为空");
      return this.fileKey(model) + ":MARK:" + edition + ":" + serialNumber;
   }

   private String fileKey(BimModelCommonDO model) {
      Preconditions.checkState(this.enabled, "BIM 服务未启用");
      Preconditions.checkArgument(model != null && model.getMonomerId() != null && model.getFileId() != null && model.getFileId() > 0,
         "BIM 模型不存在");
      Preconditions.checkArgument(BimImportModeEnum.MONOMER_MODE.getType().equals(model.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(model.getModelType()) && model.getAreaId() == null, "BIM 单体模型类型错误");
      Preconditions.checkState(BimStatusCommonEnum.SUCCESS.getName().equals(model.getTranslateStatus()), "BIM 模型尚未转换成功");
      return "BIM:BUILDING:MONOMER:" + model.getMonomerId() + ":" + model.getFileId() + ":" + model.getAttachmentId();
   }

   private List<String> readIds(String cacheKey) {
      Object raw = this.redisUtils.get(cacheKey);
      if (!(raw instanceof List)) {
         return null;
      }
      List<String> ids = new ArrayList<>();
      for (Object id : (List<?>)raw) {
         if (!(id instanceof String) || StrUtil.isBlank((String)id)) {
            return null;
         }
         ids.add((String)id);
      }
      return ids;
   }
}
