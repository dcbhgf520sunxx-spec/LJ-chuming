import { ref as p } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as y } from "vue";
import { withCtx as o } from "vue";
import { createVNode as v } from "vue";
import { createTextVNode as r } from "vue";
import { unref as m } from "vue";
import { createElementVNode as V } from "vue";
import { createElementBlock as N } from "vue";
import { Fragment as T } from "vue";
import { renderList as D } from "vue";
import { toDisplayString as E } from "vue";
import { isRef as I } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElNotification as S } from "element-plus";
import { ElTag as R } from "element-plus";
import { c as j } from "../../../../../../../modules/machine-10301ee2.js";
import { _ as z, u as F } from "../../../../../../../shared/runtime.js";
import { a as M } from "../../../../../../../modules/project-data-5e9d497a.js";
const q = { class: "flex-rss" }, H = { __name: "index", props: { visible: { type: Boolean, required: true }, detailData: { type: Object }, selectLineId: { type: String, default: "" }, isSingle: { type: Boolean, default: false } }, emits: ["change"], setup(s, { emit: h }) {
  const d = s, u = p([]), n = p(), l = h, { visible: c, handleClose: f } = F({ emit: l, props: d, field: "visible", showHook: k });
  function k() {
    x();
  }
  async function x() {
    const { content: e } = await M();
    u.value = e;
  }
  function b(e) {
    n.value = e, l("change", e);
  }
  async function C() {
    try {
      await L.confirm("是否由 '" + n.value.machineName + "' 协同？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const e = [d.detailData.id], t = await j({ mac: n.value.mac }, e);
      S({ title: "更改状态成功", message: t, type: "success" }), l("endEvent");
    } catch (e) {
      console.log(e);
    }
  }
  return (e, t) => {
    const _ = g("common-button"), w = R, B = g("common-dialog");
    return i(), y(B, { title: "机器转产", width: "50%", "show-close": false, "close-on-click-modal": false, modelValue: m(c), "onUpdate:modelValue": t[0] || (t[0] = (a) => I(c) ? c.value = a : null), "before-close": m(f) }, { titleRight: o(() => [v(_, { type: "primary", size: "default", onClick: C }, { default: o(() => t[1] || (t[1] = [r("完 成")])), _: 1, __: [1] }), v(_, { size: "default", onClick: m(f) }, { default: o(() => t[2] || (t[2] = [r("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])]), default: o(() => [V("div", q, [(i(true), N(T, null, D(u.value, (a) => (i(), y(w, { effect: s.selectLineId === a.mac ? "light" : "plain", type: s.selectLineId === a.mac ? "success" : "info", class: "elTag", hit: "", onClick: (O) => b(a), key: a.id }, { default: o(() => [r(E(a.machineName), 1)]), _: 2 }, 1032, ["effect", "type", "onClick"]))), 128))])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, J = z(H, [["__scopeId", "data-v-225fc606"]]);
export {
  J as default
};
