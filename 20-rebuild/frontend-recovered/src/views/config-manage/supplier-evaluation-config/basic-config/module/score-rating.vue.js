import { ref as v } from "vue";
import { onMounted as $ } from "vue";
import { computed as g } from "vue";
import { resolveComponent as K } from "vue";
import { unref as i } from "vue";
import { openBlock as t } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as f } from "vue";
import { createElementBlock as b } from "vue";
import { Fragment as Q } from "vue";
import { createVNode as m } from "vue";
import { createTextVNode as E } from "vue";
import { createCommentVNode as x } from "vue";
import { withDirectives as W } from "vue";
import { toDisplayString as R } from "vue";
import { ElMessage as D } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElInputNumber as Y } from "element-plus";
import { ElInput as Z } from "element-plus";
import { ElTable as ee } from "element-plus";
import { ElCard as ae } from "element-plus";
import { vLoading as le } from "element-plus";
import { _ as ne, G as h, fT as N } from "../../../../../shared/runtime.js";
import { a as ue, b as te } from "../../../../../modules/supplier-evaluation-config-2fb6916b.js";
const se = { class: "card-header" }, oe = { key: 0, class: "score-range-cell" }, ie = { key: 1 }, re = { key: 1 }, me = { class: "table-op" }, ce = { __name: "score-rating", props: { tableMaxHeight: { type: Number, default: void 0 } }, setup(M) {
  const p = v(false), V = v(false), o = v(false), l = v([]), _ = v([]);
  $(() => {
    z();
  });
  const w = g(() => l.value.map((e) => ({ id: e.id ?? null, minValue: Number(e.minValue || 0), maxValue: Number(e.maxValue || 0), name: e.name || "" }))), U = g(() => _.value.map((e) => ({ id: e.id ?? null, minValue: Number(e.minValue || 0), maxValue: Number(e.maxValue || 0), name: e.name || "" }))), S = g(() => JSON.stringify(w.value) !== JSON.stringify(U.value)), B = g(() => p.value || V.value || !o.value || !S.value);
  async function z() {
    p.value = true;
    try {
      const e = await ue();
      l.value = F(e), _.value = k(l.value);
    } catch (e) {
      console.log("供应商评价配置-分数评级列表", e);
    } finally {
      p.value = false;
    }
  }
  function I() {
    o.value = true, l.value = k(_.value), c();
  }
  function J() {
    o.value = false, l.value = k(_.value);
  }
  function O(e) {
    const a = l.value[e], n = Number((a == null ? void 0 : a.maxValue) || 0) + 1;
    l.value.splice(e + 1, 0, { id: void 0, minValue: n, maxValue: n, name: "" }), c();
  }
  function P(e) {
    l.value.splice(e, 1), l.value.length || l.value.push({ id: void 0, minValue: 0, maxValue: 0, name: "" }), c();
  }
  function c() {
    if (l.value.length) {
      l.value[0].minValue = Number(l.value[0].minValue || 0), l.value[0].maxValue = Number(l.value[0].maxValue || l.value[0].minValue), l.value[0].maxValue < l.value[0].minValue && (l.value[0].maxValue = l.value[0].minValue);
      for (let e = 1; e < l.value.length; e++) {
        const a = l.value[e - 1], n = l.value[e];
        n.minValue = Number(a.maxValue || 0) + 1, n.maxValue = Number(n.maxValue || n.minValue), n.maxValue < n.minValue && (n.maxValue = n.minValue);
      }
    }
  }
  async function T() {
    if (!S.value) return;
    if (c(), l.value.some((a) => !a.name)) {
      D.error("请填写完整的评级名称");
      return;
    }
    V.value = true;
    try {
      await te(l.value.map((a) => ({ id: a.id, minValue: Number(a.minValue || 0), maxValue: Number(a.maxValue || 0), name: a.name }))), D.success("分数评级保存成功"), o.value = false, await z();
    } catch (a) {
      console.log("供应商评价配置-分数评级保存", a);
    } finally {
      V.value = false;
    }
  }
  function F(e) {
    const a = G(e);
    return a.length ? a.map((n) => ({ id: n.id, minValue: Number(n.minValue || 0), maxValue: Number(n.maxValue || 0), name: n.name || "" })) : [{ id: void 0, minValue: 0, maxValue: 0, name: "" }];
  }
  function G(e) {
    var a;
    return Array.isArray(e) ? e : Array.isArray(e == null ? void 0 : e.content) ? e.content : Array.isArray((a = e == null ? void 0 : e.data) == null ? void 0 : a.content) ? e.data.content : Array.isArray(e == null ? void 0 : e.records) ? e.records : Array.isArray(e == null ? void 0 : e.list) ? e.list : Array.isArray(e == null ? void 0 : e.data) ? e.data : [];
  }
  function k(e) {
    return JSON.parse(JSON.stringify(e));
  }
  return (e, a) => {
    const n = K("common-button"), y = X, C = Y, H = Z, L = ee, j = ae, q = le;
    return i(h)(i(N).scoreRatingGet) ? (t(), r(j, { key: 0, shadow: "always" }, { header: s(() => [f("div", se, [a[3] || (a[3] = f("span", { class: "card-title" }, "分数评级", -1)), f("div", null, [o.value ? (t(), b(Q, { key: 0 }, [m(n, { class: "mr8", size: "default", type: "info", onClick: J }, { default: s(() => a[0] || (a[0] = [E("取消")])), _: 1, __: [0] }), i(h)(i(N).scoreRatingEdit) ? (t(), r(n, { key: 0, disabled: B.value, loading: V.value, size: "default", type: "success", onClick: T }, { default: s(() => a[1] || (a[1] = [E(" 保存 ")])), _: 1, __: [1] }, 8, ["disabled", "loading"])) : x("", true)], 64)) : i(h)(i(N).scoreRatingEdit) ? (t(), r(n, { key: 1, size: "default", type: "primary", onClick: I }, { default: s(() => a[2] || (a[2] = [E(" 编辑 ")])), _: 1, __: [2] })) : x("", true)])])]), default: s(() => [W((t(), r(L, { data: l.value, "max-height": M.tableMaxHeight, border: "", style: { width: "100%" } }, { default: s(() => [m(y, { align: "center", label: "序号", type: "index", width: "60" }), m(y, { align: "center", label: "分数范围", "min-width": "280" }, { default: s(({ row: u, $index: d }) => [o.value ? (t(), b("div", oe, [d === 0 ? (t(), r(C, { key: 0, modelValue: u.minValue, "onUpdate:modelValue": (A) => u.minValue = A, controls: false, min: 0, class: "score-input", onChange: c }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), r(C, { key: 1, "model-value": u.minValue, controls: false, class: "score-input", disabled: "" }, null, 8, ["model-value"])), a[4] || (a[4] = f("span", { class: "score-separator" }, "~", -1)), m(C, { modelValue: u.maxValue, "onUpdate:modelValue": (A) => u.maxValue = A, controls: false, min: Number(u.minValue || 0), class: "score-input", onChange: c }, null, 8, ["modelValue", "onUpdate:modelValue", "min"])])) : (t(), b("span", ie, R(Number(u.minValue || 0)) + "~" + R(Number(u.maxValue || 0)), 1))]), _: 1 }), m(y, { align: "center", label: "评级", "min-width": "220" }, { default: s(({ row: u }) => [o.value ? (t(), r(H, { key: 0, modelValue: u.name, "onUpdate:modelValue": (d) => u.name = d, modelModifiers: { trim: true }, maxlength: "50", placeholder: "请输入评级" }, null, 8, ["modelValue", "onUpdate:modelValue"])) : (t(), b("span", re, R(u.name), 1))]), _: 1 }), o.value && i(h)(i(N).scoreRatingEdit) ? (t(), r(y, { key: 0, align: "center", label: "操作", width: "110" }, { default: s(({ $index: u }) => [f("div", me, [m(n, { class: "op-plus", icon: "el-icon-plus", size: "mini", type: "success", onClick: (d) => O(u) }, null, 8, ["onClick"]), m(n, { class: "op-delete", icon: "el-icon-delete", size: "mini", type: "danger", onClick: (d) => P(u) }, null, 8, ["onClick"])])]), _: 1 })) : x("", true)]), _: 1 }, 8, ["data", "max-height"])), [[q, p.value]])]), _: 1 })) : x("", true);
  };
} }, pe = ne(ce, [["__scopeId", "data-v-5dc75bd5"]]);
export {
  pe as default
};
