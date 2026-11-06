import { ref as I } from "vue";
import { resolveComponent as G } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as p } from "vue";
import { unref as n } from "vue";
import { withDirectives as z } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createCommentVNode as T } from "vue";
import { Fragment as N } from "vue";
import { renderList as k } from "vue";
import { createTextVNode as S } from "vue";
import { toDisplayString as L } from "vue";
import { ElMessageBox as A } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { InfoFilled as Y } from "@element-plus/icons-vue";
import { ElIcon as j } from "element-plus";
import { ElTooltip as K } from "element-plus";
import { ElOption as J } from "element-plus";
import { ElSelect as W } from "element-plus";
import { ElTag as X } from "element-plus";
import { vLoading as Z } from "element-plus";
import { g as ee, e as R } from "../../../../modules/process-381d77e4.js";
import { x as te, oQ as g, o as ne, dM as D, aE as c, aF as d, G as $ } from "../../../../shared/runtime.js";
import oe from "./module/header.vue.js";
const le = { class: "app-container" }, ae = { class: "head-container" }, ie = { style: { display: "inline-block" } }, se = { style: { display: "inline-block" } }, me = { __name: "index", setup(re) {
  const B = { batchAdd: false, add: false, edit: false, del: false, download: false }, h = I(), { crud: u, columns: y, CRUD: _ } = te({ title: "报检方式", sort: [], hasPagination: false, permission: { ...g }, optShow: { ...B }, crudApi: { get: ee } }, h), { maxHeight: M } = ne({ paginate: false });
  async function U(t, o) {
    try {
      await A.confirm(`此操作将把 “${t.name}” 工序的检验方式：
由“${d.VL[t.originInspectType]}”变更为 “${d.VL[o]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await R({ id: t.id, inspectType: o }), u.notify(`“${t.name}” 工序,检验方式变更为 “${d.VL[o]}” 成功`, _.NOTIFICATION_TYPE.SUCCESS), u.refresh();
    } catch (e) {
      console.log(e), t.inspectType = t.originInspectType;
    }
  }
  async function v(t, o) {
    try {
      await A.confirm(`此操作将把 “${t.name}” 工序的上报方式：
由“${c.VL[t.originReportType]}”变更为 “${c.VL[o]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await R({ id: t.id, reportType: o }), u.notify(`“${t.name}” 工序,上报方式变更为 “${c.VL[o]}” 成功`, _.NOTIFICATION_TYPE.SUCCESS), u.refresh();
    } catch (e) {
      console.log(e), t.reportType = t.originReportType;
    }
  }
  const P = I();
  _.HOOK.handleRefresh = (t, { data: o }) => {
    P.value = o.filter((e) => e.productionLineTypeEnum === 1), o.content = o.map((e) => (e.originInspectType = e.inspectType, e.originReportType = e.reportType, e.reportDisabled = H(e), e.inspectDisabled = O(e), e)), console.log(o);
  };
  function H(t) {
    return t.sequenceType === D.MACHINE_PART.V ? [c.BATCH_SCAN.V, c.SINGLE_SCAN.V] : [];
  }
  function O(t) {
    return t.sequenceType === D.MACHINE_PART.V ? [d.BATCH_SCAN.V, d.SINGLE_SCAN.V] : [];
  }
  return (t, o) => {
    const e = Q, b = Y, w = j, V = K, C = J, E = W, x = X, F = G("common-table"), q = Z;
    return i(), f("div", le, [m("div", ae, [p(n(oe))]), z((i(), r(F, { ref_key: "tableRef", ref: h, data: n(u).data, "empty-text": n(u).emptyText, "max-height": n(M), style: { width: "100%" } }, { default: s(() => [p(e, { label: "序号", type: "index", align: "center", width: "60" }), n(y).visible("name") ? (i(), r(e, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", align: "center", width: "140px" })) : T("", true), n(y).visible("reportType") ? (i(), r(e, { key: "reportType", prop: "reportType", label: "上报方式", "min-width": "170px", align: "center" }, { header: s(() => [p(V, { class: "item", effect: "light", "popper-class": "test", placement: "top", content: `上报方式设五种方式：

          机联：需与设备进行对对接，无需进行人工上报；

          单件（不扫码）：每次只能上报一个，不需要扫码；

          单件（需扫码）：每次只能上报一个，需要扫码；

          批量（不扫码）：每次可以上报多个，不需要扫码;

          批量（需扫码）：每次可以上报多个，需要扫码。` }, { default: s(() => [m("div", ie, [o[0] || (o[0] = m("span", null, "上报方式", -1)), p(w, null, { default: s(() => [p(b)]), _: 1 })])]), _: 1 })]), default: s((l) => [n($)(n(g).edit) ? (i(), r(E, { key: 0, modelValue: l.row.reportType, "onUpdate:modelValue": (a) => l.row.reportType = a, size: "default", placeholder: "请选择", "disabled-val": l.row.inspectDisabled, style: { width: "100%" }, onChange: (a) => v(l.row, l.row.reportType) }, { default: s(() => [(i(true), f(N, null, k(n(c).ENUM, (a) => (i(), r(C, { key: a.V, label: a.L, value: a.V, disabled: l.row.reportDisabled.includes(a.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled-val", "onChange"])) : (i(), r(x, { key: 1, type: n(c).V[l.row.reportType].T }, { default: s(() => [S(L(n(c).VL[l.row.reportType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : T("", true), n(y).visible("inspectType") ? (i(), r(e, { key: "inspectType", prop: "inspectType", label: "检验方式", "min-width": "170px", align: "center" }, { header: s(() => [p(V, { class: "item", effect: "light", placement: "top", content: `检验方式设四种方式：

          单件（不扫码）：每次只能检验一个，不需要扫码；

          单件（需扫码）：每次只能检验一个，需要扫码；

          批量（不扫码）：每次可以检验多个，不需要扫码;

          批量（需扫码）：每次可以检验多个，需要扫码。` }, { default: s(() => [m("div", se, [o[1] || (o[1] = m("span", null, "检验方式", -1)), p(w, null, { default: s(() => [p(b)]), _: 1 })])]), _: 1 })]), default: s((l) => [n($)(n(g).edit) ? (i(), r(E, { key: 0, modelValue: l.row.inspectType, "onUpdate:modelValue": (a) => l.row.inspectType = a, size: "default", placeholder: "请选择", style: { width: "100%" }, onChange: (a) => U(l.row, l.row.inspectType) }, { default: s(() => [(i(true), f(N, null, k(n(d).ENUM, (a) => (i(), r(C, { key: a.V, label: a.L, value: a.V, disabled: l.row.inspectDisabled.includes(a.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (i(), r(x, { key: 1, type: n(d).V[l.row.inspectType].T }, { default: s(() => [S(L(n(d).VL[l.row.inspectType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, n(u).loading]])]);
  };
} };
export {
  me as default
};
