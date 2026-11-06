import { computed as W } from "vue";
import { ref as c } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as f } from "vue";
import { createBlock as R } from "vue";
import { withCtx as u } from "vue";
import { createVNode as a } from "vue";
import { normalizeStyle as q } from "vue";
import { withKeys as Je } from "vue";
import { withDirectives as se } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as oe } from "vue";
import { renderList as re } from "vue";
import { normalizeClass as je } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as _ } from "vue";
import { createTextVNode as w } from "vue";
import { createCommentVNode as Oe } from "vue";
import { unref as ae } from "vue";
import { ElMessage as J } from "element-plus";
import { ElInput as Be } from "element-plus";
import { ElTag as He } from "element-plus";
import { ElPagination as Ue } from "element-plus";
import { ElCard as Fe } from "element-plus";
import { ElCol as Pe } from "element-plus";
import { ElTableColumn as Ke } from "element-plus";
import { ElOption as $e } from "element-plus";
import { ElSelect as We } from "element-plus";
import { ElInputNumber as qe } from "element-plus";
import { ElTable as Qe } from "element-plus";
import { ElRow as Ge } from "element-plus";
import { vLoading as Xe } from "element-plus";
import { _ as Ye, u as Ze, o as et, wU as tt, wV as nt, p as lt, wW as st } from "../../../../../../shared/runtime.js";
import { f as ot } from "../../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const rt = { class: "supplier-list" }, at = ["onClick"], ut = { class: "supplier-name" }, it = { key: 0, class: "empty-text" }, ct = { class: "supplier-pagination" }, mt = { class: "top-header" }, pt = { class: "actions" }, ft = { class: "summary-bar" }, vt = { class: "summary-item" }, dt = { class: "summary-value" }, yt = { class: "summary-item" }, gt = { class: "summary-value" }, _t = { class: "summary-item" }, bt = { class: "summary-value" }, ht = { __name: "operate-drawer", props: { visible: { type: Boolean, default: false }, categoryOptions: { type: Array, default: () => [] }, seedSupplier: { type: Object, default: () => ({}) } }, emits: ["update:visible", "success"], setup(Q, { emit: ue }) {
  const ie = { background: "#e0e0e0", color: "#303133", textAlign: "center", fontWeight: 500 }, G = ue, L = Q, { visible: X, handleClose: Y } = Ze({ emit: G, props: L, field: "visible", showHook: ve }), { maxHeight: ce } = et({ mainBox: ".supplier-evaluation-operate-drawer", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true }, X), T = W(() => Math.max(ce.value || 0, 560)), me = W(() => Math.max(T.value - 190, 220)), m = c({ boolAnnualEvaluated: void 0, classifyId: void 0, name: "" }), pe = [{ id: false, name: "未评价" }, { id: true, name: "已评价" }], j = c(false), y = c([]), C = c(null), p = c({ pageNumber: 1, pageSize: 10, total: 0 }), O = c(false), B = c(false), H = c(false), x = c(void 0), z = c({}), I = c([]), v = c([]), b = c({ evaluateTime: "", reviewResult: "", scoreRating: "", evaluateDetailsJson: "" }), fe = W(() => {
    var e;
    return ((e = C.value) == null ? void 0 : e.name) || "未选择";
  });
  function ve() {
    var e;
    p.value.pageNumber = 1, m.value.classifyId = (e = L.seedSupplier) == null ? void 0 : e.classifyId, U().then(() => {
      var t;
      if ((t = L.seedSupplier) != null && t.id) {
        const n = y.value.find((o) => o.id === L.seedSupplier.id);
        if (n) {
          P(n);
          return;
        }
      }
      y.value.length && P(y.value[0]);
    });
  }
  async function U() {
    try {
      j.value = true;
      const e = await tt({ boolAnnualEvaluated: m.value.boolAnnualEvaluated, classifyId: m.value.classifyId, name: m.value.name || void 0, pageNumber: p.value.pageNumber, pageSize: p.value.pageSize }), t = we(e);
      y.value = t, p.value.total = Ae(e, t.length);
    } catch (e) {
      y.value = [], p.value.total = 0, console.log("供应商评价-评价供应商列表", e);
    } finally {
      j.value = false;
    }
  }
  function F() {
    p.value.pageNumber = 1, U();
  }
  function de(e) {
    p.value.pageNumber = Number(e) || 1, U();
  }
  async function P(e) {
    C.value = e, await Promise.all([ye(e.classifyId), ge(e.id)]);
  }
  async function ye(e) {
    if (!e) {
      I.value = [], v.value = [], x.value = void 0, z.value = {};
      return;
    }
    O.value = true;
    try {
      const t = await ot(e), n = ee(t), o = Z(h(n, ["value", "evaluateDetailsJson", "evaluateJson"])), r = xe((n == null ? void 0 : n.columnMap) || (n == null ? void 0 : n.columnMapJson));
      x.value = n == null ? void 0 : n.id, z.value = r, I.value = Ce(r, o), v.value = o.filter((s) => Re(s)).map((s, S) => ({ ...s, serialNumber: s.serialNumber || String(S + 1), score: g(s) ? "" : void 0 }));
    } catch (t) {
      I.value = [], v.value = [], x.value = void 0, z.value = {}, console.log("供应商评价-评审模板读取", t);
    } finally {
      O.value = false;
    }
  }
  async function ge(e) {
    if (e) {
      B.value = true;
      try {
        const t = await nt(e), n = ee(t), o = h(n, ["evaluateDetailsJson", "evaluateJson", "value"]);
        b.value = { evaluateTime: ke(h(n, ["evaluateTime", "evaluateDate", "createTime"])), reviewResult: h(n, ["score", "reviewResult", "evaluateResult"]), scoreRating: h(n, ["scoreRating", "scoreRatingName", "ratingName"]), evaluateDetailsJson: o };
      } catch (t) {
        b.value = { evaluateTime: "", reviewResult: "", scoreRating: "", evaluateDetailsJson: "" }, console.log("供应商评价-最近记录读取", t);
      } finally {
        B.value = false;
      }
    }
  }
  function _e() {
    v.value.forEach((e) => {
      e.score = g(e) ? "" : void 0;
    });
  }
  function be() {
    const e = Z(b.value.evaluateDetailsJson);
    if (!e.length) {
      J.warning("未找到最近评分记录");
      return;
    }
    v.value.forEach((t, n) => {
      const o = e.find((s) => String(s.serialNumber || "") === String(t.serialNumber || "")) || e[n], r = h(o || {}, ["score", "evaluateScore", "actualScore"]);
      t.score = g(t) ? K(r) : Ee(r);
    });
  }
  async function he() {
    var e;
    if (!((e = C.value) != null && e.id)) {
      J.warning("请先选择供应商");
      return;
    }
    if (!x.value) {
      J.warning("当前供应商未配置评审模板");
      return;
    }
    H.value = true;
    try {
      const n = v.value.some((r) => g(r) && K(r.score) === "有") ? 0 : v.value.reduce((r, s) => g(s) ? r : r + (Number(s.score) || 0), 0), o = v.value.map((r) => ({ ...r, score: Le(r) }));
      await st({ columnMap: z.value || {}, evaluateDetailsJson: JSON.stringify(o), score: n, supplierId: C.value.id, templateId: x.value }), J.success("供应商评价提交成功"), G("success"), Y();
    } catch (t) {
      console.log("供应商评价-提交", t);
    } finally {
      H.value = false;
    }
  }
  function Se(e) {
    const t = Number(e.fraction);
    return Number.isFinite(t) && t > 0 ? t : 9999;
  }
  function Ne(e) {
    const t = Number(e.fraction);
    return Number.isFinite(t) && t > 0 ? -t : -9999;
  }
  function we(e) {
    return Ve(e).map((n) => ({ id: n.id, name: n.name || n.supplierName || "", shortName: n.shortName || n.supplierShortName || "", classifyId: n.classifyId || n.evaluationCategoryId, boolAnnualEvaluated: n.boolAnnualEvaluated === true }));
  }
  function Ce(e, t) {
    const n = Object.keys(e || {}).filter((s) => !["serialNumber", "hasVeto"].includes(s)), o = t.length ? Object.keys(t[0]).filter((s) => !["serialNumber", "score", "hasVeto"].includes(s)) : ["assessmentProject", "assessmentContents", "fraction"];
    return (n.length ? n : o).map((s) => ({ key: s, title: e && e[s] || s }));
  }
  function Z(e) {
    if (Array.isArray(e)) return e;
    if (!e || typeof e != "string") return [];
    try {
      const t = JSON.parse(e);
      return Array.isArray(t) ? t : [];
    } catch {
      return [];
    }
  }
  function xe(e) {
    if (e && typeof e == "object" && !Array.isArray(e)) return e;
    if (typeof e == "string") try {
      const t = JSON.parse(e);
      return t && typeof t == "object" && !Array.isArray(t) ? t : {};
    } catch {
      return {};
    }
    return {};
  }
  function ee(e) {
    var t;
    return !e || typeof e != "object" ? e : e.content && typeof e.content == "object" ? e.content : (t = e.data) != null && t.content && typeof e.data.content == "object" ? e.data.content : e;
  }
  function Ve(e) {
    var t;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((t = e == null ? void 0 : e.data) == null ? void 0 : t.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  function Ae(e, t = 0) {
    var r, s, S, V, A, N, E, k;
    const o = [e == null ? void 0 : e.total, e == null ? void 0 : e.totalElements, e == null ? void 0 : e.totalCount, e == null ? void 0 : e.count, (r = e == null ? void 0 : e.data) == null ? void 0 : r.total, (s = e == null ? void 0 : e.data) == null ? void 0 : s.totalElements, (S = e == null ? void 0 : e.data) == null ? void 0 : S.totalCount, (V = e == null ? void 0 : e.data) == null ? void 0 : V.count, (A = e == null ? void 0 : e.content) == null ? void 0 : A.total, (N = e == null ? void 0 : e.content) == null ? void 0 : N.totalElements, (E = e == null ? void 0 : e.content) == null ? void 0 : E.totalCount, (k = e == null ? void 0 : e.content) == null ? void 0 : k.count].find(($) => Number.isFinite(Number($)));
    return o !== void 0 ? Number(o) : t;
  }
  function h(e, t = []) {
    return !e || typeof e != "object" ? "" : t.map((o) => e == null ? void 0 : e[o]).find((o) => o != null && o !== "") || "";
  }
  function Ee(e) {
    if (e == null || e === "") return;
    const t = Number(e);
    return Number.isFinite(t) ? t : void 0;
  }
  function ke(e) {
    if (e == null || e === "") return "";
    const t = Number(e);
    return Number.isNaN(t) ? String(e) : lt(t);
  }
  function g(e = {}) {
    return te(e) && ne(e);
  }
  function te(e = {}) {
    return String(e.assessmentProject || "").trim() === "否决项";
  }
  function ne(e = {}) {
    return De(e.hasVeto) === true;
  }
  function Re(e = {}) {
    return te(e) ? ne(e) : true;
  }
  function De(e) {
    if (e === true || e === false) return e;
    const t = String(e || "").trim().toLowerCase();
    if (["1", "true", "是", "y", "yes"].includes(t)) return true;
    if (["0", "false", "否", "n", "no"].includes(t)) return false;
  }
  function K(e) {
    const t = String(e || "").trim().toLowerCase();
    return ["有", "是", "1", "true", "y", "yes"].includes(t) ? "有" : ["无", "否", "0", "false", "n", "no"].includes(t) ? "无" : "";
  }
  function Le(e = {}) {
    return g(e) ? K(e.score) || null : e.score === void 0 || e.score === null || e.score === "" ? null : Number(e.score);
  }
  return (e, t) => {
    const n = M("common-radio-button"), o = M("common-select"), r = Be, s = He, S = Ue, V = Fe, A = Pe, N = M("common-button"), E = Ke, k = $e, $ = We, Te = qe, ze = Qe, Ie = Ge, Me = M("common-drawer"), le = Xe;
    return f(), R(Me, { "before-close": ae(Y), visible: ae(X), "custom-class": "supplier-evaluation-operate-drawer", size: "100%", title: "供应商评价" }, { content: u(() => [a(Ie, { gutter: 16, style: q(`height:${T.value}px`) }, { default: u(() => [a(A, { lg: 6, md: 8, sm: 24, xs: 24 }, { default: u(() => [a(V, { class: "left-card", shadow: "always", style: q(`height:${T.value}px`) }, { default: u(() => [a(n, { modelValue: m.value.boolAnnualEvaluated, "onUpdate:modelValue": t[0] || (t[0] = (l) => m.value.boolAnnualEvaluated = l), options: pe, "show-option-all": "", type: "other", onChange: F }, null, 8, ["modelValue"]), a(o, { modelValue: m.value.classifyId, "onUpdate:modelValue": t[1] || (t[1] = (l) => m.value.classifyId = l), options: Q.categoryOptions, clearable: "", placeholder: "评价分类筛选", style: { width: "100%", "margin-top": "10px" }, onChange: F }, null, 8, ["modelValue", "options"]), a(r, { modelValue: m.value.name, "onUpdate:modelValue": t[2] || (t[2] = (l) => m.value.name = l), modelModifiers: { trim: true }, clearable: "", placeholder: "名称/简称检索", style: { "margin-top": "10px" }, onKeyup: Je(F, ["enter"]) }, null, 8, ["modelValue"]), se((f(), D("div", rt, [(f(true), D(oe, null, re(y.value, (l) => {
      var d;
      return f(), D("div", { key: l.id, class: je(["supplier-item", { active: ((d = C.value) == null ? void 0 : d.id) === l.id }]), onClick: (St) => P(l) }, [i("span", ut, _(l.name || "-"), 1), a(s, { type: l.boolAnnualEvaluated ? "success" : "danger", effect: "plain", size: "small" }, { default: u(() => [w(_(l.boolAnnualEvaluated ? "已评价" : "未评价"), 1)]), _: 2 }, 1032, ["type"])], 10, at);
    }), 128)), y.value.length ? Oe("", true) : (f(), D("div", it, "暂无供应商"))])), [[le, j.value]]), i("div", ct, [a(S, { "current-page": p.value.pageNumber, "page-size": p.value.pageSize, total: p.value.total, background: "", layout: "prev, pager, next", small: "", onCurrentChange: de }, null, 8, ["current-page", "page-size", "total"])])]), _: 1 }, 8, ["style"])]), _: 1 }), a(A, { lg: 18, md: 16, sm: 24, xs: 24 }, { default: u(() => [a(V, { class: "right-card", shadow: "always", style: q(`height:${T.value}px`) }, { default: u(() => [i("div", mt, [a(s, { effect: "plain", size: "large" }, { default: u(() => [w("当前供应商：" + _(fe.value), 1)]), _: 1 }), i("div", pt, [a(N, { type: "danger", onClick: _e }, { default: u(() => t[3] || (t[3] = [w("清空评分内容")])), _: 1, __: [3] }), a(N, { type: "warning", onClick: be }, { default: u(() => t[4] || (t[4] = [w("点击赋值最近一次评分")])), _: 1, __: [4] }), a(N, { loading: H.value, type: "success", onClick: he }, { default: u(() => t[5] || (t[5] = [w("提交")])), _: 1, __: [5] }, 8, ["loading"])])]), i("div", ft, [i("div", vt, [t[6] || (t[6] = i("div", { class: "summary-label" }, "最近一次评价时间", -1)), i("div", dt, _(b.value.evaluateTime || "-"), 1)]), i("div", yt, [t[7] || (t[7] = i("div", { class: "summary-label" }, "最近一次评审结果", -1)), i("div", gt, _(b.value.reviewResult || "-"), 1)]), i("div", _t, [t[8] || (t[8] = i("div", { class: "summary-label" }, "最近一次评级", -1)), i("div", bt, _(b.value.scoreRating || "-"), 1)])]), se((f(), R(ze, { data: v.value, "header-cell-style": ie, "max-height": me.value, border: "", style: { width: "100%", "margin-top": "10px" } }, { default: u(() => [(f(true), D(oe, null, re(I.value, (l) => (f(), R(E, { key: l.key, label: l.title, "min-width": l.key === "assessmentContents" ? 280 : 180, align: "center", "show-overflow-tooltip": "" }, { default: u(({ row: d }) => [w(_(d[l.key] || "-"), 1)]), _: 2 }, 1032, ["label", "min-width"]))), 128)), a(E, { label: "评分", width: "140", align: "center" }, { default: u(({ row: l }) => [g(l) ? (f(), R($, { key: 0, modelValue: l.score, "onUpdate:modelValue": (d) => l.score = d, placeholder: "请选择", style: { width: "100%" } }, { default: u(() => [a(k, { label: "有", value: "有" }), a(k, { label: "无", value: "无" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : (f(), R(Te, { key: 1, modelValue: l.score, "onUpdate:modelValue": (d) => l.score = d, controls: false, max: Se(l), min: Ne(l), placeholder: "请打分", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "min"]))]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[le, O.value || B.value]])]), _: 1 }, 8, ["style"])]), _: 1 })]), _: 1 }, 8, ["style"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, xt = Ye(ht, [["__scopeId", "data-v-fcfe3762"]]);
export {
  xt as default
};
