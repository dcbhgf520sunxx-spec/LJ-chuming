import { ref as p } from "vue";
import { computed as g } from "vue";
import { onMounted as Le } from "vue";
import { resolveComponent as Ue } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as m } from "vue";
import { withCtx as c } from "vue";
import { normalizeStyle as U } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as le } from "vue";
import { Fragment as re } from "vue";
import { renderList as se } from "vue";
import { normalizeClass as De } from "vue";
import { toDisplayString as D } from "vue";
import { createCommentVNode as E } from "vue";
import { unref as s } from "vue";
import { createBlock as y } from "vue";
import { createTextVNode as Pe } from "vue";
import { withModifiers as oe } from "vue";
import { Plus as Be } from "@element-plus/icons-vue";
import { Delete as Oe } from "@element-plus/icons-vue";
import { ElMessage as N } from "element-plus";
import { ElInput as Fe } from "element-plus";
import { ElCard as He } from "element-plus";
import { ElCol as Ie } from "element-plus";
import { ElTag as Je } from "element-plus";
import { ElIcon as We } from "element-plus";
import { ElOption as Ke } from "element-plus";
import { ElSelect as qe } from "element-plus";
import { ElTableColumn as Ge } from "element-plus";
import { ElTable as Qe } from "element-plus";
import { ElRow as Xe } from "element-plus";
import { vLoading as Ye } from "element-plus";
import { _ as Ze, o as et, G as C, fU as k } from "../../../../shared/runtime.js";
import { g as tt, f as nt, h as at } from "../../../../modules/supplier-evaluation-config-2fb6916b.js";
const lt = { class: "app-container supplier-review-template" }, rt = ["onClick"], st = { key: 0, class: "empty-text" }, ot = { class: "right-header" }, it = { class: "current-category-text" }, ut = { class: "header-actions" }, ct = { class: "dynamic-header" }, dt = { key: 1 }, ft = { key: 3 }, mt = { class: "table-op" }, pt = { __name: "index", setup(yt) {
  const w = { serialNumber: "编号", assessmentProject: "考核项目", assessmentContents: "考核内容", fraction: "分数" }, ie = { background: "#e0e0e0", color: "#303133", textAlign: "center", fontWeight: 500 }, M = p(""), P = p(false), A = p([]), _ = p(null), S = p(false), R = p(false), B = p(void 0), O = p(4), F = p(w.serialNumber), l = p(te()), d = p([]), H = p({}), { maxHeight: ue } = et({ wrapperBox: ".supplier-review-template", extraBox: null, minHeight: 560 }), T = g(() => Math.max(ue.value || 0, 560)), ce = g(() => `height:${T.value}px`), de = g(() => `height:${T.value}px`), fe = g(() => `height:${T.value}px`), me = g(() => `max-height:${Math.max(T.value - 120, 180)}px`), pe = g(() => Math.max(T.value - 130, 220)), J = g(() => JSON.stringify(I()) !== JSON.stringify(H.value)), ye = g(() => !_.value || S.value || R.value || !J.value), W = g(() => M.value ? A.value.filter((e) => (e.name || "").includes(M.value)) : A.value);
  Le(() => {
    ve();
  });
  async function ve() {
    P.value = true;
    try {
      const e = await tt();
      A.value = we(e), A.value.length && K(A.value[0]);
    } catch (e) {
      console.log("供应商评价配置-评审模板-分类列表", e);
    } finally {
      P.value = false;
    }
  }
  async function K(e) {
    _.value = e, await q(e.id);
  }
  async function q(e) {
    S.value = true, B.value = void 0;
    try {
      const t = await nt(e), n = G(t);
      B.value = n.id, O.value = n.configTypeEnum || 4, F.value = n.columnMap.serialNumber || w.serialNumber, l.value = n.columns, d.value = n.reviewTemplates.length ? n.reviewTemplates : [z()], H.value = I();
    } catch (t) {
      O.value = 4, F.value = w.serialNumber, l.value = te(), d.value = [z()], H.value = I(), console.log("供应商评价配置-评审模板详情", t);
    } finally {
      S.value = false;
    }
  }
  function ge(e) {
    d.value.splice(e + 1, 0, z());
  }
  function _e(e) {
    if (ee(d.value[e])) {
      N.warning("否决项行不允许删除");
      return;
    }
    d.value.splice(e, 1), d.value.length || d.value.push(z());
  }
  function he(e) {
    const t = Se(), n = { key: t, title: `新列${l.value.length + 1}`, type: "text", minWidth: 200 }, o = l.value.findIndex((i) => i.key === e);
    o === -1 ? l.value.push(n) : l.value.splice(o + 1, 0, n), d.value.forEach((i) => {
      i[t] = "";
    });
  }
  function be(e) {
    if (l.value.length <= 1) {
      N.warning("至少保留一列");
      return;
    }
    l.value = l.value.filter((t) => t.key !== e), d.value.forEach((t) => {
      delete t[e];
    });
  }
  function Ce(e) {
    return ["assessmentProject", "assessmentContents", "fraction"].includes(e);
  }
  async function ke() {
    if (!J.value) return;
    if (!_.value) {
      N.warning("请先选择评价分类");
      return;
    }
    if (l.value.some((t) => !t.title)) {
      N.warning("请填写完整的列名");
      return;
    }
    R.value = true;
    try {
      const t = Q(d.value);
      await at({ id: B.value || _.value.id, classifyId: _.value.id, configTypeEnum: O.value || 4, value: JSON.stringify(t), columnMap: X() }), N.success("评审表模板保存成功"), await q(_.value.id);
    } catch (t) {
      console.log("供应商评价配置-评审模板保存", t);
    } finally {
      R.value = false;
    }
  }
  function we(e) {
    return Re(e).map((n) => ({ id: n.id, name: n.name || "" }));
  }
  function G(e) {
    const t = ze(e);
    if (Array.isArray(t)) return G(t[0] || {});
    const n = t && typeof t == "object" && "value" in t ? Ve(t.value) : (t == null ? void 0 : t.reviewTemplates) || [], o = Y(t == null ? void 0 : t.columnMap), i = Z(o, n), v = xe(n, i);
    return { id: t == null ? void 0 : t.id, configTypeEnum: (t == null ? void 0 : t.configTypeEnum) || 4, columnMap: o, columns: i, reviewTemplates: v };
  }
  function xe(e, t = l.value) {
    return (Array.isArray(e) ? e : []).map((o, i) => {
      const v = { serialNumber: o.serialNumber || String(i + 1) };
      return t.forEach((h) => {
        v[h.key] = Te(o[h.key], h.type);
      }), v;
    });
  }
  function z() {
    const e = { serialNumber: "" };
    return l.value.forEach((t) => {
      e[t.key] = t.type === "boolean" ? void 0 : "";
    }), e;
  }
  function Q(e) {
    return (Array.isArray(e) ? e : []).map((t, n) => {
      const o = { serialNumber: t.serialNumber || String(n + 1) };
      return l.value.forEach((i) => {
        o[i.key] = Ee(t[i.key], i.type);
      }), o;
    });
  }
  function X() {
    const e = { serialNumber: F.value || w.serialNumber };
    return l.value.forEach((t) => {
      e[t.key] = t.title || t.key;
    }), e;
  }
  function I() {
    return { columnMap: X(), value: Q(d.value) };
  }
  function Ve(e) {
    if (Array.isArray(e)) return e;
    if (typeof e == "string") {
      const t = e.trim();
      if (!t) return [];
      try {
        const n = JSON.parse(t);
        return Array.isArray(n) ? n : [];
      } catch (n) {
        return console.log("供应商评价配置-评审模板value解析失败", n), [];
      }
    }
    return [];
  }
  function Y(e) {
    return { ...w, ...e && typeof e == "object" ? e : {} };
  }
  function Z(e, t) {
    const n = Y(e), o = Object.keys(n).filter((f) => f !== "serialNumber"), i = Array.isArray(t) ? Array.from(t.reduce((f, j) => (Object.keys(j || {}).forEach((L) => {
      L !== "serialNumber" && f.add(L);
    }), f), /* @__PURE__ */ new Set())) : [], v = o.length ? o : i;
    return (v.length ? v : ["assessmentProject", "assessmentContents", "fraction"]).map((f) => ({ key: f, title: n[f] || f, type: Ae(f), minWidth: f === "assessmentContents" ? 280 : 200 }));
  }
  function Ae(e) {
    return e === "hasVeto" || /veto/i.test(e) ? "boolean" : e === "assessmentContents" || /content|remark|desc|note/i.test(e) ? "textarea" : "text";
  }
  function Te(e, t) {
    if (t === "boolean") {
      const n = $(e);
      return n === void 0 ? e : n;
    }
    return e ?? "";
  }
  function Ee(e, t) {
    if (t === "boolean") {
      const n = $(e);
      return n === void 0 ? e : n ? "是" : "否";
    }
    return e ?? "";
  }
  function $(e) {
    if (e === true || e === false) return e;
    const t = String(e).trim().toLowerCase();
    if (e === 1 || t === "1" || t === "true" || t === "是" || t === "y" || t === "yes") return true;
    if (e === 0 || t === "0" || t === "false" || t === "否" || t === "n" || t === "no") return false;
  }
  function Ne(e, t) {
    if (t === "boolean") {
      const n = $(e);
      return n === void 0 ? e == null || e === "" ? "-" : e : n ? "是" : "否";
    }
    return e == null || e === "" ? "-" : e;
  }
  function Me(e, t) {
    if ((t == null ? void 0 : t.type) !== "boolean") return false;
    const n = e == null ? void 0 : e[t.key];
    return n == null || n === "";
  }
  function ee(e = {}) {
    const t = String(e.assessmentProject || ""), n = $(e.hasVeto);
    return t.includes("否决") || n === true;
  }
  function Se() {
    const e = `column_${Date.now().toString(36)}`;
    if (!l.value.some((n) => n.key === e)) return e;
    let t = 1;
    for (; l.value.some((n) => n.key === `${e}_${t}`); ) t += 1;
    return `${e}_${t}`;
  }
  function te() {
    return Z(w, []);
  }
  function Re(e) {
    var t;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((t = e == null ? void 0 : e.data) == null ? void 0 : t.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  function ze(e) {
    var t;
    if (e && typeof e == "object") {
      if (e.content && typeof e.content == "object") return e.content;
      if ((t = e.data) != null && t.content && typeof e.data.content == "object") return e.data.content;
    }
    return e;
  }
  return (e, t) => {
    const n = Fe, o = He, i = Ie, v = Je, h = Ue("common-button"), f = We, j = Ke, L = qe, ne = Ge, $e = Qe, je = Xe, ae = Ye;
    return r(), b("div", lt, [m(je, { gutter: 20, style: U(ce.value) }, { default: c(() => [m(i, { lg: 5, md: 7, sm: 24, xs: 24 }, { default: c(() => [m(o, { class: "left-card", shadow: "always", style: U(de.value) }, { default: c(() => [m(n, { modelValue: M.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => M.value = a), modelModifiers: { trim: true }, class: "search-input", clearable: "", placeholder: "分类名称检索" }, null, 8, ["modelValue"]), t[1] || (t[1] = V("div", { class: "category-header" }, "评价分类", -1)), le((r(), b("div", { class: "category-list", style: U(me.value) }, [(r(true), b(re, null, se(W.value, (a) => {
      var u;
      return r(), b("div", { key: a.id, class: De(["category-item", { active: ((u = _.value) == null ? void 0 : u.id) === a.id }]), onClick: (x) => K(a) }, D(a.name), 11, rt);
    }), 128)), W.value.length ? E("", true) : (r(), b("div", st, "暂无分类数据"))], 4)), [[ae, P.value]])]), _: 1, __: [1] }, 8, ["style"])]), _: 1 }), m(i, { lg: 19, md: 17, sm: 24, xs: 24 }, { default: c(() => [m(o, { class: "right-card", shadow: "always", style: U(fe.value) }, { default: c(() => [V("div", ot, [m(v, { class: "current-category-tag", effect: "plain", size: "large" }, { default: c(() => {
      var a;
      return [V("span", it, "当前分类：" + D(((a = _.value) == null ? void 0 : a.name) || "未选择"), 1)];
    }), _: 1 }), V("div", ut, [s(C)(s(k).edit) ? (r(), y(h, { key: 0, disabled: ye.value, loading: R.value, size: "default", type: "success", onClick: ke }, { default: c(() => t[2] || (t[2] = [Pe(" 保存 ")])), _: 1, __: [2] }, 8, ["disabled", "loading"])) : E("", true)])]), le((r(), y($e, { data: d.value, "max-height": pe.value, "header-cell-style": ie, border: "", style: { width: "100%" } }, { default: c(() => [(r(true), b(re, null, se(l.value, (a) => (r(), y(ne, { key: a.key, align: "center", "min-width": a.minWidth || 200 }, { header: c(() => [V("div", ct, [s(C)(s(k).edit) ? (r(), y(n, { key: 0, modelValue: a.title, "onUpdate:modelValue": (u) => a.title = u, modelModifiers: { trim: true }, maxlength: "30", placeholder: "列名", class: "input-border-none", size: "small" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (r(), b("span", dt, D(a.title), 1)), s(C)(s(k).edit) ? (r(), y(f, { key: 2, class: "header-col-icon icon-add", onClick: oe((u) => he(a.key), ["stop"]) }, { default: c(() => [m(s(Be))]), _: 2 }, 1032, ["onClick"])) : E("", true), s(C)(s(k).edit) && l.value.length > 1 && !Ce(a.key) ? (r(), y(f, { key: 3, class: "header-col-icon icon-del", onClick: oe((u) => be(a.key), ["stop"]) }, { default: c(() => [m(s(Oe))]), _: 2 }, 1032, ["onClick"])) : E("", true)])]), default: c(({ row: u }) => [s(C)(s(k).edit) && a.type === "boolean" ? (r(), y(L, { key: 0, modelValue: u[a.key], "onUpdate:modelValue": (x) => u[a.key] = x, class: "input-border-none", disabled: Me(u, a), placeholder: "请选择", style: { width: "100%" } }, { default: c(() => [m(j, { value: true, label: "是" }), m(j, { value: false, label: "否" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "disabled"])) : s(C)(s(k).edit) && a.type !== "textarea" ? (r(), y(n, { key: 1, class: "input-border-none", modelValue: u[a.key], "onUpdate:modelValue": (x) => u[a.key] = x, modelModifiers: { trim: true }, maxlength: "200", placeholder: `请输入${a.title || "内容"}` }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : s(C)(s(k).edit) && a.type === "textarea" ? (r(), y(n, { key: 2, class: "input-border-none", modelValue: u[a.key], "onUpdate:modelValue": (x) => u[a.key] = x, modelModifiers: { trim: true }, autosize: "", maxlength: "1000", placeholder: `请输入${a.title || "内容"}`, type: "textarea" }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])) : (r(), b("span", ft, D(Ne(u[a.key], a.type)), 1))]), _: 2 }, 1032, ["min-width"]))), 128)), s(C)(s(k).edit) ? (r(), y(ne, { key: 0, align: "center", label: "操作", width: "110" }, { default: c(({ $index: a }) => [V("div", mt, [m(h, { class: "op-plus", icon: "el-icon-plus", size: "mini", type: "success", onClick: (u) => ge(a) }, null, 8, ["onClick"]), m(h, { class: "op-delete", icon: "el-icon-delete", size: "mini", type: "danger", disabled: ee(d.value[a]), onClick: (u) => _e(a) }, null, 8, ["disabled", "onClick"])])]), _: 1 })) : E("", true)]), _: 1 }, 8, ["data", "max-height"])), [[ae, S.value]])]), _: 1 }, 8, ["style"])]), _: 1 })]), _: 1 }, 8, ["style"])]);
  };
} }, ht = Ze(pt, [["__scopeId", "data-v-a5536fcc"]]);
export {
  ht as default
};
