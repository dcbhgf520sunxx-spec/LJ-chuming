package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo.dto.ProjectTenderingDTO;
import com.hzchum.scim.bid.core.api.pojo.dto.TendQueryConditionsDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.ProjectTenderingVO;
import java.util.List;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;

public interface ProjectTenderingService extends IService<ProjectTendering> {
   Long saveInstance(ProjectTenderingDTO dto);

   PageVO<ProjectTenderingVO> getPageAll(TendQueryConditionsDTO dto, Integer page, Integer size, List<String> sort, Integer menu);

   ProjectTendering getById(Long projectId);

   List<ProjectTendering> getProject(String uuid);

   Long updateProject(ProjectTenderingDTO dto);

   Integer checkProjectProgress(Long id, Integer projectProgress, Long bidDeadline, Long bidOpeningTime);

   @Async
   Future<Integer> checkProject(Long id, Integer status);

   Boolean modifyTime(Long id, Long bidDeadline, Long bidOpeningTime);

   ListVO getOverview(Long startTime, Long endTime);

   ListVO getBidType(Long startTime, Long endTime, Long projectType);

   ProjectTenderingVO selectByProjectId(Long id);

   void setTendering(String uuid);
}
