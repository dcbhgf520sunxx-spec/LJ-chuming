import { ref as y } from "vue";
import { reactive as C } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as N } from "vue";
import { createBlock as R } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as z } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as f } from "vue";
import { unref as _ } from "vue";
import { isRef as E } from "vue";
import { ElNotification as Q } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElForm as F } from "element-plus";
import { k as S } from "../../../../../modules/box-3fab54f9.js";
import { u as U } from "../../../../../shared/runtime.js";
const M = { __name: "del-form", props: { visible: { type: Boolean, default: false }, itemInfo: { type: Object, default: () => {
} } }, emits: ["update:visible", "del-success"], setup(i, { emit: g }) {
  const c = g, s = i, { visible: u, handleClose: p } = U({ emit: c, props: s, field: "visible", showHook: q }), v = { quantity: [{ required: true, message: "请填写删除数量", trigger: "blur" }] }, V = y(), m = y(false), l = C({ quantity: null });
  function q() {
    l.quantity = s.itemInfo.schedulingQuantity;
  }
  async function x() {
    try {
      m.value = true, await S([{ id: s.itemInfo.id, quantity: l.quantity }]), Q({ title: "删除任务成功", type: "success", duration: 2500 }), c("del-success"), p();
    } catch (b) {
      console.log("删除任务失败", b);
    } finally {
      m.value = false;
    }
  }
  return (b, e) => {
    const I = d("common-button"), n = j, w = d("common-input-number"), k = F, B = d("common-dialog");
    return N(), R(B, { title: "删除任务", modelValue: _(u), "onUpdate:modelValue": e[2] || (e[2] = (r) => E(u) ? u.value = r : null), width: "400px", "before-close": _(p) }, { titleRight: t(() => [o(I, { loading: m.value, type: "primary", size: "default", onClick: x }, { default: t(() => e[3] || (e[3] = [h("确 认")])), _: 1, __: [3] }, 8, ["loading"])]), default: t(() => [o(k, { ref_key: "formRef", ref: V, model: l, rules: v, size: "default", "label-width": "100px", onSubmit: e[1] || (e[1] = z(() => {
    }, ["prevent"])) }, { default: t(() => [o(n, { label: "编号" }, { default: t(() => [a("span", null, f(i.itemInfo.serialNumber), 1)]), _: 1 }), o(n, { label: "规格" }, { default: t(() => [a("span", null, f(l.specification), 1)]), _: 1 }), o(n, { label: "当前分配数量" }, { default: t(() => [a("span", null, f(i.itemInfo.schedulingQuantity), 1)]), _: 1 }), o(n, { label: "删除数量", prop: "quantity" }, { default: t(() => [o(w, { modelValue: l.quantity, "onUpdate:modelValue": e[0] || (e[0] = (r) => l.quantity = r), step: 1, min: 1, max: i.itemInfo.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "250px" } }, null, 8, ["modelValue", "max"])]), _: 1 }), o(n, null, { default: t(() => e[4] || (e[4] = [a("span", { class: "form-item-tip" }, "* 删除后，原数据退回到排产页面中。 ", -1)])), _: 1, __: [4] })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  M as default
};
