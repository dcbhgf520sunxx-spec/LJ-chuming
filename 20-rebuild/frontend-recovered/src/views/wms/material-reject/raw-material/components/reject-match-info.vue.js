import { ref as f } from "vue";
import { computed as J } from "vue";
import { watch as K } from "vue";
import { ElMessage as z } from "element-plus";
import { resolveComponent as _ } from "vue";
import { resolveDirective as X } from "vue";
import { openBlock as U } from "vue";
import { createBlock as T } from "vue";
import { withCtx as b } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as i } from "vue";
import { withDirectives as p } from "vue";
import { createTextVNode as h } from "vue";
import { toDisplayString as M } from "vue";
import { unref as E } from "vue";
import { isRef as W } from "vue";
import { nextTick as Y } from "vue";
import { ElCheckbox as Z } from "element-plus";
import { ElDivider as w } from "element-plus";
import { ElTableColumn as ee } from "element-plus";
import { vLoading as ae } from "element-plus";
import { a as te } from "../../../../../modules/application-f2aa112e.js";
import { _ as se, yX as le, sP as ie, u as ne, o as re, cO as ce, jl as oe, cS as ue, jG as k, k5 as B, jH as me, k6 as Q, sO as de, i as fe, yb as be } from "../../../../../shared/runtime.js";
import { v as ve } from "../../../../../modules/vertical-label-c3028fe0.js";
const je = { class: "statistical-info" }, pe = { class: "color-green" }, he = { class: "current-material flex-rss" }, xe = { class: "match-list-table" }, ye = { class: "flex-rbc" }, ge = { style: { flex: "none", "margin-left": "10px" } }, Ne = { __name: "reject-match-info", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object, default: () => ({}) }, rejectInfo: { type: Object, default: () => ({}) } }, emits: ["change", "update:visible"], setup(l, { emit: O }) {
  le();
  const x = O, u = l, y = f({ hasRejectNumber: false }), R = f([...ie]), m = f(0), d = f(), g = f(false), n = f({}), { visible: j, handleClose: L } = ne({ emit: x, props: u, field: "visible" }), { maxHeight: I } = re({ mainBox: ".reject-match-list-drawer", extraBox: [".el-drawer__header", ".current-material", ".divider"], wrapperBox: [".el-drawer__body"], navbar: false, minHeight: 200, extraHeight: -20 }, j), P = J(() => (d.value.map((t) => {
    t.realTime = t.realTime || (/* @__PURE__ */ new Date()).getTime();
  }), y.value.hasRejectNumber ? d.value.filter((t) => t.rejectNumber > 0) : d.value));
  K([() => u.visible, () => u.material], ([t, e]) => {
    t && (D(), e && e.id && V(e.id));
  }, { immediate: true });
  function D() {
    n.value = u.rejectInfo, m.value = 0, Object.keys(n.value).forEach((t) => {
      m.value += n.value[t].rejectNumber;
    }), d.value = [];
  }
  async function V(t) {
    try {
      g.value = true;
      const { content: e = [] } = await te(t);
      await ce(e), await oe(e), d.value = e;
      let o = false;
      const r = {};
      d.value.forEach((a) => {
        a.operableQuantity = a.quantity - (a.frozenQuantity || 0), a.operableMete = a.mete - (a.frozenMete || 0), a.rejectUnitType === ue.MEASURE.V ? (a.corQuantity = a.quantity, a.corFrozenQuantity = a.frozenQuantity, a.corOperableQuantity = a.operableQuantity) : (a.corQuantity = a.mete, a.corFrozenQuantity = a.frozenMete, a.corOperableQuantity = a.operableMete), a.maxNumber = a.corOperableQuantity;
        const v = n.value[a.id];
        v && v.rejectNumber <= a.maxNumber && (r[a.id] = true, n.value[a.id] = a, a.rejectNumber = v.rejectNumber);
      }), m.value = 0, Object.keys(n.value).forEach((a) => {
        r[a] ? m.value += n.value[a].rejectNumber || 0 : (delete n.value[a], o = true);
      }), o && (x("change"), z.warning("清除了匹配列表中“可退货数量小于填写数量”的物料数量"));
    } catch (e) {
      console.error("加载匹配列表", e);
    } finally {
      g.value = false;
    }
  }
  function q(t, e, o) {
    Y(() => {
      const r = m.value + (e || 0) - (o || 0);
      if (r > u.material.rejectMaxNumber) {
        t.rejectNumber = o, z.warning("您填写的数量超过可退货数量，已为您取消本次操作");
        return;
      }
      m.value = r;
      const a = fe(e) && e > 0;
      n.value[t.id] && !a && delete n.value[t.id], !n.value[t.id] && a && (n.value[t.id] = t), x("change");
    });
  }
  function F() {
    V(u.material.id);
  }
  function H(t, e, o) {
    const r = u.material;
    e.freezeType === be.REJECTED.V && (r.rejectMaxNumber += t.quantity, r.rejectPendingNumber -= t.quantity);
  }
  return (t, e) => {
    const o = Z, r = _("common-table"), a = w, v = _("common-input-number"), S = ee, $ = _("common-drawer"), N = X("to-fixed"), A = ae;
    return U(), T($, { ref: "drawerRef", modelValue: E(j), "onUpdate:modelValue": e[1] || (e[1] = (c) => W(j) ? j.value = c : null), "before-close": E(L), "custom-class": "reject-match-list-drawer", direction: "btt", size: "80%", title: "退货匹配列表" }, { titleRight: b(() => [s("div", je, [s("span", null, [e[2] || (e[2] = s("span", { class: "label" }, "只显示填写退货数量的材料", -1)), i(o, { modelValue: y.value.hasRejectNumber, "onUpdate:modelValue": e[0] || (e[0] = (c) => y.value.hasRejectNumber = c), size: "default" }, null, 8, ["modelValue"])]), s("span", null, [e[3] || (e[3] = s("span", { class: "label" }, "本次退货统计", -1)), p(s("span", pe, null, 512), [[N, { val: m.value, dp: l.material.rejectUnitPrecision }]]), e[4] || (e[4] = h("   ")), e[5] || (e[5] = s("span", null, "/", -1)), e[6] || (e[6] = h("  ")), p(s("span", null, null, 512), [[N, { val: l.material.rejectMaxNumber, dp: l.material.rejectUnitPrecision }]]), e[7] || (e[7] = h("  ")), s("span", null, M(l.material.rejectUnit), 1)]), s("span", null, [e[8] || (e[8] = s("span", { class: "label" }, "审核中的数量", -1)), p(s("span", null, null, 512), [[N, { val: l.material.rejectPendingNumber, dp: l.material.rejectUnitPrecision }]]), e[9] || (e[9] = h("  ")), s("span", null, M(l.material.rejectUnit), 1)])])]), content: b(() => [s("div", he, [i(ve, { left: "5px", name: "当前物料" }), i(r, { data: [l.material], "data-format": R.value, "row-key": "id" }, { default: b(() => [i(k, { "basic-class": l.material.basicClass, "show-index": false }, null, 8, ["basic-class"]), i(B, { "basic-class": l.material.basicClass }, null, 8, ["basic-class"]), i(me, { "basic-class": l.material.basicClass }, null, 8, ["basic-class"]), i(Q, { "show-area": false, "show-monomer": false, "show-project": "" })]), _: 1 }, 8, ["data", "data-format"])]), i(a, { class: "divider" }, { default: b(() => e[10] || (e[10] = [s("span", { class: "title" }, "匹配物料", -1)])), _: 1, __: [10] }), s("div", xe, [p((U(), T(r, { data: P.value, "data-format": R.value, "max-height": E(I), "row-key": "id" }, { default: b(() => [i(k, { "basic-class": l.material.basicClass, "frozen-viewable": "", "show-frozen-tip": "", onRefresh: F, onUnfreezeSuccess: H }, null, 8, ["basic-class"]), i(B, { "basic-class": l.material.basicClass }, null, 8, ["basic-class"]), i(de, { "basic-class": l.material.basicClass, "reject-type-mode": "" }, null, 8, ["basic-class"]), i(Q, { "show-project": "", "show-monomer": false, "show-area": false }), i(S, { label: "退货数量", width: "170px", align: "center", fixed: "right" }, { default: b(({ row: { sourceRow: c } }) => [s("span", ye, [i(v, { modelValue: c.rejectNumber, "onUpdate:modelValue": (C) => c.rejectNumber = C, max: l.material.rejectMaxNumber > c.maxNumber ? c.maxNumber : l.material.rejectMaxNumber, min: 0, precision: c.rejectUnitPrecision, "controls-position": "right", onChange: (C, G) => q(c, C, G) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "precision", "onChange"]), s("span", ge, M(c.rejectUnit), 1)])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[A, g.value]])])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Re = se(Ne, [["__scopeId", "data-v-d113e20d"]]);
export {
  Re as default
};
