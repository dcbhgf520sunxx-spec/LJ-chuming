import { ref as _ } from "vue";
import { computed as D } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as T } from "vue";
import { createBlock as Q } from "vue";
import { withCtx as l } from "vue";
import { createVNode as e } from "vue";
import { unref as r } from "vue";
import { createTextVNode as E } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as u } from "vue";
import { withDirectives as I } from "vue";
import { isRef as M } from "vue";
import { ElNotification as j } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { ElDivider as F } from "element-plus";
import { vLoading as O } from "element-plus";
import { b as $, f as z } from "../../../../../modules/common-b3e76e54.js";
import { u as U, o as G, b as J, ba as L } from "../../../../../shared/runtime.js";
import { _ as B } from "../../../../../modules/index-3b2628f3.js";
import { _ as K } from "../../../../../modules/index-490fd9d7.js";
const te = { __name: "production-preview", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(h, { emit: C }) {
  const b = C, c = h, { visible: d, handleClose: g } = U({ emit: b, props: c, field: "visible", showHook: q }), { maxHeight: H } = G({ mainBox: ".schedule-change-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, d), m = _(false), f = _(false), v = _([]), p = D(() => c.list.filter((t) => t.dealQuantity));
  function V(t) {
    return L(t, { props: ["quantity", "canHandleQuantity", "dealQuantity"] });
  }
  function k(t) {
    return L(t, { props: ["reduceQuantity"] });
  }
  async function q() {
    try {
      f.value = true;
      const t = p.value.map((i) => {
        const o = {};
        return o.id = i.id, o.quantity = i.dealQuantity, o;
      }), { content: n } = await $({ productType: c.info.productType, abnormalId: c.info.id, reportList: t });
      v.value = n;
    } catch (t) {
      console.log("变更预览", t);
    } finally {
      f.value = false;
    }
  }
  async function P() {
    try {
      m.value = true;
      const t = p.value.map((n) => {
        const i = {};
        return i.id = n.id, i.quantity = n.dealQuantity, i;
      });
      await z({ productType: c.info.productType, abnormalId: c.info.id, voList: t }), j({ title: "变更处理成功", type: "success", duration: 2500 }), g(), b("success");
    } catch (t) {
      console.log("变更处理失败", t);
    } finally {
      m.value = false;
    }
  }
  return (t, n) => {
    const i = w("common-button"), o = A, x = w("common-table"), N = F, R = w("common-dialog"), S = O;
    return T(), Q(R, { title: "生产变更预览", "custom-class": "schedule-change-preview", modelValue: r(d), "onUpdate:modelValue": n[0] || (n[0] = (a) => M(d) ? d.value = a : null), closeOnClickModal: false, width: "1100px", "before-close": r(g) }, { titleRight: l(() => [e(i, { loading: m.value, disabled: r(J)(p.value), type: "primary", size: "default", onClick: P }, { default: l(() => n[1] || (n[1] = [E(" 确认提交 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: l(() => [e(x, { ref: "tableRef", "summary-method": V, "show-summary": "", data: p.value, "max-height": r(H), style: { width: "100%" } }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(r(B), { showProductionLine: "", showFactory: "", showProcess: "" }), e(o, { prop: "reportTypeText", "show-overflow-tooltip": true, label: "上报类型", align: "center" }, { default: l(({ row: a }) => [s("span", null, u(a.reportTypeText), 1)]), _: 1 }), e(o, { prop: "completeTime", "show-overflow-tooltip": true, label: "上报时间", align: "center", width: "160" }, { default: l(({ row: a }) => [s("span", null, u(a.completeTime), 1)]), _: 1 }), e(o, { prop: "quantity", "show-overflow-tooltip": true, label: "生产数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, u(a.quantity), 1)]), _: 1 }), e(o, { prop: "canHandleQuantity", "show-overflow-tooltip": true, label: "可处理数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, u(a.canHandleQuantity), 1)]), _: 1 }), e(o, { prop: "dealQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: l(({ row: a }) => [s("span", null, u(a.dealQuantity), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]), e(N, null, { default: l(() => n[2] || (n[2] = [s("span", { class: "title" }, "排产变更", -1)])), _: 1, __: [2] }), I((T(), Q(x, { "summary-method": k, "show-summary": "", data: v.value, style: { width: "100%" } }, { default: l(() => {
      var a;
      return [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(r(B), { showProductionLine: "", showFactory: "" }), e(r(K), { productType: (a = h.info) == null ? void 0 : a.productType }, null, 8, ["productType"]), e(o, { prop: "schedulingQuantity", "show-overflow-tooltip": true, label: "排产数量", align: "center" }, { default: l(({ row: y }) => [s("span", null, u(y.schedulingQuantity), 1)]), _: 1 }), e(o, { prop: "reduceQuantity", "show-overflow-tooltip": true, label: "处理数量", align: "center" }, { default: l(({ row: y }) => [s("span", null, u(y.reduceQuantity), 1)]), _: 1 })];
    }), _: 1 }, 8, ["data"])), [[S, f.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
