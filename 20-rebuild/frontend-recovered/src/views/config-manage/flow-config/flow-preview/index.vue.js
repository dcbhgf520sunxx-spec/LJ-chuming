import { g as z } from "../../../../modules/flow-config-2bf9a9d0.js";
import { _ as H, o as I, p as R } from "../../../../shared/runtime.js";
import { ref as d } from "vue";
import { computed as A } from "vue";
import { watch as K } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as a } from "vue";
import { createElementVNode as s } from "vue";
import { normalizeStyle as q } from "vue";
import { unref as D } from "vue";
import { createVNode as G } from "vue";
import { withCtx as J } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as c } from "vue";
const Q = { class: "flow-preview" }, U = { key: 0 }, W = { class: "tree-org-node__text node-label" }, X = { key: 0, class: "top-no-config" }, Y = { key: 1, class: "top-no-config" }, Z = { key: 2, class: "top-no-config" }, ee = { key: 3, class: "top-no-config" }, oe = { key: 4, class: "no-config" }, te = { key: 5, class: "no-config" }, ne = { key: 6, class: "no-config" }, ie = { key: 7, class: "no-config" }, ae = { style: { position: "absolute", bottom: "6px", color: "#ccc" } }, le = { style: { "margin-left": "8px" } }, se = { key: 1, class: "red-tip" }, ce = { __name: "index", props: { line: { type: Object, default: () => {
} } }, emits: ["delChange", "tree-change"], setup(k, { expose: x, emit: w }) {
  const p = w, O = d(), v = d({}), l = d({}), u = d([]), N = d(false), b = d(false);
  function E({ node: t, command: o }) {
    console.log(t, o);
  }
  function T(t, o) {
    console.log(t, o);
  }
  function P(t) {
    console.log(t);
  }
  function S(t, o) {
    return new Promise((n, e) => {
      o || e(), t.id === o.id ? e() : n();
    });
  }
  function F(t, o) {
    console.log(t, o);
  }
  function L() {
    console.log("onNodeDblclick");
  }
  async function B(t, o) {
    console.log(o, "data"), u.value = [], u.value.push(o.id), p("delChange", o);
  }
  const M = { get: ["systemDictDetail:get"], add: ["systemDictDetail:add"], edit: ["systemDictDetail:edit"], del: ["systemDictDetail:del"] }, { maxHeight: V } = I({ wrapperBox: ".flow-preview" }), f = k, _ = A(() => f.line && f.line.id);
  K(() => _.value, async (t) => {
    t && (await m(), p("tree-change", l.value));
  }, { deep: true, immediate: true });
  async function m() {
    var t, o, n, e, y, h, C;
    try {
      const r = await z({ id: (t = f.line) == null ? void 0 : t.id });
      l.value = r || {}, v.value = (r == null ? void 0 : r.sysPushFlowConfigLinkDTOS) || {}, l.value.sysPushFlowConfigLinkDTOS.idx = 1, (o = l.value) != null && o.sysPushFlowConfigLinkDTOS && ((y = (e = (n = l.value) == null ? void 0 : n.sysPushFlowConfigLinkDTOS) == null ? void 0 : e.children) != null && y.length) && $((C = (h = l.value) == null ? void 0 : h.sysPushFlowConfigLinkDTOS) == null ? void 0 : C.children);
    } catch (r) {
      console.log(r, "获取详情失败");
    }
  }
  function $(t, o = 1) {
    t.forEach((n, e) => {
      n.idx = o + "." + (e + 1), n.children && n.children.length && $(n.children, n.idx);
    });
  }
  return x({ permission: M, fetchDetail: m }), (t, o) => {
    const n = j("vue3-tree-org");
    return i(), a("div", Q, [_.value ? (i(), a("div", U, [s("div", null, [o[0] || (o[0] = s("div", { style: { display: "flex", padding: "10px" } }, null, -1)), s("div", { style: q(`height: ${D(V) - 100}px;position: relative`) }, [G(n, { style: { "padding-top": "20px" }, data: v.value, center: "", ref_key: "treeOrgRef", ref: O, props: { label: "notificationTypeName", children: "children", expand: "expand" }, horizontal: false, collapsable: false, "define-menus": [{ name: "复制文本", command: "copy" }], "only-one-node": b.value, "clone-node-drag": N.value, "before-drag-end": S, "selected-key": u.value, "selected-class-name": t.selectedClassName, onOnNodeDrag: P, onOnNodeDragEnd: F, onOnContextmenu: E, onOnExpand: T, onOnNodeDblclick: L, onOnNodeClick: B }, { default: J(({ node: e }) => [s("div", W, [s("div", null, g(e.label), 1), e.$$level === 0 && !e.$$data.arrivalConfiguration && e.$$data.completionConfiguration ? (i(), a("div", X, " 未配置业务到达通知 ")) : c("", true), e.$$level === 0 && !e.$$data.completionConfiguration && e.$$data.arrivalConfiguration ? (i(), a("div", Y, " 未配置业务完成通知 ")) : c("", true), e.$$level === 0 && !e.$$data.arrivalConfiguration && !e.$$data.completionConfiguration ? (i(), a("div", Z, " 未配置业务到达、完成通知 ")) : c("", true), e.$$level === 0 && e.$$data.arrivalConfiguration && e.$$data.completionConfiguration ? (i(), a("div", ee)) : c("", true), e.$$level !== 0 && !e.$$data.arrivalConfiguration && e.$$data.completionConfiguration ? (i(), a("div", oe, " 未配置业务到达通知 ")) : c("", true), e.$$level !== 0 && !e.$$data.completionConfiguration && e.$$data.arrivalConfiguration ? (i(), a("div", te, " 未配置业务完成通知 ")) : c("", true), e.$$level !== 0 && !e.$$data.arrivalConfiguration && !e.$$data.completionConfiguration ? (i(), a("div", ne, " 未配置业务到达、完成通知 ")) : c("", true), e.$$level !== 0 && e.$$data.arrivalConfiguration && e.$$data.completionConfiguration ? (i(), a("div", ie)) : c("", true)])]), _: 1 }, 8, ["data", "only-one-node", "clone-node-drag", "selected-key", "selected-class-name"]), s("div", ae, [s("span", null, g(l.value.finalEditor), 1), s("span", le, g(D(R)(l.value.finalEditTime, "{y}-{m}-{d}")), 1)])], 4)])])) : (i(), a("div", se, "暂无数据"))]);
  };
} }, fe = H(ce, [["__scopeId", "data-v-d995d638"]]);
export {
  fe as default
};
