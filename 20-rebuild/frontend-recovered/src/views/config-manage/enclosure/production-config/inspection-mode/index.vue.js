import { ref as G } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as T } from "vue";
import { withDirectives as Y } from "vue";
import { unref as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as r } from "vue";
import { createVNode as u } from "vue";
import { createCommentVNode as g } from "vue";
import { createElementVNode as y } from "vue";
import { Fragment as k } from "vue";
import { renderList as S } from "vue";
import { createTextVNode as L } from "vue";
import { toDisplayString as A } from "vue";
import { ElMessageBox as R } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { InfoFilled as K } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as J } from "element-plus";
import { ElOption as W } from "element-plus";
import { ElSelect as X } from "element-plus";
import { ElTag as Z } from "element-plus";
import { vLoading as ee } from "element-plus";
import { l as B, x as te, dL as h, o as ne, dM as D, aE as p, aF as c, G as $ } from "../../../../../shared/runtime.js";
function oe(m) {
  return B({ url: "api/mes/enclosure/process/group", method: "get", params: m });
}
function le(m) {
  return B({ url: "/api/mes/enclosure/process", method: "put", data: m });
}
const b = { get: oe, edit: le }, ae = { class: "app-container" }, ie = { style: { display: "inline-block" } }, re = { style: { display: "inline-block" } }, ce = { __name: "index", setup(m) {
  const M = { batchAdd: false, add: false, edit: false, del: false, download: false }, w = G(), { crud: d, columns: _, CRUD: f } = te({ title: "报检方式", sort: [], hasPagination: false, permission: { ...h }, optShow: { ...M }, crudApi: { ...b } }, w), { maxHeight: U } = ne({ paginate: false });
  async function v(e, l) {
    try {
      await R.confirm(`此操作将把 “${e.name}” 工序的检验方式：
由“${c.VL[e.originInspectType]}”变更为 “${c.VL[l]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await b.edit({ id: e.id, inspectType: l }), d.notify(`“${e.name}” 工序,检验方式变更为 “${c.VL[l]}” 成功`, f.NOTIFICATION_TYPE.SUCCESS), d.refresh();
    } catch (t) {
      console.log(t), e.inspectType = e.originInspectType;
    }
  }
  async function H(e, l) {
    try {
      await R.confirm(`此操作将把 “${e.name}” 工序的上报方式：
由“${p.VL[e.originReportType]}”变更为 “${p.VL[l]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await b.edit({ id: e.id, reportType: l }), d.notify(`“${e.name}” 工序,上报方式变更为 “${p.VL[l]}” 成功`, f.NOTIFICATION_TYPE.SUCCESS), d.refresh();
    } catch (t) {
      console.log(t), e.reportType = e.originReportType;
    }
  }
  f.HOOK.handleRefresh = (e, { data: l }) => {
    l.content = l.map((t) => (t.originInspectType = t.inspectType, t.originReportType = t.reportType, t.reportDisabled = O(t), t.inspectDisabled = P(t), t));
  };
  function O(e) {
    return e.sequenceType === D.MACHINE_PART.V ? [p.BATCH_SCAN.V, p.SINGLE_SCAN.V] : [];
  }
  function P(e) {
    return e.sequenceType === D.MACHINE_PART.V ? [c.BATCH_SCAN.V, c.SINGLE_SCAN.V] : [];
  }
  return (e, l) => {
    const t = j, V = K, C = Q, E = J, x = W, I = X, N = Z, F = z("common-table"), q = ee;
    return i(), T("div", ae, [Y((i(), s(F, { ref_key: "tableRef", ref: w, data: n(d).data, "empty-text": n(d).emptyText, "max-height": n(U), style: { width: "100%" } }, { default: r(() => [u(t, { label: "序号", type: "index", align: "center", width: "60" }), n(_).visible("name") ? (i(), s(t, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", align: "center", width: "140px" })) : g("", true), n(_).visible("reportType") ? (i(), s(t, { key: "reportType", prop: "reportType", label: "上报方式", "min-width": "170px", align: "center" }, { header: r(() => [u(E, { class: "item", effect: "light", "popper-class": "test", placement: "top", content: `上报方式设五种方式：

          机联：需与设备进行对对接，无需进行人工上报；

          单件（不扫码）：每次只能上报一个，不需要扫码；

          单件（需扫码）：每次只能上报一个，需要扫码；

          批量（不扫码）：每次可以上报多个，不需要扫码;

          批量（需扫码）：每次可以上报多个，需要扫码。` }, { default: r(() => [y("div", ie, [l[0] || (l[0] = y("span", null, "上报方式", -1)), u(C, null, { default: r(() => [u(V)]), _: 1 })])]), _: 1 })]), default: r((o) => [n($)(n(h).edit) ? (i(), s(I, { key: 0, modelValue: o.row.reportType, "onUpdate:modelValue": (a) => o.row.reportType = a, size: "default", placeholder: "请选择", "disabled-val": o.row.inspectDisabled, style: { width: "100%" }, onChange: (a) => H(o.row, o.row.reportType) }, { default: r(() => [(i(true), T(k, null, S(n(p).ENUM, (a) => (i(), s(x, { key: a.V, label: a.L, value: a.V, disabled: o.row.reportDisabled.includes(a.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled-val", "onChange"])) : (i(), s(N, { key: 1, type: n(p).V[o.row.reportType].T }, { default: r(() => [L(A(n(p).VL[o.row.reportType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : g("", true), n(_).visible("inspectType") ? (i(), s(t, { key: "inspectType", prop: "inspectType", label: "检验方式", "min-width": "170px", align: "center" }, { header: r(() => [u(E, { class: "item", effect: "light", placement: "top", content: `检验方式设四种方式：

          单件（不扫码）：每次只能检验一个，不需要扫码；

          单件（需扫码）：每次只能检验一个，需要扫码；

          批量（不扫码）：每次可以检验多个，不需要扫码;

          批量（需扫码）：每次可以检验多个，需要扫码。` }, { default: r(() => [y("div", re, [l[1] || (l[1] = y("span", null, "检验方式", -1)), u(C, null, { default: r(() => [u(V)]), _: 1 })])]), _: 1 })]), default: r((o) => [n($)(n(h).edit) ? (i(), s(I, { key: 0, modelValue: o.row.inspectType, "onUpdate:modelValue": (a) => o.row.inspectType = a, size: "default", placeholder: "请选择", style: { width: "100%" }, onChange: (a) => v(o.row, o.row.inspectType) }, { default: r(() => [(i(true), T(k, null, S(n(c).ENUM, (a) => (i(), s(x, { key: a.V, label: a.L, value: a.V, disabled: o.row.inspectDisabled.includes(a.V) }, null, 8, ["label", "value", "disabled"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onChange"])) : (i(), s(N, { key: 1, type: n(c).V[o.row.inspectType].T }, { default: r(() => [L(A(n(c).VL[o.row.inspectType]), 1)]), _: 2 }, 1032, ["type"]))]), _: 1 })) : g("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[q, n(d).loading]])]);
  };
} };
export {
  ce as default
};
