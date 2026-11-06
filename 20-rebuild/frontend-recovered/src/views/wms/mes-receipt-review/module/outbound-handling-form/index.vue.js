import { _ as B, cJ as d, u as k, jY as S, o as j } from "../../../../../shared/runtime.js";
import L from "./module/steel-plate.vue.js";
import f from "./module/section-steel.vue.js";
import { computed as p } from "vue";
import { ref as b } from "vue";
import { provide as _ } from "vue";
import { watch as M } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as v } from "vue";
import { createBlock as h } from "vue";
import { withCtx as i } from "vue";
import { createVNode as N } from "vue";
import { createTextVNode as I } from "vue";
import { resolveDynamicComponent as W } from "vue";
import { unref as u } from "vue";
import { isRef as D } from "vue";
import { ElMessage as P } from "element-plus";
import "./components/common-form-item.vue.js";
import "./components/produce-form.vue.js";
import "./components/common-material-info.vue.js";
const q = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, emits: ["success", "update:visible", "update:modelValue"], setup(r, { emit: x }) {
  const c = x, s = r, y = p(() => {
    switch (s.basicClass) {
      case d.STEEL_PLATE.V:
        return L;
      case d.SECTION_STEEL.V:
        return f;
      default:
        return f;
    }
  }), o = b(), n = b(false), { visible: a, handleClose: m } = k({ emit: c, props: s }), { outboundCfg: w, selfOutboundTypeOptions: C } = S();
  _("outboundCfg", w), _("selfOutboundTypeOptions", C);
  const V = p(() => {
    var e;
    return (e = o.value) == null ? void 0 : e.enlargeWth;
  }), { maxHeight: R } = j({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, V);
  function l() {
    o.value && o.value.resetForm();
  }
  async function E() {
    var e;
    if (!(((e = o.value) == null ? void 0 : e.form.outboundQuantity) > 0)) {
      P.error("出库数量必须大于0");
      return;
    }
    try {
      n.value = true;
      if (!await o.value.commonSubmit()) return;
      c("success", o.value.submitData), m(), l();
    } catch (t) {
      console.log("出库办理", t);
    } finally {
      n.value = false;
    }
  }
  function F() {
    l(), m();
  }
  return M(() => a.value, (e) => {
    e && l();
  }), (e, t) => {
    const H = g("common-button"), O = g("common-dialog");
    return v(), h(O, { modelValue: u(a), "onUpdate:modelValue": t[0] || (t[0] = (T) => D(a) ? a.value = T : null), "before-close": F, "close-on-click-modal": false, "show-close": true, top: "3vh", width: "600px", "custom-class": "wms-outbound-handling", title: "出库办理" }, { titleRight: i(() => [N(H, { loading: n.value, size: "default", type: "success", onClick: E }, { default: i(() => t[1] || (t[1] = [I("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: i(() => [(v(), h(W(y.value), { ref_key: "outboundFormRef", ref: o, "basic-class": s.basicClass, material: s.material, "max-height": u(R), currentRow: r.currentRow, visible: u(a) }, null, 8, ["basic-class", "material", "max-height", "currentRow", "visible"]))]), _: 1 }, 8, ["modelValue"]);
  };
} }, K = B(q, [["__scopeId", "data-v-55b6d91f"]]);
export {
  K as default
};
