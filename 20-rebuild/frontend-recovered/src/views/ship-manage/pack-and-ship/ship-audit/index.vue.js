import { ref as P } from "vue";
import { watch as Z } from "vue";
import { provide as ee } from "vue";
import { reactive as te } from "vue";
import { resolveComponent as V } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as _ } from "vue";
import { unref as e } from "vue";
import { withDirectives as g } from "vue";
import { createBlock as i } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as l } from "vue";
import { createTextVNode as y } from "vue";
import { Fragment as T } from "vue";
import { renderList as O } from "vue";
import { withModifiers as z } from "vue";
import { ElNotification as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElTag as ie } from "element-plus";
import { vLoading as se } from "element-plus";
import { g as le, d as re, m as ne, a as ue } from "./module/detail.vue.js";
import { _ as de, m as pe, t as ce, x as me, o as fe, z as _e, bQ as b, bR as ye, K as B, aN as Q, bv as $, bi as E, bw as A, bs as we, G as x, L as q, P as he } from "../../../../shared/runtime.js";
import { i as c } from "../../../../modules/ship-manage-3066b2ed.js";
import ge from "./module/header.vue.js";
const be = { class: "app-container" }, ve = { class: "project-name" }, ke = { style: { "white-space": "pre-line" } }, Se = { style: { "white-space": "pre-line" } }, Ne = { __name: "index", setup(Te) {
  const j = { PASS: { L: "同意", K: "PASS", V: 2 }, NO_PASS: { L: "不同意", K: "NO_PASS", V: 4 } }, I = { add: false, edit: false, del: false, download: false }, L = P(), { currentProjectType: C } = pe(["currentProjectType"]), { decimalPrecision: F } = ce(), { crud: u, CRUD: D, columns: n } = me({ title: "发运审核", sort: ["auditTime.desc"], permission: { ...c }, crudApi: { get: le }, optShow: { ...I } }, L);
  Z(() => C.value, (m) => {
    u.crudApi.download = re;
  }, { immediate: true }), ee("permission", c);
  const { maxHeight: G } = fe({ paginate: true }), v = P(false), w = P({}), k = te({ passLoading: false, noPassLoading: false });
  D.HOOK.handleRefresh = (m, { data: s }) => {
  }, D.HOOK.beforeToQuery = () => {
    u.query.projectType = C.value;
  };
  function U(m) {
    w.value = m, v.value = true;
  }
  async function M(m, s) {
    try {
      k[s] = true, await ue({ id: w.value.id, status: m.V }), ae({ title: "审核成功", message: `${m.L}发运`, type: "success", duration: 2500 }), v.value = false, u.toQuery();
    } catch (r) {
      console.log("发运审核失败", r);
    } finally {
      k[s] = false;
    }
  }
  function J({ row: m }) {
    return m.shipmentStatus === "取消送货" ? "row-cancel" : "";
  }
  return (m, s) => {
    const r = oe, S = ie, W = V("table-cell-tag"), N = V("common-button"), X = V("common-table"), R = K("parse-time"), H = K("permission"), Y = se;
    return a(), h("div", be, [_(e(ge)), g((a(), i(X, { ref_key: "tableRef", ref: L, data: e(u).data, style: { width: "100%" }, "max-height": e(G), "row-class-name": J, onSortChange: e(u).handleSortChange, onSelectionChange: e(u).selectionChangeHandler }, { default: o(() => [_(r, { type: "selection", width: "55", align: "center" }), _(r, { label: "序号", type: "index", align: "center", width: "60" }), e(n).visible("project.shortName") && !e(u).query.projectId ? (a(), i(r, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "230" }, { default: o((t) => [d("span", ve, p(e(_e)(t.row.project)), 1)]), _: 1 })) : l("", true), e(n).visible("licensePlate") ? (a(), i(r, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" }, { default: o((t) => [d("span", null, p(t.row.licensePlate), 1)]), _: 1 })) : l("", true), e(n).visible("serialNumber") ? (a(), i(r, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: o((t) => [_(S, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: o(() => [y(p(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : l("", true), e(n).visible("emissionQuantity") ? (a(), i(r, { key: "emissionQuantity", prop: "emissionQuantity", label: "车次/船次数", align: "center", "min-width": "140px" }, { default: o((t) => [d("span", null, p(t.row.emissionQuantity), 1)]), _: 1 })) : l("", true), e(n).visible("checkStatus") ? (a(), i(r, { key: "checkStatus", prop: "checkStatus", label: "审核状态", align: "center", width: "100px" }, { default: o((t) => [t.row.checkStatus ? (a(), i(S, { key: 0, type: e(b).V[t.row.checkStatus].T, effect: "plain" }, { default: o(() => [y(p(e(b).VL[t.row.checkStatus]), 1)]), _: 2 }, 1032, ["type"])) : l("", true)]), _: 1 })) : l("", true), e(n).visible("userName") ? (a(), i(r, { key: "userName", prop: "userName", sortable: "custom", "show-overflow-tooltip": true, label: "装车人", align: "center", width: "140" }, { default: o((t) => [d("span", ke, [d("span", null, p(t.row.userName + `
`), 1), g(d("span", null, null, 512), [[R, t.row.loadingTime]])])]), _: 1 })) : l("", true), e(n).visible("actualUserName") ? (a(), i(r, { key: "actualUserName", prop: "actualUserName", sortable: "custom", "show-overflow-tooltip": true, label: "过磅人", align: "center", width: "140" }, { default: o((t) => [d("span", Se, [d("span", null, p(t.row.actualUserName + `
`), 1), g(d("span", null, null, 512), [[R, t.row.actualTime]])])]), _: 1 })) : l("", true), e(n).visible("auditUserName") ? (a(), i(r, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "审核人", align: "center", width: "140" })) : l("", true), e(n).visible("structureMeasureMode") ? (a(), i(r, { key: 8, "show-overflow-tooltip": true, prop: "structureMeasureMode", label: "计量方式", align: "center", "min-width": "120" }, { default: o((t) => [d("span", null, p(e(ye).VL[t.row.structureMeasureMode]), 1)]), _: 1 })) : l("", true), e(n).visible("productType") && e(u).query.projectType === e(B).STEEL.V ? (a(), i(r, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: o((t) => [(a(true), h(T, null, O(e(Q)(e($).getBits(e(E), t.row.productType, "V")), (f) => (a(), i(S, { style: { "margin-right": "5px" }, key: f, type: e(E).V[f].T, effect: "light", "disable-transitions": "" }, { default: o(() => [y(p(e(E).VL[f]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : l("", true), e(n).visible("productType") && e(u).query.projectType === e(B).BRIDGE.V ? (a(), i(r, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: o((t) => [(a(true), h(T, null, O(e(Q)(e($).getBits(e(A), t.row.productType, "V")), (f) => (a(), i(S, { style: { "margin-right": "5px" }, key: f, type: e(A).V[f].T, effect: "light", "disable-transitions": "" }, { default: o(() => [y(p(e(A).VL[f]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : l("", true), e(n).visible("remark") ? (a(), i(r, { key: "remark", prop: "remark", "show-overflow-tooltip": "", label: "备注", align: "center", width: "140" })) : l("", true), e(n).visible("shipAmount") ? (a(), i(r, { key: 12, "show-overflow-tooltip": true, prop: "shipAmount", label: "货物价值(元)", align: "center", "min-width": "120" }, { default: o((t) => [t.row.boolUnallocatedPrice ? (a(), i(W, { key: 0, name: "价格未配置", color: "#a66502", offset: 15 })) : l("", true), d("span", null, p(e(we)(t.row.shipAmount, e(F).shipment)), 1)]), _: 1 })) : l("", true), e(x)([...e(c).detail, ...e(c).audit, ...e(c).download]) ? (a(), i(r, { key: 13, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: o((t) => [t.row.checkStatus === e(b).CHECKED.V && e(x)(e(c).detail) ? (a(), i(N, { key: 0, type: "info", size: "default", onClick: z((f) => U(t.row), ["stop"]) }, { default: o(() => s[3] || (s[3] = [y(" 查看 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : l("", true), t.row.checkStatus === e(b).UNCHECKED.V && e(x)(e(c).audit) ? (a(), i(N, { key: 1, type: "primary", size: "default", onClick: z((f) => U(t.row), ["stop"]) }, { default: o(() => s[4] || (s[4] = [y(" 审核 ")])), _: 2, __: [4] }, 1032, ["onClick"])) : l("", true), g(_(q, { params: { id: t.row.id }, size: "default", fn: e(u).crudApi.download }, null, 8, ["params", "fn"]), [[H, e(c).download]])]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange", "onSelectionChange"])), [[Y, e(u).loading]]), _(e(he)), _(ne, { visible: v.value, "onUpdate:visible": s[2] || (s[2] = (t) => v.value = t), "detail-info": w.value, title: "发运审核", projectType: e(C) }, { titleRight: o(() => [w.value.checkStatus === e(b).UNCHECKED.V ? (a(), h(T, { key: 0 }, [e(x)([...e(c).audit]) ? (a(), h(T, { key: 0 }, [_(N, { type: "primary", loading: k.passLoading, size: "default", onClick: s[0] || (s[0] = (t) => M(j.PASS, "passLoading")) }, { default: o(() => s[5] || (s[5] = [y(" 同意发运 ")])), _: 1, __: [5] }, 8, ["loading"]), _(N, { type: "danger", loading: k.noPassLoading, size: "default", onClick: s[1] || (s[1] = (t) => M(j.NO_PASS, "noPassLoading")) }, { default: o(() => s[6] || (s[6] = [y(" 不同意发运 ")])), _: 1, __: [6] }, 8, ["loading"])], 64)) : l("", true)], 64)) : g((a(), i(q, { key: 1, params: { id: w.value.id }, size: "default", fn: e(u).crudApi.download }, { default: o(() => s[7] || (s[7] = [y(" 下载发运详情 ")])), _: 1, __: [7] }, 8, ["params", "fn"])), [[H, e(c).download]])]), _: 1 }, 8, ["visible", "detail-info", "projectType"])]);
  };
} }, Ae = de(Ne, [["__scopeId", "data-v-a8fc1e08"]]);
export {
  Ae as default
};
