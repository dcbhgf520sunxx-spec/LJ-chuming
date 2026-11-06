import { ref as i } from "vue";
import { watch as g } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as b } from "vue";
import { createBlock as w } from "vue";
import { withCtx as x } from "vue";
import { createVNode as u } from "vue";
import { unref as n } from "vue";
import { isRef as V } from "vue";
import { ElMessage as k } from "element-plus";
import { ElDialog as h } from "element-plus";
import { _ as C, u as D, mn as B } from "../../../../../shared/runtime.js";
import N from "./simple-jpg.vue.js";
const j = { __name: "index", props: { action: { type: String, default: "create", validator: function(s) {
  return ["create", "override"].indexOf(s) !== -1;
} }, modelValue: { type: Boolean, require: true }, current: { type: Object, default: () => {
} } }, emits: ["toQuery", "success"], setup(s, { emit: d }) {
  const m = i(), t = s, r = d, { visible: a, handleClose: c } = D({ emit: r, props: t }), l = i(true);
  g(() => t.modelValue, (o) => {
    o ? l.value = true : l.value = false;
  }, { deep: true, immediate: true });
  async function p(o) {
    try {
      const e = { fileName: `${t.current.serialNumber}.jpg`, img: o, id: t.current.id };
      await B(e), k({ message: "保存成功", type: "success" }), c();
    } catch (e) {
      console.log("图纸变更", e);
    } finally {
      r("toQuery");
    }
  }
  return (o, e) => {
    const _ = v("common-button"), f = h;
    return b(), w(f, { "append-to-body": "", "close-on-click-modal": false, modelValue: n(a), "onUpdate:modelValue": e[0] || (e[0] = (y) => V(a) ? a.value = y : null), width: "80%", fullscreen: "", "show-close": false, class: "dialog-class" }, { default: x(() => [u(_, { type: "danger", icon: "el-icon-close", circle: "", class: "btn-close", onClick: n(c) }, null, 8, ["onClick"]), u(n(N), { ref_key: "draw", ref: m, onDownload: p, reset: l.value }, null, 8, ["reset"])]), _: 1 }, 8, ["modelValue"]);
  };
} }, R = C(j, [["__scopeId", "data-v-efa02b5f"]]);
export {
  R as default
};
