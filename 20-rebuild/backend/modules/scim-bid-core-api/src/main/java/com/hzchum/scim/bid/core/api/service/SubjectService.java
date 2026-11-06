package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo._do.Subject;
import java.util.List;

public interface SubjectService extends IService<Subject> {
   ListVO tree(Boolean configuration);

   ListVO listFirst(Long subjectId);

   String getFullNameBySubjectId(Long subjectId);

   List<Subject> getSubject();
}
