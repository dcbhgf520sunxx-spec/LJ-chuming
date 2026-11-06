import { ref as c } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as m } from "vue";
import { withCtx as u } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as S } from "vue";
import { ElTableColumn as E } from "element-plus";
import { c as W, g as I, _ as B } from "./module/header.vue.js";
import { x as V, o as U, G as w, lF as D, an as F, P as H } from "../../../../shared/runtime.js";
import { p as g } from "../../../../modules/crm-c6ba92ff.js";
import L from "./module/form.vue.js";
const A = { class: "app-container" }, M = { key: 0 }, R = { key: 1 }, J = { __name: "index", setup(O) {
  const N = c([["createTime", ["parse-time", "{y}-{m}-{d} {h}:{i}"]]]), b = c(), v = c({}), p = c([]), y = c(false), k = { add: false, edit: false, del: false, download: false }, { crud: d, columns: i } = V({ title: "技术服务委托", optShow: { ...k }, crudApi: { ...W }, permission: { ...g }, invisibleColumns: [], queryOnPresenterCreated: true }, b), { maxHeight: C } = U({ extraBox: [".head-container"], paginate: true });
  j(() => {
    P();
  });
  async function P() {
    var f;
    try {
      const s = await I();
      p.value = s || [], (f = p.value) == null || f.forEach((l) => {
        l.id = l.crmProjectInformationWarehousingId, l.name = l.crmProjectInformationWarehousingSerialNumber + " " + l.crmProjectInformationWarehousingName;
      });
    } catch (s) {
      console.log(s, "获取项目列表失败");
    }
  }
  return (f, s) => {
    const l = _("common-button"), o = E, T = _("common-table");
    return t(), h("div", A, [m(B, null, { addBtn: u(() => [e(w)(e(g).add) ? (t(), a(l, { key: 0, class: "filter-item", size: "default", type: "primary", icon: "el-icon-plus", onClick: e(d).toAdd }, { default: u(() => s[1] || (s[1] = [x(" 技术委托指定 ")])), _: 1, __: [1] }, 8, ["onClick"])) : r("", true)]), _: 1 }), m(T, { ref_key: "tableRef", ref: b, style: { width: "100%" }, data: e(d).data, maxHeight: e(C), "row-key": "id", "data-format": N.value }, { default: u(() => [m(o, { type: "index", align: "center", label: "序号", width: "60" }), e(i).visible("createTime") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "委托指定日期", prop: "createTime", key: "createTime", width: "140" })) : r("", true), e(i).visible("userName") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "指定负责人", prop: "userName", key: "userName", width: "120" })) : r("", true), e(i).visible("crmProjectInformationWarehousingSerialNumber") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目编号", prop: "crmProjectInformationWarehousingSerialNumber", key: "crmProjectInformationWarehousingSerialNumber", "min-width": "170" })) : r("", true), e(i).visible("crmProjectInformationWarehousingName") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "项目名称", prop: "crmProjectInformationWarehousingName", key: "crmProjectInformationWarehousingName", "min-width": "170" })) : r("", true), e(i).visible("crmEnterpriseWarehousingName") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "建设单位", prop: "crmEnterpriseWarehousingName", key: "crmEnterpriseWarehousingName", "min-width": "130" })) : r("", true), e(i).visible("regionNames") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "所属省市", prop: "regionNames", key: "regionNames", "min-width": "130" })) : r("", true), e(i).visible("structureTypeConfigurationName") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "结构类型", prop: "structureTypeConfigurationName", key: "structureTypeConfigurationName", "min-width": "120" })) : r("", true), e(i).visible("crmSettlementBusinessTypeEnum") ? (t(), a(o, { align: "center", label: "业务类型", prop: "crmSettlementBusinessTypeEnum", key: "crmSettlementBusinessTypeEnum", width: "120" }, { default: u(({ row: n }) => [n != null && n.crmSettlementBusinessTypeEnum ? (t(), h("span", M, S(e(D).VL[n == null ? void 0 : n.crmSettlementBusinessTypeEnum]), 1)) : (t(), h("span", R, "-"))]), _: 1 })) : r("", true), e(i).visible("estimatedCost") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "预估造价（万元）", prop: "estimatedCost", key: "estimatedCost", "min-width": "120" })) : r("", true), e(i).visible("createUserName") ? (t(), a(o, { align: "center", "show-overflow-tooltip": true, label: "委托指定人", prop: "createUserName", key: "createUserName", "min-width": "120" })) : r("", true), e(w)([...e(g).del]) ? (t(), a(o, { key: 10, label: "操作", width: "80px", align: "center" }, { default: u((n) => [m(F, { "show-edit": false, data: n.row }, null, 8, ["data"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data", "maxHeight", "data-format"]), m(e(H)), m(L, { modelValue: y.value, "onUpdate:modelValue": s[0] || (s[0] = (n) => y.value = n), "detail-info": v.value, projectList: p.value, onSuccess: e(d).toQuery }, null, 8, ["modelValue", "detail-info", "projectList", "onSuccess"])]);
  };
} };
export {
  J as default
};
