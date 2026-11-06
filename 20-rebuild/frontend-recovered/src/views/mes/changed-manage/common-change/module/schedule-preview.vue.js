import { ref as _ } from "vue";
import { computed as D } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as x } from "vue";
import { createBlock as k } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { unref as u } from "vue";
import { createTextVNode as E } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as r } from "vue";
import { withDirectives as I } from "vue";
import { isRef as M } from "vue";
import { ElNotification as j } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElDivider as F } from "element-plus";
import { vLoading as O } from "element-plus";
import { b as $, g as z } from "../../../../../modules/common-b3e76e54.js";
import { u as U, o as G, b as J, ba as C } from "../../../../../shared/runtime.js";
import { _ as T } from "../../../../../modules/index-3b2628f3.js";
import { _ as K } from "../../../../../modules/index-490fd9d7.js";
const te = { __name: "schedule-preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(g, { emit: L }) {
  const w = L, d = g, { visible: c, handleClose: b } = U({ emit: w, props: d, field: "visible", showHook: V }), { maxHeight: B } = G({ mainBox: ".schedule-change-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, c), m = _(false), f = _(false), v = _([]), p = D(() => d.list.filter((t) => t.dealQuantity));
  function H(t) {
    return C(t, { props: ["taskQuantity", "inProductionQuantity", "canHandleQuantity", "dealQuantity"] });
  }
  function P(t) {
    return C(t, { props: ["reduceQuantity"] });
  }
  async function V() {
    try {
      f.value = true;
      const t = p.value.map((i) => {
        const o = {};
        return o.id = i.id, o.quantity = i.dealQuantity, o;
      }), { content: n } = await $({ productType: d.info.productType, abnormalId: d.info.id, taskList: t });
      v.value = n;
    } catch (t) {
      console.log("变更预览", t);
    } finally {
      f.value = false;
    }
  }
  async function N() {
    try {
      m.value = true;
      const t = p.value.map((n) => {
        const i = {};
        return i.id = n.id, i.quantity = n.dealQuantity, i;
      });
      await z({ productType: d.info.productType, abnormalId: d.info.id, taskChange: t }), j({ title: "变更处理成功", type: "success", duration: 2500 }), b(), w("success");
    } catch (t) {
      console.log("变更处理失败", t);
    } finally {
      m.value = false;
    }
  }
  return (t, n) => {
    const i = h("common-button"), o = A, Q = h("common-table"), R = F, S = h("common-dialog"), q = O;
    return x(), k(S, { title: "排产变更预览", "custom-class": "schedule-change-preview", modelValue: u(c), "onUpdate:modelValue": n[0] || (n[0] = (a) => M(c) ? c.value = a : null), closeOnClickModal: false, width: "1100px", "before-close": u(b) }, { titleRight: l(() => [e(i, { loading: m.value, disabled: u(J)(p.value), type: "primary", size: "default", onClick: N }, { default: l(() => n[1] || (n[1] = [E(" 确认提交 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: l(() => [e(Q, { ref: "tableRef", "summary-method": H, "show-summary": "", data: p.value, "max-height": u(B), style: { width: "100%" } }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "要求完成日期", align: "center" }, { default: l(({ row: a }) => [s("span", null, r(a.askCompleteTime), 1)]), _: 1 }), e(u(T), { showProductionLine: "", showFactory: "" }), e(o, { prop: "taskQuantity", "show-overflow-tooltip": true, label: "任务数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, r(a.taskQuantity), 1)]), _: 1 }), e(o, { prop: "inProductionQuantity", "show-overflow-tooltip": true, label: "已生产数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, r(a.inProductionQuantity), 1)]), _: 1 }), e(o, { prop: "canHandleQuantity", "show-overflow-tooltip": true, label: "可处理数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, r(a.canHandleQuantity), 1)]), _: 1 }), e(o, { prop: "dealQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, r(a.dealQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), e(R, null, { default: l(() => n[2] || (n[2] = [s("span", { class: "title" }, "排产变更", -1)])), _: 1, __: [2] }), I((x(), k(Q, { "summary-method": P, "show-summary": "", data: v.value, style: { width: "100%" } }, { default: l(() => {
      var a;
      return [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(u(T), { showProductionLine: "", showFactory: "" }), e(u(K), { productType: (a = g.info) == null ? void 0 : a.productType }, null, 8, ["productType"]), e(o, { prop: "schedulingQuantity", "show-overflow-tooltip": true, label: "排产数量", align: "center" }, { default: l(({ row: y }) => [s("span", null, r(y.schedulingQuantity), 1)]), _: 1 }), e(o, { prop: "reduceQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: l(({ row: y }) => [s("span", null, r(y.reduceQuantity), 1)]), _: 1 })];
    }), _: 1 }, 8, ["data"])), [[q, f.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
