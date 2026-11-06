import { ref as b } from "vue";
import { computed as F } from "vue";
import { watch as K } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as m } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as n } from "vue";
import { createTextVNode as f } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementVNode as d } from "vue";
import { unref as r } from "vue";
import { withDirectives as W } from "vue";
import { createElementBlock as X } from "vue";
import { isRef as Y } from "vue";
import { ElMessage as Z } from "element-plus";
import { ElNotification as ee } from "element-plus";
import { ElTag as te } from "element-plus";
import { ElPopconfirm as ae } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { ElInputNumber as ne } from "element-plus";
import { ElPagination as le } from "element-plus";
import { vLoading as re } from "element-plus";
import { l as C, u as ie, J as ue, c3 as g, o as se, p as ce, ba as pe, i as de } from "../../../../../shared/runtime.js";
function me(l) {
  return C({ module: "project", url: "install-report/list-group", method: "get", params: l });
}
function ye(l) {
  return C({ module: "project", url: "install-report/list-report", method: "get", params: l });
}
function fe(l) {
  return C({ module: "project", url: "install-report/check", method: "post", data: l });
}
const Te = { get: me }, ge = { class: "select-type" }, he = { style: { "margin-left": "3px" } }, _e = { style: { "margin-left": "3px" } }, we = { key: 1 }, be = { style: { "margin-left": "3px" } }, ke = { style: { "margin-left": "3px" } }, ve = { __name: "install-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: "detail" } }, emits: ["update:modelValue"], setup(l, { emit: z }) {
  const M = z, h = b(), c = l, { visible: _, handleClose: Q } = ie({ emit: M, props: c }), { handleSizeChange: j, handleCurrentChange: D, total: U, setTotalPage: A, queryPage: S } = ue({ fetchHook: T }), I = F(() => {
    const a = { supplierId: c.detailInfo.supplierId, productType: c.detailInfo.productType, projectId: c.detailInfo.projectId, yearMonth: c.detailInfo.yearMonth, category: c.detailInfo.category || void 0, yearMonthDay: c.detailInfo.reportDate ? c.detailInfo.reportDate : void 0 };
    return c.showType === "detail" ? { ...a } : { ...a, auditStatus: g.AUDITING.V };
  });
  K(_, (a) => {
    h.value = void 0, a && T();
  });
  const w = b([]), E = b(), x = b(false), { maxHeight: B } = se({ extraBox: [".el-drawer__header", ".select-type"], wrapperBox: ".el-drawer__body", paginate: true, extraHeight: 10 }, E);
  function P(a) {
    return pe(a, { props: ["actualQuantity"] });
  }
  async function T(a) {
    let t = [];
    x.value = true;
    try {
      const { content: i = [], totalElements: V } = await ye({ auditStatus: a, ...I.value, ...S });
      i.map((p) => {
        I.value.auditStatus === g.AUDITING.V && (p.actualQuantity = p.reportQuantity, p.actualMete = p.reportMete, p.unitMete = p.reportMete / p.reportQuantity);
      }), t = i, A(V);
    } catch (i) {
      console.log("审核详情", i);
    } finally {
      w.value = [...t], x.value = false;
    }
  }
  function O(a) {
    a.actualQuantity && (a.actualMete = a.unitMete * a.actualQuantity, a.sourceRow.actualQuantity = a.actualQuantity);
  }
  async function R(a) {
    try {
      const t = [];
      if (w.value.map((i) => {
        de(i.actualQuantity) && t.push({ id: i.id, actualQuantity: i.actualQuantity });
      }), !t.length) return Z.error("请填写安装审核明细"), false;
      await fe(t), ee({ title: "提交成功", type: "success" }), M("success"), Q();
    } catch (t) {
      console.log("审核", t);
    }
  }
  return (a, t) => {
    const i = te, V = k("common-button"), p = ae, q = k("common-radio-button"), u = oe, H = ne, L = k("common-table"), $ = le, G = k("common-drawer"), J = re;
    return m(), y(G, { ref_key: "drawerRef", ref: E, title: l.showType === "detail" ? "安装详情" : "安装审核", "close-on-click-modal": false, modelValue: r(_), "onUpdate:modelValue": t[2] || (t[2] = (e) => Y(_) ? _.value = e : null), direction: "rtl", "before-close": r(Q), size: "80%" }, { titleAfter: o(() => [n(i, { type: "warning", size: "large" }, { default: o(() => [f("分包公司：" + s(l.detailInfo.supplierName), 1)]), _: 1 }), l.showType === "audit" ? (m(), y(i, { key: 0, size: "large" }, { default: o(() => t[3] || (t[3] = [f("待审核")])), _: 1, __: [3] })) : v("", true)]), titleRight: o(() => [l.showType === "audit" && w.value.length ? (m(), y(p, { key: 0, title: "确定提交吗？", onConfirm: R }, { reference: o(() => [n(V, { type: "success", size: "default" }, { default: o(() => t[4] || (t[4] = [f("提交")])), _: 1, __: [4] })]), _: 1 })) : v("", true)]), content: o(() => [d("div", ge, [l.showType === "detail" ? (m(), y(q, { key: 0, modelValue: h.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => h.value = e), options: r(g).ENUM, showOptionAll: "", optionAllValue: void 0, type: "enum", class: "filter-item", style: { "margin-bottom": "10px" }, onChange: t[1] || (t[1] = (e) => T(h.value)) }, null, 8, ["modelValue", "options"])) : v("", true)]), W((m(), y(L, { data: w.value, "show-summary": "", "summary-method": P, "max-height": r(B), "return-source-data": "", showEmptySymbol: false }, { default: o(() => [n(u, { label: "序号", type: "index", align: "center", width: "60" }), n(u, { key: "createTime", prop: "createTime", label: "申报时间", align: "center", width: "140" }, { default: o((e) => [d("span", null, s(r(ce)(e.row.createTime, "{y}-{m}-{d} {h}:{i}:{s}")), 1)]), _: 1 }), n(u, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), n(u, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "" }), n(u, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), n(u, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), n(u, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), n(u, { key: "reportQuantity", prop: "reportQuantity", label: "上报数", align: "center" }, { default: o((e) => [d("span", null, [f(s(e.row.reportQuantity), 1), d("span", he, s(e.row.measureUnit), 1)])]), _: 1 }), n(u, { key: "reportMete", prop: "reportMete", label: "上报量", align: "center" }, { default: o((e) => [d("span", null, [f(s(e.row.reportMete), 1), d("span", _e, s(e.row.accountingUnit), 1)])]), _: 1 }), n(u, { key: "actualQuantity", prop: "actualQuantity", label: "审核数", align: "center", "min-width": "150" }, { default: o((e) => [l.showType === "audit" ? (m(), y(H, { key: 0, modelValue: e.row.actualQuantity, "onUpdate:modelValue": (N) => e.row.actualQuantity = N, modelModifiers: { number: true }, min: 0, max: e.row.reportQuantity, step: 1, precision: 0, placeholder: "请填写", "controls-position": "right", style: { width: "120px" }, onChange: (N) => O(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])) : (m(), X("span", we, s(e.row.actualQuantity || "-"), 1)), d("span", be, s(e.row.measureUnit), 1)]), _: 1 }), n(u, { key: "actualMete", prop: "actualMete", label: "审核量", align: "center" }, { default: o((e) => [d("span", null, [f(s(e.row.actualMete || "-"), 1), d("span", ke, s(e.row.accountingUnit), 1)])]), _: 1 }), l.showType === "detail" ? (m(), y(u, { key: "auditStatus", prop: "auditStatus", label: "状态", align: "center", width: "80" }, { default: o((e) => [n(i, { type: e.row.auditStatus === r(g).PASS.V ? "success" : e.row.auditStatus === r(g).REJECT.V ? "warning" : "primary" }, { default: o(() => [f(s(r(g).VL[e.row.auditStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : v("", true)]), _: 1 }, 8, ["data", "max-height"])), [[J, x.value]]), n($, { total: r(U), "current-page": r(S).pageNumber, "page-size": r(S).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: r(j), onCurrentChange: r(D) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, Ve = Object.freeze(Object.defineProperty({ __proto__: null, default: ve }, Symbol.toStringTag, { value: "Module" }));
export {
  ve as _,
  Te as c,
  Ve as i
};
