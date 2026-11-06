import { computed as g } from "vue";
import { ref as d } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as exportPermissionDirective } from "vue";
import { openBlock as m } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as w } from "vue";
import { toDisplayString as n } from "vue";
import { createElementVNode as s } from "vue";
import { normalizeStyle as S } from "vue";
import { withDirectives as W } from "vue";
import { createElementBlock as X } from "vue";
import { Fragment as G } from "vue";
import { renderList as Q } from "vue";
import { unref as k } from "vue";
import { ElTag as Y } from "element-plus";
import { ElTableColumn as Z } from "element-plus";
import { ElTable as ee } from "element-plus";
import { ElCard as te } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as se, u as re, o as le, L as ie, wX as ne, wS as supplierPermission, G as hasPermission } from "../../../../../../shared/runtime.js";
const oe = { class: "summary-bar" }, ue = { class: "summary-item" }, ce = { class: "summary-value" }, de = { class: "summary-item" }, me = { class: "summary-value" }, ve = { class: "summary-item" }, fe = { class: "summary-value" }, pe = { class: "summary-item" }, _e = { class: "summary-value" }, ye = { __name: "detail-drawer", props: { visible: { type: Boolean, default: false }, detailRow: { type: Object, default: () => ({}) } }, emits: ["update:visible"], setup(C, { emit: T }) {
  const A = { background: "#e0e0e0", color: "#303133", textAlign: "center", fontWeight: 500 }, D = T, f = C, { visible: x, handleClose: j } = re({ emit: D, props: f, field: "visible", showHook: H }), { maxHeight: B } = le({ mainBox: ".supplier-evaluation-detail-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, x), p = g(() => Math.max(B.value || 0, 520)), V = g(() => Math.max(p.value - 92, 260)), N = d(false), _ = d(void 0), o = d({ evaluateTime: "", reviewResult: "", scoreRating: "", evaluatorName: "" }), y = d([]), b = d([]), M = g(() => {
    var e;
    return ((e = f.detailRow) == null ? void 0 : e.supplierName) || "未选择";
  });
  function E(e = {}) {
    if (!hasPermission(supplierPermission.exportDetail)) return;
    return ne(e.evaluateId);
  }
  async function H() {
    const e = f.detailRow || {};
    _.value = e.id, y.value = [], b.value = [], o.value = { evaluateTime: "", reviewResult: "", scoreRating: "", evaluatorName: "" }, o.value = { evaluateTime: u(e, ["evaluateTime", "evaluateDate", "createTime"]), reviewResult: u(e, ["score", "reviewResult", "evaluateResult"]), scoreRating: u(e, ["scoreRating", "scoreRatingName", "ratingName"]), evaluatorName: u(e, ["evaluatorName", "evaluateUserName", "createUserName"]) };
    const t = O(u(e, ["evaluateDetailsJson", "evaluateJson", "value"])), i = J(L(e.columnMap || e.columnMapJson), t);
    y.value = i, b.value = t.filter((a) => z(a)).map((a) => ({ ...a, score: I(u(a, ["score", "evaluateScore", "actualScore"])) })), N.value = false;
  }
  function J(e, t) {
    const i = Object.keys(e || {}).filter((r) => !["serialNumber", "score", "hasVeto"].includes(r)), a = t.length ? Object.keys(t[0]).filter((r) => !["serialNumber", "score", "hasVeto"].includes(r)) : [];
    return (i.length ? i : a).map((r) => ({ key: r, title: e && e[r] || r }));
  }
  function O(e) {
    if (Array.isArray(e)) return e;
    if (!e || typeof e != "string") return [];
    try {
      const t = JSON.parse(e);
      return Array.isArray(t) ? t : [];
    } catch {
      return [];
    }
  }
  function L(e) {
    if (e && typeof e == "object" && !Array.isArray(e)) return e;
    if (typeof e == "string") try {
      const t = JSON.parse(e);
      return t && typeof t == "object" && !Array.isArray(t) ? t : {};
    } catch {
      return {};
    }
    return {};
  }
  function u(e, t = []) {
    return !e || typeof e != "object" ? "" : t.map((a) => e == null ? void 0 : e[a]).find((a) => a != null && a !== "") || "";
  }
  function I(e) {
    if (e == null || e === "") return "";
    const t = Number(e);
    return Number.isFinite(t) ? t : e;
  }
  function z(e = {}) {
    return F(e) ? $(e.hasVeto) === true : true;
  }
  function F(e = {}) {
    return String(e.assessmentProject || "").trim() === "否决项";
  }
  function $(e) {
    if (e === true || e === false) return e;
    const t = String(e || "").trim().toLowerCase();
    if (["1", "true", "是", "y", "yes"].includes(t)) return true;
    if (["0", "false", "否", "n", "no"].includes(t)) return false;
  }
  return (e, t) => {
    const i = Y, a = Z, R = ee, r = te, K = q("common-drawer"), P = ae, exportDirective = exportPermissionDirective("permission");
    return m(), h(K, { "before-close": k(j), visible: k(x), "custom-class": "supplier-evaluation-detail-drawer", size: "100%", title: "供应商评价详情" }, { titleAfter: l(() => [v(i, { effect: "plain" }, { default: l(() => [w("当前供应商：" + n(M.value), 1)]), _: 1 })]), titleRight: l(() => [W(v(ie, { disabled: !_.value, fn: E, params: { evaluateId: _.value }, class: "filter-item" }, { default: l(() => t[0] || (t[0] = [w(" 供应商评价记录详情下载 ")])), _: 1, __: [0] }, 8, ["disabled", "params"]), [[exportDirective, k(supplierPermission).exportDetail]])]), content: l(() => [s("div", { class: "detail-content", style: S(`height:${p.value}px`) }, [v(r, { class: "detail-card", shadow: "always", style: S(`height:${p.value}px`) }, { default: l(() => [s("div", oe, [s("div", ue, [t[1] || (t[1] = s("div", { class: "summary-label" }, "评价时间", -1)), s("div", ce, n(o.value.evaluateTime || "-"), 1)]), s("div", de, [t[2] || (t[2] = s("div", { class: "summary-label" }, "评审结果", -1)), s("div", me, n(o.value.reviewResult || "-"), 1)]), s("div", ve, [t[3] || (t[3] = s("div", { class: "summary-label" }, "评级", -1)), s("div", fe, n(o.value.scoreRating || "-"), 1)]), s("div", pe, [t[4] || (t[4] = s("div", { class: "summary-label" }, "评价人", -1)), s("div", _e, n(o.value.evaluatorName || "-"), 1)])]), W((m(), h(R, { data: b.value, "header-cell-style": A, "max-height": V.value, border: "", class: "detail-table" }, { default: l(() => [(m(true), X(G, null, Q(y.value, (c) => (m(), h(a, { key: c.key, label: c.title, "min-width": c.key === "assessmentContents" ? 280 : 180, align: "center", "show-overflow-tooltip": "" }, { default: l(({ row: U }) => [w(n(U[c.key] || "-"), 1)]), _: 2 }, 1032, ["label", "min-width"]))), 128)), v(a, { label: "评分", width: "140", align: "center" }, { default: l(({ row: c }) => [s("span", null, n(c.score ?? "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[P, N.value]])]), _: 1 }, 8, ["style"])], 4)]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, he = se(ye, [["__scopeId", "data-v-2365e335"]]);
export {
  he as default
};
