import { ref as F } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as p } from "vue";
import { unref as n } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as T } from "vue";
import { Fragment as I } from "vue";
import { renderList as N } from "vue";
import { createTextVNode as k } from "vue";
import { toDisplayString as S } from "vue";
import { ElMessageBox as A } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as j } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { ElOption as Q } from "element-plus";
import { ElSelect as J } from "element-plus";
import { ElTag as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { g as Z, e as L } from "../../../../modules/process-66f2e55f.js";
import { x as ee, aC as g, o as te, aD as R, aE as c, aF as d, G as D } from "../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
const oe = { class: "app-container" }, ae = { class: "head-container" }, le = { style: { display: "inline-block" } }, ie = { style: { display: "inline-block" } }, ue = { __name: "index", setup(se) {
  const $ = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = F(), { crud: u, columns: y, CRUD: _ } = ee({ title: "报检方式", sort: [], hasPagination: false, permission: { ...g }, optShow: { ...$ }, crudApi: { get: Z } }, h), { maxHeight: B } = te({ paginate: false });
  async function U(e, a) {
    try {
      await A.confirm(`此操作将把 “${e.name}” 工序的检验方式：
由“${d.VL[e.originInspectType]}”变更为 “${d.VL[a]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await L({ id: e.id, inspectType: a }), u.notify(`“${e.name}” 工序,检验方式变更为 “${d.VL[a]}” 成功`, _.NOTIFICATION_TYPE.SUCCESS), u.refresh();
    } catch (t) {
      console.log(t), e.inspectType = e.originInspectType;
    }
  }
  async function M(e, a) {
    try {
      await A.confirm(`此操作将把 “${e.name}” 工序的上报方式：
由“${c.VL[e.originReportType]}”变更为 “${c.VL[a]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await L({ id: e.id, reportType: a }), u.notify(`“${e.name}” 工序,上报方式变更为 “${c.VL[a]}” 成功`, _.NOTIFICATION_TYPE.SUCCESS), u.refresh();
    } catch (t) {
      console.log(t), e.reportType = e.originReportType;
    }
  }
  _.HOOK.handleRefresh = (e, { data: a }) => {
    a.content = a.map((t) => (t.originInspectType = t.inspectType, t.originReportType = t.reportType, t.reportDisabled = P(t), t.inspectDisabled = v(t), t));
  };
  function P(e) {
    return e.sequenceType === R.MACHINE_PART.V ? [c.BATCH_SCAN.V, c.SINGLE_SCAN.V] : [];
  }
  function v(e) {
    return e.sequenceType === R.MACHINE_PART.V ? [d.BATCH_SCAN.V, d.SINGLE_SCAN.V] : [];
  }
  return (e, a) => {
    const t = z, b = Y, w = j, V = K, C = Q, E = J, x = W, H = q("common-table"), O = X;
    return i(), f("div", oe, [m("div", ae, [p(n(ne))]), G((i(), r(H, { ref_key: "tableRef", ref: h, data: n(u).data, "empty-text": n(u).emptyText, "max-height": n(B), style: { width: "100%" } }, { default: s(() => [p(t, { label: "序号", type: "index", align: "center", width: "60" }), n(y).visible("name") ? (i(), r(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", align: "center", width: "140px" })) : T("", true), n(y).visible("reportType") ? (i(), r(t, { key: "reportType", prop: "reportType", label: "上报方式", "min-width": "170px", align: "center" }, { header: s(() => [p(V, { class: "item", effect: "light", "popper-class": "test", placement: "top", content: `上报方式设五种方式：

          机联：需与设备进行对对接，无需进行人工上报；

          单件（不扫码）：每次只能上报一个，不需要扫码；

          单件（需扫码）：每次只能上报一个，需要扫码；

          批量（不扫码）：每次可以上报多个，不需要扫码;

          批量（需扫码）：每次可以上报多个，需要扫码。` }, { default: s(() => [m("div", le, [a[0] || (a[0] = m("span", null, "上报方式", -1)), p(w, null, { default: s(() => [p(b)]), _: 1 })])]), _: 1 })]), default: s((o) => [n(D)(n(g).edit) ? (i(), r(E, { key: 0, modelValue: o.row.reportType, "onUpdate:modelValue": (l) => o.row.reportType = l, size: "default", placeholder: "请选择", "disabled-val": o.row.inspectDisabled, style: { width: "100%" }, onChange: (l) => M(o.row, o.row.reportType) }, { default: s(() => [(i(true), f(I, null, N(n(c).ENUM, (l) => (i(), r(C, { key: l.V, label: l.L, value: l.V, disabled: o.row.reportDisabled.includes(l.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled-val", "onChange"])) : (i(), r(x, { key: 1, type: n(c).V[o.row.reportType].T }, { default: s(() => [k(S(n(c).VL[o.row.reportType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : T("", true), n(y).visible("inspectType") ? (i(), r(t, { key: "inspectType", prop: "inspectType", label: "检验方式", "min-width": "170px", align: "center" }, { header: s(() => [p(V, { class: "item", effect: "light", placement: "top", content: `检验方式设四种方式：

          单件（不扫码）：每次只能检验一个，不需要扫码；

          单件（需扫码）：每次只能检验一个，需要扫码；

          批量（不扫码）：每次可以检验多个，不需要扫码;

          批量（需扫码）：每次可以检验多个，需要扫码。` }, { default: s(() => [m("div", ie, [a[1] || (a[1] = m("span", null, "检验方式", -1)), p(w, null, { default: s(() => [p(b)]), _: 1 })])]), _: 1 })]), default: s((o) => [n(D)(n(g).edit) ? (i(), r(E, { key: 0, modelValue: o.row.inspectType, "onUpdate:modelValue": (l) => o.row.inspectType = l, size: "default", placeholder: "请选择", style: { width: "100%" }, onChange: (l) => U(o.row, o.row.inspectType) }, { default: s(() => [(i(true), f(I, null, N(n(d).ENUM, (l) => (i(), r(C, { key: l.V, label: l.L, value: l.V, disabled: o.row.inspectDisabled.includes(l.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (i(), r(x, { key: 1, type: n(d).V[o.row.inspectType].T }, { default: s(() => [k(S(n(d).VL[o.row.inspectType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[O, n(u).loading]])]);
  };
} };
export {
  ue as default
};
