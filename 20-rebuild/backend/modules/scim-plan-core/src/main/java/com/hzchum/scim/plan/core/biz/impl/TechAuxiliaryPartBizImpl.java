package com.hzchum.scim.plan.core.biz.impl;

import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechAuxiliaryPartBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryPart;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechAuxiliaryPartSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechAuxiliaryPartQueryDTOParam;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryPartService;
import com.hzchum.scim.plan.core.mapper.TechAuxiliaryPartMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TechAuxiliaryPartBizImpl extends IBizImpl<TechAuxiliaryPartService, TechAuxiliaryPartMapper, TechAuxiliaryPart> implements TechAuxiliaryPartBiz {
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<TechAuxiliaryPartDTO> listAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.baseService.listAuxiliaryPart(param));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListAuxiliaryPart(TechAuxiliaryPartQueryDTOParam param) {
      List<TechAuxiliaryPartDTO> list = this.baseService.listAuxiliaryPart(param);
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (param.getProjectId() != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(param.getProjectId());
         header.put("project", projectInfo);
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = list.stream().map(ax -> BeanUtil.beanToMap(ax)).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public ListVO<TechAuxiliaryPartSummaryDTO> listSummary(Long projectId, Long monomerId, Long areaId) {
      return new ListVO<>(this.baseService.listAuxiliaryPartSummary(projectId, monomerId, areaId));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printListSummary(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (projectId != null) {
         ProjectInfo projectInfo = this.projectService.getSimpleById(projectId);
         header.put("project", projectInfo);
      }

      printVO.setHeader(header);
      List<TechAuxiliaryPartSummaryDTO> summaryDTOList = this.baseService.listAuxiliaryPartSummary(projectId, monomerId, areaId);
      List<Map<String, Object>> mapList = summaryDTOList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
