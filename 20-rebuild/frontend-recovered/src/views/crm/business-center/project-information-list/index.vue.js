import { ref as s } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as T } from "vue";
import { createVNode as e } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as D } from "vue";
import { unref as o } from "vue";
import { createBlock as S } from "vue";
import { createCommentVNode as V } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as E } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElTag as R } from "element-plus";
import { x as j, o as B, G as g, lv as _, P as H } from "../../../../shared/runtime.js";
import { m as c } from "../../../../modules/crm-c6ba92ff.js";
import O from "./module/header.vue.js";
import { c as U } from "../../../../modules/project-information-ad6c6e75.js";
import L from "./module/detail.vue.js";
import "./module/panels.vue.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../../modules/dept-cascader-6af417b9.js";
import "../../../../modules/use-dept-b8e95315.js";
import "../../../../modules/project-information-053c195b.js";
import "../../../../modules/use-form-config-data-098a0552.js";
import "../../components/information-description/index.vue.js";
import "./module/approval-status.vue.js";
const I = { class: "app-container" }, A = { style: { float: "right", "margin-top": "10px" } }, oe = { __name: "index", setup(M) {
  const u = s({}), l = s(false), { crud: m, CRUD: b } = j({ title: "项目信息列表", crudApi: { ...U }, permission: { ...c } }), v = s([["informantDateTime", ["parse-time", "{y}-{m}-{d}"]], ["validityOfRegistrationDate", ["parse-time", "{y}-{m}-{d}"]], ["lastDistributionTime", ["parse-time", "{y}-{m}-{d}"]]]), { maxHeight: y } = B({ extraBox: [".head-container"], extraHeight: 50, paginate: true });
  function x(p) {
    g(c.detail) && (u.value = p, l.value = true);
  }
  return b.HOOK.handleRefresh = (p, r) => {
    var i;
    r.data.content = (i = r.data.content) == null ? void 0 : i.map((t) => t);
  }, (p, r) => {
    const i = w("print-table"), t = P, N = R, C = w("common-table");
    return h(), T("div", I, [e(O, null, { printBtn: n(() => [D("div", A, [o(g)(o(c).print) ? (h(), S(i, { key: 0, "api-key": "projectInfoList", params: { ...o(m).query }, size: "default", class: "filter-item", type: "warning" }, null, 8, ["params"])) : V("", true)])]), _: 1 }), e(C, { data: o(m).data, style: { width: "100%", cursor: "pointer" }, "data-format": v.value, "highlight-current-row": "", maxHeight: o(y), onRowClick: x }, { default: n(() => [e(t, { type: "index", align: "center", label: "序号", width: "60", fixed: "left" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "登记日期", prop: "informantDateTime", width: "120", fixed: "left" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "serialNumber", "min-width": "170", fixed: "left" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "projectName", "min-width": "220", fixed: "left" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "建设单位", prop: "crmEnterpriseWarehousingName", "min-width": "170" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "regionNameList", "min-width": "170" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", "min-width": "120" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "预估造价（万元）", prop: "estimatedCost", width: "140" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "项目等级", prop: "projectLevelConfigName", width: "100" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "部门", prop: "departmentName", "min-width": "130" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "填报人", prop: "informantUserName", "min-width": "130" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "创建人", prop: "createUserName", "min-width": "130" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "当前操作人", prop: "informationOperatorUserName", "min-width": "120" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "最新分配时间", prop: "lastDistributionTime", "min-width": "120" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "失效期", prop: "validityOfRegistrationDate", "min-width": "100" }), e(t, { align: "center", "show-overflow-tooltip": true, label: "剩余天数", prop: "validityOfRegistration", "min-width": "100" }), e(t, { align: "center", label: "状态", prop: "crmProjectScheduleTypeEnum", "min-width": "150", fixed: "right" }, { default: n(({ row: a }) => {
      var d;
      return [e(N, { type: (d = o(_).V[a.crmProjectScheduleTypeEnum]) == null ? void 0 : d.TYPE }, { default: n(() => {
        var f;
        return [k(E((f = o(_).V[a.crmProjectScheduleTypeEnum]) == null ? void 0 : f.L), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "maxHeight"]), e(o(H)), e(L, { modelValue: l.value, "onUpdate:modelValue": r[0] || (r[0] = (a) => l.value = a), "current-row": u.value, onSubmitSuccess: o(m).toQuery }, null, 8, ["modelValue", "current-row", "onSubmitSuccess"])]);
  };
} };
export {
  oe as default
};
