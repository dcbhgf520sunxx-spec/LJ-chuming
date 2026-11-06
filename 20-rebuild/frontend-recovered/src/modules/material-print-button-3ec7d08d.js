import { b as x, z1 as C } from "../shared/runtime.js";
import { p as l } from "./wms-material-label-cf4447ff.js";
import { _ as P } from "./popover-confirm-35927771.js";
import { ref as B } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as p } from "vue";
import { createBlock as d } from "vue";
import { withCtx as f } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as _ } from "vue";
import { mergeProps as y } from "vue";
const T = { class: "flex-rsc" }, L = { __name: "material-print-button", props: { material: { type: Object }, number: { type: Number }, copies: { type: Number, default: 1 }, submitPrintRecord: { type: Boolean, default: false } }, emits: ["printed-success"], setup(w, { emit: v }) {
  const s = v, e = w, o = B(1);
  async function m() {
    if (x(e.material)) throw Error("物料信息不存在");
    const n = (/* @__PURE__ */ new Date()).getTime();
    if (e.number ? await l({ material: e.material, copies: e.number * e.copies }) : (await l({ material: e.material, copies: o.value * e.copies }), o.value = 1), e.submitPrintRecord) {
      const t = (/* @__PURE__ */ new Date()).getTime();
      await N({ material: e.material, number: e.number || o.value, copies: e.copies, startTime: n, endTime: t });
    } else s("printed-success");
  }
  async function N({ material: n, number: t, copies: i, startTime: r, endTime: a }) {
    const c = n.id;
    if (!(!c || !t)) try {
      await C({ receiptMaterialId: c, number: t, copies: i, startTime: r, endTime: a }), s("printed-success"), setTimeout(() => {
        n.printedNumber && (n.printedNumber += t);
      }, 0);
    } catch (k) {
      console.log("添加打印记录失败", k);
    }
  }
  function g() {
    o.value = 1;
  }
  return (n, t) => {
    const i = u("common-input-number"), r = u("common-button");
    return e.number ? (p(), d(r, y({ key: 1 }, n.$attrs, { icon: "el-icon-printer", type: "success", size: "default", onClick: m }), null, 16)) : (p(), d(P, { key: 0, "confirm-button-text": "打印", onConfirm: m, onCancel: g }, { default: f(() => [b("div", T, [t[1] || (t[1] = b("span", { style: { flex: "none", "font-weight": "bold" } }, "打印份数：", -1)), _(i, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => o.value = a), modelModifiers: { number: true }, min: 1, max: 999, size: "default", style: { width: "120px" } }, null, 8, ["modelValue"])])]), reference: f(() => [_(r, y(n.$attrs, { icon: "el-icon-printer", type: "success", size: "default" }), null, 16)]), _: 1 }));
  };
} };
export {
  L as _
};
