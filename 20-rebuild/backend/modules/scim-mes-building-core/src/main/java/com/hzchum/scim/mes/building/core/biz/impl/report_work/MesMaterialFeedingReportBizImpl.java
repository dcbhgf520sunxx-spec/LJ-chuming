package com.hzchum.scim.mes.building.core.biz.impl.report_work;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.report_work.MesMaterialFeedingReportBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesMaterialFeedingReport;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportArtifactClassDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesMaterialFeedingReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesMaterialFeedingReportQuery;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesMaterialFeedingReportService;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesMaterialFeedingReportMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMaterialFeedingReportBizImpl
   extends IBizImpl<MesMaterialFeedingReportService, MesMaterialFeedingReportMapper, MesMaterialFeedingReport>
   implements MesMaterialFeedingReportBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private ContractProjectBiz projectBiz;
   @Autowired
   private TechArtifactService artifactService;

   @Override
   public PageVO<MesMaterialFeedingReportDTO> pageInfo(MesMaterialFeedingReportQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesMaterialFeedingReportDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public MesMaterialFeedingReportDTO detail(Long id) {
      return this.baseService.detail(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesMaterialFeedingReportParam param) {
      return this.baseService.add(param);
   }

   @Override
   public List<MesMaterialFeedingReportArtifactClassDTO> artifactClassList(Long projectId, Long monomerId, Long areaBatchId, String structureType) {
      return this.baseService.artifactClassList(projectId, monomerId, areaBatchId, structureType);
   }

   @Override
   public List<ProjectSimpleInfoDTO> haveListDataProjectList() {
      SecurityUser user = UserUtil.getCurrentUser();
      List<Long> haveListDataProjectIdList = this.artifactService.list().stream().map(TechArtifact::getProjectId).distinct().collect(Collectors.toList());
      List<ProjectSimpleInfoDTO> projectSimpleList = this.projectBiz.listAllProjectSimple();
      Stream<ProjectSimpleInfoDTO> stream = projectSimpleList.stream();
      if (CollUtil.isNotEmpty(haveListDataProjectIdList)) {
         stream = stream.filter(p -> haveListDataProjectIdList.contains(p.getId()));
      }

      if (!user.isAdmin()) {
         List<Long> projectIds = this.projectService.listProjectIdByUser(user.getId(), null);
         stream = stream.filter(p -> projectIds.contains(p.getId()));
      }

      return stream.sorted(Comparator.comparing(ProjectSimpleInfoDTO::getId).reversed()).collect(Collectors.toList());
   }
}
